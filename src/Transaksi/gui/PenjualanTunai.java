/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import HumanResource.Sift;
import Inventori.Items;
import Inventori.Satuan;
import Inventori.StokBarang;
import Inventori.StokItem;
import Inventori.gui.DataItems;
import Transaksi.*;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.DBConnector;
import Util.NumberFormatTableAlignment;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Yestin
 */
public class PenjualanTunai extends javax.swing.JFrame {

    Transaksi trans = new Transaksi();
    RincianTransaksi RT = new RincianTransaksi();
    Poin Poin = new Poin();
    Sift Sift = new Sift();
    Items Item = new Items();
    StokItem SI = new StokItem();
    StokBarang SB = new StokBarang();
    Satuan Sat = new Satuan();
    Member Member = new Member();
    BusinessContact BC = new BusinessContact();
    JenisPembayaran JP = new JenisPembayaran();
    LabaItem LI = new LabaItem();
    LabaHarian LH = new LabaHarian();
    LabaMingguan LM = new LabaMingguan();
    LabaBulanan LB = new LabaBulanan();
    LabaTahunan LT = new LabaTahunan();
    BackgroundImage BI = new BackgroundImage();
    Table Tab = new Table();
    RincianTransaksi RincianTransaksi[];
    StokItem StokItem[];
    StokBarang StokBrng[];
    LabaItem LabaItem[];
    
    int LEFT = SwingConstants.LEFT;
    int CENTER = SwingConstants.CENTER;
    int RIGHT = SwingConstants.RIGHT;
    /**
     * Creates new form Penjualan
     */
    public PenjualanTunai() {
        initComponents();
        setTitle("Penjualan Tunai");
        InitTableNota();
        ftxtNoNota.setValue(new Integer(0));
        ftxtNoNota.setValue(null);
        dchTglTransaksi.setCalendar(Calendar.getInstance());
        dchTglTransaksi.setDateFormatString("dd-MM-yyyy");
        ((JTextFieldDateEditor)dchTglTransaksi.getDateEditor()).setForeground(Color.BLUE);
        txtNoMember.setText(new String());
        txtNoMember.setText(null);
        txtNoHP.setText(new String());
        txtNoHP.setText(null);
        txtNama.setText(new String());
        txtNama.setText(null);
        txtLevel.setText(new String());
        txtLevel.setText(null);
        dchTglExpire.getCalendarButton().setVisible(false);
        dchTglExpire.setDateFormatString("dd-MM-yyyy");
        ((JTextFieldDateEditor)dchTglExpire.getDateEditor()).setEditable(false);
        ((JTextFieldDateEditor)dchTglExpire.getDateEditor()).setForeground(Color.BLUE);
        dchTglExpire.setEnabled(false);
        ftxtTotalPoin.setValue(new Integer(0));
        ftxtTotalPoin.setValue(null);
        txtBarcode.setText(new String());
        txtBarcode.setText(null);
        ftxtKuantitas.setValue(new Double(0.00));
        ftxtKuantitas.setValue(null);
        ftxtSubTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtSubTotal.setValue(new Double(0.00));
        ftxtPPN.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtPPN.setValue(new Double(0.00));
        ftxtDiskon.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtDiskon.setValue(new Double(0.00));
        ftxtGrandTotal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotal.setValue(new Double(0.00));
        ftxtGrandTotal2.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotal2.setValue(new Double(0.00));
        ftxtGrandTotalModal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotalModal.setValue(new Double(0.00));
        ftxtGrandTotalDiskon.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtGrandTotalDiskon.setValue(new Double(0.00));
        ftxtKembali.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtKembali.setValue(new Double(0.00));
        lblNoMember.setEnabled(false);
        txtNoMember.setEnabled(false);
        lblNoHP.setEnabled(false);
        lblNama.setEnabled(false);
        lblLevel.setEnabled(false);
        lblTglExpire.setEnabled(false);
        txtNoMember.setEnabled(false);
        txtNoHP.setEnabled(false);
        txtNama.setEnabled(false);
        txtLevel.setEnabled(false);
        ftxtKodeOutlet.setVisible(false);
        ftxtKodeBC.setVisible(false);
        ftxtKodeJenis.setVisible(false);
        ftxtKodeStokBrng.setVisible(false);
        ftxtKodeStokItem.setVisible(false);
        ftxtKodeUser.setVisible(false);
        ftxtGrandTotalModal.setVisible(false);
        ftxtGrandTotalDiskon.setVisible(false);
        ftxtSift.setVisible(false);
        txtNamaUser.setVisible(false);
        txtNamaUser.setVisible(false);
        txtNamaBisnis.setVisible(false);
        BI.BackgroundJPanel(this, pnlPenjualan);
        Tab.TableAlignment8(tblNota, LEFT, LEFT, CENTER, CENTER, CENTER, RIGHT, CENTER, RIGHT, CENTER);
        JP.getJenisPembayaran(cboJenisPembayaran);
        Tab.setHeaderForegroundColor(tblNota, Color.BLUE);
        NumberFormatTable();
    }
    private void InitTableNota(){
        tblNota.setModel(new DefaultTableModel(){
            String ColName[] = {"Barcode","Nama Item","Satuan","Sisa Stok","Stok Keluar","Harga Jual","Diskon(%)","Total"};
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
        
        tblNota.getColumnModel().getColumn(0).setPreferredWidth(80);
        tblNota.getColumnModel().getColumn(1).setPreferredWidth(150);
        tblNota.getColumnModel().getColumn(2).setPreferredWidth(50);
        tblNota.getColumnModel().getColumn(3).setPreferredWidth(80);
        tblNota.getColumnModel().getColumn(4).setPreferredWidth(80);
        tblNota.getColumnModel().getColumn(5).setPreferredWidth(100);
        tblNota.getColumnModel().getColumn(6).setPreferredWidth(80);
        tblNota.getColumnModel().getColumn(7).setPreferredWidth(100);
    }
    public void NumberFormatTable(){
        NumberFormatTableAlignment nfta = new NumberFormatTableAlignment();
        
        tblNota.getColumnModel().getColumn(5).setCellRenderer(nfta);
        tblNota.getColumnModel().getColumn(6).setCellRenderer(nfta);
        tblNota.getColumnModel().getColumn(7).setCellRenderer(nfta);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgMember = new javax.swing.ButtonGroup();
        pnlPenjualan = new javax.swing.JPanel();
        lblNoNota = new javax.swing.JLabel();
        ftxtNoNota = new javax.swing.JFormattedTextField();
        dchTglTransaksi = new com.toedter.calendar.JDateChooser();
        lblTglTransaksi = new javax.swing.JLabel();
        lblMember = new javax.swing.JLabel();
        rbYa = new javax.swing.JRadioButton();
        rbTidak = new javax.swing.JRadioButton();
        lblNoMember = new javax.swing.JLabel();
        txtNoMember = new javax.swing.JTextField();
        lblNoHP = new javax.swing.JLabel();
        txtNoHP = new javax.swing.JTextField();
        lblLevel = new javax.swing.JLabel();
        txtLevel = new javax.swing.JTextField();
        lblNama = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        ftxtDiskon = new javax.swing.JFormattedTextField();
        lblTglExpire = new javax.swing.JLabel();
        scrlNota = new javax.swing.JScrollPane();
        tblNota = new javax.swing.JTable();
        ftxtSubTotal = new javax.swing.JFormattedTextField();
        lblSubTotal = new javax.swing.JLabel();
        ftxtPPN = new javax.swing.JFormattedTextField();
        cbPPN = new javax.swing.JCheckBox();
        lblGrandTotal = new javax.swing.JLabel();
        ftxtGrandTotal = new javax.swing.JFormattedTextField();
        btnHapus = new javax.swing.JButton();
        btnKurangiStok = new javax.swing.JButton();
        lblBarcode = new javax.swing.JLabel();
        txtBarcode = new javax.swing.JTextField();
        btnDaftarItem = new javax.swing.JButton();
        lblSatuan = new javax.swing.JLabel();
        cboSatuan = new javax.swing.JComboBox<>();
        lblKuantitas = new javax.swing.JLabel();
        ftxtKuantitas = new javax.swing.JFormattedTextField();
        btnBerikut = new javax.swing.JButton();
        lblBayar = new javax.swing.JLabel();
        cboJenisPembayaran = new javax.swing.JComboBox<>();
        ftxtJmlhPembayaran = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        ftxtGrandTotal2 = new javax.swing.JFormattedTextField();
        lblRupiah = new javax.swing.JLabel();
        ftxtKembali = new javax.swing.JFormattedTextField();
        lblJenisPembayaran = new javax.swing.JLabel();
        lblOrderan = new javax.swing.JLabel();
        cboOrderan = new javax.swing.JComboBox<>();
        btnSimpan = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        dchTglExpire = new com.toedter.calendar.JDateChooser();
        lblSaldoPoin = new javax.swing.JLabel();
        ftxtTotalPoin = new javax.swing.JFormattedTextField();
        btnCekPoin = new javax.swing.JButton();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        ftxtSift = new javax.swing.JFormattedTextField();
        txtKodeJenis = new javax.swing.JFormattedTextField();
        ftxtKodeBC = new javax.swing.JFormattedTextField();
        lblPoinBelanja = new javax.swing.JLabel();
        ftxtPoinBelanja = new javax.swing.JFormattedTextField();
        ftxtGrandTotalModal = new javax.swing.JFormattedTextField();
        ftxtGrandTotalDiskon = new javax.swing.JFormattedTextField();
        ftxtKodeStokItem = new javax.swing.JFormattedTextField();
        ftxtKodeStokBrng = new javax.swing.JFormattedTextField();
        cbDiskon = new javax.swing.JCheckBox();
        btnTambahStok = new javax.swing.JButton();
        ftxtKodeJenis = new javax.swing.JFormattedTextField();
        txtNamaUser = new javax.swing.JTextField();
        txtNamaBisnis = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pnlPenjualan.setForeground(new java.awt.Color(0, 0, 255));
        pnlPenjualan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoNota.setForeground(new java.awt.Color(0, 0, 255));
        lblNoNota.setText("No Nota :");

        ftxtNoNota.setEditable(false);
        ftxtNoNota.setForeground(new java.awt.Color(0, 0, 255));
        ftxtNoNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblTglTransaksi.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTglTransaksi.setForeground(new java.awt.Color(0, 0, 255));
        lblTglTransaksi.setText("Tanggal :");

        lblMember.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblMember.setForeground(new java.awt.Color(0, 0, 255));
        lblMember.setText("Member? ");

        bgMember.add(rbYa);
        rbYa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbYa.setForeground(new java.awt.Color(0, 0, 255));
        rbYa.setText("Ya");
        rbYa.setOpaque(false);
        rbYa.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbYaItemStateChanged(evt);
            }
        });

        bgMember.add(rbTidak);
        rbTidak.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbTidak.setForeground(new java.awt.Color(0, 0, 255));
        rbTidak.setSelected(true);
        rbTidak.setText("Tidak");
        rbTidak.setOpaque(false);
        rbTidak.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbTidakItemStateChanged(evt);
            }
        });

        lblNoMember.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoMember.setForeground(new java.awt.Color(0, 0, 255));
        lblNoMember.setText("No Member :");
        lblNoMember.setEnabled(false);

        txtNoMember.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoMember.setForeground(new java.awt.Color(0, 0, 255));
        txtNoMember.setEnabled(false);
        txtNoMember.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoMemberKeyPressed(evt);
            }
        });

        lblNoHP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNoHP.setForeground(new java.awt.Color(0, 0, 255));
        lblNoHP.setText("No HP/WA :");
        lblNoHP.setEnabled(false);

        txtNoHP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNoHP.setForeground(new java.awt.Color(0, 0, 255));
        txtNoHP.setEnabled(false);
        txtNoHP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoHPKeyPressed(evt);
            }
        });

        lblLevel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblLevel.setForeground(new java.awt.Color(0, 0, 255));
        lblLevel.setText("Level :");
        lblLevel.setEnabled(false);

        txtLevel.setEditable(false);
        txtLevel.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLevel.setForeground(new java.awt.Color(0, 0, 255));
        txtLevel.setEnabled(false);

        lblNama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 255));
        lblNama.setText("Nama :");
        lblNama.setEnabled(false);

        txtNama.setEditable(false);
        txtNama.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNama.setForeground(new java.awt.Color(0, 0, 255));

        ftxtDiskon.setForeground(new java.awt.Color(0, 0, 255));
        ftxtDiskon.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtDiskon.setEnabled(false);
        ftxtDiskon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtDiskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtDiskonKeyPressed(evt);
            }
        });

        lblTglExpire.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblTglExpire.setForeground(new java.awt.Color(0, 0, 255));
        lblTglExpire.setText("Tgl Expire :");
        lblTglExpire.setEnabled(false);

        tblNota.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblNota.setForeground(new java.awt.Color(0, 0, 255));
        tblNota.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNotaMouseClicked(evt);
            }
        });
        tblNota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblNotaKeyPressed(evt);
            }
        });
        scrlNota.setViewportView(tblNota);

        ftxtSubTotal.setEditable(false);
        ftxtSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtSubTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtSubTotal.setToolTipText("");
        ftxtSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblSubTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSubTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblSubTotal.setText("Sub Total :");

        ftxtPPN.setEditable(false);
        ftxtPPN.setForeground(new java.awt.Color(0, 0, 255));
        ftxtPPN.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbPPN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPPN.setForeground(new java.awt.Color(0, 0, 255));
        cbPPN.setText("PPN (11%) :");
        cbPPN.setOpaque(false);
        cbPPN.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPPNItemStateChanged(evt);
            }
        });
        cbPPN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPPNActionPerformed(evt);
            }
        });

        lblGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        lblGrandTotal.setText("Grand Total :");

        ftxtGrandTotal.setEditable(false);
        ftxtGrandTotal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ftxtGrandTotal.setToolTipText("");
        ftxtGrandTotal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnHapus.setBackground(new java.awt.Color(255, 255, 255));
        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Hapus.png"))); // NOI18N
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnKurangiStok.setBackground(new java.awt.Color(255, 255, 255));
        btnKurangiStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/KurangiStok.png"))); // NOI18N
        btnKurangiStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangiStokActionPerformed(evt);
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

        btnDaftarItem.setBackground(new java.awt.Color(255, 255, 255));
        btnDaftarItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/DataItem.png"))); // NOI18N
        btnDaftarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarItemActionPerformed(evt);
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

        lblKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKuantitas.setForeground(new java.awt.Color(0, 0, 255));
        lblKuantitas.setText("Kuantitas :");

        ftxtKuantitas.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKuantitas.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnBerikut.setBackground(new java.awt.Color(255, 255, 255));
        btnBerikut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Berikut.png"))); // NOI18N
        btnBerikut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBerikutActionPerformed(evt);
            }
        });

        lblBayar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblBayar.setForeground(new java.awt.Color(0, 0, 255));
        lblBayar.setText("Bayar :");

        cboJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        cboJenisPembayaran.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJenisPembayaranItemStateChanged(evt);
            }
        });

        ftxtJmlhPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        ftxtJmlhPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtJmlhPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftxtJmlhPembayaranKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("Kembali :");

        ftxtGrandTotal2.setEditable(false);
        ftxtGrandTotal2.setBorder(null);
        ftxtGrandTotal2.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotal2.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        ftxtGrandTotal2.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        ftxtGrandTotal2.setOpaque(false);

        lblRupiah.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lblRupiah.setForeground(new java.awt.Color(0, 0, 255));
        lblRupiah.setText("Rp");

        ftxtKembali.setEditable(false);
        ftxtKembali.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKembali.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblJenisPembayaran.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblJenisPembayaran.setForeground(new java.awt.Color(0, 0, 255));
        lblJenisPembayaran.setText("Jenis Pembayaran :");

        lblOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblOrderan.setForeground(new java.awt.Color(0, 0, 255));
        lblOrderan.setText("Orderan :");

        cboOrderan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboOrderan.setForeground(new java.awt.Color(0, 0, 255));
        cboOrderan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Direct Order", "Purchase Order" }));

        btnSimpan.setBackground(new java.awt.Color(255, 255, 255));
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Simpan2.png"))); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnCetak.setBackground(new java.awt.Color(255, 255, 255));
        btnCetak.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Cetak.png"))); // NOI18N
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnTutup.setBackground(new java.awt.Color(255, 255, 255));
        btnTutup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        dchTglExpire.setForeground(new java.awt.Color(0, 0, 255));
        dchTglExpire.setEnabled(false);
        dchTglExpire.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblSaldoPoin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblSaldoPoin.setForeground(new java.awt.Color(0, 0, 255));
        lblSaldoPoin.setText("Total Poin :");
        lblSaldoPoin.setEnabled(false);

        ftxtTotalPoin.setEditable(false);
        ftxtTotalPoin.setForeground(new java.awt.Color(0, 0, 255));
        ftxtTotalPoin.setEnabled(false);
        ftxtTotalPoin.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnCekPoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/CekPoin.png"))); // NOI18N
        btnCekPoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCekPoinActionPerformed(evt);
            }
        });

        ftxtKodeOutlet.setEditable(false);
        ftxtKodeOutlet.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeUser.setEditable(false);
        ftxtKodeUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtSift.setEditable(false);
        ftxtSift.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtKodeJenis.setEditable(false);
        txtKodeJenis.setForeground(new java.awt.Color(0, 0, 255));
        txtKodeJenis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeBC.setEditable(false);
        ftxtKodeBC.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        lblPoinBelanja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblPoinBelanja.setForeground(new java.awt.Color(0, 0, 255));
        lblPoinBelanja.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblPoinBelanja.setText("Poin Belanja :");

        ftxtPoinBelanja.setEditable(false);
        ftxtPoinBelanja.setForeground(new java.awt.Color(0, 0, 255));
        ftxtPoinBelanja.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ftxtPoinBelanja.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtGrandTotalModal.setEditable(false);
        ftxtGrandTotalModal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotalModal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtGrandTotalDiskon.setEditable(false);
        ftxtGrandTotalDiskon.setForeground(new java.awt.Color(0, 0, 255));
        ftxtGrandTotalDiskon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeStokItem.setEditable(false);
        ftxtKodeStokItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        ftxtKodeStokBrng.setEditable(false);
        ftxtKodeStokBrng.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeStokBrng.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        cbDiskon.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbDiskon.setForeground(new java.awt.Color(0, 0, 255));
        cbDiskon.setText("Diskon(%) :");
        cbDiskon.setOpaque(false);
        cbDiskon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbDiskonItemStateChanged(evt);
            }
        });

        btnTambahStok.setBackground(new java.awt.Color(255, 255, 255));
        btnTambahStok.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/TambahStok.png"))); // NOI18N
        btnTambahStok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahStokActionPerformed(evt);
            }
        });

        ftxtKodeJenis.setEditable(false);
        ftxtKodeJenis.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKodeJenis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtNamaUser.setEditable(false);
        txtNamaUser.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtNamaBisnis.setEditable(false);
        txtNamaBisnis.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaBisnis.setForeground(new java.awt.Color(0, 0, 255));

        javax.swing.GroupLayout pnlPenjualanLayout = new javax.swing.GroupLayout(pnlPenjualan);
        pnlPenjualan.setLayout(pnlPenjualanLayout);
        pnlPenjualanLayout.setHorizontalGroup(
            pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addComponent(lblNoNota)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblTglTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dchTglTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNoMember)
                                    .addComponent(lblNoHP)
                                    .addComponent(lblNama))
                                .addGap(61, 61, 61)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNoMember)
                                    .addComponent(txtNoHP, javax.swing.GroupLayout.DEFAULT_SIZE, 354, Short.MAX_VALUE)
                                    .addComponent(txtNama))
                                .addGap(104, 104, 104)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLevel)
                                    .addComponent(lblTglExpire)
                                    .addComponent(lblSaldoPoin))
                                .addGap(24, 24, 24)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtLevel, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                                    .addComponent(dchTglExpire, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ftxtTotalPoin)))
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addComponent(lblMember)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbYa)
                                .addGap(18, 18, 18)
                                .addComponent(rbTidak)
                                .addGap(77, 77, 77)
                                .addComponent(lblRupiah)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ftxtGrandTotal2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(scrlNota)
            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addComponent(btnCekPoin)
                        .addGap(204, 204, 204)
                        .addComponent(btnSimpan)
                        .addGap(51, 51, 51)
                        .addComponent(btnCetak)
                        .addGap(46, 46, 46)
                        .addComponent(btnTutup)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus)
                            .addComponent(lblBarcode)
                            .addComponent(lblSatuan)
                            .addComponent(lblKuantitas)
                            .addComponent(lblBayar)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lblSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbPPN, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPenjualanLayout.createSequentialGroup()
                                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlPenjualanLayout.createSequentialGroup()
                                                        .addComponent(ftxtGrandTotalModal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ftxtGrandTotalDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ftxtKodeJenis))
                                                    .addComponent(ftxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                                        .addComponent(ftxtSift, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(ftxtKodeStokItem, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(txtNamaUser))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtNamaBisnis))
                                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                                .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 382, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(txtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ftxtKodeStokBrng, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                                        .addComponent(lblGrandTotal)))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ftxtDiskon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(ftxtJmlhPembayaran)
                                            .addComponent(cboSatuan, javax.swing.GroupLayout.Alignment.LEADING, 0, 382, Short.MAX_VALUE)
                                            .addComponent(ftxtKuantitas, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnBerikut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                                .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                        .addComponent(btnKurangiStok)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnTambahStok)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnDaftarItem)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                                        .addComponent(lblPoinBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(ftxtPoinBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ftxtSubTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                                                .addComponent(lblJenisPembayaran)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                                .addComponent(lblOrderan)
                                                .addGap(78, 78, 78)))
                                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(cboJenisPembayaran, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(cboOrderan, 0, 251, Short.MAX_VALUE)))
                                    .addComponent(ftxtPPN, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        pnlPenjualanLayout.setVerticalGroup(
            pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dchTglTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftxtNoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNoNota, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTglTransaksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMember)
                            .addComponent(rbYa)
                            .addComponent(rbTidak))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addComponent(ftxtGrandTotal2)
                        .addGap(3, 3, 3))
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addComponent(lblRupiah, javax.swing.GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                        .addGap(6, 6, 6)))
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNoMember)
                    .addComponent(txtNoMember, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLevel)
                    .addComponent(txtLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblNoHP)
                        .addComponent(txtNoHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTglExpire))
                    .addComponent(dchTglExpire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSaldoPoin)
                    .addComponent(ftxtTotalPoin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrlNota, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtSubTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSubTotal))
                        .addGap(12, 12, 12)
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ftxtPPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPPN)))
                    .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKurangiStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnDaftarItem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTambahStok, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftxtDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbDiskon))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ftxtGrandTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblGrandTotal))
                    .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblBarcode)
                        .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ftxtKodeStokBrng, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblPoinBelanja)
                                    .addComponent(ftxtPoinBelanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblSatuan)
                                    .addComponent(cboSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblKuantitas)
                                    .addComponent(ftxtKuantitas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtJmlhPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblBayar)
                                    .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtKodeBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtKembali, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1)
                                    .addComponent(ftxtSift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtKodeStokItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ftxtGrandTotalModal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtGrandTotalDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNamaBisnis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSimpan)
                                    .addComponent(btnCetak)
                                    .addComponent(btnTutup)
                                    .addComponent(btnCekPoin, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(pnlPenjualanLayout.createSequentialGroup()
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cboJenisPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblJenisPembayaran))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(pnlPenjualanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblOrderan)
                                    .addComponent(cboOrderan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(pnlPenjualanLayout.createSequentialGroup()
                        .addComponent(btnBerikut)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlPenjualan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbYaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbYaItemStateChanged
        // TODO add your handling code here:
        lblNoMember.setEnabled(true);
        txtNoMember.setEnabled(true);
        lblNoHP.setEnabled(true);
        lblNama.setEnabled(true);
        lblLevel.setEnabled(true);
        lblTglExpire.setEnabled(true);
        lblSaldoPoin.setEnabled(true);
        
        txtNoMember.setEnabled(true);
        txtNoHP.setEnabled(true);
        txtNama.setEnabled(true);
        txtLevel.setEnabled(true);
        dchTglExpire.setEnabled(true);
        ((JTextFieldDateEditor)dchTglExpire.getDateEditor()).setForeground(Color.BLUE);
        ftxtTotalPoin.setEnabled(true);
        
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        if(dtm.getRowCount()>0){
            HitungGrandTotal();
        }
    }//GEN-LAST:event_rbYaItemStateChanged

    private void rbTidakItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbTidakItemStateChanged
        // TODO add your handling code here:
        lblNoMember.setEnabled(false);
        txtNoMember.setEnabled(false);
        lblNoHP.setEnabled(false);
        lblNama.setEnabled(false);
        lblLevel.setEnabled(false);
        lblTglExpire.setEnabled(false);
        lblSaldoPoin.setEnabled(false);
        
        txtNoMember.setEnabled(false);
        txtNoHP.setEnabled(false);
        txtNama.setEnabled(false);
        txtLevel.setEnabled(false);
        dchTglExpire.setEnabled(false);
        ftxtTotalPoin.setEnabled(false);
        
        txtNoMember.setText(null);
        txtNoHP.setText(null);
        txtNama.setText(null);
        txtLevel.setText(null);
        dchTglExpire.setCalendar(null);
        ftxtTotalPoin.setValue(null);
        ftxtPoinBelanja.setValue(0);
    }//GEN-LAST:event_rbTidakItemStateChanged

    private void txtNoMemberKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoMemberKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String NoMember = (((String)txtNoMember.getText().trim()).toString());
            txtNoMember.setText(new String(NoMember));
            String NoHP = (((String)txtNoHP.getText().trim()).toString());
            txtNoHP.setText(new String(NoHP));
            int KodeMember1 = Member.getKodeMember1(NoMember);
            int KodeBC = BC.getKodeBC(NoMember);
            ftxtKodeBC.setValue(new Integer(KodeBC));
            String NoMbr = Member.getNoMember(KodeMember1);
            String Nama = BC.getNamaBC(KodeBC);
            txtNama.setText(Nama);
            String NoHndphone = BC.getNoHP1(KodeBC);
            txtNoHP.setText(NoHndphone);
            String Level = Member.getLevel(NoMember);
            txtLevel.setText(Level);
            Calendar TglExpire = Member.getTglExpire(NoMember);
            dchTglExpire.setCalendar(TglExpire);
            int TotalPoin = Poin.getTotalPoin(NoMember);
            ftxtTotalPoin.setValue(new Integer(TotalPoin));
            
            HitungGrandTotal();
        }
    }//GEN-LAST:event_txtNoMemberKeyPressed

    private void txtNoHPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoHPKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String NoHP = (((String)txtNoHP.getText().trim()).toString());
            txtNoHP.setText(new String(NoHP));
            int KodeBC = BC.getKodeBC1(NoHP);
            String NoMember = BC.getNoMember(KodeBC);
            txtNoMember.setText(new String(NoMember));
            int KodeMember1 = Member.getKodeMember1(NoMember);
            
            String NoMbr = Member.getNoMember(KodeMember1);
            String Nama = BC.getNamaBC(KodeBC);
            txtNama.setText(Nama);
            String NoHndphone = BC.getNoHP1(KodeBC);
            txtNoHP.setText(NoHndphone);
            String Level = Member.getLevel(NoMember);
            txtLevel.setText(Nama);
            Calendar TglExpire = Member.getTglExpire(NoMember);
            dchTglExpire.setCalendar(TglExpire);
            int TotalPoin = Poin.getTotalPoin(KodeBC);
            ftxtTotalPoin.setValue(new Integer(TotalPoin));
            
            HitungGrandTotal();
        }
    }//GEN-LAST:event_txtNoHPKeyPressed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        if(tblNota.getSelectedColumn()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblNota.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        dtm.removeRow(row);
        HitungGrandTotal();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnKurangiStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangiStokActionPerformed
        // TODO add your handling code here:
        if(tblNota.getSelectedColumn()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblNota.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        Double Kuantitas = ((Double)dtm.getValueAt(row, 4)).doubleValue();
        Double Qtty = Kuantitas - 1;
        dtm.setValueAt(new Double(Qtty), row, 4);
        Double Hrga = (((Double)dtm.getValueAt(row, 5)).doubleValue());
        Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
        if(Diskon==0){
            Double Total = Qtty * Hrga;
            dtm.setValueAt(Total, row, 7);
        }
        else if(Diskon>0){
            Double Total = (Qtty * Hrga) - (Qtty * Hrga * (Diskon/100));
            dtm.setValueAt(Total, row, 7);
        }
        
        HitungGrandTotal();
    }//GEN-LAST:event_btnKurangiStokActionPerformed

    private void btnDaftarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarItemActionPerformed
        // TODO add your handling code here:
        DataItems DI = new DataItems(this, true);
        DI.setLocationRelativeTo(this);
        DI.setVisible(true);
        
        Item = DI.getSelectedItems();
        
        String Barcode = Item.getBarcode();
        txtBarcode.setText(Barcode);
    }//GEN-LAST:event_btnDaftarItemActionPerformed

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
       
       DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
       
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
//                if((SisaStok+Qtty)>SI.getStokMax(KodeStok)){
//                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
//                    return;
//                }
                StokMsuk = StokMsuk + Qtty;
                dtm.setValueAt(new Double(StokMsuk), i, 4);
                
                Double HrgModal =(((Double)dtm.getValueAt(i, 5)).doubleValue());
                dtm.setValueAt(new Double(HrgModal), i, 5);
                Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                dtm.setValueAt(new Double(Diskon), i, 6);
                Double Total = (StokMsuk*HrgModal) - (StokMsuk*HrgModal*(Diskon/100));
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
            String NamaSatuan = Sat.getNamaSatuan(KodeSatuan);
            rowdata[2] = NamaSatuan;
            Double SisaStok = SI.getKuantitas(KodeStokItem);
            rowdata[3] = new Double(SisaStok);
            Double StokMasuk = (((Double)ftxtKuantitas.getValue()).doubleValue());
//            if(KodeStokItem>0){
//                if((SisaStok+StokMasuk)>SI.getStokMax(KodeStokItem)){
//                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Stok Maximum!");
//                    return;
//                }
//            }
            rowdata[4] = new Double(StokMasuk);
            Double HrgJual = SI.getHargaJual(KodeStokItem);
            rowdata[5] = new Double(HrgJual);
            Double Diskon = SI.getDiskon(KodeStokItem);
            rowdata[6] = new Double(Diskon);
            Double Total = (StokMasuk * HrgJual) - (StokMasuk * HrgJual * (Diskon/100));
            rowdata[7] = new Double(Total);
            dtm.addRow(rowdata);
        }
        NumberFormatTable();
        HitungGrandTotal();
        HitungGrandTotalModal();
        HitungGrandTotalDiskon();
    }//GEN-LAST:event_btnBerikutActionPerformed

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(txtBarcode.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Barcode Belum Diisi");
                return;
            }
            
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
            int Sift = (((Integer)ftxtSift.getValue()).intValue());
            
            DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
            
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
                if(((boolean)dtm.getValueAt(i, 0).equals(Item.getBarcode())) && ((boolean)dtm.getValueAt(i, 2).equals(Sat.getNamaSatuan()))){
                    String Brc = (((String)dtm.getValueAt(i, 0)).toString());
                    String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                    int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                    Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                    Double StokKeluar = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                    Double Qtty = 1.00;
                    int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                    if((SisaStok+Qtty)<SI.getKuantitas(KodeStok)){
                        JOptionPane.showMessageDialog(this, "Kuantitas Melebihi Stok Yang Tersedia");
                        return;
                    }
                    StokKeluar = StokKeluar + Qtty;
                    dtm.setValueAt(new Double(StokKeluar), i, 4);
                    
                    Double HrgJual = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                    dtm.setValueAt(new Double(HrgJual), i, 5);
                    Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                    dtm.setValueAt(new Double(Diskon), i, 6);
                    Double Total = (StokKeluar*HrgJual) - (StokKeluar*HrgJual*(Diskon/100));
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
                int KodeStokItem = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                String NamaSatuan = Sat.getNamaSatuan(KodeSatuan);
                rowdata[2] = new String(NamaSatuan);
                Double SisaStok = SI.getKuantitas(KodeStokItem);
                rowdata[3] = new Double(SisaStok);
                Double StokKeluar = 1.00;
                if((StokKeluar)>SisaStok){
                    JOptionPane.showMessageDialog(this, "Kuantitas Inputan Melebihi Persediaan!");
                    return;
                }
                rowdata[4] = new Double(StokKeluar);
                Double HrgJual = SI.getHargaJual(KodeStokItem);
                rowdata[5] = new Double(HrgJual);
                Double Diskon = SI.getDiskon(KodeStokItem);
                rowdata[6] = new Double(Diskon);
                Double Total = (StokKeluar*HrgJual) - (StokKeluar*HrgJual*(Diskon/100));
                rowdata[7] = new Double(Total);
                
                dtm.addRow(rowdata);
            }
            NumberFormatTable();
            HitungGrandTotal();
            HitungGrandTotalModal();
            HitungGrandTotalDiskon();
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void tblNotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblNotaKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
            int row = tblNota.getSelectedRow();
            Double StokKeluar = (((Double)dtm.getValueAt(row, 4)).doubleValue());
            Double HrgJual = (((Double)dtm.getValueAt(row, 5)).doubleValue());
            Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
            Double Total = (StokKeluar* HrgJual) - (StokKeluar*HrgJual*(Diskon/100));
            dtm.setValueAt(Total, row, 7);
            
            HitungGrandTotal();
        }
    }//GEN-LAST:event_tblNotaKeyPressed

    private void tblNotaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNotaMouseClicked
        // TODO add your handling code here:
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        int row = tblNota.getSelectedRow();
        String Barcode = (((String)dtm.getValueAt(row, 0)));
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = SI.getKodeStok(Barcode,KodeOutlet,KodeSatuan);
        
        String Satuan = SI.getNamaSatuan(cboSatuan, Barcode, KodeOutlet);
        
        String CurrentSatuan = (((String)dtm.getValueAt(row, 2)).toString());
    }//GEN-LAST:event_tblNotaMouseClicked

    private void cboSatuanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSatuanItemStateChanged
        // TODO add your handling code here:
        if(tblNota.getSelectedRow()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblNota.getSelectedRow();
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        String Satuan = (((String)cboSatuan.getSelectedItem()).toString());
        int KodeSatuan = Sat.getKodeSatuan(Satuan);
        dtm.setValueAt(new String(Satuan), row, 2);
        String NamaSatuan = (((String)dtm.getValueAt(row, 2)).toString());
        int KodeSat = Sat.getKodeSatuan(NamaSatuan);
        int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSat);
        ftxtKodeStokItem.setValue(new Integer(KodeStok));
        Double SisaStok = SI.getKuantitas(KodeStok);
        dtm.setValueAt(new Double(SisaStok), row, 3);
        Double StokMasuk = (((Double)dtm.getValueAt(row, 4)).doubleValue());
        Double HrgJual = SI.getHargaJual(KodeStok);
        dtm.setValueAt(new Double(HrgJual), row, 5);
        Double Disc = SI.getDiskon(KodeStok);
        dtm.setValueAt(new Double(Disc), row, 6);
        Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
        Double Total = (StokMasuk * HrgJual) - (StokMasuk * HrgJual * (Diskon/100));
        dtm.setValueAt(new Double(Total), row, 7);
        
        HitungGrandTotal();
        HitungGrandTotalModal();
        HitungGrandTotalDiskon();
    }//GEN-LAST:event_cboSatuanItemStateChanged

    private void cbPPNItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPPNItemStateChanged
        // TODO add your handling code here:
        HitungGrandTotal();
    }//GEN-LAST:event_cbPPNItemStateChanged

    private void cbPPNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPPNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPPNActionPerformed

    private void cbDiskonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbDiskonItemStateChanged
        // TODO add your handling code here:
        if(cbDiskon.isSelected()){
            ftxtDiskon.setEnabled(true);
        }
        else{
            ftxtDiskon.setEnabled(false);
        }
    }//GEN-LAST:event_cbDiskonItemStateChanged

    private void ftxtDiskonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtDiskonKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            if(((Double)ftxtGrandTotal.getValue()).doubleValue()==0){
                JOptionPane.showMessageDialog(this, "Grand Total Belum Dihitung!");
                return;
            }
            Double SubTotal = (((Double)ftxtSubTotal.getValue()).doubleValue());
            Double PPN = (((Double)ftxtPPN.getValue()).doubleValue());
            String Diskon = ftxtDiskon.getText().trim();
            Double Disc = Double.valueOf(Diskon);
            ftxtDiskon.setValue(new Double(Disc));
            Double GrandTotal = (SubTotal+PPN) - ((SubTotal+PPN)*(Disc/100));
            ftxtGrandTotal.setValue(new Double(GrandTotal));
            ftxtGrandTotal2.setValue(new Double(GrandTotal));
        }
    }//GEN-LAST:event_ftxtDiskonKeyPressed

    private void btnTambahStokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahStokActionPerformed
        // TODO add your handling code here:
        if(tblNota.getSelectedColumn()<=-1){
            JOptionPane.showMessageDialog(this, "Item Pada Tabel Belum Dipilih!");
            return;
        }
        int row = tblNota.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        Double Kuantitas = ((Double)dtm.getValueAt(row, 4)).doubleValue();
        Double Qtty = Kuantitas + 1;
        dtm.setValueAt(new Double(Qtty), row, 4);
        Double Hrga = (((Double)dtm.getValueAt(row, 5)).doubleValue());
        Double Diskon = (((Double)dtm.getValueAt(row, 6)).doubleValue());
        if(Diskon==0){
            Double Total = Qtty * Hrga;
            dtm.setValueAt(Total, row, 7);
        }
        else if(Diskon>0){
            Double Total = (Qtty * Hrga) - (Qtty * Hrga * (Diskon/100));
            dtm.setValueAt(Total, row, 7);
        }
        
        HitungGrandTotal();
    }//GEN-LAST:event_btnTambahStokActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(dchTglTransaksi.getCalendar()==null){
            JOptionPane.showMessageDialog(this, "Tgl Transaksi Belum Diisi!");
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
        if(tblNota.getRowCount()==0){
            JOptionPane.showMessageDialog(this, "Tabel Nota Belum Diisi!");
            return;
        }
        
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        trans.setKodeOutlet(KodeOutlet);
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        trans.setKodeUser(KodeUser);
        
        
        if(rbYa.isSelected()){
            int KodeBC = (((Integer)ftxtKodeBC.getValue()).intValue());
            trans.setKodeBC(KodeBC);
        }
        else if(rbTidak.isSelected()){
            trans.setKodeBC(0);
        }
        Calendar TglTransaksi = dchTglTransaksi.getCalendar();
        trans.setTglTransaksi(TglTransaksi);
        trans.setJenisTransaksi(2);
        int KodeJenis = (((Integer)ftxtKodeJenis.getValue()).intValue());
        trans.setKodeJenis(KodeJenis);
        if(cboOrderan.getSelectedIndex()==1){
            trans.setOrderan(1);
        }
        else if(cboOrderan.getSelectedIndex()==2){
            trans.setOrderan(2);
        }
        int Orderan = cboOrderan.getSelectedIndex();
        Double SubTotal = (((Double)ftxtSubTotal.getValue()).doubleValue());
        trans.setSubTotal(SubTotal);
        Double PPN = (((Double)ftxtPPN.getValue()).doubleValue());
        trans.setPPN(PPN);
        Double Diskon = (((Double)ftxtDiskon.getValue()).doubleValue());
        trans.setDiskon(Diskon);
        Double GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        trans.setGrandTotal(GrandTotal);
        Double JmlhPembayaran = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        trans.setBayar(JmlhPembayaran);
        Double Kembali = (((Double)ftxtKembali.getValue()).doubleValue());
        
        
        trans.setJmlhPembayaran(GrandTotal);
        trans.setStatusPelunasan(1);
        trans.setTglLunas(TglTransaksi);
        trans.setBayar(JmlhPembayaran);
        trans.setKembali(Kembali);
        trans.setTglJatuhTempo(null);
        
        try {
            {
//            trans.Simpan("", KodeOutlet, KodeUser, 0, TglTransaksi, 2, KodeJenis, Orderan, SubTotal, PPN, Diskon, GrandTotal, GrandTotal, 1, TglTransaksi, JmlhPembayaran, Kembali, 
//                    TglTransaksi);
            trans.Simpan();
            DBConnector.getConnection().commit();
            
//            trans.SimpanLocalDB("", KodeOutlet, KodeUser, 0, TglTransaksi, 2, KodeJenis, Orderan, SubTotal, PPN, Diskon, GrandTotal, GrandTotal, 1, TglTransaksi, JmlhPembayaran, Kembali, 
//                    TglTransaksi);
//            DBConnector.getConnectionLocal().commit();
            }
            int NoNota = trans.getNoNota();
            ftxtNoNota.setValue(new Integer(NoNota));
            
            RincianTransaksi = new RincianTransaksi[tblNota.getRowCount()];
            
            DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
            for(int i=0;i<RincianTransaksi.length;i++){
                RincianTransaksi[i] = new RincianTransaksi();
                RincianTransaksi[i].setNoNota(NoNota);
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                RincianTransaksi[i].setBarcode(Barcode);
                String NamaItem = (((String)dtm.getValueAt(i, 1)).toString());
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                RincianTransaksi[i].setSatuan(NamaSatuan);
                Double SisaStok = (((Double)dtm.getValueAt(i, 3)).doubleValue());
                Double StokKeluar = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                SisaStok = SisaStok + StokKeluar;
                dtm.setValueAt(SisaStok, i, 3);
                RincianTransaksi[i].setKuantitas(StokKeluar);
                Double Harga = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                RincianTransaksi[i].setHarga(Harga);
                Double Disc = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                RincianTransaksi[i].setDiskon(Disc); 
                Double Total = (((Double)dtm.getValueAt(i, 7)).doubleValue());
                RincianTransaksi[i].setTotal(Total);
                
                RincianTransaksi[i].Simpan(NoNota, Barcode, NamaSatuan, StokKeluar, Harga, Disc, Total);
                DBConnector.getConnection().commit();
//                RincianTransaksi[i].Simpan(NoNota, Barcode, NamaSatuan, StokKeluar, Harga, Disc, Total);
//                DBConnector.getConnectionLocal().commit();
            }
            
            StokItem = new StokItem[tblNota.getRowCount()];
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
                Double HrgJual = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                
                    StokItem[i].KurangiKuantitas(KodeStok, StokMasuk);
//                    StokItem[i].UpdateHargaJual(KodeStok, HrgJual);
                DBConnector.getConnection().commit();

            }
            
            StokBrng = new StokBarang[tblNota.getRowCount()];
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
                Double StokKeluar = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                Double HrgJual = (((Double)dtm.getValueAt(i, 5)).doubleValue());
                Double TotalJual = StokKeluar * HrgJual;
                if(Barcode.equals(StokBrng[i].getBarcode(LastKodeStok)) && Tanggal.equals(StokBrng[i].getTanggal(LastKodeStok)) && 
                        KodeSatuan==StokBrng[i].getKodeSatuan(LastKodeStok) && KodeOutlet==StokBrng[i].getKodeOutlet(LastKodeStok)){
                    StokBrng[i].TambahStokKeluar(LastKodeStok, StokKeluar);
                    //StokBrng[i].TambahStokKeluar(LastKodeStok, 0.00);
                    Sisa = Sisa + StokKeluar;
                    StokBrng[i].UpdateSisaStok(LastKodeStok, Sisa);
                    StokBrng[i].UpdateHargaJual(LastKodeStok, HrgJual);
                    DBConnector.getConnection().commit();
                }
                else{
                    StokBrng[i].Simpan(Barcode, KodeOutlet, KodeSatuan, Tanggal, StokKeluar, 0.00, Sisa, 
                                            0.00, 0.00, HrgJual, TotalJual);
                    DBConnector.getConnection().commit();
                }
            }
            
            if(rbYa.isSelected()){
                String NoMember = (((String)txtNoMember.getText().trim()).toString());
                int KodeBC = (((Integer)ftxtKodeBC.getValue()).intValue());
                String NoHP = (((String)txtNoHP.getText().trim()).toString());
                String Nama = (((String)txtNama.getText().trim()).toString());
                String Level = (((String)txtLevel.getText().trim()).toString());
                int PoinBelanja = (((Integer)ftxtPoinBelanja.getValue()).intValue());
                
                TglTransaksi.add(Calendar.YEAR, 1);
                
                Poin.Simpan(NoMember, KodeBC, PoinBelanja, TglTransaksi);
                DBConnector.getConnection().commit();
            }
            
            LabaItem = new LabaItem[tblNota.getRowCount()];
            for(int i=0;i<LabaItem.length;i++){
                LabaItem[i] = new LabaItem();
                
                LabaItem[i].setTanggal(TglTransaksi);
                LabaItem[i].setKodeOutlet(KodeOutlet);
                String Barcode = (((String)dtm.getValueAt(i, 0)).toString());
                LabaItem[i].setKodeJenis(KodeJenis);
                String NamaSatuan = (((String)dtm.getValueAt(i, 2)).toString());
                int KodeSatuan = Sat.getKodeSatuan(NamaSatuan);
                LabaItem[i].setKodeSatuan(KodeSatuan);
                Double Kuantitas = (((Double)dtm.getValueAt(i, 4)).doubleValue());
                LabaItem[i].setKuantitas(Kuantitas);
                int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
                Double HrgModal = SI.getHargaModal(KodeStok);
                LabaItem[i].setHargaModal(HrgModal);
                Double TotalModal = Kuantitas * HrgModal;
                LabaItem[i].setTotalModal(TotalModal);
                Double HrgJual = (((Double)dtm.getValueAt(i, 5)));
                LabaItem[i].setHargaJual(HrgJual);
                Double TotalJual = Kuantitas * HrgJual;
                LabaItem[i].setTotalJual(TotalJual);
                Double Disc = (((Double)dtm.getValueAt(i, 6)).doubleValue());
                LabaItem[i].setTotalDiskon(Disc);
                
                LabaItem[i].Simpan(TglTransaksi, NoNota, KodeOutlet, Barcode, KodeJenis, KodeSatuan, Kuantitas, HrgModal, TotalModal, HrgJual, 
                        TotalJual, Disc);
                DBConnector.getConnection().commit();
            }
            
            int Tanggal = dchTglTransaksi.getCalendar().getTime().getDate();
            int Minggu = dchTglTransaksi.getCalendar().get(Calendar.WEEK_OF_MONTH);
            int Bulan = dchTglTransaksi.getCalendar().getTime().getMonth()+1;
            int Tahun = dchTglTransaksi.getCalendar().getTime().getYear()+1900;
            int Sft = (((Integer)ftxtSift.getValue()).intValue());
            int KodeSift = Sift.getKodeSift1(Sft);
            
            Double GrandTotalModal = (((Double)ftxtGrandTotalModal.getValue()).doubleValue());
            Double GrandTotalJual = (((Double)ftxtGrandTotal.getValue()).doubleValue());
            Double GrandTotalDiskon = (((Double)ftxtGrandTotalDiskon.getValue()).doubleValue());
            
            int LastLBHarian = LH.getLastKodeLB(KodeOutlet, KodeUser, KodeJenis, KodeSift, Tanggal, Bulan, Tahun);
            int KodeOutletHarian = LH.getKodeOutlet(LastLBHarian);
            int KodeUserHarian = LH.getKodeUser(LastLBHarian);
            int KodeJenisHarian = LH.getKodeJenis(LastLBHarian);
            int KodeSiftHarian = LH.getKodeSift(LastLBHarian);
            int TglAkhirHarian = LH.getTanggal(LastLBHarian);
            int BlnAkhirHarian = LH.getBulan(LastLBHarian);
            int ThnAkhirHarian = LH.getTahun(LastLBHarian);
            if(KodeOutlet==KodeOutletHarian && KodeUser==KodeUserHarian && KodeJenis==KodeJenisHarian && KodeSift==KodeSiftHarian && 
                    Tanggal==TglAkhirHarian && Bulan==BlnAkhirHarian && Tahun==ThnAkhirHarian){
                LH.TambahTotalModal(LastLBHarian, GrandTotalModal);
                LH.TambahTotalJual(LastLBHarian, GrandTotalJual);
                LH.TambahTotalDiskon(LastLBHarian, GrandTotalDiskon);
                LH.TambahTotalNota(LastLBHarian, 1);
                DBConnector.getConnection().commit();
            }
            else{
                LH.Simpan(KodeOutlet, KodeUser, KodeJenis, Sft, Tanggal, Bulan, Tahun, GrandTotalModal, GrandTotalJual, GrandTotalDiskon, 0.00, 0.00, 1);
                DBConnector.getConnection().commit();
            }
            
            int LastLBMingguan = LM.getLastKodeLB(KodeOutlet, KodeJenis, KodeUser, Minggu, Bulan, Tahun);
            int KodeOutletMingguan = LM.getKodeOutlet(LastLBMingguan);
            int KodeJenisMingguan = LM.getKodeJenis(LastLBMingguan);
            int KodeUserMingguan = LM.getKodeUser(LastLBMingguan);
            int MggAkhirMigguan = LM.getMinggu(LastLBMingguan);
            int BlnAkhirMingguan = LM.getBulan(LastLBMingguan);
            int ThnAkhirMingguan = LM.getTahun(LastLBMingguan);
            if(KodeOutlet==KodeOutletMingguan && KodeJenis==KodeJenisMingguan && KodeUser==KodeUserMingguan && Minggu==MggAkhirMigguan && 
                    Bulan==BlnAkhirMingguan && Tahun==ThnAkhirMingguan){
                LM.TambahTotalModal(LastLBMingguan, GrandTotalModal);
                LM.TambahTotalJual(LastLBMingguan, GrandTotalJual);
                LM.TambahTotalDiskon(LastLBMingguan, GrandTotalDiskon);
                LM.TambahTotalNota(LastLBMingguan, 1);
                DBConnector.getConnection().commit();
            }
            else if(LastLBMingguan==0){
                LM.Simpan(KodeOutlet, KodeJenis, KodeUser, Minggu, Bulan, Tahun, GrandTotalModal, GrandTotalJual, GrandTotalDiskon, 0.00, 
                        1);
                DBConnector.getConnection().commit();
            }
            
            int LastLBBulanan = LB.getLastKodeLB(KodeOutlet, KodeJenis, KodeUser, Bulan, Tahun);
            int KodeOutletBulanan = LB.getKodeOutlet(LastLBBulanan);
            int KodeJenisBulanan = LB.getKodeJenis(LastLBBulanan);
            int KodeUserBulanan = LB.getKodeUser(LastLBBulanan);
            int BlnAkhirBulanan = LB.getBulan(LastLBBulanan);
            int ThnAkhirBulana = LB.getTahun(LastLBBulanan);
            if(KodeOutlet==KodeOutletBulanan && KodeJenis==KodeJenisBulanan && KodeUser==KodeUserBulanan && Bulan==BlnAkhirBulanan && 
                    Tahun==ThnAkhirBulana){
                LB.TambahTotalModal(LastLBBulanan, GrandTotalModal);
                LB.TambahTotalJual(LastLBBulanan, GrandTotalJual);
                LB.TambahTotalDiskon(LastLBBulanan, GrandTotalDiskon);
                LB.TambahTotalNota(LastLBBulanan, 1);
                DBConnector.getConnection().commit();
            }
            else{
                LB.Simpan(KodeOutlet, KodeJenis, KodeUser, Bulan, Tahun, GrandTotalModal, GrandTotalJual, GrandTotalDiskon, 0.00, 1);
                DBConnector.getConnection().commit();
            }
            
            int LastLBTahunan = LT.getLastKodeLB(KodeOutlet, KodeJenis, KodeUser, Tahun);
            int KodeOutletTahunan = LT.getKodeOutlet(LastLBTahunan);
            int KodeJenisTahunan = LT.getKodeJenis(LastLBTahunan);
            int KodeUserTahunan = LT.getKodeUser(LastLBTahunan);
            int ThnAkhirTahunan = LT.getTahun(LastLBTahunan);
            
            if(KodeOutlet==KodeOutletTahunan && KodeJenis==KodeJenisTahunan && KodeUser==KodeUserTahunan && Tahun==ThnAkhirTahunan){
                LT.TambahTotalModal(LastLBTahunan, GrandTotalModal);
                LT.TambahTotalJual(LastLBTahunan, GrandTotalJual);
                LT.TambahTotalDiskon(LastLBTahunan, GrandTotalDiskon);
                LT.TambahTotalNota(LastLBTahunan, 1);
                DBConnector.getConnection().commit();
            }
            else{
                LT.Simpan(KodeOutlet, KodeJenis, KodeUser, Tahun, GrandTotalModal, GrandTotalJual, GrandTotalDiskon, 0.00, 1);
                DBConnector.getConnection().commit();
            }
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

    private void ftxtJmlhPembayaranKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftxtJmlhPembayaranKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            if(((Double)ftxtGrandTotal.getValue()).doubleValue()==0.00){
                JOptionPane.showMessageDialog(this, "Grand Total Belum Dihitung");
                return;
            }
            
            String JmlhBayar = ftxtJmlhPembayaran.getText().trim();
            Double JmlhPembayaran = Double.valueOf(JmlhBayar);
            ftxtJmlhPembayaran.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                                new DecimalFormat("#,##0"))));
            ftxtJmlhPembayaran.setValue(JmlhPembayaran);
            
            HitungKembalian();
        }
    }//GEN-LAST:event_ftxtJmlhPembayaranKeyPressed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        // TODO add your handling code here:
        if(ftxtNoNota.getText().trim().length()==0){
            JOptionPane.showMessageDialog(this, "No Nota Belum Ada");
            return;
        }
        int NoNota = (((Integer)ftxtNoNota.getValue()).intValue());
        Calendar TglTransaksi = dchTglTransaksi.getCalendar();
        String NamaUser = txtNamaUser.getText().trim();
        String NamaBisnis = txtNamaBisnis.getText().trim();
        
        JasperPrint JP = null;
        String ReportPath = "Report/";
        String ReportFileName = null;
        URL Resource = this.getClass().getResource(ReportPath);
        try {
            java.util.Map<String, Object> params = new java.util.HashMap<String, Object>();
            java.util.Map<String, Object> paramsUser = new java.util.HashMap<String, Object>();
            java.util.Map<String, Object> paramsNamaBisnis = new java.util.HashMap<String, Object>();
            params.put("NoNota", Integer.valueOf(NoNota));
            paramsUser.put("NamaUser", String.valueOf(NamaUser));
            paramsNamaBisnis.put("NamaBisnis", String.valueOf(NamaBisnis));
            DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
            
            int rowcount = RT.getRowCount(NoNota);
            String path = "Report/StrukPenjualan";
            
            if(rbYa.isSelected()){
                if(cbPPN.isSelected()==true && cbDiskon.isSelected()==true){
                    path += "PoinPPNDiskon";
                }
                else if(cbPPN.isSelected()==true && cbDiskon.isSelected()==false){
                    path += "PoinPPN";
                }
                else if(cbPPN.isSelected()==false && cbDiskon.isSelected()==true){
                    path += "PoinDiskon";
                }
                else if(cbPPN.isSelected()==false && cbDiskon.isSelected()==false){
                    path += "Poin";
                }
            }
            else if(rbTidak.isSelected()){
                if(cbPPN.isSelected()==true && cbDiskon.isSelected()==true){
                    path += "PPNDiskon";
                }
                else if(cbPPN.isSelected()==true && cbDiskon.isSelected()==false){
                    path += "PPN";
                }
                else if(cbPPN.isSelected()==false && cbDiskon.isSelected()==true){
                    path += "Diskon";
                }
                else if(cbPPN.isSelected()==false && cbDiskon.isSelected()==false){
                    path += "";
                }
            }
            path = path+".jrxml";
            int padd = rowcount < 3 ? 0 : 35*(rowcount-2);
            int pageHeight = 315+padd;
            
            File file = new File(path);
            JasperDesign jasperDesign = JRXmlLoader.load(file);
            JasperReport report = JasperCompileManager.compileReport(jasperDesign);
            JP = JasperFillManager.fillReport(report, params, DBConnector.getConnection());
            JP.setOrientation(OrientationEnum.PORTRAIT);
            JP.setPageHeight(pageHeight);
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

    private void btnCekPoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCekPoinActionPerformed
        // TODO add your handling code here:
        PoinBelanja PB = new PoinBelanja(this, true);
        
        String NoMember = (((String)txtNoMember.getText().trim()).toString());
        PB.txtNoMember.setText(NoMember);
        String NamaMember = (((String)txtNama.getText().trim()).toString());
        PB.txtNamaMember.setText(NamaMember);
        String NoHP = (((String)txtNoHP.getText().trim()).toString());
        PB.txtNoHPWA.setText(NoHP);
        
        Poin.getPoin1(PB.tblPoin, NoMember);
        
        PB.setLocationRelativeTo(this);
        PB.setVisible(true);
    }//GEN-LAST:event_btnCekPoinActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void HitungKembalian(){
        Double GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        Double JmlhPembayaran = (((Double)ftxtJmlhPembayaran.getValue()).doubleValue());
        
        Double Kembali = JmlhPembayaran - GrandTotal;
        
        ftxtKembali.setValue(new Double(Kembali));
    }
    private void HitungGrandTotal(){
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        Double SubTotal = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            Double Total = ((Double)dtm.getValueAt(i, 7)).doubleValue();
            SubTotal += Total;
        }
        ftxtSubTotal.setValue(new Double(SubTotal));
        Double SbTotal = ((Double)ftxtSubTotal.getValue()).doubleValue();
        Double GrandTotal = 0.00;
        if(cbPPN.isSelected()){
            Double PPN = SbTotal * 0.11;
            ftxtPPN.setValue(new Double(PPN));
            GrandTotal = SbTotal + PPN;
            ftxtGrandTotal.setValue(new Double(GrandTotal));
            ftxtGrandTotal2.setValue(new Double(GrandTotal));
        }
        else{
            ftxtPPN.setValue(new Double(0));
            ftxtGrandTotal.setValue(new Double(SbTotal));
            ftxtGrandTotal2.setValue(new Double(SbTotal));
        }
        
        GrandTotal = (((Double)ftxtGrandTotal.getValue()).doubleValue());
        if(rbYa.isSelected()){
            int Poin =0;
            for (Double i = GrandTotal; i >= 100000; i -= 100000) {
                Poin++;
            }
            ftxtPoinBelanja.setValue(new Integer(Poin));
        }
        else if(rbTidak.isSelected()){
            ftxtPoinBelanja.setValue(0);
        }
     
//        if(GrandTotal>=0 && GrandTotal<100000){
//            ftxtPoinBelanja.setValue(0);
//        }
//        else if(GrandTotal>=100000 && GrandTotal<200000){
//            ftxtPoinBelanja.setValue(1);
//        }
//        else if(GrandTotal>=200000 && GrandTotal<300000){
//            ftxtPoinBelanja.setValue(2);
//        }
//        else if(GrandTotal>=300000 && GrandTotal<400000){
//            ftxtPoinBelanja.setValue(3);
//        }
//        else if(GrandTotal>=400000 && GrandTotal<500000){
//            ftxtPoinBelanja.setValue(4);
//        }
//        else if(GrandTotal>=100000 && GrandTotal<200000){
//            ftxtPoinBelanja.setValue(1);
//        }
    }
    public void HitungGrandTotalModal(){
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        Double GrandTotalModal = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            String Barcode = ((String)dtm.getValueAt(i, 0)).toString();
            String Satuan = ((String)dtm.getValueAt(i, 2)).toString();
            int KodeSatuan = Sat.getKodeSatuan(Satuan);
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            Double HrgModal = SI.getHargaModal(KodeStok);
            Double Qtty = (((Double)dtm.getValueAt(i, 4)).doubleValue());
            Double TotalModal = HrgModal * Qtty;
            GrandTotalModal += TotalModal;
        }
        ftxtGrandTotalModal.setValue(new Double(GrandTotalModal));
    }
    public void HitungGrandTotalDiskon(){
        DefaultTableModel dtm = (DefaultTableModel)tblNota.getModel();
        Double GrandTotalDiskon = 0.00;
        for(int i=0;i<dtm.getRowCount();i++){
            String Barcode = ((String)dtm.getValueAt(i, 0)).toString();
            String Satuan = ((String)dtm.getValueAt(i, 2)).toString();
            int KodeSatuan = Sat.getKodeSatuan(Satuan);
            int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
            int KodeStok = SI.getKodeStok(Barcode, KodeOutlet, KodeSatuan);
            Double Qtty = (((Double)dtm.getValueAt(i, 4)).doubleValue());
            Double HrgJual = (((Double)dtm.getValueAt(i, 5)).doubleValue());
            Double Diskon = (((Double)dtm.getValueAt(i, 6)).doubleValue());
            Double TotalDiskon = (Qtty*HrgJual) - (Qtty*HrgJual*(Diskon/100));
            GrandTotalDiskon += TotalDiskon;
        }
        ftxtGrandTotalDiskon.setValue(new Double(GrandTotalDiskon));
    }
    
    
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgMember;
    private javax.swing.JButton btnBerikut;
    private javax.swing.JButton btnCekPoin;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDaftarItem;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKurangiStok;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambahStok;
    private javax.swing.JButton btnTutup;
    private javax.swing.JCheckBox cbDiskon;
    private javax.swing.JCheckBox cbPPN;
    private javax.swing.JComboBox<String> cboJenisPembayaran;
    private javax.swing.JComboBox<String> cboOrderan;
    private javax.swing.JComboBox<String> cboSatuan;
    private com.toedter.calendar.JDateChooser dchTglExpire;
    private com.toedter.calendar.JDateChooser dchTglTransaksi;
    private javax.swing.JFormattedTextField ftxtDiskon;
    private javax.swing.JFormattedTextField ftxtGrandTotal;
    private javax.swing.JFormattedTextField ftxtGrandTotal2;
    private javax.swing.JFormattedTextField ftxtGrandTotalDiskon;
    private javax.swing.JFormattedTextField ftxtGrandTotalModal;
    private javax.swing.JFormattedTextField ftxtJmlhPembayaran;
    private javax.swing.JFormattedTextField ftxtKembali;
    private javax.swing.JFormattedTextField ftxtKodeBC;
    public javax.swing.JFormattedTextField ftxtKodeJenis;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    private javax.swing.JFormattedTextField ftxtKodeStokBrng;
    private javax.swing.JFormattedTextField ftxtKodeStokItem;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JFormattedTextField ftxtKuantitas;
    private javax.swing.JFormattedTextField ftxtNoNota;
    private javax.swing.JFormattedTextField ftxtPPN;
    private javax.swing.JFormattedTextField ftxtPoinBelanja;
    public javax.swing.JFormattedTextField ftxtSift;
    private javax.swing.JFormattedTextField ftxtSubTotal;
    private javax.swing.JFormattedTextField ftxtTotalPoin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBarcode;
    private javax.swing.JLabel lblBayar;
    private javax.swing.JLabel lblGrandTotal;
    private javax.swing.JLabel lblJenisPembayaran;
    private javax.swing.JLabel lblKuantitas;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblMember;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNoHP;
    private javax.swing.JLabel lblNoMember;
    private javax.swing.JLabel lblNoNota;
    private javax.swing.JLabel lblOrderan;
    private javax.swing.JLabel lblPoinBelanja;
    private javax.swing.JLabel lblRupiah;
    private javax.swing.JLabel lblSaldoPoin;
    private javax.swing.JLabel lblSatuan;
    private javax.swing.JLabel lblSubTotal;
    private javax.swing.JLabel lblTglExpire;
    private javax.swing.JLabel lblTglTransaksi;
    private javax.swing.JPanel pnlPenjualan;
    private javax.swing.JRadioButton rbTidak;
    private javax.swing.JRadioButton rbYa;
    private javax.swing.JScrollPane scrlNota;
    private javax.swing.JTable tblNota;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JFormattedTextField txtKodeJenis;
    private javax.swing.JTextField txtLevel;
    private javax.swing.JTextField txtNama;
    public javax.swing.JTextField txtNamaBisnis;
    public javax.swing.JTextField txtNamaUser;
    private javax.swing.JTextField txtNoHP;
    private javax.swing.JTextField txtNoMember;
    // End of variables declaration//GEN-END:variables
}
