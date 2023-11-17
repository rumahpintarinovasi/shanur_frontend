/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import Util.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Yestin
 */
public class CBORenderer extends DefaultCellEditor
{
    
    public CBORenderer() {
        //super(new JComboBox<>(items));
        super(new JComboBox<String>());
    }
    
    public void reloadData(String barcode)
    {
        ResultSet rs;
        Statement stmt = null;
        String sql;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='" + barcode + "' ORDER BY s.NamaSatuan='PCS'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            JComboBox cboSatuan = (JComboBox) super.getComponent();
            cboSatuan.setModel(cbm);
            while (rs.next()){
                String Satuan = rs.getString(1);
                cbm.addElement(Satuan);
            }
            cboSatuan.setSelectedIndex(0);
//            
//            String NamaSatuan = ((String)cboSatuan.getSelectedItem()).toString();
//            txtNamaSatuan.setText(new String(NamaSatuan));
//            cboSatuanItemListener(cboSatuan, txtNamaSatuan);
        } 
        catch (SQLException e) {
            e.printStackTrace(System.out);
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
