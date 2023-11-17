/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Yestin
 */
public class CustomComboBoxRenderer extends JComboBox<String> implements TableCellRenderer {
    public CustomComboBoxRenderer() {
        addItem("Category 1");
        addItem("Category 2");
        addItem("Category 3");
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setSelectedItem(value);
        return this;
    }
}
