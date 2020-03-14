package central.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Usuario
 */
public class ConectorJdbc implements central.negocio.Connection {

    private static ConectorJdbc conector;
    private Connection cn;
    private ResultSet rs;
    private Statement st;
    private final String URL = "jdbc:hsqldb:file:C:\\Users\\Yerson\\Java\\Segunda Entrega Parqueadero\\Central\\bd\\clientes;hsqldb.lock_file=false";
    
    private final String USER = "sa";
    private final String PASSWORD = "123";

    private ConectorJdbc() {

    }

    public static ConectorJdbc getConector() {
        if(conector == null) {
            conector = new ConectorJdbc();
        }
        return conector;
    }
    
    @Override
    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.hsqldb.jdbcDriver");
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * Ejecuta una consulta de tipo select
     * @param sql
     * @throws SQLException 
     */
    @Override
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
    @Override
    public void actualizar(String sql) throws SQLException {
        st = cn.createStatement();
        st.executeUpdate(sql);
    }
    /**
     * Cierra las variables de rs, st y cn que estén abiertas
     * @throws SQLException 
     */
    @Override
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
    @Override
    public ResultSet getResultado() {
        return rs;
    }
}