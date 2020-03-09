/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.negocio;

import com.google.gson.Gson;
import java.util.Properties;
import mvcf.AModel;
import parqueadero.acceso.ICentral;
import parqueadero.acceso.ServicioCentralSocket;

/**
 *
 * @author Usuario
 */
public class GestorVehiculo extends AModel{
    
    private final ICentral central;
    

    public GestorVehiculo() {
        central = new ServicioCentralSocket();
    }
    
     public void IngresarVehiculoCentral(String info) {
        //Obtiene el objeto json serializado al servidor de la registraduria
         central.IngresarVehiculoEnLaCentral(info);
        
    }
     public Vehiculo buscarVehiculoCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = central.obtenerVehiculoDeLaCentral(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            Vehiculo vehiculo = new Vehiculo();
            parseToCliente(vehiculo, json);
            return vehiculo;
        }
        return null;
    }
     
     private void parseToCliente(Vehiculo vehiculo, String json) {
        Gson gson = new Gson();
        Properties properties = gson.fromJson(json, Properties.class);
        vehiculo.setIdvehiculo(properties.getProperty("idVehiculo"));
        vehiculo.setNodeplaca(properties.getProperty("placa"));
        vehiculo.setMarca(properties.getProperty("marca"));
        vehiculo.setTipo(properties.getProperty("tipo"));
        
    }
}
