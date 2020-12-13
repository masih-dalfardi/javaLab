package com.samanaeh.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSeeMastersList  extends javax.swing.JFrame{
    private JPanel panel1;
    private JTable table1;
    private JButton buttonClose;

    public AdminSeeMastersList() {
        this.setTitle("لیست استادها");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.pack();// sizes the frame so that all its contents
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
