/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Yestin
 */
public class DateTimeConverter {
    
    public static String ConvertToHour(String Time){
        String input = Time;
        
        SimpleDateFormat sdf = new SimpleDateFormat("hh");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("hh");
        java.util.Date Date = null;
        String Output = null;
        
        try {
            Date = sdf.parse(input);
            Output = OutputFormat.format(Date);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToMinute(String Time){
        String input = Time;
        
        SimpleDateFormat sdf = new SimpleDateFormat("mm");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("mm");
        java.util.Date Date = null;
        String Output = null;
        
        try {
            Date = sdf.parse(input);
            Output = OutputFormat.format(Date);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToSecond(String Time){
        String input = Time;
        
        SimpleDateFormat sdf = new SimpleDateFormat("ss");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("ss");
        java.util.Date Date = null;
        String Output = null;
        
        try {
            Date = sdf.parse(input);
            Output = OutputFormat.format(Date);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToTime(String Time){
        String input = Time;
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:MM:SS");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("HH:MM:SS");
        java.util.Date Date = null;
        String Output = null;
        
        try {
            Date = sdf.parse(input);
            Output = OutputFormat.format(Date);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToDays(String Date){
        String input = Date;
        
        SimpleDateFormat sdf = new SimpleDateFormat("DD");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("DD");
        java.util.Date Dates = null;
        String Output = null;
        
        try {
            Dates = sdf.parse(input);
            Output = OutputFormat.format(Dates);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToMonth(String Date){
        String input = Date;
        
        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("MM");
        java.util.Date Dates = null;
        String Output = null;
        
        try {
            Dates = sdf.parse(input);
            Output = OutputFormat.format(Dates);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToYear(String Date){
        String input = Date;
        
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("YYYY");
        java.util.Date Dates = null;
        String Output = null;
        
        try {
            Dates = sdf.parse(input);
            Output = OutputFormat.format(Dates);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static String ConvertToDate(String Date){
        String input = Date;
        
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("DD-MM-YYYY");
        java.util.Date Dates = null;
        String Output = null;
        
        try {
            Dates = sdf.parse(input);
            Output = OutputFormat.format(Date);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String ConvertToDateTime(String Date){
        String input = Date;
        
        SimpleDateFormat sdf = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
        SimpleDateFormat OutputFormat = new SimpleDateFormat("DD-MM-YYYY hh:mm:ss");
        java.util.Date Dates = null;
        String Output = null;
        
        try {
            Dates = sdf.parse(input);
            Output = OutputFormat.format(Dates);
            return Output;
        } 
        catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
