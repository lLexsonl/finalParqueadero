package parqueadero.clientemain;

import parqueadero.negocio.GestorVigilante;
import parqueadero.presentacion.GUILogin;

/**
 *
 * @author Usuario
 */
public class RunLogin {
    
    public RunLogin() {
        
        GestorVigilante gesVig = new GestorVigilante();
        GUILogin viewVL = new GUILogin();
        gesVig.addView(viewVL);
        gesVig.notificar();
        viewVL.setVisible(true);
    }
}
