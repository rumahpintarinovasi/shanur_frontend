/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import Util.DBConnector;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class Satuan {
    
    private int KodeSatuan;
    private String NamaSatuan;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeSatuan(int KodeSatuan){
        this.KodeSatuan = KodeSatuan;
    }
    public int getKodeSatuan(){
        sql = "SELECT KodeSatuan FROM satuan WHERE KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSatuan = rs.getInt(1);
                return KodeSatuan;
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
    public int getKodeSatuan(int Kode){
        sql = "SELECT KodeSatuan FROM satuan WHERE KodeSatuan="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSatuan = rs.getInt(1);
                return KodeSatuan;
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
    public int getKodeSatuan(String NamaSatuan){
        sql = "SELECT KodeSatuan FROM satuan WHERE NamaSatuan='"+NamaSatuan+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSatuan = rs.getInt(1);
                return KodeSatuan;
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
    public int getKodeSatuan(String NamaSatuan,int KodeSatuan){
        sql = "SELECT KodeSatuan FROM satuan WHERE NamaSatuan='"+NamaSatuan+"' AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSatuan = rs.getInt(1);
                return KodeSatuan;
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
    public void setNamaSatuan(String NamaSatuan){
        this.NamaSatuan = NamaSatuan;
    }
    public String getNamaSatuan(){
        return NamaSatuan;
    }
    public String getNamaSatuan(int KodeSatuan){
        sql = "SELECT NamaSatuan FROM satuan WHERE KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaSatuan = rs.getString(1);
                return NamaSatuan;
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
    public void UpdateNamaSatuan(int KodeSatuan,String NamaSatuan) throws SQLException{
        sql = "UPDATE satuan SET NamaSatuan='"+NamaSatuan+"' WHERE KodeSatuan="+KodeSatuan;
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
    public void getSatuan(JTable tblSatuan){
        sql = "SELECT KodeSatuan,NamaSatuan FROM satuan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblSatuan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Satuan","Nama Satuan"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblSatuan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblSatuan.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSatuan.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void getSatuan(JTable tblSatuan,String NamaSatuan){
        sql = "SELECT KodeSatuan,NamaSatuan FROM satuan WHERE NamaSatuan LIKE '%"+NamaSatuan+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblSatuan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Satuan","Nama Satuan"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblSatuan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblSatuan.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSatuan.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void getSatuan(JComboBox cboSatuan){
        sql = "SELECT KodeSatuan,NamaSatuan FROM satuan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeSatuan = rs.getInt(1);
                NamaSatuan = rs.getString(2);
                cbm.addElement(KodeSatuan+" "+NamaSatuan);
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
    public String getSatuan1(JComboBox cboSatuan){
        sql = "SELECT NamaSatuan FROM satuan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                NamaSatuan = rs.getString(1);
                cbm.addElement(NamaSatuan);
            }
            return NamaSatuan;
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
    public void Simpan(String NamaSatuan) throws SQLException{
        sql = "INSERT INTO satuan (NamaSatuan) VALUES ('"+NamaSatuan+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSatuan = rs.getInt(1);
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
        sql = "INSERT INTO satuan (NamaSatuan) VALUES (?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaSatuan);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSatuan = rs.getInt(1);
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
        sql = "SELECT KodeSatuan,NamaSatuan FROM satuan WHERE KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeSatuan = rs.getInt(1);
            NamaSatuan = rs.getString(2);
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
    public void Hapus(int KodeSatuan) throws SQLException{
        sql = "DELETE FROM satuan WHERE KodeSatuan="+KodeSatuan;
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
        sql = "DELETE FROM satuan";
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
