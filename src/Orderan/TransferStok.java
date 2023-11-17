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
public class TransferStok {
    
    private int KodeTF;
    private int KodeUser;
    private int KodePenerima;
    private Calendar Tanggal;
    private int KodeKerja;
    private int KodeMobil;
    private int OutletAsal;
    private int OutletTujuan;
    private int StatusDelivery;
    private Double Biaya;
    private String Keterangan;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeTF(int KodeTF){
        this.KodeTF = KodeTF;
    }
    public int getKodeTF(){
        return KodeTF;
    }
    public int getKodeTF(int Kode){
        sql = "SELECT KodeTF FROM transferstok WHERE KodeTF="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeTF = rs.getInt(1);
                return KodeTF;
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
    public int getKodeTF(int KodeUser,Calendar Tanggal,int KodeKerja,int KodeMobil,int OutletAsal,int OutletTujuan){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeTF FROM transferstok WHERE KodeUser="+KodeUser+" AND Tanggal='"+Tgl+"' AND KodeKerja="+KodeKerja+" "
                + "AND KodeMobil="+KodeMobil+" AND OutletAsal="+OutletAsal+" AND OutletTujuan="+OutletTujuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeTF = rs.getInt(1);
                return KodeTF;
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
    public int getLastKodeTF(int KodeUser,Calendar Tanggal,int KodeKerja,int KodeMobil,int OutletAsal,int OutletTujuan){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeTF FROM transferstok WHERE KodeTF = (SELECT MAX(KodeTF) FROM transferstok WHERE KodeUser="+KodeUser+" "
                + "AND Tanggal='"+Tgl+"' AND KodeKerja="+KodeKerja+" AND KodeMobil="+KodeMobil+" AND OutletAsal="+OutletAsal+" "
                + "AND OutletTujuan="+OutletTujuan+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeTF = rs.getInt(1);
                return KodeTF;
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
    public int getKodeUser(int KodeTF){
        sql = "SELECT KodeUser FROM transferstok WHERE KodeTF="+KodeTF;
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
    public void UpdateKodeUser(int KodeTF,int KodeUser) throws SQLException{
        sql = "UPDATE transferstok SET KodeUser="+KodeUser+" WHERE KodeTF="+KodeTF;
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
    public void setKodePeneriman(int KodePenerima){
        this.KodePenerima = KodePenerima;
    }
    public int getKodePenerima(){
        return KodePenerima;
    }
    public int getKodePenerima(int KodeTF){
        sql = "SELECT KodePenerima FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePenerima = rs.getInt(1);
                return KodePenerima;
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
    public void UpdateKodePenerima(int KodeTF,int KodePenerima) throws SQLException{
        sql = "UPDATE transferstok SET KodePenerima="+KodePenerima+" WHERE KodeTF="+KodeTF;
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
    public void setTanggal(Calendar Tanggal){
        this.Tanggal = Tanggal;
    }
    public Calendar getTanggal(){
        return Tanggal;
    }
    public Calendar getTanggal(int KodeTF){
        sql = "SELECT Tanggal FROM transferstok WHERE KodeTF="+KodeTF;
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
    public void UpdateTanggal(int KodeTF,Calendar Tanggal) throws SQLException{
        java.util.Date Tgl = new java.util.Date(Tanggal.getTimeInMillis());
        sql = "UPDATE transferstok SET Tanggal='"+Tgl+"' WHERE KodeTF="+KodeTF;
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
    public void setKodeKerja(int KodeKerja){
        this.KodeKerja = KodeKerja;
    }
    public int getKodeKerja(){
        return KodeKerja;
    }
    public int getKodeKerja(int KodeTF){
        sql = "SELECT KodeKerja FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKerja = rs.getInt(1);
                return KodeKerja;
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
    public void UpdateKodeKerja(int KodeTF,int KodeKerja) throws SQLException{
        sql = "UPDATE transferstok SET KodeKerja="+KodeKerja+" WHERE KodeTF="+KodeTF;
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
    public void setKodeMobil(int KodeMobil){
        this.KodeMobil = KodeMobil;
    }
    public int getKodeMobil(){
        return KodeMobil;
    }
    public int getKodeMobil(int KodeTF){
        sql = "SELECT KodeMobil FROM transferstok WHERE KodeTF="+KodeTF;
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
    public void UpdateKodeMobil(int KodeTF,int KodeMobil) throws SQLException{
        sql = "UPDATE transferstok SET KodeMobil="+KodeMobil+" WHERE KodeTF="+KodeTF;
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
    public void setOutletAsal(int OutletAsal){
        this.OutletAsal = OutletAsal;
    }
    public int getOutletAsal(){
        return OutletAsal;
    }
    public int getOutletAsal(int KodeTF){
        sql = "SELECT OutletAsal FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                OutletAsal = rs.getInt(1);
                return OutletAsal;
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
    public void UpdateOutletAsal(int KodeTF,int OutletAsal) throws SQLException{
        sql = "UPDATE transferstok SET OutletAsal="+OutletAsal+" WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
        } 
        catch (SQLException e) {
            DBConnector.getConnection().rollback();
            throw e;
        }
        if(stmt!=null){
            try {
                stmt.close();
            } 
            catch (Exception e) {
            }
        }
    }
    public void setOutletTujuan(int OutletTujuan){
        this.OutletTujuan = OutletTujuan;
    }
    public int getOutletTujuan(){
        return OutletTujuan;
    }
    public int getOutletTujuan(int KodeTF){
        sql = "SELECT OutletTujuan FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                OutletTujuan = rs.getInt(1);
                return OutletTujuan;
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
    public void UpdateOutletTujuan(int KodeTF,int OutletTujuan) throws SQLException{
        sql = "UPDATE transferstok SET OutletTujuan="+OutletTujuan+" WHERE KodeTF="+KodeTF;
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
    public void setStatusDelivery(int StatusDelivery){
        this.StatusDelivery = StatusDelivery;
    }
    public int getStatusDelivery(){
        return StatusDelivery;
    }
    public int getStatusDelivery(int KodeTF){
        sql = "SELECT StatusDelivery FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StatusDelivery = rs.getInt(1);
                return StatusDelivery;
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
    public void UpdateStatusDelivery(int KodeTF,int StatusDelivery) throws SQLException{
        sql = "UPDATE transferstok SET StatusDelivery="+StatusDelivery+" WHEE KodeTF="+KodeTF;
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
    public void setBiaya(Double Biaya){
        this.Biaya = Biaya;
    }
    public Double getBiaya(){
        return Biaya;
    }
    public Double getBiaya(int KodeTF){
        sql = "SELECT Biaya FROM transferstok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Biaya = rs.getDouble(1);
                return Biaya;
            }
            else{
                return 0.00;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return 0.00;
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
    public void UpdateBiaya(int KodeTF,Double Biaya) throws SQLException{
        sql = "UPDATE transferstok SET Biaya="+Biaya+" WHERE KodeTF="+KodeTF;
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
    public void setKeterangan(String Keterangan){
        this.Keterangan = Keterangan;
    }
    public String getKeterangan(){
        return Keterangan;
    }
    public String getKeterangan(int KodeTF){
        sql = "SELECT Keterangan FROM TransferStok WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Keterangan = rs.getString(1);
                return Keterangan;
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
    public void UpdateKeterangan(int KodeTF,String Keterangan) throws SQLException{
        sql = "UPDATE transferstok SET Keterangan='"+Keterangan+"' WHERE KodeTF="+KodeTF;
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
    
    public void getTransferStok(JTable tblTransferStok){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelivery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok(JTable tblTransferStok,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok(JTable tblTransferStok,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok(JTable tblTransferStok,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND MONTH (t.Tanggal)="+Bulan+"";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok1(JTable tblTransferStok,int KodePenerima){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodePenerima="+KodePenerima;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok1(JTable tblTransferStok,int KodePenerima,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodePenerima="+KodePenerima+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok1(JTable tblTransferStok,int KodePenerima,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelivery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodePenerima="+KodePenerima+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok1(JTable tblTransferStok,int KodePenerima,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelivery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodePenerima="+KodePenerima+" AND MONTH(T.Tanggal)="+Bulan+" AND "
                + "YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok2(JTable tblTransferStok,int KodeUser){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok2(JTable tblTransferStok,int KodeUser,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok2(JTable tblTransferStok,int KodeUser,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok2(JTable tblTransferStok,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND MONTH(t.Tanggal)="+Bulan+" AND YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok3(JTable tblTransferStok,int KodeDriver){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeKerja="+KodeDriver;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok3(JTable tblTransferStok,int KodeDriver,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeKerja="+KodeDriver+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok3(JTable tblTransferStok,int KodeDriver,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeKerja="+KodeDriver+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok3(JTable tblTransferStok,int KodeDriver,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeKerja="+KodeDriver+" AND MONTH(t.Tanggal)="+Bulan+" AND YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok4(JTable tblTransferStok,int StatusDelivery){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.StatusDelivery="+StatusDelivery;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok4(JTable tblTransferStok,int StatusDelivery,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok4(JTable tblTransferStok,int StatusDelivery,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok4(JTable tblTransferStok,int StatusDelivery,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.StatusDelivery="+StatusDelivery+" AND MONTH(t.Tanggal)="+Bulan+" AND "
                + "YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok5(JTable tblTransferStok,int KodeUser,int KodeDriver){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.KodeKerja="+KodeDriver;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok5(JTable tblTransferStok,int KodeUser,int KodeDriver,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelivery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.KodeKerja="+KodeDriver+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok5(JTable tblTransferStok,int KodeUser,int KodeDriver,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelyvery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.KodeKerja="+KodeDriver+" AND t.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim
                rowdata[2] = rs.getString(3); //Penerima
                rowdata[3] = rs.getString(3); //Tanggal
                rowdata[4] = rs.getString(4); //Driver
                rowdata[5] = rs.getString(5); //No Polisi
                rowdata[6] = rs.getString(6); //Outlet Asal
                rowdata[7] = rs.getString(7); //Outlet Tujuan
                rowdata[8] = rs.getString(8); //Status Delivery
                rowdata[9] = rs.getDouble(9); //Grand Total
                rowdata[10] = rs.getDouble(10); //Biaya
                rowdata[11] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok5(JTable tblTransferStok,int KodeUser,int KodeDriver,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap AS Pengirim,ip.NamaLengkap AS Penerima,DATE_FORMAT"
                + "(t.Tanggal,'%d-%m-%Y') AS Tanggal,d.NamaLengkap AS Driver,m.NoPolisi,oa.NamaOutlet,"
                + "ot.NamaOutlet,CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN "
                + "'Diterima' END AS StatusDelivery,(SELECT SUM(TotalModal) FROM rinciantransfer WHERE "
                + "KodeTF=t.KodeTF) AS TotalModal,t.Biaya,t.Keterangan FROM transferstok t INNER JOIN identitas "
                + "id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m INNER JOIN identitas ip INNER JOIN user up ON "
                + "(t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja AND "
                + "p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan "
                + "AND t.KodeMobil=m.KodeMobil AND ip.NoIdentitas=up.NoIdentitas AND t.KodePenerima=up.KodeUser) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.KodeKerja="+KodeDriver+" AND MONTH(t.Tanggal)="+Bulan
                + " AND YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","Pengirim","Penerima","Tanggal","Driver","No Polisi","Outlet Asal",
                                    "Outlet Tujuan","Status Delivery","Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,Double.class,Double.class,String.class};
                
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
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //Pengirim;
                rowdata[2] = rs.getString(3); //Penerima;
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //Driver
                rowdata[5] = rs.getString(6); //NoPolisi
                rowdata[6] = rs.getString(7); //Outlet Asal
                rowdata[7] = rs.getString(8); //Outlet Tujuan
                rowdata[8] = rs.getString(9); //Status Delivery
                rowdata[9] = rs.getDouble(10); //Grand Total;
                rowdata[10] = rs.getDouble(11); //Biaya
                rowdata[11] = rs.getString(12); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //Pengirim
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(100); //Penerima
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(80); //No Polisi
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(11).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok6(JTable tblTransferStok,int KodeUser,int StatusDelivery){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.StatusDelivery="+StatusDelivery;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok6(JTable tblTransferStok,int KodeUser,int StatusDelivery,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok6(JTable tblTransferStok,int KodeUser,int StatusDelivery,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok6(JTable tblTransferStok,int KodeUser,int StatusDelivery,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.StatusDelivery="+StatusDelivery+" AND MONTH(t.Tanggal)="+Bulan+" AND "
                + "YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok7(JTable tblTransferStok,int KodeDriver,int StatusDelivery){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok7(JTable tblTransferStok,int KodeDriver,int StatusDelivery,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok7(JTable tblTransferStok,int KodeDriver,int StatusDelivery,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND t.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok7(JTable tblTransferStok,int KodeDriver,int StatusDelivery,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND MONTH(t.Tanggal)="+Bulan+" AND "
                + "YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok8(JTable tblTransferStok,int KodeUser,int KodeDriver,int StatusDelivery){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok8(JTable tblTransferStok,int KodeUser,int KodeDriver,int StatusDelivery,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND p.KodeDriver="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND "
                + "t.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok8(JTable tblTransferStok,int KodeUser,int KodeDriver,int StatusDelivery,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND t.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND "
                + "t.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void getTransferStok8(JTable tblTransferStok,int KodeUser,int KodeDriver,int StatusDelivery,int Bulan,int Tahun){
        sql = "SELECT t.KodeTF,id.NamaLengkap,DATE_FORMAT(t.Tanggal,'%d-%m-%Y'),d.NamaLengkap,m.NoPolisi,oa.NamaOutlet,ot.NamaOutlet,"
                + "CASE WHEN (t.StatusDelivery=1) THEN 'Dikirim' WHEN (t.StatusDelivery=2) THEN 'Diterima' END,"
                + "(SELECT SUM(TotalModal) FROM rinciantransfer WHERE KodeTF=t.KodeTF),t.Biaya,t.Keterangan FROM "
                + "transferstok t INNER JOIN identitas id INNER JOIN user u INNER JOIN identitas d INNER JOIN pekerjaan p INNER JOIN outlet oa "
                + "INNER JOIN outlet ot INNER JOIN mobil m ON (t.KodeUser=u.KodeUser AND u.NoIdentitas=id.NoIdentitas AND t.KodeKerja=p.KodeKerja "
                + "AND p.NoIdentitas=d.NoIdentitas AND oa.KodeOutlet=t.OutletAsal AND ot.KodeOutlet=t.OutletTujuan AND t.KodeMobil=m.KodeMobil) "
                + "WHERE (1=1) AND t.KodeUser="+KodeUser+" AND p.KodeKerja="+KodeDriver+" AND t.StatusDelivery="+StatusDelivery+" AND "
                + "MONTH(t.Tanggal)="+Bulan+" AND YEAR(t.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblTransferStok.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode TF","User","Tanggal","Driver","No Polisi","Outlet Asal","Outlet Tujuan","Status Delivery",
                                    "Grand Total","Biaya","Keterangan"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    Double.class,Double.class,String.class};
                
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
                    return 11;
                }
            });
            
            Object rowdata[] = new Object[11];
            DefaultTableModel dtm = (DefaultTableModel)tblTransferStok.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeTF
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //Tanggal
                rowdata[3] = rs.getString(4); //Driver
                rowdata[4] = rs.getString(5); //No Polisi
                rowdata[5] = rs.getString(6); //Outlet Asal
                rowdata[6] = rs.getString(7); //Outlet Tujuan
                rowdata[7] = rs.getString(8); //Status Delivery
                rowdata[8] = rs.getDouble(9); //Grand Total
                rowdata[9] = rs.getDouble(10); //Biaya
                rowdata[10] = rs.getString(11); //Keterangan
                
                dtm.addRow(rowdata);
            }
            
            tblTransferStok.getColumnModel().getColumn(0).setPreferredWidth(50); //KodeTF
            tblTransferStok.getColumnModel().getColumn(1).setPreferredWidth(100); //User
            tblTransferStok.getColumnModel().getColumn(2).setPreferredWidth(80); //Tanggal
            tblTransferStok.getColumnModel().getColumn(3).setPreferredWidth(100);//Driver
            tblTransferStok.getColumnModel().getColumn(4).setPreferredWidth(50); //No Polisi
            tblTransferStok.getColumnModel().getColumn(5).setPreferredWidth(100);//Outlet Asal
            tblTransferStok.getColumnModel().getColumn(6).setPreferredWidth(100);//Outlet Tujuan
            tblTransferStok.getColumnModel().getColumn(7).setPreferredWidth(100);//Status Delivery
            tblTransferStok.getColumnModel().getColumn(8).setPreferredWidth(100);//Grand Total
            tblTransferStok.getColumnModel().getColumn(9).setPreferredWidth(70);//Biaya
            tblTransferStok.getColumnModel().getColumn(10).setPreferredWidth(100);//Keterangan
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
    public void Simpan(int KodeUser,int KodePenerima,Calendar Tanggal,int KodeKerja,int KodeMobil,int OutletAsal,int OutletTujuan,int StatusDelivery,
                        Double Biaya,String Keterangan) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO transferstok (KodeUser,KodePenerima,Tanggal,KodeKerja,KodeMobil,OutletAsal,OutletTujuan,StatusDelivery,Biaya,Keterangan) "
                + "VALUES ("+KodeUser+","+KodePenerima+",'"+Tgl+"',"+KodeKerja+","+KodeMobil+","+OutletAsal+","+OutletTujuan+","+StatusDelivery+","
                + Biaya+",'"+Keterangan+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeTF = rs.getInt(1);
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
        sql = "INSERT INTO transferstok (KodeUser,KodePeneima,Tanggal,KodeKerja,KodeMobil,OutletAsal,OutletTujuan,StatusDelivery,Biaya,Keterangan) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeUser);
            PS.setInt(2, KodePenerima);
            PS.setDate(3, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setInt(4, KodeKerja);
            PS.setInt(5, KodeMobil);
            PS.setInt(6, OutletAsal);
            PS.setInt(7, OutletTujuan);
            PS.setInt(8, StatusDelivery);
            PS.setDouble(9, Biaya);
            PS.setString(10, Keterangan);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeTF = rs.getInt(1);
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
        sql = "SELECT KodeTF,KodeUser,KodePenerima,Tanggal,KodeKerja,KodeMobil,OutletAsal,OutletTujuan,StatusDelivery,Biaya,Keterangan FROM transferstok "
                + "WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeTF = rs.getInt(1);
            KodeUser = rs.getInt(2);
            KodePenerima = rs.getInt(3);
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(4));
            KodeKerja = rs.getInt(5);
            KodeMobil = rs.getInt(6);
            OutletAsal = rs.getInt(7);
            OutletTujuan = rs.getInt(8);
            StatusDelivery = rs.getInt(9);
            Biaya = rs.getDouble(10);
            Keterangan = rs.getString(11);
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
    public void Hapus(int KodeTF) throws SQLException{
        sql = "DELETE FROM transferstok WHERE KodeTF="+KodeTF;
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
        sql = "DELETE FROM transferstok";
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
