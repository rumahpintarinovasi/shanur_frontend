/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Yestin
 */
public class SimpleDateDisplay 
{
    private Calendar cal;
    
    public SimpleDateDisplay (Date _d)
    {
        cal = Calendar.getInstance();
        cal.setTime(_d);
    }
    
    public Date getTgl ()
    {
        return cal.getTime();
    }
    
    public String getStringYYYYMMDD (String _delimiter)
    {
        String s = cal.get(Calendar.YEAR) + _delimiter + (cal.get(Calendar.MONTH) + 1) + _delimiter + cal.get(Calendar.DATE);
        return s;
    }
    
    @Override
    public String toString ()
    {
        String s = cal.get(Calendar.DATE) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.YEAR);
        return s;
    }
}
