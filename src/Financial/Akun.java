/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

import Util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class Akun {
    
    private String NoAkun;
    private String NamaAkun;
    private int SN;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setNoAkun(String NoAkun){
        this.NoAkun = this.NoAkun;
    }
    public String getNoAkun(){
        return NoAkun;
    }
    public String getNoAkun(String NmrAkun){
        sql = "SELECT NoAkun FROM akun WHERE NoAkun='"+NmrAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoAkun = rs.getString(1);
                return NoAkun;
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
    public void UpdateNoAkun(String NoAkun,String NmrAkun) throws SQLException{
        sql = "UPDATE akun SET NoAkun='"+NmrAkun+"' WHERE NoAkun='"+NoAkun+"'";
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
    public void setNamaAkun(String NamaAkun){
        this.NamaAkun = NamaAkun;
    }
    public String getNamaAkun(){
        return NamaAkun;
    }
    public String getNamaAkun(String NoAkun){
        sql = "SELECT NamaAkun FROM akun WHERE NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaAkun = rs.getString(1);
                return NamaAkun;
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
    public void UpdateNamaAkun(String NoAkun,String NamaAkun) throws SQLException{
        sql = "UPDATE akun SET NamaAkun='"+NamaAkun+"' WHERE NoAkun='"+NoAkun+"'";
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
    public void setSN(int SN){
        this.SN = SN;
    }
    public int getSN(){
        return SN;
    }
    public int getSN(String NoAkun){
        sql = "SELECT SN FROM akun WHERE NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                SN = rs.getInt(1);
                return SN;
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
    public void UpdateSN(String NoAkun,int SN) throws SQLException{
        sql = "UPDATE akun SET SN="+SN+" WHERE NoAkun='"+NoAkun+"'";
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
    public void getAkun(JTable tblAkun){
        sql = "SELECT NoAkun,NamaAkun,CASE WHEN (SN=1) THEN 'Debet' WHEN (SN=2) THEN 'Kredit' END AS SN FROM akun";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblAkun.setModel(new DefaultTableModel(){
                String ColName[] = {"No Akun","Nama Akun"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblAkun.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //NoAkun
                rowdata[1] = rs.getString(2); //NamaAkun
                
                dtm.addRow(rowdata);
            }
            
            tblAkun.getColumnModel().getColumn(0).setPreferredWidth(50); //NoAkun
            tblAkun.getColumnModel().getColumn(1).setPreferredWidth(100); //NamaAkun
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
    public void getAkun1(JTable tblAkun,String NoAkun){
        sql = "SELECT NoAkun,NamaAkun,CASE WHEN (SN=1) THEN 'Debet' WHEN (SN=2) THEN 'Kredit' END AS SN FROM akun WHERE "
                + "NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblAkun.setModel(new DefaultTableModel(){
                String ColName[] = {"No Akun","Nama Akun","SN"};
                Class ColType[] = {String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblAkun.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //NoAkun
                rowdata[1] = rs.getString(2); //NamaAkun
                rowdata[2] = rs.getString(3); //SN
                
                dtm.addRow(rowdata);
            }
            
            tblAkun.getColumnModel().getColumn(0).setPreferredWidth(50); //NoAkun
            tblAkun.getColumnModel().getColumn(1).setPreferredWidth(100); //NamaAkun
            tblAkun.getColumnModel().getColumn(2).setPreferredWidth(50); //SN
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
    public void getAkun2(JTable tblAkun,String NamaAkun){
        sql = "SELECT NoAkun,NamaAkun,CASE WHEN (SN=1) THEN 'Debet' WHEN (SN=2) THEN 'Kredit' END AS SN FROM akun WHERE NamaAkun "
                + "LIKE '%"+NamaAkun+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblAkun.setModel(new DefaultTableModel(){
                String ColName[] = {"No Akun","Nama Akun","SN"};
                Class ColType[] = {String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblAkun.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //NoAkun
                rowdata[1] = rs.getString(2); //NamaAkun
                rowdata[2] = rs.getString(3); //SN
                
                dtm.addRow(rowdata);
            }
            
            tblAkun.getColumnModel().getColumn(0).setPreferredWidth(50); //NoAkun
            tblAkun.getColumnModel().getColumn(1).setPreferredWidth(100); //NamaAkun
            tblAkun.getColumnModel().getColumn(2).setPreferredWidth(50); //SN
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
    public void Simpan(String NoAkun,String NamaAkun,int SN) throws SQLException{
        sql = "INSERT INTO akun (NoAkun,NamaAkun,SN) VALUES ('"+NoAkun+"','"+NamaAkun+"',"+SN+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            
            int n = PS.executeUpdate();
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
        sql = "INSERT INTO Akun (NoAkun,NamaAkun,SN) VALUES (?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            PS.setString(1, NoAkun);
            PS.setString(2, NamaAkun);
            PS.setInt(3, SN);
            
            int n = PS.executeUpdate();
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
        sql = "SELECT NoAkun,NamaAkun,SN FROM akun WHERE NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NoAkun = rs.getString(1);
            NamaAkun = rs.getString(2);
            SN = rs.getInt(3);
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
        sql = "DELETE FROM akun";
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
    public void Hapus(int NoAkun) throws SQLException{
        sql = "DELETE FROM akun WHERE NoAkun='"+NoAkun+"'";
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
