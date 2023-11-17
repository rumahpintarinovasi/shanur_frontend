/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Component;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JTable;
import static javax.swing.SwingConstants.RIGHT;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;


/**
 *
 * @author Vestryl
 */
public class DateFormatTableAlignment extends DefaultTableCellRenderer{
    
    
    @Override
    public Component getTableCellRendererComponent(JTable Table,Object Value,boolean isSelected,boolean hashFocus,
            int row, int column){
        Component C = super.getTableCellRendererComponent(Table, Value, isSelected, hashFocus, row, column);
        
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr = (DefaultTableCellRenderer) C;
        dtcr.setHorizontalAlignment(CENTER);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date Date = (Date)Value;
        String text = sdf.format(Date);
        dtcr.setText(text);
        
        return C;
    }
}
