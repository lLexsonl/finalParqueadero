/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.negociotest;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import parqueadero.negocio.ClienteVehiculoPost;
import parqueadero.negocio.GestorClienteVehiculo;

/**
 *
 * @author Yerson
 */
public class GestorClienteVehiculoTest {
    
    public GestorClienteVehiculoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }

    @Test
    public void test() throws Exception{
        
        GestorClienteVehiculo gcv=new GestorClienteVehiculo();
        ClienteVehiculoPost[] cv = gcv.buscarClienteVehiculoEnCentral("9200002");
        assertEquals("9200002",cv[0].getId_cli());    
    }
}
