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
import central.negocio.ClientePost;
import central.negocio.ClienteVehiculoPost;
import central.negocio.GestorClientePostgresql;
import central.negocio.Ingreso;
import central.negocio.Multa;
import central.negocio.UsuarioPost;
import central.negocio.VehiculoPost;
import com.google.gson.JsonArray;
import java.util.List;

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
            salidaDecorada.println(String.format("HA OCURRIDO UN ERROR: %S", ex.getMessage()));
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
        System.out.println("Accion: " + accion);
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
                    salidaDecorada.println(usu.toJson());
                }
                break;
            case "insertarCliente":
                gestor.agregarCliente(parametros[1], parametros[2], parametros[3], parametros[4], parametros[5], parametros[6]);
                salidaDecorada.println("OK");
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
                String idm,
                 placa,
                 desc,
                 fecha,
                 url;
                System.out.println("Llego multa central");
                
                idm = parametros[1];
                placa = parametros[2];
                desc = parametros[3];
                url = parametros[4];
                fecha = parametros[5];

                System.out.println("Parametros: " + placa + " " + desc + " " + url + " " + fecha);

                gestor.agregarMulta(idm, placa, desc, url, fecha);
                salidaDecorada.println("OK");
                break;
            case "insertarIngreso":
                System.out.println("Estoy en insertar ingreso central");
                String placaing, iding, puestoing, fingresoing;
                System.out.println("Estoy en Ingreso central");
                
                placaing = parametros[1];
                puestoing = parametros[3];
                iding = parametros[2];
                fingresoing = parametros[4];
                
                gestor.agregarIngreso(placaing, iding, puestoing, fingresoing);
                salidaDecorada.println("OK");
                break;
            case "buscarIngresos":
                List<Ingreso> listIngresos = gestor.buscarIngresos();
                
                if (listIngresos.isEmpty()) {
                    salidaDecorada.println("NO_ENCONTRADO");
                }
                else {
                    String json = serializarIngresos(listIngresos);
                    salidaDecorada.println(json);
                }
                break;
                
            case "editarSalida":
                gestor.editarSalida(parametros[1], parametros[2], parametros[3], parametros[4], parametros[5]);
                break;
                
            case "ingresarVehiculo":
                gestor.insertarVehiculo(parametros[1], parametros[2], parametros[3], parametros[4]);
                salidaDecorada.println("OK");
                break;
            case "buscarVehiculo":
                VehiculoPost vehi = gestor.buscarVehiculo(parametros[1]);
                if(vehi != null) {
                    salidaDecorada.println(vehi.toJson());
                } else {
                    salidaDecorada.println("NO_ENCONTRADO");
                }
                break;
            case "inserarClienteVehiculo":
                gestor.insertarClienteVehiculo(parametros[1], parametros[2]);
                salidaDecorada.println("OK");
                break;
            case "buscarMultas":
                System.out.println("Estoy en buscar multas central");
                List<Multa> listMulta = gestor.buscarMultas(parametros[1]);
                if(listMulta.isEmpty()) {
                    salidaDecorada.println("NO_ENCONTRADO");
                } else {
                    salidaDecorada.println(serializarMultas(listMulta));
                }
                break;
            case "insertarUsuario":
                gestor.insertarUsuario(parametros[1], parametros[2], parametros[3]);
                salidaDecorada.println("OK");
                break;
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
    
    private String serializarIngresos(List<Ingreso> listado) {
        JsonArray array = new JsonArray();
        JsonObject jsonobj;
        for (Ingreso ing : listado) {
            jsonobj = new JsonObject();
            jsonobj.addProperty("placa", ing.getPlaca());
            jsonobj.addProperty("id", ing.getId());
            jsonobj.addProperty("puesto", ing.getPuesto());
            jsonobj.addProperty("pingreso", ing.getPingreso());
            jsonobj.addProperty("fsalida", ing.getFsalida());
            array.add(jsonobj);
        }
        //System.out.println("Planes json serializado: " + array.toString());
        return array.toString();
    }
    
    private String serializarMultas(List<Multa> listado) {
        JsonArray array = new JsonArray();
        JsonObject jsonobj;
        for (Multa mul : listado) {
            jsonobj = new JsonObject();
            jsonobj.addProperty("nomulta", mul.getNomulta());
            jsonobj.addProperty("placa_vehi", mul.getPlaca_vehi());
            jsonobj.addProperty("descripcion_mul", mul.getDescripcion_mul());
            jsonobj.addProperty("fotografia_mul", mul.getFotografia_mul());
            jsonobj.addProperty("fecha_mul", mul.getFecha_mul());
            jsonobj.addProperty("estado_mul", mul.getEstado_mul());
            array.add(jsonobj);
        }
        //System.out.println("Planes json serializado: " + array.toString());
        return array.toString();
    }
}
