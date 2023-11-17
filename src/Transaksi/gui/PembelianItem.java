/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import Inventori.*;
import Inventori.gui.DataItems;
import Inventori.gui.RegistrasiKategori;
import Transaksi.BusinessContact;
import Transaksi.*;
import Util.BackgroundPane;
import Util.DoubleFormatTableAlignment;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;;

/**
 *
 * @author Yestin
 */
public class PembelianItem extends javax.swing.JFrame {

    BusinessContact BC = new BusinessContact();
    Transaksi trans = new Transaksi();
    JenisPembayaran JP = new JenisPembayaran();
    DetailTransaksi RincianTransaksi[];
    Items Item = new Items();
    StokItem StokItem = new StokItem();
    StokBarang StokBrng = new StokBarang();
    Satuan Satuan = new Satuan();
    /**
     * Creates new form PembelianItem
     */
    public PembelianItem() {
        initComponents();
        setTitle("Pembelian Item");
        InitTablePembelian();
//        NumberFormatTable();
        try {
            BackgroundPane Background = new BackgroundPane();
            Background.setBackground(ImageIO.read(new File("\\E-POS\\Green Background 37.jpeg")));
            Background.setLayout(new BorderLayout());
            pnlPembelian.setOpaque(false);
            Background.add(pnlPembelian,BorderLayout.CENTER);
            this.setLayout(new BorderLayout());
            this.add(Background, BorderLayout.CENTER);
        } 
        catch (IOException ex) {
            Logger.getLogger(RegistrasiKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
        ftxtNoNota.setValue(new Integer(0));
        ftxtNoNota.setValue(null);
        dchTglTransaksi.setDateFormatString("dd-mm-yyyy");
        txtNoFaktur.setText(new String());
        txtNoFaktur.setText(null);
        txtNamaSupplier.setText(new String());
        txtNamaSupplier.setText(null);
        dchTglJatuhTempo.setDateFormatString("dd-mm-yyyy");
        ftxtSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtSubTotal.setValue(new Double(0));
        ftxtPPN.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtPPN.setValue(new Double(0));
        ftxtGrandTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotal.setValue(new Double(0));
        txtBarcode.setText(new String());
        txtBarcode.setText(null);
        ftxtKuantitas.setValue(new Double(0));
        JP.getJenisPembayaran(cboJenisPembayaran);
    }
    private void InitTablePembelian(){
        tblPembelian.setModel(new DefaultTableModel(){
            String ColName[] = {"Barcode","Nama Item","Satuan","Sisa Stok","Stok Masuk","Harga Modal","Diskon","Total"};
            Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
            
            @Override
            public Class<?> getColumnClass(int ColIndex){
                return ColType[ColIndex];
            }
            @Override
            public String getColumnName(int ColIndex){
                return ColName[ColIndex];
            }
            @Override
            public int getColumnCount(){
                return ColName.length;
            }
        });
        
        tblPembelian.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblPembelian.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblPembelian.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblPembelian.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblPembelian.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblPembelian.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblPembelian.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblPembelian.getColumnModel().getColumn(7).setPreferredWidth(100);
        tblPembelian.setRowHeight(30);
        
        tblPembelian.getColumnModel().getColumn(2).setCellEditor(new CBORenderer());
    }
    private void InitTablePembelian2(){
        tblPembelian.setModel(new DefaultTableModel(){
            String ColName[] = {"Barcode","Nama Item","Satuan"};
            Class ColType[] = {String.class,String.class,String.class};
            
            @Override
            public Class<?> getColumnClass(int ColIndex){
                return ColType[ColIndex];
            }
            @Override
            public String getColumnName(int ColIndex){
                return ColName[ColIndex];
            }
            @Override
            public int getColumnCount(){
                return 3;
            }
        });
        
        tblPembelian.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblPembelian.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblPembelian.getColumnModel().getColumn(2).setPreferredWidth(50);
    }
    private void NumberFormatTable(){
        DoubleFormatTableAlignment dfta = new DoubleFormatTableAlignment();
        
        tblPembelian.getColumnModel().getColumn(5).setCellRenderer(dfta);
        tblPembelian.getColumnModel().getColumn(6).setCellRenderer(dfta);
        tblPembelian.getColumnModel().getColumn(7).setCellRenderer(dfta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPembelian = new javax.swing.JPanel();
        dchTglTransaksi = new com.toedter.calendar.JDateChooser();
        lblTanggal = new javax.swing.JLabel();
        lblNoNota = new javax.swing.JLabel();
        ftxtNoNota = new javax.swing.JFormattedTextField();
        lblNoFaktur = new javax.swing.JLabel();
        txtNoFaktur = new javax.swing.JTextField();
        lblNamaSupplier = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        btnDaftarSupplier = new javax.swing.JButton();
        ftxtKodeSupplier = new javax.swing.JFormattedTextField();
        lblJenisPembayaran = new javax.swing.JLabel();
        cboJenisPembayaran = new javax.swing.JComboBox<>();
        ftxtKodeJenis = new javax.swing.JFormattedTextField();
        lblOrderan = new javax.swing.JLabel();
        cboOrderan = new javax.swing.JComboBox<>();
        lblTglJatuhTempo = new javax.swing.JLabel();
        dchTglJatuhTempo = new com.toedter.calendar.JDateChooser();
        scrlPembelian = new javax.swing.JScrollPane();
        tblPembelian = new javax.swing.JTable();
        ftxtSubTotal = new javax.swing.JFormattedTextField();
        lblSubTotal = new javax.swing.JLabel();
        lblPPN = new javax.swing.JLabel();
        ftxtPPN = new javax.swing.JFormattedTextField();
        lblGrandTotal = new javax.swing.JLabel();
        ftxtGrandTotal = new javax.swing.JFormattedTextField();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        lblKuantitas = new javax.swing.JLabel();
        ftxtKuantitas = new javax.swing.JFormattedTextField();
        btnBerikut = new javax.swing.JButton();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        btnDaftarItem = new javax.swing.JButton();
        cboSatuan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPembelian.setBackground(new java.awt.Color(255, 255, 255));
        pnlPembelian.setForeground(new java.awt.Color(0, 0, 255));

        lblTanggal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 0, 255));
        lblTanggal.setText("Tgl Transaksi :");

        lblNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoNota.setForeground(new java.awt.Color(0, 0, 255));
        lblNoNota.setText("No Nota :");

        ftxtNoNota.setEditable(false);
        ftxtNoNota.setForeground(new java.awt.Color(0, 0, 255));
        ftxtNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoFaktur.setForeground(new java.awt.Color(0, 0, 255));
        lblNoFaktur.setText("Nomor Faktur :");

        txtNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoFaktur.setForeground(new java.awt.Color(0, 0, 255));

        lblNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaSupplier.setText("Nama Supplire :");

        txtNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));

        btnDaftarSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DataSupplier.png"))); // NOI18N
        btnDaftarSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarSupplierActionPerformed(evt);
            }
        });

        ftxtKodeSupplier.setEditable(false);
        ftxtKodeSupplier.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblJenisPembayaran.setText("Jenis Pembayaran :");

        cboJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        cboJenisPembayaran.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJenisPembayaranItemStateChanged(evt);
            }
        });

        ftxtKodeJenis.setEditable(false);
        ftxtKodeJenis.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeJenis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOrderan.setForeground(new java.awt.Color(0, 0, 255));
        lblOrderan.setText("Orderan :");

        cboOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOrderan.setForeground(new java.awt.Color(0, 0, 255));
        cboOrderan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Langsung", "Purchase Order" }));

        lblTglJatuhTempo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTglJatuhTempo.setForeground(new java.awt.Color(0, 0, 255));
        lblTglJatuhTempo.setText("Tgl Jatuh Tempo :");

        tblPembelian.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        tblPembelian.setForeground(new java.awt.Color(0, 0, 255));
        scrlPembelian.setViewportView(tblPembelian);

        ftxtSubTotal.setEditable(false);
        ftxtSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblSubTotal.setText("Sub Total :");

        lblPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPPN.setForeground(new java.awt.Color(0, 0, 255));
        lblPPN.setText("PPN 11% :");

        ftxtPPN.setEditable(false);
        ftxtPPN.setForeground(new java.awt.Color(0, 0, 255));
        ftxtPPN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblGrandTotal.setText("Grand Total :");

        ftxtGrandTotal.setEditable(false);
        ftxtGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Simpan2.png"))); // NOI18N

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cetak.png"))); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        lblBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBarcode.setForeground(new java.awt.Color(0, 0, 255));
        lblBarcode.setText("Barcode :");

        txtBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(0, 0, 255));
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });

        lblKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKuantitas.setForeground(new java.awt.Color(0, 0, 255));
        lblKuantitas.setText("Kuantitas :");

        ftxtKuantitas.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnBerikut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Berikut.png"))); // NOI18N
        btnBerikut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerikutActionPerformed(evt);
            }
        });

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtNamaSatuan.setEditable(false);
        txtNamaSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaSatuan.setForeground(new java.awt.Color(0, 0, 255));

        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DaftarItem.png"))); // NOI18N
        btnDaftarItem.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
            }
        });

        cboSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlPembelianLayout = new javax.swing.GroupLayout(pnlPembelian);
        pnlPembelian.setLayout(pnlPembelianLayout);
        pnlPembelianLayout.setHorizontalGroup(
            pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addComponent(lblNoNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNoFaktur)
                            .addComponent(lblNamaSupplier))
                        .addGap(76, 76, 76)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNoFaktur, javax.swing.GroupLayout.DEFAULT_SIZE, 401, Short.MAX_VALUE)
                            .addComponent(txtNamaSupplier)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(btnDaftarSupplier)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblJenisPembayaran)
                                    .addComponent(lblOrderan))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboJenisPembayaran, 0, 175, Short.MAX_VALUE)
                                    .addComponent(cboOrderan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(lblTglJatuhTempo)
                                .addGap(18, 18, 18)
                                .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 273, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
            .addComponent(scrlPembelian)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPembelianLayout.createSequentialGroup()
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSubTotal))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPembelianLayout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBarcode)
                            .addComponent(lblKuantitas))
                        .addGap(71, 71, 71)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(btnBerikut, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNamaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                                    .addComponent(txtBarcode))
                                .addGap(33, 33, 33)
                                .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(137, 137, Short.MAX_VALUE)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPPN, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblGrandTotal, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftxtSubTotal)
                    .addComponent(ftxtPPN)
                    .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPembelianLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSimpan)
                .addGap(53, 53, 53)
                .addComponent(btnCetak)
                .addGap(59, 59, 59)
                .addComponent(btnTutup)
                .addGap(392, 392, 392))
        );
        pnlPembelianLayout.setVerticalGroup(
            pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblNoNota)
                            .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(52, 52, 52)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoFaktur)
                    .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJenisPembayaran)
                    .addComponent(cboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaSupplier)
                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblOrderan)
                    .addComponent(cboOrderan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnDaftarSupplier)
                            .addComponent(ftxtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblTglJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(scrlPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubTotal))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPPN)
                    .addComponent(ftxtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBarcode)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblGrandTotal)
                        .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnDaftarItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKuantitas)
                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBerikut)
                    .addComponent(txtNamaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTutup)
                    .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDaftarSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarSupplierActionPerformed
        // TODO add your handling code here:
        DataSupplier DS = new DataSupplier(this, true);
        DS.setLocationRelativeTo(this);
        DS.setVisible(true);
        
        BC = DS.getSelectedSupplier();
        
        int KodeBC = BC.getKodeBC();
        ftxtKodeSupplier.setValue(new Integer(KodeBC));
        String NamaBC = BC.getNamaBC(KodeBC);
        txtNamaSupplier.setText(new String(NamaBC));
    }//GEN-LAST:event_btnDaftarSupplierActionPerformed

    private void cboJenisPembayaranItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboJenisPembayaranItemStateChanged
        // TODO add your handling code here:
        if(cboJenisPembayaran.getSelectedIndex()==0){
            ftxtKodeJenis.setValue(new Integer(0));
        }
        else{
            String JnsPembayaran = ((String)cboJenisPembayaran.getSelectedItem()).toString();
            int Kode = JnsPembayaran.indexOf(' ');
            String KodeJenis = JnsPembayaran.substring(0, Kode);
            int KodeJns = Integer.valueOf(KodeJenis);
            ftxtKodeJenis.setValue(new Integer(KodeJns));
        }
    }//GEN-LAST:event_cboJenisPembayaranItemStateChanged

    private void btnBerikutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerikutActionPerformed
        // TODO add your handling code here:
        if(txtBarcode.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
            return;
        }
        if(ftxtKuantitas.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Kuantitas Belum Diisi");
            return;
        }
        if(((Double)ftxtKuantitas.getValue()).doubleValue()==0){
            JOptionPane.showMessageDialog(this, "Kuantitas Tidak Boleh 0");
            return;
        }
        
        String Barcode = (((String)txtBarcode.getText().trim()).toString());
        Double Kuantitas = (((Double)ftxtKuantitas.getValue()).doubleValue());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        
        Item = new Items();
        Item.setBarcode(Barcode);
        try {
            Item.Query();
            txtBarcode.setText("");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Query Data Item : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        boolean SdhAda = false;
        for (int i=0;i<dtm.getRowCount();i++) {
            String PerSatuan = ((String)dtm.getValueAt(i, 2)).toString();
            int KodeSatuan = Satuan.getKodeSatuan(PerSatuan);
            
            if ((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode())) {
                String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                
//                CBORenderer cboRenderer = (CBORenderer) tblPembelian.getCellEditor(i, 2);
//                cboRenderer.reloadData(Barcode);
                
                //tblPembelian.getColumnModel().getColumn(2).setCellEditor(new CBORenderer(Barcode));
//                tblPembelian.getColumnModel().getColumn(2).setCellRenderer(new ComboBoxRendererSatuan(Barcode, cboSatuan, txtNamaSatuan));
                
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokMsk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                Double Qtty = (((Double)ftxtKuantitas.getValue()).doubleValue());
                int KodeStok = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                if((SisaStok+Qtty)>StokItem.getStokMax(KodeStok)){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maksimum");
                    return;
                }
                StokMsk = StokMsk + Qtty;
                dtm.setValueAt(new Double(StokMsk), i, 4);
                
                Double HrgModal = ((Double)dtm.getValueAt(i, 5)).doubleValue();
                dtm.setValueAt(new Double(HrgModal), i, 5);
                Double Diskon = ((Double)dtm.getValueAt(i, 6)).doubleValue();
                dtm.setValueAt(new Double(Diskon), i, 6);
                Double Total = (StokMsk*HrgModal) - (StokMsk*HrgModal*Diskon);
                dtm.setValueAt(new Double(Total), i, 7);
                
                SdhAda = true;
                break;
            }
        }
        if(!SdhAda){
            Object rowdata[] = new Object[8];
            
            rowdata[0] = new String(Barcode);
            String NamaItem = Item.getNamaItem(Barcode);
            rowdata[1] = new String(NamaItem);
            int KodeSatuan = StokItem.getKodeSatuan(Barcode);
            String NamaSatuan = Satuan.getNamaSatuan(KodeSatuan);
            rowdata[2] = new String(NamaSatuan);
            int KodeStokItm = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            Double SisaStok = StokItem.getKuantitas(KodeStokItm);
            rowdata[3] = new Double(SisaStok);
            Double StokMasuk = (((Double)ftxtKuantitas.getValue()).doubleValue());
            rowdata[4] = new Double(StokMasuk);
            Double HrgModal = StokItem.getHargaModal(KodeStokItm);
            rowdata[5] = new Double(HrgModal);
            Double Diskon = StokItem.getDiskon(KodeStokItm)/100;
            rowdata[6] = new Double(Diskon);
            Double TotalModal = (StokMasuk * HrgModal) - (StokMasuk*HrgModal*Diskon);
            rowdata[7] = new Double(TotalModal);
            
            dtm.addRow(rowdata);
            
        }
    }//GEN-LAST:event_btnBerikutActionPerformed

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems DI = new DataItems(this, true);
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);
        
        Item = DI.getSelectedItems();
        
        String Barcode = Item.getBarcode();
        txtBarcode.setText(Barcode);
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(txtBarcode.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
                return;
            }
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            
            DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
            
            Item = new Items();
            Item.setBarcode(Barcode);
            try {
                Item.Query();
                txtBarcode.setText("");
                ftxtKuantitas.setText("");
            } 
            catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error Saat Query Item : "+e.getMessage());
                return;
            }
            
            boolean SdhAda = false;
            for(int i=0;i<dtm.getRowCount();i++){
                
            }
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnCetakActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerikut;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnDaftarSupplier;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboJenisPembayaran;
    private javax.swing.JComboBox<String> cboOrderan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTglJatuhTempo;
    private com.toedter.calendar.JDateChooser dchTglTransaksi;
    private javax.swing.JFormattedTextField ftxtGrandTotal;
    private javax.swing.JFormattedTextField ftxtKodeJenis;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeSupplier;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
    private javax.swing.JFormattedTextField ftxtNoNota;
    private javax.swing.JFormattedTextField ftxtPPN;
    private javax.swing.JFormattedTextField ftxtSubTotal;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblJenisPembayaran;
    private javax.swing.JLabel lblKuantitas;
    private javax.swing.JLabel lblNamaSupplier;
    private javax.swing.JLabel lblNoFaktur;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JLabel lblOrderan;
    private javax.swing.JLabel lblPPN;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JLabel lblTglJatuhTempo;
    private javax.swing.JPanel pnlPembelian;
    private javax.swing.JScrollPane scrlPembelian;
    private javax.swing.JTable tblPembelian;
    private javax.swing.JTextField txtBarcode;
    private final javax.swing.JTextField txtNamaSatuan = new javax.swing.JTextField();
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtNoFaktur;
    // End of variables declaration//GEN-END:variables
}
