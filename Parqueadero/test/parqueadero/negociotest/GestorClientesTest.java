/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parqueadero.negociotest;

import java.sql.SQLException;
import parqueadero.negocio.GestorClientes;
import parqueadero.negocio.Cliente;
import org.junit.BeforeClass;
import org.junit.Test;
import parqueadero.negocio.Cliente;
import parqueadero.negocio.GestorClientes;
import static org.junit.Assert.*;

/**
 *
 * @author Libardo, Julio, Ricardo
 */
public class GestorClientesTest {
    
    public GestorClientesTest() {
    }
    
    private static GestorClientes gestor;
    
    @BeforeClass
    private static void initGestor() {
        gestor = new GestorClientes();
    }

    //<editor-fold defaultstate="collapsed" desc="Test of testCRUDCliente">
    /**
     * Test of testCRUDCliente method, of class GestorClientes.
     * @throws java.lang.Exception
     */
    @Test
    public void testCRUDCliente() throws Exception {
        
        
        System.out.println("CRUD cliente");
        
        // Lo elimina
        //GestorClientes gestor = new GestorClientes();
        gestor.eliminarCliente("1234");
        
        // Lo agrega
        String id = "1234";
        String nombres = "Juan";
        String apellidos = "Perez";
        String rol = "Estudiante";
        String vehiculo = "XBC01H";
        String codigo = "101010";
        
        gestor.agregarCliente(id, nombres, apellidos, rol, vehiculo, codigo);
        
//         Lo consulta
        Cliente result = gestor.buscarCliente("1234");
        
        assertEquals("1234", result.getIdCliente());
        assertEquals("Juan", result.getNombre());
        assertEquals("Perez", result.getApellido());
        
        // Lo edita
        nombres = "Juan Andres";
        apellidos = "Perez Lopez";
        gestor.editarCliente(id, nombres, apellidos, "", "", "");
        
        // Lo vuelve a consuttar
        
        result = gestor.buscarCliente("1234");
        assertEquals("1234", result.getIdCliente());
        assertEquals("Juan Andres", result.getNombre());
        assertEquals("Perez Lopez", result.getApellido());
                
               
        
        //Lo deja eliminando
        gestor.eliminarCliente("1234");
        result = gestor.buscarCliente("123");
        assertEquals(null, result);
                
    }
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Test Ingresos y salidas">
    
    @Test
    public void testIngresoSalida() {
        try {
            int size = gestor.buscarIngresos().size();
            gestor.agregarIngreso("XBC01D", "100001", "5", "12/02/2020 11:21 a.m.", "");
            
            int sizeNow = gestor.buscarIngresos().size();
            assertFalse(size == sizeNow);
            assertTrue(size +1 == gestor.buscarIngresos().size());
            
            gestor.editarSalida("100001", "XBCO1D", "5", "12/02/2020 11:21 a.m.", "12/02/2020 11:21 a.m.");
            
            size = gestor.buscarIngresos().size();
            
            assertEquals(size, sizeNow);
        } catch(ClassNotFoundException | SQLException e) {
            
        }
    }
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Test Cental">
    
    @Test
    public void testGestionCentral() {
        Cliente cliente = gestor.buscarClienteCentral("92000001");
        assertNotNull(cliente);
        assertEquals(cliente.getNombre(), "pepe");
        assertEquals(cliente.getApellido(), "narvaez");
        assertEquals(cliente.getGenero(), "M");
        assertTrue(cliente.getRol().equals("Estudiante"));
        assertFalse(cliente.getNombre().equals("sofia"));
    }
    //</editor-fold>
}
