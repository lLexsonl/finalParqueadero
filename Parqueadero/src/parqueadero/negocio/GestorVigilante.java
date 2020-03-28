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
    
    public UsuarioPost buscarVigilanteCentral(String id) {
        //Obtiene el objeto json serializado al servidor de la registraduria
        String json = Central.obtenerVigilanteDeLaCentral(id);
        if (!json.equals("NO_ENCONTRADO")) {
            //Lo encontró
            System.out.println("Encontro el vigilante");
            UsuarioPost usu = new UsuarioPost();
            jsonToUsu(usu, json);
            return usu;
        }
        System.out.println("NO encontro el vigilante");
        return null;
    }
    
    public String insertarUsuario(String info){
        return Central.insertarUsuario(info);
    }
    
    private void jsonToUsu(UsuarioPost usu, String json) {
        Gson gson = new Gson();
        Properties properties = gson.fromJson(json, Properties.class);
        usu.setId_cli(properties.getProperty("id_cli"));
        usu.setUser_usu(properties.getProperty("user_usu"));
        usu.setPass_usu(properties.getProperty("pass_usu"));
    }
}
