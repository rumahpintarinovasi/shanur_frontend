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
public class Orderan {
    
    private int KodeOrderan;
    private int KodeOutlet;
    private int KodeUser;
    private int KodeBC;
    private Calendar Tanggal;
    private int JenisTransaksi;
    private int KodeJenis;
    private Double SubTotal;
    private Double PPN;
    private Double GrandTotal;
    private Double JmlhPembayaran;
    private int StatusOrderan;
    private Calendar TglExpire;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeOrderan(int KodeOrderan){
        this.KodeOrderan = KodeOrderan;
    }
    public int getKodeOrderan(){
        return KodeOrderan;
    }
    public int getKodeOrderan(int Kode){
        sql = "SELECT KodeOrderan FROM orderan WHERE KodeOrderan="+Kode;
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
    public int getKodeOrderan(int KodeOutlet,int KodeUser,int KodeBC,Calendar Tanggal,int JenisTransaksi,int KodeJenis){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeOrderan FROM orderan WHERE KodeOutlet="+KodeOutlet+" AND KodeUser="+KodeUser+" AND Tanggal='"+Tgl+"' AND "
                + "JenisTransaksi="+JenisTransaksi+" AND KodeJenis="+KodeJenis;
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
    public int getLastKodeOrderan(int KodeOutlet,int KodeUser,int KodeBC,Calendar Tanggal,int JenisTransaksi,int KodeJenis){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeOrderan FROM orderan WHERE KodeOrderan=(SELECT MAX(KodeOrderan) FROM orderan WHERE KodeOutlet="+KodeOutlet+" "
                + "AND KodeUser="+KodeUser+" AND KodeBC="+KodeBC+" AND Tanggal='"+Tgl+"' AND JenisTransaksi="+JenisTransaksi+" AND "
                + "KodeJenis="+KodeJenis+")";
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
    public void setKodeOutlet(int KodeOutlet){
        this.KodeOutlet = KodeOutlet;
    }
    public int getKodeOutlet(){
        return KodeOutlet;
    }
    public int getKodeOutlet(int KodeOrderan){
        sql = "SELECT KodeOutlet FROM orderan WHERE KodeOrderan="+KodeOrderan;
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
    public void UpdateKodeOutlet(int KodeOrderan,int KodeOutlet) throws SQLException{
        sql = "UPDATE orderan SET KodeOutlet="+KodeOutlet+" WHERE KodeOrderan="+KodeOrderan;
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
    public int getKodeUser(int KodeOrderan){
        sql = "SELECT KodeUser FROM orderan WHERE KodeOrderan="+KodeOrderan;
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
    public void UpdateKodeUser(int KodeOrderan,int KodeUser) throws SQLException{
        sql = "UPDATE orderan SET KodeUser="+KodeUser+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setKodeBC(int KodeBC){
        this.KodeBC = KodeBC;
    }
    public int getKodeBC(int KodeOrderan){
        sql = "SELECT KodeBC FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeBC =  rs.getInt(1);
                return KodeBC;
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
    public void UpdateKodeBC(int KodeOrderan,int KodeBC) throws SQLException{
        sql = "UPDATE orderan SET KodeBC="+KodeBC+" WHERE KodeOrderan="+KodeOrderan;
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
    public Calendar getTanggal(int KodeOrderan){
        sql = "SELECT Tanggal FROM orderan WHERE KodeOrderan="+KodeOrderan;
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
    public void UpdateTanggal(int KodeOrderan,Calendar Tanggal) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "UPDATE orderan SET Tanggal='"+Tgl+"' WHERE KodeOrderan="+KodeOrderan;
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
    public void setJenisTransaksi(int JenisTransaksi){
        this.JenisTransaksi = JenisTransaksi;
    }
    public int getJenisTransaksi(){
        return JenisTransaksi;
    }
    public int getJenisTransaksi(int KodeOrderan){
        sql = "SELECT JenisTransaksi FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisTransaksi = rs.getInt(1);
                return JenisTransaksi;
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
    public void UpdateJenisTransaksi(int KodeOrderan,int JenisTransaksi) throws SQLException{
        sql = "UPDATE orderan SET JenisTransaksi="+JenisTransaksi+" WHERE KodeOrderan="+KodeOrderan;
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
    public int getKodeJenis(int KodeOrderan){
        sql = "SELECT KodeJenis FROM orderan WHERE KodeOrderan="+KodeOrderan;
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
    public void UpdateKodeJenis(int KodeOrderan,int KodeJenis) throws SQLException{
        sql = "UPDATE orderan SET KodeJenis="+KodeJenis+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setSubTotal(Double SubTotal){
        this.SubTotal = SubTotal;
    }
    public Double getSubTotal(){
        return SubTotal;
    }
    public Double getSubTotal(int KodeOrderan){
        sql = "SELECT SubTotal FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                SubTotal = rs.getDouble(1);
                return SubTotal;
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
    public void UpdateSubTotal(int KodeOrderan,Double SubTotal) throws SQLException{
        sql = "UPDATE orderan SET SubTotal="+SubTotal+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setPPN(Double PPN){
        this.PPN = PPN;
    }
    public Double getPPN(int KodeOrderan){
        sql = "SELECT PPN FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                PPN = rs.getDouble(1);
                return PPN;
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
    public void UpdatePPN(int KodeOrderan,Double PPN) throws SQLException{
        sql = "UPDATE orderan SET PPN="+PPN+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setGrandTotal(Double GrandTotal){
        this.GrandTotal = GrandTotal;
    }
    public Double getGrandTotal(){
        return GrandTotal;
    }
    public Double getGrandTotal(int KodeOrderan){
        sql = "SELECT GrandTotal FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                GrandTotal = rs.getDouble(1);
                return GrandTotal;
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
    public void UpdateGrandTotal(int KodeOrderan,Double GrandTotal) throws SQLException{
        sql = "UPDATE orderan SET GrandTotal="+GrandTotal+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setStatusOrderan(int StatusOrderan){
        this.StatusOrderan = StatusOrderan;
    }
    public int getStatusOrderan(){
        return StatusOrderan;
    }
    public int getStatusOrderan(int KodeOrderan){
        sql = "SELECT StatusOrderan FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StatusOrderan = rs.getInt(1);
                return StatusOrderan;
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
    public void UpdateStatusOrderan(int KodeOrderan,int StatusOrderan) throws SQLException{
        sql = "UPDATE orderan SET StatusOrderan="+StatusOrderan+" WHERE KodeOrderan="+KodeOrderan;
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
    public void setTglExpire(Calendar TglExpire){
        this.TglExpire = TglExpire;
    }
    public Calendar getTglExpire(){
        return TglExpire;
    }
    public Calendar getTglExpire(int KodeOrderan){
        sql = "SELECT TglExpire FROM orderan WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TglExpire = Calendar.getInstance();
                TglExpire.setTime(rs.getDate(1));
                return TglExpire;
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
    public void UpdateTglExpire(int KodeOrderan,Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "UPDATE orderan SET TglExpire='"+TglExp+"' WHERE KodeOrderan="+KodeOrderan;
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
    public void getOrderan(JTable tblOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int JenisTransaksi,int KodeJenis,JRadioButton rbHarian,
            JRadioButton rbAntarTanggal,JRadioButton rbBulanan,JRadioButton rbSemua,JCheckBox cbOutlet,JCheckBox cbUser,
            JCheckBox cbJenisTransaksi,JCheckBox cbKodeJenis,Calendar Tanggal,Calendar TglAwal,Calendar TglAkhir,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) ";
        if(rbHarian.isSelected()){
            java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
            if(cbOutlet.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbUser.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"' ";
            }
            else if(cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"' ";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.Tanggal='"+Tgl+"' ";
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbOutlet.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" "
                        + "AND od.Tanggal='"+Tgl+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql +"AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "od.Tanggal='"+Tgl+"'";
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "od.Tanggal='"+Tgl+"'";
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "od.Tanggal='"+Tgl+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" "
                        + "AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
            }
            else{
                sql = sql + "AND od.Tanggal='"+Tgl+"'";
            }
        }
        else if(rbAntarTanggal.isSelected()){
            java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
            java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
            if(cbOutlet.isSelected()){
                sql = sql +"AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbUser.isSelected()){
                sql = sql +"AND od.KodeUser="+KodeUser+" AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                        + "'"+TglAkhr+"'";
            }
            else if(cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeJenis="+KodeJenis+" AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                        + "'"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+"AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal "
                        + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+"AND od.KodeOutlet="+KodeOutlet+" AND "
                        + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                        + "'"+TglAkhr+"'";
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                        + "'"+TglAkhr+"'";
            }
            else if(cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                        + "'"+TglAkhr+"'";
            }
            else if(cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' "
                        + "AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND "
                        + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal "
                        + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" "
                        + "AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
            else{
                sql = sql + "AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
            }
        }
        else if(rbBulanan.isSelected()){
            if(cbOutlet.isSelected()){
                sql = sql +"AND od.KodeOutlet="+KodeOutlet+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbUser.isSelected()){
                sql = sql +"AND od.KodeUser="+KodeUser+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                        + "YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" "
                        + "AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                        + "YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                        + "YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                        + "YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                        + "YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND "
                        + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" "
                        + "AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                        + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" "
                        + "AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
            else{
                sql = sql+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
            }
        }
        else if(rbSemua.isSelected()){
            if(cbOutlet.isSelected()){
                sql = sql +"AND od.KodeOutlet="+KodeOutlet;
            }
            else if(cbUser.isSelected()){
                sql = sql +"AND od.KodeUser="+KodeUser;
            }
            else if(cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi;
            }
            else if(cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeJenis="+KodeJenis;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser;
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi;
            }
            else if(cbOutlet.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi;
            }
            else if(cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbOutlet.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
            }
            else if(cbOutlet.isSelected() && cbUser.isSelected() && cbJenisTransaksi.isSelected() && cbKodeJenis.isSelected()){
                sql = sql + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" "
                        + "AND od.KodeJenis="+KodeJenis;
            }
            else{
                sql = sql;
            }
        }
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan(JTable tblOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan(JTable tblOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan(JTable tblOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan1(JTable tblOrderan,int KodeOutlet){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan1(JTable tblOrderan,int KodeOutlet,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan1(JTable tblOrderan,int KodeOutlet,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan1(JTable tblOrderan,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan2(JTable tblOrderan,int KodeUser){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan2(JTable tblOrderan,int KodeUser,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan2(JTable tblOrderan,int KodeUser,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan2(JTable tblOrderan,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan3(JTable tblOrderan,int KodeBC){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan3(JTable tblOrderan,int KodeBC,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan3(JTable tblOrderan,int KodeBC,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan3(JTable tblOrderan,int KodeBC,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan4(JTable tblOrderan,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan4(JTable tblOrderan,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan4(JTable tblOrderan,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan4(JTable tblOrderan,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan5(JTable tblOrderan,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan5(JTable tblOrderan,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan5(JTable tblOrderan,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan5(JTable tblOrderan,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan6(JTable tblOrderan,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan6(JTable tblOrderan,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan6(JTable tblOrderan,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan6(JTable tblOrderan,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.StatusOrderan)="+Bulan+" AND YEAR(od.StatusOrderan)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan7(JTable tblOrderan,int KodeOutlet,int KodeUser){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) AND "
                + "od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan7(JTable tblOrderan,int KodeOutlet,int KodeUser,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) AND "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan7(JTable tblOrderan,int KodeOutlet,int KodeUser,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan7(JTable tblOrderan,int KodeOutlet,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan8(JTable tblOrderan,int KodeOutlet,int KodeBC){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan8(JTable tblOrderan,int KodeOutlet,int KodeBC,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan8(JTable tblOrderan,int KodeOutlet,int KodeBC,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan8(JTable tblOrderan,int KodeOutlet,int KodeBC,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan9(JTable tblOrderan,int KodeOutlet,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan9(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan9(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan9(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan10(JTable tblOrderan,int KodeOutlet,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan10(JTable tblOrderan,int KodeOutlet,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan10(JTable tblOrderan,int KodeOutlet,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan10(JTable tblOrderan,int KodeOutlet,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan11(JTable tblOrderan,int KodeOutlet,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan11(JTable tblOrderan,int KodeOutlet,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=3) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan11(JTable tblOrderan,int KodeOutlet,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan11(JTable tblOrderan,int KodeOutlet,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan12(JTable tblOrderan,int KodeUser,int KodeBC){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan12(JTable tblOrderan,int KodeUser,int KodeBC,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan12(JTable tblOrderan,int KodeUser,int KodeBC,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan12(JTable tblOrderan,int KodeUser,int KodeBC,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan13(JTable tblOrderan,int KodeUser,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan13(JTable tblOrderan,int KodeUser,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan13(JTable tblOrderan,int KodeUser,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan13(JTable tblOrderan,int KodeUser,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan14(JTable tblOrderan,int KodeUser,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan14(JTable tblOrderan,int KodeUser,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan14(JTable tblOrderan,int KodeUser,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan14(JTable tblOrderan,int KodeUser,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan15(JTable tblOrderan,int KodeUser,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan15(JTable tblOrderan,int KodeUser,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan15(JTable tblOrderan,int KodeUser,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1)"
                + "AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan15(JTable tblOrderan,int KodeUser,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan16(JTable tblOrderan,int KodeBC,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan16(JTable tblOrderan,int KodeBC,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan16(JTable tblOrderan,int KodeBC,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan16(JTable tblOrderan,int KodeBC,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan17(JTable tblOrderan,int KodeBC,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan17(JTable tblOrderan,int KodeBC,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan17(JTable tblOrderan,int KodeBC,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan17(JTable tblOrderan,int KodeBC,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan18(JTable tblOrderan,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) AND "
                + "od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan18(JTable tblOrderan,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan18(JTable tblOrderan,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan18(JTable tblOrderan,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan19(JTable tblOrderan,int JenisTransaksi,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan19(JTable tblOrderan,int JenisTransaksi,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan19(JTable tblOrderan,int JenisTransaksi,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan19(JTable tblOrderan,int JenisTransaksi,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan20(JTable tblOrderan,int JenisTransaksi,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan20(JTable tblOrderan,int JenisTransaksi,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan20(JTable tblOrderan,int JenisTransaksi,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan20(JTable tblOrderan,int JenisTransaksi,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.StatusOrderan="+StatusOrderan+" od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan21(JTable tblOrderan,int KodeJenis,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan21(JTable tblOrderan,int KodeJenis,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan21(JTable tblOrderan,int KodeJenis,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN '"+TglAwl+"' AND "
                + "'"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan21(JTable tblOrderan,int KodeJenis,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan22(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan22(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan22(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan22(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND MONTH(od.Tanggal)="+Bulan+" "
                + "AND YEAR(od.Tahun)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan23(JTable tblOrderan,int KodeOutlet,int KodeUser,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan23(JTable tblOrderan,int KodeOutlet,int KodeUser,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan23(JTable tblOrderan,int KodeOutlet,int KodeUser,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan23(JTable tblOrderan,int KodeOutlet,int KodeUser,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND "
                + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan24(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "and od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan24(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan24(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan24(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Bulan)="
                + Bulan+" AND YEAR(od.Tahun)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan25(JTable tblOrderan,int KodeOutlet,int KodeUser,int StatusOderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan25(JTable tblOrderan,int KodeOutlet,int KodeUser,int StatusOderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOderan+" AND "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan25(JTable tblOrderan,int KodeOutlet,int KodeUser,int StatusOderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOderan+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan25(JTable tblOrderan,int KodeOutlet,int KodeUser,int StatusOderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.StatusOrderan="+StatusOderan+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan26(JTable tblOrderan,int KodeOutlet,int KodeBC,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan26(JTable tblOrderan,int KodeOutlet,int KodeBC,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan26(JTable tblOrderan,int KodeOutlet,int KodeBC,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan26(JTable tblOrderan,int KodeOutlet,int KodeBC,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tahun)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan27(JTable tblOrderan,int KodeOutlet,int KodeBC,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan27(JTable tblOrderan,int KodeOutlet,int KodeBC,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan27(JTable tblOrderan,int KodeOutlet,int KodeBC,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan27(JTable tblOrderan,int KodeOutlet,int KodeBC,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" "
                + "AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan28(JTable tblOrderan,int KodeOutlet,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan28(JTable tblOrderan,int KodeOutlet,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan28(JTable tblOrderan,int KodeOutlet,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan28(JTable tblOrderan,int KodeOutlet,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan29(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOotlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan29(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan29(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeeJenis="+KodeJenis+" AND "
                + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan29(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan30(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan30(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan30(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan30(JTable tblOrderan,int KodeOutlet,int JenisTransaksi,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan31(JTable tblOrderan,int KodeOutlet,int KodeJenis,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan31(JTable tblOrderan,int KodeOutlet,int KodeJenis,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal="
                + "'"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan31(JTable tblOrderan,int KodeOutlet,int KodeJenis,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan31(JTable tblOrderan,int KodeOutlet,int KodeJenis,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "MONTH(od.Bulan)="+Bulan+" AND YEAR(od.Tahun)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan32(JTable tblOrderan,int KodeUser,int KodeBC,int JenisTransaksi){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan32(JTable tblOrderan,int KodeUser,int KodeBC,int JenisTransaksi,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan32(JTable tblOrderan,int KodeUser,int KodeBC,int JenisTransaksi,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan32(JTable tblOrderan,int KodeUser,int KodeBC,int JenisTransaksi,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.JenisTransaksi="+JenisTransaksi+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan33(JTable tblOrderan,int KodeUser,int KodeBC,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan33(JTable tblOrderan,int KodeUser,int KodeBC,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan33(JTable tblOrderan,int KodeUser,int KodeBC,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal BETWEEN '"+TglAwl+"' "
                + "AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan33(JTable tblOrderan,int KodeUser,int KodeBC,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="+Bulan+" AND "
                + "YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan34(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan34(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan34(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan34(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan35(JTable tblOrderan,int KodeUser,int JenisTransaksi,int KodeJenis){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan35(JTable tblOrderan,int KodeUser,int JenisTransaksi,int KodeJenis,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal="
                + "'"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan35(JTable tblOrderan,int KodeUser,int JenisTransaksi,int KodeJenis,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan35(JTable tblOrderan,int KodeUser,int JenisTransaksi,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.KodeJenis="+KodeJenis+" AND MONTH(od.Tanggal)="
                + Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan36(JTable tblOrderan,int KodeUser,int JenisTransaksi,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan36(JTable tblOrderan,int KodeUser,int JenisTransaksi,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan36(JTable tblOrderan,int KodeUser,int JenisTransaksi,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan36(JTable tblOrderan,int KodeUser,int JenisTransaksi,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.JenisTransaksi="+JenisTransaksi+" AND od.StatusOrderan="+StatusOrderan+" AND "
                + "MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan37(JTable tblOrderan,int KodeUser,int KodeJenis,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan37(JTable tblOrderan,int KodeUser,int KodeJenis,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan37(JTable tblOrderan,int KodeUser,int KodeJenis,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan37(JTable tblOrderan,int KodeUser,int KodeJenis,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeJenis="+KodeJenis+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="
                + Tahun+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan38(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan38(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan38(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan38(JTable tblOrderan,int KodeUser,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan39(JTable tblOrderan,int KodeJenis,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan39(JTable tblOrderan,int KodeJenis,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan39(JTable tblOrderan,int KodeJenis,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND od.Tanggal BETWEEN "
                + "'"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan39(JTable tblOrderan,int KodeJenis,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeJenis="+KodeJenis+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan+" AND MONTH(od.Tanggal)="
                + Bulan+" AND od.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan40(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int StatusOrderan){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "ANd od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan40(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int StatusOrderan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan
                + " AND od.Tangal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan40(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int StatusOrderan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan
                + " AND od.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void getOrderan40(JTable tblOrderan,int KodeOutlet,int KodeUser,int KodeBC,int StatusOrderan,int Bulan,int Tahun){
        sql = "SELECT ol.NamaOutlet,i.NamaLengkap,b.NamaBC,DATE_FORMAT(od.Tanggal),CASE WHEN (od.JenisTransaksi=1) THEN 'Pembelan' "
                + "WHEN (od.JenisTransaksi=2) THEN 'Penjualan' END,j.NamaJenis,od.SubTotal,od.PPN,od.GrandTotal,"
                + "CASE WHEN (od.StatusOrderan=1) THEN 'Disiapkan' WHEN (od.StatusOrderan=2) THEN 'Dikirim' WHEN(od.StatusOrderan=2) "
                + "THEN 'Diterima' END,DATE_FORMAT(od.TglExpire) FROM orderan od INNER JOIN outlet ol INNER JOIN user u INNER JOIN "
                + "identitas i INNER JOIN businesscontact b INNER JOIN jenispembayaran j ON (od.KodeOutlet=ol.KodeOutlet AND "
                + "od.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND od.KodeBC=b.KodeBC AND od.KodeJenis=j.KodeJenis) WHERE (1=1) "
                + "AND od.KodeOutlet="+KodeOutlet+" AND od.KodeUser="+KodeUser+" AND od.KodeBC="+KodeBC+" AND od.StatusOrderan="+StatusOrderan
                + "AND MONTH(od.Tanggal)="+Bulan+" AND YEAR(od.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOrderan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","User","Business Contact","Tanggal","Jenis Transaksi","Jenis Pembayaran","Sub Total","PPN",
                                    "Grand Total","Status Orderan","Tgl Expire"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,
                                    Double.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblOrderan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //User
                rowdata[2] = rs.getString(3); //BusinessContact
                rowdata[3] = rs.getString(4); //Tanggal
                rowdata[4] = rs.getString(5); //JenisTransaksi
                rowdata[5] = rs.getString(6); //JenisPembayaran
                rowdata[6] = rs.getDouble(7); //SubTotal
                rowdata[7] = rs.getDouble(8); //PPN
                rowdata[8] = rs.getDouble(9); //GrandTotal
                rowdata[9] = rs.getString(10); //StatusOrderan
                rowdata[10] = rs.getString(11); //TglExpire
                
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
    public void Simpan(int KodeOutlet,int KodeUser,int KodeBC,Calendar Tanggal,int JenisTransaksi,int KodeJenis,Double SubTotal,
            Double PPN,Double GrandTotal,int StatusOrderan,Calendar TglExpire) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "INSERT INTO orderan (KodeOutlet,KodeUser,KodeBC,Tanggal,JenisTransaksi,KodeJenis,SubTotal,PPN,GrandTotal,StatusOrderan,TglExpire) "
                + "VALUES ("+KodeOutlet+","+KodeUser+","+KodeBC+",'"+Tgl+"',"+JenisTransaksi+","+KodeJenis+","+SubTotal+","+PPN+","+GrandTotal+","
                + StatusOrderan+",'"+TglExp+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeOrderan = rs.getInt(1);
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
        sql = "INSERT INTO orderan (KodeOutlet,KodeUser,KodeBC,Tanggal,JenisTransaksi,KodeJenis,SubTotal,PPN,GrandTotal,StatusOrderan,TglExpire) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setInt(2, KodeBC);
            PS.setDate(3, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setInt(4, JenisTransaksi);
            PS.setInt(5, KodeJenis);
            PS.setDouble(6, SubTotal);
            PS.setDouble(7, PPN);
            PS.setDouble(8, GrandTotal);
            PS.setInt(9, StatusOrderan);
            PS.setDate(10, new java.sql.Date(TglExpire.getTimeInMillis()));
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeOrderan = rs.getInt(1);
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
        sql = "SELECT KodeOutlet,KodeBC,Tanggal,JenisTransaksi,KodeJenis,SubTotal,PPN,GrandTotal,StatusOrderan,TglExpire FROM orderan "
                + "WHERE KodeOrderan="+KodeOrderan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOutlet = rs.getInt(1);
            KodeBC = rs.getInt(2);
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(3));
            JenisTransaksi = rs.getInt(4);
            KodeJenis = rs.getInt(5);
            SubTotal = rs.getDouble(6);
            PPN = rs.getDouble(7);
            GrandTotal = rs.getDouble(8);
            StatusOrderan = rs.getInt(9);
            TglExpire = Calendar.getInstance();
            TglExpire.setTime(rs.getDate(10));
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
        sql = "DELETE FROM orderan";
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
    public void Hapus(int KodeOrderan) throws SQLException{
        sql = "DELETE FROM orderan WHERE KodeOrderan="+KodeOrderan;
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
