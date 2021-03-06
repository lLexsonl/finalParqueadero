package parqueadero.presentacion;

import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import mvcf.AModel;
import mvcf.AView;
import parqueadero.negocio.GestorClientes;
import parqueadero.negocio.Ingreso;
import parqueadero.utils.Utilidades;
/**
 *
 * @author Yerson
 */
public class GUIMapaParqueadero extends javax.swing.JFrame implements AView {

    /**
     * Creates new form GUIMapaParqueadero
     */
    public GUIMapaParqueadero() {
        initComponents();
        initButtons();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMapa = new javax.swing.JPanel();
        pnlSuperiorGeneral = new javax.swing.JPanel();
        pnlBotonLibre = new javax.swing.JPanel();
        btnOcupado = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        btnLibre = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        pnlSupIzq = new javax.swing.JPanel();
        pnlResidencias = new javax.swing.JPanel();
        pnlCentralGeneral = new javax.swing.JPanel();
        pnlViaDerVert = new javax.swing.JPanel();
        pnlViaSupHori = new javax.swing.JPanel();
        pnlViaIzqVer = new javax.swing.JPanel();
        pnlViaInfHori = new javax.swing.JPanel();
        pnlCentralP = new javax.swing.JPanel();
        pnlIzqCentralP = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        zonaUno1 = new javax.swing.JPanel();
        Z1A_01 = new javax.swing.JButton();
        Z1A_02 = new javax.swing.JButton();
        Z1A_03 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        zonaUno2 = new javax.swing.JPanel();
        Z1A_04 = new javax.swing.JButton();
        Z1A_05 = new javax.swing.JButton();
        Z1A_06 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        zonaDos1 = new javax.swing.JPanel();
        Z2A_07 = new javax.swing.JButton();
        Z2A_08 = new javax.swing.JButton();
        Z2A_09 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        zonaDos2 = new javax.swing.JPanel();
        Z2A_10 = new javax.swing.JButton();
        Z2A_11 = new javax.swing.JButton();
        Z2A_12 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        pnlCentralFIET = new javax.swing.JPanel();
        pnlCentralDer = new javax.swing.JPanel();
        zonaTres0 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        zonaTres1 = new javax.swing.JPanel();
        Z3A_13 = new javax.swing.JButton();
        Z3A_14 = new javax.swing.JButton();
        Z3A_15 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        zonaTres2 = new javax.swing.JPanel();
        Z3A_16 = new javax.swing.JButton();
        Z3A_17 = new javax.swing.JButton();
        Z3A_18 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        zonaTres3 = new javax.swing.JPanel();
        Z3A_19 = new javax.swing.JButton();
        Z3A_20 = new javax.swing.JButton();
        Z3A_21 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        zonaTres4 = new javax.swing.JPanel();
        Z3A_22 = new javax.swing.JButton();
        Z3A_23 = new javax.swing.JButton();
        Z3A_24 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        pnlCentralMotos = new javax.swing.JPanel();
        zonaMotosVacia = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        zonaMotos = new javax.swing.JPanel();
        zonaCuatro0 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        Z4M_25 = new javax.swing.JButton();
        Z4M_26 = new javax.swing.JButton();
        Z4M_27 = new javax.swing.JButton();
        zonaCuatro1 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        Z4M_28 = new javax.swing.JButton();
        Z4M_29 = new javax.swing.JButton();
        Z4M_30 = new javax.swing.JButton();
        zonaCuatro2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        Z4M_31 = new javax.swing.JButton();
        Z4M_32 = new javax.swing.JButton();
        Z4M_33 = new javax.swing.JButton();
        zonaCuatro3 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        Z4M_34 = new javax.swing.JButton();
        Z4M_35 = new javax.swing.JButton();
        Z4M_36 = new javax.swing.JButton();
        zonaCuatro4 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Z4M_37 = new javax.swing.JButton();
        Z4M_38 = new javax.swing.JButton();
        Z4M_39 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mapa");
        setLocation(new java.awt.Point(750, 50));
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnlMapa.setPreferredSize(new java.awt.Dimension(600, 500));
        pnlMapa.setLayout(new java.awt.BorderLayout());

        pnlSuperiorGeneral.setPreferredSize(new java.awt.Dimension(400, 60));
        pnlSuperiorGeneral.setLayout(new java.awt.BorderLayout(15, 0));

        pnlBotonLibre.setMinimumSize(new java.awt.Dimension(0, 0));
        pnlBotonLibre.setPreferredSize(new java.awt.Dimension(110, 75));
        pnlBotonLibre.setLayout(new java.awt.GridLayout(3, 2));

        btnOcupado.setBackground(new java.awt.Color(51, 255, 51));
        btnOcupado.setMinimumSize(new java.awt.Dimension(1, 1));
        pnlBotonLibre.add(btnOcupado);

        jLabel24.setForeground(new java.awt.Color(51, 51, 51));
        jLabel24.setText("Ocupado");
        jLabel24.setOpaque(true);
        pnlBotonLibre.add(jLabel24);

        btnLibre.setMinimumSize(new java.awt.Dimension(1, 1));
        pnlBotonLibre.add(btnLibre);

        jLabel25.setForeground(new java.awt.Color(51, 51, 51));
        jLabel25.setText("Libre");
        jLabel25.setOpaque(true);
        pnlBotonLibre.add(jLabel25);

        pnlSuperiorGeneral.add(pnlBotonLibre, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout pnlSupIzqLayout = new javax.swing.GroupLayout(pnlSupIzq);
        pnlSupIzq.setLayout(pnlSupIzqLayout);
        pnlSupIzqLayout.setHorizontalGroup(
            pnlSupIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        pnlSupIzqLayout.setVerticalGroup(
            pnlSupIzqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlSuperiorGeneral.add(pnlSupIzq, java.awt.BorderLayout.LINE_START);

        pnlResidencias.setBackground(new java.awt.Color(0, 153, 153));
        pnlResidencias.setPreferredSize(new java.awt.Dimension(370, 75));

        javax.swing.GroupLayout pnlResidenciasLayout = new javax.swing.GroupLayout(pnlResidencias);
        pnlResidencias.setLayout(pnlResidenciasLayout);
        pnlResidenciasLayout.setHorizontalGroup(
            pnlResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 364, Short.MAX_VALUE)
        );
        pnlResidenciasLayout.setVerticalGroup(
            pnlResidenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 60, Short.MAX_VALUE)
        );

        pnlSuperiorGeneral.add(pnlResidencias, java.awt.BorderLayout.CENTER);

        pnlMapa.add(pnlSuperiorGeneral, java.awt.BorderLayout.PAGE_START);

        pnlCentralGeneral.setLayout(new java.awt.BorderLayout());

        pnlViaDerVert.setBackground(new java.awt.Color(51, 51, 51));
        pnlViaDerVert.setPreferredSize(new java.awt.Dimension(40, 285));

        javax.swing.GroupLayout pnlViaDerVertLayout = new javax.swing.GroupLayout(pnlViaDerVert);
        pnlViaDerVert.setLayout(pnlViaDerVertLayout);
        pnlViaDerVertLayout.setHorizontalGroup(
            pnlViaDerVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlViaDerVertLayout.setVerticalGroup(
            pnlViaDerVertLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pnlCentralGeneral.add(pnlViaDerVert, java.awt.BorderLayout.LINE_END);

        pnlViaSupHori.setBackground(new java.awt.Color(51, 51, 51));
        pnlViaSupHori.setPreferredSize(new java.awt.Dimension(600, 40));

        javax.swing.GroupLayout pnlViaSupHoriLayout = new javax.swing.GroupLayout(pnlViaSupHori);
        pnlViaSupHori.setLayout(pnlViaSupHoriLayout);
        pnlViaSupHoriLayout.setHorizontalGroup(
            pnlViaSupHoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        pnlViaSupHoriLayout.setVerticalGroup(
            pnlViaSupHoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        pnlCentralGeneral.add(pnlViaSupHori, java.awt.BorderLayout.PAGE_START);

        pnlViaIzqVer.setBackground(new java.awt.Color(51, 51, 51));
        pnlViaIzqVer.setPreferredSize(new java.awt.Dimension(40, 335));

        javax.swing.GroupLayout pnlViaIzqVerLayout = new javax.swing.GroupLayout(pnlViaIzqVer);
        pnlViaIzqVer.setLayout(pnlViaIzqVerLayout);
        pnlViaIzqVerLayout.setHorizontalGroup(
            pnlViaIzqVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );
        pnlViaIzqVerLayout.setVerticalGroup(
            pnlViaIzqVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pnlCentralGeneral.add(pnlViaIzqVer, java.awt.BorderLayout.LINE_START);

        pnlViaInfHori.setBackground(new java.awt.Color(51, 51, 51));
        pnlViaInfHori.setPreferredSize(new java.awt.Dimension(600, 50));

        javax.swing.GroupLayout pnlViaInfHoriLayout = new javax.swing.GroupLayout(pnlViaInfHori);
        pnlViaInfHori.setLayout(pnlViaInfHoriLayout);
        pnlViaInfHoriLayout.setHorizontalGroup(
            pnlViaInfHoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );
        pnlViaInfHoriLayout.setVerticalGroup(
            pnlViaInfHoriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        pnlCentralGeneral.add(pnlViaInfHori, java.awt.BorderLayout.PAGE_END);

        pnlCentralP.setLayout(new java.awt.GridLayout(1, 4));

        pnlIzqCentralP.setLayout(new java.awt.GridLayout(10, 1));
        pnlIzqCentralP.add(jLabel9);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        pnlIzqCentralP.add(jLabel1);
        pnlIzqCentralP.add(jLabel2);

        jLabel3.setBackground(new java.awt.Color(51, 51, 51));
        jLabel3.setOpaque(true);
        pnlIzqCentralP.add(jLabel3);

        zonaUno1.setLayout(new java.awt.GridLayout(1, 0));
        zonaUno1.add(Z1A_01);
        zonaUno1.add(Z1A_02);
        zonaUno1.add(Z1A_03);

        jLabel4.setBackground(new java.awt.Color(51, 51, 51));
        jLabel4.setOpaque(true);
        zonaUno1.add(jLabel4);

        pnlIzqCentralP.add(zonaUno1);

        zonaUno2.setLayout(new java.awt.GridLayout(1, 0));
        zonaUno2.add(Z1A_04);
        zonaUno2.add(Z1A_05);
        zonaUno2.add(Z1A_06);

        jLabel5.setBackground(new java.awt.Color(51, 51, 51));
        jLabel5.setOpaque(true);
        zonaUno2.add(jLabel5);

        pnlIzqCentralP.add(zonaUno2);

        jLabel6.setBackground(new java.awt.Color(51, 51, 51));
        jLabel6.setOpaque(true);
        pnlIzqCentralP.add(jLabel6);

        zonaDos1.setLayout(new java.awt.GridLayout(1, 0));
        zonaDos1.add(Z2A_07);
        zonaDos1.add(Z2A_08);
        zonaDos1.add(Z2A_09);

        jLabel7.setBackground(new java.awt.Color(51, 51, 51));
        jLabel7.setOpaque(true);
        zonaDos1.add(jLabel7);

        pnlIzqCentralP.add(zonaDos1);

        zonaDos2.setLayout(new java.awt.GridLayout(1, 0));
        zonaDos2.add(Z2A_10);
        zonaDos2.add(Z2A_11);
        zonaDos2.add(Z2A_12);

        jLabel8.setBackground(new java.awt.Color(51, 51, 51));
        jLabel8.setOpaque(true);
        zonaDos2.add(jLabel8);

        pnlIzqCentralP.add(zonaDos2);

        pnlCentralP.add(pnlIzqCentralP);

        pnlCentralFIET.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout pnlCentralFIETLayout = new javax.swing.GroupLayout(pnlCentralFIET);
        pnlCentralFIET.setLayout(pnlCentralFIETLayout);
        pnlCentralFIETLayout.setHorizontalGroup(
            pnlCentralFIETLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 131, Short.MAX_VALUE)
        );
        pnlCentralFIETLayout.setVerticalGroup(
            pnlCentralFIETLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );

        pnlCentralP.add(pnlCentralFIET);

        pnlCentralDer.setLayout(new java.awt.GridLayout(10, 1));

        zonaTres0.setLayout(new java.awt.GridLayout(1, 0));
        zonaTres0.add(jLabel16);

        jLabel17.setBackground(new java.awt.Color(51, 51, 51));
        jLabel17.setOpaque(true);
        zonaTres0.add(jLabel17);
        zonaTres0.add(jLabel18);
        zonaTres0.add(jLabel19);

        pnlCentralDer.add(zonaTres0);

        zonaTres1.setLayout(new java.awt.GridLayout(1, 0));
        zonaTres1.add(Z3A_13);
        zonaTres1.add(Z3A_14);
        zonaTres1.add(Z3A_15);
        zonaTres1.add(jLabel11);

        pnlCentralDer.add(zonaTres1);

        zonaTres2.setLayout(new java.awt.GridLayout(1, 0));
        zonaTres2.add(Z3A_16);
        zonaTres2.add(Z3A_17);
        zonaTres2.add(Z3A_18);
        zonaTres2.add(jLabel12);

        pnlCentralDer.add(zonaTres2);

        zonaTres3.setLayout(new java.awt.GridLayout(1, 0));
        zonaTres3.add(Z3A_19);
        zonaTres3.add(Z3A_20);
        zonaTres3.add(Z3A_21);
        zonaTres3.add(jLabel13);

        pnlCentralDer.add(zonaTres3);

        zonaTres4.setLayout(new java.awt.GridLayout(1, 0));
        zonaTres4.add(Z3A_22);
        zonaTres4.add(Z3A_23);
        zonaTres4.add(Z3A_24);
        zonaTres4.add(jLabel14);

        pnlCentralDer.add(zonaTres4);

        pnlCentralP.add(pnlCentralDer);

        pnlCentralMotos.setLayout(new java.awt.GridLayout(2, 1));

        zonaMotosVacia.setLayout(new java.awt.BorderLayout());

        jLabel15.setBackground(new java.awt.Color(51, 51, 51));
        jLabel15.setOpaque(true);
        jLabel15.setPreferredSize(new java.awt.Dimension(131, 40));
        zonaMotosVacia.add(jLabel15, java.awt.BorderLayout.PAGE_END);

        pnlCentralMotos.add(zonaMotosVacia);

        zonaMotos.setLayout(new java.awt.GridLayout(5, 0));

        zonaCuatro0.setLayout(new java.awt.GridLayout(1, 0));
        zonaCuatro0.add(jLabel20);
        zonaCuatro0.add(Z4M_25);
        zonaCuatro0.add(Z4M_26);
        zonaCuatro0.add(Z4M_27);

        zonaMotos.add(zonaCuatro0);

        zonaCuatro1.setLayout(new java.awt.GridLayout(1, 0));
        zonaCuatro1.add(jLabel21);
        zonaCuatro1.add(Z4M_28);
        zonaCuatro1.add(Z4M_29);
        zonaCuatro1.add(Z4M_30);

        zonaMotos.add(zonaCuatro1);

        zonaCuatro2.setLayout(new java.awt.GridLayout(1, 0));
        zonaCuatro2.add(jLabel10);
        zonaCuatro2.add(Z4M_31);
        zonaCuatro2.add(Z4M_32);
        zonaCuatro2.add(Z4M_33);

        zonaMotos.add(zonaCuatro2);

        zonaCuatro3.setLayout(new java.awt.GridLayout(1, 0));
        zonaCuatro3.add(jLabel22);
        zonaCuatro3.add(Z4M_34);
        zonaCuatro3.add(Z4M_35);
        zonaCuatro3.add(Z4M_36);

        zonaMotos.add(zonaCuatro3);

        zonaCuatro4.setLayout(new java.awt.GridLayout(1, 0));
        zonaCuatro4.add(jLabel23);
        zonaCuatro4.add(Z4M_37);
        zonaCuatro4.add(Z4M_38);
        zonaCuatro4.add(Z4M_39);

        zonaMotos.add(zonaCuatro4);

        pnlCentralMotos.add(zonaMotos);

        pnlCentralP.add(pnlCentralMotos);

        pnlCentralGeneral.add(pnlCentralP, java.awt.BorderLayout.CENTER);

        pnlMapa.add(pnlCentralGeneral, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnlMapa);

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
    /*
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIMapaParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIMapaParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIMapaParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIMapaParqueadero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }*/
        //</editor-fold>

        /* Create and display the form */
    /*
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMapaParqueadero().setVisible(true);
            }
        });
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Z1A_01;
    private javax.swing.JButton Z1A_02;
    private javax.swing.JButton Z1A_03;
    private javax.swing.JButton Z1A_04;
    private javax.swing.JButton Z1A_05;
    private javax.swing.JButton Z1A_06;
    private javax.swing.JButton Z2A_07;
    private javax.swing.JButton Z2A_08;
    private javax.swing.JButton Z2A_09;
    private javax.swing.JButton Z2A_10;
    private javax.swing.JButton Z2A_11;
    private javax.swing.JButton Z2A_12;
    private javax.swing.JButton Z3A_13;
    private javax.swing.JButton Z3A_14;
    private javax.swing.JButton Z3A_15;
    private javax.swing.JButton Z3A_16;
    private javax.swing.JButton Z3A_17;
    private javax.swing.JButton Z3A_18;
    private javax.swing.JButton Z3A_19;
    private javax.swing.JButton Z3A_20;
    private javax.swing.JButton Z3A_21;
    private javax.swing.JButton Z3A_22;
    private javax.swing.JButton Z3A_23;
    private javax.swing.JButton Z3A_24;
    private javax.swing.JButton Z4M_25;
    private javax.swing.JButton Z4M_26;
    private javax.swing.JButton Z4M_27;
    private javax.swing.JButton Z4M_28;
    private javax.swing.JButton Z4M_29;
    private javax.swing.JButton Z4M_30;
    private javax.swing.JButton Z4M_31;
    private javax.swing.JButton Z4M_32;
    private javax.swing.JButton Z4M_33;
    private javax.swing.JButton Z4M_34;
    private javax.swing.JButton Z4M_35;
    private javax.swing.JButton Z4M_36;
    private javax.swing.JButton Z4M_37;
    private javax.swing.JButton Z4M_38;
    private javax.swing.JButton Z4M_39;
    private javax.swing.JButton btnLibre;
    private javax.swing.JButton btnOcupado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlBotonLibre;
    private javax.swing.JPanel pnlCentralDer;
    private javax.swing.JPanel pnlCentralFIET;
    private javax.swing.JPanel pnlCentralGeneral;
    private javax.swing.JPanel pnlCentralMotos;
    private javax.swing.JPanel pnlCentralP;
    private javax.swing.JPanel pnlIzqCentralP;
    private javax.swing.JPanel pnlMapa;
    private javax.swing.JPanel pnlResidencias;
    private javax.swing.JPanel pnlSupIzq;
    private javax.swing.JPanel pnlSuperiorGeneral;
    private javax.swing.JPanel pnlViaDerVert;
    private javax.swing.JPanel pnlViaInfHori;
    private javax.swing.JPanel pnlViaIzqVer;
    private javax.swing.JPanel pnlViaSupHori;
    private javax.swing.JPanel zonaCuatro0;
    private javax.swing.JPanel zonaCuatro1;
    private javax.swing.JPanel zonaCuatro2;
    private javax.swing.JPanel zonaCuatro3;
    private javax.swing.JPanel zonaCuatro4;
    private javax.swing.JPanel zonaDos1;
    private javax.swing.JPanel zonaDos2;
    private javax.swing.JPanel zonaMotos;
    private javax.swing.JPanel zonaMotosVacia;
    private javax.swing.JPanel zonaTres0;
    private javax.swing.JPanel zonaTres1;
    private javax.swing.JPanel zonaTres2;
    private javax.swing.JPanel zonaTres3;
    private javax.swing.JPanel zonaTres4;
    private javax.swing.JPanel zonaUno1;
    private javax.swing.JPanel zonaUno2;
    // End of variables declaration//GEN-END:variables

    //<editor-fold defaultstate="collapsed" desc="initButtons">
    
    private void initButtons() {
        listButtons = new ArrayList<>();
        //Zona 1
        listButtons.add(Z1A_01);
        listButtons.add(Z1A_02);
        listButtons.add(Z1A_03);
        listButtons.add(Z1A_04);
        listButtons.add(Z1A_05);
        listButtons.add(Z1A_06);
        //Zona 2
        listButtons.add(Z2A_07);
        listButtons.add(Z2A_08);
        listButtons.add(Z2A_09);
        listButtons.add(Z2A_10);
        listButtons.add(Z2A_11);
        listButtons.add(Z2A_12);
        //Zona 3
        listButtons.add(Z3A_13);
        listButtons.add(Z3A_14);
        listButtons.add(Z3A_15);
        listButtons.add(Z3A_16);
        listButtons.add(Z3A_17);
        listButtons.add(Z3A_18);
        listButtons.add(Z3A_19);
        listButtons.add(Z3A_20);
        listButtons.add(Z3A_21);
        listButtons.add(Z3A_22);
        listButtons.add(Z3A_23);
        listButtons.add(Z3A_24);
        //Zona 4
        listButtons.add(Z4M_25);
        listButtons.add(Z4M_26);
        listButtons.add(Z4M_27);
        listButtons.add(Z4M_28);
        listButtons.add(Z4M_29);
        listButtons.add(Z4M_30);
        listButtons.add(Z4M_31);
        listButtons.add(Z4M_32);
        listButtons.add(Z4M_33);
        listButtons.add(Z4M_34);
        listButtons.add(Z4M_35);
        listButtons.add(Z4M_36);
        listButtons.add(Z4M_37);
        listButtons.add(Z4M_38);
        listButtons.add(Z4M_39);
    }
    //</editor-fold>
    
    List<JButton> listButtons;

    @Override
    public void actualizar(AModel amodel) {
        System.out.println("Actualizar mapa");
        listButtons.forEach(b->b.setBackground(new Color(240,240,240)));
        GestorClientes gestor = (GestorClientes) amodel;

        try {
            List<Ingreso> list = gestor.buscarIngresosCentral();
            if(list != null) {
                list.forEach((i) -> {
                listButtons.get(Integer.parseInt(i.getPuesto().split("_")[1])-1).setBackground(Color.GREEN);
            });
            pnlMapa.updateUI();
            }
        } catch (ClassNotFoundException | SQLException e) {
            //System.out.println(e.getMessage());
            Utilidades.mensajeError("Error al actualizar el parqueadero", "Actualizar Mapa");
        }
        
        /*
        System.out.println("actualizar mapa");
        GestorClientes gestor = (GestorClientes) amodel;
        //String date = Utilidades.fechaAcual();
        ArrayList<String> list = null;
        try {
        list = gestor.consultarAsignacionesDefault();
        //list = gestor.consultarAsignaciones(date);
        } catch (ClassNotFoundException | SQLException e) {
        System.out.println("Error consulta asignar: \n" + e.getMessage());
        }
        if (list == null) {
        Utilidades.mensajeAdvertencia("La lista es NULA", "Asignación de Lugares");
        } else if (list.isEmpty()) {
        Utilidades.mensajeAdvertencia("NO hay lugares asignados", "Asignación de Lugares");
        } else {
        for (String str : list) {
        String[] array = str.split(",");
        listButtons.get(Integer.parseInt(array[1]) - 1).setBackground(Color.GREEN);
        }
        }*/
        
    }
}
