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
public class RincianOrderan {
    
    private int KodeRincian;
    private int KodeOrderan;
    private String Barcode;
    private String Satuan;
    private Double Kuantitas;
    private Double Harga;
    private Double Total;
    
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
        sql = "SELECT KodeRincian FROM rincianorderan WHERE KodeRincian="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeRincian = rs.getInt(1);
                return KodeOrderan;
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
    public int getKodeRincian(int KodeOrderan,String Barcode,String Satuan){
        sql = "SELECT KodeRincian FROM rincianorderan WHERE KodeOrderan="+KodeOrderan+" AND Barcode='"+Barcode+"' AND "
                + "Satuan='"+Satuan+"'";
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
    public int getLastKodeRincian(int KodeOrderan,String Barcode,String Satuan){
        sql = "SELECT KodeRincian FROM rincianorderan WHERE KodeRincian = (SELECT MAX(KodeRincian) FROM rincianorderan WHERE "
                + "KodeOrderan="+KodeOrderan+" AND Barcode='"+Barcode+"' AND Satuan='"+Satuan+"')";
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
    public void setKodeOrderan(int KodeOrderan){
        this.KodeOrderan = KodeOrderan;
    }
    public int getKodeOrderan(){
        return KodeOrderan;
    }
    public int getKodeOrderan(int KodeRincian){
        sql = "SELECT KodeOrderan FROM rincianorderan WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeOrderan = rs.getInt(1);
                return KodeOrderan;
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
    public void UpdateKodeOrderan(int KodeRincian,int KodeOrderan) throws SQLException{
        sql = "UPDATE rincianorderan SET KodeOrderan="+KodeOrderan+" WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Barcode FROM rincianorderan WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rincianorderan SET Barcode='"+Barcode+"' WHERE KodeRincian="+KodeRincian;
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
    public void setSatuan(String Satuan){
        this.Satuan = Satuan;
    }
    public String getSatuan(){
        return Satuan;
    }
    public String getSatuan(int KodeRincian){
        sql = "SELECT Satuan FROM rincianorderan WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Satuan = rs.getString(1);
                return Satuan;
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
    public void getSatuan(JComboBox cboSatuan,int KodeOrderan,String Barcode){
        sql = "SELECT Satuan FROM rincianorderan WHERE KodeOrderan="+KodeOrderan+" AND Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboSatuan.setModel(cbm);
            while(rs.next()){
                Satuan = rs.getString(1);
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
    public void UpdateSatuan(int KodeRincian,String Satuan) throws SQLException{
        sql = "UPDATE rincianorderan SET Satuan='"+Satuan+"' WHERE KodeRincian="+KodeRincian;
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
    public Double getKuantitas(int KodeRincian){
        sql = "SELECT Kuantitas FROM rincianorderan WHERE KodeRincian="+KodeRincian;
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
    public void UpdateKuantitas(int KodeRincian,Double Kuantitas) throws SQLException{
        sql = "UPDATE rincianorderan SET Kuantitas="+Kuantitas+" WHERE KodeRincian="+KodeRincian;
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
    public void setHarga(Double Harga){
        this.Harga = Harga;
    }
    public Double getHarga(){
        return Harga;
    }
    public Double getHarga(int KodeRincian){
        sql = "SELECT Harga FROM rincianorderan WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Harga = rs.getDouble(1);
                return Harga;
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
    public void UpdateHarga(int KodeRincian,Double Harga) throws SQLException{
        sql = "UPDATE rincianorderan SET Harga="+Harga+" WHERE KodeRincian="+KodeRincian;
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
    public void setTotal(Double Total){
        this.Total = Total;
    }
    public Double getTotal(){
        return Total;
    }
    public Double getTotal(int KodeRincian){
        sql = "SELECT Total FROM rincianorderan WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Total = rs.getDouble(1);
                return Total;
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
    public void UpdateTotal(int KodeRincian,Double Total) throws SQLException{
        sql = "UPDATE rincianorderan SET Total="+Total+" WHERE KodeRincian="+KodeRincian;
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
    public void getRincianOrderan(JTable tblOrderan){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.Kuantitas,r.Harga,r.Total FROM rincianorderan r "
                + "INNER JOIN items i ON (r.Barcode=i.Barcode) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Kauntitas","Harga","Total"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //Satuan
                rowdata[3] = rs.getDouble(4); //Kuantitas
                rowdata[4] = rs.getDouble(5); //Harga
                rowdata[5] = rs.getDouble(6); //Total
                
                dtm.addRow(rowdata);
            }
            
            tblOrderan.getColumnModel().getColumn(0).setPreferredWidth(100); //Barcode
            tblOrderan.getColumnModel().getColumn(1).setPreferredWidth(150); //NamaItem
            tblOrderan.getColumnModel().getColumn(2).setPreferredWidth(50); //Satuan
            tblOrderan.getColumnModel().getColumn(3).setPreferredWidth(100); //Kuantitas
            tblOrderan.getColumnModel().getColumn(4).setPreferredWidth(100); //Harga
            tblOrderan.getColumnModel().getColumn(5).setPreferredWidth(100); //Total
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
    public void getRincianOderan1(JTable tblOrderan,int KodeOrderan){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.Kuantitas,r.Harga,r.Total FROM rincianorderan r "
                + "INNER JOIN items i ON (r.Barcode=i.Barcode) WHERE (1=1) AND r.KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Kauntitas","Harga","Total"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Barcode
                rowdata[1] = rs.getString(2); //NamaItem
                rowdata[2] = rs.getString(3); //Satuan
                rowdata[3] = rs.getDouble(4); //Kuantitas
                rowdata[4] = rs.getDouble(5); //Harga
                rowdata[5] = rs.getDouble(6); //Total
                
                dtm.addRow(rowdata);
            }
            
            tblOrderan.getColumnModel().getColumn(0).setPreferredWidth(100); //Barcode
            tblOrderan.getColumnModel().getColumn(1).setPreferredWidth(150); //NamaItem
            tblOrderan.getColumnModel().getColumn(2).setPreferredWidth(50); //Satuan
            tblOrderan.getColumnModel().getColumn(3).setPreferredWidth(100); //Kuantitas
            tblOrderan.getColumnModel().getColumn(4).setPreferredWidth(100); //Harga
            tblOrderan.getColumnModel().getColumn(5).setPreferredWidth(100); //Total
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
    public void Simpan(int KodeOrderan,String Barcode,String Satuan,Double Kuantitas,Double Harga,Double Total) throws SQLException{
        sql = "INSERT INTO rincianorderan (KodeOrderan,Barcode,Satuan,Kuantitas,Harga,Total) VALUES ("+KodeOrderan+",'"+Barcode+"',"
                + "'"+Satuan+"',"+Kuantitas+","+Harga+","+Total+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeRincian = rs.getInt(1);
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
        sql = "INSERT INTO rincianorderan (KodeOrderan,Barcode,Satuan,Kuantitas,Harga,Total) VALUES (?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOrderan);
            PS.setString(2, Barcode);
            PS.setString(3, Satuan);
            PS.setDouble(4, Kuantitas);
            PS.setDouble(5, Harga);
            PS.setDouble(6, Total);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeRincian = rs.getInt(1);
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
        sql = "SELECT KodeOrderan,Barcode,Satuan,Kuantitas,Harga,Total FROM rincianorderan WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOrderan = rs.getInt(1);
            Barcode = rs.getString(2);
            Satuan = rs.getString(3);
            Kuantitas = rs.getDouble(4);
            Harga = rs.getDouble(5);
            Total = rs.getDouble(6);
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
        sql = "DELETE FROM rincianorderan";
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
    public void Hapus1(int KodeRincian) throws SQLException{
        sql = "DELETE FROM rincianorderan WHERE KodeRincian="+KodeRincian;
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
    public void Hapus2(int KodeOrderan) throws SQLException{
        sql = "DELETE FROM rincianorderan WHERE KodeOrderan="+KodeOrderan;
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
