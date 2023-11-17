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
public class LabaTahunan {
    
    private int KodeLB,KodeOutlet,KodeJenis,KodeUser,Tahun,TotalNota;
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
        sql = "SELECT KodeLB FROM labatahunan WHERE KodeLB="+Kode;
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
    public int getLastKodeLB(int KodeOutlet,int KodeJenis,int KodeUser,int Tahun){
        sql = "SELECT KodeLB FROM labatahunan WHERE KodeLB = (SELECT MAX(KodeLB) FROM labatahunan WHERE KodeOutlet="+KodeOutlet+" AND "
                + "KodeJenis="+KodeJenis+" AND KodeUser="+KodeUser+" AND Tahun="+Tahun+")";
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
        sql = "SELECT KodeOutlet FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET KodeOutlet="+KodeOutlet+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT KodeJenis FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET KodeJenis="+KodeJenis+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT KodeUser FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET KodeUser="+KodeUser+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT Tahun FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET Tahun="+Tahun+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalModal FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "SELECT SUM(TotalModal) FROM labatahunan WHERE Tahun="+Tahun;
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
    public Double getGrandTotalModal(int ThnAwal,int ThnAkhir){
        sql = "SELECT SUM(TotalModal) FROM labatahunan WHERE Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir;
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
        sql = "UPDATE labatahunan SET TotalModal="+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalModal=TotalModal+"+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalModal=TotalModal-"+TotalModal+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalJual FROM labatahunan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalJual(int Tahun){
        sql = "SELECT SUM(TotalJual) FROM labatahunan WHERE Tahun="+Tahun;
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
    public Double getGrandTotalJual(int ThnAwal,int ThnAkhir){
        sql = "SELECT SUM(TotalJual) FROM labatahunan WHERE Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir;
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
        sql = "UPDATE labatahunan SET TotalJual="+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalJual=TotalJual+"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalJual=TotalJual-"+TotalJual+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalDiskon FROM labatahunan WHERE KodeLB="+KodeLB;
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
        sql = "SELECT SUM(TotalDiskon) FROM labatahunan WHERE Tahun="+Tahun;
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
    public Double getGrandTotalDiskon(int ThnAwal,int ThnAkhir){
        sql = "SELECT SUM(TotalDiskon) FROM labatahunan WHERE Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir;
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
        sql = "UPDATE labatahunan SET TotalDiskon="+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalDiskon=TotalDiskon+"+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalDiskon=TotalDiskon-"+TotalDiskon+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalVariance FROM labatahunan WHERE KodeLB="+KodeLB;
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
    public Double getGrandTotalVariance(int Tahun){
        sql = "SELECT SUM(TotalVariance) FROM labatahunan WHERE Tahun="+Tahun;
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
    public Double getGrandTotalVariance(int ThnAwal,int ThnAkhir){
        sql = "SELECT SUM(TotalVariance) FROM labatahunan WHERE Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir;
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
        sql = "UPDATE labatahunan SET TotalVariance="+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalVariance=TotalVariance+"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalVariance=TotalVariance-"+TotalVariance+" WHERE KodeLB="+KodeLB;
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
        sql = "SELECT TotalNota FROM labatahunan SET KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalNota="+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalNota=TotalNota+"+TotalNota+" WHERE KodeLB="+KodeLB;
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
        sql = "UPDATE labatahunan SET TotalNota=TotalNota-"+TotalNota+" WHERE KodeLB="+KodeLB;
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
    public void getLabaTahunan(JTable tblLaba){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan(JTable tblLaba,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan(JTable tblLaba,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan1(JTable tblLaba,int KodeOutlet){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan1(JTable tblLaba,int KodeOutlet,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.Tahun="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan1(JTable tblLaba,int KodeOutlet,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND (l.Tahun BETWEEN "
                + ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan2(JTable tblLaba,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan2(JTable tblLaba,int KodeJenis,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.Tahun="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan2(JTable tblLaba,int KodeJenis,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND (l.Tahun BETWEEN "
                + ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan3(JTable tblLaba,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan3(JTable tblLaba,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan3(JTable tblLaba,int KodeUser,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeUser="+KodeUser+" AND (l.Tahun BETWEEN "
                + ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan4(JTable tblLaba,int KodeOutlet,int KodeJenis){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan4(JTable tblLaba,int KodeOutlet,int KodeJenis,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis+" AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan5(JTable tblLaba,int KodeOutlet,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="
                + KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan5(JTable tblLaba,int KodeOutlet,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="
                + KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan5(JTable tblLaba,int KodeOutlet,int KodeUser,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeUser="
                + KodeUser+" AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan6(JTable tblLaba,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="
                + KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan6(JTable tblLaba,int KodeJenis,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="
                + KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan6(JTable tblLaba,int KodeJenis,int KodeUser,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeJenis="+KodeJenis+" AND l.KodeUser="
                + KodeUser+" AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis+" AND l.KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int Tahun){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis+" AND l.KodeUser="+KodeUser+" AND l.Tahun="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void getLabaTahunan7(JTable tblLaba,int KodeOutlet,int KodeJenis,int KodeUser,int ThnAwal,int ThnAkhir){
        sql = "SELECT o.NamaOutlet,j.NamaJenis,i.NamaLengkap,l.Tahun,l.TotalModal,l.TotalJual,(TotalJual-TotalModal),l.TotalDiskon,"
                + "l.TotalVariance,l.TotalNota FROM labatahunan l INNER JOIN outlet o INNER JOIN jenispembayaran j "
                + "INNER JOIN user u INNER JOIN identitas i ON (l.KodeOutlet=o.KodeOutlet AND l.KodeJenis=j.KodeJenis AND "
                + "l.KodeUser=u.KodeUser AND u.NoIdentitas=i.NoIdentitas) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND l.KodeJenis="
                + KodeJenis+" AND l.KodeUser="+KodeUser+" AND (l.Tahun BETWEEN "+ThnAwal+" AND "+ThnAkhir+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblLaba.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Jenis Pembayaran","User","Tahun","Total Modal","Total Penjualan","Laba","Total Diskon",
                                    "Total Variance","Total Nota"};
                Class ColType[] = {String.class,String.class,String.class,Integer.class,Double.class,Double.class,Double.class,
                                    Double.class,Double.class,Integer.class};
                
                @Override
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
                rowdata[3] = rs.getInt(4); //Tahun
                rowdata[4] = rs.getDouble(5); //TotalModal
                rowdata[5] = rs.getDouble(6); //TotalPenjualan
                rowdata[6] = rs.getDouble(7); //Laba
                rowdata[7] = rs.getDouble(8);//TotalDiskon
                rowdata[8] = rs.getDouble(9);//TotalVariance
                rowdata[9] = rs.getDouble(10);//TotalNota
                
                dtm.addRow(rowdata);
            }
            
            tblLaba.getColumnModel().getColumn(0).setPreferredWidth(100); //Outlet
            tblLaba.getColumnModel().getColumn(1).setPreferredWidth(100); //JenisPembayaran
            tblLaba.getColumnModel().getColumn(2).setPreferredWidth(150); //User
            tblLaba.getColumnModel().getColumn(3).setPreferredWidth(50); //Tahun
            tblLaba.getColumnModel().getColumn(4).setPreferredWidth(100); //TotalModal
            tblLaba.getColumnModel().getColumn(5).setPreferredWidth(100); //TotalPenjualan
            tblLaba.getColumnModel().getColumn(6).setPreferredWidth(100); //Laba
            tblLaba.getColumnModel().getColumn(7).setPreferredWidth(100); //TotalDiskon
            tblLaba.getColumnModel().getColumn(8).setPreferredWidth(100); //TotalVariance
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
    public void Simpan(int KodeOutlet,int KodeJenis,int KodeUser,int Tahun,Double TotalModal,Double TotalJual,
                        Double TotalDiskon,Double TotalVariance,int TotalNota) throws SQLException{
        sql = "INSERT INTO labatahunan (KodeOutlet,KodeJenis,KodeUser,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,"
                + "TotalNota) VALUES("+KodeOutlet+","+KodeJenis+","+KodeUser+","+Tahun+","+TotalModal+","+TotalJual+","
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
        sql = "INSERT INTO labatahunan (KodeOutlet,KodeJenis,KodeUser,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,"
                + "TotalNota) VALUES (?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setInt(2, KodeJenis);
            PS.setInt(KodeJenis, Tahun);
            
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
    public void Query() throws SQLException{
        sql = "SELECT KodeOutlet,KodeJenis,KodeUser,Tahun,TotalModal,TotalJual,TotalDiskon,TotalVariance,TotalNota FROM "
                + "labatahunan WHERE KodeLB="+KodeLB;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOutlet = rs.getInt(1);
            KodeJenis = rs.getInt(2);
            KodeUser = rs.getInt(3);
            Tahun  = rs.getInt(4);
            TotalModal = rs.getDouble(5);
            TotalJual = rs.getDouble(6);
            TotalDiskon = rs.getDouble(7);
            TotalVariance = rs.getDouble(8);
            TotalNota = rs.getInt(9);
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
        sql = "DELETE FROM labatahunan";
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
        sql = "DELETE FROM labatahunan WHERE KodeLB="+KodeLB;
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
