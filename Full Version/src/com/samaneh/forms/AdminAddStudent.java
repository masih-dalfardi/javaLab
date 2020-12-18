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

/**
 * This class is to add a new Student to system by admin
 */

public class AdminAddStudent extends javax.swing.JFrame{
    private JPanel panel1;
    private JTextField textFieldName;
    private JTextField textFieldFamily;
    private JTextField textFieldStudentNumber;
    private JTextField textFieldCourse;
    private JTextField textFieldUsername;
    private JButton buttonClose;
    private JButton buttonSave;
    private JTextField textFieldPassword;

    Path AdminPathTemp = Paths.get("src/Files", "Admin.txt");
    String AdminPath = String.valueOf(AdminPathTemp);
    Path StudentsPathTemp = Paths.get("src/Files", "Students.txt");
    String StudentsPath = String.valueOf(StudentsPathTemp);
    Path ProfessorsPathTemp = Paths.get("src/Files", "Professors.txt");
    String ProfessorsPath = String.valueOf(ProfessorsPathTemp);


    /**
     * This method is constructor of class
     * @param : nothing
     * @return : nothing
     */
    public AdminAddStudent() {
        this.setTitle("افزودن دانشجوی جدید");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(350,250);//set sizes
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible
        StudentNumberValidation();

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
         * Clicking buttonSave and check the inputs and save student
         * @param : no param
         * @return: nothing
         */
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldName.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا نام را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldFamily.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا نام خانوادگی را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldStudentNumber.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفا شماره دانشجویی را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldCourse.getText().trim().length() == 0)
                {
                    JOptionPane.showMessageDialog(null, "لطفارشته تحصیلی را وارد کنید",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if(textFieldUsername.getText().trim().equals("")){
                    JOptionPane.showMessageDialog(new JFrame(), "نام کاربری را وارد کنید",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(textFieldPassword.getText().trim().length() < 8){
                    JOptionPane.showMessageDialog(new JFrame(), "رمز عبور نباید کمتر از 8 کاراکتر باشد",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if(IsRepepetiveUsername(textFieldUsername.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "این نام کاربری قبلا انتخاب شده است",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                FileManager fm = new FileManager(StudentsPath);
                String student = "name=" + textFieldName.getText() + " " + textFieldFamily.getText() + ";"+
                        "username=" + textFieldUsername.getText().trim()+ ";" +
                        "password=" + textFieldPassword.getText() + ";" +
                        "studentnumber=" + textFieldStudentNumber.getText().trim() + ";" +
                        "course=" + textFieldCourse.getText() + ";" +
                        "credit=0;reservefood=000000000000000000000;";
                try {
                    fm.FileWriter(student, true);
                    textFieldName.setText("");
                    textFieldFamily.setText("");
                    textFieldUsername.setText("");
                    textFieldPassword.setText("");
                    textFieldStudentNumber.setText("");
                    textFieldCourse.setText("");

                    JOptionPane.showMessageDialog(null,"دانشجو با موفقیت ثبت شد",
                            "موفق", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(AdminAddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminAddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminAddStudent.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(AdminAddStudent.class.getName()).log(Level.SEVERE, null, ex);

        }
        return IsRepepetive;
    }

    /**
     * This method is for checking the enterance of student number, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void StudentNumberValidation()
    {
        textFieldStudentNumber.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldStudentNumber.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldStudentNumber.setEditable(true);
                } else {
                    textFieldStudentNumber.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "خطا", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
