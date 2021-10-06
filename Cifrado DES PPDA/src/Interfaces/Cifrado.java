/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import javax.swing.JFileChooser;
import GestiondeTXT.Gestion;
import cifrado.des.ppda.CifradoDESPPDA;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author aza06
 */
public class Cifrado extends javax.swing.JFrame {

    /**
     * Creates new form Cifrado
     */
    JFileChooser seleccionado = new JFileChooser();
    File archivo;
    Gestion gestion = new Gestion();
    
    public Cifrado() {
        initComponents();
        this.setLocationRelativeTo(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Llave = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        mensajes = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Sitka Small", 1, 24)); // NOI18N
        jLabel2.setText("Cifrado");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel3.setText("Documento .txt:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Sitka Small", 1, 18)); // NOI18N
        jLabel4.setText("Ingrese una llave:");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, -1));

        Llave.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        getContentPane().add(Llave, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 170, -1));

        jButton1.setBackground(new java.awt.Color(255, 102, 51));
        jButton1.setFont(new java.awt.Font("Sitka Small", 1, 12)); // NOI18N
        jButton1.setText("Seleccionar archivo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 160, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 380, -1));

        jLabel5.setText("-");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 100, -1));

        jButton2.setBackground(new java.awt.Color(255, 204, 153));
        jButton2.setText("Regresar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton3.setBackground(new java.awt.Color(255, 153, 102));
        jButton3.setFont(new java.awt.Font("Sitka Small", 0, 14)); // NOI18N
        jButton3.setText("Cifrar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 110, -1, -1));

        mensajes.setForeground(new java.awt.Color(255, 255, 255));
        mensajes.setText("-");
        getContentPane().add(mensajes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 450, 20));

        fondo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/images_1.png"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        if(seleccionado.showDialog(this, "Seleccionar") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.canRead()){
                if(archivo.getName().endsWith("txt")){
                    String contenido = gestion.AbrirATexto(archivo);
                    jTextArea1.setText(contenido);
                    jLabel5.setText(archivo.getName());
                }else{
                    mensajes.setText("Este no es archivo de texto");
                }
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
       boolean Bandera = true;
        String checarClave = Llave.getText();
        int NumeroCaracteres = 0;
        if (checarClave.length() != 8) {
            Bandera = false;
            NumeroCaracteres = 8;
        }
        if (!Bandera) {
             mensajes.setText("La clabe debe tener: " + NumeroCaracteres + " Caracteres");
            return;
        }
        if (Llave.getText().isEmpty() || jTextArea1.getText().isEmpty() || jLabel5.getText().isEmpty()) {
             mensajes.setText("Hay algun campo vacio");
        }else{
        CifradoDESPPDA log = new CifradoDESPPDA();
        jTextArea1.setText(log.Cifrado(jTextArea1.getText(), Llave.getText()));
        
        if(seleccionado.showDialog(null, "Cifrar y guardar") == JFileChooser.APPROVE_OPTION){
            archivo = seleccionado.getSelectedFile();
            if(archivo.getName().endsWith("txt")){
                String contenido = jTextArea1.getText();
                String respuesta = gestion.GuardarATexto(archivo, contenido);
                if(respuesta != null){
                     mensajes.setText(respuesta);
                }else{
                     mensajes.setText("Error aL guardar texto");
                }
            }else{
                 mensajes.setText("El texto se debe etsar en txt");
            }
        }
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        Menu ir = new Menu();
        ir.setVisible(true);
        this.setVisible(false);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cifrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cifrado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Llave;
    private javax.swing.JLabel fondo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel mensajes;
    // End of variables declaration//GEN-END:variables
}