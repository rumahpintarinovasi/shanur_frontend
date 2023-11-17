/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author Vestryl
 */
public class TimeDifference {
    
    public static String SelisihTanggalWaktu(Date WaktuAwal,Date WaktuAkhir){
        
        long SelisihMS = Math.abs(WaktuAwal.getTime() - WaktuAkhir.getTime());
        long SelisihDetik = SelisihMS / 1000%60;
        long SelisihMenit = SelisihMS /(60*1000)%60;
        long SelisihJam = SelisihMS / (60*60*1000)%24;
        long SelisihHari = SelisihMS / (24*60*60*1000);
        
        
        
        String Selisih = new String();
        try {
            if(SelisihHari>0&&SelisihJam==0&&SelisihMenit==0&&SelisihDetik==0){
                Selisih = SelisihHari+" Hari";
                return Selisih;
            }
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit==0&&SelisihDetik==0){
                Selisih = SelisihJam+" Jam";
                return Selisih;
            }
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit>0&&SelisihDetik==0){
                Selisih = SelisihJam+":"+SelisihMenit;
                return Selisih;
            }
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit>0&&SelisihDetik>0){
                Selisih = SelisihJam+":"+SelisihMenit+":"+SelisihDetik;
                return Selisih;
            }
            else if(SelisihHari>0&&SelisihJam>0&&SelisihMenit>0&&SelisihDetik>0){
                Selisih = SelisihHari+" Hari "+SelisihJam+" Jam "+SelisihMenit+" Menit "+SelisihDetik+" Detik";
                return Selisih;
            }
            else{
                return null;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    
    }
    public static String DurasiTanggalWaktu(Date WaktuAwal,Date WaktuAkhir){
        
        long SelisihMS = Math.abs(WaktuAwal.getTime() - WaktuAkhir.getTime());
        long SelisihDetik = SelisihMS / 1000%60;
        long SelisihMenit = SelisihMS /(60*1000)%60;
        long SelisihJam = SelisihMS / (60*60*1000)%24;
        long SelisihHari = SelisihMS / (24*60*60*1000);
        
        Double DurasiMS = new Double(SelisihMS);
        Double DurasiDetik = new Double(SelisihDetik);
        Double DurasiMenit = new Double(SelisihMenit);
        Double DurasiJam = new Double(SelisihJam);
        Double DurasiHari = new Double(SelisihHari);
        
        Double SelisihWaktu;
        String Durasi = null;
        try {
            //Durasi Hari
            if(DurasiHari>0&&DurasiJam==0&&DurasiMenit==0&&DurasiDetik==0){
                SelisihWaktu = (24 * DurasiHari) + (DurasiJam + (DurasiMenit/60));
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi  Jam
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit==0&&SelisihDetik==0){
                SelisihWaktu = DurasiJam + (DurasiMenit/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Menit
            else if(SelisihHari==0&&SelisihJam==0&&SelisihMenit>0&&SelisihDetik==0){
                SelisihWaktu = DurasiMenit + (DurasiDetik/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Jam+Menit+Detik
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit>0&&SelisihDetik>=0){
                SelisihWaktu = DurasiJam + (DurasiMenit/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Hari+Jam+Menint+Detik
            else if(SelisihHari>0&&SelisihJam>0&&SelisihMenit>=0&&SelisihDetik>=0){
                SelisihWaktu = (24 * DurasiHari) + (DurasiJam + (DurasiMenit/60));
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
//            Selisih = SelisihHari+" Hari "+SelisihJam+" Jam "+SelisihMenit+" Menit "+SelisihDetik+" Detik";
            }
            else{
                return null;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
    }
    public static String DurasiWaktu(Timestamp WaktuAwal,Timestamp WaktuAkhir){
        
        long SelisihMS = Math.abs(WaktuAwal.getTime() - WaktuAkhir.getTime());
        long SelisihDetik = SelisihMS / 1000%60;
        long SelisihMenit = SelisihMS /(60*1000)%60;
        long SelisihJam = SelisihMS / (60*60*1000)%24;
        long SelisihHari = SelisihMS / (24*60*60*1000);
        
        Double DurasiMS = new Double(SelisihMS);
        Double DurasiDetik = new Double(SelisihDetik);
        Double DurasiMenit = new Double(SelisihMenit);
        Double DurasiJam = new Double(SelisihJam);
        Double DurasiHari = new Double(SelisihHari);
        
        Double SelisihWaktu;
        String Durasi = null;
        try {
            //Durasi Hari
            if(DurasiHari>0&&DurasiJam==0&&DurasiMenit==0&&DurasiDetik==0){
                SelisihWaktu = (24 * DurasiHari) + (DurasiJam + (DurasiMenit/60));
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi  Jam
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit==0&&SelisihDetik==0){
                SelisihWaktu = DurasiJam + (DurasiMenit/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Menit
            else if(SelisihHari==0&&SelisihJam==0&&SelisihMenit>0&&SelisihDetik==0){
                SelisihWaktu = DurasiMenit + (DurasiDetik/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Jam+Menit+Detik
            else if(SelisihHari==0&&SelisihJam>0&&SelisihMenit>0&&SelisihDetik>=0){
                SelisihWaktu = DurasiJam + (DurasiMenit/60);
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
            }
            //Durasi Hari+Jam+Menint+Detik
            else if(SelisihHari>0&&SelisihJam>0&&SelisihMenit>=0&&SelisihDetik>=0){
                SelisihWaktu = (24 * DurasiHari) + (DurasiJam + (DurasiMenit/60));
                String Selisih = String.valueOf(SelisihWaktu);
                return Selisih;
//            Selisih = SelisihHari+" Hari "+SelisihJam+" Jam "+SelisihMenit+" Menit "+SelisihDetik+" Detik";
            }
            else{
                return null;
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        
    }
    
    public static String SelisihWaktu(Date WaktuAwal,Date WaktuAkhir){
        
        long SelisihMS = Math.abs(WaktuAwal.getTime()-WaktuAkhir.getTime());
        
        long SelisihDetik = SelisihMS / 1000%60;
        long SelisihMenit = SelisihMS / (60*1000)%60;
        long SelisihJam = SelisihMS / (60*60*1000)%24;
        
        Double DurasiJam = new Double(SelisihJam);
        Double DurasiMenit = new Double(SelisihMenit);
        Double DurasiDetik = new Double(SelisihDetik);
        Double DurasiWaktu = DurasiJam + (DurasiMenit/60);
        String Selisih = String.valueOf(DurasiWaktu);
        return Selisih;
    }
    public static String SelisihWaktu2(java.sql.Time WaktuAwal, java.sql.Time WaktuAkhir){
        Long SelisihMS = Math.abs(WaktuAwal.getTime()-WaktuAkhir.getTime());
        
        Long SelisihDetik = SelisihMS / 1000%60;
        Long SelisihMenit = SelisihMS / (60*1000)%60;
        Long SelisihJam = SelisihMS / (60*60*1000)%24;
        
        Double DurasiDetik = new Double(SelisihDetik);
        Double DurasiMenit = new Double(SelisihMenit);
        Double DurasiJam = new Double(SelisihJam);
        Double DurasiWaktu = DurasiJam + (DurasiMenit/60);
        String Selisih = String.valueOf(DurasiWaktu);
        return Selisih;
    }
    public static Date KonversiStringKeDate(String TglDnWktu,String pola,Locale lokal){
        Date Tanggal = null;
        SimpleDateFormat sdf;
        if(lokal==null){
            sdf = new SimpleDateFormat(pola);
        }
        else{
            sdf = new SimpleDateFormat(pola, lokal);
        }
        try {
            Tanggal = sdf.parse(TglDnWktu);
        } 
        catch (ParseException e) {
            e.printStackTrace();
        }
        return Tanggal;
    }
    
    public static Timestamp KonversiStringKeTimeStamp(String Tgl,String Bln,String Thn,String Jam,String Mnt,String Dtk) throws ParseException{
        
        SimpleDateFormat sdf;
        String Waktu = Thn+"-"+Bln+"-"+Tgl+" "+Jam+":"+Mnt+":"+Dtk;
        
        sdf = new SimpleDateFormat(Waktu);
        Date TimeStamp = sdf.parse(Waktu);
        ((SimpleDateFormat)sdf).applyPattern(Waktu);
        Waktu = sdf.format(TimeStamp);
        
        java.sql.Timestamp ts = Timestamp.valueOf(Waktu);
        
        return ts;
    }
    public static Double KonversiStringTimeDouble(String Waktu){
        Time time;
        Double Wkt;
        time = new Time(Integer.valueOf(Waktu.split(":")[0]),Integer.valueOf(Waktu.split(":")[1]),0);
        Wkt = new Double(time.getHours()+Math.floor(time.getMinutes()*100/60)/100);
        return Wkt;
    }
}
