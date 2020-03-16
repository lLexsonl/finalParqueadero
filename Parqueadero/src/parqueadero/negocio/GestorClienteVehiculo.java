package parqueadero.negocio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import parqueadero.acceso.ICentral;
import parqueadero.acceso.ServicioCentralSocket;

/**
 *
 * @author Usuario
 */
public class GestorClienteVehiculo {
    
   
    private final ICentral central;
    private ConectorJdbc connector;
    
    public GestorClienteVehiculo() {
        connector = ConectorJdbc.getConnectorJdbc();
        central=new ServicioCentralSocket();
    }
    
    public ClienteVehiculo buscarClienteVehiculoPorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta("SELECT * FROM clientvehiculo Where idcliente='" + id + "'");

        ClienteVehiculo clientevehiculo = null;
        if (connector.getResultado().next()) {
            clientevehiculo = new ClienteVehiculo(connector.getResultado().getString("idCliente"), connector.getResultado().getString("nombre"), connector.getResultado().getString("apellido"), connector.getResultado().getString("genero"), connector.getResultado().getString("fechaNacimiento"),connector.getResultado().getString("idvehiculo"),connector.getResultado().getString("placa"),connector.getResultado().getString("idvehiculo"),connector.getResultado().getString("tipovehiculo"));
            
        }
        connector.desconectarse();
        return clientevehiculo;
    }
    public ClienteVehiculoPost[] buscarClienteVehiculoEnCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = central.obtenerClienteVehiculoDeLaCentral(id);
        System.out.println("Json que viene de la central : " + json);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            ClienteVehiculoPost[] clienteve = parseToClienteVehiculo(json);
            return clienteve;
        }
        return null;
    }
    public ClienteVehiculoPost[] buscarClientesVehiculosEnCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = central.obtenerClientesVehiculosDeLaCentral(id);
        System.out.println("\n Json que viene de la central : " + json);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            return this.parseToClienteVehiculo( json);
            //System.out.println("parseToClienteVeiculo " + clienteve.toString());
            //return clienteve;
        }
        return null;
    }
    
    public String IngresarClienteVehiculoCentral(String info) {
        //Obtiene el objeto json serializado al servidor de la registraduria
         return central.IngresarClienteVehiculoEnLaCentral(info);
    }
    
    private ClienteVehiculoPost[] parseToClienteVehiculo(String json) {
        ClienteVehiculoPost[] array = new Gson().fromJson(json, ClienteVehiculoPost[].class);
        return array;
    }
    
    private ClienteVehiculo[] deserializarClientesVehiculos(String arrayJsonSerializado) {

        ClienteVehiculo[] clientesvehiculos = new Gson().fromJson(arrayJsonSerializado, ClienteVehiculo[].class);

        
        return clientesvehiculos;
    }
    
    
    
}
    

