
package parqueadero.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Esta clase se conecta a la base de datos con Jdbc
 *
 * @author Libardo, Ricardo, Julio
 */
public class ConectorJdbc {

    private static ConectorJdbc connector;

    private Connection cn;
    private ResultSet rs;
    private Statement st;
    private final String URL = "jdbc:hsqldb:file:C:\\Users\\Yerson\\Downloads\\Segunda Entrega Parqueadero\\Parqueadero\\bd\\clientes;hsqldb.lock_file=false";
    
    private final String USER = "sa";
    private final String PASSWORD = "123";

    private ConectorJdbc() {

    }
    
    public static ConectorJdbc getConnectorJdbc() {
        if (connector == null) {
            connector = new ConectorJdbc();
        }
        return connector;
    }

    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Ejecuta una consulta de tipo select
     * @param sql
     * @throws SQLException 
     */
    public void crearConsulta(String sql) throws SQLException {
        st = cn.createStatement();
        rs = st.executeQuery(sql);
    }

    /**
     * Ejecuta una consulta de tipo insert, update o delete
     *
     * @param sql
     * @throws SQLException
     */
    public void actualizar(String sql) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(sql);
        cn.commit();
    }
    /**
     * Cierra las variables de rs, st y cn que estén abiertas
     * @throws SQLException 
     */
    public void desconectarse() throws SQLException {
        if ( rs != null){
            rs.close();
        }
        st.close();
        cn.close();
    }
    /**
     * Devuelve todo el conjunto de resultados
     * @return 
     */
    public ResultSet getResultado() {
        return rs;
    }
}
