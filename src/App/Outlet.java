/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import java.sql.*;
import javax.swing.*;
import Util.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class Outlet {
    
    private int KodeOutlet;
    private String NamaOutlet;
    private String Alamat;
    private String Kelurahan;
    private String Kecamatan;
    private String Kota;
    private String Provinsi;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeOutlet(int KodeOutlet){
        this.KodeOutlet = KodeOutlet;
    }
    public int getKodeOutlet(){
        return KodeOutlet;
    }
    public int getKodeOutlet(int Kode){
        sql = "SELECT KodeOutlet FROM outlet WHERE KodeOutlet="+Kode;
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
    public void setNamaOutlet(String NamaOutlet){
        this.NamaOutlet = NamaOutlet;
    }
    public String getNamaOutlet(){
        return NamaOutlet;
    }
    public String getNamaOutlet(int KodeOutlet){
        sql = "SELECT NamaOutlet FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaOutlet = rs.getString(1);
                return NamaOutlet;
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
    public void UpdateNamaOutlet(int KodeOutlet,String NamaOutlet) throws SQLException{
        sql = "UPDATE outlet SET NamaOutlet='"+NamaOutlet+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void setAlamat(String Alamat){
        this.Alamat = Alamat;
    }
    public String getAlamat(){
        return Alamat;
    }
    public String getAlamat(int KodeOutlet){
        sql = "SELECT Alamat FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Alamat = rs.getString(1);
                return Alamat;
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
    public void UpdateAlamat(int KodeOutlet,String Alamat) throws SQLException{
        sql = "UPDATE outlet SET Alamat='"+Alamat+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void setKelurahan(String Kelurahan){
        this.Kelurahan = Kelurahan;
    }
    public String getKelurahan(){
        return Kelurahan;
    }
    public String getKelurahan(int KodeOutlet){
        sql = "SELECT Kelurahan FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kelurahan = rs.getString(1);
                return Kelurahan;
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
    public void UpdateKelurahan(int KodeOutlet,String Kelurahan) throws SQLException{
        sql = "UPDATE outlet SET Kelurahan='"+Kelurahan+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void setKecamatan(String Kecamatan){
        this.Kecamatan = Kecamatan;
    }
    public String getKecamatan(){
        return Kecamatan;
    }
    public String getKecamatan(int KodeOutlet){
        sql = "SELECT Kecamatan FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kecamatan = rs.getString(1);
                return Kecamatan;
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
    public void UpdateKecamatan(int KodeOutlet,String Kecamatan) throws SQLException{
        sql = "UPDATE outlet SET Kecamatan='"+Kecamatan+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void setKota(String Kota){
        this.Kota = Kota;
    }
    public String getKota(){
        return Kota;
    }
    public String getKota(int KodeOutlet){
        sql = "SELECT Kota FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kota = rs.getString(1);
                return Kota;
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
    public void UpdateKota(int KodeOutlet,String Kota) throws SQLException{
        sql = "UPDATE outlet SET Kota='"+Kota+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void setProvinsi(String Provinsi){
        this.Provinsi = Provinsi;
    }
    public String getProvinsi(){
        return Provinsi;
    }
    public String getProvinsi(int KodeOutlet){
        sql = "SELECT Provinsi FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Provinsi = rs.getString(1);
                return  Provinsi;
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
    public void UpdateProvinsi(int KodeOutlet,String Provinsi) throws SQLException{
        sql = "UPDATE outlet SET Provinsi='"+Provinsi+"' WHERE KodeOutlet="+KodeOutlet;
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
    public void getOutlet(JComboBox cboOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet FROM outlet";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboOutlet.setModel(cbm);
//            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeOutlet = rs.getInt(1);
                NamaOutlet = rs.getString(2);
                
                cbm.addElement(KodeOutlet+" "+NamaOutlet);
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
    public void getOutlet(JComboBox cboOutlet,int KodeOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboOutlet.setModel(cbm);
            cbm.addElement("-Pilih-");
            while(rs.next()){
                KodeOutlet = rs.getInt(1);
                NamaOutlet = rs.getString(2);
                
                cbm.addElement(KodeOutlet+" "+NamaOutlet);
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
    public void getOutlet(JComboBox cboOutlet,String NamaOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet FROM outlet WHERE NamaOutlet='"+NamaOutlet+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboOutlet.setModel(cbm);
            cbm.addElement("-Pilih-");
            while(rs.next()){
                KodeOutlet = rs.getInt(1);
                NamaOutlet = rs.getString(2);
                
                cbm.addElement(KodeOutlet+" "+NamaOutlet);
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
    public void getOutlet(JComboBox cboOutlet,int KodeOutlet,String NamaOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet FROM outlet WHERE KodeOutlet="+KodeOutlet+" AND NamaOutlet='"+NamaOutlet+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboOutlet.setModel(cbm);
            cbm.addElement("-Pilih-");
            while(rs.next()){
                KodeOutlet = rs.getInt(1);
                NamaOutlet = rs.getString(2);
                
                cbm.addElement(KodeOutlet+" "+NamaOutlet);
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
    public void getOutlet(JTable tblOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet,Alamat,Kelurahan,Kecamatan,Kota,Provinsi FROM outlet WHERE KodeOutlet>0";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOutlet.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Outlet","Nama Outlet","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Provinsi"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 7;
                }
            });
            
            Object rowdata[] = new Object[7];
            DefaultTableModel dtm = (DefaultTableModel)tblOutlet.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                
                dtm.addRow(rowdata);
            }
            
            tblOutlet.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblOutlet.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(6).setPreferredWidth(150);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void getOutlet(JTable tblOutlet,String NamaOutlet){
        sql = "SELECT KodeOutlet,NamaOutlet,Alamat,Kelurahan,Kecamatan,Kota,Provinsi FROM outlet WHERE KodeOutlet>0 AND "
                + "NamaOutlet LIKE '%"+NamaOutlet+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblOutlet.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Outlet","Nama Outlet","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Provinsi"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                @Override
                public int getColumnCount(){
                    return 7;
                }
            });
            
            Object rowdata[] = new Object[7];
            DefaultTableModel dtm = (DefaultTableModel)tblOutlet.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                
                dtm.addRow(rowdata);
            }
            
            tblOutlet.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(2).setPreferredWidth(250);
            tblOutlet.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblOutlet.getColumnModel().getColumn(6).setPreferredWidth(150);
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void Simpan(String NamaOutlet,String Alamat,String Kelurahan,String Kecamatan,String Kota,String Provinsi) throws SQLException{
        sql = "INSERT INTO outlet (NamaOutlet,Alamat,Kelurahan,Kecamatan,Kota,Provinsi) VALUES ('"+NamaOutlet+"','"+Alamat+"','"+Kelurahan+"',"
                + "'"+Kecamatan+"','"+Kota+"','"+Provinsi+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeOutlet = rs.getInt(1);
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
        sql = "INSERT INTO outlet (NamaOutlet,Alamat,Kelurahan,Kecamatan,Kota,Provinsi) VALUES (?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NamaOutlet);
            PS.setString(2, Alamat);
            PS.setString(3, Kelurahan);
            PS.setString(4, Kecamatan);
            PS.setString(5, Kota);
            PS.setString(6, Provinsi);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeOutlet = rs.getInt(1);
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
        sql = "SELECT KodeOutlet,NamaOutlet,Alamat,Kelurahan,Kecamatan,Kota,Provinsi FROM outlet WHERE KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOutlet = rs.getInt(1);
            NamaOutlet = rs.getString(2);
            Alamat = rs.getString(3);
            Kelurahan = rs.getString(4);
            Kecamatan = rs.getString(5);
            Kota = rs.getString(6);
            Provinsi = rs.getString(7);
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
        sql = "DELETE FROM outlet";
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
    public void Hapus(int KodeOutlet) throws SQLException{
        sql = "DELETE FROM outelt WHERE KodeOutlet='"+KodeOutlet+"'";
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
