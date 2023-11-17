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
public class Items {
    
    private String Barcode;
    private String NamaItem;
    private int JenisItem;
    private int KodeKategori;
    private int KodeMerek;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    
    public void setBarcode(String Barcode){
        this.Barcode = Barcode;
    }
    public String getBarcode(){
        sql = "SELECT Barcode FROM items WHERE Barcode='"+Barcode+"'";
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
    public boolean getKodeBarcode(){
        sql = "SELECT Barcode FROM items";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Barcode = rs.getString(1);
                return true;
            }
            else{
                return false;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
            if(stmt!=null){
                try {
                    stmt.close();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public String getBarcode(String KodeBarcode){
        sql = "SELECT Barcode FROM items WHERE Barcode='"+KodeBarcode+"'";
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
    public boolean getKodeBarcode(String Barcode){
        sql = "SELECT Barcode FROM items WHERE Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Barcode = rs.getString(1);
                return true;
            }
            else{
                return false;
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        finally{
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
        sql = "UPDATE items SET Barcode='"+Barcode+"' WHERE Barcode='"+KodeBarcode+"'";
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
        sql = "SELECT NamaItem FROM items WHERE Barcode='"+Barcode+"'";
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
        sql = "UPDATE items SET NamaItem='"+NamaItem+"' WHERE Barcode='"+Barcode+"'";
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
        sql = "SELECT JenisItem FROM items WHERE Barcode='"+Barcode+"'";
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
                    stmt.clearBatch();
                } 
                catch (Exception e) {
                }
            }
        }
    }
    public void UpdateJenisItem(String Barcode,int JenisItem) throws SQLException{
        sql = "UPDATE items SET JenisItem="+JenisItem+" WHERE Barcode='"+Barcode+"'";
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
        sql = "SELECT KodeKategori FROM items WHERE Barcode='"+Barcode+"'";
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
        sql = "UPDATE items SET KodeKategori="+KodeKategori+" WHERE Barcode='"+Barcode+"'";
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
        sql = "SELECT KodeMerek FROM items WHERE Barcode='"+Barcode+"'";
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
        sql = "UPDATE items SET KodeMerek="+KodeMerek+" WHERE Barcode='"+Barcode+"'";
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
    
    public void getItems(JTable tblItems){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getItems1(JTable tblItems,String Barcode){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1) AND i.Barcode='"+Barcode+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getItems2(JTable tblItems,String NamaItem){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1) AND i.NamaItem LIKE '%"+NamaItem+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getItems3(JTable tblItems,int JenisItem){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1) AND i.JenisItem="+JenisItem;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getItems4(JTable tblItems,int KodeKategori){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1) AND i.KodeKategori="+KodeKategori;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
    public void getItems5(JTable tblItems,int KodeMerek){
        sql = "SELECT i.Barcode,i.NamaItem,CASE WHEN (i.JenisItem=1) THEN 'Barang' WHEN (i.JenisItem=2) THEN 'Jasa' END AS JenisItem,"
                + "k.NamaKategori AS Kategori,m.NamaMerek AS Merek FROM items i INNER JOIN kategori k INNER JOIN merek m "
                + "ON (i.KodeKategori=k.KodeKategori AND i.KodeMerek=m.KodeMerek) WHERE (1=1) AND i.KodeMerek="+KodeMerek;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblItems.setModel(new DefaultTableModel(){
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
            DefaultTableModel dtm = (DefaultTableModel)tblItems.getModel();
            while(rs.next()){
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                
                dtm.addRow(rowdata);
            }
            
            tblItems.getColumnModel().getColumn(0).setPreferredWidth(70);
            tblItems.getColumnModel().getColumn(1).setPreferredWidth(150);
            tblItems.getColumnModel().getColumn(2).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblItems.getColumnModel().getColumn(4).setPreferredWidth(100);
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
        sql = "INSERT INTO items (Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek) VALUES ('"+Barcode+"','"+NamaItem+"',"+JenisItem+","
                + ""+KodeKategori+","+KodeMerek+")";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            
            int n = PS.executeUpdate();
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
        sql = "INSERT INTO items (Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek) VALUES (?,?,?,?,?)";
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
        sql = "SELECT Barcode,NamaItem,JenisItem,KodeKategori,KodeMerek FROM items WHERE Barcode='"+Barcode+"'";
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
    public void Hapus(String Barcode) throws SQLException{
        sql = "DELETE FROM items WHERE Barcode='"+Barcode+"'";
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
        sql = "DELETE FROM items";
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
