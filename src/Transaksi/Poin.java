/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import java.sql.*;
import java.util.*;
import Util.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class Poin {
    
    private int KodePoin;
    private String NoMember;
    private int KodeBC;
    private int JmlhPoin;
    private Calendar TglExpire;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodePoin(int KodePoin){
        this.KodePoin = KodePoin;
    }
    public int getKodePoin(){
        return KodePoin;
    }
    public int getKodePoin(int Kode){
        sql = "SELECT KodePoin FROM poin WHERE KodePoin="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePoin = rs.getInt(1);
                return KodePoin;
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
    public int getKodePoin1(int KodeBC){
        sql = "SELECT KodePoin FROM poin WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePoin = rs.getInt(1);
                return KodePoin;
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
    public void setNoMember(String NoMember){
        this.NoMember = NoMember;
    }
    public String getNoMember(){
        return NoMember;
    }
    public String getNoMember(int KodePoin){
        sql = "SELECT NoMember FROM poin WHERE KodePoin="+KodePoin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoMember = rs.getString(1);
                return NoMember;
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
    public String getNoMember1(int KodeBC){
        sql = "SELECT NoMember FROM poin WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoMember = rs.getString(1);
                return NoMember;
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
    public void UpdateNoMember(int KodePoin,String NoMember) throws SQLException{
        sql = "UPDATE poin SET NoMember='"+NoMember+"' WHERE KodePoin="+KodePoin;
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
    public int getKodeBC(){
        return KodeBC;
    }
    public int getKodeBC(int KodePoin){
        sql = "SELECT KodeBC FROM poin WHERE KodePoin="+KodePoin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeBC = rs.getInt(1);
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
    public void UpdateKodeBC(int KodePoin,int KodeBC) throws SQLException{
        sql = "UPDATE poin SET KodeBC="+KodeBC+" WHERE KodePoin="+KodePoin;
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
    public void setJmlhPoint(int JmlhPoin){
        this.JmlhPoin = JmlhPoin;
    }
    public int getJmlhPoin(){
        return JmlhPoin;
    }
    public int getJmlhPoin(int KodePoin){
        sql = "SELECT JmlhPoin FROM poin WHERE KodePoin="+KodePoin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JmlhPoin = rs.getInt(1);
                return JmlhPoin;
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
    public int getTotalPoin(int KodeBC){
        sql = "SELECT SUM(JmlhPoin) FROM poin WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JmlhPoin = rs.getInt(1);
                return JmlhPoin;
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
    public int getTotalPoin(String NoMember){
        sql = "SELECT SUM(JmlhPoin) FROM poin WHERE NoMember='"+NoMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JmlhPoin = rs.getInt(1);
                return JmlhPoin;
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
    public int getTotalPoin(int KodeBC,Calendar TglExpire){
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "SELECT SUM(JmlhPoin) FROM poin WHERE KodeBC="+KodeBC+" AND TglExpire='"+TglExp+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JmlhPoin = rs.getInt(1);
                return JmlhPoin;
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
    public int getTotalPoin(String NoMember,Calendar TglExpire){
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "SELECT SUM(JmlhPoin) FROM poin WHERE NoMember='"+NoMember+"' AND TglExpire='"+TglExp+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JmlhPoin = rs.getInt(1);
                return JmlhPoin;
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
    public void UpdateJmlhPoin(int KodePoin,int JmlhPoin) throws SQLException{
        sql = "UPDATE poin SET JmlhPoin="+JmlhPoin+" WHERE KodePoin="+KodePoin;
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
    public void TambahPoin(int KodePoin,int JmlhPoin) throws SQLException{
        sql = "UPDATE poin SET JmlhPoin=JmlhPoin+"+JmlhPoin+" WHERE KodePoin="+KodePoin;
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
    public void KurangiPoin(int KodePoin,int JmlhPoin) throws SQLException{
        sql = "UPDATE poin SET JmlhPoin=JmlhPoin+"+JmlhPoin+" WHERE KodePoin="+KodePoin;
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
    public Calendar getTglExpire(int KodePoin){
        sql = "SELECT TglExpire FROM poin WHERE KodePoin="+KodePoin;
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
    public void UpdateTglExpire(int KodePoin,Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "UPDATE poin SET TglExpire='"+TglExp+"' WHERE KodePoin="+KodePoin;
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
    public void getPoin(JTable tblPoin){
        sql = "SELECT p.JmlhPoin,DATE_FORMAT(p.TglExpire,'%d-%m-%Y') FROM poin p INNER JOIN member m INNER JOIN "
                + "businesscontact b ON (p.KodeMember=m.KodeMember AND p.KodeBC=b.KodeBC) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPoin.setModel(new DefaultTableModel(){
                String ColName[] = {"Poin","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 2;
                }
            });
            
            Object rowdata[] = new Object[2];
            DefaultTableModel dtm = (DefaultTableModel)tblPoin.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPoin.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPoin.getColumnModel().getColumn(1).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getPoin1(JTable tblPoin,String NoMember){
        sql = "SELECT p.JmlhPoin,DATE_FORMAT(p.TglExpire,'%d-%m-%Y') FROM poin p INNER JOIN member m INNER JOIN "
                + "businesscontact b ON (p.KodeMember=m.KodeMember AND p.KodeBC=b.KodeBC) WHERE (1=1) AND m.NoMember='"+NoMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPoin.setModel(new DefaultTableModel(){
                String ColName[] = {"Poin","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 2;
                }
            });
            
            Object rowdata[] = new Object[2];
            DefaultTableModel dtm = (DefaultTableModel)tblPoin.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPoin.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPoin.getColumnModel().getColumn(1).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getPoin2(JTable tblPoin,String NoHP) throws SQLException{
        sql = "SELECT p.JmlhPoin,DATE_FORMAT(p.TglExpire,'%d-%m-%Y') FROM poin p INNER JOIN member m INNER JOIN "
                + "businesscontact b ON (p.KodeMember=m.KodeMember AND p.KodeBC=b.KodeBC) WHERE (1=1) AND b.NoHP1='"+NoHP+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPoin.setModel(new DefaultTableModel(){
                String ColName[] = {"Poin","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 2;
                }
            });
            
            Object rowdata[] = new Object[2];
            DefaultTableModel dtm = (DefaultTableModel)tblPoin.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                
                dtm.addRow(rowdata);
            }
            
            tblPoin.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblPoin.getColumnModel().getColumn(1).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan(String NoMember,int KodeBC,int JmlhPoin,Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "INSERT INTO poin (NoMember,KodeBC,JmlhPoin,TglExpire) VALUES ('"+NoMember+"',"+KodeBC+","+JmlhPoin+",'"+TglExp+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodePoin = rs.getInt(1);
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
        sql = "INSERT INTO poin (NoMember,KodeBC,JmlhPoin,TglExpire) VALUES (?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoMember);
            PS.setInt(2, KodeBC);
            PS.setInt(3, JmlhPoin);
            if(TglExpire!=null){
                PS.setDate(4, new java.sql.Date(TglExpire.getTimeInMillis()));
            }
            else{
                PS.setNull(4, java.sql.Types.DATE);
            }
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodePoin = rs.getInt(1);
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
        sql = "SELECT NoMember,KodeBC,JmlhPoin,TglExpire FROM poin WHERE KodePoin="+KodePoin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NoMember = rs.getString(1);
            KodeBC = rs.getInt(2);
            JmlhPoin = rs.getInt(3);
            TglExpire = Calendar.getInstance();
            TglExpire.setTime(rs.getDate(4));
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
