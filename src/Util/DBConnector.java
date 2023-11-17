/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Util;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

 /*
 * @author Yestin
 */
public class DBConnector
{
    private static java.sql.Connection dbconn;
    private static java.sql.Connection dbconnVPS;
    private static java.sql.Connection dbconnLocal;
 
    public static void Inisialisasi (){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            dbconnVPS = DriverManager.getConnection("jdbc:mysql://178.16.138.233:3306/delicakes?" +
                                                 "user=delicakes&password=2s0XbMid6yq0zhQxx9C9");
            
//            dbconnLocal = DriverManager.getConnection("jdbc:mysql://localhost:3307/epos?" +
//                                                 "user=vestrylprogramming&password=V6s4Ty9S0t");
            
            dbconnVPS.setAutoCommit(false);
//            dbconnLocal.setAutoCommit(false);
//            dbconnVPS.setReadOnly(false);
            Statement stmtVPS = dbconnVPS.createStatement();
//            Statement stmtLocal = dbconnLocal.createStatement();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new  SimpleDateFormat ("dd-MMM-yyyy HH:mm:ss z");

            System.out.println("Terkoneksi ke Database VPS pada " + sdf.format(cal.getTime()));
            
        }
        catch (Exception e) {
            System.out.println("Koneksi ke DB error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static java.sql.Connection getConnection()
    {
        return dbconnVPS;
    }
    public static java.sql.Connection getConnectionLocal(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            dbconnLocal = DriverManager.getConnection("jdbc:mysql://localhost:3307/epos?" +
                                                 "user=vestrylprogramming&password=V6s4Ty9S0t"); //LocalDB
            dbconnLocal.setAutoCommit(false);
            //dbconn.setReadOnly(false); 

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new  SimpleDateFormat ("dd-MMM-yyyy HH:mm:ss z");

            System.out.println("Terkoneksi ke Database Local pada " + sdf.format(cal.getTime()));
            
            return dbconnLocal;
        }
        catch (Exception e) {
            System.out.println("Koneksi ke DB error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static java.sql.Connection ConnectionDelicake(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            dbconn = DriverManager.getConnection("jdbc:mysql://89.116.236.148:3306/delicake?" +
                                                 "user=delicake&password=V6s4Ty9S0t"); //VPS
            dbconn.setAutoCommit(false);
            //dbconn.setReadOnly(false); 

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new  SimpleDateFormat ("dd-MMM-yyyy HH:mm:ss z");

//            System.out.println("Terkoneksi ke Database pada " + sdf.format(cal.getTime()));
            
            return dbconn;
        }
        catch (Exception e) {
            System.out.println("Koneksi ke DB error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static java.sql.Connection getConnection2(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            dbconn = DriverManager.getConnection("jdbc:mysql://83.136.216.72:3306/u1567541_shanur?" +
                                                 "user=u1567541_agus&password=V6s4Ty9S0t");
            dbconn.setAutoCommit(false);
            //dbconn.setReadOnly(false); 

            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new  SimpleDateFormat ("dd-MMM-yyyy HH:mm:ss z");

//            System.out.println("Terkoneksi ke Database pada " + sdf.format(cal.getTime()));
            
            return dbconn;
        }
        catch (Exception e) {
            System.out.println("Koneksi ke DB error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    public static java.sql.Connection getConnection3(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            
            dbconn = DriverManager.getConnection("jdbc:mysql://89.116.236.148:3306/delicake?" +
                                                 "user=delicake&password=V6s4Ty9S0t");
            dbconn.setAutoCommit(false);
            //dbconn.setReadOnly(false);
            Statement stmt = dbconn.createStatement();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new  SimpleDateFormat ("dd-MMM-yyyy HH:mm:ss z");

            System.out.println("Terkoneksi ke Database pada " + sdf.format(cal.getTime()));
            
            return dbconn;
            
        }
        catch (Exception e) {
            System.out.println("Koneksi ke DB error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}