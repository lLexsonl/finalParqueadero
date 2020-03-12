package central.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorCliente {
    private ConectorJdbc connector;
    
    public GestorCliente() {
        connector = new ConectorJdbc();
    }
    
    public String consultarnumeroClientes() throws ClassNotFoundException, SQLException {
        
        String numerodeclientes="";
        connector.conectarse();
        connector.crearConsulta("SELECT COUNT(idcliente) AS num FROM cliente");
    if (connector.getResultado().next()) {
        numerodeclientes=connector.getResultado().getString("num");   
        }
        connector.desconectarse();
        return numerodeclientes;
    }
    
    public Cliente buscarClientePorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta("SELECT * FROM cliente Where idcliente='" + id + "'");

        Cliente cliente = null;
        if (connector.getResultado().next()) {
            cliente = new Cliente(connector.getResultado().getString("idCliente"), connector.getResultado().getString("nombre"), connector.getResultado().getString("apellido"), connector.getResultado().getString("genero"), connector.getResultado().getString("fechaNacimiento"), connector.getResultado().getString("rol"));
            
        }
        connector.desconectarse();
        return cliente;
    }
    
    public void agregarCliente(String idcliente, String nombre, String apellido,String genero,String fechanacimiento,String rol) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO cliente (idcliente, nombre,apellido,genero,fechanacimiento,rol)"
                + " VALUES ("
                + "'" + idcliente + "',"
                + "'" + nombre + "',"
                + "'" + apellido + "',"
                + "'" + genero + "',"
                + "'" + fechanacimiento+ "',"
                + "'" + rol + "'"
                
                + ")");
        connector.desconectarse();
    }
    
    public void agregarMulta(String placa, String desc, String url, String fecha) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO MULTA"
                + " VALUES ("
                + "NULL,"
                + "'" + placa + "',"
                + "'" + desc + "',"
                + "'" + url + "',"
                + "'" + fecha +"',"
                + "'DEBE'"
                
                + ")");
        //connector.actualizar(String.format("INSERT INTO MULTA VALUES(1, '%s', '%s', '%s', CURRENT_DATE, 'DEBE')", placa, desc, url));
        connector.desconectarse();
    }
}
