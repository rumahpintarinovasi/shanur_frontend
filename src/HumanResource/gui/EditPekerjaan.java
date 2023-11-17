/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource.gui;

import App.Outlet;
import HumanResource.JenisPekerjaan;
import HumanResource.Pekerjaan;
import Inventori.gui.RegistrasiKategori;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.DBConnector;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

/**
 *
 * @author Yestin
 */
public class EditPekerjaan extends javax.swing.JFrame {

    JenisPekerjaan JP = new JenisPekerjaan();
    Outlet Outlet = new Outlet();
    Pekerjaan Job = new Pekerjaan();
    BackgroundImage BI = new BackgroundImage();
    /**
     * Creates new form EditPekerjaan
     */
    public EditPekerjaan() {
        initComponents();
        setTitle("Edit Pekerjaan");
        BI.BackgroundJPanel(this, pnlEditPekerjaan);
        JP.getJenisPekerjaan(cboPekerjaan);
        Outlet.getOutlet(cboOutlet);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEditPekerjaan = new javax.swing.JPanel();
        ftxtKodeKerja = new javax.swing.JFormattedTextField();
        lblNoIdentitas = new javax.swing.JLabel();
        txtNoIdentitas = new javax.swing.JTextField();
        lblNamaLengkap = new javax.swing.JLabel();
        txtNamaLengkap = new javax.swing.JTextField();
        lblPekerjaan = new javax.swing.JLabel();
        cboPekerjaan = new javax.swing.JComboBox<>();
        ftxtKodeJob = new javax.swing.JFormattedTextField();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        lblOutlet = new javax.swing.JLabel();
        cboOutlet = new javax.swing.JComboBox<>();
        lblGaji = new javax.swing.JLabel();
        ftxtGaji = new javax.swing.JFormattedTextField();
        btnUpdate = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        ftxtKodeKerja.setEditable(false);
        ftxtKodeKerja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNoIdentitas.setBackground(new java.awt.Color(255, 255, 255));
        lblNoIdentitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoIdentitas.setForeground(new java.awt.Color(0, 0, 255));
        lblNoIdentitas.setText("No Identitas :");

        txtNoIdentitas.setEditable(false);
        txtNoIdentitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoIdentitas.setForeground(new java.awt.Color(0, 0, 255));

        lblNamaLengkap.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaLengkap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaLengkap.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaLengkap.setText("Nama Lengkap :");

        txtNamaLengkap.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaLengkap.setForeground(new java.awt.Color(0, 0, 255));

        lblPekerjaan.setBackground(new java.awt.Color(255, 255, 255));
        lblPekerjaan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPekerjaan.setForeground(new java.awt.Color(0, 0, 255));
        lblPekerjaan.setText("Pekerjaan :");

        cboPekerjaan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboPekerjaan.setForeground(new java.awt.Color(0, 0, 255));
        cboPekerjaan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboPekerjaanItemStateChanged(evt);
            }
        });

        ftxtKodeJob.setEditable(false);
        ftxtKodeJob.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeJob.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblOutlet.setBackground(new java.awt.Color(255, 255, 255));
        lblOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOutlet.setForeground(new java.awt.Color(0, 0, 255));
        lblOutlet.setText("Outlet :");

        cboOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOutlet.setForeground(new java.awt.Color(0, 0, 255));
        cboOutlet.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOutletItemStateChanged(evt);
            }
        });

        lblGaji.setBackground(new java.awt.Color(255, 255, 255));
        lblGaji.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGaji.setForeground(new java.awt.Color(0, 0, 255));
        lblGaji.setText("Gaji :");

        ftxtGaji.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGaji.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnUpdate.setBackground(new java.awt.Color(255, 255, 255));
        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Update.png"))); // NOI18N
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(255, 255, 255));
        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlEditPekerjaanLayout = new javax.swing.GroupLayout(pnlEditPekerjaan);
        pnlEditPekerjaan.setLayout(pnlEditPekerjaanLayout);
        pnlEditPekerjaanLayout.setHorizontalGroup(
            pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEditPekerjaanLayout.createSequentialGroup()
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                        .addContainerGap(375, Short.MAX_VALUE)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeJob, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeKerja, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNoIdentitas)
                                    .addComponent(lblPekerjaan)
                                    .addComponent(lblOutlet)
                                    .addComponent(lblGaji))
                                .addGap(76, 76, 76)
                                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoIdentitas)
                                    .addComponent(cboPekerjaan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboOutlet, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftxtGaji)))
                            .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                                .addComponent(lblNamaLengkap)
                                .addGap(55, 55, 55)
                                .addComponent(txtNamaLengkap)))))
                .addGap(68, 68, 68))
            .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                .addGap(181, 181, 181)
                .addComponent(btnUpdate)
                .addGap(47, 47, 47)
                .addComponent(btnTutup)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlEditPekerjaanLayout.setVerticalGroup(
            pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEditPekerjaanLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtKodeKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtKodeJob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoIdentitas)
                    .addComponent(txtNoIdentitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaLengkap)
                    .addComponent(txtNamaLengkap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPekerjaan)
                    .addComponent(cboPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutlet)
                    .addComponent(cboOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGaji)
                    .addComponent(ftxtGaji, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(pnlEditPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditPekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEditPekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        if(txtNoIdentitas.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "No Identitas Belum Diisi");
            return;
        }
        if(txtNamaLengkap.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Nama Lengkap Belum Diisi");
            return;
        }
//        if(cboPekerjaan.getSelectedIndex()==0){
//            JOptionPane.showMessageDialog(this, "Pekerjaan Belum dipilih");
//            return;
//        }
//        if(cboOutlet.getSelectedIndex()==0){
//            JOptionPane.showMessageDialog(this, "Outlet Belum Dipilih");
//            return;
//        }
//        if(ftxtGaji.getValue() instanceof Double){
//            if(((Double)ftxtGaji.getValue()).doubleValue()==0.00 || ftxtGaji.getText().trim().length()==0){
//                JOptionPane.showMessageDialog(this, "Gaji Belum Diisi");
//                return;
//            }
//        }
//        else if(ftxtGaji.getValue() instanceof Long){
//            if(((Long)ftxtGaji.getValue()).doubleValue()==0.00 || ftxtGaji.getText().trim().length()==0){
//                JOptionPane.showMessageDialog(this, "Gaji Belum Diisi");
//                return;
//            }
//        }
        
        int KodeKerja = (((Integer)ftxtKodeKerja.getValue()).intValue());
        int KodeJob = (((Integer)ftxtKodeJob.getValue()).intValue());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        try {
            Job.UpdateKodeJob(KodeKerja, KodeJob);
            Job.UpdateKodeOutlet(KodeKerja, KodeOutlet);
            
            if(ftxtGaji.getValue() instanceof Double){
                Double Gaji = (((Double)ftxtGaji.getValue()).doubleValue());
                Job.UpdateBiaya(KodeKerja, Gaji);
            }
            else if(ftxtGaji.getValue() instanceof Long){
                Double Gaji = (((Long)ftxtGaji.getValue()).doubleValue());
                Job.UpdateBiaya(KodeKerja, Gaji);
            }
            
            DBConnector.getConnection().commit();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Data Berhasil Diperbarui");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Memperbarui Data Pekerjaan : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void cboPekerjaanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboPekerjaanItemStateChanged
        // TODO add your handling code here:
        String Pekerjaan = ((String)cboPekerjaan.getSelectedItem()).toString();
            int Kode = Pekerjaan.indexOf(' ');
            String KodeJob = Pekerjaan.substring(0, Kode);
            int KodeKerja = Integer.valueOf(KodeJob);
            ftxtKodeJob.setValue(new Integer(KodeKerja));
    
    }//GEN-LAST:event_cboPekerjaanItemStateChanged

    private void cboOutletItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOutletItemStateChanged
        // TODO add your handling code here:
            String Outlet = ((String)cboOutlet.getSelectedItem()).toString();
            int Kode = Outlet.indexOf(' ');
            String KodeOutlet = Outlet.substring(0, Kode);
            int KodeCabang = Integer.valueOf(KodeOutlet);
            ftxtKodeOutlet.setValue(new Integer(KodeCabang));
    }//GEN-LAST:event_cboOutletItemStateChanged

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUpdate;
    public javax.swing.JComboBox<String> cboOutlet;
    public javax.swing.JComboBox<String> cboPekerjaan;
    public javax.swing.JFormattedTextField ftxtGaji;
    public javax.swing.JFormattedTextField ftxtKodeJob;
    public javax.swing.JFormattedTextField ftxtKodeKerja;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JLabel lblGaji;
    private javax.swing.JLabel lblNamaLengkap;
    private javax.swing.JLabel lblNoIdentitas;
    private javax.swing.JLabel lblOutlet;
    private javax.swing.JLabel lblPekerjaan;
    private javax.swing.JPanel pnlEditPekerjaan;
    public javax.swing.JTextField txtNamaLengkap;
    public javax.swing.JTextField txtNoIdentitas;
    // End of variables declaration//GEN-END:variables
}
