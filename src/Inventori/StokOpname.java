/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.sql.*;
import java.util.*;
import Util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Yestin
 */
public class StokOpname {
    
    private int KodeSO;
    private String Barcode;
    private int KodeOutlet;
    private int KodeUser;
    private int KodeSatuan;
    private Calendar Tanggal;
    private Double StokSistem;
    private Double StokAktual;
    private Double StokOpname;
    private Double HargaModal;
    private Double Kerugian;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeSO(int KodeSO){
        this.KodeSO = KodeSO;
    }
    public int getKodeSO(){
        return KodeSO;
    }
    public int getKodeSO(int Kode){
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSO = rs.getInt(1);
                return KodeSO;
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
    public int getLastKodeSO(){
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO = (SELECT MAX(KodeSO) FROM stokopname)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSO = rs.getInt(1);
                return KodeSO;
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
    public int getLastKodeSO(String Barcode){
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO = (SELECT MAX(KodeSO) FROM stokopname WHERE Barcode='"+Barcode+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSO = rs.getInt(1);
                return KodeSO;
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
    public int getLastKodeSO(String Barcode,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO = (SELECT MAX(KodeSO) FROM stokopname WHERE Barcode='"+Barcode+"' AND "
                + "Tanggal='"+Tgl+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSO = rs.getInt(1);
                return KodeSO;
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
    public int getLastKodeSO(String Barcode,int KodeOutlet,int KodeUser,int KodeSatuan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO = (SELECT MAX(KodeSO) FROM stokopname WHERE Barcode='"+Barcode+"' AND "
                + "KodeOutlet="+KodeOutlet+" AND KodeUser="+KodeUser+" AND KodeSatuan="+KodeSatuan+" AND Tanggal='"+Tgl+"')";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSO = rs.getInt(1);
                return KodeSO;
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
    public String getBarcode(int KodeSO){
        sql = "SELECT Barcode FROM stokopname WHERE KodeSO="+KodeSO;
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
        sql = "SELECT Barcode FROM stokopname WHERE Barcode='"+KodeBarcode+"'";
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
    public void UpdateBarcode(int KodeSO,String Barcode) throws SQLException{
        sql = "UPDATE stokopname SET Barcode='"+Barcode+"' AND KodeSO="+KodeSO;
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
    public int getKodeOutlet(int KodeSO){
        sql = "SELECT KodeOutlet FROM stokopname WHERE KodeSO="+KodeSO;
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
        sql = "SELECT KodeOutlet FROM stokopname WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKodeOutlet(int KodeSO,int KodeOutlet) throws SQLException{
        sql = "UPDATE stokopname SET KodeOutlet="+KodeOutlet+" WHERE KodeSO="+KodeSO;
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
    public int getKodeUser(int KodeSO){
        sql = "SELECT KodeUser FROM stokopname WHERE KodeSO="+KodeSO;
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
    public void UpdateKodeUser(int KodeSO,int KodeUser) throws SQLException{
        sql = "UPDATE stokopname SET KodeUser="+KodeUser+" WHERE KodeSO="+KodeSO;
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
    public int getKodeSatuan(int KodeSO){
        sql = "SELECT KodeSatuan FROM stokopname WHERE KodeSO="+KodeSO;
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
    public void UpdateKodeSatuan(int KodeSO,int KodeSatuan) throws SQLException{
        sql = "UPDATE stokopname SET KodeStuan="+KodeSatuan+" WHERE KodeSO="+KodeSO;
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
    public Calendar getTanggal(int KodeSO){
        sql = "SELECT Tanggal FROM stokopname WHERE KodeSO="+KodeSO;
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
        sql = "SELECT Tanggal FROM stokopname WHERE Barcode='"+Barcode+"'";
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
    public void UpdateTanggal(int KodeSO,Calendar Tanggal) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "UPDATE stokopname SET Tanggal='"+Tgl+"' WHERE KodeSO="+KodeSO;
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
    public void setStokSistem(Double StokSistem){
        this.StokSistem = StokSistem;
    }
    public Double getStokSistem(){
        return StokSistem;
    }
    public Double getStokSistem(int KodeSO){
        sql = "SELECT KodeSO FROM stokopname WHERE KodeSO="+KodeSO;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokSistem = rs.getDouble(1);
                return StokSistem;
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
    public Double getStokSistem(String Barcode){
        sql = "SELECT KodeSO FROM stokopname WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokSistem = rs.getDouble(1);
                return StokSistem;
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
    public void UpdateStokSistem(int KodeSO,Double StokSistem) throws SQLException{
        sql = "UPDATE stokopname SET StokSistem="+StokSistem+" WHERE KodeSO="+KodeSO;
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
    public void TambahStokSistem(int KodeSO,Double StokSistem) throws SQLException{
        sql = "UPDATE stokopname SET StokSistem = StokSistem + "+StokSistem+" WHERE KodeSO="+KodeSO;
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
    public void KurangiStokSistem(int KodeSO,Double StokSistem) throws SQLException{
        sql = "UPDATE stokopname SET StokSistem = StokSistem - "+StokSistem+" WHERE KodeSO="+KodeSO;
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
    public void setStokAktual(Double StokAktual){
        this.StokAktual = StokAktual;
    }
    public Double getStokAktual(){
        return StokAktual;
    }
    public Double getStokAktual(int KodeSO){
        sql = "SELECT StokAktual FROM stokopname WHERE KodeSO="+KodeSO;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokAktual = rs.getDouble(1);
                return StokAktual;
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
    public Double getStokAktual(String Barcode){
        sql = "SELECT StokAktual FROM stokopname WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokAktual = rs.getDouble(1);
                return StokAktual;
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
    public void UpdateStokAktual(int KodeSO,Double StokAktual) throws SQLException{
        sql = "UPDATE stokopname SET StokAktual="+StokAktual+" WHERE KodeSO="+KodeSO;
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
    public void TambahStokAktual(int KodeSO,Double StokAktual) throws SQLException{
        sql = "UPDATE stokopname SET StokAktual = StokAktual + "+StokAktual+" WHERE KodeSO="+KodeSO;
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
    public void KurangiStokAktual(int KodeSO,Double StokAktual) throws SQLException{
        sql = "UPDATE stokopname SET StokAktual=StokAktual-"+StokAktual+" WHERE KodeSO="+KodeSO;
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
    public void setStokOpname(Double StokOpname){
        this.StokOpname = StokOpname;
    }
    public Double getStokOpname(){
        return StokOpname;
    }
    public Double getStokOpname(int KodeSO){
        sql = "SELECT StokOpname FROM stokopname WHERE KodeSO="+KodeSO;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokOpname = rs.getDouble(1);
                return StokOpname;
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
    public Double getStokOpname(String Barcode){
        sql = "SELECT StokOpname FROM stokopname WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokOpname = rs.getDouble(1);
                return StokOpname;
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
    public void UpdateStokOpname(int KodeSO,Double StokOpname) throws SQLException{
        sql = "UPDATE stokopanem SET Stokopname = "+StokOpname+" WHERE KodeSO="+KodeSO;
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
    public void TambahStokOpname(int KodeSO,Double StokOpname) throws SQLException{
        sql = "UPDATE stokopname SET StokOpname = StokOpname + "+StokOpname+" WHERE KodeSO="+KodeSO;
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
    public void KurangiStokOpname(int KodeSO,Double StokOpname) throws SQLException{
        sql = "UPDATE stokopname SET StokOpname = StokOpname - "+StokOpname+" WHERE KodeSO="+KodeSO;
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
    public Double getHargaModal(int KodeSO){
        sql = "SELECT HargaModal FROM stokopname WHERE KodeSO="+KodeSO;
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
        sql = "SELECT HargaModal FROM stokopname WHERE Barcode='"+Barcode+"'";
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
    public void UpdateHargaModal(int KodeSO,Double HargaModal) throws SQLException{
        sql = "UPDATE stokopname SET HargaModal="+HargaModal+" WHERE KodeSO="+KodeSO;
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
    
    public void setKerugian(Double Kerugian){
        this.Kerugian = Kerugian;
    }
    public Double getKerugian(){
        return Kerugian;
    }
    public Double getKerugian(int KodeSO){
        sql = "SELECT Kerugian FROM stokopname WHERE KodeSO="+KodeSO;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kerugian = rs.getDouble(1);
                return Kerugian;
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
    public Double getKerugian(String Barcode){
        sql = "SELECT Kerugian FROM stokopname WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kerugian = rs.getDouble(1);
                return Kerugian;
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
    public void UpdateKerugian(int KodeSO,Double Kerugian) throws SQLException{
        sql = "UPDATE stokopname SET Kerugian="+Kerugian+" WHERE KodeSO="+KodeSO;
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
    public void TambahKerugian(int KodeSO,Double Kerugian) throws SQLException{
        sql = "UPDATE stokopname SET Kerugian = Kerugian + "+Kerugian+" WHERE KodeSO="+KodeSO;
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
    public void KurangiKerugian(int KodeSO,Double Kerugian) throws SQLException{
        sql = "UPDDATE stokopname SET Kerugian = Kerugian - "+Kerugian+" WHERE KodeSO="+KodeSO;
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
    public void getStokOpname(JTable tblStokOpname){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date BeginDate = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date EndDate = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,int Bulan,int Tahun){
         sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)='"+Bulan+"' AND YEAR(Tanggal)='"+Tahun+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)='"+Bulan+"' AND YEAR(Tanggal)='"+Tahun+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)='"+Bulan+"' AND YEAR(Tanggal)='"+Tahun+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)='"+Bulan+"' AND YEAR(Tanggal)='"+Tahun+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)='"+Bulan+"' AND YEAR(Tanggal)='"+Tahun+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date BeginDate = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date EndDate = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,int Bulan,int Tahun){
          sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND o.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,int KodeOutlet,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND o.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,int KodeOutlet,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date BeginDate = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date EndDate = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND o.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND o.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,int KodeOutlet){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan) AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan) AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"' AND o.KodeOutler="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,int KodeOutlet,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal='"+Tgl+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"' AND o.KodeOutler="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,int KodeOutlet,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date BeginDate = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date EndDate = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND Tanggal BETWEEN '"+BeginDate+"' AND '"+EndDate+"') AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"' AND o.KodeOutler="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getStokOpname(JTable tblStokOpname,String Barcode,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,"
                + "(SELECT SUM(StokSistem) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokSistem,"
                + "(SELECT SUM(StokAktual) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokAktual,"
                + "(SELECT SUM(StokOpname) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS StokOpname,"
                + "(SELECT HargaModal FROM stokopname WHERE Barcode=i.Barcode AND KodeOutlet=o.KodeOutlet "
                + "AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS HargaModal,"
                + "(SELECT SUM(Kerugian) FROM stokopname WHERE Barcode=i.Barcode AND "
                + "KodeOutlet=o.KodeOutlet AND KodeSatuan=s.KodeSatuan AND MONTH(Tanggal)="+Bulan+" AND YEAR(Tanggal)="+Tahun+") AS Kerugian "
                + "FROM item i INNER JOIN outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) "
                + "WHERE (1=1) AND i.JenisItem=1 AND i.Barcode='"+Barcode+"' AND o.KodeOutler="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokOpname.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Outlet","Satuan","Stok Sistem","Stok Aktual","Stok Opname","Harga Modal","Kerugian"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblStokOpname.getModel();
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
                
                dtm.addRow(rowdata);
            }
            
            tblStokOpname.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblStokOpname.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(3).setPreferredWidth(80);
            tblStokOpname.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblStokOpname.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void Simpan(String Barcode,int KodeOutlet,int KodeUser,int KodeSatuan,Calendar Tanggal,Double StokSistem,Double StokAktual,Double StokOpname,
            Double HargaModal,Double Kerugian) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO stokopname (Barcode,KodeOutlet,KodeUser,KodeSatuan,Tanggal,StokSistem,StokAktual,StokOpname,HargaModal,Kerugian) "
                + "VALUES ('"+Barcode+"',"+KodeOutlet+","+KodeUser+","+KodeSatuan+",'"+Tgl+"',"+StokSistem+","+StokAktual+","+StokOpname+","+HargaModal+","
                + Kerugian+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSO = rs.getInt(1);
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
        sql = "INSERT INTO stokopname (Barcode,KodeOutlet,KodeSatuan,Tanggal,StokSistem,StokAktual,StokOpname,HargaModal,Kerugian) "
                + "VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, Barcode);
            PS.setInt(2, KodeOutlet);
            PS.setInt(3, KodeSatuan);
            PS.setDate(4, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setDouble(5, StokSistem);
            PS.setDouble(6, StokAktual);
            PS.setDouble(7, StokOpname);
            PS.setDouble(8, HargaModal);
            PS.setDouble(9, Kerugian);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSO = rs.getInt(1);
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
        sql = "SELECT Barcode,KodeOutlet,KodeSatuan,Tanggal,StokSistem,StokAktual,StokOpname,HargaModal,Kerugian FROM stokopname "
                + "WHERE KodeSO="+KodeSO;
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
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(4));
            StokSistem = rs.getDouble(5);
            StokAktual = rs.getDouble(6);
            StokOpname = rs.getDouble(7);
            HargaModal = rs.getDouble(8);
            Kerugian = rs.getDouble(9);
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
        sql = "DELETE FROM stokopname";
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
    public void Hapus(int KodeSO) throws SQLException{
        sql = "DELETE FROM stokopname WHERE KodeSO="+KodeSO;
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
        sql = "DELETE FROM stokopname WHERE Barcode='"+Barcode+"'";
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
