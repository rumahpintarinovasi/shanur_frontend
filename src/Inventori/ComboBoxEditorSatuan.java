/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import Util.DBConnector;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 *
 * @author Yestin
 */
public class ComboBoxEditorSatuan extends DefaultCellEditor{
    
    private JComboBox<String> cboSatuan;
    
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public ComboBoxEditorSatuan(String Barcode,JComboBox<String> cboSatuan){
        super (new JComboBox<String>());
        cboSatuan = (JComboBox<String>) getComponent();
        
//        cboSatuan.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                getSatuan(Barcode, cboSatuan, txtNamaSatuan);
//            }
//        });
        getSatuan(Barcode, cboSatuan);
    }
    private void getSatuan(String Barcode,JComboBox<String> cboSatuan){
        Statement stmt=null ;
        ResultSet rs;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='"+Barcode+"' ORDER BY s.NamaSatuan='PCS'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            int i=1;
            while(rs.next()){
                cboSatuan.setModel(cbm);
                String Satuan = rs.getString(1);
                cboSatuan.addItem(Satuan);
            }
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
    
}
