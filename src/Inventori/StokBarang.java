/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class StokBarang {
    
    private int KodeStok;
    private String Barcode;
    private int KodeOutlet;
    private int KodeSatuan;
    private Calendar Tanggal;
    private Double StokMasuk;
    private Double StokKeluar;
    private Double SisaStok;
    private Double HargaModal;
    private Double TotalModal;
    private Double HargaJual;
    private Double TotalJual;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeStok(int KodeStok){
        this.KodeStok = KodeStok;
    }
    public int getKodeStok(){
        return KodeStok;
    }
    public int getKodeStok(int Kode){
        sql = "SELECT KodeStok FROM stokbarang WHERE KodeStok="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeStok = rs.getInt(1);
                return KodeStok;
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
    public int getLastKodeStok(){
        sql = "SELECT KodeStok FROM stokbarang WHERE KodeStok = (SELECT MAX(KodeStok) FROM stokbarang)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeStok = rs.getInt(1);
                return KodeStok;
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
    public int getLastKodeStok(String Barcode,int KodeOutlet,int KodeSatuan,Calendar Tanggal){
        java.sql.Date TglStok = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeStok FROM stokbarang WHERE KodeStok = (SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode='"+Barcode+"' AND "
                + "KodeOutlet="+KodeOutlet+" AND KodeSatuan="+KodeSatuan+" AND Tanggal='"+TglStok+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeStok = rs.getInt(1);
                return KodeStok;
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
    public void setBarcode(String Barcode){
        this.Barcode = Barcode;
    }
    public String getBarcode(){
        return Barcode;
    }
    public String getBarcode(int KodeStok){
        sql = "SELECT Barcode FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Barcode = rs.getString(1);
                return Barcode;
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
    public String Barcode(String KodeBarcode){
        sql = "SELECT Barcode FROM stokbarang WHERE Barcode='"+KodeBarcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Barcode = rs.getString(1);
                return Barcode;
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
    public void UpdateBarcode(int KodeStok,String Barcode) throws SQLException{
        sql = "UPDATE stokbarang SET Barcode='"+Barcode+"' WHERE KodeStok="+KodeStok;
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
    public void UpdateBarcode(String KodeBarcode,String Barcode) throws SQLException{
        sql = "UPDATE stokbarang SET Barcode='"+Barcode+"' WHERE Barcode='"+KodeBarcode+"'";
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
    public int getKodeOutlet(int KodeStok){
        sql = "SELECT KodeOutlet FROM stokbarang WHERE KodeStok="+KodeStok;
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
    public int getKodeOutlet(String Barcode){
        sql = "SELECT KodeOutlet FROM stokbarang WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKodeOutlet(int KodeStok,int KodeOutlet) throws SQLException{
        sql = "UPDATE stokbarang SET KodeOutlet="+KodeOutlet+" AND KodeStok="+KodeStok;
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
    public void setKodeSatuan(int KodeSatuan){
        this.KodeSatuan = KodeSatuan;
    }
    public int getKodeSatuan(){
        return KodeSatuan;
    }
    public int getKodeSatuan(int KodeStok){
        sql = "SELECT KodeSatuan FROM stokbarang WHERE KodeStok="+KodeStok;
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
    public int getKodeSatuan(String Barcode){
        sql = "SELECT KodeSatuan FROM stokbarang WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKodeSatuan(int KodeStok,int KodeSatuan) throws SQLException{
        sql = "UPDATE stokbarang SET KodeSatuan="+KodeSatuan+" WHERE KodeStok="+KodeStok;
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
    public Calendar getTanggal(int KodeStok){
        sql = "SELECT Tanggal FROM stokbarang WHERE KodeStok="+KodeStok;
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
    public Calendar getTanggal(String Barcode){
        sql = "SELECT Tanggal FROM stokbarang WHERE Barcode='"+Barcode+"'";
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
    public void UpdateTanggal(int KodeStok,Calendar Tanggal) throws SQLException{
        java.sql.Date TglStok = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "UDPATE stokbarang SET Tanggal='"+TglStok+"' WHERE KodeStok="+KodeStok;
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
    public void setStokMasuk(Double StokMasuk){
        this.StokMasuk = StokMasuk;
    }
    public Double getStokMasuk(){
        return StokMasuk;
    }
    public Double getStokMasuk(int KodeStok){
        sql = "SELECT StokMasuk FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMasuk = rs.getDouble(1);
                return StokMasuk;
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
    public Double getStokMasuk(String Barcode){
        sql = "SELECT StokMasuk FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMasuk = rs.getDouble(1);
                return StokMasuk;
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
    public void UpdateStokMasuk(int KodeStok,Double StokMasuk) throws SQLException{
        sql = "UPDATE stokbarang SET StokMasuk="+StokMasuk+" WHERE KodeStok="+KodeStok;
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
    public void TambahStokMasuk(int KodeStok,Double StokMasuk) throws SQLException{
        sql = "UPDATE stokbarang SET StokMasuk = StokMasuk + "+StokMasuk+" WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
            DBConnector.getConnection().commit();
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
    public void KurangiStokMasuk(int KodeStok,Double StokMasuk) throws SQLException{
        sql = "UPDTE stokbarang SET StokMasuk = StokMasuk - "+StokMasuk+" WHERE KodeStok="+KodeStok;
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
    public void setStokKeluar(Double StokKeluar){
        this.StokKeluar = StokKeluar;
    }
    public Double getStokKeluar(int KodeStok){
        sql = "SELECT StokKeluar FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokKeluar = rs.getDouble(1);
                return StokKeluar;
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
    public Double getStokKeluar(String Barcode){
        sql = "SELECT StokKeluar FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokKeluar = rs.getDouble(1);
                return StokKeluar;
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
    public void UpdateStokKeluar(int KodeStok,Double StokKeluar) throws SQLException{
        sql = "UPDATE stokbarang SET StokKeluar = "+StokKeluar+" WHERE KodeStok="+KodeStok;
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
    public void TambahStokKeluar(int KodeStok,Double StokKeluar) throws SQLException{
        sql = "UPDATE stokbarang SET StokKeluar = StokKeluar + "+StokKeluar+" WHERE KodeStok="+KodeStok;
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
    public void KurangiStokKeluar(int KodeStok,Double StokKeluar) throws SQLException{
        sql = "UPDATE stokbarang SET StokKeluar = StokKeluar - "+StokKeluar+" WHERE KodeStok="+KodeStok;
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
    public void setSisaStok(Double SisaStok){
        this.SisaStok = SisaStok;
    }
    public Double getSisaStok(){
        return SisaStok;
    }
    public Double getSisaStok(int KodeStok){
        sql = "SELECT SisaStok FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                SisaStok = rs.getDouble(1);
                return SisaStok;
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
    public Double getSisaStok(String Barcode){
        sql = "SELECT SisaStok FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                SisaStok = rs.getDouble(1);
                return SisaStok;
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
    public void UpdateSisaStok(int KodeStok,Double SisaStok) throws SQLException{
        sql = "UPDATE stokbarang SET SisaStok="+SisaStok+" WHERE KodeStok="+KodeStok;
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
    public void TambahSisaStok(int KodeStok,Double SisaStok) throws SQLException{
        sql = "UPDATE stokbarang SET SisaStok = SisaStok + "+SisaStok+" WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
            DBConnector.getConnection().commit();
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
    public void KurangiSisaStok(int KodeStok,Double SisaStok) throws SQLException{
        sql = "UPDATE stokbarang SET SisaStok = SisaStok - "+SisaStok+" WHERE KodeStok="+KodeStok;
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
    public void setHargaModal(Double HargaModal){
        this.HargaModal = HargaModal;
    }
    public Double getHargaModal(){
        return HargaModal;
    }
    public Double getHargaModal(int KodeStok){
        sql = "SELECT HargaModal FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                HargaModal = rs.getDouble(1);
                return HargaModal;
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
    public Double getHargaModal(String Barcode){
        sql = "SELECT HargaModal FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                HargaModal = rs.getDouble(1);
                return HargaModal;
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
    public void UpdateHargaModal(int KodeStok,Double HargaModal) throws SQLException{
        sql = "UPDATE stokbarang SET HargaModal="+HargaModal+" WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
            DBConnector.getConnection().commit();
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
    public void setTotalModal(Double TotalModal){
        this.TotalModal = TotalModal;
    }
    public Double getTotalModal(){
        return TotalModal;
    }
    public Double getTotalModal(int KodeStok){
        sql = "SELECT TotalModal FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalModal = rs.getDouble(1);
                return TotalModal;
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
    public Double getTotalModal(String Barcode){
        sql = "SELECT TotalModal FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalModal = rs.getDouble(1);
                return TotalModal;
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
    public void UpdateTotalModal(int KodeStok,Double TotalModal) throws SQLException{
        sql = "UPDATE stokbarang SET TotalModal="+TotalModal+" WHERE KodeStok="+KodeStok;
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
    public void TambahTotalModal(int KodeStok,Double TotalModal) throws SQLException{
        sql = "UPDATE stokbarang SET TotalModal = TotalModal + "+TotalModal+" WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement();
            int n = stmt.executeUpdate(sql);
            DBConnector.getConnection().commit();
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
    public void KurangiTotalModal(int KodeStok,Double TotalModal) throws SQLException{
        sql = "UPDATE stokbarang SET TotalModal = TotalModal - "+TotalModal+" WHERE KodeStok="+KodeStok;
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
    public void setHargaJual(Double HargaJual){
        this.HargaJual = HargaJual;
    }
    public Double getHargaJual(){
        return HargaJual;
    }
    public Double getHargaJual(int KodeStok){
        sql = "SELECT HargaJual FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                HargaJual = rs.getDouble(1);
                return HargaJual;
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
    public Double getHargaJual(String Barcode){
        sql = "SELECT HargaJual FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                HargaJual = rs.getDouble(1);
                return HargaJual;
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
    public void UpdateHargaJual(int KodeStok,Double HargaJual) throws SQLException{
        sql = "UPDATE stokbarang SET HargaJual="+HargaJual+" WHERE KodeStok="+KodeStok;
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
    public void setTotalJual(Double TotalJual){
        this.TotalJual = TotalJual;
    }
    public Double getTotalJual(){
        return TotalJual;
    }
    public Double getTotalJual(int KodeStok){
        sql = "SELECT TotalJual FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalJual = rs.getDouble(1);
                return TotalJual;
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
    public Double getTotalJual(String Barcode){
        sql = "SELECT TotalJual FROM stokbarang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalJual = rs.getDouble(1);
                return TotalJual;
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
    public void UpdateTotalJual(int KodeStok,Double TotalJual) throws SQLException{
        sql = "UPDATE stokbarang SET TotalJual="+TotalJual+" WHERE KodeStok="+KodeStok;
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
    public void TambahTotalJual(int KodeStok,Double TotalJual) throws SQLException{
        sql = "UPDATE stokbarang SET TotalJual = TotalJual + "+TotalJual+" WHERE KodeStok="+KodeStok;
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
    public void KurangiTotalJual(int KodeStok,Double TotalJual) throws SQLException{
        sql = "UPDATE stokbarang SET TotalJual = TotalJual - "+TotalJual+" WHERE KodeStok="+KodeStok;
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
    public void getStokBarang(JTable tblStokBarang){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokKeluar,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS SisaStok,"
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalJual "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang, String Barcode){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokKeluar,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS SisaStok,"
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalJual "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem=1 AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokKeluar,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS SisaStok,"
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalJual "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem=1 AND i.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang,String Barcode,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokKeluar,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS SisaStok,"
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan)) AS TotalJual "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem=1 AND i.Barcode='"+Barcode+"' AND i.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokKeluar,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) AS SisaStok,"
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"')) AS TotalJual "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"') AS StokMasuk,"
                + "(SELECT SUM(StokKeluar) FROM stokbarang WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND "
                + "Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"') AS StokKeluar,(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) "
                + "FROM stokbarang WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"')) AS SisaStok,(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang "
                + "WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) AS "
                + "HargaModal,(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"')) AS TotalJual "
                + "FROM items i INNER JOIN outlet o INNER JOIN satuan s INNER JOIN stokbarang sb ON (sb.KodeOutlet=o.KodeOutlet AND "
                + "sb.KodeSatuan=s.KodeSatuan AND i.Barcode=sb.Barcode) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void getStokBarang(JTable tblStokBarang,int Bulan,int Tahun){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokMasuk) FROM stokbarang WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND "
                + "MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokMasuk,(SELECT SUM(StokKeluar) FROM stokbarang WHERE "
                + "Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") "
                + "AS StokKeluar,(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE "
                + "Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) "
                + "AS SisaStok,(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) AS HargaModal,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) * "
                + "(SELECT HargaModal FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) AS TotalModal,"
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) AS HargaJual,"
                + "(SELECT SisaStok FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" ANDTan YEAR(Tanggal)="+Tahun+")) * "
                + "(SELECT HargaJual FROM stokbarang WHERE KodeStok=(SELECT MAX(KodeStok) FROM stokbarang WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+")) AS TotalJual "
                + "FROM items i INNER JOIN outlet o INNER JOIN satuan s INNER JOIN stokbarang sb ON (sb.KodeOutlet=o.KodeOutlet AND "
                + "sb.KodeSatuan=s.KodeSatuan AND i.Barcode=sb.Barcode) WHERE (1=1) AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Masuk","Stok Keluar","Sisa Stok","Harga Modal",
                                    "Total Modal","Harga Jual","Total Jual"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class};
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
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
    public void Simpan(String Barcode,int KodeOutlet,int KodeSatuan,Calendar Tanggal,Double StokMasuk,Double StokKeluar,Double SisaStok,
            Double HargaModal,Double TotalModal,Double HargaJual,Double TotalJual) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO stokbarang (Barcode,KodeOutlet,KodeSatuan,Tanggal,StokMasuk,StokKeluar,SisaStok,HargaModal,TotalModal,HargaJual,TotalJual) "
                + "VALUES ('"+Barcode+"',"+KodeOutlet+","+KodeSatuan+",'"+Tgl+"',"+StokMasuk+","+StokKeluar+","+SisaStok+","+HargaModal+","
                +TotalModal+","+HargaJual+","+TotalJual+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeStok = rs.getInt(1);
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
        sql = "INSERT INTO stokbarang (Barcode,KodeOutlet,KodeSatuan,Tanggal,StokMasuk,StokKeluar,SisaStok,HargaModal,TotalModal,HargaJual,TotalJual) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, Barcode);
            PS.setInt(2, KodeOutlet);
            PS.setInt(3, KodeSatuan);
            PS.setDate(4, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setDouble(5, StokMasuk);
            PS.setDouble(6, StokKeluar);
            PS.setDouble(7, SisaStok);
            PS.setDouble(8, HargaModal);
            PS.setDouble(9, TotalModal);
            PS.setDouble(10, HargaJual);
            PS.setDouble(11, TotalJual);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeStok = rs.getInt(1);
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
        sql = "SELECT KodeStok,Barcode,KodeOutlet,KodeSatuan,Tanggal,StokMasuk,StokKeluar,SisaStok,HargaModal,TotalModal,"
                + "HargaJual,TotalJual FROM stokbarang WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeStok = rs.getInt(1);
            Barcode = rs.getString(2);
            KodeOutlet = rs.getInt(3);
            KodeSatuan = rs.getInt(4);
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(5));
            StokMasuk = rs.getDouble(6);
            StokKeluar = rs.getDouble(7);
            SisaStok = rs.getDouble(8);
            HargaModal = rs.getDouble(9);
            TotalModal = rs.getDouble(10);
            HargaJual = rs.getDouble(11);
            TotalJual = rs.getDouble(12);
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
    public void Hapus(int KodeStok) throws SQLException{
        sql = "DELETE FROM stokbarang WHERE KodeStok="+KodeStok;
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
        sql = "DELETE FROM stokbarang WHERE KodeStok="+KodeStok;
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
