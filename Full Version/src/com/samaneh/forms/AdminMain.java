package com.samaneh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the Panel of Admin to access all items
 */
public class AdminMain extends javax.swing.JFrame {
    private JPanel panel1;
    private JButton buttonChangeusername;
    private JButton buttonFood;
    private JButton ButtonSeeStudents;
    private JButton buttonSeeProfessors;
    private JButton ButtonListClasses;
    private JButton buttonAddStudent;
    private JButton buttonAddProfessor;
    private JButton buttonClose;

    /**
     * This method is constructor of class
     * @param : nothing
     * @return : nothing
     */
    public AdminMain(){

        this.setTitle("پنل ادمین");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(500, 250);// set size
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible

        /**
         * This method is an ActionListener ! that add a listener for buttonClose for waiting to
         * Clicking buttonClose and Close the app
         * @param : no param
         * @return: nothing
         */
        buttonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener to Changeusername for waiting to
         * Clicking buttonChangeusername and run the AdminSetting()
         * @param : no param
         * @return: nothing
         */
        buttonChangeusername.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSetting();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for buttonFood for waiting to
         * Clicking buttonFood and run the AdminFood()
         * @param : no param
         * @return: nothing
         */
        buttonFood.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminFood();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for ButtonSeeStudents for waiting to
         * Clicking ButtonSeeStudents and run the AdminSeeStudentsList()
         * @param : no param
         * @return: nothing
         */
        ButtonSeeStudents.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeStudentsList();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for buttonSeeProfessors for waiting to
         * Clicking buttonSeeProfessors and run the AdminSeeProfessorsList()
         * @param : no param
         * @return: nothing
         */
        buttonSeeProfessors.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeProfessorsList();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for ButtonListClasses for waiting to
         * Clicking ButtonListClasses and run the AdminSeeClasses()
         * @param : no param
         * @return: nothing
         */
        ButtonListClasses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminSeeClasses();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for buttonAddStudent for waiting to
         * Clicking buttonAddStudent and run the AdminAddStudent()
         * @param : no param
         * @return: nothing
         */
        buttonAddStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddStudent();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for buttonAddProfessor for waiting to
         * Clicking buttonAddProfessor and run the AdminAddProfessor()
         * @param : no param
         * @return: nothing
         */
        buttonAddProfessor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminAddProfessor();
            }
        });
    }
}
