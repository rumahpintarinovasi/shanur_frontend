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
public class Akses {
    
    private int KodeAkses;
    private int KodeUser;
    private String NamaFitur;
    private int Akses;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeAkses(int KodeAkses){
        this.KodeAkses = KodeAkses;
    }
    public int getKodeAkses(){
        return KodeAkses;
    }
    public int getKodeAkses(int Kode){
        sql = "SELECT KodeAkses FROM akses WHERE KodeAkses="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeAkses = rs.getInt(1);
                return KodeAkses;
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
    public int getKodeAkses(int KodeUser,String NamaFitur){
        sql = "SELECT KodeAkses FROM akses WHERE KodeUser="+KodeUser+" AND NamaFitur='"+NamaFitur+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeAkses = rs.getInt(1);
                return KodeAkses;
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
    public void setKodeUser(int KodeUser){
        this.KodeUser = KodeUser;
    }
    public int getKodeUser(){
        return KodeUser;
    }
    public int getKodeUser(int KodeAkses){
        sql = "SELECT KodeUser FROM akses WHERE KodeAkses="+KodeAkses;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeUser = rs.getInt(1);
                return KodeUser;
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
    public void UpdateKodeUser(int KodeAkses,int KodeUser) throws SQLException{
        sql = "UPDATE akses SET KodeUser="+KodeUser+" WHERE KodeAkses="+KodeAkses;
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
    public void SetNamaFitur(String NamaFitur){
        this.NamaFitur = NamaFitur;
    }
    public String getNamaFitur(){
        return NamaFitur;
    }
    public String getNamaFitur(int KodeAkses){
        sql = "SELECT NamaFitur FROM akses WHERE KodeAkses="+KodeAkses;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaFitur = rs.getString(1);
                return NamaFitur;
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
    public String getFitureName(int KodeUser){
        sql = "SELECT NamaFitur FEOM akses WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaFitur = rs.getString(1);
                return NamaFitur;
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
    public void UpdateNamaFitur(int KodeAskes,String NamaFitur) throws SQLException{
        sql = "UPDATE akses SET NamaFitur='"+NamaFitur+"' WHERE KodeAkses="+KodeAskes;
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
    public void setAkses(int Akses){
        this.Akses = Akses;
    }
    public int getAkses(){
        return Akses;
    }
    public int getAkses(int KodeAkses){
        sql = "SELECT Akses FROM akses WHERE KodeAkses="+KodeAkses;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Akses = rs.getInt(1);
                return Akses;
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
    public void UpdateAkses(int KodeAkses,int Akses) throws SQLException{
        sql = "UPDATE akses SET Akses="+Akses+" WHERE KodeAkses="+KodeAkses;
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
    public void getAkses(JTable tblAkses){
        sql = "SELECT KodeAkses,NamaFitur,CASE WHEN (Akses=1) THEN 'Ya' WHEN (Akses=2) THEN 'Tidak' END FROM akses";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblAkses.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Akses","Nama Fitur","Akses"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblAkses.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                
                dtm.addRow(rowdata);
            }
            
            tblAkses.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblAkses.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAkses.getColumnModel().getColumn(2).setPreferredWidth(50);
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
    public void getAkses(JTable tblAkses,int KodeUser){
        sql = "SELECT KodeAkses,NamaFitur,CASE WHEN (Akses=1) THEN 'Ya' WHEN (Akses=2) THEN 'Tidak' END FROM akses WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblAkses.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Akses","Nama Fitur","Akses"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblAkses.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                dtm.addRow(rowdata); 
            }
            
            tblAkses.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblAkses.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblAkses.getColumnModel().getColumn(2).setPreferredWidth(50);
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
    public void Simpan(int KodeUser,String NamaFitur,int Akses) throws SQLException{
        sql = "INSERT INTO akses (KodeUser,NamaFitur,Akses) VALUES ("+KodeUser+",'"+NamaFitur+"',"+Akses+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeAkses = rs.getInt(1);
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
        sql = "INSERT INTO akses (KodeUser,NamaFitur,Akses) VALUES (?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeUser);
            PS.setString(2, NamaFitur);
            PS.setInt(3, Akses);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeAkses = rs.getInt(1);
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
        sql = "SELECT KodeAkses,KodeUser,NamaFitur,Akses FROM akses";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeAkses = rs.getInt(1);
            KodeUser = rs.getInt(2);
            NamaFitur = rs.getString(3);
            Akses = rs.getInt(4);
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
        sql = "DELETE FROM akses";
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
    public void Hapus(int KodeAkses) throws SQLException{
        sql = "DELETE FROM akses WHERE KodeAkses="+KodeAkses;
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
    public void HapusAkses(int KodeUser) throws SQLException{
        sql = "DELETE FROM akses WHERE KodeUser="+KodeUser;
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
