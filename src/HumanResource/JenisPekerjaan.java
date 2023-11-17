/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class JenisPekerjaan {
    
    private int KodeJob;
    private String NamaPekerjaan;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeJob(int KodeJob){
        this.KodeJob = KodeJob;
    }
    public int getKodeJob(){
        return KodeJob;
    }
    public int getKodeJob(int Kode){
        sql = "SELECT KodeJob FROM jenispekerjaan WHERE Kode="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeJob = rs.getInt(1);
                return KodeJob;
            }
            else{
                return 0;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return 0;
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
    public void setNamaPekerjaan(String NamaPekerjaan){
        this.NamaPekerjaan = NamaPekerjaan;
    }
    public String getNamaPekerjaan(){
        return NamaPekerjaan;
    }
    public String getNamaPekerjaan(int KodeJob){
        sql = "SELECT NamaPekerjaan FROM jenispekerjaan WHERE KodeJob="+KodeJob;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaPekerjaan = rs.getString(1);
                return NamaPekerjaan;
            }
            else{
                return null;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
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
    public void UpdateNamaPekerjaan(int KodeJob,String NamaPekerjaan) throws SQLException{
        sql = "UPDATE jenispekerjaan SET NamaPekerjaan='"+NamaPekerjaan+"' WHERE KodeJob="+KodeJob;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
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
    public void getJenisPekerjaan(JComboBox cboJenisPekerjaan){
        sql = "SELECT KodeJob,NamaPekerjaan FROM jenispekerjaan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboJenisPekerjaan.setModel(cbm);
            while(rs.next()){
                KodeJob = rs.getInt(1);
                NamaPekerjaan = rs.getString(2);
                
                cbm.addElement(KodeJob+" "+NamaPekerjaan);
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
    public void getJenisPekerjaan(JTable tblJenisPekerjaan){
        sql = "SELECT KodeJob,NamaPekerjaan FROM jenispekerjaan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Job","Nama Pekerjaan"};
                Class ColType[] = {Integer.class,String.class};
                
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
            
            Object rowdata[] = new Object[2];
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void getJenisPekerjaan(JTable tblJenisPekerjaan,String NamaPekerjaan){
        sql = "SELECT KodeJob,NamaPekerjaan FROM jenispekerjaan WHERE NamaPekerjaan LIKE '%"+NamaPekerjaan+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Job","Nama Pekerjaan"};
                Class ColType[] = {Integer.class,String.class};
                
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
            
            Object rowdata[] = new Object[2];
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void Simpan(String NamaPekerjaan) throws SQLException{
        sql = "INSERT INTO jenispekerjaan (NamaPekerjaan) VALUES ('"+NamaPekerjaan+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeJob = rs.getInt(1);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
        }
        finally{
            if(PS!=null){
                try {
                    PS.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan() throws SQLException{
        sql = "INSERT INTO jenispekerjaan (NamaPekerjaan) VALUES(?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaPekerjaan);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeJob = rs.getInt(1);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
        }
        finally{
            if(PS!=null){
                try {
                    PS.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Query() throws SQLException{
        sql = "SELECT KodeJob,NamaPekerjaan FROM jenispekerjaan WHERE KodeJob="+KodeJob;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeJob = rs.getInt(1);
            NamaPekerjaan = rs.getString(2);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
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
    public void Hapus(int KodeJob) throws SQLException{
        sql = "DELETE FROM jenispekerjaan WHERE KodeJob="+KodeJob;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
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
    public void Hapus() throws SQLException{
        sql = "DELETE FROM jenispekerjaan";
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
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
