/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori.gui;

import Inventori.Items;
import Inventori.Satuan;
import Inventori.StokBarang;
import Inventori.StokItem;
import Transaksi.gui.DataTransaksi;
import Util.BackgroundImage;
import Util.BackgroundPane;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author Yestin
 */
public class PenguranganStok extends javax.swing.JFrame {

    StokItem StokItem = new StokItem();
    StokBarang StokBrng = new StokBarang();
    Items Item = new Items();
    Satuan Sat = new Satuan();
    BackgroundImage BI = new BackgroundImage();
    /**
     * Creates new form PenguranganStok
     */
    public PenguranganStok() {
        initComponents();
        setTitle("Pengurangan Stok");
        BI.BackgroundJPanel(this, pnlPenguranganStok);
        dchTanggal.setDateFormatString("dd-mm-yyyy");
        dchTanggal.setCalendar(Calendar.getInstance());
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPenguranganStok = new javax.swing.JPanel();
        dchTanggal = new com.toedter.calendar.JDateChooser();
        lblTanggal = new javax.swing.JLabel();
        lblOutlet = new javax.swing.JLabel();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        ftxtKodeSatuan = new javax.swing.JFormattedTextField();
        txtOutlet = new javax.swing.JTextField();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        lblNamaItem = new javax.swing.JLabel();
        txtNamaItem = new javax.swing.JTextField();
        lblSatuan = new javax.swing.JLabel();
        cboSatuan = new javax.swing.JComboBox<>();
        ftxtKodeStok = new javax.swing.JFormattedTextField();
        lblStokTersedia = new javax.swing.JLabel();
        ftxtSisaStok = new javax.swing.JFormattedTextField();
        lblStokDikurangi = new javax.swing.JLabel();
        ftxtStokDikurangi = new javax.swing.JFormattedTextField();
        lblHargaModal = new javax.swing.JLabel();
        ftxtHargaModal = new javax.swing.JFormattedTextField();
        btnDaftarItem = new javax.swing.JButton();
        lblTotalModal = new javax.swing.JLabel();
        ftxtTotalModa = new javax.swing.JFormattedTextField();
        btnSimpan = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPenguranganStok.setForeground(new java.awt.Color(0, 0, 255));

        lblTanggal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 0, 255));
        lblTanggal.setText("Tanggal :");

        lblOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOutlet.setForeground(new java.awt.Color(0, 0, 255));
        lblOutlet.setText("Outlet :");

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeSatuan.setEditable(false);
        ftxtKodeSatuan.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtOutlet.setEditable(false);
        txtOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtOutlet.setForeground(new java.awt.Color(0, 0, 255));

        lblBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBarcode.setForeground(new java.awt.Color(0, 0, 255));
        lblBarcode.setText("Barcode :");

        txtBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(0, 0, 255));

        lblNamaItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaItem.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaItem.setText("Nama Item :");

        txtNamaItem.setEditable(false);
        txtNamaItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaItem.setForeground(new java.awt.Color(0, 0, 255));

        lblSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSatuan.setForeground(new java.awt.Color(51, 0, 255));
        lblSatuan.setText("Satuan :");

        cboSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboSatuan.setForeground(new java.awt.Color(0, 0, 255));
        cboSatuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSatuanItemStateChanged(evt);
            }
        });

        ftxtKodeStok.setEditable(false);
        ftxtKodeStok.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeStok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblStokTersedia.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStokTersedia.setForeground(new java.awt.Color(0, 0, 255));
        lblStokTersedia.setText("Sisa Stok :");

        ftxtSisaStok.setEditable(false);
        ftxtSisaStok.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSisaStok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblStokDikurangi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStokDikurangi.setForeground(new java.awt.Color(0, 0, 255));
        lblStokDikurangi.setText("Stok Dikurangi :");

        ftxtStokDikurangi.setForeground(new java.awt.Color(0, 0, 255));
        ftxtStokDikurangi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblHargaModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblHargaModal.setForeground(new java.awt.Color(0, 0, 255));
        lblHargaModal.setText("Harga Modal :");

        ftxtHargaModal.setEditable(false);
        ftxtHargaModal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtHargaModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DaftarItem.png"))); // NOI18N
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
            }
        });

        lblTotalModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTotalModal.setForeground(new java.awt.Color(0, 0, 255));
        lblTotalModal.setText("Total Modal :");

        ftxtTotalModa.setEditable(false);
        ftxtTotalModa.setForeground(new java.awt.Color(0, 0, 255));
        ftxtTotalModa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Simpan2.png"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        javax.swing.GroupLayout pnlPenguranganStokLayout = new javax.swing.GroupLayout(pnlPenguranganStok);
        pnlPenguranganStok.setLayout(pnlPenguranganStokLayout);
        pnlPenguranganStokLayout.setHorizontalGroup(
            pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                        .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblOutlet))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                                .addComponent(ftxtKodeSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftxtKodeStok, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 192, Short.MAX_VALUE)
                                .addComponent(lblTanggal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dchTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenguranganStokLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(ftxtHargaModal, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtBarcode)
                                    .addComponent(txtOutlet)
                                    .addComponent(txtNamaItem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboSatuan, javax.swing.GroupLayout.Alignment.LEADING, 0, 481, Short.MAX_VALUE)
                                    .addComponent(ftxtSisaStok, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtStokDikurangi, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDaftarItem, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtTotalModa, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(119, 119, 119))))
                    .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                        .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblStokTersedia)
                            .addComponent(lblHargaModal)
                            .addComponent(lblStokDikurangi)
                            .addComponent(lblNamaItem))
                        .addContainerGap())
                    .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                        .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTotalModal)
                            .addComponent(lblSatuan)
                            .addComponent(lblBarcode))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addComponent(btnSimpan)
                .addGap(111, 111, 111)
                .addComponent(jButton1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPenguranganStokLayout.setVerticalGroup(
            pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenguranganStokLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dchTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(46, 46, 46)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOutlet)
                    .addComponent(txtOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBarcode)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDaftarItem)
                .addGap(25, 25, 25)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaItem)
                    .addComponent(txtNamaItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSatuan)
                    .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStokTersedia)
                    .addComponent(ftxtSisaStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStokDikurangi)
                    .addComponent(ftxtStokDikurangi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHargaModal)
                    .addComponent(ftxtHargaModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalModal)
                    .addComponent(ftxtTotalModa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 109, Short.MAX_VALUE)
                .addGroup(pnlPenguranganStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(jButton1))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPenguranganStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPenguranganStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems Di = new DataItems(this, true);
        Di.setLocationRelativeTo(this);
        Di.setVisible(true);
        
        Item = Di.getSelectedItems();
        
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String Barcode = Item.getBarcode();
        txtBarcode.setText(new String(Barcode));
        String NamaItem = Item.getNamaItem(Barcode);
        txtNamaItem.setText(new String(NamaItem));
        StokItem.getSatuan(cboSatuan, Barcode, KodeOutlet);
        String NamaSatuan = ((String)cboSatuan.getSelectedItem()).toString();
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        ftxtKodeSatuan.setValue(KodeSatuan);
        int KodeStok = StokItem.getKodeStok(Barcode,KodeOutlet,KodeSatuan);
        ftxtKodeStok.setValue(KodeStok);
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
        String NamaSatuan = ((String)cboSatuan.getSelectedItem());
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        ftxtKodeSatuan.setValue(KodeSatuan);
    }//GEN-LAST:event_cboSatuanItemStateChanged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTanggal;
    private javax.swing.JFormattedTextField ftxtHargaModal;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    public javax.swing.JFormattedTextField ftxtKodeSatuan;
    public javax.swing.JFormattedTextField ftxtKodeStok;
    private javax.swing.JFormattedTextField ftxtSisaStok;
    private javax.swing.JFormattedTextField ftxtStokDikurangi;
    private javax.swing.JFormattedTextField ftxtTotalModa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblHargaModal;
    private javax.swing.JLabel lblNamaItem;
    private javax.swing.JLabel lblOutlet;
    private javax.swing.JLabel lblSatuan;
    private javax.swing.JLabel lblStokDikurangi;
    private javax.swing.JLabel lblStokTersedia;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTotalModal;
    private javax.swing.JPanel pnlPenguranganStok;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtNamaItem;
    public javax.swing.JTextField txtOutlet;
    // End of variables declaration//GEN-END:variables
}
