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
public class RincianTransfer {
    
    private int KodeRincian;
    private int KodeTF;
    private String Barcode;
    private String Satuan;
    private Double StokDikirim;
    private Double StokDiterima;
    private Double HargaModal;
    private Double TotalModal;
    
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
        sql = "SELECT KodeRincian FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
        try {
            stmt =DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
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
    public int getKodeRincian(int KodeTF,String Barcode,String Satuan){
        sql = "SELECT KodeRincian FROM rinciantransfer WHERE KodeTF="+KodeTF+" AND Barcode='"+Barcode+"' AND Satuan='"+Satuan+"'";
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
    public int getLastKodeRincian(int KodeTF,String Barcode,String Satuan){
        sql = "SELECT KodeRincian FROM rinciantransfer WHERE KodeRincian = (SELECT MAX(KodeRincian) FROM rinciantransfer WHERE KodeTF="+KodeTF+" "
                + "AND Barcode='"+Barcode+"' AND Satuan='"+Satuan+"'";
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
    public void setKodeTF(int KodeTF){
        this.KodeTF = KodeTF;
    }
    public int getKodeTF(){
        return KodeTF;
    }
    public int getKodeTF(int KodeRincian){
        sql = "SELECT KodeTF FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
    public void UpdateKodeTF(int KodeRincian,int KodeTF) throws SQLException{
        sql = "UPDATE rinciantransfer SET KodeTF="+KodeTF+" WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Barcode FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rinciantransfer SET Barcode='"+Barcode+"' WHERE KodeRincian="+KodeRincian;
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
        sql = "SELECT Satuan FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
        sql = "UPDATE rinciantransfer SET Satuan='"+Satuan+"' WHERE KodeRincian="+KodeRincian;
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
    public void setStokDikirim(Double StokDikirim){
        this.StokDikirim = StokDikirim;
    }
    public Double getStokDikirim(){
        return StokDikirim;
    }
    public Double getStokDikirm(int KodeRincian){
        sql = "SELECT StokDikirim FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokDikirim = rs.getDouble(1);
                return StokDikirim;
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
    public void UpdateStokDikirm(int KodeRincian,Double StokDikirim) throws SQLException{
        sql = "UPDATE rinciantransfer SET StokDikirim="+StokDikirim+" WHERE KodeRincian="+KodeRincian;
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
    public void setStokDiterima(Double StokDiterima){
        this.StokDiterima = StokDiterima;
    }
    public Double getStokDiterima(){
        return StokDiterima;
    }
    public Double getStokDiterima(int KodeRincian){
        sql = "SELECT StokDiterima FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StokDiterima = rs.getDouble(1);
                return StokDiterima;
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
    public void UpdateStokDiterima(int KodeRincian,Double StokDiterima) throws SQLException{
        sql = "UPDATE rinciantransfer SET StokDiterima="+StokDiterima+" WHERE KodeRincian="+KodeRincian;
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
    public Double getHargaModal(int KodeRincian){
        sql = "SELECT HargaModal FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
    public void UpdateHargaModal(int KodeRincian,Double HargaModal) throws SQLException{
        sql = "UPDATE rinciantransfer SET HargaModal="+HargaModal+" WHERE KodeRincian="+KodeRincian;
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
    public Double getTotalModal(int KodeRincian){
        sql = "SELECT TotalModal FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
    public void UpdateTotalModal(int KodeRincian,Double TotalModal) throws SQLException{
        sql = "UPDATE rinciantransfer SET TotalModal="+TotalModal+" WHERE KodeRincian="+KodeRincian;
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
    public void getRincianTransfer(JTable tblRincianTransfer){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.StokDikirim,r.StokDiterima,r.HargaModal,r.TotalModal FROM rinciantransfer r INNER JOIN items i "
                + "ON (i.Barcode=r.Barcode) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblRincianTransfer.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Stok Dikirim","Stok Diterima","Harga Modal","Total Modal"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
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
            
            tblRincianTransfer.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblRincianTransfer.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRincianTransfer.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblRincianTransfer.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblRincianTransfer.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblRincianTransfer.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblRincianTransfer.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void getRincianTransfer(JTable tblRincianTransfer,int KodeTF){
        sql = "SELECT r.Barcode,i.NamaItem,r.Satuan,r.StokDikirim,r.StokDiterima,r.HargaModal,r.TotalModal FROM rinciantransfer r INNER JOIN items i "
                + "ON (i.Barcode=r.Barcode) WHERE (1=1) AND r.KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblRincianTransfer.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Satuan","Stok Dikirim","Stok Diterima","Harga Modal","Total Modal"};
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
            DefaultTableModel dtm = (DefaultTableModel)tblRincianTransfer.getModel();
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
            
            tblRincianTransfer.getColumnModel().getColumn(0).setPreferredWidth(60);
            tblRincianTransfer.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblRincianTransfer.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblRincianTransfer.getColumnModel().getColumn(3).setPreferredWidth(70);
            tblRincianTransfer.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblRincianTransfer.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblRincianTransfer.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void Simpan(int KodeTF,String Barcode,String Satuan,Double StokDikirim,Double StokDiterima,Double HargaModal,
            Double TotalModal) throws SQLException{
        sql = "INSERT INTO rinciantransfer (KodeTF,Barcode,Satuan,Stok Dikirim,Stok Diterima,HargaModal,TotalModal) VALUES ("+KodeTF+","
                + "'"+Barcode+"','"+Satuan+"',"+StokDikirim+","+StokDiterima+","+HargaModal+","+TotalModal+")";
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
        sql = "INSERT INTO rinciantransfer (KodeTF,Barcode,Satuan,StokDikirim,StokDiterima,HargaModal,TotalModal) VALUES (?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeTF);
            PS.setString(2, Barcode);
            PS.setString(3, Satuan);
            PS.setDouble(4, StokDikirim);
            PS.setDouble(5, StokDiterima);
            PS.setDouble(6, HargaModal);
            PS.setDouble(7, TotalModal);
            
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
        sql = "SELECT KodeTF,Barcode,Satuan,StokDikirim,StokDiterima,HargaModal,TotalModal FROM rinciantransfer WHERE KodeTF="+KodeTF;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeTF = rs.getInt(1);
            Barcode = rs.getString(2);
            Satuan = rs.getString(3);
            StokDikirim = rs.getDouble(4);
            StokDiterima = rs.getDouble(5);
            HargaModal = rs.getDouble(6);
            TotalModal = rs.getDouble(7);
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
        sql = "DELETE FROM rinciantransfer";
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
    public void Hapus(int KodeRincian) throws SQLException{
        sql = "DELETE FROM rinciantransfer WHERE KodeRincian="+KodeRincian;
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
    public void Hapus2(int KodeTF) throws SQLException{
        sql = "DELETE FROM rinciantransfer WHERE KodeTF="+KodeTF;
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
