/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource.gui;

import HumanResource.JenisPekerjaan;
import Inventori.gui.RegistrasiKategori;
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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yestin
 */
public class DaftarJenisPekerjaan extends javax.swing.JFrame {

    JenisPekerjaan JP = new JenisPekerjaan();
    Table Tab = new Table();
    BackgroundImage BI = new BackgroundImage();
    
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    /**
     * Creates new form DaftarJenisPekerjaan
     */
    public DaftarJenisPekerjaan() {
        initComponents();
        setTitle("Daftar Jenis Pekerjaan");
        BI.BackgroundJPanel(this, pnlDaftarJenisPekerjaan);
        txtNamaPekerjaan.setText(new String());
        txtNamaPekerjaan.setText(null);
        JP.getJenisPekerjaan(tblJenisPekerjaan);
        Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDaftarJenisPekerjaan = new javax.swing.JPanel();
        lblNamaJenisPekerjaan = new javax.swing.JLabel();
        txtNamaPekerjaan = new javax.swing.JTextField();
        scrlJenisPekerjaan = new javax.swing.JScrollPane();
        tblJenisPekerjaan = new javax.swing.JTable();
        btnTutup = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        brnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNamaJenisPekerjaan.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaJenisPekerjaan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaJenisPekerjaan.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaJenisPekerjaan.setText("Nama Pekerjaan :");

        txtNamaPekerjaan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaPekerjaan.setForeground(new java.awt.Color(0, 0, 255));
        txtNamaPekerjaan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaPekerjaanKeyPressed(evt);
            }
        });

        tblJenisPekerjaan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblJenisPekerjaan.setForeground(new java.awt.Color(0, 0, 255));
        scrlJenisPekerjaan.setViewportView(tblJenisPekerjaan);

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        brnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        brnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                brnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDaftarJenisPekerjaanLayout = new javax.swing.GroupLayout(pnlDaftarJenisPekerjaan);
        pnlDaftarJenisPekerjaan.setLayout(pnlDaftarJenisPekerjaanLayout);
        pnlDaftarJenisPekerjaanLayout.setHorizontalGroup(
            pnlDaftarJenisPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaftarJenisPekerjaanLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(lblNamaJenisPekerjaan)
                .addGap(44, 44, 44)
                .addComponent(txtNamaPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(135, Short.MAX_VALUE))
            .addComponent(scrlJenisPekerjaan)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDaftarJenisPekerjaanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(brnRefresh)
                .addGap(41, 41, 41)
                .addComponent(btnEdit)
                .addGap(42, 42, 42)
                .addComponent(btnTutup)
                .addGap(45, 45, 45))
        );
        pnlDaftarJenisPekerjaanLayout.setVerticalGroup(
            pnlDaftarJenisPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDaftarJenisPekerjaanLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(pnlDaftarJenisPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaJenisPekerjaan)
                    .addComponent(txtNamaPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(scrlJenisPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(pnlDaftarJenisPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDaftarJenisPekerjaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(brnRefresh))
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDaftarJenisPekerjaan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDaftarJenisPekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaPekerjaanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaPekerjaanKeyPressed
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
            String NamaPekerjaan = (((String)txtNamaPekerjaan.getText().trim()).toString());
            JP.getJenisPekerjaan(tblJenisPekerjaan, NamaPekerjaan);
            Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
        }
    }//GEN-LAST:event_txtNamaPekerjaanKeyPressed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        if(tblJenisPekerjaan.getSelectedRow() <= -1){
            JOptionPane.showMessageDialog(this, "Data Pada Tabel Belum Dipilih");
            return;
        }
        EditJenisPekerjaan EJP = new EditJenisPekerjaan();
        
        int row = tblJenisPekerjaan.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblJenisPekerjaan.getModel();
        
        int KodeJenis = (((Integer)dtm.getValueAt(row, 0)).intValue());
        String NamaPekerjaan = (((String)dtm.getValueAt(row, 1)).toString());
        
        EJP.ftxtKodeJenis.setValue(new Integer(KodeJenis));
        EJP.txtJenisPekerjaan.setText(new String(NamaPekerjaan));
        
        EJP.setLocationRelativeTo(this);
        EJP.setVisible(true);
        
        if(txtNamaPekerjaan.getText().trim().length()==0){
            JP.getJenisPekerjaan(tblJenisPekerjaan);
            Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
        }
        else if(txtNamaPekerjaan.getText().trim().length()>0){
            String NamaJob = (((String)txtNamaPekerjaan.getText().trim()).toString());
            JP.getJenisPekerjaan(tblJenisPekerjaan, NamaJob);
            Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void brnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_brnRefreshActionPerformed
        // TODO add your handling code here:
        if(txtNamaPekerjaan.getText().trim().length()==0){
            JP.getJenisPekerjaan(tblJenisPekerjaan);
            Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
        }
        else if(txtNamaPekerjaan.getText().trim().length()>0){
            String NamaJob = (((String)txtNamaPekerjaan.getText().trim()).toString());
            JP.getJenisPekerjaan(tblJenisPekerjaan, NamaJob);
            Tab.TableAlignment2(tblJenisPekerjaan, Center, Left, Center);
        }
    }//GEN-LAST:event_brnRefreshActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton brnRefresh;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel lblNamaJenisPekerjaan;
    private javax.swing.JPanel pnlDaftarJenisPekerjaan;
    private javax.swing.JScrollPane scrlJenisPekerjaan;
    private javax.swing.JTable tblJenisPekerjaan;
    private javax.swing.JTextField txtNamaPekerjaan;
    // End of variables declaration//GEN-END:variables
}
