/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import Inventori.ComboBoxEditorSatuan;
import Inventori.ComboBoxRendererSatuan;
import Inventori.CustomComboBoxEditor;
import Inventori.CustomComboBoxRenderer;
import Inventori.*;
import Inventori.Satuan;
import Inventori.StokBarang;
import Inventori.StokItem;
import Inventori.gui.DaftarItems;
import Inventori.gui.DataItems;
import Inventori.gui.RegistrasiKategori;
import Transaksi.BusinessContact;
import Transaksi.RincianTransaksi;
import Transaksi.*;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.DBConnector;
import Util.NumberFormatTableAlignment;
import Util.Table;
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
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.ComboBoxCellEditor;

/**
 *
 * @author Yestin
 */
public class Pembelian extends javax.swing.JFrame {

    Items Item = new Items();
    StokItem SI = new StokItem();
    StokItem StokItem[];
    StokBarang SB = new StokBarang();
    StokBarang StokBrng[];
    BackgroundImage BI = new BackgroundImage();
    Satuan Sat = new Satuan();
    BusinessContact BC = new BusinessContact();
    JenisPembayaran JP = new JenisPembayaran();
    Transaksi trans = new Transaksi();
    RincianTransaksi RincianTrans = new RincianTransaksi();
    RincianTransaksi RincianTransaksi[];
    Table Tab = new Table();
    
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    
    /**
     * Creates new form Pembelian
     */
    public Pembelian() {
        initComponents();
        setTitle("Pembelian");
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
        InitTableNota();
        dchTglTransaksi.setCalendar(Calendar.getInstance());
        dchTglTransaksi.setDateFormatString("dd-MM-yyyy");
        ftxtNoNota.setValue(new Integer(0));
        ftxtNoNota.setValue(null);
        ftxtKodeBC.setValue(new Integer(0));
        ftxtKodeBC.setValue(null);
        txtNamaSupplier.setText(new String());
        txtNamaSupplier.setText(null);
        txtBarcode.setText(new String());
        txtBarcode.setText(null);
        ftxtKuantitas.setValue(new Double(0));
        ftxtHargaModal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtHargaModal.setValue(new Double(0.00));
        ftxtSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtSubTotal.setValue(new Double(0.00));
        ftxtPPN.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtPPN.setValue(new Double(0.00));
        ftxtGrandTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotal.setValue(new Double(0.00));
        BI.BackgroundJPanel(this, pnlPembelian);
        JP.getJenisPembayaran(cboJenisPembayaran);
        Tab.TableAlignment8(tblPembelian, Left, Left, Center, Center, Center, Right, Center, Right, Center);
        NumberFormatTable();
        Tab.setHeaderForegroundColor(tblPembelian, Color.BLUE);
    }
    public void InitTableNota(){
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
                return 8;
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
    }
    public void NumberFormatTable(){
        NumberFormatTableAlignment nfta = new NumberFormatTableAlignment();
        
        tblPembelian.getColumnModel().getColumn(5).setCellRenderer(nfta);
        tblPembelian.getColumnModel().getColumn(6).setCellRenderer(nfta);
        tblPembelian.getColumnModel().getColumn(7).setCellRenderer(nfta);
    }
    public void InitTableNota2(){
        tblPembelian.setModel(new DefaultTableModel(){
            String ColName[] = {"Item","Category"};
            Class ColType[] = {String.class,JComboBox.class};
            
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
                return 2;
            }
       });
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
        lblNoNota = new javax.swing.JLabel();
        ftxtNoNota = new javax.swing.JFormattedTextField();
        dchTglTransaksi = new com.toedter.calendar.JDateChooser();
        lblTanggal = new javax.swing.JLabel();
        lblNamaSupplier = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        ftxtKodeBC = new javax.swing.JFormattedTextField();
        scrlNota = new javax.swing.JScrollPane();
        tblPembelian = new javax.swing.JTable();
        ftxtGrandTotal = new javax.swing.JFormattedTextField();
        lblGrandTotal = new javax.swing.JLabel();
        btnDaftarSupplier = new javax.swing.JButton();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        btnDaftarItem = new javax.swing.JButton();
        lblKuantitas = new javax.swing.JLabel();
        ftxtKuantitas = new javax.swing.JFormattedTextField();
        btnBerikut = new javax.swing.JButton();
        lblSatuan = new javax.swing.JLabel();
        cboSatuan = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        ftxtKodeJenis = new javax.swing.JFormattedTextField();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        lblNoFaktur = new javax.swing.JLabel();
        txtNoFaktur = new javax.swing.JTextField();
        lblJenisPembayaran = new javax.swing.JLabel();
        lblOrderan = new javax.swing.JLabel();
        lblJatuhTempo = new javax.swing.JLabel();
        cboJenisPembayaran = new javax.swing.JComboBox<>();
        cboOrderan = new javax.swing.JComboBox<>();
        dchTglJatuhTempo = new com.toedter.calendar.JDateChooser();
        btnHapus = new javax.swing.JButton();
        btnKurangiStok = new javax.swing.JButton();
        ftxtSubTotal = new javax.swing.JFormattedTextField();
        ftxtPPN = new javax.swing.JFormattedTextField();
        lblPPN = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        lblJmlhPembayaran = new javax.swing.JLabel();
        ftxtJmlhPembayaran = new javax.swing.JFormattedTextField();
        lblSisaPembayaran = new javax.swing.JLabel();
        ftxtSisaPembayaran = new javax.swing.JFormattedTextField();
        lblStatusPelunasan = new javax.swing.JLabel();
        txtStatusPelunasan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ftxtKembali = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        ftxtHargaModal = new javax.swing.JFormattedTextField();
        ftxtKodeStok = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        lblNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoNota.setForeground(new java.awt.Color(0, 0, 255));
        lblNoNota.setText("No Nota :");

        ftxtNoNota.setEditable(false);
        ftxtNoNota.setForeground(new java.awt.Color(0, 0, 255));
        ftxtNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dchTglTransaksi.setForeground(new java.awt.Color(0, 0, 255));
        dchTglTransaksi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTanggal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTanggal.setForeground(new java.awt.Color(0, 0, 255));
        lblTanggal.setText("Tanggal :");

        lblNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaSupplier.setText("Nama Supplier :");

        txtNamaSupplier.setEditable(false);
        txtNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));

        ftxtKodeBC.setEditable(false);
        ftxtKodeBC.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeBC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tblPembelian.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPembelianMouseClicked(evt);
            }
        });
        tblPembelian.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblPembelianKeyPressed(evt);
            }
        });
        scrlNota.setViewportView(tblPembelian);

        ftxtGrandTotal.setEditable(false);
        ftxtGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblGrandTotal.setText("Grand Total :");

        btnDaftarSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DataSupplier.png"))); // NOI18N
        btnDaftarSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarSupplierActionPerformed(evt);
            }
        });

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

        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DaftarItem.png"))); // NOI18N
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
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

        lblSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSatuan.setForeground(new java.awt.Color(0, 0, 255));
        lblSatuan.setText("Satuan :");

        cboSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboSatuan.setForeground(new java.awt.Color(0, 0, 255));
        cboSatuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSatuanItemStateChanged(evt);
            }
        });
        cboSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSatuanActionPerformed(evt);
            }
        });

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

        ftxtKodeJenis.setEditable(false);
        ftxtKodeJenis.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeJenis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoFaktur.setForeground(new java.awt.Color(0, 0, 255));
        lblNoFaktur.setText("No Faktur :");

        txtNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoFaktur.setForeground(new java.awt.Color(0, 0, 255));

        lblJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblJenisPembayaran.setText("Jenis Pembayaran :");

        lblOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOrderan.setForeground(new java.awt.Color(0, 0, 255));
        lblOrderan.setText("Orderan :");

        lblJatuhTempo.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJatuhTempo.setForeground(new java.awt.Color(0, 0, 255));
        lblJatuhTempo.setText("Jatuh Tempo :");

        cboJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        cboJenisPembayaran.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJenisPembayaranItemStateChanged(evt);
            }
        });

        cboOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOrderan.setForeground(new java.awt.Color(0, 0, 255));
        cboOrderan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Langsung", "Purchase Order" }));

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Hapus.png"))); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKurangiStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/KurangiStok.png"))); // NOI18N
        btnKurangiStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangiStokActionPerformed(evt);
            }
        });

        ftxtSubTotal.setEditable(false);
        ftxtSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtSubTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtSubTotalActionPerformed(evt);
            }
        });

        ftxtPPN.setEditable(false);
        ftxtPPN.setForeground(new java.awt.Color(0, 0, 255));
        ftxtPPN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPPN.setForeground(new java.awt.Color(51, 0, 255));
        lblPPN.setText("PPN (11%) :");

        lblSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblSubTotal.setText("Sub Total :");

        lblJmlhPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJmlhPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblJmlhPembayaran.setText("Jumlah Pembayaran :");

        ftxtJmlhPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        ftxtJmlhPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtJmlhPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtJmlhPembayaranKeyPressed(evt);
            }
        });

        lblSisaPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSisaPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblSisaPembayaran.setText("Sisa Pembayaran :");

        ftxtSisaPembayaran.setEditable(false);
        ftxtSisaPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSisaPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblStatusPelunasan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblStatusPelunasan.setForeground(new java.awt.Color(0, 0, 255));
        lblStatusPelunasan.setText("Satatus Pelunasan :");

        txtStatusPelunasan.setEditable(false);
        txtStatusPelunasan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtStatusPelunasan.setForeground(new java.awt.Color(0, 0, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Kembali :");

        ftxtKembali.setEditable(false);
        ftxtKembali.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtKembaliActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("Harga Modal :");

        ftxtHargaModal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtHargaModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeStok.setEditable(false);
        ftxtKodeStok.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeStok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout pnlPembelianLayout = new javax.swing.GroupLayout(pnlPembelian);
        pnlPembelian.setLayout(pnlPembelianLayout);
        pnlPembelianLayout.setHorizontalGroup(
            pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addComponent(lblNoNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTanggal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNamaSupplier)
                            .addComponent(lblNoFaktur))
                        .addGap(72, 72, 72)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(btnDaftarSupplier)
                                .addGap(18, 18, 18)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtKodeOutlet)
                                    .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
                                .addGap(12, 12, 12)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtKodeUser, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(ftxtKodeStok)))
                            .addComponent(txtNamaSupplier)
                            .addComponent(txtNoFaktur))
                        .addGap(51, 51, 51)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJenisPembayaran)
                            .addComponent(lblOrderan)
                            .addComponent(lblJatuhTempo))
                        .addGap(33, 33, 33)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cboJenisPembayaran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cboOrderan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addComponent(scrlNota, javax.swing.GroupLayout.PREFERRED_SIZE, 1206, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addComponent(btnHapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnKurangiStok)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ftxtSubTotal)
                            .addComponent(ftxtPPN, javax.swing.GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblJmlhPembayaran)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblBarcode)
                                    .addComponent(lblSatuan)
                                    .addComponent(lblKuantitas))
                                .addGap(96, 96, 96)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtHargaModal)
                                    .addComponent(txtBarcode)
                                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                    .addComponent(cboSatuan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(btnDaftarItem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblPPN)
                                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                                        .addComponent(lblGrandTotal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblSubTotal)))
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addComponent(btnBerikut)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGap(261, 261, 261)
                                .addComponent(btnSimpan)
                                .addGap(63, 63, 63)
                                .addComponent(btnCetak)
                                .addGap(62, 62, 62)
                                .addComponent(btnTutup))
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                                        .addGap(163, 163, 163)
                                        .addComponent(ftxtJmlhPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2))
                                .addGap(27, 27, 27)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatusPelunasan)
                                    .addComponent(lblSisaPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtStatusPelunasan)
                                    .addComponent(ftxtSisaPembayaran, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
                                    .addComponent(ftxtKembali))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlPembelianLayout.setVerticalGroup(
            pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPembelianLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoNota)
                            .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoFaktur)
                            .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnDaftarSupplier)
                            .addGroup(pnlPembelianLayout.createSequentialGroup()
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtKodeStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblJenisPembayaran)
                            .addComponent(cboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblOrderan)
                            .addComponent(cboOrderan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(scrlNota, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnHapus)
                    .addComponent(btnKurangiStok)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubTotal))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPPN))))
                .addGap(16, 16, 16)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblBarcode)
                            .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSatuan)
                            .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblKuantitas)))
                    .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlPembelianLayout.createSequentialGroup()
                        .addComponent(btnDaftarItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBerikut)))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ftxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(ftxtHargaModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSisaPembayaran)
                    .addComponent(ftxtSisaPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJmlhPembayaran)
                    .addComponent(ftxtJmlhPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusPelunasan)
                    .addComponent(txtStatusPelunasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPembelianLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnTutup)
                        .addComponent(btnCetak)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPembelian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
        ftxtKodeBC.setValue(new Integer(KodeBC));
        String NamaBC = BC.getNamaBC(KodeBC);
        txtNamaSupplier.setText(new String(NamaBC));
    }//GEN-LAST:event_btnDaftarSupplierActionPerformed

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems DI = new DataItems(this, true);
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);
        
        Item = DI.getSelectedItems();
        
        String Barcode = Item.getBarcode();
        txtBarcode.setText(new String(Barcode));
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        SI.getSatuan(cboSatuan, Barcode, KodeOutlet);
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void cboJenisPembayaranItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboJenisPembayaranItemStateChanged
        // TODO add your handling code here:
        if(cboJenisPembayaran.getSelectedIndex()==0){
            ftxtKodeJenis.setValue(new Integer(0));
        }
        else{
            String JnsPembayaran = (((String)cboJenisPembayaran.getSelectedItem()).toString());
            int Kode = JnsPembayaran.indexOf(' ');
            String KodeJenis = JnsPembayaran.substring(0, Kode);
            int KodeJns = Integer.valueOf(KodeJenis);
            ftxtKodeJenis.setValue(KodeJns);
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
        for(int i=0;i<dtm.getRowCount();i++){
           
            if((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode()) && ((boolean)dtm.getValueAt(i, 2).equals(Sat.getKodeSatuan()))){
                String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                String NamaSatuan = ((String)dtm.getValueAt(i, 2)).toString();
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokMsuk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                Double Qtty = (((Double)ftxtKuantitas.getValue()).doubleValue());
                int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                if((SisaStok+Qtty)>SI.getStokMax(KodeStok)){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
                    return;
                }
                StokMsuk = StokMsuk + Qtty;
                dtm.setValueAt(new Double(StokMsuk), i, 4);
                
                Double HrgModal =(((Double)dtm.getValueAt(i, 5)).doubleValue());
                dtm.setValueAt(new Double(HrgModal), i, 5);
                Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                dtm.setValueAt(new Double(Diskon), i, 6);
                Double Total = (StokMsuk*HrgModal) - (StokMsuk*HrgModal*Diskon);
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
            int KodeSatuan = SI.getKodeSatuan(Barcode);
            int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            String NamaSatuan = (((String)cboSatuan.getSelectedItem()).toString());
            rowdata[2] = NamaSatuan;
            Double SisaStok = SI.getKuantitas(KodeStokItem);
            rowdata[3] = new Double(SisaStok);
            Double StokMasuk = (((Double)ftxtKuantitas.getValue()).doubleValue());
            if(KodeStokItem>0){
                if((SisaStok+StokMasuk)>SI.getStokMax(KodeStokItem)){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
                    return;
                }
            }
            
            rowdata[4] = new Double(StokMasuk);
            if(ftxtHargaModal.getValue() instanceof Double){
                if((((Double)ftxtHargaModal.getValue()).doubleValue())==0.00){
                    Double HrgModal = SI.getHargaModal(KodeStokItem);
                    rowdata[5] = new Double(HrgModal);
                    Double Diskon = SI.getDiskon(KodeStokItem)/100;
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HrgModal) - (StokMasuk * HrgModal * Diskon);
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
                else{
                    Double HargaModal = (((Double)ftxtHargaModal.getValue()).doubleValue());
                    rowdata[5] = new Double(HargaModal);
                    Double Diskon = SI.getDiskon(KodeStokItem)/100;
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HargaModal) - (StokMasuk * HargaModal * Diskon);
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
            }
            else if(ftxtHargaModal.getValue() instanceof Long){
                if((((Long)ftxtHargaModal.getValue()).doubleValue())==0.00){
                    Double HrgModal = SI.getHargaModal(KodeStokItem);
                    rowdata[5] = new Double(HrgModal);
                    Double Diskon = SI.getDiskon(KodeStokItem)/100;
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HrgModal) - (StokMasuk * HrgModal * Diskon);
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
                else{
                    Double HargaModal = (((Long)ftxtHargaModal.getValue()).doubleValue());
                    rowdata[5] = new Double(HargaModal);
                    Double Diskon = SI.getDiskon(KodeStokItem)/100;
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HargaModal) - (StokMasuk * HargaModal * Diskon);
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
            }
        }
        
        HitungGrandTotal();
    }//GEN-LAST:event_btnBerikutActionPerformed

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txtBarcode.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
               return;
            }
            
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            Double Kuantitas = 1.00;
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
            for(int i=0;i<dtm.getRowCount();i++){
                
                if((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode()) && ((boolean)dtm.getValueAt(i, 2).equals(Sat.getKodeSatuan()))){
                    String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                    String NamaSatuan = ((String)dtm.getValueAt(i, 2)).toString();
                    int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                    Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                    Double StokMsuk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                    Double Qtty = 1.00;
                    int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                    if((SisaStok+Qtty)>SI.getStokMax(KodeStok)){
                        JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
                        return;
                    }
                    StokMsuk = StokMsuk + Qtty;
                    dtm.setValueAt(new Double(StokMsuk), i, 4);
                    
                    Double HrgModal =(((Double)dtm.getValueAt(i, 5)).doubleValue());
                    dtm.setValueAt(new Double(HrgModal), i, 5);
                    Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                    dtm.setValueAt(new Double(Diskon), i, 6);
                    Double Total = (StokMsuk*HrgModal) - (StokMsuk*HrgModal*Diskon);
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
                int KodeSatuan = SI.getKodeSatuan(Barcode, 1);
                String NamaSatuan = Sat.getNamaSatuan(KodeSatuan);
                rowdata[2] = NamaSatuan;
                int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                Double SisaStok = SI.getKuantitas(KodeStokItem);
                rowdata[3] = new Double(SisaStok);
                Double StokMasuk = 1.00;
                if((SisaStok+StokMasuk)>SI.getStokMax(KodeStokItem)){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
                    return;
                }
                rowdata[4] = new Double(StokMasuk);
                if((((Double)ftxtHargaModal.getValue()).doubleValue())==0.00){
                    Double HrgModal = SI.getHargaModal(KodeStokItem);
                    rowdata[5] = new Double(HrgModal);
                    Double Diskon = SI.getDiskon(KodeStokItem);
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HrgModal) - (StokMasuk * HrgModal * (Diskon/100));
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
                else{
                    Double HargaModal = (((Double)ftxtHargaModal.getValue()).doubleValue());
                    rowdata[5] = new Double(HargaModal);
                    Double Diskon = SI.getDiskon(KodeStokItem);
                    rowdata[6] = new Double(Diskon);
                    Double Total = (StokMasuk * HargaModal) - (StokMasuk * HargaModal * (Diskon/100));
                    rowdata[7] = new Double(Total);
                    dtm.addRow(rowdata);
                }
            }
        
            HitungGrandTotal();
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(tblPembelian.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblPembelian.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        dtm.removeRow(row);
        HitungGrandTotal();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKurangiStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangiStokActionPerformed
        // TODO add your handling code here:
        if(tblPembelian.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblPembelian.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        Double Kuantitas = (((Double)dtm.getValueAt(row, 4)).doubleValue());
        Double StokMasuk = Kuantitas-1;
        dtm.setValueAt(new Double(StokMasuk), row, 4);
        Double Harga = (((Double)dtm.getValueAt(row, 5)).doubleValue());
        Double HrgDiskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
        if(HrgDiskon==0){
            Double Total = StokMasuk * Harga;
            dtm.setValueAt(Total, row, 7);
        }
        else if(HrgDiskon>0){
            Double Total = StokMasuk * HrgDiskon;
            dtm.setValueAt(Total, row, 7);
        }
        HitungGrandTotal();
    }//GEN-LAST:event_btnKurangiStokActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
//        if(tblPembelian.getSelectedRow()<=-1){
//            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
//            return;
//        }
        int row = tblPembelian.getSelectedRow();
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        String Satuan = (((String)cboSatuan.getSelectedItem()).toString());
        int KodeSatuan = Sat.getKodeSatuan(Satuan);
        dtm.setValueAt(new String(Satuan), row, 2);
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSat = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSat);
        ftxtKodeStok.setValue(new Integer(KodeStok));
        Double SisaStok = SI.getKuantitas(KodeStok);
        dtm.setValueAt(new Double(SisaStok), row, 3);
        Double StokMasuk = (((Double)dtm.getValueAt(row, 4)).doubleValue());
        Double HrgModal = SI.getHargaModal(KodeStok);
        dtm.setValueAt(new Double(HrgModal), row, 5);
        Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
        Double Total = (StokMasuk * HrgModal) - (StokMasuk * HrgModal * (Diskon/100));
        dtm.setValueAt(new Double(Total), row, 7);
        
        HitungGrandTotal();
    }//GEN-LAST:event_cboSatuanItemStateChanged

    private void tblPembelianMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPembelianMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        int row = tblPembelian.getSelectedRow();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
        ftxtKodeStok.setValue(new Integer(KodeStok));
        
        // Ambil nilai yang akan diatur dalam kolom "Satuan"
        String newSatuan = SI.getNamaSatuan(cboSatuan, Barcode, KodeOutlet);

        // Ambil nilai yang saat ini ada dalam kolom "Satuan"
        String currentSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        
    }//GEN-LAST:event_tblPembelianMouseClicked

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(dchTglTransaksi.getCalendar()==null){
            JOptionPane.showMessageDialog(this, "Tanggal Belum Diisi!");
            return;
        }
        if(txtNamaSupplier.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Supplier Belum Dipilih!");
            return;
        }
        if(cboJenisPembayaran.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Jenis Pembayaran Belum Dipilih!");
            return;
        }
        if(cboOrderan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Orderan Belum Dipilih!");
            return;
        }
        if(tblPembelian.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Tabel Pembelian Belum Diisi!");
            return;
        }
        
        
        String NoFaktur = (((String)txtNoFaktur.getText().trim()).toString());
        if(txtNoFaktur.getText().trim().length()>0){
            trans.setNoFaktur(NoFaktur);
        }
        else if(txtNoFaktur.getText().trim().length()==0){
            trans.setNoFaktur(null);
        }
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        trans.setKodeOutlet(KodeOutlet);
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        trans.setKodeUser(KodeUser);
        int KodeBC = (((Integer)ftxtKodeBC.getValue()).intValue());
        trans.setKodeBC(KodeBC);
        Calendar TglTransaksi = dchTglTransaksi.getCalendar();
        trans.setTglTransaksi(TglTransaksi);
        trans.setJenisTransaksi(1);
        int KodeJenis = (((Integer)ftxtKodeJenis.getValue()).intValue());
        trans.setKodeJenis(KodeJenis);
        if(cboOrderan.getSelectedIndex()==1){
            trans.setOrderan(1);
        }
        else if(cboOrderan.getSelectedIndex()==2){
            trans.setOrderan(2);
        }
        Double SubTotal = (((Double)ftxtSubTotal.getValue()).doubleValue());
        trans.setSubTotal(SubTotal);
        Double PPN = (((Double)ftxtPPN.getValue()).doubleValue());
        trans.setPPN(PPN);
        Double GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        trans.setGrandTotal(GrandTotal);
        Double JmlhPembayaran = (((Double)ftxtJmlhPembayaran.getValue()).doubleValue());
        Double Kembali = (((Double)ftxtKembali.getValue()).doubleValue());
        Double SisaPembayaran = (((Double)ftxtSisaPembayaran.getValue()).doubleValue());
        if(JmlhPembayaran>=GrandTotal){
            trans.setJmlhPembayaran(GrandTotal);
            trans.setStatusPelunasan(1);
            trans.setTglLunas(TglTransaksi);
            trans.setBayar(JmlhPembayaran);
            trans.setKembali(Kembali);
            trans.setTglJatuhTempo(null);
        }
        else if(JmlhPembayaran<GrandTotal){
            trans.setJmlhPembayaran(SisaPembayaran);
            trans.setStatusPelunasan(2);
            trans.setTglLunas(null);
            trans.setBayar(JmlhPembayaran);
            trans.setKembali(Kembali);
            Calendar TglJthTempo = dchTglJatuhTempo.getCalendar();
            trans.setTglJatuhTempo(TglJthTempo);
        }
        
        try {
            trans.Simpan();
            DBConnector.getConnection().commit();
            
            int NoNota = trans.getNoNota();
            ftxtNoNota.setValue(new Integer(NoNota));
            
            RincianTransaksi = new RincianTransaksi[tblPembelian.getRowCount()];
            
            DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
            for(int i=0;i<RincianTransaksi.length;i++){
                RincianTransaksi[i] = new RincianTransaksi();
                RincianTransaksi[i].setNoNota(NoNota);
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                RincianTransaksi[i].setBarcode(Barcode);
                String NamaItem = (((String)dtm.getValueAt(i, 1)).toString());
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                RincianTransaksi[i].setSatuan(NamaSatuan);
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokMasuk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                SisaStok = SisaStok + StokMasuk;
                dtm.setValueAt(SisaStok, i, 3);
                RincianTransaksi[i].setKuantitas(StokMasuk);
                Double Harga = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                RincianTransaksi[i].setHarga(Harga);
                Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                RincianTransaksi[i].setDiskon(Diskon);
                Double Total = (((Double)dtm.getValueAt(i, 7)).doubleValue());
                RincianTransaksi[i].setTotal(Total);
                
                RincianTransaksi[i].Simpan(NoNota, Barcode, NamaSatuan, StokMasuk, Harga, Diskon, Total);
                DBConnector.getConnection().commit();
            }
            
            StokItem = new StokItem[tblPembelian.getRowCount()];
            for(int i=0;i<StokItem.length;i++){
                StokItem[i] = new StokItem();
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                StokItem[i].setBarcode(Barcode);
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                StokItem[i].setKodeSatuan(KodeSatuan);
                int KodeStok = StokItem[i].getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokMasuk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                StokItem[i].setKuantitas(StokMasuk);
                Double HrgModal = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                if(KodeStok>0){
                    StokItem[i].TambahKuantitas(KodeStok, StokMasuk);
                    StokItem[i].UpdateHargaModal(KodeStok, HrgModal);
                    DBConnector.getConnection().commit();
                }
                else{
                    StokItem[i].Simpan(Barcode, KodeOutlet, KodeSatuan, StokMasuk, 0.00, 0.00, 0.00, HrgModal, 0.00, 0.00);
                    DBConnector.getConnection().commit();
                }
            }
            
            StokBrng = new StokBarang[tblPembelian.getRowCount()];
            for(int i=0;i<StokBrng.length;i++){
                StokBrng[i] = new StokBarang();
                
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                StokBrng[i].setBarcode(Barcode);
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                StokBrng[i].setKodeSatuan(KodeSatuan);
                Double Sisa = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Calendar Tanggal = dchTglTransaksi.getCalendar();
                int LastKodeStok = StokBrng[i].getLastKodeStok(Barcode, KodeOutlet, KodeSatuan, Tanggal);
                Double StokMasuk = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                Double HrgModal = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                Double TotalModal = StokMasuk * HrgModal;
                if(Barcode.equals(StokBrng[i].getBarcode(LastKodeStok)) && Tanggal.equals(StokBrng[i].getTanggal(LastKodeStok)) && 
                        KodeSatuan==StokBrng[i].getKodeSatuan(LastKodeStok) && KodeOutlet==StokBrng[i].getKodeOutlet(LastKodeStok)){
                    StokBrng[i].TambahStokMasuk(LastKodeStok, StokMasuk);
                    //StokBrng[i].TambahStokKeluar(LastKodeStok, 0.00);
                    Sisa = Sisa + StokMasuk;
                    StokBrng[i].UpdateSisaStok(LastKodeStok, Sisa);
                    StokBrng[i].UpdateHargaModal(LastKodeStok, HrgModal);
                }
                else{
                    StokBrng[i].Simpan(Barcode, KodeOutlet, KodeSatuan, Tanggal, StokMasuk, 0.00, Sisa, 
                                            HrgModal, TotalModal, 0.00, 0.00);
                }
            }
            
            DBConnector.getConnection().commit();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Menyimpan Transaksi Pembelian : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void ftxtJmlhPembayaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtJmlhPembayaranKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(((Double)ftxtGrandTotal.getValue()).doubleValue()==0){
                JOptionPane.showMessageDialog(this, "Grand Total Belum Dihitung!");
                return;
            }
            Double GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
            String JmlhBayar = ftxtJmlhPembayaran.getText().trim();
            Double JmlhPembayaran = Double.valueOf(JmlhBayar);
            ftxtJmlhPembayaran.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                                new DecimalFormat("#,##0"))));
            ftxtJmlhPembayaran.setValue(new Double(JmlhPembayaran));
            if(JmlhPembayaran>=GrandTotal){
                Double Kembali = JmlhPembayaran - GrandTotal;
                ftxtKembali.setValue(new Double(Kembali));
                Double Sisa = JmlhPembayaran - (GrandTotal+Kembali);
                ftxtSisaPembayaran.setValue(new Double(Sisa)); 
                txtStatusPelunasan.setText("Lunas");
            }
            else if(JmlhPembayaran<GrandTotal){
                Double SisaPembayaran = GrandTotal - JmlhPembayaran;
                ftxtKembali.setValue(new Double(0.00));
                ftxtSisaPembayaran.setValue(new Double(SisaPembayaran));
                txtStatusPelunasan.setText("Belum Lunas");
            }
        }
    }//GEN-LAST:event_ftxtJmlhPembayaranKeyPressed

    private void ftxtSubTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtSubTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtSubTotalActionPerformed

    private void ftxtKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtKembaliActionPerformed

    private void tblPembelianKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblPembelianKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
            int row = tblPembelian.getSelectedRow();
            Double StokMasuk = (((Double)dtm.getValueAt(row, 4)).doubleValue());
            Double HrgModal = (((Double)dtm.getValueAt(row, 5)).doubleValue());
            Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
            Double Total = (StokMasuk* HrgModal) - (StokMasuk*HrgModal*(Diskon/100));
            dtm.setValueAt(Total, row, 7);
            
            HitungGrandTotal();
        }
    }//GEN-LAST:event_tblPembelianKeyPressed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if(ftxtNoNota.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "No Nota Belum Ada");
            return;
        }
        int NoNota = (((Integer)ftxtNoNota.getValue()).intValue());
        JasperPrint JP = null;
        String ReportPath = "\\E-POS\\Report\\";
        String ReportFileName = null;
        URL Resource = this.getClass().getResource(ReportPath);
        try {
            java.util.Map<String, Object> params = new java.util.HashMap<String, Object>();
            params.put("NoNota", Integer.valueOf(NoNota));
            
            ReportFileName = ReportPath + "InvoicePembelian.jasper";
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
        catch(Exception e){
            e.printStackTrace();
            return;
        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void cboSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboSatuanActionPerformed
    private void HitungGrandTotal(){
        DefaultTableModel dtm = (DefaultTableModel)tblPembelian.getModel();
        Double SubTotal = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            Double Total = ((Double)dtm.getValueAt(i, 7)).doubleValue();
            SubTotal += Total;
        }
        ftxtSubTotal.setValue(new Double(SubTotal));
        Double SbTotal = (((Double)ftxtSubTotal.getValue()).doubleValue());
        Double PPN = SbTotal * 0.11;
        ftxtPPN.setValue(new Double(PPN));
        Double GrandTotal = SbTotal + PPN;
        ftxtGrandTotal.setValue(new Double(GrandTotal));
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBerikut;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnDaftarSupplier;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKurangiStok;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboJenisPembayaran;
    private javax.swing.JComboBox<String> cboOrderan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTglJatuhTempo;
    private com.toedter.calendar.JDateChooser dchTglTransaksi;
    private javax.swing.JFormattedTextField ftxtGrandTotal;
    private javax.swing.JFormattedTextField ftxtHargaModal;
    private javax.swing.JFormattedTextField ftxtJmlhPembayaran;
    private javax.swing.JFormattedTextField ftxtKembali;
    private javax.swing.JFormattedTextField ftxtKodeBC;
    private javax.swing.JFormattedTextField ftxtKodeJenis;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeStok;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
    private javax.swing.JFormattedTextField ftxtNoNota;
    private javax.swing.JFormattedTextField ftxtPPN;
    private javax.swing.JFormattedTextField ftxtSisaPembayaran;
    private javax.swing.JFormattedTextField ftxtSubTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblJatuhTempo;
    private javax.swing.JLabel lblJenisPembayaran;
    private javax.swing.JLabel lblJmlhPembayaran;
    private javax.swing.JLabel lblKuantitas;
    private javax.swing.JLabel lblNamaSupplier;
    private javax.swing.JLabel lblNoFaktur;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JLabel lblOrderan;
    private javax.swing.JLabel lblPPN;
    private javax.swing.JLabel lblSatuan;
    private javax.swing.JLabel lblSisaPembayaran;
    private javax.swing.JLabel lblStatusPelunasan;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTanggal;
    private javax.swing.JPanel pnlPembelian;
    private javax.swing.JScrollPane scrlNota;
    private javax.swing.JTable tblPembelian;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtNoFaktur;
    private javax.swing.JTextField txtStatusPelunasan;
    // End of variables declaration//GEN-END:variables
}
