package central.negocio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class GestorClientePostgresql {

    private central.negocio.Connection connector;

    public GestorClientePostgresql() {
        connector = ConectorPostgresql.getConector();
    }

    public ClientePost buscarClientePorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();

        connector.crearConsulta("SELECT * FROM cliente Where id_cli='" + id + "'");

        ClientePost cliente = null;
        if (connector.getResultado().next()) {
            cliente = new ClientePost(connector.getResultado().getString("id_cli"), 
                    connector.getResultado().getString("nombre_cli"),
                    connector.getResultado().getString("apellido_cli"),
                    connector.getResultado().getString("genero_cli"),
                    connector.getResultado().getString("fecha_nac_cli"),
                    connector.getResultado().getString("rol_cli"));
        }
        connector.desconectarse();
        return cliente;
    }

    public void agregarCliente(String idcliente, String nombre, String apellido, String genero, String fechanacimiento, String rol) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO cliente"
                + " VALUES ("
                + "'" + idcliente + "',"
                + "'" + nombre + "',"
                + "'" + apellido + "',"
                + "'" + genero + "',"
                + "'" + fechanacimiento + "',"
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
                + "'" + fecha + "',"
                + "'DEBE'"
                + ")");
        //connector.actualizar(String.format("INSERT INTO MULTA VALUES(1, '%s', '%s', '%s', CURRENT_DATE, 'DEBE')", placa, desc, url));
        connector.desconectarse();
    }
    
    public UsuarioPost buscarVigilante(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.crearConsulta("SELECT * FROM usuario Where user_usu='" + id + "'");

        UsuarioPost usuario = null;
        if (connector.getResultado().next()) {
            usuario = new UsuarioPost(connector.getResultado().getString("id_cli"), connector.getResultado().getString("user_usu"), connector.getResultado().getString("pass_usu"));
        }
        connector.desconectarse();
        return usuario;
    }
    
    public List<ClienteVehiculoPost> buscarVehiculosCliente(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta(String.format("select * from cliente c inner join clientevehiculo cv " +
            "on c.id_cli = cv.id_cli " +
            "inner join vehiculo v " +
            "on cv.placa_vehi = v.placa_vehi where c.id_cli = '%s'", id));
        
        List<ClienteVehiculoPost> list = new ArrayList<>();
        
        while(connector.getResultado().next()) {
            ClienteVehiculoPost cvp = new ClienteVehiculoPost(
                    connector.getResultado().getString("id_cli"),
                    connector.getResultado().getString("nombre_cli"),
                    connector.getResultado().getString("apellido_cli"),
                    connector.getResultado().getString("rol_cli"),
                    connector.getResultado().getString("placa_vehi"),
                    connector.getResultado().getString("marca_vehi"),
                    connector.getResultado().getString("tipo_vehi"));
            list.add(cvp);
        }
        connector.desconectarse();
        return list;
    }
    
}
