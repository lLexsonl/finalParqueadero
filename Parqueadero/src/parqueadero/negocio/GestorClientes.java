package parqueadero.negocio;

import parqueadero.acceso.ServicioCentralSocket;
import java.util.ArrayList;
import mvcf.AModel;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import parqueadero.acceso.ICentral;
import parqueadero.acceso.IFabricaServicioCentral;

/**
 * Representa el modelo (Observable) de datos Cuando hay cambios en el estado,
 * notifica a todas sus vistas (observadores)
 *
 * @author Julio, Libardo, Ricardo
 */
public class GestorClientes extends AModel {

    private final ICentral central;
    private ConectorJdbc conector;

    public GestorClientes() {
        central = new ServicioCentralSocket();
        conector = ConectorJdbc.getConnectorJdbc();
    }
    
    public GestorClientes(IFabricaServicioCentral fabricaCentral) {
        central = fabricaCentral.crearServicioRegistraduria();
        conector = ConectorJdbc.getConnectorJdbc();
    }
    
    /**
     * Trae de la base de datos todos los clientes
     *
     * @return
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public ArrayList<Cliente> consultarClientes() throws ClassNotFoundException, SQLException {

        conector.conectarse();
        conector.crearConsulta("SELECT * FROM clientes");

        ArrayList<Cliente> clientes = new ArrayList();

        while (conector.getResultado().next()) {
            Cliente cli = new Cliente(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("rol"), conector.getResultado().getString("vehiculo"), conector.getResultado().getString("codigo"));
            clientes.add(cli);
        }
        conector.desconectarse();
        return clientes;
    }

    /**
     * Busca un cliente en el servidor remoto de la registraduría
     *
     * @param id identificador del clilente
     * @return Objeto tipo Cliente, null si no lo encuentra
     */
    public Cliente buscarClienteCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = central.obtenerClienteDeLaCentral(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            Cliente cliente = new Cliente();
            parseToCliente(cliente, json);
            return cliente;
        }
        return null;
    }
    
    public void IngresarClienteCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
         central.IngresarClienteEnLaCentral(id);
        
    }
    
    /**
     * Parsea una String json en un objeto Cliente
     * @param cliente
     * @param json 
     */
    private void parseToCliente(Cliente cliente, String json) {
        Gson gson = new Gson();
        Properties properties = gson.fromJson(json, Properties.class);
        cliente.setIdCliente(properties.getProperty("idCliente"));
        cliente.setNombre(properties.getProperty("nombre"));
        cliente.setApellido(properties.getProperty("apellido"));
        cliente.setGenero(properties.getProperty("genero"));
        cliente.setFechaNacimiento(properties.getProperty("fechaNacimiento"));
        cliente.setRol(properties.getProperty("rol"));
        
    }
    
    /**
     * Busca un cliente de la base de datos local dependiendo del ID
     * @param id identificación del cliente
     * @return retorna un Cliente
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public Cliente buscarCliente(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM clientes Where id='" + id + "'");

        Cliente cliente = null;
        if (conector.getResultado().next()) {
            cliente = new Cliente(conector.getResultado().getString("id"),
                    conector.getResultado().getString("nombres"), 
                    conector.getResultado().getString("apellidos"), 
                    conector.getResultado().getString("rol"), 
                    conector.getResultado().getString("vehiculo"), 
                    conector.getResultado().getString("codigo"));
        }
        conector.desconectarse();
        return cliente;
    }
     /**
      * Agrega un cliente en la base de datos local 
      * @param id
      * @param nombres
      * @param apellidos
      * @param direccion
      * @param celular
      * @param email
      * @throws ClassNotFoundException
      * @throws SQLException 
      */   
    public void agregarCliente(String id, String nombres, String apellidos, String direccion, String celular, String email) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("INSERT INTO Clientes (id, nombres, apellidos, rol, vehiculo, codigo)"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + direccion + "',"
                + "'" + celular + "',"
                + "'" + email + "'"
                        //parque
                
                + ")");
        conector.desconectarse();

        this.notificar();
    }
   
    public void editarCliente(String id, String nombres, String apellidos, String direccion, String celular, String email) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("UPDATE Clientes SET "
                + "nombres = '" + nombres + "',"
                + "apellidos ='" + apellidos + "',"
                + "rol ='" + direccion + "',"
                + "vehiculo = '" + celular + "',"
                + "codigo ='" + email + "'"
                
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
        this.notificar();

    }
    
    public void eliminarCliente(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("DELETE FROM Clientes  "
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
        this.notificar();
    }
    
    public int getTotalHombres(){
        return 12;
    }
    
    public int getTotalMujeres(){
        return 6;
    }    
    
    //Parte Hecha por Yerson
    /**
     * Busca los datos de los ingresos que no poseen fecha de salida
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public List<Ingreso> buscarIngresos() throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM REGISTRO WHERE FSALIDA IS NULL");
        List<Ingreso> list = new ArrayList<>();
        
        while(conector.getResultado().next()) {
            Ingreso ingreso = new Ingreso(conector.getResultado().getString("idvehiculo"), conector.getResultado().getString("idcliente"), 
                    conector.getResultado().getString("puesto"), conector.getResultado().getString("fingreso"),conector.getResultado().getString("fsalida"));
            list.add(ingreso);
        }
        conector.desconectarse();
        return list;
    }
    /**
     * Registra el ingreso de un vehiculo en el parqueadero
     * @param placa placa del vehiculo que se desea ingresar
     * @param id
     * @param puesto
     * @param fingreso
     * @param fsalida
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    
    public void agregarIngreso(String placa, String id, String puesto, String fingreso, String fsalida) throws ClassNotFoundException, SQLException  {
        conector.conectarse();
        conector.actualizar("INSERT INTO REGISTRO"
                + " VALUES ("
                + "'" + placa + fingreso +"',"
                + "'" + placa + "',"
                + "'" + id + "',"
                + "'" + puesto + "',"
                + "'" + fingreso + "',"
                + "NULL"
                + ")");
        conector.desconectarse();
        this.notificar();
    }
    
    /**
     * Consulta la información de los usuarios que poseen un vehiculo
     * @param id
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    
    public List<ClienteVehiculo> consultarVehiCliente(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.crearConsulta(String.format("SELECT * FROM CLIENTE INNER JOIN CLIENTEVEHICULO ON CLIENTE.ID = CLIENTEVEHICULO.ID INNER JOIN VEHICULO ON VEHICULO.PLACA = CLIENTEVEHICULO.PLACA WHERE CLIENTE.ID = '%s'", id));

        List<ClienteVehiculo> list = new ArrayList<>();
        
        while (conector.getResultado().next()) {
            ClienteVehiculo vehiculosCliente = new ClienteVehiculo(
                    conector.getResultado().getString("id"), 
                    conector.getResultado().getString("nombre"), 
                    conector.getResultado().getString("apellido"),
                    "", 
                    "",
                    "", 
                    conector.getResultado().getString("placa"), 
                    conector.getResultado().getString("marca"),
                    conector.getResultado().getString("tipo"));
            list.add(vehiculosCliente);
        }
        conector.desconectarse();
        return list;
    }
    
    /**
     * Edita la tabla INGRESO para actualizar la fecha de salida
     * @param id
     * @param placa
     * @param puesto
     * @param fingreso
     * @param fsalida
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void editarSalida(String id, String placa, String puesto, String fingreso, String fsalida) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar(String.format("UPDATE REGISTRO SET FSALIDA = '%s' WHERE IDREGISTRO = '%s%s'",
                fsalida, placa, fingreso));
        conector.desconectarse();
        this.notificar();
    }
    /**
     * Envia la información de la multa para que la cetral la cree
     * @param placa
     * @param desc
     * @param url
     * @param fecha 
     */
    public void crearMulta(String placa, String desc, String url, String fecha) {
        this.central.ingresarMulta(String.format("%s,%s,%s,%s", placa, desc, url, fecha));
    }
    
}
