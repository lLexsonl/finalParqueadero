package central.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorClienteVehiculo {
    
    private ConectorJdbc connector;
    
    public GestorClienteVehiculo() {
        connector = ConectorJdbc.getConector();
    }

    
    
    public ClienteVehiculo buscarClienteVehiculoPorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta("SELECT * \n" +
"FROM ((clientvehiculo INNER JOIN vehiculo ON clientvehiculo.idvehiculo=vehiculo.idvehiculo)as resto\n" +
"inner join cliente on resto.idcliente=cliente.idcliente)  Where cliente.idcliente='" + id + "'");

        ClienteVehiculo clientevehiculo = null;
        if (connector.getResultado().next()) {
            clientevehiculo = new ClienteVehiculo(
                    connector.getResultado().getString("idCliente"),
                    connector.getResultado().getString("nombre"),
                    connector.getResultado().getString("apellido"),
                    connector.getResultado().getString("genero"),
                    connector.getResultado().getString("fechaNacimiento"),
                    connector.getResultado().getString("rol"),
                    connector.getResultado().getString("idvehiculo"),
                    connector.getResultado().getString("placa"),
                    connector.getResultado().getString("marca"),
                    connector.getResultado().getString("tipovehiculo"));
            
        }
        connector.desconectarse();
        return clientevehiculo;
    }
    
    public void agregarClienteVehiculo(String idclientevehiculo, String idcliente, String idvehiculo) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO clientvehiculo (idclientevehiculo, idcliente,idvehiculo)"
                + " VALUES ("
                + "'" + idclientevehiculo + "',"
                + "'" + idcliente + "',"
                + "'" + idvehiculo + "'"            
                + ")");
        connector.desconectarse();

       
    }
    
    public String consultarnumeroClienteVehiculos() throws ClassNotFoundException, SQLException {
        
        String numerodeclientes="";
        connector.conectarse();
        connector.crearConsulta("SELECT COUNT(idclientevehiculo) AS num FROM clientvehiculo");
    if (connector.getResultado().next()) {
        numerodeclientes=connector.getResultado().getString("num");   
        }
        connector.desconectarse();
        return numerodeclientes;
    }

    public ArrayList<ClienteVehiculo> buscarClientesVehiculosPorId(String idclives) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta("SELECT * \n" +
"FROM ((clientvehiculo INNER JOIN vehiculo ON clientvehiculo.idvehiculo=vehiculo.idvehiculo)as resto\n" +
"inner join cliente on resto.idcliente=cliente.idcliente)  Where cliente.idcliente='" + idclives + "'");

        ArrayList<ClienteVehiculo> list = new ArrayList<>();
        
        while (connector.getResultado().next()) {
            ClienteVehiculo clientevehiculo = new ClienteVehiculo(
                    connector.getResultado().getString("idCliente"),
                    connector.getResultado().getString("nombre"),
                    connector.getResultado().getString("apellido"),
                    connector.getResultado().getString("genero"),
                    connector.getResultado().getString("fechaNacimiento"),
                    connector.getResultado().getString("rol"),
                    connector.getResultado().getString("idvehiculo"),
                    connector.getResultado().getString("placa"),
                    connector.getResultado().getString("marca"),
                    connector.getResultado().getString("tipovehiculo"));
            list.add(clientevehiculo);
        }
        connector.desconectarse();
        return list;
    }
    
}
