package com.samanaeh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterDeleteClass extends javax.swing.JFrame{
    private JPanel panel1;
    private JComboBox comboBox1;
    private JButton buttonDeleteClass;
    private JButton buttonClose;

    public MasterDeleteClass() {
        this.setTitle("بستن کلاس");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(300,150);// sizes the frame so that all its contents
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
