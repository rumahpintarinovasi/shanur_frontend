/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Financial;

import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Keuangan {
    
    private int KodeFin;
    private int KodeOutlet;
    private Calendar Tanggal;
    private String NoAkun;
    private int KodePenyimpanan;
    private Double Debet;
    private Double Kredit;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    public void setKodeFin(int KodeFin){
        this.KodeFin = KodeFin;
    }
    public int getKodeFin(){
        return KodeFin;
    }
    public int getKodeFin(int Kode){
        sql = "SELECT KodeFin FROM keuangan WHERE KodeFin="+Kode;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeFin = rs.getInt(1);
                return KodeFin;
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
    public int getKodeFin(int KodeOutlet,String NoAkun,Calendar Tanggal,int KodePenyimpanan){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeFin FROM keuangan WHERE KodeOutlet="+KodeOutlet+" AND NoAkun='"+NoAkun+"' AND Tanggal='"+Tgl+"' AND "
                + "KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeFin = rs.getInt(1);
                return KodeFin;
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
    public int getLastKodeFin(){
        sql = "SELECT KodeFin FROM keuangan WHERE KodeFin=(SELECT MAX(KodeFin) FROM keuangan)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeFin = rs.getInt(1);
                return KodeFin;
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
    public int getLastKodeFin(int KodeOutlet,String NoAkun,Calendar Tanggal,int KodePenyimpanan){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT KodeFin FROM keuangan WHERE KodeFin=(SELECT MAX (KodeFin) FROM keuangan WHERE KodeOutlet="+KodeOutlet+" NoAkun='"+NoAkun+"' "
                + "AND Tanggal='"+Tgl+"' AND KodePenyimpanan="+KodePenyimpanan+")";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeFin = rs.getInt(1);
                return KodeFin;
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
    public void setTanggal(Calendar Tanggal){
        this.Tanggal = Tanggal;
    }
    public Calendar getTanggal(){
        return Tanggal;
    }
    public Calendar getTanggal(int KodeFin){
        sql = "SELECT Tanggal FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Tanggal = Calendar.getInstance();
                Tanggal.setTime(rs.getDate(1));
                return Tanggal;
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
    public void setNoAkun(String NoAkun){
        this.NoAkun = NoAkun;
    }
    public String getNoAkun(){
        return NoAkun;
    }
    public String getNoAkun(int KodeFin){
        sql = "SELECT NoAkun FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NoAkun = rs.getString(1);
                return NoAkun;
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
    public void UpdateNoAkun(int KodeFin,String NoAkun) throws SQLException{
        sql = "UPDATE keuangan SET NoAkun='"+NoAkun+"' WHERE KodeFin="+KodeFin;
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
    public void setKodePenyimpanan(int KodePenyimpanan){
        this.KodePenyimpanan = KodePenyimpanan;
    }
    public int getKodePenyimpanan(){
        return KodePenyimpanan;
    }
    public int getKodeJenis(int KodeFin){
        sql = "SELECT KodePenyimpanan FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodePenyimpanan = rs.getInt(1);
                return KodePenyimpanan;
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
    public void UpdateKodePenyimpanan(int KodeFin,int KodePenyimpanan) throws SQLException{
        sql = "UPDATE keuangan SET KodePenyimpanan="+KodePenyimpanan+" WHERE KodeFin="+KodeFin;
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
    public void setDebet(Double Debet){
        this.Debet = Debet;
    }
    public Double getDebet(){
        return Debet;
    }
    public Double getDebet(int KodeFin){
        sql = "SELECT Debet FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Debet = rs.getDouble(1);
                return Debet;
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
    public void UpdateDebet(int KodeFin,Double Debet) throws SQLException{
        sql = "UPDATE keuangan SET Debet="+Debet+" WHERE KodeFin="+KodeFin;
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
    public void setKredit(Double Kredit){
        this.Kredit = Kredit;
    }
    public Double getKredit(){
        return Kredit;
    }
    public Double getKredit(int KodeFin){
        sql = "SELECT Kredit FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kredit = rs.getDouble(1);
                return Kredit;
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
    public void UpdateKredit(int KodeFin,Double Kredit) throws SQLException{
        sql = "UPDATE keuangan SET Kredit="+Kredit+" WHERE KodeFin="+KodeFin;
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
    public void getKeuangan(JTable tblKeuangan){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,String NoAkun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND MONTH(Tanggal)="+Bulan+" AND "
                + "YEAR(Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,String NoAkun,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.NoAkun='"+NoAkun+"' AND "
                + "k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,String NoAkun,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.NoAkun='"+NoAkun+"' AND k.Tanggal "
                + "BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan(JTable tblKeuangan,String NoAkun,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,j.NamaJenis,k.Debet,k.Kredit FROM keuangan k INNER JOIN "
                + "outlet o INNER JOIN akun a INNER JOIN jenispembayaran j ON (k.KodeOutlet=o.KodeOutlet AND a.NoAkun=k.NoAkun "
                + "AND j.KodeJenis=k.KodeJenis) WHERE (1=1) AND k.NoAkun='"+NoAkun+"' AND MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,String NoAkun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,String NoAkun,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.NoAkun='"+NoAkun+"' AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,String NoAkun,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.NoAkun='"+NoAkun+"' AND k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan1(JTable tblKeuangan,int KodeOutlet,String NoAkun,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND l.KodeOutlet="+KodeOutlet+" AND "
                + "k.NoAkun='"+NoAkun+"' AND MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,String NoAkun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" "
                + "AND NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" "
                + "AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" AND "
                + "k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" AND "
                + "MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,String NoAkun,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" AND "
                + "k.NoAkun='"+NoAkun+"' AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,String NoAkun,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" "
                + "AND k.NoAkun='"+NoAkun+"' AND k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan2(JTable tblKeuangan,int KodePenyimpanan,String NoAkun,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodePenyimpanan="+KodePenyimpanan+" "
                + "AND k.NoAkun='"+NoAkun+"' AND MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "l.KodePenyimpanan="+KodePenyimpanan;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND MONTH(k.Tanggal)="+Bulan+" YEAR(k.Tanggal)="+Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,String NoAkun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND k.NoAkun='"+NoAkun+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,String NoAkun,Calendar Tanggal){
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND k.NoAkun='"+NoAkun+"' AND k.Tanggal='"+Tgl+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,String NoAkun,Calendar TglAwal,Calendar TglAkhir){
        java.sql.Date TglAwl = new java.sql.Date(TglAwal.getTimeInMillis());
        java.sql.Date TglAkhr = new java.sql.Date(TglAkhir.getTimeInMillis());
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND k.Tanggal BETWEEN '"+TglAwl+"' AND '"+TglAkhr+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void getKeuangan3(JTable tblKeuangan,int KodeOutlet,int KodePenyimpanan,String NoAkun,int Bulan,int Tahun){
        sql = "SELECT o.NamaOutlet,DATE_FORMAT(k.Tanggal,'%d-%m-%Y'),k.NoAkun,a.NamaAkun,p.NamaPenyimpanan,k.Debet,k.Kredit "
                + "FROM keuangan k INNER JOIN outlet o INNER JOIN akun a INNER JOIN penyimpanan p ON (k.KodeOutlet=o.KodeOutlet AND "
                + "a.NoAkun=k.NoAkun AND p.KodePenyimpanan=k.KodePenyimpanan) WHERE (1=1) AND k.KodeOutlet="+KodeOutlet+" AND "
                + "k.KodePenyimpanan="+KodePenyimpanan+" AND k.NoAkun='"+NoAkun+"' AND MONTH(k.Tanggal)="+Bulan+" AND YEAR(k.Tanggal)="
                + Tahun;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblKeuangan.setModel(new DefaultTableModel(){
                String ColName[] = {"Outlet","Tanggal","No Akun","Nama Akun","Penyimpanan","Debet","Kredit","Saldo"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,Double.class,Double.class,Double.class};
                
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
                    return 8;
                }
            });
            
            Object rowdata[] = new Object[8];
            Double Saldo = 0.00,Debet,Kredit;
            DefaultTableModel dtm = (DefaultTableModel)tblKeuangan.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1); //Outlet
                rowdata[1] = rs.getString(2); //Tanggal
                rowdata[2] = rs.getString(3); //NoAkun
                rowdata[3] = rs.getString(4); //NamaAkun
                rowdata[4] = rs.getString(5); //Penyimpanan
                Debet = rs.getDouble(6);
                rowdata[5] = Debet; //Debet
                Kredit = rs.getDouble(7);
                rowdata[6] = Kredit; //Kredit
                
                Saldo += Debet;
                Saldo -= Kredit;
                
                rowdata[7] = Saldo;
                
                dtm.addRow(rowdata);
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
    public void Simpan(int KodeOutlet,Calendar Tanggal,String NoAkun,int KodePenyimpanan,Double Debet,Double Kredit) throws SQLException{
        java.sql.Date Tgl = new java.sql.Date(Tanggal.getTimeInMillis());
        sql = "INSERT INTO keuangan (KodeOutlet,Tanggal,NoAkun,KodePenyimpanan,Debet,Kredit) VALUES ("+KodeOutlet+".'"+Tgl+"','"+NoAkun+"',"
                +KodePenyimpanan+","+Debet+","+Kredit+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeFin = rs.getInt(1);
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
        sql = "INSERT INTO keuangan (KodeOutlet,Tanggal,NoAkun,KodePenyimpanan,Debet,Kredit) VALUES (?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            PS.setInt(1, KodeOutlet);
            PS.setDate(2, new java.sql.Date(Tanggal.getTimeInMillis()));
            PS.setString(3, NoAkun);
            PS.setInt(4, KodePenyimpanan);
            PS.setDouble(5, Debet);
            PS.setDouble(6, Kredit);
            
            int n = PS.executeUpdate();
            rs = PS.getGeneratedKeys();
            rs.next();
            KodeFin = rs.getInt(1);
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
        sql = "SELECT KodeOutlet,Tanggal,NoAkun,KodePenyimpanan,Debet,Kredit FROM keuangan WHERE KodeFin="+KodeFin;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            KodeOutlet = rs.getInt(1);
            Tanggal = Calendar.getInstance();
            Tanggal.setTime(rs.getDate(2));
            NoAkun = rs.getString(3);
            KodePenyimpanan = rs.getInt(4);
            Debet = rs.getDouble(5);
            Kredit = rs.getDouble(6);
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
        sql = "DELETE FROM keuangan";
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
    public void Hapus(int KodeFin) throws SQLException{
        sql = "DELETE FROM keuangan WHERE KodeFin="+KodeFin;
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
