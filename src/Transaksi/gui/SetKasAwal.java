/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi.gui;

import Inventori.gui.RegistrasiKategori;
import Transaksi.LabaHarian;
import Util.BackgroundPane;
import Util.DBConnector;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Yestin
 */
public class SetKasAwal extends javax.swing.JFrame {

    LabaHarian LH = new LabaHarian();
    /**
     * Creates new form SetKasAwal
     */
    public SetKasAwal() {
        initComponents();
        setTitle("Set Kas Awal");
        dchTanggal.setCalendar(Calendar.getInstance());
        dchTanggal.setDateFormatString("dd-mm-yyyy");
        ftxtKasAwal.setFormatterFactory(new DefaultFormatterFactory(new NumberFormatter(
                        new DecimalFormat("#,##0"))));
        ftxtKasAwal.setValue(new Double(0.00));
         try {
            BackgroundPane Background = new BackgroundPane();
            Background.setBackground(ImageIO.read(new File("\\E-POS\\Green Background 37.jpeg")));
            Background.setLayout(new BorderLayout());
            pnlSetKasAwal.setOpaque(false);
            Background.add(pnlSetKasAwal,BorderLayout.CENTER);
            this.setLayout(new BorderLayout());
            this.add(Background, BorderLayout.CENTER);
        } 
        catch (IOException ex) {
            Logger.getLogger(RegistrasiKategori.class.getName()).log(Level.SEVERE, null, ex);
        }
        ftxtKodeJenis.setVisible(false);
        ftxtKodeOutlet.setVisible(false);
        ftxtKodeSift.setVisible(false);
        ftxtKodeUser.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlSetKasAwal = new javax.swing.JPanel();
        lblKasAwal = new javax.swing.JLabel();
        ftxtKasAwal = new javax.swing.JFormattedTextField();
        dchTanggal = new com.toedter.calendar.JDateChooser();
        btnSimpan = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        ftxtKodeOutlet = new javax.swing.JFormattedTextField();
        ftxtKodeUser = new javax.swing.JFormattedTextField();
        ftxtKodeJenis = new javax.swing.JFormattedTextField();
        ftxtKodeSift = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblKasAwal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblKasAwal.setForeground(new java.awt.Color(0, 0, 255));
        lblKasAwal.setText("Kas Awal :");

        ftxtKasAwal.setForeground(new java.awt.Color(0, 0, 255));
        ftxtKasAwal.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnSimpan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Simpan2.png"))); // NOI18N
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        ftxtKodeOutlet.setEditable(false);

        ftxtKodeUser.setEditable(false);

        ftxtKodeJenis.setEditable(false);

        ftxtKodeSift.setEditable(false);

        javax.swing.GroupLayout pnlSetKasAwalLayout = new javax.swing.GroupLayout(pnlSetKasAwal);
        pnlSetKasAwal.setLayout(pnlSetKasAwalLayout);
        pnlSetKasAwalLayout.setHorizontalGroup(
            pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSetKasAwalLayout.createSequentialGroup()
                .addContainerGap(75, Short.MAX_VALUE)
                .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(ftxtKodeOutlet)
                    .addComponent(lblKasAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSetKasAwalLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlSetKasAwalLayout.createSequentialGroup()
                                .addComponent(btnSimpan)
                                .addGap(56, 56, 56)
                                .addComponent(btnTutup))
                            .addComponent(ftxtKasAwal, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49))
                    .addGroup(pnlSetKasAwalLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftxtKodeSift, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                        .addGap(158, 158, 158)
                        .addComponent(dchTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(74, 74, 74))
        );
        pnlSetKasAwalLayout.setVerticalGroup(
            pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlSetKasAwalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlSetKasAwalLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnTutup))
                    .addGroup(pnlSetKasAwalLayout.createSequentialGroup()
                        .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dchTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ftxtKodeOutlet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ftxtKodeUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ftxtKodeJenis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ftxtKodeSift, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(72, 72, 72)
                        .addGroup(pnlSetKasAwalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblKasAwal)
                            .addComponent(ftxtKasAwal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                        .addComponent(btnSimpan)))
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlSetKasAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlSetKasAwal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if(ftxtKasAwal.getValue() instanceof Long){
            if(((Long)ftxtKasAwal.getValue()).doubleValue()==0.00 || ftxtKasAwal.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Kas Aktual Belum Diisi");
                return;
            }
        }
        else if(ftxtKasAwal.getValue() instanceof Double){
            if(((Double)ftxtKasAwal.getValue()).doubleValue()==0.00 || ftxtKasAwal.getText().trim().length()==0){
                JOptionPane.showMessageDialog(this, "Kas Aktual Belum Diisi");
                return;
            }
        }
        
        int KodeOutlet = (((Integer)ftxtKodeOutlet.getValue()).intValue());
        LH.setKodeOutlet(KodeOutlet);
        int KodeUser = (((Integer)ftxtKodeUser.getValue()).intValue());
        LH.setKodeUser(KodeUser);
        int KodeJenis = (((Integer)ftxtKodeJenis.getValue()).intValue());
        LH.setKodeJenis(KodeJenis);
        int KodeSift = (((Integer)ftxtKodeSift.getValue()).intValue());
        LH.setKodeSift(KodeSift);
        Calendar Tanggal = dchTanggal.getCalendar();
        int Tgl = Tanggal.getTime().getDate();
        LH.setTanggal(Tgl);
        int Bln = Tanggal.getTime().getMonth()+1;
        LH.setBulan(Bln);
        int Thn = Tanggal.getTime().getYear()+1900;
        LH.setTahun(Thn);
        LH.setTotalModal(0.00);
        LH.setTotalJual(0.00);
        LH.setTotalDiskon(0.00);
        if(ftxtKasAwal.getValue() instanceof Double){
            Double KasAwal = (((Double)ftxtKasAwal.getValue()).doubleValue());
            LH.setKasAktual(KasAwal);
        }
        else if(ftxtKasAwal.getValue() instanceof Long){
            Double KasAwal = (((Long)ftxtKasAwal.getValue()).doubleValue());
            LH.setKasAktual(KasAwal);
        }
        LH.setTotalVariance(0.00);
        LH.setTotalNota(0);
        
        try {
            LH.Simpan();
            
            DBConnector.getConnection().commit();
            Toolkit.getDefaultToolkit().beep();
            JOptionPane.showMessageDialog(this, "Data Berhasil Disimpan");
        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error Saat Menyimpan Kas : "+e.getMessage(),
                    "Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        
    }//GEN-LAST:event_btnSimpanActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTutup;
    private com.toedter.calendar.JDateChooser dchTanggal;
    private javax.swing.JFormattedTextField ftxtKasAwal;
    public javax.swing.JFormattedTextField ftxtKodeJenis;
    public javax.swing.JFormattedTextField ftxtKodeOutlet;
    public javax.swing.JFormattedTextField ftxtKodeSift;
    public javax.swing.JFormattedTextField ftxtKodeUser;
    private javax.swing.JLabel lblKasAwal;
    private javax.swing.JPanel pnlSetKasAwal;
    // End of variables declaration//GEN-END:variables
}
