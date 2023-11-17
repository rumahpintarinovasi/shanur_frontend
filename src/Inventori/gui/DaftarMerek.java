/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori.gui;

import Inventori.Merek;
import Util.BackgroundImage;
import Util.BackgroundPane;
import Util.Table;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yestin
 */
public class DaftarMerek extends javax.swing.JFrame {

    Merek Merek = new Merek();
    Table Tab = new Table();
    BackgroundImage BI = new BackgroundImage();
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    /**
     * Creates new form DaftarMerek
     */
    public DaftarMerek() {
        initComponents();
        setTitle("Daftar Merek");
        BI.BackgroundJPanel(this, pnlDataMerek);
        Merek.getMerek(tblMerek);
        Tab.TableAlignment2(tblMerek, Center, Left,Center);
        Tab.setHeaderForegroundColor(tblMerek, Color.BLUE);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDataMerek = new javax.swing.JPanel();
        lblNamaMerek = new javax.swing.JLabel();
        txtNamaMerek = new javax.swing.JTextField();
        scrlMerek = new javax.swing.JScrollPane();
        tblMerek = new javax.swing.JTable();
        btnTutup = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblNamaMerek.setBackground(new java.awt.Color(255, 255, 255));
        lblNamaMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lblNamaMerek.setForeground(new java.awt.Color(0, 0, 255));
        lblNamaMerek.setText("Nama Merek :");

        txtNamaMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNamaMerek.setForeground(new java.awt.Color(0, 0, 255));
        txtNamaMerek.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamaMerekKeyPressed(evt);
            }
        });

        tblMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblMerek.setForeground(new java.awt.Color(0, 0, 255));
        tblMerek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        scrlMerek.setViewportView(tblMerek);

        btnTutup.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon2/Edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Refresh.png"))); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDataMerekLayout = new javax.swing.GroupLayout(pnlDataMerek);
        pnlDataMerek.setLayout(pnlDataMerekLayout);
        pnlDataMerekLayout.setHorizontalGroup(
            pnlDataMerekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataMerekLayout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addComponent(lblNamaMerek)
                .addGap(61, 61, 61)
                .addComponent(txtNamaMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlDataMerekLayout.createSequentialGroup()
                .addComponent(scrlMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 837, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDataMerekLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(39, 39, 39)
                .addComponent(btnEdit)
                .addGap(42, 42, 42)
                .addComponent(btnTutup)
                .addGap(53, 53, 53))
        );
        pnlDataMerekLayout.setVerticalGroup(
            pnlDataMerekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataMerekLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(pnlDataMerekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNamaMerek)
                    .addComponent(txtNamaMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(scrlMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(pnlDataMerekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDataMerekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(btnRefresh))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDataMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDataMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaMerekKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamaMerekKeyPressed
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
            
            String NamaMerek = (((String)txtNamaMerek.getText().trim()).toString());
            Merek.getMerek(tblMerek, NamaMerek);
            Tab.TableAlignment2(tblMerek, Center, Left, Center);
            Tab.setHeaderForegroundColor(tblMerek, Color.BLUE);
        }
    }//GEN-LAST:event_txtNamaMerekKeyPressed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnTutupActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        EditMerek EM = new EditMerek();
        
        int row = tblMerek.getSelectedRow();
        DefaultTableModel dtm = (DefaultTableModel)tblMerek.getModel();
        
        int KodeMerek = (((Integer)dtm.getValueAt(row, 0)).intValue());
        String NamaMerek = (((String)dtm.getValueAt(row, 1)).toString());
        
        EM.ftxtKodeMerek.setValue(new Integer(KodeMerek));
        EM.txtNamaMerek.setText(new String(NamaMerek));
        
        EM.setLocationRelativeTo(this);
        EM.setVisible(true);
        
        if(txtNamaMerek.getText().trim().length()==0){
            Merek.getMerek(tblMerek);
        }
        else if(txtNamaMerek.getText().trim().length()>0){
            String NmMerek = (((String)txtNamaMerek.getText().trim()).toString());
            Merek.getMerek(tblMerek, NmMerek);
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        if(txtNamaMerek.getText().trim().length()==0){
            Merek.getMerek(tblMerek);
        }
        else if(txtNamaMerek.getText().trim().length()>0){
            String NmMerek = (((String)txtNamaMerek.getText().trim()).toString());
            Merek.getMerek(tblMerek, NmMerek);
        }
    }//GEN-LAST:event_btnRefreshActionPerformed

    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTutup;
    private javax.swing.JLabel lblNamaMerek;
    private javax.swing.JPanel pnlDataMerek;
    private javax.swing.JScrollPane scrlMerek;
    private javax.swing.JTable tblMerek;
    private javax.swing.JTextField txtNamaMerek;
    // End of variables declaration//GEN-END:variables
}
