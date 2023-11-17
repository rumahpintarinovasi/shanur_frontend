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
import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

public class ComboBoxRenderer extends DefaultCellEditor {
    public ComboBoxRenderer(String[] items) {
        super(new JComboBox<>(items));
    }
}

