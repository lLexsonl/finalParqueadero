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
import parqueadero.negocio.Multa;

/**
 *
 * @author Libardo, Ricardo, Julio, Yerson, Adrian, Breiner
 */
public class GUIClientesController extends AActionController {

    private final GestorClientes gestor; // Modelo
    private final GUIPrincipal vista; //Vista

    public GUIClientesController(AModel myModel, AView myView) {
        super(myModel, myView);
        this.gestor = (GestorClientes) myModel;
        this.vista = (GUIPrincipal) myView;
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
                    rol = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 3));
                    tipo = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 5));
                    placa = String.valueOf(vista.getTblIngresoRetirar().getValueAt(index, 4));

                    fingreso = Utilidades.fechaAcualConFormato();
                    puesto = asignarPuesto(tipo);
                    System.out.println(puesto);
                    if (ingresoValido(id, placa)) {
                        if (puesto != -1) {
                            try {
                                gestor.agregarIngresoCentral(placa, id, String.valueOf(puesto), fingreso);
                                Utilidades.mensajeExito("Se registró el ingreso", "Ingreso");
                                GUIReporte reporte = GUIReporte.getReporte();
                                reporte.buscarReporte(placa);
                                reporte.setVisible(true);
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
                    placa = String.valueOf(vista.getTblIngresoRetirar().getValueAt(indexj, 4));
                    //fingreso = Utilidades.fechaAcual();//"19/02/2020";
                    
                    if (salidaValida(id, placa)) {
                        Utilidades.mensajeExito("Se realizó la salida del vehiculo", "Salida");
                    } else {
                        Utilidades.mensajeError("NO se realizó la salida del vehivulo", "Salida");
                    }
                    break;
                }
                //</editor-fold>
            case "MULTAR":
                //<editor-fold defaultstate="collapsed" desc="Funcionalidad MULTAR">
                
                System.out.println("Estoy en multar");
                
                String id, placa, des, url, fecha;
                id = vista.getTxtNoMulta().trim();
                if(Utilidades.isNumeric(id)) {
                placa = vista.getTxt_placa_mul().trim().toUpperCase();
                des = vista.getTxt_des_mul();
                url = vista.getTxt_url_multa();
                fecha = Utilidades.fechaAcualConFormato();
                
                String respuesta = gestor.crearMulta(id, placa, des, url, fecha);
                
                if(respuesta.equals("OK")) {
                    Utilidades.mensajeExito("Se creó la multa con éxito", "Crear Multa");
                } else {
                    Utilidades.mensajeError(String.format("NO se creó la multa, error: %s%n", respuesta), "Crear Multa");
                }
                } else {
                    Utilidades.mensajeError("El campo Número multa no es númerico", "Crear Multa");
                }
                
                //gestor.insertarMulta(placa, des, url, fecha);
                break;
                //</editor-fold>
            case "BUSCAR_MULTA":
                //<editor-fold defaultstate="collapsed" desc="Funcionalidad BuscarMulta">
                
                System.out.println("Estoy en buscar multa");
                
                String placa_multa = vista.getTxtBuscarMultaPlaca().trim().toUpperCase();
                
                List<Multa> list = gestor.buscarMultas(placa_multa);
                
                if(list != null) {
                    Utilidades.mensajeExito("Se encotraron multas asociadas al vehiculo", "Buscar Multas");
                    vista.fijarCamposTablaMulta(list);
                } else {
                    Utilidades.mensajeExito("NO se encotraron multas asociadas al vehiculo", "Buscar Multas");
                }
                break;
//</editor-fold>
            case "PAGAR_MULTA":
                //<editor-fold defaultstate="collapsed" desc="Funcionalida pagarMulta">
                
                int indexM = vista.getTblMultas().getSelectedRow();
                if (indexM != -1) {
                    String numeroMulta, respuesta;
                    
                    numeroMulta = String.valueOf(vista.getTblMultas().getValueAt(indexM, 0));
                    
                    respuesta = gestor.pagarMulta(numeroMulta);
                    
                    if(respuesta.equals("OK")) {
                        Utilidades.mensajeExito("Se pagó la multa", "Pago de MULTA");
                    } else {
                        Utilidades.mensajeExito("NO se logró pagar la multa", "Pago de MULTA");
                    }
                } else {
                    Utilidades.mensajeAdvertencia("NO ha seleccionado una tupla", "Pago de MULTA");
                }
                break;
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
            List<Ingreso> list = gestor.buscarIngresosCentral();
            if (list != null) {
                ints.removeAll(list.stream().map(l -> String.valueOf(Integer.parseInt(l.getPuesto().split("_")[1]))).collect(Collectors.toList()));
            }
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
            List<Ingreso> list = gestor.buscarIngresosCentral();

            if (list != null) {
                for (Ingreso i : list) {
                    //System.out.println(String.format("IngresoValido: %s = %s, %s = %s", i.getId(), id, i.getPlaca(), placa));
                    if (i.getId().equals(id)
                            || i.getPlaca().equals(placa)) {
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
        String fsalida = Utilidades.fechaAcualConFormato();//"21/02/2020";

        try {
            List<Ingreso> list = gestor.buscarIngresosCentral();
            System.out.println("Estoy en validar la salida");
            for (Ingreso i : list) {
                System.out.println(i.toString());
                if (id.equals(i.getId()) && placa.equals(i.getPlaca())) {
                    String respuesta = gestor.editarSalidaCentral(id, placa, i.getPuesto(), i.getPingreso(), fsalida);
                    if(respuesta.isEmpty())
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
