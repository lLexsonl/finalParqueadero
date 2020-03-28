package parqueadero.presentacion;

import java.util.Calendar;
import mvcf.AModel;
import mvcf.AView;
import parqueadero.negocio.GestorClientes;
import parqueadero.negocio.GestorVigilante;
import parqueadero.utils.Utilidades;

/**
 *
 * @author Usuario
 */
public class GUIAdministrador extends javax.swing.JFrame implements AView {

    /**
     * Creates new form GUIAdministrador
     */
    public GUIAdministrador() {
        this.initComponents();
        super.setSize(600, 600);
        super.setLocationRelativeTo(null);
        btnGroup1.add(rbFemenino);
        btnGroup1.add(rbMasculino);
        rbFemenino.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblIdent = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblApellido = new javax.swing.JLabel();
        txtApellido = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblGeneroU = new javax.swing.JLabel();
        rbFemenino = new javax.swing.JRadioButton();
        rbMasculino = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        lblUser = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtPass = new javax.swing.JPasswordField();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        fechaNac = new com.toedter.calendar.JCalendar();
        jPanel6 = new javax.swing.JPanel();
        btnCrearVigi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrador");
        setPreferredSize(new java.awt.Dimension(500, 500));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel7.setMinimumSize(new java.awt.Dimension(20, 7));
        jPanel7.setLayout(new java.awt.GridLayout(4, 0));

        jPanel10.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jPanel1.setPreferredSize(new java.awt.Dimension(450, 55));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 10, 5));

        lblIdent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIdent.setText("Identificación:");
        lblIdent.setToolTipText("");
        lblIdent.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIdent.setPreferredSize(new java.awt.Dimension(80, 50));
        jPanel1.add(lblIdent);

        txtId.setText(" ");
        txtId.setPreferredSize(new java.awt.Dimension(200, 50));
        jPanel1.add(txtId);

        jPanel10.add(jPanel1);

        jPanel3.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 25, 5));

        lblNombre.setText("Nombre:");
        lblNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jPanel3.add(lblNombre);

        txtNombre.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel3.add(txtNombre);

        lblApellido.setText("Apellido:");
        jPanel3.add(lblApellido);

        txtApellido.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel3.add(txtApellido);

        jPanel10.add(jPanel3);

        jPanel7.add(jPanel10);

        jPanel11.setLayout(new java.awt.GridLayout(2, 0));

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 10, 10));

        lblGeneroU.setText("Género:");
        jPanel4.add(lblGeneroU);

        rbFemenino.setText("Femenino");
        jPanel4.add(rbFemenino);

        rbMasculino.setText("Masculino");
        rbMasculino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMasculinoActionPerformed(evt);
            }
        });
        jPanel4.add(rbMasculino);

        jPanel11.add(jPanel4);

        lblUser.setText("User:");
        jPanel5.add(lblUser);

        txtUser.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel5.add(txtUser);

        jLabel13.setText("Clave Acceso:");
        jPanel5.add(jLabel13);

        txtPass.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        txtPass.setPreferredSize(new java.awt.Dimension(150, 50));
        jPanel5.add(txtPass);

        jPanel11.add(jPanel5);

        jPanel7.add(jPanel11);

        jPanel9.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 25, 5));

        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Fecha de Nacimiento:");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel9.add(jLabel11);

        fechaNac.setMinimumSize(new java.awt.Dimension(20, 7));
        fechaNac.setPreferredSize(new java.awt.Dimension(300, 150));
        jPanel9.add(fechaNac);

        jPanel7.add(jPanel9);

        jPanel6.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 5, 25));

        btnCrearVigi.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnCrearVigi.setText("Crear Vigilante");
        btnCrearVigi.setPreferredSize(new java.awt.Dimension(150, 50));
        btnCrearVigi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearVigiActionPerformed(evt);
            }
        });
        jPanel6.add(btnCrearVigi);

        jPanel7.add(jPanel6);

        jTabbedPane1.addTab("Gestión Vigilante", jPanel7);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearVigiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearVigiActionPerformed
        // TODO add your handling code here:
        String numeroid = txtId.getText().trim();
        String nombre = txtNombre.getText().trim().toUpperCase();
        String apellido = txtApellido.getText().trim().toUpperCase();
        String rol = "ADMINISTRATIVO";
        String user = txtUser.getText().trim();
        String pass = txtPass.getText().trim();
        String genero;
        if (rbFemenino.isSelected()) {
            genero = "FEMENINO";
        }
        else if (rbMasculino.isSelected()) {
            genero = "MASCULINO";
        }
        else
        {
            Utilidades.mensajeError("No ha seleccionado el Genero", "Gestión Vegilante");
            return;
        }

        String fechaNac = this.fechaNac.getCalendar().get(Calendar.DAY_OF_MONTH) + "-";
        fechaNac += this.fechaNac.getCalendar().get(Calendar.MONTH) + "-";
        fechaNac += this.fechaNac.getCalendar().get(Calendar.YEAR) + "";
        GestorVigilante gestor = new GestorVigilante();
        GestorClientes gestorCli = new GestorClientes();
        String info;

        info = String.format("%s,%s,%s,%s,%s,%s", numeroid, nombre, apellido, genero, fechaNac, rol);
        String respuesta = gestorCli.IngresarClienteCentral(info);
        if(!respuesta.equals("OK")){
            Utilidades.mensajeError("Errror al intentar crear el vigilante", "Gestión Vegilante");
            return;
        }
        info = String.format("%s,%s,%s", numeroid, user, pass);

        respuesta = gestor.insertarUsuario(info);
        if(!respuesta.equals("OK")){
            Utilidades.mensajeError("Error al intentar crear el vigilante", "Gestión Vigilante");
            return;
        }

        Utilidades.mensajeExito("Se registro un nuevo Vigilante en la central", "Gestión Vegilante");
    }//GEN-LAST:event_btnCrearVigiActionPerformed

    private void rbMasculinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMasculinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbMasculinoActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCrearVigi;
    private javax.swing.ButtonGroup btnGroup1;
    private com.toedter.calendar.JCalendar fechaNac;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblGeneroU;
    private javax.swing.JLabel lblIdent;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblUser;
    private javax.swing.JRadioButton rbFemenino;
    private javax.swing.JRadioButton rbMasculino;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPass;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actualizar(AModel arg0) {
    }
}