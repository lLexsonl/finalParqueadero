package parqueadero.acceso;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import parqueadero.utils.Utilidades;

/**
 *
 * @author ahurtado, wpantoja, rzambran
 */
public class ServicioCentralSocket implements ICentral {

    private Socket socket = null;
    private Scanner entradaDecorada;
    private PrintStream salidaDecorada;
    private final String IP_SERVIDOR = "localhost";
    private final int PUERTO = 5000;

    /**
     * Obtiene el registro de un cliente en formato Json
     *
     */
    @Override
    public String IngresarClienteEnLaCentral(String info) {

        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 3);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }

    @Override
    public String IngresarVehiculoEnLaCentral(String info) {

        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 4);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }

    @Override
    public String IngresarClienteVehiculoEnLaCentral(String info) {

        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 7);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;

    }

    @Override
    public String obtenerClienteDeLaCentral(String id) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, 1);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String obtenerVehiculoDeLaCentral(String id) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, 6);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String obtenerVigilanteDeLaCentral(String id) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, 2);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String obtenerClienteVehiculoDeLaCentral(String id) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, 5);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String obtenerClientesVehiculosDeLaCentral(String id) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id, 8);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    private String leerFlujoEntradaSalida(String id, int opc) throws IOException {
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicación
        
        switch(opc) {
            case 1:
                salidaDecorada.println("buscarCliente," + id);
                break;
            case 2:
                salidaDecorada.println("buscarVigilante," + id);
                break;
            case 3:
                salidaDecorada.println("insertarCliente," + id);
                break;
            case 4:
                salidaDecorada.println("ingresarVehiculo," + id);
                break;
            case 5:
                salidaDecorada.println("buscarClienteVehiculo," + id);
                break;
            case 6:
                salidaDecorada.println("buscarVehiculo," + id);
                break;
            case 7:
                salidaDecorada.println("inserarClienteVehiculo," + id);
                break;
            case 8:
                salidaDecorada.println("buscarClienteVehiculo," + id);
                break;
            case 9:
                salidaDecorada.println("insertarMulta," + id);
                break;
            case 10:
                salidaDecorada.println("insertarIngreso," + id);
                break;
            case 11:
                salidaDecorada.println("buscarIngresos");
                break;
            case 12:
                salidaDecorada.println("editarSalida," + id);
                break;
            case 13:
                salidaDecorada.println("buscarMultas,"+ id);
                break;
            case 14:
                salidaDecorada.println("insertarUsuario," + id);
                break;
            case 15:
                salidaDecorada.println("buscarReporteIngresos," + id);
                break;
            case 16:
                salidaDecorada.println("generarReporteHorasIngreso,"+ id);
                break;
            case 17:
                salidaDecorada.println("pagarMulta," + id);
                break;
            default:
                Utilidades.mensajeError("Opción NO valida", "Comunicación con el servidor");
                break;
        }
        
        if (entradaDecorada.hasNextLine()) {
            respuesta = entradaDecorada.nextLine();
        }
        return respuesta;
    }

    private void cerrarFlujos() {
        salidaDecorada.close();
        entradaDecorada.close();
    }

    private void desconectar() {
        try {
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void conectar(String address, int port) throws IOException {
        socket = new Socket(address, port);
        System.out.println("Conectado");
    }

    @Override
    public String ingresarMulta(String sql) {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(sql, 9);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public void insertarIngreso(String info) {
        try {
            conectar(IP_SERVIDOR, PUERTO);
            leerFlujoEntradaSalida(info, 10);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String buscarIngresosCentral() {
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida("",11);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String editarSalidaCentral(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 12);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;
    }

    @Override
    public String buscarMultas(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 13);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;        
    }

    @Override
    public String insertarUsuario(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 14);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta; 
    }

    @Override
    public String buscarReporteIngresos(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 15);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta; 
    }

    @Override
    public String generarReporteHorasIngreso(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 16);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta; 
    }

    @Override
    public String pagarMulta(String info) {
        String respuesta = "";
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info, 17);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta; 
    }
}
