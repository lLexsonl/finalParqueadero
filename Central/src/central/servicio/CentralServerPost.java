package central.servicio;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import central.negocio.Cliente;
import central.negocio.ClientePost;
import central.negocio.ClienteVehiculo;
import central.negocio.ClienteVehiculoPost;
import central.negocio.GestorClientePostgresql;
import central.negocio.UsuarioPost;
import central.negocio.Vehiculo;
import central.negocio.Vigilante;
import com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CentralServerPost implements Runnable {

    private static ServerSocket ssock;
    private static Socket socket;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;

    private static GestorClientePostgresql gestor;
    private static final int PUERTO = 5000;

    /**
     * Constructor
     */
    public CentralServerPost() {
        gestor = new GestorClientePostgresql();
    }

    /**
     * Logica completa del servidor
     */
    public void iniciar() {
        abrirPuerto();

        while (true) {
            esperarAlCliente();
            lanzarHilo();
        }
    }

    /**
     * Lanza el hilo
     */
    private static void lanzarHilo() {
        new Thread(new CentralServerPost()).start();
    }

    private static void abrirPuerto() {
        try {
            ssock = new ServerSocket(PUERTO);
            System.out.println("Escuchando por el puerto " + PUERTO);
        } catch (IOException ex) {
            Logger.getLogger(CentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Espera que el cliente se conecta y le devuelve un socket
     */
    private static void esperarAlCliente() {
        try {
            socket = ssock.accept();
            System.out.println("Cliente conectado");
        } catch (IOException ex) {
            Logger.getLogger(CentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Cuerpo del hilo
     */
    @Override
    public void run() {
        try {
            crearFlujos();
            leerFlujos();
            cerrarFlujos();

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CentralServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Crea los flujos con el socket
     *
     * @throws IOException
     */
    private void crearFlujos() throws IOException {
        salidaDecorada = new PrintStream(socket.getOutputStream());
        entradaDecorada = new Scanner(socket.getInputStream());
    }

    /**
     * Lee los flujos del socket
     */
    private void leerFlujos() throws ClassNotFoundException, SQLException {
        if (entradaDecorada.hasNextLine()) {
            // Extrae el flujo que envía el cliente
            String peticion = entradaDecorada.nextLine();
            decodificarPeticion(peticion);

        } else {
            salidaDecorada.flush();
            salidaDecorada.println("NO_ENCONTRADO");
        }
    }

    /**
     * Decodifica la petición, extrayeno la acción y los parámetros
     *
     * @param peticion petición completa al estilo
     * "consultarCiudadano,983932814"
     */
    private void decodificarPeticion(String peticion) throws ClassNotFoundException, SQLException {
        StringTokenizer tokens = new StringTokenizer(peticion, ",");
        String parametros[] = new String[10];

        int i = 0;
        while (tokens.hasMoreTokens()) {
            parametros[i++] = tokens.nextToken();
        }
        String accion = parametros[0];
        procesarAccion(accion, parametros);

    }

    /**
     * Segun el protocolo decide qué accion invocar
     *
     * @param accion acción a procesar
     * @param parametros parámetros de la acción
     */
    private void procesarAccion(String accion, String parametros[]) throws ClassNotFoundException, SQLException {
        switch (accion) {
            //<editor-fold defaultstate="collapsed" desc="case de la base de datos HSQLDB">
            case "buscarCliente":
                String id = parametros[1];
                ClientePost cli = gestor.buscarClientePorId(id);
                if (cli == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(cli.toJson());
                }
                break;

            case "buscarVigilante":
                System.out.println("Estoy en consulta vigilante ");
                String idV = parametros[1];
                UsuarioPost usu = gestor.buscarVigilante(idV);
                if (usu == null) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    System.out.println("usu sale: " + usu.toJson());
                    salidaDecorada.println(usu.toJson());
                }
                break;
            case "insertarCliente":
                gestor.agregarCliente(parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], parametros[6]);
                break;
            case "buscarClienteVehiculo":
                String idcv = parametros[1];
                List<ClienteVehiculoPost> listcv = gestor.buscarVehiculosCliente(idcv);
                if (listcv.isEmpty()) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    String json = serializarVehiculosCliente(listcv);
                    System.out.println("json sale: " + json);
                    salidaDecorada.println(json);
                }
                break;
            case "insertarMulta":
                String placa,
                 desc,
                 fecha,
                 url;
                System.out.println("Llego multa central");

                placa = parametros[1];
                desc = parametros[2];
                url = parametros[3];
                fecha = parametros[4];

                System.out.println("Parametros: " + placa + " " + desc + " " + url + " " + fecha);

                gestor.agregarMulta(placa, desc, url, fecha);
                break;
//</editor-fold>
        }
    }

    /**
     * Cierra los flujos de entrada y salida
     *
     * @throws IOException
     */
    private void cerrarFlujos() throws IOException {
        salidaDecorada.close();
        entradaDecorada.close();
        socket.close();
    }

    /**
     * Convierte el objeto Ciudadano a json
     *
     * @param ciu Objeto ciudadano
     * @return cadena json
     */
    private String parseToJSON(Vehiculo vehi) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("idVehiculo", vehi.getIdvehiculo());
        jsonobj.addProperty("placa", vehi.getNodeplaca());
        jsonobj.addProperty("marca", vehi.getMarca());
        jsonobj.addProperty("tipo", vehi.getTipo());
        return jsonobj.toString();
    }

    private String serializarVehiculosCliente(List<ClienteVehiculoPost> listado) {
        JsonArray array = new JsonArray();
        JsonObject jsonobj;
        for (ClienteVehiculoPost cli : listado) {
            jsonobj = new JsonObject();
            jsonobj.addProperty("id_cli", cli.getId_cli());
            jsonobj.addProperty("nombre_cli", cli.getNombre_cli());
            jsonobj.addProperty("apellido_cli", cli.getApellido_cli());
            jsonobj.addProperty("rol_cli", cli.getRol_cli());
            jsonobj.addProperty("placa_vehi", cli.getPlaca_vehi());
            jsonobj.addProperty("marca_vehi", cli.getMarca_vehi());
            jsonobj.addProperty("tipo_vehi", cli.getTipo_vehi());
            array.add(jsonobj);
        }
        //System.out.println("Planes json serializado: " + array.toString());
        return array.toString();
    }

    private String parseToJSON(ClienteVehiculo clive) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("idCliente", clive.getIdCliente());
        jsonobj.addProperty("nombre", clive.getNombre());
        jsonobj.addProperty("apellido", clive.getApellido());
        jsonobj.addProperty("genero", clive.getGenero());
        jsonobj.addProperty("fechaNacimiento", clive.getFechaNacimiento());
        jsonobj.addProperty("idVehiculo", clive.getIdvehiculo());
        jsonobj.addProperty("placa", clive.getNodeplaca());
        jsonobj.addProperty("marca", clive.getMarca());
        jsonobj.addProperty("tipoVehiculo", clive.getTipo());
        return jsonobj.toString();
    }

    private String parseToJSON(Cliente cli) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("idCliente", cli.getIdCliente());
        jsonobj.addProperty("nombre", cli.getNombre());
        jsonobj.addProperty("apellido", cli.getApellido());
        jsonobj.addProperty("genero", cli.getGenero());
        jsonobj.addProperty("fechaNacimiento", cli.getFechaNacimiento());
        jsonobj.addProperty("rol", cli.getRol());
        return jsonobj.toString();
    }

    private String parseToJSON(Vigilante vig) {
        JsonObject jsonobj = new JsonObject();
        jsonobj.addProperty("numeroid", vig.getNumeroid());
        jsonobj.addProperty("codigo", vig.getCodigo());
        jsonobj.addProperty("nombres", vig.getNombre());
        jsonobj.addProperty("apellido", vig.getApellido());
        jsonobj.addProperty("genero", vig.getGenero());
        jsonobj.addProperty("fechadenacimiento", vig.getFechadenacimiento());
        jsonobj.addProperty("empresa", vig.getEmpresa());
        jsonobj.addProperty("claveacceso", vig.getClaveacceso());
        return jsonobj.toString();
    }
}
