/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori.gui;

import Inventori.Barang;
import Inventori.Items;
import Inventori.Kategori;
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
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yestin
 */
public class DataItems extends javax.swing.JDialog {

    Items Item = new Items();
    Kategori Kat = new Kategori();
    Merek Mrk = new Merek();
    Table Tab = new Table();
    BackgroundImage BI = new BackgroundImage();
    
    int Left = SwingConstants.LEFT;
    int Center = SwingConstants.CENTER;
    int Right = SwingConstants.RIGHT;
    /**
     * Creates new form DataItems
     */
    public DataItems(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setTitle("Data Items");
        BI.BackgroundJPanel(this, pnlDaftarItem);
        txtaNamaItem.setText(new String());
        txtaNamaItem.setText(null);
        Item.getItems(tblItem);
        Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        Tab.setHeaderForegroundColor(tblItem, Color.BLUE);
        Kat.getKategori(cboKategori);
        Mrk.getMerek(cboMerek);
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(false);
        ftxtKodeKategori.setVisible(false);
        ftxtKodeMerek.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgSelection = new javax.swing.ButtonGroup();
        pnlDaftarItem = new javax.swing.JPanel();
        rbNamaItem = new javax.swing.JRadioButton();
        rbJenisItem = new javax.swing.JRadioButton();
        txtaNamaItem = new javax.swing.JTextField();
        cboJenisItem = new javax.swing.JComboBox<>();
        rbKategori = new javax.swing.JRadioButton();
        cboKategori = new javax.swing.JComboBox<>();
        rbMerek = new javax.swing.JRadioButton();
        cboMerek = new javax.swing.JComboBox<>();
        rbSemua = new javax.swing.JRadioButton();
        scrlItem = new javax.swing.JScrollPane();
        tblItem = new javax.swing.JTable();
        btnTutup = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnPilih = new javax.swing.JButton();
        rbBarcode = new javax.swing.JRadioButton();
        txtBarcode = new javax.swing.JTextField();
        ftxtKodeKategori = new javax.swing.JFormattedTextField();
        ftxtKodeMerek = new javax.swing.JFormattedTextField();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        rbNamaItem.setBackground(new java.awt.Color(255, 255, 255));
        bgSelection.add(rbNamaItem);
        rbNamaItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbNamaItem.setForeground(new java.awt.Color(0, 0, 255));
        rbNamaItem.setText("Nama Item :");
        rbNamaItem.setOpaque(false);
        rbNamaItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbNamaItemItemStateChanged(evt);
            }
        });

        rbJenisItem.setBackground(new java.awt.Color(255, 255, 255));
        bgSelection.add(rbJenisItem);
        rbJenisItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbJenisItem.setForeground(new java.awt.Color(0, 0, 255));
        rbJenisItem.setText("Jenis Item :");
        rbJenisItem.setOpaque(false);
        rbJenisItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbJenisItemItemStateChanged(evt);
            }
        });

        txtaNamaItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtaNamaItem.setForeground(new java.awt.Color(0, 0, 255));
        txtaNamaItem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtaNamaItemKeyPressed(evt);
            }
        });

        cboJenisItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboJenisItem.setForeground(new java.awt.Color(0, 0, 255));
        cboJenisItem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- Pilih -", "Barang", "Jasa" }));
        cboJenisItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboJenisItemItemStateChanged(evt);
            }
        });
        cboJenisItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboJenisItemActionPerformed(evt);
            }
        });

        rbKategori.setBackground(new java.awt.Color(255, 255, 255));
        bgSelection.add(rbKategori);
        rbKategori.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbKategori.setForeground(new java.awt.Color(0, 0, 255));
        rbKategori.setText("Kategori :");
        rbKategori.setOpaque(false);
        rbKategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbKategoriItemStateChanged(evt);
            }
        });

        cboKategori.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboKategori.setForeground(new java.awt.Color(0, 0, 255));
        cboKategori.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboKategoriItemStateChanged(evt);
            }
        });

        rbMerek.setBackground(new java.awt.Color(255, 255, 255));
        bgSelection.add(rbMerek);
        rbMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbMerek.setForeground(new java.awt.Color(0, 0, 255));
        rbMerek.setText("Merek :");
        rbMerek.setOpaque(false);
        rbMerek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbMerekItemStateChanged(evt);
            }
        });

        cboMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cboMerek.setForeground(new java.awt.Color(0, 0, 255));
        cboMerek.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMerekItemStateChanged(evt);
            }
        });

        bgSelection.add(rbSemua);
        rbSemua.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbSemua.setForeground(new java.awt.Color(0, 0, 255));
        rbSemua.setSelected(true);
        rbSemua.setText("Semua");
        rbSemua.setOpaque(false);
        rbSemua.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbSemuaItemStateChanged(evt);
            }
        });

        tblItem.setAutoCreateRowSorter(true);
        tblItem.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblItem.setForeground(new java.awt.Color(0, 0, 255));
        scrlItem.setViewportView(tblItem);

        btnTutup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Tutup.png"))); // NOI18N

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Edit.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnPilih.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Pilih.png"))); // NOI18N
        btnPilih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilihActionPerformed(evt);
            }
        });

        bgSelection.add(rbBarcode);
        rbBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rbBarcode.setForeground(new java.awt.Color(0, 0, 255));
        rbBarcode.setText("Barcode :");
        rbBarcode.setOpaque(false);
        rbBarcode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbBarcodeItemStateChanged(evt);
            }
        });

        txtBarcode.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBarcode.setForeground(new java.awt.Color(0, 0, 255));
        txtBarcode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBarcodeKeyPressed(evt);
            }
        });

        ftxtKodeKategori.setEditable(false);
        ftxtKodeKategori.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        ftxtKodeKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtKodeKategoriActionPerformed(evt);
            }
        });

        ftxtKodeMerek.setEditable(false);
        ftxtKodeMerek.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btnHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Hapus.png"))); // NOI18N

        javax.swing.GroupLayout pnlDaftarItemLayout = new javax.swing.GroupLayout(pnlDaftarItem);
        pnlDaftarItem.setLayout(pnlDaftarItemLayout);
        pnlDaftarItemLayout.setHorizontalGroup(
            pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrlItem)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDaftarItemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnHapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEdit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 528, Short.MAX_VALUE)
                .addComponent(btnPilih)
                .addGap(18, 18, 18)
                .addComponent(btnTutup)
                .addGap(54, 54, 54))
            .addGroup(pnlDaftarItemLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbNamaItem)
                    .addComponent(rbJenisItem)
                    .addComponent(rbKategori)
                    .addComponent(rbMerek)
                    .addComponent(rbBarcode)
                    .addComponent(rbSemua))
                .addGap(74, 74, 74)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtaNamaItem)
                        .addComponent(cboJenisItem, 0, 463, Short.MAX_VALUE)
                        .addComponent(cboKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cboMerek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBarcode))
                    .addGroup(pnlDaftarItemLayout.createSequentialGroup()
                        .addComponent(ftxtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ftxtKodeMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDaftarItemLayout.setVerticalGroup(
            pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDaftarItemLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbBarcode)
                    .addComponent(txtBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNamaItem)
                    .addComponent(txtaNamaItem, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbJenisItem)
                    .addComponent(cboJenisItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(rbKategori)
                    .addComponent(cboKategori, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbMerek)
                    .addComponent(cboMerek, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbSemua)
                    .addComponent(ftxtKodeKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftxtKodeMerek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(scrlItem, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDaftarItemLayout.createSequentialGroup()
                        .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDaftarItemLayout.createSequentialGroup()
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(86, 86, 86))
                    .addGroup(pnlDaftarItemLayout.createSequentialGroup()
                        .addGroup(pnlDaftarItemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTutup)
                            .addComponent(btnPilih, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDaftarItem, javax.swing.GroupLayout.PREFERRED_SIZE, 762, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbNamaItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbNamaItemItemStateChanged
        // TODO add your handling code here:
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(true);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(false);
    }//GEN-LAST:event_rbNamaItemItemStateChanged

    private void rbJenisItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbJenisItemItemStateChanged
        // TODO add your handling code here:
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(true);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(false);
    }//GEN-LAST:event_rbJenisItemItemStateChanged

    private void txtaNamaItemKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtaNamaItemKeyPressed
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

            String NamaItem = (((String)txtaNamaItem.getText().trim()).toString());
            Item.getItems2(tblItem, NamaItem);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
    }//GEN-LAST:event_txtaNamaItemKeyPressed

    private void cboJenisItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboJenisItemItemStateChanged
        // TODO add your handling code here:
        if(cboJenisItem.getSelectedIndex()==1){
            Item.getItems3(tblItem, 1);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
        else if(cboJenisItem.getSelectedIndex()==2){
            Item.getItems3(tblItem, 2);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
    }//GEN-LAST:event_cboJenisItemItemStateChanged

    private void rbKategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbKategoriItemStateChanged
        // TODO add your handling code here:
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(true);
        cboMerek.setEnabled(false);
    }//GEN-LAST:event_rbKategoriItemStateChanged

    private void cboKategoriItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboKategoriItemStateChanged
        // TODO add your handling code here:
        if(cboKategori.getSelectedIndex()==0){
            ftxtKodeKategori.setValue(new Integer(0));
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
        else{
            String Kategori = ((String)cboKategori.getSelectedItem()).toString();
            int Kode = Kategori.indexOf(' ');
            String KodeKaetgori = Kategori.substring(0, Kode);
            int KodeKat = Integer.valueOf(KodeKaetgori);

            Item.getItems4(tblItem, KodeKat);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
    }//GEN-LAST:event_cboKategoriItemStateChanged

    private void rbMerekItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbMerekItemStateChanged
        // TODO add your handling code here:
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(true);
    }//GEN-LAST:event_rbMerekItemStateChanged

    private void cboMerekItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMerekItemStateChanged
        // TODO add your handling code here:
        if(cboMerek.getSelectedIndex()==0){
            ftxtKodeMerek.setValue(new Integer(0));
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
        else{
            String Merek = ((String)cboMerek.getSelectedItem()).toString();
            int Kode = Merek.indexOf(' ');
            String KodeMerek = Merek.substring(0, Kode);
            int KodeMrk = Integer.valueOf(KodeMerek);

            Item.getItems5(tblItem, KodeMrk);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
    }//GEN-LAST:event_cboMerekItemStateChanged

    private void rbSemuaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbSemuaItemStateChanged
        // TODO add your handling code here:
        Item.getItems(tblItem);
        Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        txtBarcode.setEnabled(false);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(false);
    }//GEN-LAST:event_rbSemuaItemStateChanged

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        int row = tblItem.getSelectedRow();
        if(row<=-1){
            JOptionPane.showMessageDialog(this, "Item Belum Dipilih");
            return;
        }
        
        EditItems EI = new EditItems(null, true);
        
        DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        
        EI.txtBarcode.setText(Barcode);
        String NamaItem = Item.getNamaItem(Barcode);
        EI.txtNamaItem.setText(NamaItem);
       
        EI.setLocationRelativeTo(this);
        EI.setVisible(true);
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPilihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilihActionPerformed
        // TODO add your handling code here:
        int row = tblItem.getSelectedRow();
        if(row<=-1){
            JOptionPane.showMessageDialog(this, "Item Belum Dipilih");
            return;
        }
        getSelectedItems();
        setVisible(false);
        dispose();
    }//GEN-LAST:event_btnPilihActionPerformed

    private void rbBarcodeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbBarcodeItemStateChanged
        // TODO add your handling code here:
        txtBarcode.setEnabled(true);
        txtaNamaItem.setEnabled(false);
        cboJenisItem.setEnabled(false);
        cboKategori.setEnabled(false);
        cboMerek.setEnabled(false);
    }//GEN-LAST:event_rbBarcodeItemStateChanged

    private void txtBarcodeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBarcodeKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            String Barcode = (((String)txtBarcode.getText().trim()).toString());
            Item.getItems1(tblItem, Barcode);
            Tab.TableAlignment5(tblItem, Left, Left, Center, Center, Center, Center);
        }
    }//GEN-LAST:event_txtBarcodeKeyPressed

    private void cboJenisItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboJenisItemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboJenisItemActionPerformed

    private void ftxtKodeKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtKodeKategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtKodeKategoriActionPerformed
    public Items getSelectedItems(){
        int row ;
        row = tblItem.getSelectedRow();
        if(row<=-1){
            return null;
        }
        DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
        
        String Barcode = (((String)dtm.getValueAt(row, 0)).toString());
        Item.setBarcode(Barcode);
        String NamaItem = (((String)dtm.getValueAt(row, 1)).toString());
        Item.setNamaItem(NamaItem);
        String JenisItem = (((String)dtm.getValueAt(row, 2)).toString());
        if(JenisItem=="Barang"){
            Item.setJenisItem(1);
        }
        else if(JenisItem=="Jasa"){
            Item.setJenisItem(2);
        }
        String Kategori = (((String)dtm.getValueAt(row, 3)).toString());
        Kat.setNamaKategori(Kategori);
        String Merek = (((String)dtm.getValueAt(row, 4)).toString());
        Mrk.setNamaMerek(Merek);
        
        return Item;
    }
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgSelection;
    public javax.swing.JButton btnEdit;
    public javax.swing.JButton btnHapus;
    private javax.swing.JButton btnPilih;
    private javax.swing.JButton btnTutup;
    private javax.swing.JComboBox<String> cboJenisItem;
    private javax.swing.JComboBox<String> cboKategori;
    private javax.swing.JComboBox<String> cboMerek;
    private javax.swing.JFormattedTextField ftxtKodeKategori;
    private javax.swing.JFormattedTextField ftxtKodeMerek;
    private javax.swing.JPanel pnlDaftarItem;
    private javax.swing.JRadioButton rbBarcode;
    private javax.swing.JRadioButton rbJenisItem;
    private javax.swing.JRadioButton rbKategori;
    private javax.swing.JRadioButton rbMerek;
    private javax.swing.JRadioButton rbNamaItem;
    private javax.swing.JRadioButton rbSemua;
    private javax.swing.JScrollPane scrlItem;
    public javax.swing.JTable tblItem;
    private javax.swing.JTextField txtBarcode;
    private javax.swing.JTextField txtaNamaItem;
    // End of variables declaration//GEN-END:variables
}
