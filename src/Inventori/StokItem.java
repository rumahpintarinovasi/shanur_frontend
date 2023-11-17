/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class StokItem {
    
    private int KodeStok;
    private String Barcode;
    private int KodeOutlet;
    private int KodeSatuan;
    private Double Kuantitas;
    private Double Isi;
    private Double StokMax;
    private Double StokMin;
    private Double HargaModal;
    private Double HargaJual;
    private Double Diskon;
    
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
        sql = "SELECT KodeStok FROM stokitem WHERE KodeStok="+Kode;
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
    public int getKodeStok(String Barcode,int KodeOutlet,int KodeSatuan){
        sql = "SELECT KodeStok FROM stokitem WHERE Barcode='"+Barcode+"' AND KodeOutlet="+KodeOutlet+" AND KodeSatuan="+KodeSatuan;
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
        sql = "SELECT KodeStok FROM stokitem WHERE KodeStok = (SELECT MAX(KodeStok) FROM stokitem)";
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
    public int getLastKodeStok(String Barcode,int KodeOutlet,int KodeSatuan){
        sql = "SELECT KodeStok FROM stokitem WHERE KodeStok = (SELECT MAX(KodeStok) FROM stokitem WHERE Barcode='"+Barcode+"' AND "
                + "KodeOutlet="+KodeOutlet+" AND KodeSatuan="+KodeSatuan+")";
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
        sql = "SELECT Barcode FROM stokitem WHERE KodeStok="+KodeStok;
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
        sql = "UPDATE stokitem SET Barcode='"+Barcode+"' WHERE KodeStok="+KodeStok;
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
        sql = "UPDATE stokitem SET Barcode='"+Barcode+"' WHERE Barcode='"+KodeBarcode+"'";
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
        sql = "SELECT KodeOutlet FROM stokitem WHERE KodeStok="+KodeStok;
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
        sql = "UPDATE stokitem SET KodeOutlet="+KodeOutlet+" WHERE KodeStok="+KodeStok;
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
        sql = "SELECT KodeSatuan FROM stokitem WHERE KodeStok="+KodeStok;
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
        sql = "SELECT KodeSatuan FROM stokitem WHERE Barcode='"+Barcode+"'";
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
    public int getKodeSatuan(String Barcode,int KodeOutlet){
        sql = "SELECT KodeSatuan FROM stokitem WHERE Barcode='"+Barcode+"' AND KodeOutlet="+KodeOutlet;
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
        sql = "UPDATE stokitem SET KodeSatuan="+KodeSatuan+" WHERE KodeStok="+KodeStok;
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
    public void getSatuan(JComboBox cboSatuan,String Barcode){
        ResultSet rs;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            while(rs.next()){
                String Satuan = rs.getString(1);
                cbm.addElement(Satuan);
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
    public void getSatuan(JComboBox cboSatuan,String Barcode,int KodeOutlet){
        ResultSet rs;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) "
                + "AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            while(rs.next()){
                String Satuan = rs.getString(1);
                cbm.addElement(Satuan);
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
    public String getNamaSatuan(JComboBox cboSatuan,String Barcode,int KodeOutlet){
        ResultSet rs;
        sql = "SELECT s.NamaSatuan FROM satuan s INNER JOIN stokitem si ON (s.KodeSatuan=si.KodeSatuan) WHERE (1=1) "
                + "AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            while(rs.next()){
                String Satuan = rs.getString(1);
                cbm.addElement(Satuan);
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
        return null;
    }
    public void setKuantitas(Double Kuantitas){
        this.Kuantitas = Kuantitas;
    }
    public Double getKuantitas(){
        return Kuantitas;
    }
    public Double getKuantitas(int KodeStok){
        sql = "SELECT Kuantitas FROM stokitem WHERE KodeStok="+KodeStok;
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
    public void UpdateKuantitas(int KodeStok,Double Kuantitas) throws SQLException{
        sql = "UPDATE stokitem SET Kuantitas="+Kuantitas+" WHERE KodeStok="+KodeStok;
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
    public void TambahKuantitas(int KodeStok,Double Kuantitas) throws SQLException{
        sql = "UPDATE stokitem SET Kuantitas = Kuantitas + "+Kuantitas+" WHERE KodeStok="+KodeStok;
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
    public void KurangiKuantitas(int KodeStok,Double Kuantitas) throws SQLException{
        sql = "UPDATE stokitem SET Kuantitas = Kuantitas - "+Kuantitas+" WHERE KodeStok="+KodeStok;
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
    public void setIsi(Double Isi){
        this.Isi = Isi;
    }
    public Double getIsi(){
        return Isi;
    }
    public Double getIsi(int KodeStok){
        sql = "SELECT Isi FROM stokitem WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Isi = rs.getDouble(1);
                return Isi;
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
    public void UpdateIsi(int KodeStok,Double Isi) throws SQLException{
        sql = "UPDATE stokitem SET Isi="+Isi+" WHERE KodeStok="+KodeStok;
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
    public void setStokMax(Double StokMax){
        this.StokMax = StokMax;
    }
    public Double getStokMax(){
        return StokMax;
    }
    public Double getStokMax(int KodeStok){
        sql = "SELECT StokMax FROM stokitem WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMax = rs.getDouble(1);
                return StokMax;
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
    public void UpdateStokMax(int KodeStok,Double StokMax) throws SQLException{
        sql = "UPDATE stokitem SET StokMax="+StokMax+" WHERE KodeStok="+KodeStok;
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
    public void setStokMin(Double StokMin){
        this.StokMin = StokMin;
    }
    public Double getStokMin(){
        return StokMin;
    }
    public Double getStokMin(int KodeStok){
        sql = "SELECT StokMin FROM stokitem WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMin = rs.getDouble(1);
                return StokMin;
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
    public void UpdateStokMin(int KodeStok,Double StokMin) throws SQLException{
        sql = "UPDATE stokitem SET StokMin="+StokMin+" WHERE KodeStok="+KodeStok;
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
    public void setHargaModal(Double HargaModal){
        this.HargaModal = HargaModal;
    }
    public Double getHargaModal(){
        return HargaModal;
    }
    public Double getHargaModal(int KodeStok){
        sql = "SELECT HargaModal FROM stokitem WHERE KodeStok="+KodeStok;
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
        sql = "UPDATE stokitem SET HargaModal="+HargaModal+" WHERE KodeStok="+KodeStok;
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
    public void UpdateHargaModal(String Barcode,int KodeSatuan,Double HargaModal) throws SQLException{
        sql = "UPDATE stokitem SET HargaModal="+HargaModal+" WHERE KodeSatuan="+KodeSatuan+" AND Barcode='"+Barcode+"'";
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
        sql = "SELECT HargaJual FROM stokitem WHERE KodeStok="+KodeStok;
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
        sql = "UPDATE stokitem SET HargaJual="+HargaJual+" WHERE KodeStok="+KodeStok;
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
    public void UpdateHargaJual(String Barcode,int KodeSatuan,Double HargaJual) throws SQLException{
        sql = "UPDATE stokitem SET HargaJual="+HargaJual+" WHERE KodeSatuan="+KodeSatuan+" AND Barcode='"+Barcode+"'";
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
    public void setDiskon(Double Diskon){
        this.Diskon = Diskon;
    }
    public Double getDiskon(){
        return Diskon;
    }
    public Double getDiskon(int KodeStok){
        sql = "SELECT Diskon FROM stokitem WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Diskon = rs.getDouble(1);
                return Diskon;
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
    public void UpdateDiskon(int KodeStok,Double Diskon) throws SQLException{
        sql = "UPDATE stokitem SET Diskon="+Diskon+" WHERE KodeStok="+KodeStok;
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
    public void UpdateDiskon(String Barcode,int KodeSatuan,Double Diskon) throws SQLException{
        sql = "UPDATE stokitem SET Diskon="+Diskon+" WHERE Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan;
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
    public void getStokItem(JTable tblStokItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin,si.HargaModal,si.HargaJual,"
                + "si.Diskon FROM stokitem si INNER JOIN barang i INNER JOIN outlet o INNER JOIN satuan s ON (si.Barcode=i.Barcode AND "
                + "si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem(JTable tblStokItem, int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem1(JTable tblStokItem,String Barcode){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem1(JTable tblStokItem,String Barcode,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND "
                + "si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem2(JTable tblStokItem,String NamaItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND "
                + "i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem2(JTable tblStokItem,String NamaItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND "
                + "i.NamaItem LIKE '%"+NamaItem+"%' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem3(JTable tblStokItem,int JenisItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin,si.HargaModal,si.HargaJual FROM stokitem si INNER JOIN "
                + "barang i INNER JOIN outlet o INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND "
                + "si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem3(JTable tblStokItem,int JenisItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "i.JenisItem="+JenisItem+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem4(JTable tblStokItem,int KodeKategori){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem4(JTable tblStokItem,int KodeKategori,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "i.KodeKategori="+KodeKategori+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokItem5(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum(JTable tblStokItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN barang i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND si.KodeOutlet="+ KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum1(JTable tblStokItem,String Barcode){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum1(JTable tblStokItem,String Barcode,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas>=si.StokMax AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum2(JTable tblStokItem,String NamaItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas>=si.StokMax AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum2(JTable tblStokItem,String NamaItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND i.NamaItem LIKE '%"+NamaItem+"%' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum3(JTable tblStokItem,int JenisItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas>=si.StokMax AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum3(JTable tblStokItem,int JenisItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND i.JenisItem="+JenisItem+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum4(JTable tblStokItem,int KodeKategori){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas>=si.StokMax AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum4(JTable tblStokItem,int KodeKategori,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND i.KodeKategori="+KodeKategori+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMaximum5(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax) AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum(JTable tblStokItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum1(JTable tblStokItem,String Barcode){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin) AND si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum1(JTable tblStokItem,String Barcode,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin,si.HargaModal,si.HargaJual stokitem si INNER JOIN items i "
                + "INNER JOIN outlet o INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) "
                + "WHERE (1=1) AND (si.Kuantitas<=si.StokMin) AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum2(JTable tblStokItem,String NamaItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas<=si.StokMin AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum2(JTable tblStokItem,String NamaItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin) AND i.NamaItem LIKE '%"+NamaItem+"%' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum3(JTable tblStokItem,int JenisItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "si.Kuantitas<=si.StokMin AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum3(JTable tblStokItem,int JenisItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin) AND i.JenisItem="+JenisItem+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum4(JTable tblStokItem,int KodeKategori){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin) AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum4(JTable tblStokItem,int KodeKategori,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND s.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas<=si.StokMin) AND i.KodeKategori="+KodeKategori+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinimum5(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin,si.HargaModal,si.HargaJual,si.Diskon FROM stokitem si "
                + "INNER JOIN items i INNER JOIN outlet o INNER JOIN satuan s ON (si.Barcode=i.Barcode AND s.KodeOutlet=o.KodeOutlet AND "
                + "si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND (si.Kuantitas<=si.StokMin) AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax1(JTable tblStokItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax1(JTable tblStokItem,String Barcode){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax1(JTable tblStokItem,String Barcode,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax2(JTable tblStokItem,String NamaItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax2(JTable tblStokItem,String NamaItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND si.NamaItem LIKE '%"+NamaItem+"%' AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax3(JTable tblStokItem,int JenisItem){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax3(JTable tblStokItem,int JenisItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND i.JenisItem="+JenisItem+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax4(JTable tblStokItem,int KodeKategori){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin,si.HargaModal,si.HargaJual,si.Diskon FROM stokitem si "
                + "INNER JOIN items i INNER JOIN outlet o INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND "
                + "si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND (si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND "
                + "i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax4(JTable tblStokItem,int KodeKategori,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND i.KodeKategori="+KodeKategori+" AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getStokMinMax5(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT si.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem, "
                + "o.NamaOutlet,s.NamaSatuan,si.Kuantitas,si.Isi,si.StokMax,si.StokMin FROM stokitem si INNER JOIN items i INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (si.Barcode=i.Barcode AND si.KodeOutlet=o.KodeOutlet AND si.KodeSatuan=si.KodeSatuan) WHERE (1=1) AND "
                + "(si.Kuantitas>=si.StokMax OR si.Kuantitas<=si.StokMin) AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Outlet","Satuan","Kuantitas","Isi","Stok Max","Stok Min"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //JenisItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMax
                rowdata[8] = rs.getDouble(9); //StokMin
                
                dtm.addRow(rowdata);
            }
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80); //Barcode
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(200); //NamaItem
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(80); //JenisItem
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100); //Outlet
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60); //Satuan
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100); //Kuanttias
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50); //Isi
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(80); //StokMax
            tblStokItem.getColumnModel().getColumn(8).setPreferredWidth(80); //StokMin
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
    public void getHargaItem(JTable tblHargaItem){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem(JTable tblHargaItem,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem1(JTable tblHargaItem,String Barcode){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND si.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem2(JTable tblHargaItem,String Barcode,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND si.Barcode='"+Barcode+"' AND si.KodeOutlet="
                +KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem3(JTable tblHargaItem,String NamaItem){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem3(JTable tblHargaItem,String NamaItem,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%' AND "
                + "si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem4(JTable tblHargaItem,int KodeKategori){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void getHargaItem4(JTable tblHargaItem,int KodeKategori,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,s.NamaSatuan,si.HargaModal,si.HargaJual,si.Diskon FROM items i INNER JOIN stokitem si INNER JOIN "
                + "satuan s ON (i.Barcode=si.Barcode AND si.KodeSatuan=s.KodeSatuan) WHERE (1=1) AND i.KodeKategori="+KodeKategori+" AND "
                + "si.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblHargaItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Harga Modal","Harga Jual","Diskon(%)"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 6;
                }
            });
            
            Object rowdata[] = new Object[6];
            DefaultTableModel dtm = (DefaultTableModel)tblHargaItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                
                dtm.addRow(rowdata);
            }
            
            tblHargaItem.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblHargaItem.getColumnModel().getColumn(2).setPreferredWidth(70);
            tblHargaItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblHargaItem.getColumnModel().getColumn(5).setPreferredWidth(100);
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
    public void Simpan(String Barcode,int KodeOutlet,int KodeSatuan,Double Kuantitas,Double Isi,Double StokMax,Double StokMin,Double HargaModal,
                        Double HargaJual,Double Diskon) throws SQLException{
        sql = "INSERT INTO stokitem (Barcode,KodeOutlet,KodeSatuan,Kuantitas,Isi,StokMax,StokMin,HargaModal,HargaJual,Diskon) VALUES ('"
                +Barcode+"',"+KodeOutlet+","+KodeSatuan+","+Kuantitas+","+Isi+","+StokMax+","+StokMin+","+HargaModal+","+HargaJual+","+Diskon+")";
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
        sql = "INSERT INTO stokitem (Barcode,KodeOutlet,KodeSatuan,Kuantitas,Isi,StokMax,StokMin,HargaModal,HargaJual,Diskon) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, Barcode);
            PS.setInt(2, KodeOutlet);
            PS.setInt(3, KodeSatuan);
            PS.setDouble(4, Kuantitas);
            PS.setDouble(5, Isi);
            PS.setDouble(6, StokMax);
            PS.setDouble(7, StokMin);
            PS.setDouble(8, HargaModal);
            PS.setDouble(9, HargaJual);
            PS.setDouble(10, Diskon);
            
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
        sql = "SELECT Barcode,KodeOutlet,KodeSatuan,Kuantitas,Isi,StokMax,StokMin,HargaModal,HargaJual,Diskon FROM stokitem "
                + "WHERE KodeStok="+KodeStok;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            Barcode = rs.getString(1);
            KodeOutlet = rs.getInt(2);
            KodeSatuan = rs.getInt(3);
            Kuantitas = rs.getDouble(4);
            Isi = rs.getDouble(5);
            StokMax = rs.getDouble(6);
            StokMin = rs.getDouble(7);
            HargaModal = rs.getDouble(8);
            HargaJual = rs.getDouble(9);
            Diskon = rs.getDouble(10);
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
        sql = "DELETE FROM stokitem ";
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
    public void Hapus(int KodeStok) throws SQLException{
        sql = "DELETE FROM stokItem WHERE KodeStok="+KodeStok;
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
    public void Hapus(String Barcode) throws SQLException{
        sql = "DELETE FROM stokitem WHERE Barcode='"+Barcode+"'";
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
