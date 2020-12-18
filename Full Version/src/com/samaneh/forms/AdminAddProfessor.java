package com.samaneh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.samaneh.filemanager.FileManager;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This class is for add a new professor to the system by admin
 */

public class AdminAddProfessor extends javax.swing.JFrame{
    private JPanel panel1;
    private JTextField textFieldName;
    private JTextField textFieldFamily;
    private JTextField textFieldUsername;
    private JButton buttonClose;
    private JButton buttonSave;
    private JTextField textFieldPassword;

    Path AdminPathTemp = Paths.get("src/Files", "Admin.txt");
    Path StudentsPathTemp = Paths.get("src/Files", "Students.txt");
    String StudentsPath = String.valueOf(StudentsPathTemp);
    Path ProfessorsPathTemp = Paths.get("src/Files", "Professors.txt");
    String AdminPath = String.valueOf(AdminPathTemp);
    String ProfessorsPath = String.valueOf(ProfessorsPathTemp);

    /**
     * This method is constructor of class
     * @param nothing
     * @return nothing
     */
    public AdminAddProfessor() {
        this.setTitle("افزودن استاد جدید");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(350,220);//set sizes
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible

        /**
         * This method is an ActionListener ! that add a listener to buttonClose for waiting to
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
         * This method is an ActionListener ! that add a listener to buttonSave for waiting to
         * Clicking buttonSave and check the enterances and save Professor
         * @param : no param
         * @return: nothing
         */

        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldName.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا نام استاد را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                if(textFieldFamily.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا نام خانوادگی استاد را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldUsername.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا نام کاربری را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldPassword.getText().trim().length() < 8)
                {
                    JOptionPane.showMessageDialog(null, "پسورد نباید کمتر از 8 کاراکتر باشد",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(IsRepepetiveUsername(textFieldUsername.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "این نام کاربری قبلا انتخاب شده است",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                FileManager fm = new FileManager(ProfessorsPath);
                String Professor = "name=" + textFieldName.getText() + " " + textFieldFamily.getText() + ";"+
                        "username=" + textFieldUsername.getText().trim() + ";" +
                        "password=" + textFieldPassword.getText() + ";" ;
                try {
                    fm.FileWriter(Professor, true);
                    textFieldPassword.setText("");
                    textFieldUsername.setText("");
                    textFieldFamily.setText("");
                    textFieldName.setText("");

                    JOptionPane.showMessageDialog(null,"اطلاعات استاد ثبت شد",
                            "ثبت موفق", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(AdminAddProfessor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This method is to check if a username is used before or not?
     * actually this method check all users such as the only admin, all students and all professors
     * @param Username : This is a username that entered for new professor
     * @return boolean : return the result of checking, if the username be repetitive return true
     * and else return false
     */
    private boolean IsRepepetiveUsername(String Username){
        boolean IsRepepetive = false;
        try {
            FileManager file = new FileManager(StudentsPath);

            if(!file.IsEmpty()){
                String[] result = file.ReadFile();
                int CountLines = file.CountLines();
                for(int i = 0; i < CountLines; i++)
                {
                    String data = result[i];
                    int startuser = data.indexOf("username=");
                    int enduser = data.indexOf(";", startuser);
                    String _username = data.substring(startuser + 9, enduser);

                    if(Username.equals(_username))
                    {IsRepepetive = true; break;}
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(AdminAddProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileManager file = new FileManager(ProfessorsPath);

            if(!file.IsEmpty()){
                String[] result = file.ReadFile();
                int CountLines = file.CountLines();
                for(int i = 0; i < CountLines; i++)
                {
                    String data = result[i];
                    int startuser = data.indexOf("username=");
                    int enduser = data.indexOf(";", startuser);
                    String _username = data.substring(startuser + 9, enduser);

                    if(Username.equals(_username))
                    {IsRepepetive = true; break;}
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(AdminAddProfessor.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            FileManager file = new FileManager(AdminPath);
            if(!file.IsEmpty()){
                String[] result = file.ReadFile();
                int CountLines = file.CountLines();
                for(int i = 0; i < CountLines; i++)
                {
                    String data = result[i];
                    int startuser = data.indexOf("username=");
                    int enduser = data.indexOf(";", startuser);
                    String _username = data.substring(startuser + 9, enduser);

                    if(Username.equals(_username))
                    {IsRepepetive = true; break;}
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(AdminAddProfessor.class.getName()).log(Level.SEVERE, null, ex);

        }
        return IsRepepetive;
    }

}
