/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package central.negocio;

import java.sql.SQLException;

/**
 *
 * @author Usuario
 */
public class GestorVehiculo {
    
    private ConectorJdbc connector;
    
     public GestorVehiculo() {
        connector = new ConectorJdbc();
    }
    
    public String consultarnumeroVehiculos() throws ClassNotFoundException, SQLException {
        
        String numerodeclientes="";
        connector.conectarse();
        connector.crearConsulta("SELECT COUNT(idvehiculo) AS num FROM vehiculo");
    if (connector.getResultado().next()) {
        numerodeclientes=connector.getResultado().getString("num");   
        }
        connector.desconectarse();
        return numerodeclientes;
    }
    
    public Vehiculo buscarVehiculoPorId(String id) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        
        connector.crearConsulta("SELECT * FROM vehiculo Where placa='" + id + "'");

        Vehiculo vehiculo = null;
        if (connector.getResultado().next()) {
            vehiculo = new Vehiculo(connector.getResultado().getString("idvehiculo"), connector.getResultado().getString("placa"), connector.getResultado().getString("marca"), connector.getResultado().getString("tipovehiculo"));
            
        }
        connector.desconectarse();
        return vehiculo;
    }
    
    public void agregarVehiculo(String idvehiculo, String placa, String marca,String tipovehiculo) throws ClassNotFoundException, SQLException {
        connector.conectarse();
        connector.actualizar("INSERT INTO vehiculo (idvehiculo, placa,marca,tipovehiculo)"
                + " VALUES ("
                + "'" + idvehiculo + "',"
                + "'" + placa + "',"
                + "'" + marca + "',"
                + "'" + tipovehiculo + "'"            
                + ")");
        connector.desconectarse();

       
    }
    
    
}
