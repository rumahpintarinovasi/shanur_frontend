/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orderan;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;

/**
 *
 * @author Yestin
 */
public class Mobil {
    
    private int KodeMobil;
    private String NoPolisi;
    private int JenisMobil;
    private String Merek;
    private String Warna;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeMobil(int KodeMobil){
        this.KodeMobil = KodeMobil;
    }
    public int getKodeMobil(){
        return KodeMobil;
    }
    public int getKodeMobil(int Kode){
        sql = "SELECT KodeMobil FROM mobil WHERE KodeMobil="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMobil = rs.getInt(1);
                return KodeMobil;
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
    public void setNoPolisi(String NoPolisi){
        this.NoPolisi = NoPolisi;
    }
    public String getNoPolisi(){
        return NoPolisi;
    }
    public String getNoPolisi(int KodeMobil){
        sql = "SELECT NoPolisi FROM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoPolisi = rs.getString(1);
                return NoPolisi;
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
    public void UpdateNoPolisi(int KodeMobil,String NoPolisi) throws SQLException{
        sql = "UPDATE mobil SET NoPolisi='"+NoPolisi+"' WHERE KodeMobil="+KodeMobil;
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
    public void setJenisMobil(int JenisMobil){
        this.JenisMobil = JenisMobil;
    }
    public int getJenisMobil(){
        return JenisMobil;
    }
    public int getJenisMobil(int KodeMobil){
        sql = "SELECT JenisMobil FROM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisMobil = rs.getInt(1);
                return JenisMobil;
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
    public void UpdateJenisMobil(int KodeMobil,int JenisMobil) throws SQLException{
        sql = "UPDATE mobil SET JenisMobil="+JenisMobil+" WHERE KodeMobil="+KodeMobil;
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
    public void setMerek(String Merek){
        this.Merek = Merek;
    }
    public String getMerek(){
        return Merek;
    }
    public String getMerek(int KodeMobil){
        sql = "SELECT Merek FRoM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Merek = rs.getString(1);
                return Merek;
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
    public void UpdateMerek(int KodeMobil,String Merek) throws SQLException{
        sql = "UPDATE mobil SET Merek='"+Merek+"' WHERE KodeMobil="+KodeMobil;
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
    public void setWarna(String Warna){
        this.Warna = Warna;
    }
    public String getWarna(){
        return Warna;
    }
    public String getWarna(int KodeMobil){
        sql = "SELECT Warna FROM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Warna = rs.getString(1);
                return Warna;
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
    public void UpdateWarna(int KodeMobil,String Warna) throws SQLException{
        sql = "UPDATE mobil SET Warna='"+Warna+"' WHERE KodeMobil="+KodeMobil;
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
    public void getMobil(JComboBox cboMobil){
        sql = "SELECT KodeMobil,NoPolisi,Merek,"
                + "CASE WHEN (JenisMobil=1) THEN 'Pick Up Open'  "
                + "WHEN (JenisMobil=2) THEN 'Pick Up Box' "
                + "WHEN (JenisMobil=3) THEN 'Truk Box' "
                + "WHEN (JenisMobil=4) THEN 'Truk Open' END AS JenisMobil,Warna FROM mobil";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboMobil.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeMobil = rs.getInt(1);
                NoPolisi = rs.getString(2);
                Merek = rs.getString(3);
                String JnsMobil = rs.getString(4);
                Warna = rs.getString(5);
                
                cbm.addElement(KodeMobil+" "+NoPolisi+" "+Merek+" "+JnsMobil+" "+Warna);
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
    public void getMobil(JTable tblMobil){
        sql = "SELECT KodeMobil,NoPolisi,"
                + "CASE WHEN (JenisMobil=1) THEN 'Pick Up Open' " 
                + "WHEN (JenisMobil=2) THEN 'Pick Up Box' "
                + "WHEN (JenisMobil=3) THEN 'Truk Box' "
                + "WHEN (JenisMobil=4) THEN 'Truk Open' END AS JenisMobil,"
                + "Merek,Warna FROM mobil ";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMobil.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Mobil","No Polisi","Jenis Mobil","Merek","Warna"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
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
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblMobil.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblMobil.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblMobil.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMobil.getColumnModel().getColumn(4).setPreferredWidth(50);
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
    public void getMobil(JTable tblMobil,String NoPolisi){
        sql = "SELECT KodeMobil,NoPolisi,"
                + "CASE WHEN (JenisMobil=1) THEN 'Pick Up Open' " 
                + "WHEN (JenisMobil=2) THEN 'Pick Up Box' "
                + "WHEN (JenisMobil=3) THEN 'Truk Box' "
                + "WHEN (JenisMobil=4) THEN 'Truk Open' END AS JenisMobil,"
                + "Merek,Warna FROM mobil WHERE NoPolisi LIKE '%"+NoPolisi+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMobil.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Mobil","No Polisi","Jenis Mobil","Merek","Warna"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
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
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblMobil.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblMobil.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblMobil.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMobil.getColumnModel().getColumn(4).setPreferredWidth(50);
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
    public void getMobil(JTable tblMobil,int JenisMobil){
        sql = "SELECT KodeMobil,NoPolisi,"
                + "CASE WHEN (JenisMobil=1) THEN 'Pick Up Open' " 
                + "WHEN (JenisMobil=2) THEN 'Pick Up Box' "
                + "WHEN (JenisMobil=3) THEN 'Truk Box' "
                + "WHEN (JenisMobil=4) THEN 'Truk Open' END AS JenisMobil,"
                + "Merek,Warna FROM mobil WHERE JenisMobil="+JenisMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMobil.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Mobil","No Polisi","Jenis Mobil","Merek","Warna"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
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
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblMobil.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblMobil.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblMobil.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblMobil.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblMobil.getColumnModel().getColumn(4).setPreferredWidth(50);
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
    public void Simpan(String NoPolisi,int JenisMobil,String Merek,String Warna) throws SQLException{
        sql = "INSERT INTO mobil (NoPolisi,JenisMobil,Merek,Warna) VALUES ('"+NoPolisi+"',"+JenisMobil+",'"+Merek+"','"+Warna+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMobil = rs.getInt(1);
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
        sql = "INSERT INTO mobil (NoPolisi,JenisMobil,Merek,Warna) VALUES (?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoPolisi);
            PS.setInt(2, JenisMobil);
            PS.setString(3, Merek);
            PS.setString(4, Warna);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMobil = rs.getInt(1);
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
        sql = "SELECT KodeMobil,NoPolisi,JenisMobil,Merek,Warna FROM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeMobil = rs.getInt(1);
            NoPolisi = rs.getString(2);
            JenisMobil = rs.getInt(3);
            Merek = rs.getString(4);
            Warna = rs.getString(5);
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
        sql = "DELETE FROM mobil";
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
    public void Hapus(int KodeMobil) throws SQLException{
        sql = "DELETE FROM mobil WHERE KodeMobil="+KodeMobil;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
        }
    }
}
