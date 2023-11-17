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
public class RincianPesanan {
    
    private int KodeRincian;
    private int NoPesanan;
    private String Barcode;
    private int KodeSatuan;
    private Double Kuantitas;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeRincian(int KodeRincian){
        this.KodeRincian = KodeRincian;
    }
    public int getKodeRincian(){
        return KodeRincian;
    }
    public int getKodeRincian(int Kode){
        sql = "SELECT KodeRincian FROM rincianpesanan WHERE KodeRincian="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeRincian = rs.getInt(1);
                return KodeRincian;
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
    public int getKodeRincian(int NoPesanan,String Barcode,int KodeSatuan){
        sql = "SELECT KodeRincian FROM rincianpesanan WHERE NoPesanan="+NoPesanan+" AND Barcode='"+Barcode+"' "
                + "AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeRincian = rs.getInt(1);
                return KodeRincian;
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
    public int getLastKodeRincian(int NoPesanan,String Barcode,int KodeSatuan){
        sql = "SELECT KodeRincian FROM rincianpesanan WHERE KodeRincian = (SELECT MAX(KodeRincian) FROM rinciantransaksi "
                + "WHERE NoPesanan="+NoPesanan+" AND Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeRincian = rs.getInt(1);
                return KodeRincian;
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
    public void setNoPesanan(int NoPesanan){
        this.NoPesanan = NoPesanan;
    }
    public int getNoPesanan(){
        return NoPesanan;
    }
    public int getNoPesanan(int KodeRincian){
        sql = "SELECT NoPesanan FROM rincianpesanan WHERE KodeRincian="+KodeRincian;
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
    public void UpdateNoPesanan(int KodeRincian,int NoPesanan) throws SQLException{
        sql = "UPDATE rincianpesanan SET NoPesanan="+NoPesanan+" WHERE KodeRincian="+KodeRincian;
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
    public String getBarcode(int KodeRincian){
        sql = "SELECT Barcode FROM rincianpesanan WHERE KodeRincian="+KodeRincian;
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
    public void UpdateBarcode(int KodeRincian,String Barcode) throws SQLException{
        sql = "UPDATE rincianpesanan SET Barcode='"+Barcode+"' WHERE KodeRincian="+KodeRincian;
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
