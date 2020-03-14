package central.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yerson
 */
public interface Connection {
    public void conectarse() throws ClassNotFoundException, SQLException;
    public void crearConsulta(String sql) throws SQLException;
    public void actualizar(String sql) throws SQLException;
    public ResultSet getResultado();
    public void desconectarse() throws SQLException;
}
