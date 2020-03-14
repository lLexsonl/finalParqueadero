package central.main;

import central.servicio.CentralServer;
import central.servicio.CentralServerPost;
import java.sql.SQLException;

/**
 *
 * @author libardo
 */
public class RunMain {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
       CentralServerPost regSer = new CentralServerPost();
       regSer.iniciar();
    }
}
