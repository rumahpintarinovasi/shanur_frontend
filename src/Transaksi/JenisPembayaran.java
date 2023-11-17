/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class JenisPembayaran {
    
    private int KodeJenis;
    private String NamaJenis;
    private int KodePenyimpanan;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeJenis(int KodeJenis){
        this.KodeJenis = KodeJenis;
    }
    public int getKodeJenis(){
        return KodeJenis;
    }
    public int getKodeJenis(int Kode){
        sql = "SELECT KodeJenis FORM jenispembayaran WHERE KodeJenis="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeJenis = rs.getInt(1);
                return KodeJenis;
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
    public void setNamaJenis(String NamaJenis){
        this.NamaJenis = NamaJenis;
    }
    public String getNamaJenis(){
        return NamaJenis;
    }
    public String getNamaJenis(int KodeJenis){
        sql = "SELECT NamaJenis FROM jenispembayaran WHERE KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaJenis = rs.getString(1);
                return NamaJenis;
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
    public void UpdateNamaJenis(int KodeJenis,String NamaJenis) throws SQLException{
        sql = "UPDATE jenispembayaran SET NamaJenis='"+NamaJenis+"' WHERE KodeJenis="+KodeJenis;
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
    public void setKodePenyimpanan(int KodePenyimpanan){
        this.KodePenyimpanan = KodePenyimpanan;
    }
    public int getKodePenyimpanan(){
        return KodePenyimpanan;
    }
    public int getKodePenyimpanan(int KodeJenis){
        sql = "SELECT KodePenyimpanan FROM jenispembayaran WHERE KodeJenis="+KodeJenis;
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
    public void UpdateKodePenyimpanan(int KodeJenis,int KodePenyimpanan) throws SQLException{
        sql = "UPDATE jenispembayaran SET KodePenyimpanan="+KodePenyimpanan+" WHERE KodeJenis="+KodeJenis;
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
    public void getJenisPembayaran(JComboBox cboJenisPembayaran){
        sql = "SELECT KodeJenis,NamaJenis FROM jenispembayaran";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboJenisPembayaran.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeJenis = rs.getInt(1);
                NamaJenis = rs.getString(2);
                
                cbm.addElement(KodeJenis+" "+NamaJenis);
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
    public void getJenisPembayaran(JTable tblJenisPembayaran){
        sql = "SELECT j.KodeJenis,j.NamaJenis,p.Nomor FROM jenispembayaran j INNER JOIN penyimpanan p "
                + "ON (j.KodePenyimpanan=p.KodePenyimpanan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPembayaran.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Jenis","Nama Jenis","Nomor"};
                Class ColType[] = {Integer.class,String.class,String.class};
                
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
                    return 3;
                }
            });
            
            Object rowdata[] = new Object[3];
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPembayaran.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPembayaran.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPembayaran.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblJenisPembayaran.getColumnModel().getColumn(2).setPreferredWidth(100);
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
    public void getJenisPembayaran1(JTable tblJenisPembayaran){
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPembayaran.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Jenis","Nama Jenis"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPembayaran.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPembayaran.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPembayaran.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void getJenisPembayaran(JTable tblJenisPembayaran,String NamaJenis){
        sql = "SELECT j.KodeJenis,j.NamaJenis,p.NamaPenyimpanan FROM jenispembayaran j INNER JOIN penyimpanan p "
                + "ON (j.KodePenyimpanan=p.KodePenyimpanan) WHERE (1=1) AND j.NamaJenis LIKE '%"+NamaJenis+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPembayaran.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Jenis","Nama Jenis","Penyimpanan"};
                Class ColType[] = {Integer.class,String.class,String.class};
                
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
                    return 3;
                }
            });
            
            Object rowdata[] = new Object[3];
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPembayaran.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPembayaran.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPembayaran.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblJenisPembayaran.getColumnModel().getColumn(2).setPreferredWidth(100);
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
    public void getJenisPembayaran1(JTable tblJenisPembayaran,String NamaJenis){
        sql = "SELECT j.KodeJenis,j.NamaJenis FROM jenispembayaran j INNER JOIN penyimpanan p "
                + "ON (j.KodePenyimpanan=p.KodePenyimpanan) WHERE (1=1) AND j.NamaJenis LIKE '%"+NamaJenis+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblJenisPembayaran.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Jenis","Nama Jenis"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblJenisPembayaran.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblJenisPembayaran.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblJenisPembayaran.getColumnModel().getColumn(1).setPreferredWidth(150);
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
    public void Simpan(String NamaJenis,int KodePenyimpanan) throws SQLException{
        sql = "INSERT INTO jenispembayaran (NamaJenis,KodePenyimpanan) VALUES ('"+NamaJenis+"',"+KodePenyimpanan+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeJenis = rs.getInt(1);
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
        sql = "INSERT INTO jenispembayaran (NamaJenis,KodePenyimpanan) VALUES (?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaJenis);
            PS.setInt(2, KodePenyimpanan);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeJenis = rs.getInt(1);
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
        sql = "SELECT KodeJenis,NamaJenis,KodePenyimpanan FROM jenispembayaran WHERE KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeJenis = rs.getInt(1);
            NamaJenis = rs.getString(2);
            KodePenyimpanan = rs.getInt(3);
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
        sql = "DELETE FROM jenispembayaran";
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
    public void Hapus(int KodeJenis) throws SQLException{
        sql = "DELETE FROM jenispembayaran WHERE KodeJenis="+KodeJenis;
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
