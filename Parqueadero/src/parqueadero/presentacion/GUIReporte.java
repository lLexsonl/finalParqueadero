package parqueadero.presentacion;

import java.awt.Color;
import java.util.List;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;
import parqueadero.negocio.GestorClientes;
import parqueadero.negocio.ReporteIngreso;

/**
 *
 * @author Yerson
 */
public class GUIReporte extends javax.swing.JFrame {
    
    private static GUIReporte reporte;
    /**
     * Creates new form GUIReporte
     */
    private GUIReporte() {
        initComponents();
    }
    
    public static GUIReporte getReporte() {
        if(reporte == null){
            reporte = new GUIReporte();
        }
        return reporte;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Reporte");
        setPreferredSize(new java.awt.Dimension(700, 500));

        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
/*        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIReporte.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
    /*    java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIReporte().setVisible(true);
            }
        });
    }*/

    public void buscarReporte(String placa) {
        GestorClientes gestor = new GestorClientes();
        List<ReporteIngreso> reportes = gestor.buscarReporteIngresos(placa);
        if (reportes != null) {
            String dia = "";
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
            for (ReporteIngreso ingreso : reportes) {
                dia = elegirDia(ingreso.getFechaIngreso());
                dataSet.addValue(Double.parseDouble(ingreso.getCantidad()), "Dia de la semana", dia);
                //dataSet.setValue(Double.parseDouble(ingreso.getCantidad()), "Dia de la semana", dia);
            }
            JFreeChart jchart = ChartFactory.createBarChart("Reporte Ingresos", "Fecha Ingreso", "Cantidad", dataSet, PlotOrientation.VERTICAL, true, true, false);

            CategoryPlot plot = jchart.getCategoryPlot();
            plot.setRangeGridlinePaint(Color.BLACK);
            
            ChartPanel panel = new ChartPanel(jchart);

            pnlPrincipal.removeAll();
            pnlPrincipal.add(panel);
            pnlPrincipal.updateUI();
        }
    }
    
    private String elegirDia(String dia) {
        switch (dia) {
            case "0":
                dia = "Domingo";
                break;
            case "1":
                dia = "Lunes";
                break;
            case "2":
                dia = "Martes";
                break;
            case "3":
                dia = "Miercoles";
                break;
            case "4":
                dia = "Jueves";
                break;
            case "5":
                dia = "Viernes";
                break;
            case "6":
                dia = "Sabado";
                break;
            default:
                dia = "-1";
                break;
        }
        return dia;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
