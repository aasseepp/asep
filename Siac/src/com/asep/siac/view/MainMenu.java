/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.asep.siac.view;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author user
 */
public class MainMenu extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        mFile = new javax.swing.JMenu();
        mAkademik = new javax.swing.JMenu();
        mnuMahasiswa = new javax.swing.JMenuItem();
        mBantuan = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().add(jDesktopPane1, java.awt.BorderLayout.CENTER);

        mFile.setText("File");
        jMenuBar1.add(mFile);

        mAkademik.setText("Akademik");

        mnuMahasiswa.setText("Mahasiswa");
        mnuMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuMahasiswaActionPerformed(evt);
            }
        });
        mAkademik.add(mnuMahasiswa);

        jMenuBar1.add(mAkademik);

        mBantuan.setText("Bantuan");
        jMenuBar1.add(mBantuan);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuMahasiswaActionPerformed
        // TODO add your handling code here:
        MahasiswaForm Form=new MahasiswaForm();
        jDesktopPane1.add(Form);
        Dimension scren=this.getSize();
        Dimension frame=Form.getSize();
        Form.setLocation((scren.width-frame.width)/2,(scren.height-frame.height)/2);
        Form.reload();
        Form.setVisible(true);
    }//GEN-LAST:event_mnuMahasiswaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu mAkademik;
    private javax.swing.JMenu mBantuan;
    private javax.swing.JMenu mFile;
    private javax.swing.JMenuItem mnuMahasiswa;
    // End of variables declaration//GEN-END:variables
}
