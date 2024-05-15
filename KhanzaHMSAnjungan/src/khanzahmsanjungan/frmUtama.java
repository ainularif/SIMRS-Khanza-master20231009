/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmUtama.java
 *
 * Created on 04 Des 13, 11:19:32
 */
package khanzahmsanjungan;

import fungsi.sekuel;
import fungsi.validasi;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class frmUtama extends javax.swing.JFrame {
    private final sekuel Sequel=new sekuel();
    private final validasi Valid=new validasi();
    private String validasiregistrasi=Sequel.cariIsi("select set_validasi_registrasi.wajib_closing_kasir from set_validasi_registrasi");
        
    /** Creates new form frmUtama */
    public frmUtama() {
        initComponents();
        setIconImage(new ImageIcon(super.getClass().getResource("/picture/addressbook-edit24.png")).getImage());      
        this.setSize(screen.width,screen.height);
    }    
    private final Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();  
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new component.Panel();
        jLabel1 = new component.Label();
        jLabel2 = new component.Label();
        jPanel3 = new component.Panel();
        jLabel3 = new component.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::[ SIMRS KhanzaHMS, Sub Menu Anjungan Registrasi Mandiri Pasien ]::");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(130, 50, 130));
        jPanel1.setBorder(null);
        jPanel1.setPreferredSize(new java.awt.Dimension(560, 55));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setForeground(new java.awt.Color(254, 184, 254));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/48x48/folder.png"))); // NOI18N
        jLabel1.setText("Anjungan Registrasi Mandiri, Silahkan Scan Kartu Pasien Anda !!!");
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIconTextGap(10);
        jLabel1.setPreferredSize(new java.awt.Dimension(650, 135));
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        jLabel2.setPreferredSize(new java.awt.Dimension(20, 10));
        jPanel1.add(jLabel2, java.awt.BorderLayout.LINE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(130, 50, 130));
        jPanel3.setBorder(null);
        jPanel3.setPreferredSize(new java.awt.Dimension(560, 30));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel3.setForeground(new java.awt.Color(254, 184, 254));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Dikembangkan Oleh Khanza.Soft Media, Email : khanza_media@yahoo.com, Skype : khanza.media, HP : 08562675039");
        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jPanel3.add(jLabel3, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        TCari.setText("");
    }//GEN-LAST:event_formWindowActivated

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmUtama().setVisible(true);
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private component.Label jLabel1;
    private component.Label jLabel2;
    private component.Label jLabel3;
    private component.Panel jPanel1;
    private component.Panel jPanel3;
    // End of variables declaration//GEN-END:variables
}
