/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import Util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class Merek {
    
    private int KodeMerek;
    private String NamaMerek;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeMerek(int KodeMerek){
        this.KodeMerek = KodeMerek;
    }
    public int getKodeMerek(){
        return 0;
    }
    public int getKodeMerek(int Kode){
        sql = "SELECT KodeMerek FROM merek WHERE KodeMerek="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMerek = rs.getInt(1);
                return KodeMerek;
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
    public void setNamaMerek(String NamaMerek){
        this.NamaMerek = NamaMerek;
    }
    public String getNamaMerek(){
        return NamaMerek;
    }
    public String getNamaMerek(int KodeMerek){
        sql = "SELECT NamaMerek FROM merek WHERE KodeMerek="+KodeMerek;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaMerek = rs.getString(1);
                return NamaMerek;
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
    public void UpdateNamaMerek(int KodeMerek,String NamaMerek) throws SQLException{
        sql = "UPDATE merek SET NamaMerek='"+NamaMerek+"' WHERE KodeMerek="+KodeMerek;
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
    public void getMerek(JComboBox cboMerek){
        sql = "SELECT KodeMerek,NamaMerek FROM merek";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboMerek.setModel(cbm);
//            cbm.addElement("-Pilih-");
            while(rs.next()){
                KodeMerek = rs.getInt(1);
                NamaMerek = rs.getString(2);
                
                cbm.addElement(KodeMerek+" "+NamaMerek);
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
    public void getMerek(JTable tblMerek){
        sql = "SELECT KodeMerek,NamaMerek FROM merek";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMerek.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Merek","Nama Merek"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblMerek.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblMerek.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblMerek.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void getMerek(JTable tblMerek,String NamaMerek){
        sql = "SELECT KodeMerek,NamaMerek FROM merek WHERE NamaMerek LIKE '%"+NamaMerek+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMerek.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Merek","Nama Merek"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblMerek.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblMerek.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblMerek.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void Simpan(String NamaMerek) throws SQLException{
        sql = "INSERT INTO merek (NamaMerek) VALUES ('"+NamaMerek+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMerek = rs.getInt(1);
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
    public void Simpan() throws SQLException{
        sql = "INSERT INTO merek (NamaMerek) VALUES(?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaMerek);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMerek = rs.getInt(1);
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
    public void Query() throws SQLException{
        sql = "SELECT KodeMerek,NamaMerek FROM merek WHERE KodeMerek="+KodeMerek;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeMerek = rs.getInt(1);
            NamaMerek = rs.getString(2);
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
    public void Hapus(int KodeMerek) throws SQLException{
        sql = "DELETE FROM merek WHERE KodeMerek="+KodeMerek;
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
        sql = "DELETE FROM merek";
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
