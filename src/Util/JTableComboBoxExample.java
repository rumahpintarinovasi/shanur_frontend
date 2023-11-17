/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Yestin
 */
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class JTableComboBoxExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JTable ComboBox Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Sample data and column names
        String[] columnNames = {"Item", "Quantity"};
        Object[][] data = {
            {"Item 1", "PCS"},
            {"Item 2", "Box"},
            {"Item 3", "Pack"}
        };

        // Create a table model
        DefaultTableModel model = new DefaultTableModel(data, columnNames);

        // Create a JTable and set the model
        JTable table = new JTable(model);

        // Set ComboBoxRenderer for the "Quantity" column
        String[] options = {"PCS", "Box", "Pack"};
        table.getColumnModel().getColumn(1).setCellEditor(new ComboBoxRenderer(options));

        // Add the table to a scroll pane and add it to the frame
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane);

        frame.pack();
        frame.setVisible(true);
    }
}
