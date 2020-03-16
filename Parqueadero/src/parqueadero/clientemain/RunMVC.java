package parqueadero.clientemain;

import java.util.TimerTask;
import java.util.Timer;
import parqueadero.acceso.FabricaServicioCentralSocket;
import parqueadero.acceso.IFabricaServicioCentral;
import parqueadero.negocio.GestorClientes;
import parqueadero.presentacion.GUIClientesController;
import parqueadero.presentacion.GUIMapaParqueadero;
import parqueadero.presentacion.GUIPrincipal;

/**
 * Es el pegamento de la aplición
 *
 * @author Libardo, Julio, Ricardo
 */
public class RunMVC {

    public RunMVC() {
        IFabricaServicioCentral fabricaCentral = new FabricaServicioCentralSocket();
        GestorClientes gestor = new GestorClientes(fabricaCentral);
        
        //PRIMERA VISTA
        GUIPrincipal view1 = new GUIPrincipal();
        gestor.addView(view1);
        GUIClientesController control = new GUIClientesController(gestor, view1);
        view1.setVisible(true);
        //gestor.notificar();
        
        //Mapa 
        GUIMapaParqueadero mapa = new GUIMapaParqueadero();
        gestor.addView(mapa);
        gestor.notificar();
        mapa.setVisible(true);
        /*
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                gestor.notificar();
            }
        };
        
        timer.scheduleAtFixedRate(timerTask, 0, 10000);
        */
        // SEGUNDA VISTA
        //GUIClientesVer view2 = new GUIClientesVer();
        //gestor.addView(view2);
        //gestor.notificar(); // Para que se cargue los clientes al cargar la ventana
        //view2.setVisible(true);
        

        // Enlaza el action controller de los botones al controlador y fija el comando de acción
        
        view1.getBtnIngresar().addActionListener(control);
        view1.getBtnIngresar().setActionCommand("INGRESAR");

        view1.getBtnRetirar().addActionListener(control);
        view1.getBtnRetirar().setActionCommand("RETIRAR");
        
        view1.getBtnMultar().addActionListener(control);
        view1.getBtnMultar().setActionCommand("MULTAR");
    }
}

    

