/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.negocio;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import mvcf.AModel;
import parqueadero.acceso.ICentral;
import parqueadero.acceso.ServicioCentralSocket;

/**
 *
 * @author Usuario
 */
public class GestorVigilante extends AModel {
  
    private final ICentral Central;
    
    public GestorVigilante() {
        Central = new ServicioCentralSocket();
                
    }
    private void parseToVigilante(Vigilante vigilante, String json) {
        Gson gson = new Gson();
        Properties properties = gson.fromJson(json, Properties.class);
        
        vigilante.setNumeroid(properties.getProperty("numeroid"));
        vigilante.setCodigo(properties.getProperty("codigo"));
        vigilante.setNombre(properties.getProperty("nombre"));
        vigilante.setApellido(properties.getProperty("apellido"));
        vigilante.setGenero(properties.getProperty("genero"));
        vigilante.setFechadenacimiento(properties.getProperty("fechadenacimiento"));
        vigilante.setEmpresa(properties.getProperty("empresa"));
        vigilante.setClaveacceso(properties.getProperty("claveacceso"));
        
    }
    public Vigilante buscarVigilanteCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = Central.obtenerVigilanteDeLaCentral(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            Vigilante vig = new Vigilante();
            parseToVigilante(vig, json);
            return vig;
        }
        return null;
    }
}
