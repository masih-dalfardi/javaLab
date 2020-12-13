package com.samanaeh.forms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminFood extends javax.swing.JFrame{
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton buttonSave;
    private JButton buttonClose;
    private JPanel panel1;

    public AdminFood() {
        this.setTitle("تنظیم برنامه غذایی");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(1100,280);//set sizes
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
