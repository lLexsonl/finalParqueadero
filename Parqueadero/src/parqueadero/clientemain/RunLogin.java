/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
