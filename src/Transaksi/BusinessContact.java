/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Transaksi;

import Util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
/**
 *
 * @author Yestin
 */
public class BusinessContact {
    
    private int KodeBC;
    private String NoMember;
    private String NamaBC;
    private int JenisKontak;
    private String Alamat;
    private String Kelurahan;
    private String Kecamatan;
    private String Kota;
    private String Telpon1;
    private String Telpon2;
    private String NoHP1;
    private String NoHP2;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeBC(int KodeBC){
        this.KodeBC = KodeBC;
    }
    public int getKodeBC(){
        sql = "SELECT KodeBC FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public int getKodeBC(int Kode){
        sql = "SELECT KodeBC FROM businesscontact WHERE KodeBC="+Kode;
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
    public int getKodeBC(String NoMember){
        sql = "SELECT KodeBC FROM businesscontact WHERE NoMember='"+NoMember+"'";
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
    public int getKodeBC1(String NoHP1){
        sql = "SELECT KodeBC FROM businesscontact WHERE NoHP1='"+NoHP1+"'";
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
    public void setNoMember(String NoMember){
        this.NoMember = NoMember;
    }
    public String getNoMember(){
        return NoMember;
    }
    public String getNoMember(int KodeBC){
        sql = "SELECT NoMember FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public String getLastNoMember(){
        sql = "SELECT NoMember FROM businesscontact WHERE KodeBC=(SELECT MAX(KodeBC) FROM businesscontact)";
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
    public void UpdateNoMember(int KodeBC,String NoMember) throws SQLException{
        sql = "UPDATE businesscontact SET NoMember='"+NoMember+"' WHERE KodeBC="+KodeBC;
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
    public void setNamaBC(String NamaBC){
        this.NamaBC = NamaBC;
    }
    public String getNamaBC(){
        return NamaBC;
    }
    public String getNamaBC(int KodeBC){
        sql = "SELECT NamaBC FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaBC = rs.getString(1);
                return NamaBC;
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
    public void UpdateNamaBC(int KodeBC,String NamaBC) throws SQLException{
        sql = "UPDATE businesscontact SET NamaBC='"+NamaBC+"' WHERE KodeBC="+KodeBC;
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
    public void setJenisKontak(int JenisKontak){
        this.JenisKontak = JenisKontak;
    }
    public int getJenisKontak(){
        return JenisKontak;
    }
    public int getJenisKontak(int KodeBC){
        sql = "SELECT JenisKontak FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisKontak = rs.getInt(1);
                return JenisKontak;
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
    public void UpdateJenisKontak(int KodeBC,int JenisKontak) throws SQLException{
        sql = "UPDATE businesscontact SET JenisKontak="+JenisKontak+" WHERE KodeBC="+KodeBC;
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
    public String getAlamat(int KodeBC){
        sql = "SELECT Alamat FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public void UpdateAlamat(int KodeBC,String Alamat) throws SQLException{
        sql = "UPDATE businesscontact SET Alamat='"+Alamat+"' WHERE KodeBC="+KodeBC;
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
    public String getKelurahan(int KodeBC){
        sql = "SELECT Kelurahan FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public void UpdateKelurahan(int KodeBC,String Kelurahan) throws SQLException{
        sql = "UPDATE businesscontact SET Kelurahan='"+Kelurahan+"' WHERE KodeBC="+KodeBC;
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
    public String getKecamatan(int KodeBC){
        sql = "SELECT Kecamatan FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public void UpdateKecamatan(int KodeBC,String Kecamatan) throws SQLException{
        sql = "UPDATE businesscontact SET Kecamatan='"+Kecamatan+"' WHERE KodeBC="+KodeBC;
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
    public String getKota(int KodeBC){
        sql = "SELECT Kota FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public void UpdateKota(int KodeBC,String Kota) throws SQLException{
        sql = "UPDATE businesscontact SET Kota='"+Kota+"' WHERE KodeBC="+KodeBC;
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
    public void setTelpon1(String Telpon1){
        this.Telpon1 = Telpon1;
    }
    public String getTelpon1(){
        return Telpon1;
    }
    public String getTelpon1(int KodeBC){
        sql = "SELECT Telpon1 FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Telpon1 = rs.getString(1);
                return Telpon1;
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
    public void UpdateTelpon1(int KodeBC,String Telpon1) throws SQLException{
        sql = "UPDATE businesscontact SET Telpon1='"+Telpon1+"' WHERE KodeBC="+KodeBC;
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
    public void setTelpon2(String Telpon2){
        this.Telpon2 = Telpon2;
    }
    public String getTelpon2(){
        return Telpon2;
    }
    public String getTelpon2(int KodeBC){
        sql = "SELECT Telpon2 FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Telpon2 = rs.getString(1);
                return Telpon2;
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
    public void UpdateTelpon2(int KodeBC,String Telpon2) throws SQLException{
        sql = "UPDATE businesscontact SET Telpon2='"+Telpon2+"' WHERE KodeBC="+KodeBC;
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
    public void setNoHP1(String NoHP1){
        this.NoHP1 = NoHP1;
    }
    public String getNoHP1(){
        return NoHP1;
    }
    public String getNoHP1(int KodeBC){
        sql = "SELECT NoHP1 FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoHP1 = rs.getString(1);
                return NoHP1;
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
    public void UpdateNoHP1(int KodeBC,String NoHP1) throws SQLException{
        sql = "UPDATE businesscontact SET NoHP1='"+NoHP1+"' WHERE KodeBC="+KodeBC;
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
    public void setNoHP2(String NoHP2){
        this.NoHP2 = NoHP2;
    }
    public String getNoHP2(){
        return NoHP2;
    }
    public String getNoHP2(int KodeBC){
        sql = "SELECT NoHP2 FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoHP2 = rs.getString(1);
                return NoHP2;
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
    public void UpdateNoHP2(int KodeBC,String NoHP2) throws SQLException{
        sql = "UPDATE businesscontact SET NoHP2='"+NoHP2+"' WHERE KodeBC="+KodeBC;
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
    public void getBusinessContact(JComboBox cboBusinessContact){
        sql = "SELECT KodeBC,NoMember,NamaBC FROM businesscontact";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboBusinessContact.setModel(cbm);
            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeBC = rs.getInt(1);
                NoMember = rs.getString(2);
                NamaBC = rs.getString(3);
                
                cbm.addElement(KodeBC+" "+NoMember+" "+NamaBC);
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
    public void getBusinessContact(JTable tblBusinessContact){
        sql = "SELECT KodeBC,NamaBC,CASE WHEN (JenisKontak=1) THEN 'Supplier' WHEN (JenisKontak=2) THEN 'Pelanggan' END,"
                + "Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Business Contact","Jenis Kontak","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getBusinessContact(JTable tblBusinessContact,String NamaBC){
        sql = "SELECT KodeBC,NamaBC,CASE WHEN (JenisKontak=1) THEN 'Supplier' WHEN (JenisKontak=2) THEN 'Pelanggan' END,"
                + "Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE NamaBC LIKE '%"+NamaBC+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Business Contact","Jenis Kontak","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getBusinessContact(JTable tblBusinessContact,int JenisKontak){
        sql = "SELECT KodeBC,NamaBC,CASE WHEN (JenisKontak=1) THEN 'Supplier' WHEN (JenisKontak=2) THEN 'Pelanggan' END,"
                + "Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE JenisKontak="+JenisKontak;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Business Contact","Jenis Kontak","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getBusinessContact(JTable tblBusinessContact,String NamaBC,int JenisKontak){
        sql = "SELECT KodeBC,NamaBC,CASE WHEN (JenisKontak=1) THEN 'Supplier' WHEN (JenisKontak=2) THEN 'Pelanggan' END,"
                + "Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE NamaBC LIKE '%"+NamaBC+"%' "
                + "AND JenisKontak="+JenisKontak;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Business Contact","Jenis Kontak","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getSupplier(JTable tblBusinessContact){
        sql = "SELECT KodeBC,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE JenisKontak=1";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Supplier","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
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
    public void getSupplier(JTable tblBusinessContact,String NamaSupplier){
        sql = "SELECT KodeBC,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE JenisKontak=1 AND "
                + "NamaBC LIKE '%"+NamaSupplier+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Nama Supplier","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
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
    public void getCustomer(JTable tblBusinessContact){
        sql = "SELECT KodeBC,NoMember,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE "
                + "JenisKontak=2";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Kode Member","Nama Customer","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getCustomer1(JTable tblBusinessContact,String KodeMember){
        sql = "SELECT KodeBC,NoMember,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE "
                + "JenisKontak=2 AND KodeMember='"+KodeMember+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Kode Member","Nama Customer","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getCustomer2(JTable tblBusinessContact,String NamaBC){
        sql = "SELECT KodeBC,NoMember,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE "
                + "JenisKontak=2 AND NamaBC LIKE '%"+NamaBC+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Kode Member","Nama Customer","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void getCustomer(JTable tblBusinessContact,String KodeMember,String NamaCustomer){
        sql = "SELECT KodeBC,NoMember,NamaBC,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2 FROM businesscontact WHERE "
                + "JenisKontak=2 AND KodeMember='"+KodeMember+"' AND NamaBC LIKE '%"+NamaCustomer+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBusinessContact.setModel(new DefaultTableModel(){
                String ColName[] = {"KodeBC","Kode Member","Nama Customer","Alamat","Kelurahan/Desa","Kecamatan","Kabupaten/Kota","Telpon1",
                                    "Telpon2","No HP1","No HP2"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBusinessContact.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                rowdata[9] = rs.getString(10);
                rowdata[10] = rs.getString(11);
                
                dtm.addRow(rowdata);
            }
            
            tblBusinessContact.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblBusinessContact.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBusinessContact.getColumnModel().getColumn(3).setPreferredWidth(200);
            tblBusinessContact.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(6).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(9).setPreferredWidth(100);
            tblBusinessContact.getColumnModel().getColumn(10).setPreferredWidth(100);
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
    public void Simpan(String NoMember,String NamaBC,int JenisKontak,String Alamat,String Kelurahan,String Kecamatan,String Kota,String Telpon1,String Telpon2,
            String NoHP1,String NoHP2) throws SQLException{
        sql = "INSERT INTO businesscontact (NoMember,NamaBC,JenisKontak,Alamat,Kelurahan,Kecamatan,Kota,"
                + "Telpon1,Telpon2,NoHP1,NoHP2) VALUES ('"+NoMember+"','"+NamaBC+"',"+JenisKontak+","
                + "'"+Alamat+"','"+Kelurahan+"','"+Kecamatan+"','"+Kota+"','"+Telpon1+"','"+Telpon2+"',"
                + "'"+NoHP1+"','"+NoHP2+"')";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeBC = rs.getInt(1);
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
        sql = "INSERT INTO businesscontact (NoMember,NamaBC,JenisKontak,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,NoHP1,NoHP2) "
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoMember);
            PS.setString(2, NamaBC);
            PS.setInt(3, JenisKontak);
            PS.setString(4, Alamat);
            PS.setString(5, Kelurahan);
            PS.setString(6, Kecamatan);
            PS.setString(7, Kota);
            PS.setString(8, Telpon1);
            PS.setString(9, Telpon2);
            PS.setString(10, NoHP1);
            PS.setString(11, NoHP2);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeBC = rs.getInt(1);
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
        sql = "SELECT KodeBC,NoMember,NamaBC,JenisKontak,Alamat,Kelurahan,Kecamatan,Kota,Telpon1,Telpon2,"
                + "NoHP1,NoHP2 FROM businesscontact WHERE KodeBC="+KodeBC;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeBC = rs.getInt(1);
            NoMember = rs.getString(2);
            NamaBC = rs.getString(3);
            JenisKontak = rs.getInt(4);
            Alamat = rs.getString(5);
            Kelurahan = rs.getString(6);
            Kecamatan = rs.getString(7);
            Kota = rs.getString(8);
            Telpon1 = rs.getString(9);
            Telpon2 = rs.getString(10);
            NoHP1 = rs.getString(11);
            NoHP2 = rs.getString(12);
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
    public void Hapus(int KodeBC) throws SQLException{
        sql = "DELETE FROM businesscontact WHERE KodeBC="+KodeBC;
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
    public void Hapus() throws SQLException{
        sql = "DELETE FROM businesscontact";
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
