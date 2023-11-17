/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orderan;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Pesanan {
    
    private int NoPesanan;
    private Calendar Tanggal;
    private int KodeOutlet;
    private int KodeUser;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setNoPesanan(int NoPesanan){
        this.NoPesanan = NoPesanan;
    }
    public int getNoPesanan(){
        return NoPesanan;
    }
    public int getKodePesanan(int NmrPesanan){
        sql = "SELECT NoPesanan FROM pesanan WHERE NoPesanan="+NmrPesanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoPesanan = rs.getInt(1);
                return NoPesanan;
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
    public void setTanggal(Calendar Tanggal){
        this.Tanggal = Tanggal;
    }
    public Calendar getTanggal(){
        return Tanggal;
    }
    public Calendar getTanggal(int NoPesanan){
        sql = "SELECT Tanggal FROM pesanan WHERE NoPesanan="+NoPesanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Tanggal = Calendar.getInstance();
                Tanggal.setTime(rs.getDate(1));
                return Tanggal;
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
    public void UpdateTanggal(int NoPesanan,Calendar Tanggal) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "UPDATE pesanan SET Tanggal='"+Tgl+"' WHERE NoPesanan="+NoPesanan;
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
    public void setKodeOutlet(int KodeOutlet){
        this.KodeOutlet = KodeOutlet;
    }
    public int getKodeOutlet(){
        return KodeOutlet;
    }
    public int getKodeOutlet(int NoPesanan){
        sql = "SELECT KodeOutlet FROM pesanan WHERE NoPesanan="+NoPesanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeOutlet = rs.getInt(1);
                return KodeOutlet;
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
    public void UpdateKodeOutlet(int NoPesanan,int KodeOutlet) throws SQLException{
        sql = "UPDATE pesanan SET KodeOutlet="+KodeOutlet+" WHERE NoPesanan="+NoPesanan;
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
    public void setKodeUser(int KodeUser){
        this.KodeUser = KodeUser;
    }
    public int getKodeUser(){
        return KodeUser;
    }
    public int getKodeUser(int NoPesanan){
        sql = "SELECT KodeUser FROM pesanan WHERE NoPesanan="+NoPesanan;
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
    public void UpdateKodeUser(int NoPesanan,int KodeUser) throws SQLException{
        sql = "UPDATE pesanan SET KodeUser="+KodeUser+" WHERE NoPesanan="+NoPesanan;
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
    public void getPasanan(JTable tblPesanan){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan(JTable tblPesanan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan(JTable tblPesanan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan(JTable tblPesanan,int Bulan,int Tahun){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND MONTH(p.Tanggal)="
                + Bulan+" AND YEAR(p.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan2(JTable tblPesanan,int NoPesanan){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.NoPesanan="+NoPesanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan2(JTable tblPesanan,int NoPesanan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.NoPesanan="
                + NoPesanan+" AND p.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan2(JTable tblPesanan,int NoPesanan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.NoPesanan="
                + NoPesanan+" AND p.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPesanan2(JTable tblPesanan,int NoPesanan,int Bulan,int Tahun){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.NoPesanan="
                + NoPesanan+" AND MONTH(p.Tanggal)="+Bulan+" AND YEAR(p.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan3(JTable tblPesanan,int KodeOutlet){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeOutlet="
                + KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan3(JTable tblPesanan,int KodeOutlet,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeOutlet="
                + KodeOutlet+" AND p.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan3(JTable tblPesanan,int KodeOutlet,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeOutlet="
                + KodeOutlet+" AND p.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan3(JTable tblPesanan,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeOutlet="
                + KodeOutlet+" AND MONTH(p.Tanggal)="+Bulan+" AND YEAR(p.Tanggal)="+Bulan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan4(JTable tblPesanan,int KodeUser){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan4(JTable tblPesanan,int KodeUser,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeUser="
                + KodeUser+" AND p.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan4(JTable tblPesanan,int KodeUser,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeUser="
                + KodeUser+" AND p.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getPasanan4(JTable tblPesanan,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT p.NoPesanan,DATE_FORMAT(p.Tanggal,'%d-%m-%Y)'),o.NamaOutlet,i.NamaLengkap FROM pesanan p "
                + "INNER JOIN outlet o INNER JOIN identitas i INNER JOIN user u ON (o.KodeOutlet=p.KodeOutlet "
                + "AND p.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND p.KodeUser="
                + KodeUser+" AND MONTH(p.Tanggal)="+Bulan+" AND YEAR(p.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPesanan.setModel(new DefaultTableModel(){
                String ColName[] = {"No Pesanan","Tanggal","Outlet","User"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class};
                
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
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblPesanan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //NoPesanan
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //Outlet
                rowdata[4] = rs.getString(4); //User
            }
            
            tblPesanan.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblPesanan.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblPesanan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPesanan.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void Simpan(Calendar Tanggal,int KodeOutlet,int KodeUser) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO pesanan (Tanggal,KodeOutlet,KodeUser) VALUES ('"+Tgl+"',"+KodeOutlet+","+KodeUser+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            NoPesanan = rs.getInt(1);
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
        sql = "INSERT INTO pesanan (Tanggal,KodeOutlet,KodeUser) VALUES (?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setDate(1, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setInt(2, KodeOutlet);
            PS.setInt(3, KodeUser);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            NoPesanan = rs.getInt(1);
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
        sql = "SELECT NoPesanan,Tanggal,KodeOutlet,KodeUser FROM pesanan WHERE NoPesanan="+NoPesanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NoPesanan = rs.getInt(1);
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(2));
            KodeOutlet = rs.getInt(3);
            KodeUser = rs.getInt(4);
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
        sql = "DELETE FROM pesan";
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
    public void Hapus(int NoPesanan) throws SQLException{
        sql = "DELETE FROM pesan WHERE NoPesan="+NoPesanan;
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
