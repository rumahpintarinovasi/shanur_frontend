/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import Inventori.gui.RegistrasiKategori;
import Transaksi.BusinessContact;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.Table;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class DataSupplier extends javax.swing.JDialog {

    BusinessContact BC = new BusinessContact();
    BackgroundImage BI = new BackgroundImage();
    Table Tab = new Table();
    /**
     * Creates new form DataSupplier1
     */
    public DataSupplier(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Data Supplier");
        BC.getSupplier(tblSupplier);
        BI.BackgroundJPanel(this, pnlDataSupplier);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDataSupplier = new javax.swing.JPanel();
        lblNamaSupplier = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        scrlSupplier = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        btnTutup = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnPilih = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaSupplier.setText("Nama Supplier :");

        txtNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));
        txtNamaSupplier.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaSupplierKeyPressed(evt);
            }
        });

        tblSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblSupplier.setForeground(new java.awt.Color(0, 0, 255));
        scrlSupplier.setViewportView(tblSupplier);

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Pilih.png"))); // NOI18N
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Hapus.png"))); // NOI18N

        javax.swing.GroupLayout pnlDataSupplierLayout = new javax.swing.GroupLayout(pnlDataSupplier);
        pnlDataSupplier.setLayout(pnlDataSupplierLayout);
        pnlDataSupplierLayout.setHorizontalGroup(
            pnlDataSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataSupplierLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(lblNamaSupplier)
                .addGap(56, 56, 56)
                .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 492, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataSupplierLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnPilih)
                .addGap(18, 18, 18)
                .addComponent(btnTutup)
                .addGap(58, 58, 58))
            .addGroup(pnlDataSupplierLayout.createSequentialGroup()
                .addComponent(scrlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlDataSupplierLayout.setVerticalGroup(
            pnlDataSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataSupplierLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(pnlDataSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaSupplier)
                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(scrlSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(pnlDataSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataSupplierLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnPilih)
                    .addComponent(btnHapus))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDataSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDataSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaSupplierKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaSupplierKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_A || evt.getKeyCode()==KeyEvent.VK_B || evt.getKeyCode()==KeyEvent.VK_C ||
            evt.getKeyCode()==KeyEvent.VK_D || evt.getKeyCode()==KeyEvent.VK_E || evt.getKeyCode()==KeyEvent.VK_F ||
            evt.getKeyCode()==KeyEvent.VK_G || evt.getKeyCode()==KeyEvent.VK_H || evt.getKeyCode()==KeyEvent.VK_I ||
            evt.getKeyCode()==KeyEvent.VK_J || evt.getKeyCode()==KeyEvent.VK_K || evt.getKeyCode()==KeyEvent.VK_L ||
            evt.getKeyCode()==KeyEvent.VK_M || evt.getKeyCode()==KeyEvent.VK_N || evt.getKeyCode()==KeyEvent.VK_O ||
            evt.getKeyCode()==KeyEvent.VK_P || evt.getKeyCode()==KeyEvent.VK_Q || evt.getKeyCode()==KeyEvent.VK_R ||
            evt.getKeyCode()==KeyEvent.VK_S || evt.getKeyCode()==KeyEvent.VK_T || evt.getKeyCode()==KeyEvent.VK_U ||
            evt.getKeyCode()==KeyEvent.VK_V || evt.getKeyCode()==KeyEvent.VK_W || evt.getKeyCode()==KeyEvent.VK_X ||
            evt.getKeyCode()==KeyEvent.VK_Y || evt.getKeyCode()==KeyEvent.VK_Z || evt.getKeyCode()==KeyEvent.VK_BACK_SPACE ||
            evt.getKeyCode()==KeyEvent.VK_SPACE || evt.getKeyCode()==KeyEvent.VK_0 || evt.getKeyCode()==KeyEvent.VK_1 ||
            evt.getKeyCode()==KeyEvent.VK_2 || evt.getKeyCode()==KeyEvent.VK_3 || evt.getKeyCode()==KeyEvent.VK_4 ||
            evt.getKeyCode()==KeyEvent.VK_5 || evt.getKeyCode()==KeyEvent.VK_6 || evt.getKeyCode()==KeyEvent.VK_7 ||
            evt.getKeyCode()==KeyEvent.VK_8 || evt.getKeyCode()==KeyEvent.VK_9){
            String NamaSupplier = (((String)txtNamaSupplier.getText().trim()).toString());
            BC.getSupplier(tblSupplier, NamaSupplier);
        }
    }//GEN-LAST:event_txtNamaSupplierKeyPressed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        EditSupplier ES = new EditSupplier(null, true);

        int row;
        row = tblSupplier.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblSupplier.getModel();

        int KodeBC = (((Integer)dtm.getValueAt(row, 0)).intValue());
        ES.ftxtKodeBC.setValue(new Integer(KodeBC));
        String NamaSupplier = BC.getNamaBC(KodeBC);
        ES.txtNamaSupplier.setText(new String(NamaSupplier));
        String Alamat = BC.getAlamat(KodeBC);
        ES.txaAlamat.setText(new String(Alamat));
        String Kelurahan = BC.getKelurahan(KodeBC);
        ES.txtKelurahan.setText(new String(Kelurahan));
        String Kecamatan = BC.getKecamatan(KodeBC);
        ES.txtKecamatan.setText(new String(Kecamatan));
        String Kota = BC.getKota(KodeBC);
        ES.txtKota.setText(new String(Kota));
        String Telpon1 = BC.getTelpon1(KodeBC);
        if(Telpon1!=null){
            ES.txtTelpon1.setText(new String(Telpon1));
        }
        else{
            ES.txtTelpon1.setText(null);
        }
        String Telpon2 = BC.getTelpon2(KodeBC);
        if(Telpon2!=null){
            ES.txtTelpon2.setText(new String(Telpon2));
        }
        else{
            ES.txtTelpon2.setText(null);
        }
        String NoHP1 = BC.getNoHP1(KodeBC);
        if(NoHP1!=null){
            ES.txtNoHP1.setText(new String(NoHP1));
        }
        else{
            ES.txtNoHP1.setText(null);
        }
        String NoHP2 = BC.getNoHP2(KodeBC);
        if(NoHP2!=null){
            ES.txtNoHP2.setText(new String(NoHP2));
        }
        else{
            ES.txtNoHP2.setText(null);
        }

        ES.setLocationRelativeTo(this);
        ES.setVisible(true);

        if(txtNamaSupplier.getText().trim().length()>0){
            BC.getSupplier(tblSupplier, NamaSupplier);
        }
        else{
            BC.getSupplier(tblSupplier);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        getSelectedSupplier();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnPilihActionPerformed

    public BusinessContact getSelectedSupplier(){
        int row;
        row = tblSupplier.getSelectedRow();
        if(row<=-1){
            return null;
        }
        DefaultTableModel dtm = (DefaultTableModel)tblSupplier.getModel();
        
        int KodeBC = (((Integer)dtm.getValueAt(row, 0)).intValue());
        BC.setKodeBC(KodeBC);
        String NamaSupplier = (((String)dtm.getValueAt(row, 1)).toString());
        BC.setNamaBC(NamaSupplier);
        String Alamat = (((String)dtm.getValueAt(row, 2)).toString());
        BC.setAlamat(Alamat);
        String Kelurahan = (((String)dtm.getValueAt(row, 3)).toString());
        BC.setKelurahan(Kelurahan);
        String Kecamatan = (((String)dtm.getValueAt(row, 4)).toString());
        BC.setKecamatan(Kecamatan);
        String Kota = (((String)dtm.getValueAt(row, 5)).toString());
        BC.setKota(Kota);
        String Telpon1 = (((String)dtm.getValueAt(row, 6)).toString());
        BC.setTelpon1(Telpon1);
        String Telpon2 = (((String)dtm.getValueAt(row, 7)).toString());
        BC.setTelpon2(Telpon2);
        String NoHP1 = (((String)dtm.getValueAt(row, 8)).toString());
        BC.setNoHP1(NoHP1);
        String NoHP2 = (((String)dtm.getValueAt(row, 9)).toString());
        BC.setNoHP2(NoHP2);
        
        return BC;
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    public javax.swing.JButton btnPilih;
    public javax.swing.JButton btnTutup;
    private javax.swing.JLabel lblNamaSupplier;
    private javax.swing.JPanel pnlDataSupplier;
    private javax.swing.JScrollPane scrlSupplier;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtNamaSupplier;
    // End of variables declaration//GEN-END:variables
}
