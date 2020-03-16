package parqueadero.negocio;

import com.google.gson.Gson;
import java.util.Properties;
import mvcf.AModel;
import parqueadero.acceso.ICentral;
import parqueadero.acceso.ServicioCentralSocket;
import parqueadero.negocio.VehiculoPost;

/**
 *
 * @author Usuario
 */
public class GestorVehiculo extends AModel{
    
    private final ICentral central;
    

    public GestorVehiculo() {
        central = new ServicioCentralSocket();
    }
    
     public String IngresarVehiculoCentral(String info) {
        //Obtiene el objeto json serializado al servidor de la registraduria
         return central.IngresarVehiculoEnLaCentral(info);
        
    }
     public VehiculoPost buscarVehiculoCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = central.obtenerVehiculoDeLaCentral(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            VehiculoPost vehiculo = parseToVehiculo(json);
            return vehiculo;
        }
        return null;
    }
     
     private VehiculoPost parseToVehiculo(String json) {
        VehiculoPost vehi = new Gson().fromJson(json, VehiculoPost.class);
        return vehi;
    }
}
