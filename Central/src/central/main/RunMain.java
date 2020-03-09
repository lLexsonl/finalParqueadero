package central.main;

import central.negocio.Cliente;
import central.negocio.GestorCliente;
import central.negocio.GestorVigilante;
import central.negocio.Vigilante;
import central.servicio.CentralServer;
import java.sql.SQLException;

/**
 *
 * @author libardo
 */
public class RunMain {
    public static void main(String args[]) throws ClassNotFoundException, SQLException{
     
        
        
       CentralServer regSer = new CentralServer();
       regSer.iniciar();
    }
}
