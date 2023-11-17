/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Component;
import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
//import org.jfree.ui.DateCellRenderer;

/**
 *
 * @author Vestryl
 */
public class DoubleFormatTableAlignment extends DefaultTableCellRenderer{
    
    @Override
    public Component getTableCellRendererComponent(JTable Table,Object Value,boolean isSelected,boolean hashFocus,
            int row, int column){
        Component C = super.getTableCellRendererComponent(Table, Value, isSelected, hashFocus, row, column);
        
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr = (DefaultTableCellRenderer) C;
        dtcr.setHorizontalAlignment(RIGHT);
        DecimalFormat NumberFormat = new DecimalFormat("#,##0");
        Number Number = (Number)Value;
        String Text = NumberFormat.format(Number);
        dtcr.setText(Text);
        
        return C;
    }
}
