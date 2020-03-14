package central.negocio;

import java.sql.SQLException;

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
}
