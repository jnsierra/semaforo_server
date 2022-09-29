/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.com.ud.semaforo.server.vista;

import co.com.ud.semaforo.server.logica.EnvioMensajesLogica;
import co.com.ud.semaforo.server.logica.ServerSemaforo;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author sierraj
 */
@Getter
@Setter
public class VistaServer extends javax.swing.JFrame {

    private SemaforoServerControlador semaforoServerControlador;
    private EjecucionCicloModel ejecucionCicloModel;
    
    private ServerSemaforo serverSemaforo;
    private EnvioMensajesLogica envioMensajesLogica;
    /**
     * Creates new form VistaServer
     */
    public VistaServer(ServerSemaforo serverSemaforo, EnvioMensajesLogica envioMensajesLogica) {
        this.serverSemaforo = serverSemaforo;
        this.envioMensajesLogica = envioMensajesLogica;
        if(Objects.isNull(this.semaforoServerControlador)){
            this.semaforoServerControlador = new SemaforoServerControlador(this, serverSemaforo, this.envioMensajesLogica);
        }
        if(Objects.isNull(this.ejecucionCicloModel)){
            this.ejecucionCicloModel = new EjecucionCicloModel(this, serverSemaforo, envioMensajesLogica);
        }
        initComponents();
        capturarEventos();
    }
    
    private void capturarEventos(){
        enviarMensaje.addActionListener(semaforoServerControlador);
        ejecutarInicioBtn.addActionListener(ejecucionCicloModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enviarMensaje = new javax.swing.JButton();
        msnTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        conectadosTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        idClienteText = new javax.swing.JTextField();
        ejecutarInicioBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Enviar Mensaje");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel2.setText("Mensaje: ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, -1, -1));

        enviarMensaje.setText("Enviar");
        enviarMensaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarMensajeActionPerformed(evt);
            }
        });
        getContentPane().add(enviarMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        msnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                msnTxtActionPerformed(evt);
            }
        });
        getContentPane().add(msnTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 100, -1));

        conectadosTextArea.setColumns(20);
        conectadosTextArea.setRows(5);
        jScrollPane1.setViewportView(conectadosTextArea);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 40, -1, -1));

        jLabel3.setText("Conectados");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, -1, -1));

        jLabel4.setText("Id Cliente:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        idClienteText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idClienteTextActionPerformed(evt);
            }
        });
        getContentPane().add(idClienteText, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 100, -1));

        ejecutarInicioBtn.setText("Ejecutar");
        ejecutarInicioBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ejecutarInicioBtnActionPerformed(evt);
            }
        });
        getContentPane().add(ejecutarInicioBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarMensajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarMensajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enviarMensajeActionPerformed

    private void msnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_msnTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_msnTxtActionPerformed

    private void idClienteTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idClienteTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idClienteTextActionPerformed

    private void ejecutarInicioBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ejecutarInicioBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ejecutarInicioBtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea conectadosTextArea;
    private javax.swing.JButton ejecutarInicioBtn;
    private javax.swing.JButton enviarMensaje;
    private javax.swing.JTextField idClienteText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField msnTxt;
    // End of variables declaration//GEN-END:variables
}
