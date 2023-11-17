/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;

/**
 *
 * @author Yestin
 */
public class LabaBulanan {
    
    private int KodeLB,KodeOutlet,KodeJenis,KodeUser,Bulan,Tahun,TotalNota;
    private Double TotalModal,TotalJual,TotalDiskon,TotalVariance;
    
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
        sql = "SELECT KodeLB FROM lababulanan WHERE KodeLB="+Kode;
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
        sql = "SELECT KodeLB FROM lababulanan WHERE KodeLB = (SELECT MAX(KodeLB) FROM lababulanan)";
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
    public int getLastKodeLB(int KodeOutlet,int KodeJenis,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT KodeLB FROM lababulanan WHERE KodeLB = (SELECT MAX(KodeLB) FROM lababulanan WHERE KodeOutlet="+KodeOutlet+" AND "
                + "KodeJenis="+KodeJenis+" AND KodeUser="+KodeUser+" AND Bulan="+Bulan+" AND Tahun="+Tahun+")";
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
        sql = "SELECT KodeOutlet FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET KodeOutlet="+KodeOutlet+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT KodeJenis FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET KodeJenis="+KodeJenis+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT KodeUser FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET KodeUser="+KodeUser+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT Bulan FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET Bulan="+Bulan+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT Tahun FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET Tahun="+Tahun+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalModal FROM lababulanan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalModal(int Bulan,int Tahun){
        sql = "SELECT SUM(TotalModal) FROM lababulanan WHERE Bulan="+Bulan+" AND Tahun="+Tahun;
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
    public Double getGrandTotalModal(int Tahun){
        sql = "SELECT SUM(TotalModal) FROM lababulanan WHERE Tahun="+Tahun;
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
        sql = "UPDATE lababulanan SET TotalModal="+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalModal=TotalModal+"+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalModal=TotalModal-"+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalJual FROM lababulanan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalJual(int Bulan,int Tahun){
        sql = "SELECT SUM(TotalJual) FROM lababulanan WHERE Bulan="+Bulan+" AND Tahun="+Tahun;
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
    public Double getGrandTotalJual(int Tahun){
        sql = "SELECT SUM(TotalJual) FROM lababulanan WHERE Tahun="+Tahun;
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
    public void UpdateTotalJual(int KodeLB,Double TotalJual) throws SQLException{
        sql = "UPDATE lababulanan SET TotalJual="+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalJual=TotalJual+"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalJual=TotalJual-"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalDiskon FROM lababulanan WHERE KodeLB="+KodeLB;
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
    public Double gtGrandTotalDiskon(int Bulan,int Tahun){
        sql = "SELECT SUM(TotalDiskon) FROM lababulanan WHERE Bulan="+Bulan+" AND Tahun="+Tahun;
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
    public Double getGrandTotalDiskon(int Tahun){
        sql = "SELECT SUM(TotalDiskon) FROM lababulanan WHERE Tahun="+Tahun;
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
        sql = "UPDATE lababulanan SET TotalDiskon="+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalDiskon=TotalDiskon+"+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalDiskon=TotalDiskon-"+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
    public void setTotalVariance(Double TotalVariance){
        this.TotalVariance = TotalVariance;
    }
    public Double getTotalVariance(){
        return TotalVariance;
    }
    public Double getTotalVariance(int KodeLB){
        sql = "SELECT TotalVariance FROM lababulanan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalVariance(int Bulan,int Tahun){
        sql = "SELECT TotalVariance FROM lababulanan WHERE Bulan="+Bulan+" AND Tahun="+Tahun;
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
        sql = "UPDATE lababulanan SET TotalVariance="+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalVariance=TotalVariance+"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalVariance=TotalVariance+"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalNota FROM lababulanan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan WHERE TotalNota="+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalNota=TotalNota+"+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE lababulanan SET TotalNota=TotalNota-"+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void getLabaBulanan(JTable tblLaba){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan(JTable tblLaba,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan(JTable tblLaba,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan1(JTable tblLaba,int KodeOutlet){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan1(JTable tblLaba,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan1(JTable tblLaba,int KodeOutlet,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan2(JTable tblLaba,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan2(JTable tblLaba,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan2(JTable tblLaba,int KodeJenis,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan3(JTable tblLaba,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan3(JTable tblLaba,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan3(JTable tblLaba,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan4(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND "
                + "l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND "
                + "l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan5(JTable tblLaba,int KodeOutlet,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan5(JTable tblLaba,int KodeOutlet,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND "
                + "l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan5(JTable tblLaba,int KodeOutlet,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="+KodeUser+" AND "
                + "l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan6(JTable tblLaba,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan6(JTable tblLaba,int KodeJenis,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser+" AND "
                + "l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan6(JTable tblLaba,int KodeJenis,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="+KodeUser+" AND "
                + "l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="
                + KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND "
                + "l.KodeUser="+KodeUser+" AND l.Bulan="+Bulan+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getLabaBulanan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,"
                + "CASE WHEN (l.Bulan=1) THEN CONCAT ('Januari',' ',l.Tahun) "
                + "WHEN (l.Bulan=2) THEN CONCAT('Februari',' ',l.Tahun) "
                + "WHEN (l.Bulan=3) THEN CONCAT('Maret',' ',l.Tahun) "
                + "WHEN (l.Bulan=4) THEN CONCAT('April',' ',l.Tahun) "
                + "WHEN (l.Bulan=5) THEN CONCAT('Mei',' ',l.Tahun) "
                + "WHEN (l.Bulan=6) THEN CONCAT('Juni',' ',l.Tahun) "
                + "WHEN (l.Bulan=7) THEN CONCAT('Juli',' ',l.Tahun) "
                + "WHEN (l.Bulan=8) THEN CONCAT('Agustus',' ',l.Tahun) "
                + "WHEN (l.Bulan=9) THEN CONCAT('September',' ',l.Tahun) "
                + "WHEN (l.Bulan=10) THEN CONCAT('Oktober',' ',l.Tahun) "
                + "WHEN (l.Bulan=11) THEN CONCAT('November',' ',l.Tahun) "
                + "WHEN (l.Bulan=12) THEN CONCAT('Desember',' ',l.Tahun) END AS Bulan,"
                + "l.TotalModal,l.TotalJual,(l.TotalJual-l.TotalModal) AS Laba,"
                + "l.TotalDiskon,l.TotalVariance,l.TotalNota FROM lababulanan l INNER JOIN outlet o INNER JOIN jenispembayaran j INNER "
                + "JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND l.KodeUser=u.KodeUser "
                + "AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="
                + KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Bulan","Total Modal","Total Penjualan","Laba","Total Diskon","Total Variance",
                                    "Total Nota"};
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
                rowdata[2] = rs.getString(3); //User
                rowdata[3] = rs.getString(4); //Bulan
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8); //TotalDiskon
                rowdata[8] = rs.getDouble(9); //TotalVariance
                rowdata[9] = rs.getInt(10); //TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(80); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(100); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(100); //Bulan
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
            tblLaba.getColumnModel().getColumn(9).setPreferredWidth(80); //TotalNota
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan(int KodeOutlet,int KodeJenis,int KodeUser,int Bulan,int Tahun,Double TotalModal,Double TotalJual,
            Double TotalDiskon,Double TotalVariance,int TotalNota) throws SQLException{
        sql = "INSERT INTO lababulanan (KodeOutlet,KodeJenis,KodeUser,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,"
                + "TotalNota) VALUES ("+KodeOutlet+","+KodeJenis+","+KodeUser+","+Bulan+","+Tahun+","+TotalModal+","+TotalJual+","
                + TotalDiskon+","+TotalVariance+","+TotalNota+")";
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
        sql = "INSERT INTO lababulanan (KodeOutlet,KodeJenis,KodeUser,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,"
                + "TotalNota) VALUES (?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setInt(2, KodeJenis);
            PS.setInt(3, KodeUser);
            PS.setInt(4, Bulan);
            PS.setInt(5, Tahun);
            PS.setDouble(6, TotalModal);
            PS.setDouble(7, TotalJual);
            PS.setDouble(8, TotalDiskon);
            PS.setDouble(9, TotalVariance);
            PS.setInt(10, TotalNota);
            
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
        sql = "SELECT KodeOutlet,KodeJenis,KodeUser,Bulan,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,TotalNota "
                + "FROM lababulanan WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOutlet = rs.getInt(1);
            KodeJenis = rs.getInt(2);
            KodeUser = rs.getInt(3);
            Bulan = rs.getInt(4);
            Tahun = rs.getInt(5);
            TotalModal = rs.getDouble(6);
            TotalJual = rs.getDouble(7);
            TotalDiskon = rs.getDouble(8);
            TotalVariance = rs.getDouble(9);
            TotalNota = rs.getInt(10);
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
        sql = "DELETE FROM lababulanan";
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
        sql = "DELETE FROM lababulanan WHERE KodeLB="+KodeLB;
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
