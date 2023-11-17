/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import Util.DBConnector;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Yestin
 */
public class ComboBoxRendererSatuan extends JComboBox<String> implements TableCellRenderer{
    
    String sql;
    Statement stmt = null;
    
    public ComboBoxRendererSatuan(String Barcode,JComboBox cboSatuan) {
        
        cboSatuan = new JComboBox();
        
        Statement stmt = null;
        ResultSet rs;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='"+Barcode+"' ORDER BY s.NamaSatuan='PCS'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            while(rs.next()){
                cboSatuan.setModel(cbm);
                String Satuan = rs.getString(1);
                cboSatuan.addItem(Satuan);
            }
//            cboSatuan.setSelectedIndex(0);
//            
//            String NamaSatuan = ((String)cboSatuan.getSelectedItem()).toString();
//            txtNamaSatuan.setText(new String(NamaSatuan));
//            cboSatuanItemListener(cboSatuan, txtNamaSatuan);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setSelectedItem(value);
        return this;
    }
    
    private void cboSatuanItemStateChanged(ItemEvent evt,JComboBox cboSatuan,JTextField txtNamaSatuan){
        String NamaSatuan = ((String)cboSatuan.getSelectedItem()).toString();
        txtNamaSatuan.setText(new String(NamaSatuan));
    }
    private void cboSatuanItemListener(JComboBox cboSatuan,JTextField txtNamaSatuan){
        cboSatuan.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cboSatuanItemStateChanged(e, cboSatuan, txtNamaSatuan);
            }
        });
    }
}
