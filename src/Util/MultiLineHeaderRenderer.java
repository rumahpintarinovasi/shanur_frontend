/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Vector;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Yestin
 */
public class MultiLineHeaderRenderer extends JList implements TableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setFont(table.getFont());
        String str = (value == null) ? "" : value.toString();
        BufferedReader br = new BufferedReader(new StringReader(str));
        String line;
        Vector v = new Vector();
        try
        {
            while ((line = br.readLine()) != null)
            {
                v.addElement(line);
            }
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        setListData(v);
        return this;
    }
    
}
