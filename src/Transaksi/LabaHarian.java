/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import java.util.*;
import Util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class LabaHarian {
    
    private int KodeLB;
    private int KodeOutlet;
    private int KodeUser;
    private int KodeJenis;
    private int KodeSift;
    private int Tanggal;
    private int Bulan;
    private int Tahun;
    private Double TotalModal;
    private Double TotalJual;
    private Double TotalDiskon;
    private Double KasAktual;
    private Double TotalVariance;
    private int TotalNota;
    
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
        sql = "SELECT KodeLB FROM labaharian WHERE KodeLB="+Kode;
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
    public int getKodeLB(int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT KodeLB FOM labaharian WHERE KodeOutlet="+KodeOutlet+" AND KodeUser="+KodeUser+" AND KodeJenis="+KodeJenis+" AND "
                + "KodeSift="+KodeSift+" AND Tanggal="+Tanggal+" AND Bulan="+Bulan+" AND Tahun="+Tahun;
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
        sql = "SELECT KodeLB FROM labaharian WHERE KodeLB=(SELECT MAX(KodeLB) FROM labaharian)";
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
    public int getLastKodeLB(int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT KodeLB FROM labaharian WHERE KodeLB = (SELECT MAX(KodeLB) FROM labaharian WHERE KodeOutlet="+KodeOutlet+" AND KodeUser="
                +KodeUser+" AND "+"KodeJenis="+KodeJenis+" AND KodeSift="+KodeSift+" AND Tanggal="+Tanggal+" AND Bulan="+Bulan+" AND Tahun="
                +Tahun+")";
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
    public void setKodeOutlet(int KodeOutlet){
        this.KodeOutlet = KodeOutlet;
    }
    public int getKodeOutlet(){
        return KodeOutlet;
    }
    public int getKodeOutlet(int KodeLB){
        sql = "SELECT KodeOutlet FROM labaharian WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET KodeOutlet="+KodeOutlet+" WHERE KodeLB="+KodeLB;
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
    public int getKodeUser(int KodeLB){
        sql = "SELECT KodeUser FROM labaharian WHERE KodeLB="+KodeLB;
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
    public void UpdateKodeUser(int KodeLB,int KodeUser) throws SQLException{
        sql = "UPDATE labaharian SET KodeUser="+KodeUser+" AND KodeLB="+KodeLB;
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
        sql = "SELECT KodeJenis FROM labaharian WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET KodeJenis="+KodeJenis+" WHERE KodeLB="+KodeLB;
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
    public void setKodeSift(int KodeSift){
        this.KodeSift = KodeSift;
    }
    public int getKodeSift(){
        return KodeSift;
    }
    public int getKodeSift(int KodeLB){
        sql = "SELECT KodeSift FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeSift = rs.getInt(1);
                return KodeSift;
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
    public void UpdateKodeSift(int KodeLB,int KodeSift) throws SQLException{
        sql = "UPDATE labaharian SET KodeSift="+KodeSift+" WHERE KodeLB="+KodeLB;
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
    public void setTanggal(int Tanggal){
        this.Tanggal = Tanggal;
    }
    public int getTanggal(){
        return Tanggal;
    }
    public int getTanggal(int KodeLB){
        sql = "SELECT Tanggal FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Tanggal = rs.getInt(1);
                return Tanggal;
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
    public void UpdateTanggal(int KodeLB,int Tanggal) throws SQLException{
        sql = "UPDATE labaharian SET Tanggal="+Tanggal+" WHERE KodeLB="+KodeLB;
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
    public void setBulan(int Bulan){
        this.Bulan = Bulan;
    }
    public int getBulan(){
        return Bulan;
    }
    public int getBulan(int KodeLB){
        sql = "SELECT Bulan FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Bulan = rs.getInt(1);
                return Bulan;
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
    public void UpdateBulan(int KodeLB,int Bulan) throws SQLException{
        sql = "UPDATE labaharian SET Bulan="+Bulan+" WHERE KodeLB="+KodeLB;
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
    public void setTahun(int Tahun){
        this.Tahun = Tahun;
    }
    public int getTahun(){
        return Tahun;
    }
    public int getTahun(int KodeLB){
        sql = "SELECT Tahun FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Tahun = rs.getInt(1);
                return Tahun;
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
    public void UpdateTahun(int KodeLB,int Tahun) throws SQLException{
        sql = "UPDATE labaharian SET Tahun="+Tahun+" AND KodeLB="+KodeLB;
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
        sql = "SELECT TotalModal FROM labaharian WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalModal(int Tgl,int Bln,int Tahun){
        sql = "SELECT SUM(TotalModal) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Tahun;
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
    public Double GrandTotalModal(int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
        sql = "SELECT SUM(TotalModal) FROM labaharian WHERE (Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
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
    public Double getGrandTotalModal(int Bln,int Tahun){
        sql = "SELECT SUM(TotalModal) FROM labaharian WHERE Bulan="+Bln+" AND Tahun="+Tahun;
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
        sql = "UPDATE labaharian SET TotalModal="+TotalModal+" AND KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET TotalModal=TotalModal+"+TotalModal+" AND KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET TotalModal=TotalModal-"+TotalModal+" AND KodeLB="+KodeLB;
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
        sql = "SELECT TotalJual FROM labaharian WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalJual(int Tgl,int Bln,int Thn){
        sql = "SELECT SUM(TotalJual) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Thn;
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
    public Double getGrandTotalJual(int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
         sql = "SELECT SUM(TotalJual) FROM labaharian WHERE (Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
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
    public Double getGrandTotalJual(int Bln,int Tahun){
        sql = "SELECT SUM(TotalJual) FROM labaharian WHERE Bulan="+Bln+" AND Tahun="+Tahun;
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
        sql = "UPDATE labaharian SET TotalJual="+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET TotalJual=TotalJual+"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET TotalJual=TotalJual-"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalDiskon FROM labaharian WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalDiskon(int Tgl,int Bln,int Thn){
        sql = "SELECT TotalDiskon FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Thn;
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
    public Double getGrandTotalDiskon(int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
         sql = "SELECT SUM(TotalDiskon) FROM labaharian WHERE (Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
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
    public Double getGrandTotalDiskon(int Bln,int Tahun){
        sql = "SELECT TotalDiskon FROM labaharian WHERE Bulan="+Bln+" AND Tahun="+Tahun;
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
        sql = "UPDATE labaharian SET TotalDiskon="+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labaharian SET TotalDiskon=TotalDiskon+"+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
    public void setKasAktual(Double KasAktual){
        this.KasAktual = KasAktual;
    }
    public Double getKasAktual(){
        return KasAktual;
    }
    public Double getKasAktual(int KodeLB){
        sql = "SELECT KasAktual FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KasAktual = rs.getDouble(1);
                return KasAktual;
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
    public void UpdateKasAktual(int KodeLB,Double KasAktual) throws SQLException{
        sql = "UPDATE labaharian SET KasAktual="+KasAktual+" AND KodeLB="+KodeLB;
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
    public void TambahKasAktual(int KodeLB,Double KasAktual) throws SQLException{
        sql = "UPDATE labaharian SET KasAktual = KasAktual + "+KasAktual+" WHERE KodeLB="+KodeLB;
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
    public void KurangiKasAktual(int KodeLB,Double KasAktual) throws SQLException{
        sql = "UPDATE labaharian SET KasAktual = KasAktual - "+KasAktual+" WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalKasAktual(int Tgl,int Bln,int Thn){
        sql = "SELECT SUM(KasAktual) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND YEAR="+Thn;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KasAktual = rs.getDouble(1);
                return KasAktual;
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
    public Double getGrandTotalKasAktual(int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
         sql = "SELECT SUM(KasAktual) FROM labaharian WHERE (Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
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
    public Double getGrandTotalKasAktual(int Bln,int Thn){
        sql = "SELECT SUM(KasAktual) FROM labaharian WHERE Bulan="+Bln+" AND YEAR="+Thn;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KasAktual = rs.getDouble(1);
                return KasAktual;
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
    public void setTotalVariance(Double TotalVariance){
        this.TotalVariance = TotalVariance;
    }
    public Double getTotalVariance(){
        return TotalVariance;
    }
    public Double getTotalVariance(int KodeLB){
        sql = "SELECT TotalVariance FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public Double getGrandTotalVariance(int Tgl,int Bln,int Tahun){
        sql = "SELECT SUM(TotalVariance) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public Double getGrandTotalVariance1(int KodeOutlet,int Tgl,int Bln,int Tahun){
        sql = "SELECT SUM(TotalVariance) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Tahun+" AND "
                + "KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public Double getGrandTotalVariance2(int KodeJenis,int Tgl,int Bln,int Tahun){
        sql = "SELECT SUM(TotalVariance) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Tahun+" AND "
                + "KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public Double getGrandTotalVariance3(int KodeOutlet,int KodeJenis,int Tgl,int Bln,int Tahun){
        sql = "SELECT SUM(TotalVariance) FROM labaharian WHERE Tanggal="+Tgl+" AND Bulan="+Bln+" AND Tahun="+Tahun+" AND "
                + "KodeOutlet="+KodeOutlet+" AND KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public Double getGrandTotalVariance(int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
         sql = "SELECT SUM(Variance) FROM labaharian WHERE (Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
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
    public Double getGrandTotalVariance(int Bln,int Thn){
        sql = "SELECT SUM(TotalVariance) FROM labaharian WHERE Bulan="+Bln+" AND Tahun="+Thn;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalVariance = rs.getDouble(1);
                return TotalVariance;
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
    public void UpdateTotalVariance(int KodeLB,Double TotalVariance) throws SQLException{
        sql = "UPDATE labaharian SET TotalVariance="+TotalVariance+" WHERE KodeLB="+KodeLB;
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
    public void TambahTotalVariance(int KodeLB,Double TotalVariance) throws SQLException{
        sql = "UPDATE labaharian SET TotalVariance=TotalVariance+"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
    public void KurangiTotalVariance(int KodeLB,Double TotalVariance) throws SQLException{
        sql = "UPDATE labaharian SET TotalVariance=TotalVariance-"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
    public void setTotalNota(int TotalNota){
        this.TotalNota = TotalNota;
    }
    public int getTotalNota(){
        return TotalNota;
    }
    public int getTotalNota(int KodeLB){
        sql = "SELECT TotalNota FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TotalNota = rs.getInt(1);
                return TotalNota;
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
    public void UpdateTotalNota(int KodeLB,int TotalNota) throws SQLException{
        sql = "UPDATE labaharian SET TotalNota="+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void TambahTotalNota(int KodeLB,int TotalNota) throws SQLException{
        sql = "UPDATE labaharian SET TotalNota=TotalNota+"+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void KurangiTotalNota(int KodeLB,int TotalNota) throws SQLException{
        sql = "UPDATE labaharian SET TotalNota=TotalNota-"+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void getLabaHarian(JTable tblLaba){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian(JTable tblLaba,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian(JTable tblLaba,int TglAwal,int TglAkhir,int BlnAwal,int BlnAkhir,int ThnAwal,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "(l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (l.Bulan BETWEEN "+BlnAwal+" AND "+BlnAkhir+") AND (l.Tahun BETWEEN "
                + ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian(JTable tblLaba,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian1(JTable tblLaba,int KodeOutlet){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian1(JTable tblLaba,int KodeOutlet,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian1(JTable tblLaba,int KodeOtlet,int TglAwal,int TglAkhir,int BlnAwal,int BlnAkhir,int ThnAwal,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOtlet+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (l.Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian1(JTable tblLaba,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian2(JTable tblLaba,int KodeUser){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian2(JTable tblLaba,int KodeUser,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian2(JTable tblLaba,int KodeUser,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "AND l.KodeuSer="+KodeUser+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (l.Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian2(JTable tblLaba,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian3(JTable tblLaba,int KodeJenis){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian3(JTable tblLaba,int KodeJenis,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian3(JTable tblLaba,int KodeJenis,int TglAwal,int TglAkhir,int BlnAwal,int BlnAkhir,int ThnAwal,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (l.Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian3(JTable tblLaba,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian4(JTable tblLaba,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian4(JTable tblLaba,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian4(JTable tblLaba,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "AND l.KodeSift="+KodeSift+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND (l.Bulan BETWEEN "+BlnAwal+" AND "
                + BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian4(JTable tblLaba,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian5(JTable tblLaba,int KodeOutlet,int KodeUser){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian5(JTable tblLaba,int KodeOutlet,int KodeUser,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian5(JTable tblLaba,int KodeOutlet,int KodeUser,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND "
                + "(l.Bulan BETWEEN "+BlnAwal+" AND "+BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian5(JTable tblLaba,int KodeOutlet,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian6(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian6(JTable tblLaba,int KodeOutlet,int KodeJenis,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian6(JTable tblLaba,int KodeOutlet,int KodeJenis,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) "
                + "AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND "
                + "(l.Bulan BETWEEN "+BlnAwal+" AND "+BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian6(JTable tblLaba,int KodeOutlet,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian7(JTable tblLaba,int KodeOutlet,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian7(JTable tblLaba,int KodeOutlet,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian7(JTable tblLaba,int KodeOutlet,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeSift="+KodeSift+" AND (l.Tanggal BETWEEN "+TglAwal+" AND "+TglAkhir+") AND "
                + "(l.Bulan BETWEEN "+BlnAwal+" AND "+BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian7(JTable tblLaba,int KodeOutlet,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian8(JTable tblLaba, int KodeUser,int KodeJenis){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian8(JTable tblLaba, int KodeUser,int KodeJenis,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian8(JTable tblLaba,int KodeUser,int KodeJenis,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Tanggal BETWEEN ("+TglAwal+" AND "+TglAkhir+") AND l.Bulan "
                + "BETWEEN ("+BlnAwal+" AND "+BlnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian8(JTable tblLaba,int KodeUser,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian9(JTable tblLaba,int KodeUser,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian9(JTable tblLaba, int KodeUser,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian9(JTable tblLaba,int KodeUser,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,int BlnAkhir,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.TglAwal BETWEEN ("+TglAwal+" AND "+TglAkhir+") AND l.Bulan "
                + "BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN ("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian9(JTable tblLaba,int KodeUser,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian10(JTable tblLaba,int KodeJenis,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian10(JTable tblLaba,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian10(JTable tblLaba,int KodeJenis,int KodeSift,int TglAwal,int TglAkhir,int BlnAwal,int BlnAkhir,int ThnAwal,
            int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.KodeSft="+KodeSift+" AND l.Tanggal BETWEEN ("+TglAwal+" AND "+TglAkhir+") AND "
                + "l.Bulan BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN ("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian10(JTable tblLaba,int KodeJenis,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian11(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian11(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Tanggal="+Tanggal+" AND "
                + "l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian11(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,
            int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Tanggal BETWEEN ("+TglAwal+" AND "
                + TglAkhir+") AND l.Bulan BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN ("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian11(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian12(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian12(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="
                + Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian12(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,
            int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.Tanggal BETWEEN ("+TglAwal+" AND "
                + TglAkhir+") AND l.Bulan BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN ("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian12(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian13(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian13(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="
                + Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian13(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,
            int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.Tanggal BETWEEN ("+TglAwal+" AND "+TglAkhir+") AND l.Bulan BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN "
                + "("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getlabaHarian13(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian14(JTable tblLaba,int KodeUser,int KodeJenis,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian14(JTable tblLaba,int KodeUser,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Tanggal="+Tanggal+" AND l.Bulan="
                + Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian14(JTable tblLaba,int KodeUser,int KodeJenis,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,int TglAkhir,
            int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.Tanggal BETWEEN ("+TglAwal+" AND "+TglAkhir+") AND l.Bulan BETWEEN ("+BlnAwal+" AND "+BlnAkhir+") AND l.Tahun BETWEEN "
                + "("+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian14(JTable tblLaba,int KodeUser,int KodeJenis,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian15(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian15(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND "
                + "l.Tanggal="+Tanggal+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian15(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int TglAwal,int BlnAwal,int ThnAwal,
            int TglAkhir,int BlnAkhir,int ThnAkhir){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND l.Tanggal "
                + "(BETWEEN "+TglAwal+" AND "+TglAkhir+") AND l.Bulan (BETWEEN "+BlnAwal+" AND "+BlnAkhir+") AND (l.Tahun BETWEEN "+ThnAwal+" AND "
                + ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaHarian15(JTable tblLaba,int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int Bulan,int Tahun){
        sql = "SELECT CONCAT(l.Tanggal,'-',l.Bulan,'-',l.Tahun),o.NamaOutlet,s.Sift,i.NamaLengkap,j.NamaJenis,l.TotalModal,l.TotalJual,"
                + "(l.TotalJual-l.TotalModal),l.TotalDiskon,l.KasAktual,l.TotalVariance,l.TotalNota FROM labaharian l INNER JOIN outlet o "
                + "INNER JOIN user u INNER JOIN identitas i INNER JOIN jenispembayaran j INNER JOIN sift s ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas AND l.KodeSift=s.KodeSift AND l.KodeJenis=j.KodeJEnis) WHERE (1=1) AND "
                + "l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.KodeJenis="+KodeJenis+" AND l.KodeSift="+KodeSift+" AND "
                + "l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Tanggal","Outlet","Sift","User","Jenis Pembayaran","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Kas Aktual","Total Variance","Total Struk"};
                Class ColType[] = {String.class,String.class,Integer.class,String.class,String.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Double.class,Integer.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 12;
                }
            });
            
            Object rowdata[] = new Object[12];
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getInt(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getDouble(6);
                rowdata[6] = rs.getDouble(7);
                rowdata[7] = rs.getDouble(8);
                rowdata[8] = rs.getDouble(9);
                rowdata[9] = rs.getDouble(10);
                rowdata[10] = rs.getDouble(11);
                rowdata[11] = rs.getInt(12);
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(80);
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(50);
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100);
            tblLaba.getColumnModel().getColumn(11).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan(int KodeOutlet,int KodeUser,int KodeJenis,int KodeSift,int Tanggal,int Bulan,int Tahun,Double TotalModal,Double TotalJual,
            Double TotalDiskon,Double KasAktual,Double TotalVariance,int TotalNota) throws SQLException{
        sql = "INSERT INTO labaharian (KodeOutlet,KodeUser,KodeJenis,KodeSift,Tanggal,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,KasAktual,"
                + "TotalVariance,TotalNota) VALUES ("+KodeOutlet+","+KodeUser+","+KodeJenis+","+KodeSift+","+Tanggal+","+Bulan+","+Tahun+","
                + TotalModal+","+TotalJual+","+TotalDiskon+","+KasAktual+","+TotalVariance+","+TotalNota+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
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
    public void Simpan() throws SQLException{
        sql = "INSERT INTO labaharian (KodeOutlet,KodeUser,KodeJenis,KodeSift,Tanggal,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,KasAktual,"
                + "TotalVariance,TotalNota) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setInt(2, KodeUser);
            PS.setInt(3, KodeJenis);
            PS.setInt(4, KodeSift);
            PS.setInt(5, Tanggal);
            PS.setInt(6, Bulan);
            PS.setInt(7, Tahun);
            PS.setDouble(8, TotalModal);
            PS.setDouble(9, TotalJual);
            PS.setDouble(10, TotalDiskon);
            PS.setDouble(11, KasAktual);
            PS.setDouble(12, TotalVariance);
            PS.setDouble(13, TotalNota);
            
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
    public void Query() throws SQLException{
        sql = "SELECT KodeOutlet,KodeUser,KodeJenis,KodeSift,Tanggal,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,KasAktual,TotalVariance,"
                + "TotalNota FROM labaharian WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return ;
            }
            KodeOutlet = rs.getInt(1);
            KodeUser = rs.getInt(2);
            KodeJenis = rs.getInt(3);
            KodeSift = rs.getInt(4);
            Tanggal = rs.getInt(5);
            Bulan = rs.getInt(6);
            Tahun = rs.getInt(7);
            TotalModal = rs.getDouble(8);
            TotalJual = rs.getDouble(9);
            TotalDiskon = rs.getDouble(10);
            KasAktual = rs.getDouble(11);
            TotalVariance = rs.getDouble(12);
            TotalNota = rs.getInt(13);
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
        sql = "DELETE FROM labaharian";
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
        sql = "DELETE FROM labaharian WHERE KodeLB="+KodeLB;
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
