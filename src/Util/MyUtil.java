/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.io.BufferedReader;
import java.net.URL;
import java.text.*;
import java.util.*;
import App.Main;
import java.io.InputStreamReader;
import java.net.URLConnection;

/**
 *
 * @author vitbeljasten
 */
public class MyUtil {
    
    public static String ConvertCalendarToYMD(Calendar c){
        
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getInstance();
        sdf.applyPattern("yyyy-MM-dd");
        
        return sdf.format(c.getTime());
    }
    
    public static String ConvertCalendarToYear(Calendar y){
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getInstance();
        sdf.applyPattern("yyyy");
        
        return sdf.format(y.getTime());
    }
    
    public static String ConvertCalendarToDate(Calendar d){
        SimpleDateFormat sdf = (SimpleDateFormat) SimpleDateFormat.getInstance();
        sdf.applyPattern("dd");
        return sdf.format(d.getTime());
    }
    
}
