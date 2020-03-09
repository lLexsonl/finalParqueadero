package parqueadero.acceso;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    public void IngresarClienteEnLaCentral(String info) {
    
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info,3);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    @Override
    public void IngresarVehiculoEnLaCentral(String info) {
    
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info,4);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public void IngresarClienteVehiculoEnLaCentral(String info) {
        
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(info,7);
            cerrarFlujos();
            desconectar();
        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }
    
    @Override
    public String obtenerClienteDeLaCentral(String id) {       
        String respuesta = null;
        try {
            conectar(IP_SERVIDOR, PUERTO);
            respuesta = leerFlujoEntradaSalida(id,1);
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
            respuesta = leerFlujoEntradaSalida(id,6);
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
            respuesta = leerFlujoEntradaSalida(id,2);
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
            respuesta = leerFlujoEntradaSalida(id,5);
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
            respuesta = leerFlujoEntradaSalida(id,8);
            cerrarFlujos();
            desconectar();

        } catch (IOException ex) {
            Logger.getLogger(ServicioCentralSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuesta;  
    }

    private String leerFlujoEntradaSalida(String id,int opc) throws IOException {
        String respuesta = "";
        entradaDecorada = new Scanner(socket.getInputStream());
        salidaDecorada = new PrintStream(socket.getOutputStream());
        salidaDecorada.flush();
        // Usando el protocolo de comunicación
        if(opc==1){
        salidaDecorada.println("consultarCiudadano," + id);
        }
        if(opc==2){
        salidaDecorada.println("consultarVigilante," + id);    
        }
        if(opc==3){
        salidaDecorada.println("ingresarCliente," + id);    
        }
        if(opc==4){
        salidaDecorada.println("ingresarVehiculo," + id);    
        }
        if(opc==5){
        salidaDecorada.println("consultarCiudadanoVehiculo," + id);    
        }
        if(opc==6){
        salidaDecorada.println("consultarVehiculo," + id);    
        }
        if(opc==7){
        salidaDecorada.println("ingresarClienteVehiculo," + id);    
        }
        if(opc==8){
        salidaDecorada.println("consultarCiudadanosVehiculos," + id);    
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

    

    

    

    

    

    

    
}
