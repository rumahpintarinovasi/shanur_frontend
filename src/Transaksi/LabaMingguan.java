/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import Util.*;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class LabaMingguan {
    
    private int KodeLB;
    private int KodeOutlet;
    private int KodeJenis;
    private int KodeUser;
    private int Minggu;
    private int Bulan;
    private int Tahun;
    private Double TotalModal;
    private Double TotalJual;
    private Double TotalDiskon;
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
        sql = "SELECT KodeLB FROM labamingguan WHERE KodeLB="+Kode;
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
    public int getKodeLB(int KodeOutlet,int KodeJenis,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT KodeLB FROM labamingguan WHERE KodeOutlet="+KodeOutlet+" AND KodeJenis="+KodeJenis+" AND KodeUser="+KodeUser+" AND "
                + "Minggu="+Minggu+" AND Bulan="+Bulan+" AND Tahun="+Tahun;
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
    public int getLastKodeLB(int KodeOutlet,int KodeJenis,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT KodeLB FROM labamingguan WHERE KodeLB = (SELECT MAX(KodeLB) FROM labamingguan WHERE KodeOutlet="+KodeOutlet+" AND "
                + "KodeJenis="+KodeJenis+" AND KodeUser="+KodeUser+" AND Minggu="+Minggu+" AND Bulan="+Bulan+" AND Tahun="+Tahun+")";
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
        sql = "SELECT KodeOutlet FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET KodeOutlet="+KodeOutlet+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT KodeJenis FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET KodeJenis="+KodeJenis+" AND KodeLB="+KodeLB;
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
        sql = "SELECT KodeUser FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET KodeUser="+KodeUser+" WHERE KodeLB="+KodeLB;
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
    public void setMinggu(int Minggu){
        this.Minggu = Minggu;
    }
    public int getMinggu(){
        return Minggu;
    }
    public int getMinggu(int KodeLB){
        sql = "SELECT Minggu FROM labamingguan WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Minggu = rs.getInt(1);
                return Minggu;
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
    public void UpdateMinggu(int KodeLB,int Minggu) throws SQLException{
        sql = "UPDATE labamingguan SET Minggu="+Minggu+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT Bulan FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET Bulan="+Bulan+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT Tahun FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET Tahun="+Tahun+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalModal FROM labamingguan WHERE KodeLB="+KodeLB;
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
    public Double GrandTotalModal(int Mgg,int Bln,int Thn){
        sql = "SELECT SUM(TotalModal) FROM labamingguan WHERE Minggu="+Mgg+" AND Bulan="+Bln+" AND Tahun="+Thn;
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
    public Double getGrandTotalModal(int Bln,int Thn){
        sql = "SELECT SUM(TotalModal) FROM labamingguan WHERE Bulan="+Bln+" AND Tahun="+Thn;
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
        sql = "UPDATE labamingguan SET TotalModal="+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalModal = TotalModal + "+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalModal = TotalModal - "+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalJual FROM labamingguan WHERE KodeLB="+KodeLB;
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
                } catch (Exception e) {
                }
            }
        }
    }
    public Double getGrandTotalJual(int Mgg,int Bln,int Thn){
        sql = "SELECT SUM(TotalJual) FROM labamingguan WHERE Minggu="+Mgg+" AND Bulan="+Bln+" AND Tahun="+Thn;
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
                } catch (Exception e) {
                }
            }
        }
    }
    public Double GrandTotalJual(int Bln,int Thn){
        sql = "SELECT SUM(TotalJual) FROM labamingguan WHERE Bulan="+Bln+" AND Tahun="+Thn;
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
                } catch (Exception e) {
                }
            }
        }
    }
    public void UpdateTotalJual(int KodeLB,Double TotalJual) throws SQLException{
        sql = "UPDATE labamingguan SET TotalJual="+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalJual = TotalJual + "+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalJual = TotalJual - "+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalDiskon FROM labamingguan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalDiskon(int Mgg,int Bln,int Thn){
        sql = "SELECT SUM(TotalDiskon) FROM labamingguan WHERE Minggu="+Mgg+" AND Bulan="+Bln+" AND Tahun="+Thn;
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
    public Double getGrandTotalDiskon(int Bln,int Thn){
        sql = "SELECT SUM(TotalDiskon) FROM labamingguan WHERE Bulan="+Bln+" AND Tahun="+Thn;
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
        sql = "UPDATE labamingguan SET TotalDiskon="+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalDiskon = TotalDiskon + "+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalDiskon = TotalDiskon - "+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalNota FROM labamingguan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalNota = "+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalNota = TotalNota + "+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labamingguan SET TotalNota = TotalNota - "+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void getLabaMingguan(JTable tblLaba){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan(JTable tblLaba,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.Minggu="+Minggu
                + " AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan(JTable tblLaba,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.Bulan="+Bulan
                + " AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan1(JTable tblLaba,int KodeOutlet){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan1(JTable tblLaba,int KodeOutlet,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan1(JTable tblLaba,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan2(JTable tblLaba,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="
                + KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan2(JTable tblLaba,int KodeJenis,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="
                + KodeJenis+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan2(JTable tblLaba,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="
                + KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan3(JTable tblLaba,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="
                + KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan3(JTable tblLaba,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="
                + KodeUser+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan3(JTable tblLaba,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="
                + KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan4(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Minggu
                rowdata[4] = rs.getString(5); //Bulan
                rowdata[5] = rs.getDouble(6); //TotalModal
                rowdata[6] = rs.getDouble(7); //TotalPenjualan
                rowdata[7] = rs.getDouble(8); //LabaRugi
                rowdata[8] = rs.getDouble(9); //TotalDiskon
                rowdata[9] = rs.getDouble(10); //TotalVariance
                rowdata[10] = rs.getInt(11); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(10).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan5(JTable tblLaba,int KodeOutlet,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan5(JTable tblLaba,int KodeOutlet,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan5(JTable tblLaba,int KodeOutlet,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan6(JTable tblLaba,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJeinis="
                + KodeJenis+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan6(JTable tblLaba,int KodeJenis,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="
                + KodeJenis+" AND l.KodeUser="+KodeUser+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan6(JTable tblLaba,int KodeJenis,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="
                + KodeJenis+" AND l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int Minggu,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser+" AND l.Minggu="+Minggu+" AND l.Bulan="+Bulan+" "
                + "AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaMingguan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,CONCAT('Minggu ke-',l.Minggu) AS Minggu,"
                + "CASE WHEN l.Bulan=1 THEN CONCAT('Januari',',',l.Tahun) "
                + "WHEN l.Bulan=2 THEN CONCAT('Februari',',',l.Tahun) "
                + "WHEN l.Bulan=3 THEN CONCAT('Maret',',',l.Tahun) "
                + "WHEN l.Bulan=4 THEN CONCAT('April',',',l.Tahun) "
                + "WHEN l.Bulan=5 THEN CONCAT('Mei',',',l.Tahun) "
                + "WHEN l.Bulan=6 THEN CONCAT('Juni',',',l.Tahun) "
                + "WHEN l.Bulan=7 THEN CONCAT('Juli',',',l.Tahun) "
                + "WHEN l.Bulan=8 THEN CONCAT('Agustus',',',l.Tahun) "
                + "WHEN l.Bulan=9 THEN CONCAT('September',',',l.Tahun) "
                + "WHEN l.Bulan=10 THEN CONCAT('Oktober',',',l.Tahun) "
                + "WHEN l.Bulan=11 THEN CONCAT('November',',',l.Tahun) "
                + "WHEN l.Bulan=12 THEN CONCAT('Desember',',',l.Tahun) END AS Bulan,l.TotalModal,"
                + "l.TotalJual,(l.TotalJual-l.TotalModal),l.TotalDiskon,l.TotalVariance,l.TotalNota FROM labamingguan l INNER JOIN "
                + "outlet o INNER JOIN jenispembayaran j INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND "
                + "l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="
                + KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","Minggu","Bulan","Total Modal","Total Penjualan","Laba/Rugi","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class,Double.class,
                                    Double.class,Integer.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblLaba.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //JenisPembayaran
                rowdata[2] = rs.getString(3); //Minggu
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //LabaRugi
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //Minggu
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //LabaRugi
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotaVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(100); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    
    public void Simpan(int KodeOutlet,int KodeJenis,int KodeUser,int Minggu,int Bulan,int Tahun,Double TotalModal,
            Double TotalJual,Double TotalDiskon,Double TotalVariance,int TotalNota) throws SQLException{
        sql = "INSERT INTO labamingguan (KodeOutlet,KodeJenis,KodeUser,Minggu,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,"
                + "TotalVariance,TotalNota) VALUES("+KodeOutlet+","+KodeJenis+","+KodeUser+","+Minggu+","+Bulan+","+Tahun+","+TotalModal+","
                + TotalJual+","+TotalDiskon+","+TotalVariance+","+TotalNota+")";
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
        sql = "INSERT INTO labamingguan (KodeOutlet,KodeJenis,KodeUser,Minggu,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,"
                + "TotalVariance) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setInt(2, KodeJenis);
            PS.setInt(3, KodeUser);
            PS.setInt(4, Minggu);
            PS.setInt(5, Bulan);
            PS.setInt(6, Tahun);
            PS.setDouble(7, TotalModal);
            PS.setDouble(8, TotalJual);
            PS.setDouble(9, TotalDiskon);
            PS.setDouble(10, TotalVariance);
            
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
        sql = "SELECT KodeLB,KodeOutlet,KodeJenis,KodeUser,Minggu,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance "
                + "FROM labamingguan WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeLB = rs.getInt(1);
            KodeOutlet = rs.getInt(2);
            KodeJenis = rs.getInt(3);
            KodeUser = rs.getInt(4);
            Minggu = rs.getInt(5);
            Bulan = rs.getInt(6);
            Tahun = rs.getInt(7);
            TotalModal = rs.getDouble(8);
            TotalJual = rs.getDouble(9);
            TotalDiskon = rs.getDouble(10);
            TotalVariance = rs.getDouble(11);
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
        sql = "DELETE FROM labamingguan";
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
        sql = "DELETE FROM labamingguan WHERE KodeLB="+KodeLB;
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
