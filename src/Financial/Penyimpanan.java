/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Penyimpanan {
    
    private int KodePenyimpanan;
    private String NamaPenyimpanan;
    private String Nomor;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodePenyimpanan(int KodePenyimpanan){
        this.KodePenyimpanan = KodePenyimpanan;
    }
    public int getKodePenyimpanan(){
        return KodePenyimpanan;
    }
    public int getKodePenyimpanan(int Kode){
        sql = "SELECT KodePenyimpanan FROM penyimpanan WHERE KodePenyimpanan="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePenyimpanan = rs.getInt(1);
                return KodePenyimpanan;
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
    public int getKodePenyimpanan(String Nomor){
        sql = "SELECT KodePenyimpanan FROM penyimpanan WHERE Nomor='"+Nomor+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePenyimpanan = rs.getInt(1);
                return KodePenyimpanan;
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
    public int getKodePenyimpanan(String NamaPenyimpanan,String Nomor){
        sql = "SELECT KodePenyimpanan FROM penyimpanan WHERE NamaPenyimpanan='"+NamaPenyimpanan+"' AND Nomor='"+Nomor+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePenyimpanan = rs.getInt(1);
                return KodePenyimpanan;
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
    public void setNamaPenyimpanan(String NamaPenyimpanan){
        this.NamaPenyimpanan = NamaPenyimpanan;
    }
    public String getNamaPenyimpanan(){
        return NamaPenyimpanan;
    }
    public String getNamaPenyimpanan(int KodePenyimpanan){
        sql = "SELECT NamaPenyimpanan FROM penyimpanan WHERE KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaPenyimpanan = rs.getString(1);
                return NamaPenyimpanan;
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
    public void UpdateNamaPenyimpanan(int KodePenyimpanan,String NamaPenyimpanan) throws SQLException{
        sql = "UPDATE penyimpanan SET NamaPenyimpanan='"+NamaPenyimpanan+"' WHERE KodePenyimpanan="+KodePenyimpanan;
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
    public void setNomor(String Nomor){
        this.Nomor = Nomor;
    }
    public String getNomor(){
        return Nomor;
    }
    public String getNomor(int KodePenyimpanan){
        sql = "SELECT Nomor FROM penyimpanan WHERE KodePeyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Nomor = rs.getString(1);
                return Nomor;
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
    public void UpdateNomor(int KodePenyimpanan,String Nomor) throws SQLException{
        sql = "UPDATE penyimpanan SET Nomor='"+Nomor+"' WHERE KodePenyimpanan="+KodePenyimpanan;
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
    public void getPenyimpanan(JComboBox cboPenyimpanan){
        Statement stmt = null;
        ResultSet rs;
        sql = "SELECT NamaPenyimpanan,Nomor FROM penyimpanan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboPenyimpanan.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                NamaPenyimpanan = rs.getString(1);
                Nomor = rs.getString(2);
                
                cbm.addElement(Nomor+" "+NamaPenyimpanan);
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
    public void getPenyimpanan(JTable tblPenyimpanan){
        sql = "SELECT NamaPenyimpanan,Nomor FROM penyimpanan";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPenyimpanan.setModel(new DefaultTableModel(){
                String ColName[] = {"Nama Penyimpanan","Nomor"};
                Class ColType[] = {String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPenyimpanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPenyimpanan.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPenyimpanan.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void getPenyimpanan1(JTable tblPenyimpanan,String NamaPenyimpanan){
        sql = "SELECT NamaPenyimpanan,Nomor FROM penyimpanan WHERE NamaPenyimpanan LIKE '"+NamaPenyimpanan+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPenyimpanan.setModel(new DefaultTableModel(){
                String ColName[] = {"Nama Penyimpanan","Nomor"};
                Class ColType[] = {String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPenyimpanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPenyimpanan.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPenyimpanan.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void getPenyimpanan2(JTable tblPenyimpanan,String Nomor){
        sql = "SELECT NamaPenyimpanan,Nomor FROM penyimpanan WHERE Nomor LIKE '%"+Nomor+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPenyimpanan.setModel(new DefaultTableModel(){
                String ColName[] = {"Nama Penyimpanan","Nomor"};
                Class ColType[] = {String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPenyimpanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPenyimpanan.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPenyimpanan.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void Simpan(String NamaPenyimpanan,String Nomor) throws SQLException{
        sql = "INSERT INTO penyimpanan (NamaPenyimpanan,Nomor) VALUES ('"+NamaPenyimpanan+"','"+Nomor+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodePenyimpanan = rs.getInt(1);
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
        sql = "INSERT INTO penyimpanan (NamaPenyimpanan,Nomor) VALUES (?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaPenyimpanan);
            PS.setString(2, Nomor);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodePenyimpanan = rs.getInt(1);
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
        sql = "SELECT NamaPenyimpanan,Nomor FROM penyimpanan WHERE KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NamaPenyimpanan = rs.getString(1);
            Nomor = rs.getString(2);
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
    public void Hapus(int KodePenyimpanan) throws SQLException{
        sql = "DELETE FROM penyimpanan WHERE KodePenyimpanan="+KodePenyimpanan;
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
        sql = "DELETE FROM penyimpanan";
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
