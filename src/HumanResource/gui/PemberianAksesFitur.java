/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource.gui;

import HumanResource.Akses;
import Inventori.gui.RegistrasiKategori;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.DBConnector;
import Util.Table;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yestin
 */
public class PemberianAksesFitur extends javax.swing.JFrame {

    Akses Access = new Akses();
    Akses Acc[];
    public JCheckBox cbAkses = new JCheckBox();
    Table Tab = new Table();
    
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    BackgroundImage BI = new BackgroundImage();
    /**
     * Creates new form AksesFitur
     */
    public PemberianAksesFitur() {
        initComponents();
        setTitle("Pemberian Akses Fitur");
        
        BI.BackgroundJPanel(this, pnlAksesFitur);
        
        ftxtKodeOutlet.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAksesFitur = new javax.swing.JPanel();
        lblKodeUser = new javax.swing.JLabel();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        lblNamaLengkap = new javax.swing.JLabel();
        txtNamaLengkap = new javax.swing.JTextField();
        scrlAksesFitur = new javax.swing.JScrollPane();
        tblAksesFitur = new javax.swing.JTable();
        lblOutlet = new javax.swing.JLabel();
        txtOutlet = new javax.swing.JTextField();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        btnSelesai = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlAksesFitur.setForeground(new java.awt.Color(0, 0, 255));

        lblKodeUser.setBackground(new java.awt.Color(255, 255, 255));
        lblKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKodeUser.setForeground(new java.awt.Color(0, 0, 255));
        lblKodeUser.setText("Kode User :");
        lblKodeUser.setOpaque(true);

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtKodeUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtKodeUserActionPerformed(evt);
            }
        });

        lblNamaLengkap.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaLengkap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaLengkap.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaLengkap.setText("Nama Lengkap :");
        lblNamaLengkap.setOpaque(true);

        txtNamaLengkap.setEditable(false);
        txtNamaLengkap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaLengkap.setForeground(new java.awt.Color(0, 0, 255));
        txtNamaLengkap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaLengkapActionPerformed(evt);
            }
        });

        tblAksesFitur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblAksesFitur.setForeground(new java.awt.Color(0, 0, 255));
        scrlAksesFitur.setViewportView(tblAksesFitur);

        lblOutlet.setBackground(new java.awt.Color(255, 255, 255));
        lblOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOutlet.setForeground(new java.awt.Color(0, 0, 255));
        lblOutlet.setText("Outlet :");
        lblOutlet.setOpaque(true);

        txtOutlet.setEditable(false);
        txtOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtOutlet.setForeground(new java.awt.Color(0, 0, 255));

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSelesai.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Selesai.png"))); // NOI18N
        btnSelesai.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        btnSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelesaiActionPerformed(evt);
            }
        });

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Update.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAksesFiturLayout = new javax.swing.GroupLayout(pnlAksesFitur);
        pnlAksesFitur.setLayout(pnlAksesFiturLayout);
        pnlAksesFiturLayout.setHorizontalGroup(
            pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAksesFiturLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlAksesFiturLayout.createSequentialGroup()
                        .addComponent(lblKodeUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlAksesFiturLayout.createSequentialGroup()
                        .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamaLengkap)
                            .addComponent(lblOutlet))
                        .addGap(104, 104, 104)
                        .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNamaLengkap)
                            .addComponent(txtOutlet, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAksesFiturLayout.createSequentialGroup()
                .addContainerGap(340, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(40, 40, 40)
                .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(btnSelesai)
                .addGap(39, 39, 39))
            .addComponent(scrlAksesFitur)
        );
        pnlAksesFiturLayout.setVerticalGroup(
            pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAksesFiturLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKodeUser)
                    .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaLengkap)
                    .addComponent(txtNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutlet)
                    .addComponent(txtOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(scrlAksesFitur, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlAksesFiturLayout.createSequentialGroup()
                        .addComponent(btnRefresh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(103, 103, 103))
                    .addGroup(pnlAksesFiturLayout.createSequentialGroup()
                        .addGroup(pnlAksesFiturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btnSelesai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAksesFitur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlAksesFitur, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ftxtKodeUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtKodeUserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtKodeUserActionPerformed

    private void txtNamaLengkapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaLengkapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaLengkapActionPerformed

    private void btnSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelesaiActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnSelesaiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(tblAksesFitur.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Fitur Akses Belum Dipilih");
            return;
        }
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        int row = tblAksesFitur.getSelectedRow();
        int rows[] = tblAksesFitur.getSelectedRows();
        DefaultTableModel dtm = (DefaultTableModel)tblAksesFitur.getModel();
        String NamaFitur = (((String)dtm.getValueAt(row, 1)));

        int KodeAkses = Access.getKodeAkses(KodeUser, NamaFitur);
        try {
            Acc = new Akses[rows.length];
            for(int i=0;i<Acc.length;i++){
                Acc[i] = new Akses();
                
                if(Acc[i].getAkses(KodeAkses)==1){
                    Acc[i].UpdateAkses(KodeAkses, 2);
                }
                else if(Access.getAkses(KodeAkses)==2){
                    Acc[i].UpdateAkses(KodeAkses, 1);
                }
            }
            
            DBConnector.getConnection().commit();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Akses Berhasil Diubah");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Ubah Akses : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        Access.getAkses(tblAksesFitur, KodeUser);
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        
        Access.getAkses(tblAksesFitur, KodeUser);
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSelesai;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JFormattedTextField ftxtKodeOutlet;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JLabel lblKodeUser;
    private javax.swing.JLabel lblNamaLengkap;
    private javax.swing.JLabel lblOutlet;
    private javax.swing.JPanel pnlAksesFitur;
    private javax.swing.JScrollPane scrlAksesFitur;
    public javax.swing.JTable tblAksesFitur;
    public javax.swing.JTextField txtNamaLengkap;
    public javax.swing.JTextField txtOutlet;
    // End of variables declaration//GEN-END:variables
}
