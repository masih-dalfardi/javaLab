package com.samanaeh.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminAddMaster extends javax.swing.JFrame{
    private JPanel panel1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField5;
    private JPasswordField passwordField1;
    private JButton buttonClose;
    private JButton buttonSave;

    public AdminAddMaster() {
        this.setTitle("افزودن استاد جدید");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(350,220);//set sizes
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
