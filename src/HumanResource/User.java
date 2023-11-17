/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class User {
    
    private int KodeUser;
    private String NoIdentitas;
    private int KodeOutlet;
    private String Username;
    private String Password;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeUser(int KodeUser){
        this.KodeUser = KodeUser;
    }
    public int getKodeUser(){
        return KodeUser;
    }
    public int getKodeUser(int Kode){
        sql = "SELECT KodeUser FROM user WHERE KodeUser="+Kode;
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
    public int getKodeUsr(int KodeOutlet){
        sql = "SELECT KodeUser FROM user WHERE KodeOutlet="+KodeOutlet;
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
    public int getKodeUser(String Username,String Password){
        sql = "SELECT KodeUser FROM user WHERE Username='"+Username+"' AND Password=SHA2('"+Password+"',512)";
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
    public int getLastKodeUser(){
        sql = "SELECT KodeUser FROM user WHERE KodeUser=(SELECT MAX(KodeUser) FROM user)";
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
    public int getLastKodeUser(String NoIdentitas,int KodeOutlet){
        sql = "SELECT KodeUser FROM user WHERE KodeUser = (SELECT MAX(KodeUser) FROM user WHERE NoIdentitas='"+NoIdentitas+"' AND "
                + "KodeOutlet="+KodeOutlet+")";
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
    public int getAllKodeUser(){
        sql = "SELECT KodeUser FROM user";
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
    public int getRowCount(){
        sql = "SELECT COUNT(*) FROM user";
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
    public void setNoIdentitas(String NoIdentitas){
        this.NoIdentitas = NoIdentitas;
    }
    public String getNoIdentitas(){
        return NoIdentitas;
    }
    public String getNoIdentitas(int KodeUser){
        sql = "SELECT NoIdentitas FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoIdentitas = rs.getString(1);
                return NoIdentitas;
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
    public String getNoIdentitas(String NoId){
        sql = "SELECT NoIdentitas FROM user WHERE NoIdentitas='"+NoId+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoIdentitas = rs.getString(1);
                return NoIdentitas;
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
    public void UpdateNoIdentitas(int KodeUser,String NoIdentitas) throws SQLException{
        sql = "UPDATE user SET NoIdentitas='"+NoIdentitas+"' WHERE KodeUser="+KodeUser;
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
    public int getKodeOutlet(int KodeUser){
        sql = "SELECT KodeOutlet FROM user WHERE KodeUser="+KodeUser;
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
    public int getKodeOutlet(String NoIdentitas){
        sql = "SELECT KodeOutlet FROM user WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdateKodeOutlet(int KodeUser,int KodeOutlet) throws SQLException{
        sql = "UPDATE user SET KodeOutlet="+KodeOutlet+" WHERE KodeUser="+KodeOutlet;
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
    public void UpdateKodeOutlet(String NoIdentitas,int KodeOutlet) throws SQLException{
        sql = "UPDATE user SET KodeOutlet="+KodeOutlet+" WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setUsername(String Username){
        this.Username = Username;
    }
    public String getUsername(){
        return Username;
    }
    public String getUsername(int KodeUser){
        sql = "SELECT Username FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Username = rs.getString(1);
                return Username;
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
    public String getUsername(String NoIdentitas){
        sql = "SELECT Username FROM user WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Username = rs.getString(1);
                return Username;
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
    public void UpdateUsername(int KodeUser,String Username) throws SQLException{
        sql = "UPDATE user SET Username='"+Username+"' WHERE KodeUser="+KodeUser;
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
    public void UpdateUsername(String NoIdentitas,String Username) throws SQLException{
        sql = "UPDATE user SET Username='"+Username+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setPassword(String Password){
        this.Password = Password;
    }
    public String getPassword(){
        return Password;
    }
    public String getPassword(int KodeUser){
        sql = "SELECT Password FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public String getPassword(String NoIdentitas){
        sql = "SELECT Password FROM user WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public String getPasswordSHA2(int KodeUser){
        sql = "SELECT SHA2('Password', 532) FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public String getPasswordSHA2(String NoIdentitas){
        sql = "SELECT SHA2('Password', 512) FROM user WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public String getPasswordMD5(int KodeUser){
        sql = "SELECT MD5('Password') FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public String getPasswordMD5(String NoIdentitas){
        sql = "SELECT MD5('Password') WHERE NoIdenititas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Password = rs.getString(1);
                return Password;
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
    public void UpdatePasswordSHA2(int KodeUser,String Password) throws SQLException{
        sql = "UPDATE user SET Password=SHA2('"+Password+"',512) WHERE KodeUser="+KodeUser;
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
    public void UpdatePasswordSHA2(String NoIdentitas,String Password) throws SQLException{
        sql = "UPDATE user SET Password=SHA2('"+Password+"',512) WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdatePasswordMD5(int KodeUser,String Password) throws SQLException{
        sql = "UPDATE user SET Password=MD5('"+Password+"') WHERE KodeUser="+KodeUser;
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
    public void UpdatePasswordMD5(String NoIdentitas,String Password) throws SQLException{
        sql = "UPDATE user SET Password=MD5('"+Password+"') WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public String getNoIdentitasMD5(String Password,String Username) throws SQLException{
        User retval = null;
        sql = "SELECT NoIdentitas,MD5('"+Password+"'),Password FROM user WHERE Username='"+Username+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return null;
            }
            NoIdentitas = rs.getString(1);
            String MD5 = rs.getString(2);
            String Psw = rs.getString(3);
            
            if(Psw.equals(MD5)){
                retval = new User();
                retval.setNoIdentitas(rs.getString(1));
                retval.setUsername(rs.getString(2));
                retval.setPassword(rs.getString(3));
                
                return NoIdentitas;
            }
            else{
                return null;
            }
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
    public String getNoIdentitasSHA2(String Password,String Username) throws SQLException{
        User retval = null;
        sql = "SELECT NoIdentitas,SHA2('"+Password+"',512),Password FROM user WHERE Username='"+Username+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return null;
            }
            NoIdentitas = rs.getString(1);
            String SHA2 = rs.getString(2);
            String Psw = rs.getString(3);
            
            if(Psw.equals(SHA2)){
                retval = new User();
                retval.setNoIdentitas(rs.getString(1));
                retval.setUsername(rs.getString(2));
                retval.setPassword(rs.getString(3));
                
                return NoIdentitas;
            }
            else{
                return null;
            }
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
    public static User ValidateUserLoginSHA2(String Password,String Username) throws SQLException{
        User retval = null;
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT SHA2('"+Password+"',512),Password FROM user WHERE Username='"+Username+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return null;
            }
            String SHA2 = rs.getString(1);
            String Psw = rs.getString(2);
            
            if(Psw.equals(SHA2)){
                retval = new User();
                retval.setUsername(rs.getString(1));
                retval.setPassword(rs.getString(2));
                
                return retval;
            }
            else{
                return null;
            }
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
    public static User ValidateUserLoginMD5(String Password,String Username) throws SQLException{
        User retval = null;
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT MD5('"+Password+"'),Password FROM user WHERE Username='"+Username+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return null;
            }
            String MD5 = rs.getString(1);
            String Psw = rs.getString(2);
            
            if(Psw.equals(MD5)){
                retval = new User();
                retval.setUsername(rs.getString(1));
                retval.setPassword(rs.getString(2));
                
                return retval;
            }
            else{
                return null;
            }
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
    public void getUser(JComboBox cboUser){
        sql = "SELECT u.KodeUser,i.NamaLengkap FROM user u INNER JOIN identitas i ON (i.NoIdentitas=u.NoIdentitas) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboUser.setModel(cbm);
            cbm.addElement("-Pilih-");
            while(rs.next()){
                KodeUser = rs.getInt(1);
                String Nama = rs.getString(2);
                
                cbm.addElement(KodeUser+" "+Nama);
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
    public void getUser(JTable tblUser){
        sql = "SELECT u.KodeUser,u.NoIdentitas,i.NamaLengkap,o.NamaOutlet,u.UserName FROM user u INNER JOIN identitas i INNER JOIN outlet o "
                + "ON (u.NoIdentitas=i.NoIdentitas AND u.KodeOutlet=o.KodeOutlet) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblUser.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode User","No Identitas","Nama Lengkap","Outlet","Username"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblUser.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblUser.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblUser.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(4).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getUser1(JTable tblUser,String Nama){
        sql = "SELECT u.KodeUser,u.NoIdentitas,i.NamaLengkap,o.NamaOutlet,u.UserName FROM user u INNER JOIN identitas i INNER JOIN outlet o "
                + "ON (u.NoIdentitas=i.NoIdentitas AND u.KodeOutlet=o.KodeOutlet) WHERE (1=1) AND i.NamaLengkap LIKE '%"+Nama+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblUser.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode User","No Identitas","Nama Lengkap","Outlet","Username"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblUser.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblUser.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblUser.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(4).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getUser2(JTable tblUser,int KodeOutlet){
        sql = "SELECT u.KodeUser,u.NoIdentitas,i.NamaLengkap,o.NamaOutlet,u.UserName FROM user u INNER JOIN identitas i INNER JOIN outlet o "
                + "ON (u.NoIdentitas=i.NoIdentitas AND u.KodeOutlet=o.KodeOutlet) WHERE (1=1) AND u.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblUser.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode User","No Identitas","Nama Lengkap","Outlet","Username"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 5;
                }
            });
            
            Object rowdata[] = new Object[5];
            DefaultTableModel dtm = (DefaultTableModel)tblUser.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblUser.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblUser.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblUser.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblUser.getColumnModel().getColumn(4).setPreferredWidth(100);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void SimpanSHA2(String NoIdentitas,int KodeOutlet,String Username,String Password) throws SQLException{
        sql = "INSERT INTO user (NoIdentitas,KodeOutlet,Username,Password) VALUES ('"+NoIdentitas+"',"+KodeOutlet+",'"+Username+"',"
                + "SHA2('"+Password+"',512))";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeUser = rs.getInt(1);
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
    public void SimpanMD5(String NoIdentitas,int KodeOutlet,String Username,String Password) throws SQLException{
        sql = "INSERT INTO user (NoIdentitas,KodeOutlet,Username,Password) VALUES ('"+NoIdentitas+"',"+KodeOutlet+",'"+Username+"',"
                + "MD5('"+Password+"')";
        try {
            stmt = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeUser = rs.getInt(1);
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
    public void SimpanSHA2() throws SQLException{
        sql = "INSERT INTO user (NoIdentitas,KodeOutlet,Username,Password) VALUES(?,?,?,SHA2(?,512))";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoIdentitas);
            PS.setInt(2, KodeOutlet);
            PS.setString(3, Username);
            PS.setString(4, Password);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeUser = rs.getInt(1);
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
    public void SimpanMD5() throws SQLException{
        sql = "INSERT INTO user (NoIdentitas,KodeOutlet,Username,Password) VALUES (?,?,?,MD5(?))";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoIdentitas);
            PS.setInt(2, KodeOutlet);
            PS.setString(3, Username);
            PS.setString(4, Password);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeUser = rs.getInt(1);
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
        sql = "SELECT KodeUser,NoIdentitas,KodeOutlet,Username,Password FROM user WHERE KodeUser="+KodeUser;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeUser = rs.getInt(1);
            NoIdentitas = rs.getString(2);
            KodeOutlet = rs.getInt(3);
            Username = rs.getString(4);
            Password = rs.getString(5);
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
        sql = "DELETE FROM user";
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
    public void Hapus(int KodeUser) throws SQLException{
        sql = "DELETE FROM user WHERE KodeUser="+KodeUser;
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
