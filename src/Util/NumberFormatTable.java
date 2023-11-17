/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Color;
import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Vestryl
 */
public class NumberFormatTable extends DefaultTableCellRenderer{
    
    private static final DecimalFormat df = new DecimalFormat("#,##0.00");
    
    public Component getTableCellRendererComponent(
            JTable Table,Object Value,boolean isSelected,boolean hasFocus,int row, int Column){
        
        Value = df.format((Number)Value);
        
        return super.getTableCellRendererComponent(Table, Value, isSelected, hasFocus, row, Column);
        
    }
}
