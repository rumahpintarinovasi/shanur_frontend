/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import Util.*;
import java.time.LocalTime;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class Sift {
    
    private int KodeSift;
    private int Sift;
    private String WaktuMulai;
    private String WaktuSelesai;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeSift(int KodeSift){
        this.KodeSift = KodeSift;
    }
    public int getKodeSift(){
        return KodeSift;
    }
    public int getKodeSift(int Kode){
        sql = "SELECT KodeSift FROM sift WHERE KodeSift="+Kode;
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
    public int getKodeSift1(int Sift){
        sql = "SELECT KodeSift FROM sift WHERE Sift="+Sift;
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
    public void setSift(int Sift){
        this.Sift = Sift;
    }
    public int getSift(){
        return Sift;
    }
    public int getSift(int KodeSift){
        sql = "SELECT Sift FROM sift WHERE KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Sift = rs.getInt(1);
                return Sift;
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
    public int getSift(String WaktuMulai,String WaktuSelesai){
        sql = "SELECT Sift FROM sift WHERE WaktuMulai='"+WaktuMulai+"' AND WaktuSelesai='"+WaktuSelesai+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Sift = rs.getInt(1);
                return Sift;
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
    public int getLastSift(){
        sql = "SELECT Sift FROM sift WHERE KodeSift = (SELECT MAX(KodeSift) FROM sift)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Sift = rs.getInt(1);
                return Sift;
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
    public void UpdateSift(int KodeSift,int Sift) throws SQLException{
        sql = "UPDATE sift SET Sift="+Sift+" WHERE KodeSift="+KodeSift;
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
    public void setWaktuMulai(String WaktuMulai){
        this.WaktuMulai = WaktuMulai;
    }
    public String getWaktuMulai(){
        return WaktuMulai;
    }
    public String getWaktuMulai(int KodeSift){
        sql = "SELECT WaktuMulai FROM sift WHERE KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuMulai = rs.getString(1);
                return WaktuMulai;
            }
            else{
                return null;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public String getStartTime(int Sift){
        sql = "SELECT WaktuMulai FROM sift WHERE Sift="+Sift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuMulai = rs.getString(1);
                return WaktuMulai;
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
    public String getStartTime(int KodeSift,int Sift){
        sql = "SELECT WaktuMulai FROM sift WHERE KodeSift="+KodeSift+" AND Sift="+Sift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuMulai = rs.getString(1);
                return WaktuMulai;
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
    public void UpdateWaktuMulai(int KodeSift,String WaktuMulai) throws SQLException{
        sql = "UPDATE sift SET WaktuMulai='"+WaktuMulai+"' WHERE KodeSift="+KodeSift;
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
    public void UpdateStartTime(int Sift,String WaktuMulai) throws SQLException{
        sql = "UPDATE sift SET WaktuMulai='"+WaktuMulai+"' WHERE Sift="+Sift;
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
    public void UpdateWaktuMulai(int KodeSift,int Sift,String WaktuMulai) throws SQLException{
        sql = "UPDATE sift SET WaktuMulai='"+WaktuMulai+"' WHERE KodeSift="+KodeSift+" AND Sift="+Sift;
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
    public void setWaktuSelesai(String WaktuSelesai){
        this.WaktuSelesai = WaktuSelesai;
    }
    public String getWaktuSelesai(){
        return WaktuSelesai;
    }
    public String getWaktuSelesai(int KodeSift){
        sql = "SELECT WaktuSelesai FROM sift WHERE KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuSelesai = rs.getString(1);
                return WaktuSelesai;
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
    public String getFinishTime(int Sift){
        sql = "SELECT WaktuSelesai FROM sift WHERE Sift="+Sift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.TYPE_SCROLL_INSENSITIVE);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuSelesai = rs.getString(1);
                return WaktuSelesai;
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
    public String getWaktuSelesai(int KodeSift,int Sift){
        sql = "SELECT WaktuSelesai FROM sift WHERE KodeSift="+KodeSift+" AND Sift="+Sift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                WaktuSelesai = rs.getString(1);
                return WaktuSelesai;
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
    public void UpdateWaktuSelesai(int KodeSift,String WaktuSelesai) throws SQLException{
        sql = "UPDATE sift SET WaktuSelesai='"+WaktuSelesai+"' WHERE KodeSift="+KodeSift;
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
    public void UpdateFinishTime(int Sift,String WaktuSelesai) throws SQLException{
        sql = "UPDATE sift SET WaktuSelesai='"+WaktuSelesai+"' WHERE Sift="+Sift;
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
    public void UpdateWaktuSelesai(int KodeSift,int Sift,String WaktuSelesai) throws SQLException{
        sql = "UPDTE sift SET WaktuSelesai='"+WaktuSelesai+"' WHERE KodeSift="+KodeSift+" AND Sift="+Sift;
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
    public void getSift1(JMenu mSift,int Sift1){
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        
        LocalTime Now = LocalTime.now();
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
    }
    public void getSift1(JFormattedTextField ftxtSift,int Sift1){
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        
        LocalTime Now = LocalTime.now();
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
    }
    public void getSift2(JMenu mSift,int Sift1,int Sift2){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
    }
    public void getSift2(JFormattedTextField ftxtSift,int Sift1,int Sift2){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
    }
    public void getSift3(JMenu mSift,int Sift1,int Sift2,int Sift3){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            mSift.setText(String.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
    }
   public void getSift3(JFormattedTextField ftxtSift,int Sift1,int Sift2,int Sift3){ 
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
   }
   public void getSift4(JMenu mSift,int Sift1,int Sift2,int Sift3,int Sift4){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        String WaktuMulai4 = getStartTime(Sift4);
        String WaktuSelesai4 = getFinishTime(Sift4);
        LocalTime StartTime4 = LocalTime.parse(WaktuMulai4);
        LocalTime FinishTime4 = LocalTime.parse(WaktuSelesai4);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            mSift.setText(String.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
        else if(Now.isAfter(StartTime4) && Now.isBefore(FinishTime4)){
            mSift.setText(String.valueOf(getSift(WaktuMulai4, WaktuSelesai4)));
        }
   }
   public void getSift4(JFormattedTextField ftxtSift,int Sift1,int Sift2,int Sift3,int Sift4){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        String WaktuMulai4 = getStartTime(Sift4);
        String WaktuSelesai4 = getFinishTime(Sift4);
        LocalTime StartTime4 = LocalTime.parse(WaktuMulai4);
        LocalTime FinishTime4 = LocalTime.parse(WaktuSelesai4);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
        else if(Now.isAfter(StartTime4) && Now.isBefore(FinishTime4)){
            ftxtSift.setValue(Integer.valueOf(getSift(WaktuMulai4, WaktuSelesai4)));
        }
   }
   public void getSift4(JMenu mSift,int Sift1,int Sift2,int Sift3,int Sift4,int Sift5){
       LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        String WaktuMulai4 = getStartTime(Sift4);
        String WaktuSelesai4 = getFinishTime(Sift4);
        LocalTime StartTime4 = LocalTime.parse(WaktuMulai4);
        LocalTime FinishTime4 = LocalTime.parse(WaktuSelesai4);
        
        String WaktuMulai5 = getStartTime(Sift5);
        String WaktuSelesai5 = getFinishTime(Sift5);
        LocalTime StartTime5 = LocalTime.parse(WaktuMulai5);
        LocalTime FinishTime5 = LocalTime.parse(WaktuSelesai5);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            mSift.setText(String.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
        else if(Now.isAfter(StartTime4) && Now.isBefore(FinishTime4)){
            mSift.setText(String.valueOf(getSift(WaktuMulai4, WaktuSelesai4)));
        }
        else if(Now.isAfter(StartTime5) && Now.isBefore(FinishTime5)){
            mSift.setText(String.valueOf(getSift(WaktuMulai5, WaktuSelesai5)));
        }
   }
   public void getSift5(JFormattedTextField ftxtSift,int Sift1,int Sift2,int Sift3,int Sift4,int Sift5){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        String WaktuMulai4 = getStartTime(Sift4);
        String WaktuSelesai4 = getFinishTime(Sift4);
        LocalTime StartTime4 = LocalTime.parse(WaktuMulai4);
        LocalTime FinishTime4 = LocalTime.parse(WaktuSelesai4);
        
        String WaktuMulai5 = getStartTime(Sift5);
        String WaktuSelesai5 = getFinishTime(Sift5);
        LocalTime StartTime5 = LocalTime.parse(WaktuMulai5);
        LocalTime FinishTime5 = LocalTime.parse(WaktuSelesai5);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            ftxtSift.setText(String.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
        else if(Now.isAfter(StartTime4) && Now.isBefore(FinishTime4)){
            ftxtSift.setText(String.valueOf(getSift(WaktuMulai4, WaktuSelesai4)));
        }
        else if(Now.isAfter(StartTime5) && Now.isBefore(FinishTime5)){
            ftxtSift.setText(String.valueOf(getSift(WaktuMulai5, WaktuSelesai5)));
        }
   }
   public void getSift5(JMenu mSift,int Sift1,int Sift2,int Sift3,int Sift4,int Sift5){
        LocalTime Now = LocalTime.now();
        
        String WaktuMulai1 = getStartTime(Sift1);
        String WaktuSelesai1 = getFinishTime(Sift1);
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        String WaktuMulai2 = getStartTime(Sift2);
        String WaktuSelesai2 = getFinishTime(Sift2);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        String WaktuMulai3 = getStartTime(Sift3);
        String WaktuSelesai3 = getFinishTime(Sift3);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        String WaktuMulai4 = getStartTime(Sift4);
        String WaktuSelesai4 = getFinishTime(Sift4);
        LocalTime StartTime4 = LocalTime.parse(WaktuMulai4);
        LocalTime FinishTime4 = LocalTime.parse(WaktuSelesai4);
        
        String WaktuMulai5 = getStartTime(Sift5);
        String WaktuSelesai5 = getFinishTime(Sift5);
        LocalTime StartTime5 = LocalTime.parse(WaktuMulai5);
        LocalTime FinishTime5 = LocalTime.parse(WaktuSelesai5);
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(getSift(WaktuMulai1, WaktuSelesai1)));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(getSift(WaktuMulai2, WaktuSelesai2)));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            mSift.setText(String.valueOf(getSift(WaktuMulai3, WaktuSelesai3)));
        }
        else if(Now.isAfter(StartTime4) && Now.isBefore(FinishTime4)){
            mSift.setText(String.valueOf(getSift(WaktuMulai4, WaktuSelesai4)));
        }
        else if(Now.isAfter(StartTime5) && Now.isBefore(FinishTime5)){
            mSift.setText(String.valueOf(getSift(WaktuMulai5, WaktuSelesai5)));
        }
   }
    
    
    public void getSift(JTable tblSift){
        sql = "SELECT KodeSift,Sift,WaktuMulai,WaktuSelesai FROM sift";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblSift.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Sift","Sift","Waktu Mulai","Waktu Selesai"};
                Class ColType[] = {Integer.class,Integer.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 4;
                }
            });
            
            Object rowdata[] = new Object[4];
            DefaultTableModel dtm = (DefaultTableModel)tblSift.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getInt(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                
                dtm.addRow(rowdata);
            }
            
            tblSift.getColumnModel().getColumn(0).setPreferredWidth(50);
            tblSift.getColumnModel().getColumn(1).setPreferredWidth(50);
            tblSift.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblSift.getColumnModel().getColumn(3).setPreferredWidth(80);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public int getJumlahSift(){
        sql = "SELECT COUNT(*) FROM sift";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Sift = rs.getInt(1);
                return Sift;
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
    public void getSatuSift(JMenu mSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(1));
        }
    }
    public void getSatuSift(JFormattedTextField ftxtSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(1));
        }
    }
    public void getDuaSift(JMenu mSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        String WaktuMulai2 = getStartTime(2);
        String WaktuSelesai2 = getFinishTime(2);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(1));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(2));
        }
    }
    public void getDuaSift(JFormattedTextField ftxtSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        String WaktuMulai2 = getStartTime(2);
        String WaktuSelesai2 = getFinishTime(2);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(1));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setValue(Integer.valueOf(2));
        }
    }
    public void getTigaSift(JMenu mSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        String WaktuMulai2 = getStartTime(2);
        String WaktuSelesai2 = getFinishTime(2);
        String WaktuMulai3 = getStartTime(3);
        String WaktuSelesai3 = getFinishTime(3);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            mSift.setText(String.valueOf(1));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            mSift.setText(String.valueOf(2));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            mSift.setText(String.valueOf(3));
        }
    }
    public void getTigaSift(JFormattedTextField ftxtSift){
        String WaktuMulai1 = getStartTime(1);
        String WaktuSelesai1 = getFinishTime(1);
        String WaktuMulai2 = getStartTime(2);
        String WaktuSelesai2 = getFinishTime(2);
        String WaktuMulai3 = getStartTime(3);
        String WaktuSelesai3 = getFinishTime(3);
        
        LocalTime StartTime1 = LocalTime.parse(WaktuMulai1);
        LocalTime FinishTime1 = LocalTime.parse(WaktuSelesai1);
        LocalTime StartTime2 = LocalTime.parse(WaktuMulai2);
        LocalTime FinishTime2 = LocalTime.parse(WaktuSelesai2);
        LocalTime StartTime3 = LocalTime.parse(WaktuMulai3);
        LocalTime FinishTime3 = LocalTime.parse(WaktuSelesai3);
        
        LocalTime Now = LocalTime.now();
        
        if(Now.isAfter(StartTime1) && Now.isBefore(FinishTime1)){
            ftxtSift.setValue(Integer.valueOf(1));
        }
        else if(Now.isAfter(StartTime2) && Now.isBefore(FinishTime2)){
            ftxtSift.setValue(Integer.valueOf(2));
        }
        else if(Now.isAfter(StartTime3) && Now.isBefore(FinishTime3)){
            ftxtSift.setValue(Integer.valueOf(3));
        }
    }
    public void Simpan(int Sift,String WaktuMulai,String WaktuSelesai) throws SQLException{
        sql = "INSERT INTO sift (Sift,WaktuMulai,WaktuSelesai) VALUES ("+Sift+",'"+WaktuMulai+"','"+WaktuSelesai+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSift = rs.getInt(1);
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
        sql = "INSERT INTO sift (Sift,WaktuMulai,WaktuSelesai) VALUES (?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, Sift);
            PS.setString(2, WaktuMulai);
            PS.setString(3, WaktuSelesai);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeSift = rs.getInt(1);
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
        sql = "SELECT KodeSift,Sift,WaktuMulai,WaktuSelesai FROM sift WHERE KodeSift="+KodeSift;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeSift = rs.getInt(1);
            Sift = rs.getInt(2);
            WaktuMulai = rs.getString(3);
            WaktuSelesai = rs.getString(4);
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
        sql = "DELETE FROM sift";
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
    public void Hapus(int KodeSift) throws SQLException{
        sql = "DELETE FROM sift WHERE KodeSift="+KodeSift;
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
