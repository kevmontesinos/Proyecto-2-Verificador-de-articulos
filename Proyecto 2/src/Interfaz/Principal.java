/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaz;

import javax.swing.JOptionPane;
import proyecto.pkg2.Funciones;
import proyecto.pkg2.HashTable;

/**
 *
 * @author Kevin
 */
public class Principal extends javax.swing.JFrame {

    boolean archivo;
    Funciones f;
    HashTable hashTable;

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        f = new Funciones();
        hashTable = new HashTable(10111);
        archivo = false;
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        leerDocumento = new javax.swing.JButton();
        contarRep = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        leerDocumento.setText("Leer documento");
        leerDocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leerDocumentoActionPerformed(evt);
            }
        });
        jPanel1.add(leerDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 160, -1));

        contarRep.setText("Contar repeticiones");
        contarRep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contarRepActionPerformed(evt);
            }
        });
        jPanel1.add(contarRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 160, -1));

        jButton3.setText("Buscar palabra");
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 160, -1));

        jButton4.setText("Verificar originalidad");
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 160, -1));

        jButton5.setText("Palabras más usadas");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, 160, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void leerDocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leerDocumentoActionPerformed
        String texto = f.leerTxtCargado();
        if (!texto.isBlank() || !texto.isEmpty()) {
            archivo = true;
            String[] array = f.soloPalabrasArray(texto);
            for (int i = 0; i < array.length; i++) {
                System.out.println("----");
                System.out.println(array[i]);
                hashTable.insertar(array[i].replace("\n","").replace(" ", ""));
            }

        } else {
            archivo = false;
        }
    }//GEN-LAST:event_leerDocumentoActionPerformed

    private void contarRepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contarRepActionPerformed
        if (archivo) {

            String repeticiones = hashTable.repeticiones();
            Repeticiones rep = new Repeticiones(repeticiones);
            
            
            //JOptionPane.showMessageDialog(null, repeticiones);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha cargado ningún documento");
        }
    }//GEN-LAST:event_contarRepActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton contarRep;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton leerDocumento;
    // End of variables declaration//GEN-END:variables
}