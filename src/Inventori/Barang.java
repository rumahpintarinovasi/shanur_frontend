/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import Util.*;
/**
 *
 * @author Yestin
 */
public class Barang {
    
    private String Barcode;
    private String NamaItem;
    private int JenisItem;
    private int KodeKategori;
    private int KodeMerek;
    
    public void setBarcode(String Barcode){
        this.Barcode = Barcode;
    }
    public String getBarcode(){
        return Barcode;
    }
    public String getBarcode(String KodeBarcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT Barcode FROM barang WHERE Barcode='"+KodeBarcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Barcode = rs.getString(1);
                return Barcode;
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
    public void UpdateBarcode(String KodeBarcode,String Barcode) throws SQLException{
        Statement stmt = null;
        String sql = "UPDATE barang SET Barcode='"+Barcode+"' WHERE Barcode='"+KodeBarcode+"'";
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
    public void setNamaItem(String NamaItem){
        this.NamaItem = NamaItem;
    }
    public String getNamaItem(){
        return NamaItem;
    }
    public String getNamaItem(String Barcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT NamaItem FROM barang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaItem = rs.getString(1);
                return NamaItem;
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
    public void UpdateNamaItem(String Barcode,String NamaItem) throws SQLException{
        Statement stmt = null;
        String sql = "UPDATE barang SET NamaItem='"+NamaItem+"' WHERE Barcode='"+Barcode+"'";
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
    public void setJenisItem(int JenisItem){
        this.JenisItem = JenisItem;
    }
    public int getJenisItem(){
        return JenisItem;
    }
    public int getJenisItem(String Barcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT JenisItem FROM barang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisItem = rs.getInt(1);
                return JenisItem;
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
    public void UpdateJenisItem(String Barcode,int JenisItem) throws SQLException{
        Statement stmt = null;
        String sql = "UPDATE barang SET JenisItem="+JenisItem+" WHERE Barcode='"+Barcode+"'";
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
    public void setKodeKategori(int KodeKategori){
        this.KodeKategori = KodeKategori;
    }
    public int getKodeKategori(){
        return KodeKategori;
    }
    public int getKodeKategori(String Barcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT KodeKategori FROM barang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeKategori = rs.getInt(1);
                return KodeKategori;
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
    public void UpdateKodeKategori(String Barcode,int KodeKategori) throws SQLException{
        Statement stmt = null;
        String sql = "UPDATE barang SET KodeKategori="+KodeKategori+" WHERE Barcode='"+Barcode+"'";
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
    public void setKodeMerek(int KodeMerek){
        this.KodeMerek = KodeMerek;
    }
    public int getKodeMerek(){
        return KodeMerek;
    }
    public int getKodeMerek(String Barcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT KodeMerek FROM barang WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeMerek = rs.getInt(1);
                return KodeMerek;
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
    public void UpdateKodeMerek(String Barcode,int KodeMerek) throws SQLException{
        Statement stmt = null;
        String sql = "UPDATE barang SET KodeMerek="+KodeMerek+" WHERE Barcode='"+Barcode+"'";
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
    public void getBarang(JTable tblBarang){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getBarang1(JTable tblBarang,String NamaItem){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1) AND b.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getBarang2(JTable tblBarang,int JenisItem){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1) AND b.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getBarang3(JTable tblBarang,int KodeKategori){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1) AND b.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getBarang4(JTable tblBarang,int KodeMerek){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1) AND b.KodeMerek="+KodeMerek;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getBarang5(JTable tblBarang,String Barcode){
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT b.Barcode,b.NamaItem,CASE WEHN (JenisItem=1) THEN 'Barang' WHEN (JenisItem=2) THEN 'Jasa' END,"
                + "k.NamaKategori,m.NamaMerek FROM barang b INNER JOIN kategori k INNER JOIN merek m ON (b.KodeKategori=k.KodeKategori "
                + "AND b.KodeMerek=m.KodeMerek) WHERE (1=1) AND b.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblBarang.setModel(new DefaultTableModel(){
                String ColName[] = {"Barcode","Nama Item","Jenis Item","Kategori","Merek"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblBarang.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(4);
                rowdata[3] = rs.getString(5);
                rowdata[4] = rs.getString(6);
                
                dtm.addRow(rowdata);
            }
            
            tblBarang.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblBarang.getColumnModel().getColumn(2).setPreferredWidth(80);
            tblBarang.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblBarang.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void Simpan(String Barcode,String NamaItem,int JenisItem,int KodeKategori,int KodeMerek) throws SQLException{
        PreparedStatement PS = null;
        String sql = "INSERT INTO barang (Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek) VALUES ('"+Barcode+"','"+NamaItem+"',"
                + JenisItem+","+KodeKategori+","+KodeMerek+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            
            int n = PS.executeUpdate();
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
        PreparedStatement PS = null;
        String sql = "INSERT INTO barang (Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek) VALUES (?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            PS.setString(1, Barcode);
            PS.setString(2, NamaItem);
            PS.setInt(3, JenisItem);
            PS.setInt(4, KodeKategori);
            PS.setInt(5, KodeMerek);
            
            int n = PS.executeUpdate();
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
        Statement stmt = null;
        ResultSet rs;
        String sql = "SELECT Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek FROM barang";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            Barcode = rs.getString(1);
            NamaItem = rs.getString(2);
            JenisItem = rs.getInt(3);
            KodeKategori = rs.getInt(4);
            KodeMerek = rs.getInt(5);
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
        Statement stmt = null;
        String sql = "DELETE FROM barang";
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
    public void Hapus(String Barcode) throws SQLException{
        Statement stmt = null;
        String sql = "DELETE FROM barang WHERE Barcode='"+Barcode+"'";
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
