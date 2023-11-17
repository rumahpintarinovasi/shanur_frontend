/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import Util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class RincianTransaksi {
    
    private int KodeRincian;
    private int NoNota;
    private String Barcode;
    private String NamaItem;
    private String Satuan;
    private Double Kuantitas;
    private Double Harga;
    private Double Diskon;
    private Double Total;
    private int RowCount;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeSatuan(int KodeRincian){
        this.KodeRincian = KodeRincian;
    }
    public int getKodeRincian(){
        return KodeRincian;
    }
    public int getKodeRincian(int NoNota,String Barcode,String Satuan){
        sql = "SELECT KodeRincian FROM rinciantransaksi WHERE NoNota="+NoNota+" AND "
                + "Barcoed='"+Barcode+"' AND Satuan='"+Satuan+"'";
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
    public void setNoNota(int NoNota){
        this.NoNota = NoNota;
    }
    public int getNoNota(){
        return NoNota;
    }
    public int getNoNota(int KodeRincian){
        sql = "SELECT NoNota FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public void setBarcode(String Barcode){
        this.Barcode = Barcode;
    }
    public String getBarcode(){
        return Barcode;
    }
    public String getBarcode(int KodeRincian){
        sql = "SELECT Barcode FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public String getBarcode(int KodeRincian,String KodeBarcode){
        sql = "SELECT Barcode FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public void setSatuan(String Satuan){
        this.Satuan = Satuan;
    }
    public String getSatuan(){
        return Satuan;
    }
    public String getSatuan(int KodeRincian){
        sql = "SELECT Satuan FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public void UpdateSatuan(int KodeRincian,String Satuan) throws SQLException{
        sql = "UPDATE rinciantransaksi SET Satuan='"+Satuan+"' WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Kuantitas FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rinciantransaksi SET Kuantitas="+Kuantitas+" WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Harga FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rinciantransaksi SET Harga="+Harga+" WHERE KodeRincian="+KodeRincian;
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
    public Double getDiskon(int KodeRincian){
        sql = "SELECT Diskon FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public void UpdateDiskon(int KodeRincian,Double Diskon) throws SQLException{
        sql = "UPDATE rinciantransaksi SET Diskon="+Diskon+" WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Total FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rinciantransaksi SET Total="+Total+" WHERE KodeRincian="+KodeRincian;
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
    public int getRowCount(){
        sql = "SELECT Count(*) FROM rinciantransaksi";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                RowCount = rs.getInt(1);
                return RowCount;
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
    public int getRowCount(int NoNota){
        sql = "SELECT Count(*) FROM rinciantransaksi WHERE NoNota="+NoNota;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                RowCount = rs.getInt(1);
                return RowCount;
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
    public void getRincianTransaksi(JTable tblRincianTransaksi){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.Kuantitas,r.Harga,r.Diskon,r.Total FROM rinciantransaksi r "
                + "INNER JOIN items i ON (i.Barcode=r.Barcode) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblRincianTransaksi.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Kuantitas","Harga","Diskon","Total"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 7;
                }
            });
            
            Object rowdata[] = new Object[7];
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransaksi.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblRincianTransaksi.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRincianTransaksi.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblRincianTransaksi.getColumnModel().getColumn(3).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(4).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblRincianTransaksi.getColumnModel().getColumn(6).setPreferredWidth(75);
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
    public void getRincianTransaksi(JTable tblRincianTransaksi,int NoNota){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.Kuantitas,r.Harga,r.Diskon,r.Total FROM rinciantransaksi r "
                + "INNER JOIN items i ON (i.Barcode=r.Barcode) WHERE (1=1) AND r.NoNota="+NoNota;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblRincianTransaksi.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Kuantitas","Harga","Diskon","Total"};
                Class ColType[] = {String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class};
                
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
                    return 7;
                }
            });
            
            Object rowdata[] = new Object[7];
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransaksi.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getDouble(4);
                rowdata[4] = rs.getDouble(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblRincianTransaksi.getColumnModel().getColumn(0).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRincianTransaksi.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblRincianTransaksi.getColumnModel().getColumn(3).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(4).setPreferredWidth(75);
            tblRincianTransaksi.getColumnModel().getColumn(5).setPreferredWidth(50);
            tblRincianTransaksi.getColumnModel().getColumn(6).setPreferredWidth(75);
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
    public void Simpan(int NoNota,String Barcode,String Satuan,Double Kuantitas,Double Harga,Double Diskon,Double Total) throws SQLException{
        sql = "INSERT INTO rinciantransaksi (NoNota,Barcode,Satuan,Kuantitas,Harga,Diskon,Total) VALUES ("+NoNota+",'"+Barcode+"','"+Satuan+"',"
                + Kuantitas+","+Harga+","+Diskon+","+Total+")";
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
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void SimpanLocalDB(int NoNota,String Barcode,String Satuan,Double Kuantitas,Double Harga,Double Diskon,Double Total) throws SQLException{
        sql = "INSERT INTO rinciantransaksi (NoNota,Barcode,Satuan,Kuantitas,Harga,Diskon,Total) VALUES ("+NoNota+",'"+Barcode+"','"+Satuan+"',"
                + Kuantitas+","+Harga+","+Diskon+","+Total+")";
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
        sql = "INSERT INTO rinciantransaksi (NoNota,Barcode,Satuan,Kuantitas,Harga,Diskon,Total) VALUES (?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, NoNota);
            PS.setString(2, Barcode);
            PS.setString(3, Satuan);
            PS.setDouble(4, Kuantitas);
            PS.setDouble(5, Harga);
            PS.setDouble(6, Diskon);
            PS.setDouble(7, Total);
            
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
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void SimpanLocalDB() throws SQLException{
        sql = "INSERT INTO rinciantransaksi (NoNota,Barcode,Satuan,Kuantitas,Harga,Diskon,Total) VALUES (?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnectionLocal().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, NoNota);
            PS.setString(2, Barcode);
            PS.setString(3, Satuan);
            PS.setDouble(4, Kuantitas);
            PS.setDouble(5, Harga);
            PS.setDouble(6, Diskon);
            PS.setDouble(7, Total);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeRincian = rs.getInt(1);
        } 
        catch (SQLException e) {
            DBConnector.getConnectionLocal().rollback();
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
        sql = "SELECT NoNota,Barcode,Satuan,Kuantitas,Harga,Diskon,Total FROM rinciantransaksi WHERE NoNota="+NoNota;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NoNota = rs.getInt(1);
            Barcode = rs.getString(2);
            Satuan = rs.getString(3);
            Kuantitas = rs.getDouble(4);
            Harga = rs.getDouble(5);
            Diskon = rs.getDouble(6);
            Total = rs.getDouble(7);
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
        sql = "DELETE FROM rinciantransaksi";
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
        sql = "DELETE FROM rinciantransaksi WHERE KodeRincian="+KodeRincian;
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
    public void Hapus2(int NoNota) throws SQLException{
        sql = "DELETE FROM rinciantransaksi WHERE NoNota="+NoNota;
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
