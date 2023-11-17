/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.sql.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class Item {
    
    private int KodeItem;
    private String Barcode;
    private String NamaItem;
    private int JenisItem;
    private int KodeKategori;
    private int KodeOutlet;
    private int KodeSatuan;
    private Double Kuantitas;
    private Double Isi;
    private Double StokMinimum;
    private Double HargaModal;
    private Double HargaJual;
    private Double Diskon;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeItem(int KodeItem){
        this.KodeItem = KodeItem;
    }
    public int getKodeItem(int Kode){
        sql = "SELECT KodeItem FROM item WHERE KodeItem="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeItem = rs.getInt(1);
                return KodeItem;
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
    public int getKodeItem(String Barcode,int KodeSatuan){
        sql = "SELECT KodeItem FROM item WHERE Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeItem = rs.getInt(1);
                return KodeItem;
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
    public int getKodeItems(int KodeOutlet){
        sql = "SELECT KodeItem FROM item WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeItem = rs.getInt(1);
                return KodeItem;
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
    public int getKodeItem(String Barcode,int KodeOutlet,int KodeSatuan){
        sql = "SELECT KodeItem FROM item WHERE Barcode='"+Barcode+"' AND KodeOutlet="+KodeOutlet+" AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeItem = rs.getInt(1);
                return KodeItem;
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
    public String getBarcode(int KodeItem){
        sql = "SELECT Barcode FROM item WHERE KodeItem="+KodeItem;
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
    public String getBarcode(String KodeBarcode){
        sql = "SELECT Barcode FROM item WHERE Barcode='"+KodeBarcode+"'";
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
    public String getKodeBarcode(int KodeOutlet){
        sql = "SELECT Barcode FROM item WHERE KodeOutlet="+KodeOutlet;
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
    public void UpdateBarcode(int KodeItem,String Barcode) throws SQLException{
        sql = "UPDATE item SET Barcode='"+Barcode+"' WHERE KodeItem="+KodeItem;
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
    public void setNamaItem(String NamaItem){
        this.NamaItem = NamaItem;
    }
    public String getNamaItem(){
        return NamaItem;
    }
    public String getNamaItem(int KodeItem){
        sql = "SELECT NamaItem FROM item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaItem = rs.getString(1);
                return NamaItem;
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
    public String getNamaItem(String Barcode){
        sql = "SELECT NamaItem FROM item WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaItem = rs.getString(1);
                return NamaItem;
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
    public String getNamaItems(int KodeOutlet){
        sql = "SELECT NamaItem FROM item WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaItem = rs.getString(1);
                return NamaItem;
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
    public void UpdateNamaItem(int KodeItem,String NamaItem) throws SQLException{
        sql = "UPDATE item SET NamaItem='"+NamaItem+"' WHERE KodeItem="+KodeItem;
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
    public void UpdateNamaItem(String Barcode,String NamaItem) throws SQLException{
        sql = "UDPATE item SET NamaItem='"+NamaItem+"' WHERE Barcode='"+Barcode+"'";
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
    public void setJenisItem(int JenisItem){
        this.JenisItem = JenisItem;
    }
    public int getJenisItem(){
        return JenisItem;
    }
    public int getJenisItem(int KodeItem){
        sql = "SELECT JenisItem FROM item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisItem = rs.getInt(1);
                return JenisItem;
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
    public int getJenisItem(String Barcode){
        sql = "SELECT JenisItem FROM item WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisItem = rs.getInt(1);
                return JenisItem;
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
    public int getJenisItems(int KodeOutlet){
        sql = "SELECT JenisItem FROM item WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisItem = rs.getInt(1);
                return JenisItem;
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
    public int getJenisItem(String Barcode,int KodeSatuan){
        sql = "SELECT JenisItem FROM item WHERE Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisItem = rs.getInt(1);
                return JenisItem;
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
    public void UpdateJenisItem(int KodeItem,int JenisItem) throws SQLException{
        sql = "UDPATE item SET JenisItem="+JenisItem+" WHERE KodeItem="+KodeItem;
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
    public void UpdateJenisItem(String Barcode,int JenisItem) throws SQLException{
        sql = "UDPATE item SET JenisItem="+JenisItem+" WHERE Barcode='"+Barcode+"'";
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
    public void UpdateJenisItem(String Barcode,int Satuan,int JenisItem) throws SQLException{
        sql = "UPDATE item SET JenisItem="+JenisItem+" WHERE Barcode='"+Barcode+"' WHERE JenisItem="+JenisItem;
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
    public void setKodeKategori(int KodeKategori){
        this.KodeKategori = KodeKategori;
    }
    public int getKodeKategori(){
        return KodeKategori;
    }
    public int getKodeKategori(int KodeItem){
        sql = "SELECT KodeKategori FROM item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKategori = rs.getInt(1);
                return KodeKategori;
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
    public int getKodeKategori(String Barcode){
        sql = "SELECT KodeKategori FROM item WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKategori = rs.getInt(1);
                return KodeKategori;
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
    public int getKodeCategory(int KodeOutlet){
        sql = "SELECT KodeKategori FROM item WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKategori = rs.getInt(1);
                return KodeKategori;
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
    public int getKodeKategori(String Barcode,int KodeSatuan){
        sql = "SELECT KodeKategori FROM item WHERE Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKategori = rs.getInt(1);
                return KodeKategori;
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
    public void UpdateKodeKategori(int KodeItem,int KodeKategori) throws SQLException{
        sql = "UPDATE item SET KodeKategori="+KodeKategori+" WHERE KodeItem="+KodeItem;
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
    public void UpdateKodeKategori(String Barcode,int KodeKategori) throws SQLException{
        sql = "UPDATE item SET KodeKategori="+KodeKategori+" WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKodeKategori(String Barcode,int KodeSatuan,int KodeKategori) throws SQLException{
        sql = "UPDATE item SET KodeKategori="+KodeKategori+" WHERE Barcode='"+Barcode+"' AND KodeSatuan="+KodeSatuan;
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
    public int getKodeOutlet(int KodeItem){
        sql = "SELECT KodeOutlet FROM item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.CONCUR_READ_ONLY,
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
        sql = "SELECT KodeOutlet FROM item WHERE Barcode='"+Barcode+"'";
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
    
    public void UpdateKodeOutlet(int KodeItem,int KodeOutlet) throws SQLException{
        sql = "UPDATE item SET KodeOutlet="+KodeOutlet+" WHERE KodeItem="+KodeItem;
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
    public void UpdateKodeOutlet(String Barcode,int KodeOutlet) throws SQLException{
        sql = "UPDATE item SET KodeOutlet="+KodeOutlet+" WHERE Barcode='"+Barcode+"'";
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
    public void setKodeSatuan(int KodeSatuan) {
        this.KodeSatuan = KodeSatuan;
    }
    public int getKodeSatuan(){
        return KodeSatuan;
    }
    public int getKodeSatuan(int KodeItem){
        sql = "SELECT KodeSatuan FROM item WHERE KodeItem="+KodeItem;
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
        sql = "SELECT KodeSatuan FROM item WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKodeSatuan(int KodeItem,int KodeSatuan) throws SQLException{
        sql = "UPDATE item SET KodeSatuan="+KodeSatuan+" WHERE KodeItem="+KodeItem;
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
    public void UpdateKodeSatuan(String Barcode,int KodeSatuan) throws SQLException{
        sql = "UPDATE item SET KodeSatuan="+KodeSatuan+" WHERE Barcode='"+Barcode+"'";
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
    public Double getKuantitas(int KodeItem){
        sql = "SELECT Kuantitas FROM item WHERE KodeItem="+KodeItem;
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
    public Double getKuantitas(String Barcode) throws SQLException{
        sql = "SELECT Kuantitas FROM item WHERE Barcode='"+Barcode+"'";
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
    public void UpdateKuantitas(int KodeItem,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas="+Kuantitas+" WHERE KodeItem="+KodeItem;
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
    public void UpdateKuantitas(String Barcode,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas="+Kuantitas+" WHERE Barcode='"+Barcode+"'";
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
    public void TambahKuantitas(int KodeItem,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas = Kuantitas + "+Kuantitas+" WHERE KodeItem="+KodeItem;
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
    public void TambahKuantitas(String Barcode,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas = "+Kuantitas+" WHERE Barcode='"+Barcode+"'";
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
    public void KurangiKuantitas(int KodeItem,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas = Kuantitas - "+Kuantitas+" WHERE KodeItem="+KodeItem;
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
    public void KurangiKuantitas(String Barcode,Double Kuantitas) throws SQLException{
        sql = "UPDATE item SET Kuantitas = Kuantitas - "+Kuantitas+" WHERE Barcode='"+Barcode+"'";
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
    public void Isi(Double Isi){
        this.Isi = Isi;
    }
    public Double getIsi(){
        return Isi;
    }
    public Double getIsi(int KodeItem){
        sql = "SELECT Isi FROM item WHERE KodeItem="+KodeItem;
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
    public Double getIsi(String Barcode){
        sql = "SELECT Isi FROM item WHERE Barcode='"+Barcode+"'";
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
    public void UpdateIsi(int KodeItem,Double Isi) throws SQLException{
        sql = "UPDATE item SET Isi="+Isi+" WHERE KodeItem="+KodeItem;
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
    public void UpdateIsi(String Barcode,Double Isi) throws SQLException{
        sql = "UPDATE item SET Isi="+Isi+" WHERE Barcode='"+Barcode+"'";
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
    public void setStokMinimum(Double StokMinimum){
        this.StokMinimum = StokMinimum;
    }
    public Double getStokMinimum(){
        return StokMinimum;
    }
    public Double getStokMinimum(int KodeItem){
        sql = "SELECT StokMinimum FROM item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMinimum = rs.getDouble(1);
                return StokMinimum;
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
    public Double getStokMinimum(String Barcode){
        sql = "SELECT StokMinimum FROM item WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokMinimum = rs.getDouble(1);
                return StokMinimum;
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
    public void UpdateStokMinimum(int KodeItem,Double StokMinimum) throws SQLException{
        sql = "UPDATE item SET StokMinimum="+StokMinimum+" WHERE KodeItem="+KodeItem;
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
    public void UpdateStokMinimum(String Barcode,Double StokMinimum) throws SQLException{
        sql = "UPDATE item SET StokMinimum="+StokMinimum+" WHERE Barcode='"+Barcode+"'";
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
    public Double getHargaModal(int KodeItem){
        sql = "SELECT HargaModal FROM item WHERE KodeItem="+KodeItem;
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
        sql = "SELECT HargaModal FROM item WHERE Barcode='"+Barcode+"'";
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
    public void UpdateHargaModal(int KodeItem,Double HargaModal) throws SQLException{
        sql = "UPDATE item SET HargaModal="+HargaModal+" WHERE KodeItem="+KodeItem;
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
    public void UpdateHargaModal(String Barcode,Double HargaModal) throws SQLException{
        sql = "UPDATE item SET HargaModal="+HargaModal+" WHERE Barcode='"+Barcode+"'";
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
    public Double getDiskon(int KodeItem){
        sql = "SELECT Diskon FROM item WHERE KodeItem="+KodeItem;
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
    public Double getDiskon(String Barcode){
        sql = "SELECT Diskon FROM item WHERE Barcode='"+Barcode+"'";
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
    public void UpdateDiskon(int KodeItem,Double Diskon) throws SQLException{
        sql = "UPDATE item SET Diskon="+Diskon+" WHERE KodeItem="+KodeItem;
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
    public void UpdateDiskon(String Barcode,Double Diskon) throws SQLException{
        sql = "UPDATE item SET Diskon="+Diskon+" WHERE Barcode='"+Barcode+"'";
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
    public void getItem(int KodeCabang){
        sql = "SELECT Barcode,NamaItem,JenisItem,KodeKategori,KodeOutlet,KodeSatuan,HargaModal,HargaJual,Diskon FROM item WHERE KodeOutlet="
                +KodeCabang;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            Barcode = rs.getString(1);
            NamaItem = rs.getString(2);
            JenisItem = rs.getInt(3);
            KodeKategori = rs.getInt(4);
            KodeOutlet = rs.getInt(5);
            KodeSatuan = rs.getInt(6);
            HargaModal = rs.getDouble(7);
            HargaJual = rs.getDouble(8);
            Diskon = rs.getDouble(9);
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
    public void getItem(JTable tblItem){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem1(JTable tblItem,String NamaItem){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem2(JTable tblItem,int JenisItem){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem3(JTable tblItem,int KodeKategori){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem4(JTable tblItem,int KodeOutlet){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem5(JTable tblItem,int KodeOutlet,String NamaItem){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.KodeOutlet="+KodeOutlet+" AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getItem6(JTable tblItem,int KodeOutlet,int KodeKategori){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,o.NamaOutlet,s.NamaSatuan,i.HargaModal,i.HargaJual,i.Diskon FROM item i INNER JOIN kategori k INNER JOIN outlet o "
                + "INNER JOIN satuan s ON (i.KodeKategori=k.KodeKategori AND i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=s.KodeSatuan) WHERE (1=1) "
                + "AND i.KodeOutlet="+KodeOutlet+" AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Jenis Item","Ketegori","Outlet","Satuan","Harga Modal","Harga Jual","Diskon"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 10;
                }
            });
            
            Object rowdata[] = new Object[10];
            DefaultTableModel dtm = (DefaultTableModel)tblItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                
                dtm.addRow(rowdata);
            }
            
            tblItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblItem.getColumnModel().getColumn(9).setPreferredWidth(80);
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
    public void getStokItem(JTable tblStokItem){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    public void getStokItem1(JTable tblStokItem,String Barcode) throws SQLException{
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1) AND "
                + "i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1) AND i.NamaItem "
                + "LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    public void getStokItem3(JTable tblStokItem,int KodeOutlet){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1) WHERE i.KodeOutlet="
                + KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    public void getStokItem4(JTable tblStokItem,String Barcode,int KodeOutlet){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1) AND i.Barcode="
                + "'"+Barcode+"' AND i.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    public void getStokItem5(JTable tblStokItem,String NamaItem,int KodeOutlet){
        sql = "SELECT i.KodeItem,i.Barcode,i.NamaItem,o.NamaOutlet,s.NamaSatuan,i.Kuantitas,i.Isi,i.StokMinimum FROM item i INNER JOIN "
                + "outlet o INNER JOIN satuan s ON (i.KodeOutlet=o.KodeOutlet AND i.KodeSatuan=o.KodeSatuan) WHERE (1=1) AND i.NamaItem "
                + "LIKE '"+NamaItem+"' AND i.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblStokItem.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Item","Barcode","Nama Item","Outlet","Satuan","Kuantitas","Isi","Stok Minimum"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            DefaultTableModel dtm = (DefaultTableModel)tblStokItem.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //KodeItem
                rowdata[1] = rs.getString(2); //Barcode
                rowdata[2] = rs.getString(3); //NamaItem
                rowdata[3] = rs.getString(4); //Outlet
                rowdata[4] = rs.getString(5); //Satuan
                rowdata[5] = rs.getDouble(6); //Kuantitas
                rowdata[6] = rs.getDouble(7); //Isi
                rowdata[7] = rs.getDouble(8); //StokMinimum
                
                dtm.addRow(rowdata);
            }
            
            tblStokItem.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblStokItem.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblStokItem.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(4).setPreferredWidth(60);
            tblStokItem.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblStokItem.getColumnModel().getColumn(6).setPreferredWidth(50);
            tblStokItem.getColumnModel().getColumn(7).setPreferredWidth(100);
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
    public void Simpan(String Barcode,String NamaItem,int JenisItem,int KodeKategori,int KodeOutlet,Double Kuantitas,Double Isi,Double StokMinimum,
            Double HargaModal,Double HargaJual) throws SQLException{
        sql = "INSERT INTO item (Barcode,NamaItem,JenisItem,KodeKategori,KodeOutlet,Kuantitas,Isi,StokMinimum,HargaModal,HargaJual) "
                + "VALUES ('"+Barcode+"','"+NamaItem+","+JenisItem+","+KodeKategori+","+KodeOutlet+","+Kuantitas+","+Isi+","+StokMinimum+","
                + HargaModal+","+HargaJual+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeItem = rs.getInt(1);
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
        sql = "INSERT INTO item (Barcode,NamaItem,JenisItem,KodeKaetgori,KodeOutlet,KodeSatuan,Kuantitas,Isi,StokMinimum,HargaModal,HargaJual) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, Barcode);
            PS.setString(2, NamaItem);
            PS.setInt(3, JenisItem);
            PS.setInt(4, KodeKategori);
            PS.setInt(5, KodeOutlet);
            PS.setInt(6, KodeSatuan);
            PS.setDouble(7, Kuantitas);
            PS.setDouble(8, Isi);
            PS.setDouble(9, StokMinimum);
            PS.setDouble(10, HargaModal);
            PS.setDouble(11, HargaJual);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeItem = rs.getInt(1);
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
        sql = "SELECT KodeItem,Barcode,NamaItem,JenisItem,KodeKategori,KodeOutlet,KodeSatuan,Kuantitas,Isi,StokMinimum,HargaModal,HargaJual FROM "
                + "item WHERE KodeItem="+KodeItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeItem = rs.getInt(1);
            Barcode = rs.getString(2);
            NamaItem = rs.getString(3);
            JenisItem = rs.getInt(4);
            KodeKategori = rs.getInt(5);
            KodeOutlet = rs.getInt(6);
            KodeSatuan = rs.getInt(7);
            Kuantitas = rs.getDouble(8);
            Isi = rs.getDouble(9);
            StokMinimum = rs.getDouble(10);
            HargaModal = rs.getDouble(11);
            HargaJual = rs.getDouble(12);
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
        sql = "DELETE FROM item";
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
    public void Hapus(int KodeItem) throws SQLException{
        sql = "DELETE FROM item WHERE KodeItem="+KodeItem;
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
