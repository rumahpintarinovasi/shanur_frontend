/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HumanResource;

import java.sql.*;
import java.util.*;
import Util.*;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Yestin
 */
public class Identitas {
    
    private String NoIdentitas;
    private int KodeJenis;
    private String NamaLengkap;
    private int JenisKelamin;
    private String TempatLahir;
    private Calendar TglLahir;
    private String Alamat;
    private String RT;
    private String RW;
    private String Kelurahan;
    private String Kecamatan;
    private String Kabupaten;
    private String Agama;
    private String StatusPernikahan;
    private String Pekerjaan;
    private String Kewarganegaraan;
    
    PreparedStatement PS = null;
    Statement stmt = null;
    ResultSet rs;
    String sql;
    
    
    public void setNoIdentitas(String NoIdentitas){
        this.NoIdentitas = NoIdentitas;
    }
    public String getNoIdentitas(){
        return NoIdentitas;
    }
    public String getNoIdentitas(String NoId){
        sql = "SELECT NoIdentitas FROM identitas WHERE NoId='"+NoId+"'";
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
    public void UpdateNoIdentitas(String NoId,String NoIdentitas) throws SQLException{
        sql = "UPDATE identittas SET NoIdentitas='"+NoIdentitas+"' WHERE NoIdentitas='"+NoId+"'";
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
    public void setKodeJenis(int KodeJenis){
        this.KodeJenis = KodeJenis;
    }
    public int getKodeJenis(){
        return KodeJenis;
    }
    public int getKodeJenis(String NoIdentitas){
        sql = "SELECT KodeJenis FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                KodeJenis = rs.getInt(1);
                return KodeJenis;
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
    public void UpdateKodeJenis(String NoIdentitas,int KodeJenis) throws SQLException{
        sql = "UPDATE identitas SET KodeJenis="+KodeJenis+" WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setNamaLengkap(String NamaLengkap){
        this.NamaLengkap = NamaLengkap;
    }
    public String getNamaLengkap(){
        return NamaLengkap;
    }
    public String getNamaLengkap(String NoIdentitas){
        sql = "SELECT NamaLengkap FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                NamaLengkap = rs.getString(1);
                return NamaLengkap;
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
    public void UpdateNamaLengkap(String NoIdentitas,String NamaLengkap) throws SQLException{
        sql = "UPDATE identitas SET NamaLengkap='"+NamaLengkap+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setJenisKelamin(int JenisKelamin){
        this.JenisKelamin = JenisKelamin;
    }
    public int getJenisKelamin(){
        return JenisKelamin;
    }
    public int getJenisKelamin(String NoIdentitas){
        sql = "SELECT JenisKelamin FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                JenisKelamin = rs.getInt(1);
                return JenisKelamin;
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
    public void UpdateJenisKelamin(String NoIdentitas,int JenisKelamin) throws SQLException{
        sql = "UPDATE identitas SET JenisKelamin="+JenisKelamin+" WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setTempatLahir(String TempatLahir){
        this.TempatLahir = TempatLahir;
    }
    public String getTempatLahir(){
        return TempatLahir;
    }
    public String getTempatLahir(String NoIdentitas){
        sql = "SELECT TempatLahir FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TempatLahir = rs.getString(1);
                return TempatLahir;
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
    public void UpdateTempatLahir(String NoIdentitas,String TempatLahir) throws SQLException{
        sql ="UPDATE identitas SET TempatLahir='"+TempatLahir+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setTglLahir(Calendar TglLahir){
        this.TglLahir = TglLahir;
    }
    public Calendar getTglLahir(){
        return TglLahir;
    }
    public Calendar getTglLahir(String NoIdentitas){
        sql = "SELECT TglLahir FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                TglLahir = Calendar.getInstance();
                TglLahir.setTime(rs.getDate(1));
                return TglLahir;
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
    public void UpdateTglLahir(String NoIdentitas,Calendar TglLahir) throws SQLException{
        java.sql.Date TanggalLahir = new java.sql.Date(TglLahir.getTimeInMillis());
        sql = "UPDATE identitas SET TglLahir='"+TanggalLahir+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public String getAlamat(String NoIdentitas){
        sql = "SELECT Alamat FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdateAlamat(String NoIdentitas,String Alamat) throws SQLException{
        sql = "UPDATE identitas SET Alamat='"+Alamat+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setRT(String RT){
        this.RT = RT;
    }
    public String getRT(){
        return RT;
    }
    public String getRT(String NoIdentitas){
        sql = "SELECT RT FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                RT = rs.getString(1);
                return RT;
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
    public void UpdateRT(String NoIdentitas,String RT) throws SQLException{
        sql = "UPDATE identitas SET RT='"+RT+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setRW(String RW){
        this.RW = RW;
    }
    public String getRW(){
        return RW;
    }
    public String getRW(String NoIdentitas){
        sql = "SELECT RW FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                RW = rs.getString(1);
                return RW;
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
    public void UpdateRW(String NoIdentitas,String RW) throws SQLException{
        sql = "UPDATE identitas SET RW='"+RW+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public String getKelurahan(String NoIdentitas){
        sql = "SELECT Kelurahan FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdateKelurahan(String NoIdentitas,String Kelurahan) throws SQLException{
        sql = "UPDATE identitas SET Kelurahan='"+Kelurahan+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public String getKecamatan(String NoIdentitas){
        sql = "SELECT Kecamatan FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void UpdateKecamatan(String NoIdentitas,String Kecamatan) throws SQLException{
        sql = "UPDATE identitas SET Kecamatan='"+Kecamatan+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setKabupaten(String Kabupaten){
        this.Kabupaten = Kabupaten;
    }
    public String getKabupaten(){
        return Kabupaten;
    }
    public String getKabupaten(String NoIdentitas){
        sql = "SELECT Kabupaten FROM identitas SET NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kabupaten = rs.getString(1);
                return Kabupaten;
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
    public void UpdateKabupaten(String NoIdentitas,String Kabupaten) throws SQLException{
        sql = "UPDATE identitas SET Kabupaten='"+Kabupaten+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setAgama(String Agama){
        this.Agama = Agama;
    }
    public String getAgama(){
        return Agama;
    }
    public String getAgama(String NoIdentitas){
        sql = "SELECT Agama FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Agama = rs.getString(1);
                return Agama;
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
    public void UpdateAgama(String NoIdentitas,String Agama) throws SQLException{
        sql = "UPDATE identitas SET Agama='"+Agama+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setStatusPernikahan(String StatusPernikahan){
        this.StatusPernikahan = StatusPernikahan;
    }
    public String getStatusPernikahan(){
        return StatusPernikahan;
    }
    public String getStatusPernikahan(String NoIdentitas){
        sql = "SELECT StatusPernikahan FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                StatusPernikahan = rs.getString(1);
                return StatusPernikahan;
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
    public void UpdateStatusPernikahan(String NoIdentitas,String StatusPernikahan) throws SQLException{
        sql = "UPDATE identitas SET StatusPernikahan='"+StatusPernikahan+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void setPekerjaan(String Pekerjaan){
        this.Pekerjaan = Pekerjaan;
    }
    public String getPekerjaan(){
        return Pekerjaan;
    }
    public String getPekerjaan(String NoIdentitas){
        sql = "SELECT Pekerjaan FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Pekerjaan = rs.getString(1);
                return Pekerjaan;
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
    public void UpdatePekerjaan(String NoIdenitas,String Pekerjaan) throws SQLException{
        sql = "UPDATE identitas SET Pekerjaan='"+Pekerjaan+"' WHERE NoIdentitas='"+NoIdenitas+"'";
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
    public void setKewarganegaraan(String Kewarganegaraan){
        this.Kewarganegaraan = Kewarganegaraan;
    }
    public String getKewarganegaraan(){
        return Kewarganegaraan;
    }
    public String getKewarganegaraan(String NoIdentitas){
        sql = "SELECT Kewarganegeraan FROM identitas WHERE NoIdenititas='"+NoIdentitas+"'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()){
                Kewarganegaraan = rs.getString(1);
                return Kewarganegaraan;
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
    public void UpdateKewarganegaraan(String NoIdentitas,String Kewarganegaraan) throws SQLException{
        sql = "UPDATE identitas SET Kewarganegeraan='"+Kewarganegaraan+"' WHERE NoIdentitas='"+NoIdentitas+"'";
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
    public void getIdentitas(JTable tblIdentitas){
        sql = "SELECT i.NoIdentitas,j.NamaJenis,i.NamaLengkap,CASE WHEN (i.JenisKelamin=1) THEN 'Laki-Laki' WHEN (i.JenisKelamin=2) THEN 'Perempuan' "
                + "END,i.TempatLahir,DATE_FORMAT(i.TglLahir,'%d-%m-%Y'),i.Agama,i.StatusPernikahan,i.Pekerjaan,"
                + "i.Kewarganegaraan FROM identitas i INNER JOIN jenisidentitas j ON (i.KodeJenis=j.KodeJenis) WHERE (1=1) ";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblIdentitas.setModel(new DefaultTableModel(){
                String ColName[] = {"No Identitas","Jenis Identitas","Nama Lengkap","Jenis Kelamin","Tempat Lahir","Tgl Lahir",
                                        "Agama","Status Pernikahan","Pekerjaan","Kewarganegaraan"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblIdentitas.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getString(1);
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
            
            tblIdentitas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblIdentitas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblIdentitas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblIdentitas.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getIdentitas(JTable tblIdentitas,String NamaLengkap){
        sql = "SELECT i.NoIdentitas,j.NamaJenis,i.NamaLengkap,CASE WHEN (i.JenisKelamin=1) THEN 'Laki-Laki' WHEN (i.JenisKelamin=2) THEN 'Perempuan' "
                + "END,i.TempatLahir,DATE_FORMAT(i.TglLahir,'%d-%m-%Y'),i.Agama,i.StatusPernikahan,i.Pekerjaan,"
                + "i.Kewarganegaraan FROM identitas i INNER JOIN jenisidentitas j ON (i.KodeJenis=j.KodeJenis) WHERE (1=1) AND "
                + "i.NamaLengkap LIKE '%"+NamaLengkap+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblIdentitas.setModel(new DefaultTableModel(){
                String ColName[] = {"No Identitas","Jenis Identitas","Nama Lengkap","Jenis Kelamin","Tempat Lahir","Tgl Lahir",
                                        "Agama","Status Pernikahan","Pekerjaan","Kewarganegaraan"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,
                                    String.class,String.class};
                
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
            DefaultTableModel dtm = (DefaultTableModel)tblIdentitas.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getString(1);
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
            
            tblIdentitas.getColumnModel().getColumn(0).setPreferredWidth(80);
            tblIdentitas.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblIdentitas.getColumnModel().getColumn(3).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(4).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(5).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(6).setPreferredWidth(80);
            tblIdentitas.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(8).setPreferredWidth(100);
            tblIdentitas.getColumnModel().getColumn(8).setPreferredWidth(100);
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
    public void getDomisili(JTable tblDomisili){
        sql = "SELECT i.NoIdentitas,j.NamaJenis,i.NamaLengkap,i.Alamat,i.RT,i.RW,i.Kelurahan,i.Kecamatan,i.Kabupaten FROM identitas i "
                + "INNER JOIN jenisidentitas j ON (j.KodeJenis=i.KodeJenis) WHERE (1=1)";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblDomisili.setModel(new DefaultTableModel(){
                String ColName[] = {"No Identitas","Jenis Identitas","Nama Lengkap","Alamat","RT","RW","Kelurahan/Desa","Kecamatan","Kabupaten/Kota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                public int getColumnCount(){
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblDomisili.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                
                dtm.addRow(rowdata);
            }
            
            tblDomisili.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblDomisili.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblDomisili.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblDomisili.getColumnModel().getColumn(5).setPreferredWidth(40);
            tblDomisili.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblDomisili.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(8).setPreferredWidth(150);
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
    public void getDomisili(JTable tblDomisili,String NamaLengkap){
        sql = "SELECT i.NoIdentitas,j.NamaJenis,i.NamaLengkap,i.Alamat,i.RT,i.RW,i.Kelurahan,i.Kecamatan,i.Kabupaten FROM identitas i "
                + "INNER JOIN jenisidentitas j ON (j.KodeJenis=i.KodeJenis) WHERE (1=1) AND i.NamaLengkap LIKE '%"+NamaLengkap+"%'";
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            
            tblDomisili.setModel(new DefaultTableModel(){
                String ColName[] = {"No Identitas","Jenis Identitas","Nama Lengkap","Alamat","RT","RW","Kelurahan/Desa","Kecamatan","Kabupaten/Kota"};
                Class ColType[] = {String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class,String.class};
                
                @Override
                public Class<?> getColumnClass(int ColIndex){
                    return ColType[ColIndex];
                }
                @Override
                public String getColumnName(int ColIndex){
                    return ColName[ColIndex];
                }
                public int getColumnCount(){
                    return 9;
                }
            });
            
            Object rowdata[] = new Object[9];
            DefaultTableModel dtm = (DefaultTableModel)tblDomisili.getModel();
            while(rs.next()){
                
                rowdata[0] = rs.getString(1);
                rowdata[1] = rs.getString(2);
                rowdata[2] = rs.getString(3);
                rowdata[3] = rs.getString(4);
                rowdata[4] = rs.getString(5);
                rowdata[5] = rs.getString(6);
                rowdata[6] = rs.getString(7);
                rowdata[7] = rs.getString(8);
                rowdata[8] = rs.getString(9);
                
                dtm.addRow(rowdata);
            }
            
            tblDomisili.getColumnModel().getColumn(0).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(1).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(2).setPreferredWidth(150);
            tblDomisili.getColumnModel().getColumn(3).setPreferredWidth(250);
            tblDomisili.getColumnModel().getColumn(4).setPreferredWidth(40);
            tblDomisili.getColumnModel().getColumn(5).setPreferredWidth(40);
            tblDomisili.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblDomisili.getColumnModel().getColumn(7).setPreferredWidth(100);
            tblDomisili.getColumnModel().getColumn(8).setPreferredWidth(150);
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
    public void Simpan(String NoIdentitas,int KodeJenis,String NamaLengkap,int JenisKelamin,String TempatLahir,Calendar TglLahir,String Alamat,
            String RT,String RW,String Kelurahan,String Kecamatan,String Kabupaten,String Agama,String StatusPernikahan,String Pekerjaan,
            String Kewarganegaraan) throws SQLException{
        java.sql.Date Tanggal = new java.sql.Date(TglLahir.getTimeInMillis());
        sql = "INSERT INTO identitas (NoIdentitas,KodeJenis,NamaLengkap,JenisKelamin,TempatLahir,TglLahir,Alamat,RT,RW,Kelurahan,Kecamatan,"
                + "Kabupaten,Agama,StatusPernikahan,Pekerjaan,Kewarganegaraan) VALUES ('"+NoIdentitas+"',"+KodeJenis+",'"+NamaLengkap+"',"
                +JenisKelamin+",'"+TempatLahir+"','"+Tanggal+"','"+Alamat+"','"+RT+"','"+RW+"','"+RW+"','"+Kelurahan+"','"+Kecamatan+"',"
                + "'"+Kabupaten+"','"+Agama+"','"+StatusPernikahan+"','"+Pekerjaan+"','"+Kewarganegaraan+"')";
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
        sql = "INSERT INTO identitas(NoIdentitas,KodeJenis,NamaLengkap,JenisKelamin,TempatLahir,TglLahir,Alamat,RT,RW,Kelurahan,Kecamatan,"
                + "Kabupaten,Agama,StatusPernikahan,Pekerjaan,Kewarganegaraan) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PS = DBConnector.getConnection().prepareStatement(sql);
            PS.setString(1, NoIdentitas);
            PS.setInt(2, KodeJenis);
            PS.setString(3, NamaLengkap);
            PS.setInt(4, JenisKelamin);
            PS.setString(5, TempatLahir);
            PS.setDate(6, new java.sql.Date(TglLahir.getTimeInMillis()));
            PS.setString(7, Alamat);
            PS.setString(8, RT);
            PS.setString(9, RW);
            PS.setString(10, Kelurahan);
            PS.setString(11, Kecamatan);
            PS.setString(12, Kabupaten);
            PS.setString(13, Agama);
            PS.setString(14, StatusPernikahan);
            PS.setString(15, Pekerjaan);
            PS.setString(16, Kewarganegaraan);
            
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
    public void Query() throws SQLException{
        sql = "SELECT NoIdentitas,KodeJenis,NamaLengkap,JenisKelamin,TempatLahir,TglLahir,Alamat,RT,RW,Kelurahan,Kecamatan,Kabupaten,Agama,"
                + "StatusPerniakahan,Pekerjaan,Kewarganegaraan FROM identitas WHERE NoIdentitas="+NoIdentitas;
        try {
            stmt = DBConnector.getConnection().createStatement(ResultSet.TYPE_FORWARD_ONLY,
                    ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sql);
            if(rs.next()==false){
                return;
            }
            NoIdentitas = rs.getString(1);
            KodeJenis = rs.getInt(2);
            NamaLengkap = rs.getString(3);
            JenisKelamin = rs.getInt(4);
            TempatLahir = rs.getString(5);
            TglLahir = Calendar.getInstance();
            TglLahir.setTime(rs.getDate(6));
            Alamat = rs.getString(7);
            RT = rs.getString(8);
            RW = rs.getString(9);
            Kelurahan = rs.getString(10);
            Kecamatan = rs.getString(11);
            Kabupaten = rs.getString(12);
            Agama = rs.getString(13);
            StatusPernikahan = rs.getString(14);
            Pekerjaan = rs.getString(15);
            Kewarganegaraan = rs.getString(16);
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
        sql = "DELETE FROM identitas";
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
        sql = "DELETE FROM identitas WHERE NoIdentitas='"+NoIdentitas+"'";
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
