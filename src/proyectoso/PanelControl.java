/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoso;

import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author luismanzano
 * @author Leonardo Gonzalez
 */
public class PanelControl extends javax.swing.JFrame {
    
    /*
    Imports necesarios para actualizar la informacion en la interfaz grafica
    */
    Controlador control = new Controlador();
    
//    Productor_botones boton = new Productor_botones();
    
    private int cant_botones = Productor_botones.botones;
    private int almacen_botones = Productor_botones.almacen_botones;
    private int cant_productores_boton = Productor_botones.productores_botones;
    
//    Productor_pantallas pantalla = new Productor_pantallas();
    
    private int cant_pantallas_normales = Productor_pantallas.pantallas_normales;
    private int cant_pantallas_tactiles = Productor_pantallas.pantallas_tactiles;
    private int cant_prouctores_pantallas = Productor_pantallas.productores_pantallas;
    private int almacen_pantallas = Productor_pantallas.almacen_pantallas;
    
//    Productor_joysticks joysticks = new Productor_joysticks();
    
    private int cant_joysticks = Productor_joysticks.joysticks;
    private int almacen_joysticks = Productor_joysticks.almacen_joysticks;
    private int cant_productores_joysticks = Productor_joysticks.productores_joysticks;
    
//    Productor_SD SD = new Productor_SD();
    
    private int cant_sd = Productor_SD.SD;
    private int almacen_sd = Productor_SD.almacen_SD;
    private int cant_productores_sd = Productor_SD.productores_SD;
    
    
    private int cant_Ensambladores = Ensamblador.ensambladores;
    private int cant_consolas = Ensamblador.consolas_listas;
    
    /**
     * Creates new form PanelControl
     */
    public PanelControl() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        duracionDia = new javax.swing.JSpinner();
        jTextField1 = new javax.swing.JTextField();
        startProgram = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cantBotonesText = new javax.swing.JLabel();
        cantPantallasText = new javax.swing.JLabel();
        cantPTactilText = new javax.swing.JLabel();
        cantJoystickText = new javax.swing.JLabel();
        cantSDText = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cantProductorBotones = new javax.swing.JLabel();
        cantProductorPantalla = new javax.swing.JLabel();
        cantProductorPTactil = new javax.swing.JLabel();
        cantProductorJoystick = new javax.swing.JLabel();
        cantProductorSD = new javax.swing.JLabel();
        consolasTerminadasText = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cantEnsambladorText = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        statusJefeText = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        statusGerenteText = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        diasLanzamientoText = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        almacenBoton = new javax.swing.JLabel();
        almacenPantalla = new javax.swing.JLabel();
        almacenPantallaTactil = new javax.swing.JLabel();
        almacenJoystick = new javax.swing.JLabel();
        almacenSD = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("Duracion del dia (ms)");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        startProgram.setText("Iniciar");
        startProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startProgramActionPerformed(evt);
            }
        });

        jLabel1.setText("Productores");

        jLabel2.setText("Botones");

        jLabel3.setText("Pantalla normal");

        jLabel4.setText("Pantalla tactil");

        jLabel5.setText("Joystick");

        jLabel6.setText("Tarjeta SD");

        jLabel7.setText("Producidos");

        cantBotonesText.setText("0");

        cantPantallasText.setText("0");

        cantPTactilText.setText("0");

        cantJoystickText.setText("0");

        cantSDText.setText("0");

        jLabel8.setText("Productores activos");

        cantProductorBotones.setText("0");
        cantProductorBotones.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cantProductorBotonesPropertyChange(evt);
            }
        });

        cantProductorPantalla.setText("0");

        cantProductorPTactil.setText("0");

        cantProductorJoystick.setText("0");

        cantProductorSD.setText("0");

        consolasTerminadasText.setText("0");

        jLabel9.setText("Consolas Terminadas:");

        jLabel10.setText("Cantidad Ensamblador");

        cantEnsambladorText.setText("0");

        jLabel11.setText("Status Jefe");

        statusJefeText.setText("n/a");

        jLabel12.setText("Status Gerente:");

        statusGerenteText.setText("n/a");

        jLabel13.setText("Dias para lanzamiento");

        diasLanzamientoText.setText("0");

        jLabel14.setText("Espacio en almacen");

        almacenBoton.setText("0");

        almacenPantalla.setText("0");

        almacenPantallaTactil.setText("0");

        almacenJoystick.setText("0");

        almacenSD.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(duracionDia, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(267, 267, 267)
                        .addComponent(startProgram)))
                .addContainerGap(351, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cantProductorPantalla)
                                    .addComponent(cantProductorBotones)
                                    .addComponent(cantProductorPTactil)
                                    .addComponent(cantProductorJoystick)
                                    .addComponent(cantProductorSD))
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantBotonesText)
                                    .addComponent(cantPantallasText)
                                    .addComponent(cantPTactilText)
                                    .addComponent(cantJoystickText)
                                    .addComponent(cantSDText))
                                .addGap(102, 102, 102)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(almacenSD)
                                    .addComponent(almacenJoystick)
                                    .addComponent(almacenPantallaTactil)
                                    .addComponent(almacenPantalla)
                                    .addComponent(almacenBoton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel10))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cantEnsambladorText)
                                    .addComponent(consolasTerminadasText)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel14)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(statusJefeText)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(statusGerenteText)
                        .addContainerGap(292, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(diasLanzamientoText)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(duracionDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(startProgram)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(statusJefeText)
                    .addComponent(jLabel12)
                    .addComponent(statusGerenteText))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(diasLanzamientoText))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(cantEnsambladorText))
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(consolasTerminadasText)
                            .addComponent(jLabel9))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cantSDText)
                            .addComponent(cantProductorSD)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cantBotonesText)
                            .addComponent(cantProductorBotones)
                            .addComponent(almacenBoton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cantPantallasText)
                            .addComponent(cantProductorPantalla)
                            .addComponent(almacenPantalla))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cantPTactilText)
                            .addComponent(cantProductorPTactil)
                            .addComponent(almacenPantallaTactil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(cantJoystickText)
                            .addComponent(cantProductorJoystick)
                            .addComponent(almacenJoystick))
                        .addGap(18, 18, 18)
                        .addComponent(almacenSD)))
                .addGap(75, 75, 75))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void startProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startProgramActionPerformed
                        // TODO add your handling code here:
            statusJefeText.setText("Durmiendo");
            statusGerenteText.setText("Activo");
            cantProductorBotones.setText(Integer.toString(cant_productores_boton));
            cantBotonesText.setText(Integer.toString(cant_botones));
            almacenBoton.setText(Integer.toString(almacen_botones));
            cantProductorPantalla.setText(Integer.toString(cant_prouctores_pantallas));
            cantProductorPTactil.setText(Integer.toString(cant_prouctores_pantallas));
            cantPantallasText.setText(Integer.toString(cant_pantallas_normales));
            cantPTactilText.setText(Integer.toString(cant_pantallas_tactiles));
            almacenPantalla.setText(Integer.toString(almacen_pantallas));
            almacenPantallaTactil.setText(Integer.toString(almacen_pantallas));
            cantJoystickText.setText(Integer.toString(cant_joysticks));
            cantProductorJoystick.setText(Integer.toString(cant_productores_joysticks));
            consolasTerminadasText.setText(Integer.toString(cant_consolas));
            almacenJoystick.setText(Integer.toString(almacen_joysticks));
            cantSDText.setText(Integer.toString(cant_sd));
            cantProductorSD.setText(Integer.toString(cant_productores_sd));
            almacenSD.setText(Integer.toString(almacen_sd));
            cantEnsambladorText.setText(Integer.toHexString(cant_Ensambladores));
            consolasTerminadasText.setText(Integer.toHexString(cant_consolas));
            control.controlInicio();
    }//GEN-LAST:event_startProgramActionPerformed

    private void cantProductorBotonesPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cantProductorBotonesPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cantProductorBotonesPropertyChange

    /**
     * @param args the command line arguments
     */
     /*ELEMENTOS DEL MAIN*/
//    public static volatile int contador_global = 0;
     /*la cantidad de botones que se estan generando */
//    public static volatile int cantidad_botones = 0;
    
    /* Metodos para actualizar los labels en la interfaz */
    public static void setEstadisticaConsolas(String consolas){
        consolasTerminadasText.setText(consolas);
    }
  
    
    public static void setEstadisticaBotones(String botones, String almacen){
        cantBotonesText.setText(botones);
        almacenBoton.setText(almacen);
    }
    
    public static void setEstadisticaPantallaNormal(String pantalla_normal , String almacen){
        cantPantallasText.setText(pantalla_normal);
        almacenPantalla.setText(almacen);
        almacenPantallaTactil.setText(almacen);
    }
    
    public static void setEstadisticaPantallaTactil(String pantalla_tactil , String almacen){
        cantPTactilText.setText(pantalla_tactil);
        almacenPantalla.setText(almacen);
        almacenPantallaTactil.setText(almacen);
    }
    
    public static void setEstadisticasJoysticks(String joysticks, String almacen){
        cantJoystickText.setText(joysticks);
        almacenJoystick.setText(almacen);
    }
    
    public static void setEstadisticasSD(String SD, String almacen){
        cantSDText.setText(SD);
        almacenSD.setText(almacen);
    }
    
    public static void main(String args[]) {
         
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PanelControl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PanelControl().setVisible(true);
            }
        });
    
    }

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JLabel almacenBoton;
    private static javax.swing.JLabel almacenJoystick;
    private static javax.swing.JLabel almacenPantalla;
    private static javax.swing.JLabel almacenPantallaTactil;
    private static javax.swing.JLabel almacenSD;
    private static javax.swing.JLabel cantBotonesText;
    private static javax.swing.JLabel cantEnsambladorText;
    private static javax.swing.JLabel cantJoystickText;
    private static javax.swing.JLabel cantPTactilText;
    private static javax.swing.JLabel cantPantallasText;
    private static javax.swing.JLabel cantProductorBotones;
    private static javax.swing.JLabel cantProductorJoystick;
    private static javax.swing.JLabel cantProductorPTactil;
    private static javax.swing.JLabel cantProductorPantalla;
    private static javax.swing.JLabel cantProductorSD;
    private static javax.swing.JLabel cantSDText;
    private static javax.swing.JLabel consolasTerminadasText;
    private static javax.swing.JLabel diasLanzamientoText;
    private javax.swing.JSpinner duracionDia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton startProgram;
    private static javax.swing.JLabel statusGerenteText;
    private static javax.swing.JLabel statusJefeText;
    // End of variables declaration//GEN-END:variables
}
