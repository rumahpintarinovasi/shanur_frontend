/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Transaksi.gui.DataTransaksi;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Yestin
 */
public class BackgroundImage {
    
    private static final String BACKHGROUND_IMAGE_URL = "\\E-POS\\Pink Background 18.jpg";

    public void initUI(JPanel mainPanel) throws MalformedURLException {
//        dialog = new JDialog((Frame) null, BackgroundImage.class.getSimpleName());
//        dialog.setModal(true);
//        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        ImageIcon backgroundImage = new ImageIcon(BACKHGROUND_IMAGE_URL);
        mainPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }

            @Override
            public Dimension getPreferredSize() {
                Dimension size = super.getPreferredSize();
                size.width = Math.max(backgroundImage.getIconWidth(), size.width);
                size.height = Math.max(backgroundImage.getIconHeight(), size.height);

                return size;
            }
        };
//        mainPanel.add(new JButton("A button"), BorderLayout.WEST);
//        dialog.add(mainPanel);
//        dialog.setSize(400, 300);
//        dialog.setVisible(true);
    }
    
    public void BackgroundJPanel(JFrame Frame,JPanel Panel){
        try {
            BackgroundPane Background = new BackgroundPane();
            Background.setBackground(ImageIO.read(new File("\\E-POS\\Pink Background 18.jpg")));
            Background.setLayout(new BorderLayout());
            Panel.setOpaque(false);
            Background.add(Panel,BorderLayout.CENTER);
            Frame.setLayout(new BorderLayout());
            Frame.add(Background, BorderLayout.CENTER);
        }
        catch (IOException e) {
            Logger.getLogger(DataTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void BackgroundJPanel(JDialog Dialog,JPanel Panel){
        try {
            BackgroundPane Background = new BackgroundPane();
            Background.setBackground(ImageIO.read(new File("\\E-POS\\Pink Background 18.jpg")));
            Background.setLayout(new BorderLayout());
            Panel.setOpaque(false);
            Background.add(Panel,BorderLayout.CENTER);
            Dialog.setLayout(new BorderLayout());
            Dialog.add(Background, BorderLayout.CENTER);
        }
        catch (IOException e) {
            Logger.getLogger(DataTransaksi.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
