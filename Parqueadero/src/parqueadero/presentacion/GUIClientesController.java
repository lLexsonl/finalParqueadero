package parqueadero.presentacion;

import parqueadero.negocio.GestorClientes;
import parqueadero.utils.Utilidades;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import mvcf.AActionController;
import mvcf.AModel;
import mvcf.AView;
import parqueadero.negocio.Ingreso;

/**
 *
 * @author Libardo, Ricardo, Julio, Yerson, Adrian, Breiner
 */
public class GUIClientesController extends AActionController {

    private final GestorClientes gestor; // Modelo
    private final GuiPrincipal vista; //Vista

    public GUIClientesController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorClientes) myModel;
        this.vista = (GuiPrincipal) myView;
    }

    /**
     * Este método se invoca automáticamente desde GUICliente al presionar los
     * botones de accion INGRESAR O RETIRAR
     *
     * @param e objeto tipo ActionEvent que indica qué boton se presionó
     */
    @Override
    public void actualizar(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "INGRESAR":
                //<editor-fold defaultstate="collapsed" desc="Funcionalidad INGRESAR">
                System.out.println("Estoy en ingresar");
                int index = vista.getTblIngresoRetirar().getSelectedRow();
                if (index != -1) {

                    String id, nombre, apellido, rol, placa, tipo, fingreso , idVehiculo;
                    int puesto;

                    id = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 0));
                    nombre = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 1));
                    apellido = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 2));
                    //rol = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 3));
                    tipo = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 5));
                    idVehiculo = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 3));
                    placa = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 4));

                    fingreso = Utilidades.fechaAcual();//"19/02/2020";
                    puesto = asignarPuesto(tipo);
                    System.out.println(puesto);
                    if (ingresoValido(id, idVehiculo)) {
                        if (puesto != -1) {
                            try {
                                gestor.agregarIngreso(idVehiculo, id, String.valueOf(puesto), fingreso, null);
                                Utilidades.mensajeExito("Se registró el ingreso", "Ingreso");
                            } catch (ClassNotFoundException | SQLException ex) {
                                System.out.println(ex.getMessage());
                                Utilidades.mensajeError("NO se pudo registrar el ingreso", "Ingreso");
                            }
                            //gestor.notificar();
                        } else {
                            Utilidades.mensajeAdvertencia("No se pudo asignar el puesto", "Ingreso");
                        }
                    } else {
                        Utilidades.mensajeError("NO se puede ingresar por que el vehiculo no ha registrado la salida", "Ingreso");
                    }
                } else {
                    Utilidades.mensajeAdvertencia("No ha seleccionado una fila", "Ingreso");
                }

                //<editor-fold defaultstate="collapsed" desc="Lo que tenia el compañero">
                /*
                if (vista.validarFormulario()) {
                    if (vista.getAccion().equals("AGREGAR")) {
                        //AGREGAR
                        GUIMapaParqueadero mapa = new GUIMapaParqueadero();
                        gestor.addView(mapa);
                        gestor.notificar();
                        mapa.setVisible(true);
                        //agregarCliente();

                    } else {
                        editarCliente();
                    }
                    vista.limpiarCajas(true);
                    vista.botonesEstadoInicial();
                }*/
                //</editor-fold>
                break;
            //</editor-fold>
            case "RETIRAR":
                //<editor-fold defaultstate="collapsed" desc="Funcionalidad RETIRAR">
                System.out.println("Estoy en retirar");
                int indexj = vista.getTblIngresoRetirar().getSelectedRow();
                if (indexj != -1) {

                    String id, placa;//, fingreso;

                    id = String.valueOf(vista.getTblIngresoRetirar().getValueAt(indexj, 0));
                    placa = String.valueOf(vista.getTblIngresoRetirar().getValueAt(indexj, 3));
                    //fingreso = Utilidades.fechaAcual();//"19/02/2020";
                    
                    if (salidaValida(id, placa)) {
                        Utilidades.mensajeExito("Se realizó la salida del vehiculo", "Salida");
                    } else {
                        Utilidades.mensajeError("NO se realizó la salida del vehivulo", "Salida");
                    }

                    //eliminarCliente();
                    /*
                try {
                    gestor.editarSalida(id, placa, puesto, fingreso, fsalida);
                } catch(SQLException | ClassNotFoundException ex) {
                    System.out.println(ex.getMessage());
                }
                     */
                    break;
                }
                //</editor-fold>
        }
    }

    //<editor-fold defaultstate="collapsed" desc="Agregar/Editar/Eliminar Cliente">
    private void agregarCliente() {
        try {
            gestor.agregarCliente(vista.getId(), vista.getNombres(), vista.getApellidos(), vista.getDireccion(), vista.getCelular(), vista.getEmail());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeError("Error al agregar el cliente", "Atención");
        }
        Utilidades.mensajeExito("Empleado agregado con éxito", "Atención");
    }

    private void editarCliente() {
        try {
            // EDITAR
            gestor.editarCliente(vista.getId(), vista.getNombres(), vista.getApellidos(), vista.getDireccion(), vista.getCelular(), vista.getEmail());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
            Utilidades.mensajeError("Error al editar el cliente", "Atención");
        }
        Utilidades.mensajeExito("Empleado modificado con éxito", "Atención");
    }

    private void eliminarCliente() {
        if (Utilidades.mensajeConfirmacion("Está seguro que desea eliminar el empleado " + vista.getId() + "?", "Atención") == JOptionPane.YES_OPTION) {
            try {
                gestor.eliminarCliente(vista.getId());
                Utilidades.mensajeExito("Empleado borrado con éxito", "Atención");
                vista.limpiarCajas(true);
                vista.botonesEstadoInicial();
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(GUIClientesController.class.getName()).log(Level.SEVERE, null, ex);
                Utilidades.mensajeError("Error al eliminar el cliente", "Atención");
            }
        }
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Apoyo Ingreso">

    private int asignarPuesto(String tipo) {
        tipo = tipo.toUpperCase();
        int puesto = -1;
        List<String> ints = new ArrayList<>();//Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39");

        for (int j = 1; j <= 39; j++) {
            ints.add("" + j);
        }

        try {
            List<Ingreso> list = gestor.buscarIngresos();

            ints.removeAll(list.stream().map(l -> l.getPuesto()).collect(Collectors.toList()));

            //System.out.println(Arrays.toString(ints.toArray()));
            if (tipo.equals("MOTO")) {
                ints.removeAll(Arrays.asList("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"));
                puesto = Integer.parseInt(ints.get(0));
            } else {
                ints.removeAll(Arrays.asList("25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39"));
                puesto = Integer.parseInt(ints.get(0));
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            return puesto;
        }
        return puesto;
    }

    public boolean ingresoValido(String id, String placa) {
        boolean valido = true;
        try {
            List<Ingreso> list = gestor.buscarIngresos();

            if (!list.isEmpty()) {
                for (Ingreso i : list) {
                    //System.out.println(String.format("IngresoValido: %s = %s, %s = %s", i.getId(), id, i.getPlaca(), placa));
                    if (i.getId().equals(id)
                            && i.getPlaca().equals(placa)) {
                        valido = false;
                    }
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            valido = false;
        }
        System.out.println("Valido=" + valido);
        return valido;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Apoyo Salida">
    
    public boolean salidaValida(String id, String placa) {

        boolean valido = false;
        String fsalida = Utilidades.fechaAcual();//"21/02/2020";

        try {
            List<Ingreso> list = gestor.buscarIngresos();

            for (Ingreso i : list) {
                if (id.equals(i.getId()) && placa.equals(i.getPlaca())) {
                    gestor.editarSalida(id, placa, i.getPuesto(), i.getPingreso(), fsalida);
                    valido = true;
                    break;
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
            valido = false;
        }

        return valido;
    }
    //</editor-fold>
}
