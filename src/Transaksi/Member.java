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
public class Member {
    
    private int KodeMember;
    private String NoMember;
    private int KodeBC;
    private int KodeOutlet;
    private String Level;
    private Double Diskon;
    private Calendar TglExpire;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeMember(int KodeMember){
        this.KodeMember = KodeMember;
    }
    public int getKodeMember(){
        return KodeMember;
    }
    public int getKodeMember(int Kode){
        sql = "SELECT KodeMember FROM member WHERE KodeMember="+KodeMember;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMember = rs.getInt(1);
                return KodeMember;
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
    public int getKodeMember1(String NoMember){
        sql = "SELECT KodeMember FROM member WHERE NoMember='"+NoMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMember = rs.getInt(1);
                return KodeMember;
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
    public int getLastKodeMember(){
        sql = "SELECT KodeMember FROM member WHERE KodeMember = (SELECT MAX(KodeMember) FROM member)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMember = rs.getInt(1);
                return KodeMember;
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
    public String getNoMember(int KodeMember){
        sql = "SELECT NoMember FROM member WHERE KodeMember=+"+KodeMember;
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
    public String getNoMember(String NmrMember){
        sql = "SELECT NoMember FROM member WHERE NoMember='"+NmrMember+"'";
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
    public void UpdateNoMember(int KodeMember,String NoMember) throws SQLException{
        sql = "UPDATE member SET NoMember='"+NoMember+"' WHERE KodeMember="+KodeMember;
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
    public int getKodeBC(int KodeMember){
        sql = "SELECT KodeBC FROM member WHERR KodeMember="+KodeMember;
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
        catch (Exception e) {
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
    public int getKodeBC(String NoMember){
        sql = "SELECT KodeBC FROM member WHERR NoMember='"+NoMember+"'";
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
        catch (Exception e) {
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
    public void UpdateKodeBC(int KodeMember,int KodeBC) throws SQLException{
        sql = "UPDATE member SET KodeBC="+KodeBC+" WHERE KodeMember="+KodeMember;
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
    public void setKodeOutlet(int KodeOutlet){
        this.KodeOutlet = KodeOutlet;
    }
    public int getKodeOutlet(){
        return KodeOutlet;
    }
    public int getKodeOUutlet(int KodeMember){
        sql = "SELECT KodeOutlet FROM member WHERE KodeMember="+KodeMember;
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
    }
    public void UpdateKodeOutlet(int KodeMember,int KodeOutlet) throws SQLException{
        sql = "UPDATE member SET KodeOutlet="+KodeOutlet+" WHERE KodeMember="+KodeMember;
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
    public void setLevel(String Level){
        this.Level = Level;
    }
    public String getLevel(){
        return Level;
    }
    public String getLevel(int KodeMember){
        sql = "SELECT Level FROM member WHERE KodeMember="+KodeMember;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Level = rs.getString(1);
                return Level;
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
    public String getLevel(String NoMember){
        sql = "SELECT Level FROM member WHERE NoMember='"+NoMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Level = rs.getString(1);
                return Level;
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
    public void UpdateLevel(int KodeMember,String Level) throws SQLException{
        sql = "UPDATE member SET Level='"+Level+"' WHERE KodeMember="+KodeMember;
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
    public Double getDiskon(int KodeMember){
        sql = "SELECT Diskon FROM member WHERE KodeMember="+KodeMember;
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
    public Double getDiskon(String NoMember){
        sql = "SELECT Diskon FROM member WHERE NoMember='"+NoMember+"'";
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
    public void UpdateDiskon(int KodeMember,Double Diskon) throws SQLException{
        sql = "UPDATE member SET Diskon="+Diskon+" WHERE KodeMember="+KodeMember;
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
    public void setTglExpire(Calendar TglExpire) {
        this.TglExpire = TglExpire;
    }
    public Calendar getTglExpire(){
        return TglExpire;
    }
    public Calendar getTglExpire(int KodeMember){
        sql = "SELECT TglExpire FROM member WHERE KodeMember="+KodeMember;
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
    public Calendar getTglExpire(String NoMember){
        sql = "SELECT TglExpire FROM member WHERE NoMember='"+NoMember+"'";
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
    public void UpdateTglExpire(int KodeMember,Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "UPDATE member SET TglExpire='"+TglExp+"' WHERE KodeMember="+KodeMember;
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
    public void getMember(JTable tblMember){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember1(JTable tblMember,int KodeMember){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND m.KodeMember='"+KodeMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember2(JTable tblMember,String NamaMember){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND b.NamaBC LIKE '%"+NamaMember+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember3(JTable tblMember,String NoHP){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND b.NoHP1='"+NoHP+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember4(JTable tblMember,Double Diskon){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND m.Diskon="+Diskon;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember5(JTable tblMember,Calendar TglExpire){
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND m.TglExpire='"+TglExp+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember6(JTable tblMember,int Bulan,int Tahun){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND MONTH(m.TglExpire)="+Bulan+" AND "
                + "YEAR(m.TglExpire)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getMember7(JTable tblMember,String Level){
        sql = "SELECT m.KodeMember,m.NoMember,b.NamaBC,b.Alamat,b.Kelurahan,b.Kecamatan,b.Kota,b.NoHP1,m.Diskon,DATE_FORMAT(m.TglExpire,'%d-%m-%Y') "
                + "FROM member m INNER JOIN businesscontact b ON (m.KodeBC=b.KodeBC) WHERE (1=1) AND m.Level='"+Level+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblMember.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Member","No Member","Nama Member","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota",
                                    "No HP/WA","Diskon(%)","Tgl Expire"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,Double.class,String.class};
                
                @Override
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
            DefaultTableModel dtm = (DefaultTableModel)tblMember.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1); //Kode Member;
                rowdata[1] = rs.getString(2); //No Member;
                rowdata[2] = rs.getString(3); //Nama Member;
                rowdata[3] = rs.getString(4); //Alamat;
                rowdata[4] = rs.getString(5); //Kelurahan/Desa;
                rowdata[5] = rs.getString(6); //Kecamatan;
                rowdata[6] = rs.getString(7); //Kabupaten/Kota;
                rowdata[7] = rs.getString(8); //NoHP;
                rowdata[8] = rs.getDouble(9); //Diskon;
                rowdata[9] = rs.getString(10); //Tgl Expire;
                
                dtm.addRow(rowdata);
            }
            
            tblMember.getColumnModel().getColumn(0).setPreferredWidth(80); //KodeMember;
            tblMember.getColumnModel().getColumn(1).setPreferredWidth(70); //NoMember;
            tblMember.getColumnModel().getColumn(2).setPreferredWidth(100); //NamaMember;
            tblMember.getColumnModel().getColumn(3).setPreferredWidth(150); //Alamat;
            tblMember.getColumnModel().getColumn(4).setPreferredWidth(100); //Kelurahan/Desa;
            tblMember.getColumnModel().getColumn(5).setPreferredWidth(100); //Kecamatan;
            tblMember.getColumnModel().getColumn(6).setPreferredWidth(150); //Kabupaten/Kota;
            tblMember.getColumnModel().getColumn(7).setPreferredWidth(70);// NoHP;
            tblMember.getColumnModel().getColumn(8).setPreferredWidth(70);// Diskon;
            tblMember.getColumnModel().getColumn(9).setPreferredWidth(80);// TglExpire;
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan(String NoMember,int KodeBC,String Level,Double Diskon,Calendar TglExpire) throws SQLException{
        java.sql.Date TglExp = new java.sql.Date(TglExpire.getTimeInMillis());
        sql = "INSERT INTO member (NoMember,KodeBC,Level,Diskon,TglExpire) VALUES ('"+NoMember+"',"+KodeBC+",'"+Level+"',"+Diskon+",'"+TglExp+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMember = rs.getInt(1);
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
        sql = "INSERT INTO member (NoMember,KodeBC,Level,Diskon,TglExpire) VALUES (?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoMember);
            PS.setInt(2, KodeBC);
            PS.setString(3, Level);
            PS.setDouble(4, Diskon);
            PS.setDate(5, new java.sql.Date(TglExpire.getTimeInMillis()));
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeMember = rs.getInt(1);
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
        sql = "SELECT KodeMember,NoMember,KodeBC,Level,Diskon,TglExpire FROM member WHERE KodeMember="+KodeMember;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeMember = rs.getInt(1);
            NoMember = rs.getString(2);
            KodeBC = rs.getInt(3);
            Level = rs.getString(4);
            Diskon = rs.getDouble(5);
            TglExpire = Calendar.getInstance();
            TglExpire.setTime(rs.getDate(6));
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
        sql = "DELETE FROM member";
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
    public void Hapus1(int KodeMember) throws SQLException{
        sql = "DELETE FROM member WHERE KodeMember="+KodeMember;
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
    public void Hapus2(int KodeBC) throws SQLException{
        sql = "DELETE FROM member WHERE KodeBC="+KodeBC;
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
