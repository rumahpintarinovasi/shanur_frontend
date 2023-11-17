/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventori;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

/**
 *
 * @author Yestin
 */
public class CustomComboBoxEditor extends DefaultCellEditor {
    private JComboBox<String> comboBox;

    public CustomComboBoxEditor() {
        super(new JComboBox<String>());
        comboBox = (JComboBox<String>) getComponent();
        comboBox.addItem("Category 1");
        comboBox.addItem("Category 2");
        comboBox.addItem("Category 3");
    }
}
