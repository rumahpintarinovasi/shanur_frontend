/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Pekerjaan {
    
    private int KodeKerja;
    private String NoIdentitas;
    private int KodeJob;
    private int KodeOutlet;
    private int JenisPembayaran;
    private Double Gaji;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeKerja(int KodeKerja){
        this.KodeKerja = KodeKerja;
    }
    public int getKodeKerja(){
        return KodeKerja;
    }
    public int getKodeKerja(int Kode){
        sql = "SELECT KodeKerja FROM pekerjaan WHERE KodeKerja="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKerja = rs.getInt(1);
                return KodeKerja;
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
    public void setNoidentitas(String NoIdentitas){
        this.NoIdentitas = NoIdentitas;
    }
    public String getNoIdentitas(){
        return NoIdentitas;
    }
    public String getNoIdentitas(int KodeKerja){
        sql = "SELECT NoIdentitas FROM pekerjaan WHERE KodeKerja="+KodeKerja;
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
    public void UpdateNoIdentitas(int KodeKerja,String NoIdentitas) throws SQLException{
        sql = "UPDATE pekerjaan SET NoIdentitas='"+NoIdentitas+"' WHERE KodeKerja="+KodeKerja;
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
    public void setKodeJob(int KodeJob){
        this.KodeJob = KodeJob;
    }
    public int getKodeJob(){
        return KodeJob;
    }
    public int getKodeJob(int KodeKerja){
        sql = "SELECT KodeJob FROM pekerjaan WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeJob = rs.getInt(1);
                return KodeJob;
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
    public int getKodeJob(String NoIdentitas){
        sql = "SELECT KodeJob FROM pekerjaan WHERE KodeKerja="+KodeKerja;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeJob = rs.getInt(1);
                return KodeJob;
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
    public void UpdateKodeJob(int KodeKerja,int KodeJob) throws SQLException{
        sql = "UPDATE pekerjaan SET KodeJob="+KodeJob+" WHERE KodeKerja="+KodeKerja;
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
    public void UpdteKodeJob(String NoIdentitas,int KodeJob) throws SQLException{
        sql = "UPDATE pekerjaan SET KodeJob="+KodeJob+" AND NoIdentitas='"+NoIdentitas+"'";
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
    public int getKodeOutlet(int KodeKerja){
        sql = "SELECT KodeOutlet FROM pekerjaan WHERE KodeKerja="+KodeKerja;
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
        sql = "SELECT KodeOutlet FROM pekerjaan WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdateKodeOutlet(int KodeKerja,int KodeOutlet) throws SQLException{
        sql = "UPDATE pekerjaan SET KodeOutlet="+KodeOutlet+" WHERE KodeKerja="+KodeKerja;
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
    public void UdateKodeOutlet(String NoIdentitas,int KodeOutlet) throws SQLException{
        sql = "UPDATE pekerjaan SET KodeOutlet="+KodeOutlet+" WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setJenisPembayaran(int JenisPembayaran){
        this.JenisPembayaran = JenisPembayaran;
    }
    public int getJenisPembayaran(){
        return JenisPembayaran;
    }
    public int getJenisPembayaran(int KodeKerja){
        sql = "SELECT JenisPembayaran FROM pekerjaan WHERE KodeKerja="+KodeKerja;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisPembayaran = rs.getInt(1);
                return JenisPembayaran;
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
    public int getJenisPembayaran(String NoIdentitas){
        sql = "SELECT JenisPembayaran FROM pekerjaan WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisPembayaran = rs.getInt(1);
                return JenisPembayaran;
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
    public void UpdateJenisPembayaran(int KodeKerja,int JenisPembayaran) throws SQLException{
        sql = "UPDATE pekerjaan SET JenisPembayaran="+JenisPembayaran+" WHERE KodeKerja="+KodeKerja;
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
    public void UpdateJenisPembayaran(String NoIdentitas,int JenisPembayaran) throws SQLException{
        sql = "UPDATE pekerjaan SET JenisPembayaran="+JenisPembayaran+" WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setGaji(Double Gaji){
        this.Gaji = Gaji;
    }
    public Double getGaji(){
        return Gaji;
    }
    public Double getGaji(int KodeKerja){
        sql = "SELECT Gaji FROM pekerjaan WHERE KodeKerja="+KodeKerja;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Gaji = rs.getDouble(1);
                return Gaji;
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
    public Double getGaji(String NoIdentitas){
        sql = "SELECT Gaji FROM pekerjaan WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Gaji = rs.getDouble(1);
                return Gaji;
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
    public void UpdateBiaya(int KodeKerja,Double Gaji) throws SQLException{
        sql = "UPDATE pekerjaan SET Gaji="+Gaji+" WHERE KodeKerja="+KodeKerja;
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
    public void UpdateBiaya(String NoIdentitas,Double Gaji) throws SQLException{
        sql = "UPDATE pekerjaan SET Gaji="+Gaji+" WHERE NoIdentita='"+NoIdentitas+"'";
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
    public void getDriver(JComboBox cboJenisPekerjaan){
        sql = "SELECT p.KodeKerja,i.NamaLengkap FROM pekerjaan p INNER JOIN jenispekerjaan j INNER JOIN identitas i "
                + "ON (p.NoIdentitas=i.NoIdentitas AND j.KodeJob=p.KodeJob) WHERE (1=1) AND j.NamaPekerjaan='Driver'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            DefaultComboBoxModel cbm = new DefaultComboBoxModel();
            cboJenisPekerjaan.setModel(cbm);
            
            cbm.addElement("- Pilih -");
            while(rs.next()){
                KodeKerja = rs.getInt(1);
                String Nama = rs.getString(2);
                
                cbm.addElement(KodeKerja+" "+Nama);
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
    public void getPekerjaan(JTable tblPekerjaan){
        sql = "SELECT p.KodeKerja,i.NoIdentitas,i.NamaLengkap,j.NamaPekerjaan,o.NamaOutlet,"
                + "CASE WHEN (p.JenisPembayaran=1) THEN 'Gaji' WHEN (p.JenisPembayaran)=2 THEN 'Freelance' END,p.Gaji "
                + "FROM pekerjaan p INNER JOIN identitas i INNER JOIN jenispekerjaan j INNER JOIN outlet o "
                + "ON (p.NoIdentitas=i.NoIdentitas AND p.KodeJob=j.KodeJob AND p.KodeOutlet=o.KodeOutlet) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Kerja","No Identitas","Nama Lengkap","Pekerjaan","Outlet","Jenis Pembayaran","Gaji"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblPekerjaan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void getPekerjaan(JTable tblPekerjaan,String NamaLengkap){
        sql = "SELECT p.KodeKerja,i.NoIdentitas,i.NamaLengkap,j.NamaPekerjaan,o.NamaOutlet,"
                + "CASE WHEN (p.JenisPembayaran=1) THEN 'Gaji' WHEN (p.JenisPembayaran)=2 THEN 'Freelance' END,p.Gaji "
                + "FROM pekerjaan p INNER JOIN identitas i INNER JOIN jenispekerjaan j INNER JOIN outlet o "
                + "ON (p.NoIdentitas=i.NoIdentitas AND p.KodeJob=j.KodeJob AND p.KodeOutlet=o.KodeOutlet) WHERE (1=1) AND "
                + "i.NamaLengkap LIKE '%"+NamaLengkap+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Kerja","No Identitas","Nama Lengkap","Pekerjaan","Outlet","Jenis Pembayaran","Gaji"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblPekerjaan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void getPekerjaan(JTable tblPekerjaan,int KodeJob){
        sql = "SELECT p.KodeKerja,i.NoIdentitas,i.NamaLengkap,j.NamaPekerjaan,o.NamaOutlet,"
                + "CASE WHEN (p.JenisPembayaran=1) THEN 'Gaji' WHEN (p.JenisPembayaran)=2 THEN 'Freelance' END,p.Gaji "
                + "FROM pekerjaan p INNER JOIN identitas i INNER JOIN jenispekerjaan j INNER JOIN outlet o "
                + "ON (p.NoIdentitas=i.NoIdentitas AND p.KodeJob=j.KodeJob AND p.KodeOutlet=o.KodeOutlet) WHERE (1=1) AND "
                + "j.KodeJob="+KodeJob;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Kerja","No Identitas","Nama Lengkap","Pekerjaan","Outlet","Jenis Pembayaran","Gaji"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblPekerjaan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void getOpportunity(JTable tblPekerjaan,int KodeOutlet){
        sql = "SELECT p.KodeKerja,i.NoIdentitas,i.NamaLengkap,j.NamaPekerjaan,o.NamaOutlet,"
                + "CASE WHEN (p.JenisPembayaran=1) THEN 'Gaji' WHEN (p.JenisPembayaran)=2 THEN 'Freelance' END,p.Gaji "
                + "FROM pekerjaan p INNER JOIN identitas i INNER JOIN jenispekerjaan j INNER JOIN outlet o "
                + "ON (p.NoIdentitas=i.NoIdentitas AND p.KodeJob=j.KodeJob AND p.KodeOutlet=o.KodeOutlet) WHERE (1=1) "
                + "AND o.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblPekerjaan.setModel(new DefaultTableModel(){
                String ColName[] = {"Kode Kerja","No Identitas","Nama Lengkap","Pekerjaan","Outlet","Jenis Pembayaran","Gaji"};
                Class ColType[] = {Integer.class,String.class,String.class,String.class,String.class,String.class,Double.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblPekerjaan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getInt(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getDouble(7);
                
                dtm.addRow(rowdata);
            }
            
            tblPekerjaan.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblPekerjaan.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblPekerjaan.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblPekerjaan.getColumnModel().getColumn(6).setPreferredWidth(100);
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
    public void Simpan(String NoIdentitas,int KodeJob,int KodeOutlet,int JenisPembayaran,Double Gaji) throws SQLException{
        sql = "INSERT INTO pekerjaan (NoIdentitas,KodeJob,KodeOutlet,JenisPembayaran,Gaji) VALUES ('"+NoIdentitas+"',"+KodeJob+","+KodeOutlet+","
                +JenisPembayaran+","+Gaji+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeKerja = rs.getInt(1);
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
        sql = "INSERT INTO pekerjaan (NoIdentitas,KodeJob,KodeOutlet,JenisPembayaran,Gaji) VALUES(?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setString(1, NoIdentitas);
            PS.setInt(2, KodeJob);
            PS.setInt(3, KodeOutlet);
            PS.setInt(4, JenisPembayaran);
            PS.setDouble(5, Gaji);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeKerja = rs.getInt(1);
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
        sql = "SELECT KodeKerja,NoIdentitas,KodeJob,KodeOutlet,JenisPembayaran,Gaji FROM pekerjaan WHERE KodeKerja="+KodeKerja;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeKerja = rs.getInt(1);
            NoIdentitas = rs.getString(2);
            KodeJob = rs.getInt(3);
            KodeOutlet = rs.getInt(4);
            JenisPembayaran = rs.getInt(5);
            Gaji = rs.getDouble(6);
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
        sql = "DELETE FROM pekerjaan";
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
    public void Hapus(int KodeKerja) throws SQLException{
        sql = "DELETE FROM pekerjaan WHERE KodeKerja="+KodeKerja;
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
    public void Hapus(String NoIdentitas) throws SQLException{
        sql = "DELETE FROM pekerjaan WHERE NoIdentitas='"+NoIdentitas+"'";
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
