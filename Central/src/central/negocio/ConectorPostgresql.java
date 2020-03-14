package central.negocio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Yerson
 */
public class ConectorPostgresql implements central.negocio.Connection {
    
    private static ConectorPostgresql singleton;

    private Connection cn;
    private ResultSet rs;
    private Statement st;
    private final String URL = "jdbc:postgresql://localhost:5432/parqueadero";

    private final String USER = "postgres";
    private final String PASSWORD = "postgresql";

    private ConectorPostgresql() {

    }
    
    public static ConectorPostgresql getConector() {
        if (singleton == null) {
            singleton = new ConectorPostgresql();
        }
        return singleton;
    }
    
    @Override
    public void conectarse() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        cn = DriverManager.getConnection(URL, USER, PASSWORD);
        boolean valid = cn.isValid(50000);
        System.out.println(valid ? "TEST OK" : "TEST FAIL");
    }

    /**
     * Ejecuta una consulta de tipo select
     *
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
     *
     * @throws SQLException
     */
    @Override
    public void desconectarse() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        st.close();
        cn.close();
    }

    /**
     * Devuelve todo el conjunto de resultados
     *
     * @return
     */
    @Override
    public ResultSet getResultado() {
        return rs;
    }
    //<editor-fold defaultstate="collapsed" desc="main">
    /*
    public static void main(String[] args) {
        ConectorPostgresql conector = getConector();
        try {
            String nombre = "";
            conector.conectarse();
            conector.crearConsulta("SELECT *  FROM emp where id = '2'");
            if (conector.getResultado().next()) {
                nombre = conector.getResultado().getString("nombre");
                System.out.println(nombre);
            }
            conector.desconectarse();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

    }
*/
//</editor-fold>
}
