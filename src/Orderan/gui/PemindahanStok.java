/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orderan.gui;

import App.Outlet;
import HumanResource.Pekerjaan;
import Inventori.ComboBoxEditorSatuan;
import Inventori.ComboBoxRendererSatuan;
import Inventori.Items;
import Inventori.Satuan;
import Inventori.StokBarang;
import Inventori.StokItem;
import Inventori.gui.DaftarItems;
import Inventori.gui.DataItems;
import Orderan.*;
import Transaksi.gui.DataTransaksi;
import Util.BackgroundPane;
import Util.BackgroundImage;
import Util.DBConnector;
import Util.DoubleFormatTableAlignment;
import Util.Table;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Yestin
 */
public class PemindahanStok extends javax.swing.JFrame {

    TransferStok TS = new TransferStok();
    RincianTransfer RT = new RincianTransfer();
    RincianTransfer RincianTransfer[];
    Pekerjaan Kerja = new Pekerjaan();
    Mobil mbl = new Mobil();
    Outlet Cab = new Outlet();
    Items Item = new Items();
    Satuan Sat = new Satuan();
    BackgroundImage BI = new BackgroundImage();
    StokItem StokItem = new StokItem();
    StokItem StokItm[];
    StokBarang StokBrng = new StokBarang();
    StokBarang StokBarang[];
    Table Tab = new Table();
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    /**
     * Creates new form TransferStok
     */
    public PemindahanStok() {
        initComponents();
        setTitle("Transfer Stok");
        BI.BackgroundJPanel(this, pnlPemindahanStok);
//        try {
//            BackgroundPane Background = new BackgroundPane();
//            Background.setBackground(ImageIO.read(new File("\\E-POS\\Green Background 37.jpeg")));
//            Background.setLayout(new BorderLayout());
//            pnlPemindahanStok.setOpaque(false);
//            Background.add(pnlPemindahanStok,BorderLayout.CENTER);
//            this.setLayout(new BorderLayout());
//            this.add(Background, BorderLayout.CENTER);
//        }
//        catch (IOException e) {
//            Logger.getLogger(DataTransaksi.class.getName()).log(Level.SEVERE, null, e);
//        }
        
        ftxtKodeTF.setValue(new Integer(0));
        ftxtKodeTF.setValue(null);
        dchTanggal.setCalendar(Calendar.getInstance());
        dchTanggal.setDateFormatString("dd-MM-yyyy");
        ((JTextFieldDateEditor)dchTanggal.getDateEditor()).setForeground(Color.BLUE);
        ftxtKodeUser.setValue(new Integer(0));
        ftxtKodeUser.setValue(null);
        ftxtBiaya.setValue(new Double(0.00));
        ftxtKuantitas.setValue(new Double(0.00));
        ftxtKuantitas.setValue(null);
        ftxtGrandTotalModal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                            new DecimalFormat("#,##0"))));
        ftxtGrandTotalModal.setValue(new Double(0.00));
        Kerja.getDriver(cboDriver);
        mbl.getMobil(cboMobil);
        Cab.getOutlet(cboOutletTujuan);
        InitTableTransferStok();
        NumberFormatTable();
        Tab.TableAlignment7(tblRincianTransfer, Left, Left, Center, Center, Center, Right, Right, Center);
    }
    private void InitTableTransferStok(){
        tblRincianTransfer.setModel(new DefaultTableModel(){
            String ColName[] = {"Barcode","Nama Item","Satuan","Sisa Stok","Stok TF","Harga Modal","Total Modal"};
            Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
            
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
                return 7;
            }
        });
        
        tblRincianTransfer.getColumnModel().getColumn(0).setPreferredWidth(100);
        tblRincianTransfer.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblRincianTransfer.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblRincianTransfer.getColumnModel().getColumn(3).setPreferredWidth(50);
        tblRincianTransfer.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblRincianTransfer.getColumnModel().getColumn(5).setPreferredWidth(70);
        tblRincianTransfer.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    private void NumberFormatTable(){
        DoubleFormatTableAlignment dfta = new DoubleFormatTableAlignment();
        
        tblRincianTransfer.getColumnModel().getColumn(5).setCellRenderer(dfta);
        tblRincianTransfer.getColumnModel().getColumn(6).setCellRenderer(dfta);
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
        btnBerikut = new javax.swing.JButton();
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
        ftxtKodeSatuan = new javax.swing.JFormattedTextField();
        btnHapus = new javax.swing.JButton();

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
        tblRincianTransfer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblRincianTransferMouseClicked(evt);
            }
        });
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
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cetak.png"))); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

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

        btnBerikut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Berikut.png"))); // NOI18N
        btnBerikut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerikutActionPerformed(evt);
            }
        });

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

        ftxtKodeSatuan.setEditable(false);
        ftxtKodeSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Hapus.png"))); // NOI18N

        javax.swing.GroupLayout pnlPemindahanStokLayout = new javax.swing.GroupLayout(pnlPemindahanStok);
        pnlPemindahanStok.setLayout(pnlPemindahanStokLayout);
        pnlPemindahanStokLayout.setHorizontalGroup(
            pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrlRincianTransfer)
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
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addGap(310, 310, 310)
                .addComponent(btnSimpan)
                .addGap(32, 32, 32)
                .addComponent(btnCetak)
                .addGap(41, 41, 41)
                .addComponent(btnTutup)
                .addGap(0, 297, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPemindahanStokLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblGrandTotalModal)
                .addGap(18, 18, 18)
                .addComponent(ftxtGrandTotalModal, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
            .addGroup(pnlPemindahanStokLayout.createSequentialGroup()
                .addGap(106, 106, 106)
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
                                    .addComponent(btnBerikut)
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
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtKodeSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(lblGrandTotalModal)
                    .addComponent(btnHapus))
                .addGap(39, 39, 39)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBerikut)
                    .addGroup(pnlPemindahanStokLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtKodeStokItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeStokBrng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addGap(51, 51, 51)
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
        DataItems DI = new DataItems(this, true);
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);
        
        Item = DI.getSelectedItems();
        
        if(Item==null){
            JOptionPane.showMessageDialog(this, "Item Belum Dipilih");
            return;
        }
        String Barcode = Item.getBarcode();
        txtBarcode.setText(new String(Barcode));
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
        if(tblRincianTransfer.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblRincianTransfer.getSelectedRow();
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        String Satuan = (((String)cboSatuan.getSelectedItem()).toString());
        int KodeSatuan = Sat.getKodeSatuan(Satuan);
        dtm.setValueAt(new String(Satuan), row, 2);
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSat = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSat);
        ftxtKodeStokItem.setValue(new Integer(KodeStok));
        Double SisaStok = StokItem.getKuantitas(KodeStok);
        dtm.setValueAt(new Double(SisaStok), row, 3);
        Double StokTF = (((Double)dtm.getValueAt(row, 4)).doubleValue());
        Double HrgModal = StokItem.getHargaModal(KodeStok);
        dtm.setValueAt(new Double(HrgModal), row, 5);
        Double Total = (StokTF * HrgModal);
        dtm.setValueAt(new Double(Total), row, 6);
        
        HitungGrandTotalModal();
    }//GEN-LAST:event_cboSatuanItemStateChanged

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
        
        DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
        
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
        for(int i=0;i<dtm.getRowCount();i++){
            
            if((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode()) && ((boolean)dtm.getValueAt(i, 2).equals(Sat.getKodeSatuan()))){
                String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                String NamaSatuan = ((String)dtm.getValueAt(i, 2)).toString();
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokKeluar = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                
                //Double Qtty = (((Double)ftxtKuantitas.getValue()).doubleValue());
                int KodeStok = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                if((StokKeluar+Kuantitas)>SisaStok){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Tersedia!");
                    return;
                }
                StokKeluar = StokKeluar + 1;
                dtm.setValueAt(new Double(StokKeluar), i, 4);
                
                Double HrgModal =(((Double)dtm.getValueAt(i, 5)).doubleValue());
                dtm.setValueAt(new Double(HrgModal), i, 5);
                Double Total = StokKeluar*HrgModal;
                dtm.setValueAt(new Double(Total), i, 6);
                
                SdhAda = true;
                break;
            }
        }
        
        if(!SdhAda){
            Object rowdata[] = new Object[7];
            
            rowdata[0] = new String(Barcode);
            String NamaItem = Item.getNamaItem(Barcode);
            rowdata[1] = new String(NamaItem);
            String NamaSatuan = "Kardus";
            rowdata[2] = NamaSatuan;
            int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
            int KodeStokItem = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            Double SisaStok = StokItem.getKuantitas(KodeStokItem);
            rowdata[3] = new Double(SisaStok);
            Double StokKeluar = (((Double)ftxtKuantitas.getValue()).doubleValue());
            if(KodeStokItem>0){
                if((StokKeluar)>StokItem.getKuantitas(KodeStokItem)){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Tersedia!");
                    return;
                }
            }
            
            rowdata[4] = new Double(StokKeluar);
            Double HrgModal = StokItem.getHargaModal(KodeStokItem);
            rowdata[5] = new Double(HrgModal);
            Double Total = (StokKeluar * HrgModal);
            rowdata[6] = new Double(Total);
            
            dtm.addRow(rowdata);
        }
        NumberFormatTable();
        HitungGrandTotalModal();
    }//GEN-LAST:event_btnBerikutActionPerformed

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            Double Kuantitas = (((Double)ftxtKuantitas.getValue()).doubleValue());
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
            
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
            for(int i=0;i<dtm.getRowCount();i++){
                
                if((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode()) && ((boolean)dtm.getValueAt(i, 2).equals(Sat.getKodeSatuan()))){
                    String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                    String NamaSatuan = ((String)dtm.getValueAt(i, 2)).toString();
                    int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                    Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                    Double StokKeluar = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                    //Double Qtty = (((Double)ftxtKuantitas.getValue()).doubleValue());
                    int KodeStok = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                    if((SisaStok+StokKeluar+1)>StokItem.getKuantitas(KodeStok)){
                        JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Tersedia!");
                        return;
                    }
                    StokKeluar = StokKeluar + 1;
                    dtm.setValueAt(new Double(StokKeluar), i, 4);
                    
                    Double HrgModal =(((Double)dtm.getValueAt(i, 5)).doubleValue());
                    dtm.setValueAt(new Double(HrgModal), i, 5);
                    Double Total = StokKeluar*HrgModal;
                    dtm.setValueAt(new Double(Total), i, 6);
                    
                    SdhAda = true;
                    break;
                }
            }
            
            if(!SdhAda){
                Object rowdata[] = new Object[7];
                
                rowdata[0] = new String(Barcode);
                String NamaItem = Item.getNamaItem(Barcode);
                rowdata[1] = new String(NamaItem);
                String NamaSatuan = "Kardus";
                rowdata[2] = NamaSatuan;
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                int KodeStokItem = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                Double SisaStok = StokItem.getKuantitas(KodeStokItem);
                rowdata[3] = new Double(SisaStok);
                Double StokKeluar = 1.00;
                if(KodeStokItem>0){
                    if((SisaStok+StokKeluar)>StokItem.getKuantitas(KodeStokItem)){
                        JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Tersedia!");
                        return;
                    }
                }
                
                rowdata[4] = new Double(StokKeluar);
                Double HrgModal = StokItem.getHargaModal(KodeStokItem);
                rowdata[5] = new Double(HrgModal);
                Double Total = (StokKeluar * HrgModal);
                rowdata[6] = new Double(Total);
                
                dtm.addRow(rowdata);
            }
            NumberFormatTable();
            HitungGrandTotalModal();
       }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(dchTanggal.getCalendar()==null){
            JOptionPane.showMessageDialog(this, "Tanggal Belum Diisi");
            return;
        }
        if(cboDriver.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Driver Belum Dipilih");
            return;
        }
        if(cboMobil.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Mobil Belum Dipilih");
            return;
        }
        if(cboOutletTujuan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Outlet Tujuan Belum Dipilh");
            return;
        }
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        int OutletTujuan = Integer.valueOf(((String)txtOutletTujuan.getText().trim()).toString());
        if(KodeOutlet==OutletTujuan){
            JOptionPane.showMessageDialog(this, "Outlet Saat Ini Tidak Boleh Sama Dengan Outlet Tujuan");
            return;
        }
        
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        TS.setKodeUser(KodeUser);
        Calendar Tanggal = dchTanggal.getCalendar();
        TS.setTanggal(Tanggal);
        int KodeKerja = Integer.valueOf(((String)txtKodeKerja.getText().trim()).toString());
        TS.setKodeKerja(KodeKerja);
        int KodeMobil = Integer.valueOf(((String)txtKodeMobil.getText().trim()).toString());
        TS.setKodeMobil(KodeMobil);
        TS.setOutletAsal(KodeOutlet);
        TS.setOutletTujuan(OutletTujuan);
        TS.setStatusDelivery(1);
        Double Biaya = (((Double)ftxtBiaya.getValue()).doubleValue());
        TS.setBiaya(Biaya);
        String Keterangan = (((String)txtKeterangan.getText().trim()).toString());
        
        try {
            TS.Simpan(KodeUser, 0, Tanggal, KodeKerja, KodeMobil, KodeOutlet, OutletTujuan, 1, Biaya, Keterangan);
            
            int KodeTF = TS.getKodeTF();
            ftxtKodeTF.setValue(new Integer(KodeTF));
            
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
            RincianTransfer = new RincianTransfer[dtm.getRowCount()];
            for(int i=0;i<RincianTransfer.length;i++){
                RincianTransfer[i] = new RincianTransfer();
                
                RincianTransfer[i].setKodeTF(KodeTF);
                String Barcode = ((String)dtm.getValueAt(i, 0)).toString();
                RincianTransfer[i].setBarcode(Barcode);
                String Satuan = (((String)dtm.getValueAt(i, 2)).toString());
                RincianTransfer[i].setSatuan(Satuan);
                Double Kuantitas = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                RincianTransfer[i].setStokDikirim(Kuantitas);
                Double HrgModal = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                RincianTransfer[i].setHargaModal(HrgModal);
                Double TotalModal = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                RincianTransfer[i].setTotalModal(TotalModal);
                
                RincianTransfer[i].Simpan(KodeTF, Barcode, Satuan, Kuantitas, 0.00, HrgModal, TotalModal);
            }
            
            StokItm = new StokItem[dtm.getRowCount()];
            for(int i=0;i<StokItm.length;i++){
                StokItm[i] = new StokItem();
                
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                StokItm[i].setBarcode(Barcode);
                String Satuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(Satuan);
                int KodeStokItm = StokItm[i].getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                StokItm[i].setKodeSatuan(KodeSatuan);
                Double Kuantitas = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                StokItm[i].setKuantitas(Kuantitas);
                Double Isi = StokItm[i].getIsi(KodeStokItm);
                Double HrgModal = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                StokItm[i].setHargaModal(HrgModal);
                Double TotModal = Kuantitas * HrgModal;
                if(KodeStokItm>0){
                    StokItm[i].KurangiKuantitas(KodeStokItm, Kuantitas);
                }
                else if(KodeStokItm==0){
                    StokItm[i].Simpan(Barcode, KodeOutlet, KodeSatuan, Kuantitas, Isi, 0.00, 0.00, HrgModal, 0.00, 0.00);
                }
            }
            
            StokBarang = new StokBarang[dtm.getRowCount()];
            for(int i=0;i<StokBarang.length||i<StokItm.length;i++){
                StokBarang[i] = new StokBarang();
                StokItm[i] = new StokItem();
                
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                StokBarang[i].setBarcode(Barcode);
                String Satuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(Satuan);
                Double Kuantitas = (((Double)dtm.getValueAt(i, 4)));
                int LastKodeStok = StokBarang[i].getLastKodeStok(Barcode, KodeOutlet, KodeSatuan, Tanggal);
                int KodeStokItem = StokItm[i].getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                
                if(LastKodeStok>0){
                    Double LastStokKeluar = StokBarang[i].getStokKeluar(LastKodeStok);
                    Double StokKeluar = LastStokKeluar + Kuantitas;
                    StokBarang[i].TambahStokKeluar(LastKodeStok, StokKeluar);
                    Double Sisa = StokItm[i].getKuantitas(KodeStokItem);
                    Double SisaStok = Sisa - Kuantitas;
                    StokBarang[i].UpdateSisaStok(LastKodeStok, SisaStok);
                    Double HrgModal = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                    StokBarang[i].UpdateHargaModal(LastKodeStok, HrgModal);
//                    Double TotalModal = Kuantitas * HrgModal;
//                    StokBarang[i].TambahTotalModal(LastKodeStok, TotalModal);
                }
                else if(LastKodeStok==0){
                    Double Sisa = StokItm[i].getKuantitas(KodeStokItem);
                    Double SisaStok = Sisa - Kuantitas;
                    Double HargaModal = StokItm[i].getHargaModal(KodeStokItem);
                    Double TotalModal = Kuantitas * HargaModal;
                    StokBarang[i].Simpan(Barcode, KodeOutlet, KodeSatuan, Tanggal, 0.00, Kuantitas, SisaStok, HargaModal, TotalModal, 0.00, 0.00);
                }
            }
            
            DBConnector.getConnection().commit();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Menyimpan Data : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if(ftxtKodeTF.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "KodeTF Stok Belum Ada");
            return;
        }
        int KodeTF = (((Integer)ftxtKodeTF.getValue()).intValue());
        JasperPrint JP = null;
        String ReportPath = "\\E-POS\\Report\\";
        String ReportFileName = null;
        URL Resource = this.getClass().getResource(ReportPath);
        try {
            java.util.Map<String,Object> params = new java.util.HashMap<String,Object>();
            params.put("KodeTF", Integer.valueOf(KodeTF));
            
            ReportFileName = ReportPath + "SuratJalan2.jasper";
            JP = JasperFillManager.fillReport(ReportFileName, params, DBConnector.getConnection());
            
            JP.setOrientation(OrientationEnum.PORTRAIT);
            JasperViewer JV = new JasperViewer(JP, false);
            JV.setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
            JV.setVisible(true);
            JV.setFitPageZoomRatio();
        } 
        catch (JRException e) {
            e.printStackTrace();
            return;
        }
        catch (Exception e){
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void tblRincianTransferMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblRincianTransferMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
        int row = tblRincianTransfer.getSelectedRow();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = StokItem.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
        ftxtKodeStokItem.setValue(new Integer(KodeStok));
        
        // Ambil nilai yang akan diatur dalam kolom "Satuan"
        String newSatuan = StokItem.getNamaSatuan(cboSatuan, Barcode, KodeOutlet);

        // Ambil nilai yang saat ini ada dalam kolom "Satuan"
        String currentSatuan = (((String)dtm.getValueAt(row, 2)).toString());
    }//GEN-LAST:event_tblRincianTransferMouseClicked

    private void HitungGrandTotalModal(){
        DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
        Double GrandTotal = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            Double Total = ((Double)dtm.getValueAt(i, 6)).doubleValue();
            GrandTotal += Total;
        }
        ftxtGrandTotalModal.setValue(new Double(GrandTotal));
    }
        
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerikut;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboDriver;
    private javax.swing.JComboBox<String> cboMobil;
    private javax.swing.JComboBox<String> cboOutletTujuan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTanggal;
    private javax.swing.JFormattedTextField ftxtBiaya;
    private javax.swing.JFormattedTextField ftxtGrandTotalModal;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeSatuan;
    private javax.swing.JFormattedTextField ftxtKodeStokBrng;
    private javax.swing.JFormattedTextField ftxtKodeStokItem;
    private javax.swing.JFormattedTextField ftxtKodeTF;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
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
