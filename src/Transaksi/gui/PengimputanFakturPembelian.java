/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import Inventori.Items;
import Inventori.Satuan;
import Inventori.StokItem;
import Inventori.gui.DataItems;
import Transaksi.*;
import Transaksi.RincianTransaksi;
import Transaksi.Transaksi;
import Util.BackgroundImage;
import Util.DBConnector;
import Util.DoubleFormatTableAlignment;
import Util.NumberFormatTableAlignment;
import Util.Table;
import com.toedter.calendar.JTextFieldDateEditor;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
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
public class PengimputanFakturPembelian extends javax.swing.JFrame {

    Transaksi trans = new Transaksi();
    RincianTransaksi RT = new RincianTransaksi();
    RincianTransaksi RincianTransaksi[]; 
    BusinessContact BC = new BusinessContact();
    JenisPembayaran JP = new JenisPembayaran();
    Items Item = new Items();
    StokItem SI = new StokItem();
    Satuan Sat = new Satuan();
    BackgroundImage BI = new BackgroundImage();
    Table Tab = new Table();
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    /**
     * Creates new form PengimputanFakturPembelian
     */
    public PengimputanFakturPembelian() {
        initComponents();
        setTitle("Pengimputan Faktur Pembelian");
        InitTableFaktur();
        BI.BackgroundJPanel(this, pnlPengimputanFaktur);
        ftxtNoNota.setValue(new Integer(0));
        ftxtNoNota.setValue(null);
        ((JTextFieldDateEditor)dchTglTransaksi.getDateEditor()).setForeground(Color.BLUE);
        dchTglTransaksi.setDateFormatString("dd-MM-yyyy");
        txtNoFaktur.setText(new String());
        txtNoFaktur.setText(null);
        txtNamaSupplier.setText(new String());
        txtNamaSupplier.setText(null);
        ((JTextFieldDateEditor)dchTglJatuhTempo.getDateEditor()).setForeground(Color.BLUE);
        dchTglJatuhTempo.setDateFormatString("dd-MM-yyyy");
        txtBarcode.setText(new String());
        txtBarcode.setText(null);
        ftxtKuantitas.setValue(new Double(0.00));
        ftxtKuantitas.setValue(null);
        
        ftxtDiskon.setValue(new Double(0.00));
        
        ftxtSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                    new DecimalFormat("#,##0"))));
        ftxtSubTotal.setValue(new Double(0.00));
        ftxtPPN.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                    new DecimalFormat("#,##0"))));
        ftxtPPN.setValue(new Double(0.00));
        ftxtGrandTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                    new DecimalFormat("#,##0"))));
        ftxtGrandTotal.setValue(new Double(0.00));
        ftxtJmlhPembayaran.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                    new DecimalFormat("#,##0"))));
        ftxtJmlhPembayaran.setValue(new Double(0.00));
        ftxtJmlhLunas.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                     new DecimalFormat("#,##0"))));
        ftxtJmlhLunas.setValue(new Double(0.00));
        
        JP.getJenisPembayaran(cboJenisPembayaran);
        Tab.TableAlignment7(tblFaktur, Left, Left, Center, Center, Right, Center, Right, Center);
    }
    private void InitTableFaktur(){
        tblFaktur.setModel(new DefaultTableModel(){
            String ColName[] = {"Barcode","Nama Item","Satuan","Kuantitas","Harga Modal","Diskon","Total"};
            Class ColType[] ={String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
            
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
        
        tblFaktur.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblFaktur.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblFaktur.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblFaktur.getColumnModel().getColumn(3).setPreferredWidth(100);
        tblFaktur.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblFaktur.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblFaktur.getColumnModel().getColumn(6).setPreferredWidth(100);
    }
    
    public void NumberFormatTable(){
        NumberFormatTableAlignment nfta = new NumberFormatTableAlignment();
        DoubleFormatTableAlignment dfta = new DoubleFormatTableAlignment();
        
        tblFaktur.getColumnModel().getColumn(3).setCellRenderer(dfta);
        tblFaktur.getColumnModel().getColumn(4).setCellRenderer(dfta);
        tblFaktur.getColumnModel().getColumn(5).setCellRenderer(dfta);
        tblFaktur.getColumnModel().getColumn(6).setCellRenderer(dfta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPengimputanFaktur = new javax.swing.JPanel();
        lblNoNota = new javax.swing.JLabel();
        ftxtNoNota = new javax.swing.JFormattedTextField();
        lblTglTransaksi = new javax.swing.JLabel();
        dchTglTransaksi = new com.toedter.calendar.JDateChooser();
        txtNoFaktur = new javax.swing.JTextField();
        lblNoFaktur = new javax.swing.JLabel();
        lblNamaSupplier = new javax.swing.JLabel();
        txtNamaSupplier = new javax.swing.JTextField();
        scrlFaktur = new javax.swing.JScrollPane();
        tblFaktur = new javax.swing.JTable();
        ftxtSubTotal = new javax.swing.JFormattedTextField();
        lblRp1 = new javax.swing.JLabel();
        lblSubTotal = new javax.swing.JLabel();
        ftxtPPN = new javax.swing.JFormattedTextField();
        lblPPN = new javax.swing.JLabel();
        lblRp2 = new javax.swing.JLabel();
        ftxtGrandTotal = new javax.swing.JFormattedTextField();
        lblRp3 = new javax.swing.JLabel();
        lblGrandTotal = new javax.swing.JLabel();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        btnDataSupplier = new javax.swing.JButton();
        ftxtKodeBC = new javax.swing.JFormattedTextField();
        lblJmlhPembayaran = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ftxtJmlhPembayaran = new javax.swing.JFormattedTextField();
        lblJmlhLunas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ftxtJmlhLunas = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cboSatuan = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        ftxtKuantitas = new javax.swing.JFormattedTextField();
        btnDaftarItem = new javax.swing.JButton();
        btnBerikut = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        cboJenisPembayaran = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cboOrderan = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        dchTglJatuhTempo = new com.toedter.calendar.JDateChooser();
        ftxtKodeJenis = new javax.swing.JFormattedTextField();
        lblDiskon = new javax.swing.JLabel();
        ftxtDiskon = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        ftxtHargaModal = new javax.swing.JFormattedTextField();
        ftxtKodeStok = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ftxtSisaPembayaran = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        ftxtKembali = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtStatusPelunasan = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoNota.setForeground(new java.awt.Color(0, 0, 255));
        lblNoNota.setText("No Nota :");

        ftxtNoNota.setEditable(false);
        ftxtNoNota.setForeground(new java.awt.Color(0, 0, 255));
        ftxtNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTglTransaksi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTglTransaksi.setForeground(new java.awt.Color(0, 0, 255));
        lblTglTransaksi.setText("Tanggal Transaksi :");

        dchTglTransaksi.setForeground(new java.awt.Color(0, 0, 255));

        txtNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoFaktur.setForeground(new java.awt.Color(0, 0, 255));

        lblNoFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoFaktur.setForeground(new java.awt.Color(0, 0, 255));
        lblNoFaktur.setText("No Faktur :");

        lblNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaSupplier.setText("Nama Supplier :");

        txtNamaSupplier.setEditable(false);
        txtNamaSupplier.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaSupplier.setForeground(new java.awt.Color(0, 0, 255));

        tblFaktur.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblFaktur.setForeground(new java.awt.Color(51, 0, 255));
        tblFaktur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFakturMouseClicked(evt);
            }
        });
        scrlFaktur.setViewportView(tblFaktur);

        ftxtSubTotal.setEditable(false);
        ftxtSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblRp1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRp1.setForeground(new java.awt.Color(0, 0, 255));
        lblRp1.setText("Rp");

        lblSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblSubTotal.setText("Sub Total :");

        ftxtPPN.setEditable(false);
        ftxtPPN.setForeground(new java.awt.Color(0, 0, 255));
        ftxtPPN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPPN.setForeground(new java.awt.Color(0, 51, 255));
        lblPPN.setText("PPN (11%) :");

        lblRp2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRp2.setForeground(new java.awt.Color(0, 0, 255));
        lblRp2.setText("Rp");

        ftxtGrandTotal.setEditable(false);
        ftxtGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblRp3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblRp3.setForeground(new java.awt.Color(0, 0, 255));
        lblRp3.setText("Rp");

        lblGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblGrandTotal.setText("Grand Total :");

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

        btnTutup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnDataSupplier.setForeground(new java.awt.Color(0, 0, 255));
        btnDataSupplier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DataSupplier.png"))); // NOI18N
        btnDataSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataSupplierActionPerformed(evt);
            }
        });

        ftxtKodeBC.setEditable(false);
        ftxtKodeBC.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeBC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblJmlhPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJmlhPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblJmlhPembayaran.setText("Jumlah Pembayaran :");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Rp");

        ftxtJmlhPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        ftxtJmlhPembayaran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtJmlhPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtJmlhPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtJmlhPembayaranKeyPressed(evt);
            }
        });

        lblJmlhLunas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJmlhLunas.setForeground(new java.awt.Color(0, 0, 255));
        lblJmlhLunas.setText("Jumlah Lunas :");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Rp");

        ftxtJmlhLunas.setEditable(false);
        ftxtJmlhLunas.setForeground(new java.awt.Color(0, 0, 255));
        ftxtJmlhLunas.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtJmlhLunas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

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

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 255));
        jLabel4.setText("Satuan :");

        cboSatuan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboSatuan.setForeground(new java.awt.Color(0, 0, 255));
        cboSatuan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSatuanItemStateChanged(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Kuantitas :");

        ftxtKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DataItem.png"))); // NOI18N
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
            }
        });

        btnBerikut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Berikut.png"))); // NOI18N
        btnBerikut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerikutActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("Jenis Pembayaran :");

        cboJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        cboJenisPembayaran.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJenisPembayaranItemStateChanged(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 255));
        jLabel7.setText("Orderan :");

        cboOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOrderan.setForeground(new java.awt.Color(0, 0, 255));
        cboOrderan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Direct Order", "Purchase Order" }));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 255));
        jLabel8.setText("Tgl Jatuh Tempo :");

        dchTglJatuhTempo.setForeground(new java.awt.Color(0, 0, 255));

        ftxtKodeJenis.setEditable(false);
        ftxtKodeJenis.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeJenis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblDiskon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblDiskon.setForeground(new java.awt.Color(0, 0, 255));
        lblDiskon.setText("Diskon :");

        ftxtDiskon.setForeground(new java.awt.Color(0, 0, 255));
        ftxtDiskon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 255));
        jLabel9.setText("Harga Modal :");

        ftxtHargaModal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtHargaModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeStok.setEditable(false);
        ftxtKodeStok.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeStok.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 255));
        jLabel10.setText("Sisa Pembayaran :");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 255));
        jLabel11.setText("Rp");

        ftxtSisaPembayaran.setEditable(false);
        ftxtSisaPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSisaPembayaran.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtSisaPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 255));
        jLabel12.setText("Kembali :");

        ftxtKembali.setEditable(false);
        ftxtKembali.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 255));
        jLabel13.setText("Rp");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 255));
        jLabel14.setText("Satatus Pelunasan :");

        jLabel15.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 255));
        jLabel15.setText("Rp");

        txtStatusPelunasan.setEditable(false);
        txtStatusPelunasan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtStatusPelunasan.setForeground(new java.awt.Color(51, 0, 255));

        javax.swing.GroupLayout pnlPengimputanFakturLayout = new javax.swing.GroupLayout(pnlPengimputanFaktur);
        pnlPengimputanFaktur.setLayout(pnlPengimputanFakturLayout);
        pnlPengimputanFakturLayout.setHorizontalGroup(
            pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                .addComponent(scrlFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNamaSupplier)
                                    .addComponent(lblNoFaktur))
                                .addGap(41, 41, 41)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btnDataSupplier)
                                .addGap(41, 41, 41)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))
                                .addGap(26, 26, 26)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cboJenisPembayaran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cboOrderan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                .addComponent(lblNoNota)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtKodeStok, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblTglTransaksi)
                                .addGap(18, 18, 18)
                                .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSimpan)
                        .addGap(63, 63, 63)
                        .addComponent(btnCetak)
                        .addGap(57, 57, 57)
                        .addComponent(btnTutup))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblDiskon)
                            .addComponent(jLabel9)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(35, 35, 35)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(ftxtDiskon)
                                .addComponent(ftxtHargaModal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBarcode)
                                .addComponent(cboSatuan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ftxtKuantitas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                            .addComponent(btnBerikut))
                        .addGap(43, 43, 43)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                                .addComponent(btnDaftarItem)
                                .addGap(128, 128, 128)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblGrandTotal)
                                    .addComponent(lblPPN, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblSubTotal, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblRp2, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblRp1, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(lblRp3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtSubTotal)
                                    .addComponent(ftxtPPN)
                                    .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel12)
                                    .addComponent(lblJmlhPembayaran))
                                .addGap(21, 21, 21)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ftxtJmlhPembayaran)
                                    .addComponent(ftxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPengimputanFakturLayout.createSequentialGroup()
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(lblJmlhLunas)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ftxtJmlhLunas, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(ftxtSisaPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtStatusPelunasan)))))))
                .addContainerGap())
        );
        pnlPengimputanFakturLayout.setVerticalGroup(
            pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoNota)
                        .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTglTransaksi)
                        .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNoFaktur)
                            .addComponent(txtNoFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNamaSupplier)
                            .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnDataSupplier)
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cboOrderan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(dchTglJatuhTempo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrlFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRp1)
                    .addComponent(lblSubTotal))
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPPN)
                            .addComponent(lblRp2)))
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12))
                            .addComponent(btnDaftarItem, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblRp3)
                    .addComponent(lblGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtJmlhPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(lblJmlhPembayaran)
                    .addComponent(jLabel5)
                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(ftxtHargaModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(ftxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtJmlhLunas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(lblJmlhLunas))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(ftxtSisaPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(txtStatusPelunasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTutup)
                            .addComponent(btnCetak, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlPengimputanFakturLayout.createSequentialGroup()
                        .addGroup(pnlPengimputanFakturLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiskon)
                            .addComponent(ftxtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBerikut)))
                .addGap(422, 422, 422))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPengimputanFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPengimputanFaktur, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataSupplierActionPerformed
        // TODO add your handling code here:
        DataSupplier DS = new DataSupplier(this, true);
        DS.setLocationRelativeTo(this);
        DS.setVisible(true);
        
        BC = DS.getSelectedSupplier();
        
        int KodeBC = BC.getKodeBC();
        ftxtKodeBC.setValue(new Integer(KodeBC));
        String NamaSupplier = BC.getNamaBC(KodeBC);
        txtNamaSupplier.setText(NamaSupplier);
    }//GEN-LAST:event_btnDataSupplierActionPerformed

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems DI = new DataItems(this, true);
        
        DI.btnEdit.setVisible(false);
        DI.btnHapus.setVisible(false);
        
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);
        
        Item = DI.getSelectedItems();
        
        String Barcode = Item.getBarcode();
        txtBarcode.setText(Barcode);
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        int KodeSatuan = SI.getKodeSatuan(Barcode, KodeOutlet);
        int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
        Double HargaModal = SI.getHargaModal(KodeStokItem);
        ftxtHargaModal.setValue(new Double(HargaModal));
        
    }//GEN-LAST:event_btnDaftarItemActionPerformed

    private void btnBerikutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBerikutActionPerformed
        // TODO add your handling code here:
        if(txtBarcode.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
            return;
        }
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String Barcode = (((String)txtBarcode.getText().trim()).toString());
        
        Double Kuantitas = (((Double)ftxtKuantitas.getValue()).doubleValue());
        
        
        DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
        
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
                String KodeBarcode = (((String)dtm.getValueAt(i, 0)).toString());
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                
                Double Qtty = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Qtty = Qtty + Kuantitas;
                dtm.setValueAt(new Double(Qtty), i, 3);
                
                Double HrgModal = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                dtm.setValueAt(new Double(HrgModal), i, 5);
                Double Diskon = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                dtm.setValueAt(new Double(Diskon), i, 5);
                Double Total = (Kuantitas * HrgModal) - (Kuantitas * HrgModal * (Diskon/100));
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
            int KodeSatuan = SI.getKodeSatuan(Barcode);
            String NamaSatuan = Sat.getNamaSatuan(KodeSatuan);
            rowdata[2] = new String(NamaSatuan);
            Double Qtty = (((Double)ftxtKuantitas.getValue()).doubleValue());
            rowdata[3] = new Double(Qtty);
            int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            Double HrgModal = (((Double)ftxtHargaModal.getValue()).doubleValue());
            rowdata[4] = new Double(HrgModal);
            Double Diskon = (((Double)ftxtDiskon.getValue()).doubleValue());
            rowdata[5] = new Double(Diskon);
            Double Total = (Qtty * HrgModal) - (Qtty * HrgModal * (Diskon/100));
            rowdata[6] = new Double(Total);
            
            dtm.addRow(rowdata);
        }
        NumberFormatTable();
        HitungGrandTotal();
    }//GEN-LAST:event_btnBerikutActionPerformed

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

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txtBarcode.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
                return;
            }
            
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            
            Double Kuantitas = (((Double)ftxtKuantitas.getValue()).doubleValue());
            
            
            DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
            
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
                    String KodeBarcode = (((String)dtm.getValueAt(i, 0)).toString());
                    String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                    int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                
                    Double Qtty = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                    Qtty = Qtty + 1;
                    dtm.setValueAt(new Double(Qtty), i, 3);
                    
                    Double HrgModal = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                    dtm.setValueAt(new Double(HrgModal), i, 5);
                    Double Diskon = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                    dtm.setValueAt(new Double(Diskon), i, 5);
                    Double Total = (Kuantitas * HrgModal) - (Kuantitas * HrgModal * Diskon);
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
                int KodeSatuan = SI.getKodeSatuan(Barcode);
                String NamaSatuan = Sat.getNamaSatuan(KodeSatuan);
                rowdata[2] = new String(NamaSatuan);
                Double Qtty = 1.00;
                rowdata[3] = new Double(Qtty);
                int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                Double HrgModal = SI.getHargaModal(KodeStokItem);
                rowdata[4] = new Double(HrgModal);
                Double Diskon = (((Double)ftxtDiskon.getValue()).doubleValue());
                rowdata[5] = new Double(Diskon);
                Double Total = (Qtty * HrgModal) - (Qtty * HrgModal * Diskon);
                rowdata[6] = new Double(Total);
                
                dtm.addRow(rowdata);
            }
            NumberFormatTable();
            HitungGrandTotal();
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void tblFakturMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFakturMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
        int row = tblFaktur.getSelectedRow();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
        ftxtKodeStok.setValue(new Double(KodeStok));
        
        String newSatuan = SI.getNamaSatuan(cboSatuan, Barcode, KodeOutlet);
        
        String currentSatuan = (((String)dtm.getValueAt(row, 2)).toString());
    }//GEN-LAST:event_tblFakturMouseClicked

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
        int row = tblFaktur.getSelectedRow();
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        String Satuan = (((String)cboSatuan.getSelectedItem()).toString());
        int KodeSatuan = Sat.getKodeSatuan(Satuan);
        int KodeStok = SI.getKodeStok(Barcode,KodeOutlet,KodeSatuan);
        ftxtKodeStok.setValue(KodeStok);
        Double Kuantitas = (((Double)dtm.getValueAt(row, 3)).doubleValue());
        Double HrgModal = SI.getHargaModal(KodeStok);
        dtm.setValueAt(new Double(HrgModal), row, 4);
        Double Diskon = (((Double)dtm.getValueAt(row, 5)).doubleValue());
        Double Total = (Kuantitas*HrgModal) - (Kuantitas*HrgModal*(Diskon/100));
        dtm.setValueAt(new Double(Total), row, 6);
        
        HitungGrandTotal();
    }//GEN-LAST:event_cboSatuanItemStateChanged

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
                Double JmlhLunas = JmlhPembayaran - Kembali;
                ftxtJmlhLunas.setValue(new Double(JmlhLunas));
                Double Sisa = JmlhPembayaran - (GrandTotal+Kembali);
                ftxtSisaPembayaran.setValue(new Double(Sisa));
                txtStatusPelunasan.setText("Lunas");
            }
            else if(JmlhPembayaran<GrandTotal){
                Double SisaPembayaran = GrandTotal - JmlhPembayaran;
                ftxtKembali.setValue(new Double(0.00));
                ftxtJmlhLunas.setValue(new Double(JmlhPembayaran));
                ftxtSisaPembayaran.setValue(new Double(SisaPembayaran));
                txtStatusPelunasan.setText("Belum Lunas");
            }
            
        }
    }//GEN-LAST:event_ftxtJmlhPembayaranKeyPressed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(dchTglTransaksi.getCalendar()==null){
            JOptionPane.showMessageDialog(this, "Tanggal Transaksi Belum Diisi");
            return;
        }
        if(txtNamaSupplier.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "Nama Supplier Belum Diisi");
            return;
        }
        if(cboOrderan.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(this, "Orderan Belum Dipilih");
            return;
        }
        if(((Double)ftxtGrandTotal.getValue()).doubleValue()==0.00){
            JOptionPane.showMessageDialog(this, "Grand Total Belum Dihitung");
            return;
        }
        
        String NoFaktur = (((String)txtNoFaktur.getText().trim()).toString());
        trans.setNoFaktur(NoFaktur);
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        trans.setKodeOutlet(KodeOutlet);
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        trans.setKodeUser(KodeUser);
        int KodeBC = (((Integer)ftxtKodeBC.getValue()).intValue());
        trans.setKodeBC(KodeBC);
        Calendar TglTransaksi = dchTglTransaksi.getCalendar();
        trans.setTglTransaksi(TglTransaksi);
        trans.setJenisTransaksi(1);
        int KodeJenis= (((Integer)ftxtKodeJenis.getValue()).intValue());
        trans.setKodeJenis(KodeJenis);
        int Orderan = cboOrderan.getSelectedIndex();
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
        Double Diskon = (((Double)ftxtDiskon.getValue()).doubleValue());
        trans.setDiskon(Diskon);
        Double GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        trans.setGrandTotal(GrandTotal);
        Double JmlhPembayaran = (((Double)ftxtJmlhPembayaran.getValue()).doubleValue());
        trans.setJmlhPembayaran(JmlhPembayaran);
        Double Kembali = (((Double)ftxtKembali.getValue()).doubleValue());
        trans.setKembali(Kembali);
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
            Calendar TglJatuhTempo = dchTglJatuhTempo.getCalendar();
            trans.setTglJatuhTempo(TglJatuhTempo);
        }
        
        try {
            
            trans.Simpan(NoFaktur, KodeOutlet, KodeUser, KodeBC, TglTransaksi, 1, KodeJenis, Orderan, SubTotal, PPN, Diskon, GrandTotal, 
                    JmlhPembayaran, KodeJenis, TglTransaksi, PPN, Kembali, TglTransaksi);
            DBConnector.getConnection().commit();
            
            int NoNota = trans.getNoNota();
            ftxtNoNota.setValue(new Integer(NoNota));
            
            RincianTransaksi = new RincianTransaksi[tblFaktur.getRowCount()];
            
            DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
            for(int i=0;i<RincianTransaksi.length;i++){
                RincianTransaksi[i] = new RincianTransaksi();
                RincianTransaksi[i].setNoNota(NoNota);
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                RincianTransaksi[i].setBarcode(Barcode);
                String Satuan = (((String)dtm.getValueAt(i, 2)).toString());
                RincianTransaksi[i].setSatuan(Satuan);
                Double Kuantitas = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                RincianTransaksi[i].setKuantitas(Kuantitas);
                Double Harga = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                RincianTransaksi[i].setHarga(Harga);
                Double Disc = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                RincianTransaksi[i].setDiskon(Disc);
                Double Total = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                RincianTransaksi[i].setTotal(Total);
                
                RincianTransaksi[i].Simpan(NoNota, Barcode, Satuan, Kuantitas, Harga, Diskon, Total);
                DBConnector.getConnection().commit();
            }
            
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

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if(ftxtNoNota.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "No Nota Belum Ada");
            return;
        }
        int NoNota = ((Integer)ftxtNoNota.getValue()).intValue();
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
    private void HitungGrandTotal(){
        DefaultTableModel dtm = (DefaultTableModel)tblFaktur.getModel();
        Double SubTotal = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            Double Total = ((Double)dtm.getValueAt(i, 6)).doubleValue();
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
    private javax.swing.JButton btnDataSupplier;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboJenisPembayaran;
    public javax.swing.JComboBox<String> cboOrderan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTglJatuhTempo;
    private com.toedter.calendar.JDateChooser dchTglTransaksi;
    private javax.swing.JFormattedTextField ftxtDiskon;
    private javax.swing.JFormattedTextField ftxtGrandTotal;
    private javax.swing.JFormattedTextField ftxtHargaModal;
    private javax.swing.JFormattedTextField ftxtJmlhLunas;
    private javax.swing.JFormattedTextField ftxtJmlhPembayaran;
    private javax.swing.JFormattedTextField ftxtKembali;
    public javax.swing.JFormattedTextField ftxtKodeBC;
    private javax.swing.JFormattedTextField ftxtKodeJenis;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeStok;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
    public javax.swing.JFormattedTextField ftxtNoNota;
    private javax.swing.JFormattedTextField ftxtPPN;
    private javax.swing.JFormattedTextField ftxtSisaPembayaran;
    private javax.swing.JFormattedTextField ftxtSubTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lblDiskon;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblJmlhLunas;
    private javax.swing.JLabel lblJmlhPembayaran;
    private javax.swing.JLabel lblNamaSupplier;
    private javax.swing.JLabel lblNoFaktur;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JLabel lblPPN;
    private javax.swing.JLabel lblRp1;
    private javax.swing.JLabel lblRp2;
    private javax.swing.JLabel lblRp3;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTglTransaksi;
    private javax.swing.JPanel pnlPengimputanFaktur;
    private javax.swing.JScrollPane scrlFaktur;
    private javax.swing.JTable tblFaktur;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtNoFaktur;
    private javax.swing.JTextField txtStatusPelunasan;
    // End of variables declaration//GEN-END:variables
}
