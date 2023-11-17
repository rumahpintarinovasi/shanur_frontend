/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Fitur {
    
    private int KodeFitur;
    private String NamaFitur;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeFitur(int KodeFitur){
        this.KodeFitur = KodeFitur;
    }
    public int getKodeFitur(){
        return KodeFitur;
    }
    public int getKodeFitur(int Kode){
        sql = "SELECT KodeFitur FROM fitur WHERE KodeFitur="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeFitur = rs.getInt(1);
                return KodeFitur;
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
    public void setNamaFitur(String NamaFitur){
        this.NamaFitur = NamaFitur;
    }
    public String getNamaFitur(){
        return NamaFitur;
    }
    public String getNamaFitur(int KodeFitur){
        sql = "SELECT NamaFitur FROM fitur WHERE KodeFitur="+KodeFitur;
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
    public void UpdateNamaFitur(int KodeFitur,String NamaFitur) throws SQLException{
        sql = "UPDATE fitur SET NamaFitur='"+NamaFitur+"' WHERE KodeFitur="+KodeFitur;
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
    public void getFitur(JTable tblFitur){
        sql = "SELECT KodeFitur,NamaFitur FROM fitur";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblFitur.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Fitur","Nama Fitur"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblFitur.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblFitur.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblFitur.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void getFitur(JTable tblFitur,String NamaFitur){
        sql = "SELECT KodeFitur,NamaFitur FROM fitur WHERE NamaFitur LIKE '%"+NamaFitur+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblFitur.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Fitur","Nama Fitur"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblFitur.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblFitur.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblFitur.getColumnModel().getColumn(1).setPreferredWidth(100);
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
    public void Simpan(String NamaFitur) throws SQLException{
        sql = "INSERT INTO fitur (NamaFitur) VALUES ('"+NamaFitur+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeFitur = rs.getInt(1);
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
        sql = "INSERT INTO fitur (NamaFitur) VALUES(?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaFitur);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeFitur = rs.getInt(1);
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
        sql = "SELECT KodeFitur,NamaFitur FROM fitur WHERE KodeFitur="+KodeFitur;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            if(rs.next()==false){
                return;
            }
            KodeFitur = rs.getInt(1);
            NamaFitur = rs.getString(2);
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
        sql = "DELETE FROM fitur";
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
    public void Hapus(int KodeFitur) throws SQLException{
        sql = "DELETE FROM fitur WHERE KodeFitur="+KodeFitur;
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
