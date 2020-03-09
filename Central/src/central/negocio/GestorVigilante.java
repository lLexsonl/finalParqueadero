/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central.negocio;

import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import mvcf.AModel;


/**
 *
 * @author Usuario
 */
public class GestorVigilante extends AModel {
  
    
    private ConectorJdbcVigilante conector;
    
    public GestorVigilante() {
       
                conector = new ConectorJdbcVigilante();
    }

    
    
    public ArrayList<Vigilante> consultarVigilantes() throws ClassNotFoundException, SQLException {

        conector.conectarse();
        conector.crearConsulta("SELECT * FROM vigilante");

        ArrayList<Vigilante> vigilantes = new ArrayList();

        while (conector.getResultado().next()) {
            //Vigilante vig = new Vigilante(conector.getResultado().getString("id"), conector.getResultado().getString("nombres"), conector.getResultado().getString("apellidos"), conector.getResultado().getString("codigo"));
            
            //vigilantes.add(vig);
        }
        conector.desconectarse();
        return vigilantes;

    }
    
    
    
    public Vigilante buscarVigilante(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.crearConsulta("SELECT * FROM vigilante Where numeroid='" + id + "'");

        Vigilante vigilante = null;
        if (conector.getResultado().next()) {
            vigilante = new Vigilante(conector.getResultado().getString("numeroid"), conector.getResultado().getString("codigo"), conector.getResultado().getString("nombre"), conector.getResultado().getString("apellido"),conector.getResultado().getString("genero"),conector.getResultado().getString("fechadenacimiento"),conector.getResultado().getString("empresa"),conector.getResultado().getString("claveacceso"));
        }
        conector.desconectarse();
        return vigilante;
    }
    
    public void agregarVigilante(String id, String nombres, String apellidos,String codigo) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("INSERT INTO vigilante (id, nombres, apellidos, codigo)"
                + " VALUES ("
                + "'" + id + "',"
                + "'" + nombres + "',"
                + "'" + apellidos + "',"
                + "'" + codigo + "'"
                
                + ")");
        conector.desconectarse();

       
    }
        
    public void editarVigilante(String id, String nombres, String apellidos, String codigo) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("UPDATE Clientes SET "
                + "nombres = '" + nombres + "',"
                + "apellidos ='" + apellidos + "',"
                + "codigo ='" + codigo + "'"
                
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
        

    }
   
    public void eliminarVigilante(String id) throws ClassNotFoundException, SQLException {
        conector.conectarse();
        conector.actualizar("DELETE FROM vigilante  "
                + " WHERE id ='" + id
                + "'");
        conector.desconectarse();
       
    }  
}
