package parqueadero.clientemain;

import parqueadero.acceso.FabricaServicioCentralSocket;
import parqueadero.acceso.IFabricaServicioCentral;
import parqueadero.negocio.GestorClientes;
import parqueadero.presentacion.GUIAdministrador;

/**
 *
 * @author Yerson
 */
public class RunAdmin {
    public RunAdmin() {
        IFabricaServicioCentral fabricaCentral = new FabricaServicioCentralSocket();
        GestorClientes gestor = new GestorClientes(fabricaCentral);
        
        GUIAdministrador viewAdmin = new GUIAdministrador();
        gestor.addView(viewAdmin);
        viewAdmin.setVisible(true);
    }
}
