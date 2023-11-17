/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import java.util.*;
import Util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class LabaItem {
    
    private int KodeLB;
    private int NoNota;
    private Calendar Tanggal;
    private int KodeOutlet;
    private String Barcode;
    private int KodeJenis;
    private int KodeSatuan;
    private Double Kuantitas;
    private Double HargaModal;
    private Double TotalModal;
    private Double HargaJual;
    private Double TotalJual;
    private Double TotalDiskon;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeLB(int KodeLB){
        this.KodeLB = KodeLB;
    }
    public int getKodeLB(){
        return KodeLB;
    }
    public int getKodeLB(int Kode){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLB(){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaitem)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLB(Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaitem WHERE Tanggal='"+Tgl+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLB(String Barcode){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaitem WHERE Barcode='"+Barcode+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLB(int KodeOutlet){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaitem WHERE KodeOutlet="+KodeOutlet+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLaba(int KodeSatuan){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaitem WHERE KodeSatuan="+KodeSatuan+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastProfit(int KodeJenis){
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB=(SELECT MAX(KodeLB) FROM labaitem WHERE KodeJenis="+KodeJenis+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public int getLastKodeLB(Calendar Tanggal,int KodeOutlet,String Barcode,int KodeJenis,int KodeSatuan){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeLB FROM labaitem WHERE KodeLB=(SELECT MAX(KodeLB) FROM labaitem WHERE Tanggal="+Tgl+" AND KodeOutlet="+KodeOutlet+" "
                + "AND Barcode='"+Barcode+"' AND KodeJenis="+KodeJenis+" AND KodeSatuan="+KodeSatuan+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeLB = rs.getInt(1);
                return KodeLB;
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
    public void setNoNota(int NoNota){
        this.NoNota = NoNota;
    }
    public int getNoNota(){
        return NoNota;
    }
    public int getNoNota(int KodeLB){
        sql = "SELECT NoNota FROM labaitem WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoNota = rs.getInt(1);
                return NoNota;
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
    public void UpdateNoNota(int KodeLB,int NoNota) throws SQLException{
        sql = "UPDATE NoNota FROM labaitem WHERE NoNota="+NoNota;
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
    public Calendar getTanggal(int KodeLB){
        sql = "SELECT Tanggal FROM labaitem WHERE KodeLB="+KodeLB;
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
    }
    public void UpdateTanggal(int KodeLB,Calendar Tanggal) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "UPDATE labaitem SET Tanggal='"+Tgl+"' WHERE KodeLB="+KodeLB;
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
    public int getKodeOutlet(int KodeLB){
        sql = "SELECT KodeOutlet FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateKodeOutlet(int KodeLB,int KodeOutlet) throws SQLException{
        sql = "UPDATE labaitem SET KodeOutlet="+KodeOutlet+" WHERE KodeLB="+KodeLB;
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
    public void setBarcode(String Barcode){
        this.Barcode = Barcode;
    }
    public String getBarcode(){
        return Barcode;
    }
    public String getBarcode(int KodeLB){
        sql = "SELECT Barcode FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateBarcode(int KodeLB,String Barcode) throws SQLException{
        sql = "UPDATE labaitem SET Barcode='"+Barcode+"' WHERE KodeLB="+KodeLB;
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
    public void setKodeJenis(int KodeJenis){
        this.KodeJenis = KodeJenis;
    }
    public int getKodeJenis(){
        return KodeJenis;
    }
    public int getKodeJenis(int KodeLB){
        sql = "SELECT KodeJenis FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateKodeJenis(int KodeLB,int KodeJenis) throws SQLException{
        sql = "UPDATE labaitem SET KodeJenis="+KodeJenis+" WHERE KodeLB="+KodeLB;
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
    public int getKodeSatuan(int KodeLB){
        sql = "SELECT KodeSatuan FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateKodeSatuan(int KodeLB,int KodeSatuan) throws SQLException{
        sql = "UPDATE labaitem SET KodeSatuan="+KodeSatuan+" WHERE KodeLB="+KodeLB;
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
    public void setKuantitas(Double Kuantitas){
        this.Kuantitas = Kuantitas;
    }
    public Double getKuantitas(){
        return Kuantitas;
    }
    public Double getKuantitas(int KodeLB){
        sql = "SELECT Kuantitas FROM labaitem WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kuantitas = rs.getDouble(1);
                return Kuantitas;
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
    public void UpdateKuantitas(int KodeLB,Double Kuantitas) throws SQLException{
        sql = "UDPATE labaitem SET Kuantitas="+Kuantitas+" WHERE KodeLB="+KodeLB;
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
    public void TambahKuantitas(int KodeLB,Double Kuantitas) throws SQLException{
        sql = "UPDATE labaitem SET Kuantitas = Kuantitas + "+Kuantitas+" WHERE KodeLB="+KodeLB;
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
    public void KurangiKuantitas(int KodeLB,Double Kuantitas) throws SQLException{
        sql = "UPDATE labaitem SET Kuantitas = Kuantitas - "+Kuantitas+" WHERE KodeLB="+KodeLB;
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
    public Double getHargaModal(int KodeLB){
        sql = "SELECT HargaModal FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateHargaModal(int KodeLB,Double HargaModal) throws SQLException{
        sql = "UPDATE labaitem SET HargaModal="+HargaModal+" WHERE KodeLB="+KodeLB;
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
    public void setTotalModal(Double TotalModal){
        this.TotalModal = TotalModal;
    }
    public Double getTotalModal(){
        return TotalModal;
    }
    public Double getTotalModal(int KodeLB){
        sql = "SELECT TotalModal FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateTotalModal(int KodeLB,Double TotalModal) throws SQLException{
        sql = "UPDATE labaitem SET TotalModal="+TotalModal+" WHERE KodeLB="+KodeLB;
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
    public void TambahTotalModal(int KodeLB,Double TotalModal) throws SQLException{
        sql = "UPDATE labaitem SET TotalModal = TotalModal + "+TotalModal+" WHERE KodeLB="+KodeLB;
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
    public void KurangiTotalModal(int KodeLB,Double TotalModal) throws SQLException{
        sql = "UPDATE labaitem SET TotalModal = TotalModal - "+TotalModal+" WHERE KodeLB="+KodeLB;
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
    public Double getHargaJual(int KodeLB){
        sql = "SELECT HargaJual FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateHargaJual(int KodeLB,Double HargaJual) throws SQLException{
        sql = "UPDATE labaitem SET HargaJual="+HargaJual+" WHERE KodeLB="+KodeLB;
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
    public Double getTotalJual(int KodeLB){
        sql = "SELECT TotalJual FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void UpdateTotalJual(int KodeLB,Double TotalJual) throws SQLException{
        sql = "UPDATE labaitem SET TotalJual="+TotalJual+" WHERE KodeLB="+KodeLB;
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
    public void TambahTotalJual(int KodeLB,Double TotalJual) throws SQLException{
        sql = "UPDATE labaitem SET TotalJual = TotalJual + "+TotalJual+" WHERE KodeLB="+KodeLB;
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
    public void KurangiTotalJual(int KodeLB,Double TotalJual) throws SQLException{
        sql = "UPDATE labaitem SET TotalJual = TotalJual - "+TotalJual+" WHERE KodeLB="+KodeLB;
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
    public void setTotalDiskon(Double TotalDiskon){
        this.TotalDiskon = TotalDiskon;
    }
    public Double getTotalDiskon(){
        return TotalDiskon;
    }
    public Double getTotalDiskon(int KodeLB){
        sql = "SELECT TotalDiskon FROM labaitem WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalDiskon = rs.getDouble(1);
                return TotalDiskon;
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
    public void UpdateTotalDiskon(int KodeLB,Double TotalDiskon) throws SQLException{
        sql = "UPDATE labaitem SET TotalDiskon="+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
    public void TambahTotalDiskon(int KodeLB,Double TotalDiskon) throws SQLException{
        sql = "UPDATE labaitem SET TotalDiskon = TotalDiskon + "+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
    public void KurangiTotalDiskon(int KodeLB,Double TotalDiskon) throws SQLException{
        sql = "UPDATE labaitem SET TotalDiskon = TotalDiskon - "+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
    public void getLabaItem(JTable tblLaba){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,String Barcode){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,String NamaItem){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,int KodeOutlet){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,int KodeOutlet,String Barcode){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.Barcode='"+Barcode+"' AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,int KodeOutlet,String NamaItem){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%' AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getProfitItem(JTable tblLaba,int KodeJenis,String Barcode){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.Barcode='"+Barcode+"' AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getProfitItems(JTable tblLaba,int KodeJenis,String NamaJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.NamaJenis LIKE '%"+NamaJenis+"%' AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,String Barcode,int KodeOutlet,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.Barcode='"+Barcode+"' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,String NamaItem,int KodeOutlet,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal,int KodeOutlet){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,Calendar Tanggal,int KodeJenis){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal,String Barcode){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,Calendar Tanggal,String NamaItem){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal,int KodeOutlet,String Barcode){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,Calendar Tanggal,int KodeOutlet,String NamaItem){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getProfitItem(JTable tblLaba,Calendar Tanggal,int KodeJenis,String Barcode){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeJenis="+KodeJenis+" AND Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getProfitItems(JTable tblLaba,Calendar Tanggal,int KodeJenis,String NamaItem){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItem(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis,String Barcode){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaItems(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis,String NamaItem){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.Kuantitas,l.HargaModal,l.TotalModal,"
                + "l.HargaJual,l.TotalJual,(l.TotalJual - l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i "
                + "INNER JOIN jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) "
                + "WHERE (1=1) AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND "
                + "i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Harga Modal","Total Modal","Harga Jual",
                                    "Total Penjualan","Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Double.class};
                
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
                    return 13;
                }
            });
            
            Object rowdata[] = new Object[13];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getDouble(12);
                rowdata[12] = rs.getDouble(13);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(70);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(12).setPreferredWidth(100);
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
    public void getLabaPerItem(JTable tblLaba){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void LabaPerItem(JTable tblLaba,int KodeOutlet){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItems(JTable tblLaba,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItem(JTable tblLaba,int Barcode){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItems(JTable tblLaba,String NamaItem){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void LabaPerItem(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void LabaPerItem(JTable tblLaba,int KodeOutlet,int KodeJenis,String Barcode){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItems(JTable tblLaba,int KodeOutlet,int KodeJenis,String NamaItem){
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerIem(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItem(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis,String Barcode){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.Tanggal='"+Tgl+"' AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getLabaPerItems(JTable tblLaba,Calendar Tanggal,int KodeOutlet,int KodeJenis,String NamaItem){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT DATE_FORMAT(l.Tanggal,'%d-%m-%Y'),o.NamaOutlet,i.Barcode,i.NamaItem,j.NamaJenis,s.NamaSatuan,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon FROM labaitem l INNER JOIN outlet o INNER JOIN items i INNER JOIN "
                + "jenispembayaran j INNER JOIN satuan s "
                + "ON (o.KodeOutlet=l.KodeOutlet AND i.Barcode=l.Barcode AND j.KodeJenis=l.KodeJenis AND s.KodeSatuan=l.KodeSatuan) WHERE (1=1) "
                + "AND l.Tanggal='"+Tgl+"' l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Barcode","Nama Item","Jenis Pembayaran","Satuan","Kuantitas","Total Modal","Total Penjualan",
                                    "Laba","Total Diskon"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void Simpan(Calendar Tanggal,int NoNota,int KodeOutlet,String Barcode,int KodeJenis,int KodeSatuan,Double Kuantitas,Double HargaModal,
            Double TotalModal,Double HargaJual,Double TotalJual,Double TotalDiskon) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO labaitem (Tanggal,NoNota,KodeOutlet,Barcode,KodeJenis,KodeSatuan,Kuantitas,HargaModal,TotalModal,HargaJual,TotalJual,"
                + "TotalDiskon) VALUES ('"+Tgl+"',"+NoNota+","+KodeOutlet+",'"+Barcode+"',"+KodeJenis+","+KodeSatuan+","+Kuantitas+","+HargaModal
                +","+ TotalModal+","+HargaJual+","+TotalJual+","+TotalDiskon+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeLB = rs.getInt(1);
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
        sql = "INSERT INTO labaitem (Tanggal,NoNota,KodeOutlet,Barcode,KodeJenis,KodeSatuan,Kuantitas,HargaModal,TotalModal,HargaJual,TotalJual,"
                + "TotalDiskon) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setDate(1, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setInt(2, NoNota);
            PS.setInt(3, KodeOutlet);
            PS.setString(4, Barcode);
            PS.setInt(5, KodeJenis);
            PS.setInt(6, KodeSatuan);
            PS.setDouble(7, Kuantitas);
            PS.setDouble(8, HargaModal);
            PS.setDouble(9, TotalModal);
            PS.setDouble(10, HargaJual);
            PS.setDouble(11, TotalJual);
            PS.setDouble(12, TotalDiskon);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeLB = rs.getInt(1);
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
        sql = "SELECT Tanggal,NoNota,KodeOutlet,Barcode,KodeJenis,KodeSatuan,Kuantitas,HargaModal,TotalModal,HargaJual,TotalJual,"
                + "TotalDiskon FROM labaitem WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(1));
            NoNota = rs.getInt(2);
            KodeOutlet = rs.getInt(3);
            Barcode = rs.getString(4);
            KodeJenis = rs.getInt(5);
            KodeSatuan = rs.getInt(6);
            Kuantitas = rs.getDouble(7);
            HargaModal = rs.getDouble(8);
            TotalModal = rs.getDouble(9);
            HargaJual = rs.getDouble(10);
            TotalJual = rs.getDouble(11);
            TotalDiskon = rs.getDouble(12);
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
        sql = "DELETE FROM labaitem";
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
    public void Hapus(int KodeLB) throws SQLException{
        sql = "DELETE FROM labaitem WHERE KodeLB="+KodeLB;
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
    public void Hapus(Calendar Tanggal,int KodeOutlet,String Barcode,int KodeJenis,int KodeSatuan) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "DELETE FROM labaitem WHERE Tanggal='"+Tgl+"' AND KodeOutlet="+KodeOutlet+" AND Barcode='"+Barcode+"' AND "
                + "KodeJenis="+KodeJenis+" AND KodeSatuan="+KodeSatuan;
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
