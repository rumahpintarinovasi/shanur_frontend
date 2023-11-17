/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orderan.gui;

import App.Outlet;
import HumanResource.Pekerjaan;
import Inventori.Item;
import Inventori.Items;
import Inventori.gui.DataItems;
import javax.swing.JOptionPane;
import Inventori.*;
import Orderan.Mobil;
import Orderan.RincianTransfer;
import Orderan.TransferStok;
import Transaksi.gui.DataTransaksi;
import Util.BackgroundPane;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Yestin
 */
public class PemindahanStock extends javax.swing.JDialog {

    TransferStok TS = new TransferStok();
    RincianTransfer RT = new RincianTransfer();
    RincianTransfer RincianTransfer[];
    Pekerjaan Kerja = new Pekerjaan();
    Mobil mbl = new Mobil();
    Outlet Cab = new Outlet();
    Items Item = new Items();
    Satuan Sat = new Satuan();
    StokItem StokItem = new StokItem();
    StokBarang StokBrng = new StokBarang();
    /**
     * Creates new form PemindahanStock
     */
    public PemindahanStock(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Pemindahan Stok");
        try {
            BackgroundPane Background = new BackgroundPane();
            Background.setBackground(ImageIO.read(new File("\\E-POS\\Green Background 37.jpeg")));
            Background.setLayout(new BorderLayout());
            pnlPemindahanStok.setOpaque(false);
            Background.add(pnlPemindahanStok,BorderLayout.CENTER);
            this.setLayout(new BorderLayout());
            this.add(Background, BorderLayout.CENTER);
        }
        catch (IOException e) {
            Logger.getLogger(DataTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
        
        ftxtKodeTF.setValue(new Integer(0));
        ftxtKodeTF.setValue(null);
        dchTanggal.setCalendar(Calendar.getInstance());
        dchTanggal.setDateFormatString("dd-MM-yyyy");
        ((JTextFieldDateEditor)dchTanggal.getDateEditor()).setForeground(Color.BLUE);
        ftxtKodeUser.setValue(new Integer(0));
        ftxtKodeUser.setValue(null);
        ftxtGrandTotalModal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                            new DecimalFormat("#,##0"))));
        ftxtGrandTotalModal.setValue(new Double(0.00));
        Kerja.getDriver(cboDriver);
        mbl.getMobil(cboMobil);
        Cab.getOutlet(cboOutletTujuan);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPemindahanStok = new javax.swing.JPanel();
        lblTanggal = new javax.swing.JLabel();
        dchTanggal = new com.toedter.calendar.JDateChooser();
        lblKodeTF = new javax.swing.JLabel();
        ftxtKodeTF = new javax.swing.JFormattedTextField();
        scrlRincianTransfer = new javax.swing.JScrollPane();
        tblRincianTransfer = new javax.swing.JTable();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        lblDriver = new javax.swing.JLabel();
        cboDriver = new javax.swing.JComboBox<>();
        lblMobil = new javax.swing.JLabel();
        cboMobil = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        cboOutletTujuan = new javax.swing.JComboBox<>();
        ftxtGrandTotalModal = new javax.swing.JFormattedTextField();
        lblGrandTotalModal = new javax.swing.JLabel();
        lblBiaya = new javax.swing.JLabel();
        ftxtBiaya = new javax.swing.JFormattedTextField();
        lblKeterangan = new javax.swing.JLabel();
        txtKeterangan = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ftxtKuantitas = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        ftxtKodeStokItem = new javax.swing.JFormattedTextField();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        btnDaftarItem = new javax.swing.JButton();
        txtKodeKerja = new javax.swing.JTextField();
        txtKodeMobil = new javax.swing.JTextField();
        txtOutletTujuan = new javax.swing.JTextField();
        ftxtKodeStokBrng = new javax.swing.JFormattedTextField();
        cboSatuan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTanggal.setBackground(new java.awt.Color(255, 255, 255));
        lblTanggal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 0, 255));
        lblTanggal.setText("Tanggal :");

        lblKodeTF.setBackground(new java.awt.Color(255, 255, 255));
        lblKodeTF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKodeTF.setForeground(new java.awt.Color(0, 0, 255));
        lblKodeTF.setText("Kode TF :");

        ftxtKodeTF.setEditable(false);
        ftxtKodeTF.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeTF.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tblRincianTransfer.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblRincianTransfer.setForeground(new java.awt.Color(0, 0, 255));
        scrlRincianTransfer.setViewportView(tblRincianTransfer);

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblDriver.setBackground(new java.awt.Color(255, 255, 255));
        lblDriver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDriver.setForeground(new java.awt.Color(0, 0, 255));
        lblDriver.setText("Driver :");

        cboDriver.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboDriver.setForeground(new java.awt.Color(0, 0, 255));
        cboDriver.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboDriverItemStateChanged(evt);
            }
        });

        lblMobil.setBackground(new java.awt.Color(255, 255, 255));
        lblMobil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMobil.setForeground(new java.awt.Color(0, 0, 255));
        lblMobil.setText("Mobil :");

        cboMobil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboMobil.setForeground(new java.awt.Color(0, 0, 255));
        cboMobil.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMobilItemStateChanged(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Outlet Tujuan :");

        cboOutletTujuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOutletTujuan.setForeground(new java.awt.Color(0, 0, 255));
        cboOutletTujuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboOutletTujuanItemStateChanged(evt);
            }
        });

        ftxtGrandTotalModal.setEditable(false);
        ftxtGrandTotalModal.setBackground(new java.awt.Color(255, 255, 255));
        ftxtGrandTotalModal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotalModal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtGrandTotalModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblGrandTotalModal.setBackground(new java.awt.Color(255, 255, 255));
        lblGrandTotalModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrandTotalModal.setForeground(new java.awt.Color(0, 0, 255));
        lblGrandTotalModal.setText("Grand Total Modal :");

        lblBiaya.setBackground(new java.awt.Color(255, 255, 255));
        lblBiaya.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBiaya.setForeground(new java.awt.Color(0, 0, 255));
        lblBiaya.setText("Biaya :");

        ftxtBiaya.setForeground(new java.awt.Color(0, 0, 255));
        ftxtBiaya.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblKeterangan.setBackground(new java.awt.Color(255, 255, 255));
        lblKeterangan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKeterangan.setForeground(new java.awt.Color(0, 0, 255));
        lblKeterangan.setText("Keterangan :");

        txtKeterangan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtKeterangan.setForeground(new java.awt.Color(0, 0, 255));

        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Simpan2.png"))); // NOI18N

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cetak.png"))); // NOI18N

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Barcode :");

        txtBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(0, 0, 255));
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Berikut.png"))); // NOI18N

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Kuantitas :");

        ftxtKuantitas.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Satuan :");

        ftxtKodeStokItem.setEditable(false);
        ftxtKodeStokItem.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeStokItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DaftarItem.png"))); // NOI18N
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
            }
        });

        txtKodeKerja.setEditable(false);
        txtKodeKerja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtKodeMobil.setEditable(false);
        txtKodeMobil.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtKodeMobil.setForeground(new java.awt.Color(0, 0, 255));

        txtOutletTujuan.setEditable(false);
        txtOutletTujuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtOutletTujuan.setForeground(new java.awt.Color(0, 0, 255));

        ftxtKodeStokBrng.setEditable(false);
        ftxtKodeStokBrng.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cboSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboSatuan.setForeground(new java.awt.Color(0, 0, 255));
        cboSatuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSatuanItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlPemindahanStokLayout = new javax.swing.GroupLayout(pnlPemindahanStok);
        pnlPemindahanStok.setLayout(pnlPemindahanStokLayout);
        pnlPemindahanStokLayout.setHorizontalGroup(
            pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(603, 603, 603))
                    .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                        .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblKodeTF)
                            .addComponent(lblDriver)
                            .addComponent(lblMobil))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                                .addComponent(ftxtKodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTanggal)
                                .addGap(18, 18, 18)
                                .addComponent(dchTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32))
                            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(cboOutletTujuan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboMobil, javax.swing.GroupLayout.Alignment.LEADING, 0, 428, Short.MAX_VALUE)
                                    .addComponent(cboDriver, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtKodeKerja)
                                    .addComponent(txtKodeMobil)
                                    .addComponent(txtOutletTujuan, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPemindahanStokLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGrandTotalModal)
                .addGap(18, 18, 18)
                .addComponent(ftxtGrandTotalModal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                        .addComponent(btnSimpan)
                        .addGap(32, 32, 32)
                        .addComponent(btnCetak)
                        .addGap(41, 41, 41)
                        .addComponent(btnTutup))
                    .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                        .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPemindahanStokLayout.createSequentialGroup()
                                .addComponent(lblKeterangan)
                                .addGap(42, 42, 42)
                                .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPemindahanStokLayout.createSequentialGroup()
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(lblBiaya))
                                .addGap(63, 63, 63)
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txtBarcode, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPemindahanStokLayout.createSequentialGroup()
                                            .addComponent(jButton1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ftxtKodeStokItem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ftxtKodeStokBrng, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(ftxtBiaya, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPemindahanStokLayout.createSequentialGroup()
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                                    .addComponent(cboSatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addComponent(scrlRincianTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlPemindahanStokLayout.setVerticalGroup(
            pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dchTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblKodeTF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ftxtKodeTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDriver)
                    .addComponent(cboDriver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKodeKerja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMobil)
                    .addComponent(txtKodeMobil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cboOutletTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtOutletTujuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrlRincianTransfer, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtGrandTotalModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGrandTotalModal))
                .addGap(41, 41, 41)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtKodeStokItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeStokBrng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiaya)
                    .addComponent(ftxtBiaya, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblKeterangan)
                    .addComponent(txtKeterangan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan)
                    .addComponent(btnCetak)
                    .addComponent(btnTutup))
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPemindahanStok, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPemindahanStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboDriverItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboDriverItemStateChanged
        // TODO add your handling code here:
        String Driver = (((String)cboDriver.getSelectedItem()).toString());
        int Kode = Driver.indexOf(' ');
        String KodeDriver = Driver.substring(0, Kode);
        txtKodeKerja.setText(String.valueOf(KodeDriver));
    }//GEN-LAST:event_cboDriverItemStateChanged

    private void cboMobilItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMobilItemStateChanged
        // TODO add your handling code here:
        String Mobil = (((String)cboMobil.getSelectedItem()).toString());
        int Kode = Mobil.indexOf(' ');
        String KodeMobil = Mobil.substring(0, Kode);
        txtKodeMobil.setText(String.valueOf(KodeMobil));
    }//GEN-LAST:event_cboMobilItemStateChanged

    private void cboOutletTujuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboOutletTujuanItemStateChanged
        // TODO add your handling code here:
        String Outlet = (((String)cboOutletTujuan.getSelectedItem()).toString());
        int Kode = Outlet.indexOf(' ');
        String KodeOutlet = Outlet.substring(0, Kode);
        txtOutletTujuan.setText(String.valueOf(KodeOutlet));
    }//GEN-LAST:event_cboOutletTujuanItemStateChanged

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems DI = new DataItems(null, true);
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);

        Item = DI.getSelectedItems();

        if(Item==null){
            JOptionPane.showMessageDialog(this, "Item Belum Dipilih");
            return;
        }
        String Barcode = Item.getBarcode();
        txtBarcode.setText(new String(Barcode));
        StokItem.getSatuan(cboSatuan, Barcode);
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
        String Satuan = (((String)cboSatuan.getSelectedItem()).toString());
        String Barcode = (((String)txtBarcode.getText().trim()).toString());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        int KodeSatuan = Sat.getKodeSatuan(Satuan);

        int KodeStokItem = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
        ftxtKodeStokItem.setValue(new Integer(KodeStokItem));

        Calendar Tanggal = dchTanggal.getCalendar();

        int KodeStokBrng = StokBrng.getLastKodeStok(Barcode, KodeOutlet, KodeSatuan, Tanggal);
        ftxtKodeStokBrng.setValue(new Integer(KodeStokBrng));
    }//GEN-LAST:event_cboSatuanItemStateChanged

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            StokItem.getSatuan(cboSatuan, Barcode);
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboDriver;
    private javax.swing.JComboBox<String> cboMobil;
    private javax.swing.JComboBox<String> cboOutletTujuan;
    public javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTanggal;
    private javax.swing.JFormattedTextField ftxtBiaya;
    private javax.swing.JFormattedTextField ftxtGrandTotalModal;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeStokBrng;
    private javax.swing.JFormattedTextField ftxtKodeStokItem;
    private javax.swing.JFormattedTextField ftxtKodeTF;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel lblBiaya;
    private javax.swing.JLabel lblDriver;
    private javax.swing.JLabel lblGrandTotalModal;
    private javax.swing.JLabel lblKeterangan;
    private javax.swing.JLabel lblKodeTF;
    private javax.swing.JLabel lblMobil;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JPanel pnlPemindahanStok;
    private javax.swing.JScrollPane scrlRincianTransfer;
    private javax.swing.JTable tblRincianTransfer;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtKeterangan;
    private javax.swing.JTextField txtKodeKerja;
    private javax.swing.JTextField txtKodeMobil;
    private javax.swing.JTextField txtOutletTujuan;
    // End of variables declaration//GEN-END:variables
}
