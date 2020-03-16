
package parqueadero.negociotest;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import parqueadero.negocio.GestorVehiculo;
import parqueadero.negocio.GestorVehiculo;
import parqueadero.negocio.Vehiculo;
import parqueadero.negocio.Vehiculo;
import parqueadero.negocio.VehiculoPost;

/**
 *
 * @author Yerson
 */
public class TestGestorVehiculo {
    private static GestorVehiculo gestor;
    
    public TestGestorVehiculo() {
        
    }
    @BeforeClass
    public static void initGestor() {
        gestor = new GestorVehiculo();
    }
    
    @Test
    public void test() throws Exception{
        String nodeplaca="ABC-123";
        String marca="MAZDA";
        String tipo="CARRO";
        
        GestorVehiculo gv=new GestorVehiculo();
        gv.IngresarVehiculoCentral(nodeplaca+","+marca+","+tipo);
        
        VehiculoPost v=gv.buscarVehiculoCentral(nodeplaca);
        assertEquals(nodeplaca,v.getPlaca_vehi());
        
    }
}
