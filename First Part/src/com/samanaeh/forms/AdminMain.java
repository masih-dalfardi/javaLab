package com.samanaeh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMain extends javax.swing.JFrame {
    private JPanel panel1;
    private JButton buttonChangeusername;
    private JButton buttonFood;
    private JButton ButtonSeeStudents;
    private JButton buttonSeeMasters;
    private JButton ButtonListClasses;
    private JButton buttonAddStudent;
    private JButton buttonAddMaster;
    private JButton buttonClose;

    public AdminMain(){

        this.setTitle("پنل ادمین");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(500, 250);// set size
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
                new AdminSetting();
            }
        });
        buttonFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFood();
            }
        });
        ButtonSeeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeStudentsList();
            }
        });
        buttonSeeMasters.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeMastersList();
            }
        });
        ButtonListClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeClasses();
            }
        });
        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddStudent();
            }
        });
        buttonAddMaster.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddMaster();
            }
        });
    }
}
