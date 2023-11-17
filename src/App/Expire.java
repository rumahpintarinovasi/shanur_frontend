/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.util.*;
import java.sql.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Expire {
    
    private int KodeExpire;
    private Calendar TglExpire;
    private String TglExp;
    
    String sql = null;
    ResultSet rs = null;
    Statement stmt = null;
    PreparedStatement PS = null;
    
    public void setKodeExpire(int KodeExpire){
        this.KodeExpire = KodeExpire;
    }
    public int getKodeExpire(){
        return KodeExpire;
    }
    public int getKodeExpire(int Kode){
        sql = "SELECT KodeExpire FROM expire WHERE Kode="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeExpire = rs.getInt(1);
                return KodeExpire;
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
    public void setTglExpire(Calendar TglExpire){
        this.TglExpire = TglExpire;
    }
    public Calendar getTglExpire(){
        return TglExpire;
    }
    public Calendar getTglExpire(int KodeExpire){
        sql = "SELECT TglExpire FROM expire WHERE KodeExpire="+KodeExpire;
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
    public Calendar getTglExpireAkhir(){
        sql = "SELECT Tanggal FROM expire WHERE KodeExp=(SELECT MAX(KodeExp) FROM expire)";
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
    public String getLastTglExpire(){
        sql = "SELECT Tanggal FROM expire WHERE KodeExp=(SELECT MAX(KodeExp) FROM expire)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TglExp = rs.getString(1);
                return TglExp;
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
    public void Simpan(Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "INSERT INTO expire (TglExpire) VALUES ('"+TglExp+"')";
        try {
            stmt = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeExpire = rs.getInt(1);
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
