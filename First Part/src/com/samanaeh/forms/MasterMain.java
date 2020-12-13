package com.samanaeh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MasterMain extends javax.swing.JFrame{
    private JPanel panel1;
    private JButton buttonChangeusername;
    private JButton ButtonSeeStudents;
    private JButton buttonSeeMasters;
    private JButton buttonFood;
    private JButton ButtonListClasses;
    private JButton buttonClose;
    private JTextField textField1;
    private JTextField textField2;

    public MasterMain() {
        this.setTitle("پنل استاد");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(380,220);// sizes the frame so that all its contents
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible

        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        buttonChangeusername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterSetting();
            }
        });
        buttonFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterSeeClasses();
            }
        });
        ButtonSeeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterSeeListStudentInClasses();
            }
        });
        buttonSeeMasters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterCreateClass();
            }
        });
        ButtonListClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MasterDeleteClass();
            }
        });
    }
}
