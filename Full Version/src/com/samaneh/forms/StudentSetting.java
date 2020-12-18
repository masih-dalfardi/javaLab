package com.samaneh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.samaneh.filemanager.FileManager;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * This method is for changing username and password of student
 */
public class StudentSetting  extends javax.swing.JFrame{
    private JButton buttonSaveChange;
    private JTextField textFieldNewUsername;
    private JButton ButtonClose;
    private JPanel panel1;
    private JTextField textFieldNewPass;

    Path AdminPathTemp = Paths.get("src/Files", "Admin.txt");
    Path StudentsPathTemp = Paths.get("src/Files", "Students.txt");
    Path ProfessorsPathTemp = Paths.get("src/Files", "Professors.txt");
    String AdminPath = String.valueOf(AdminPathTemp);
    String StudentsPath = String.valueOf(StudentsPathTemp);
    String ProfessorsPath = String.valueOf(ProfessorsPathTemp);
    Path SelectUnitPathTemp = Paths.get("src/Files", "SelectUnit.txt");
    String SelectUnitPath = String.valueOf(SelectUnitPathTemp);

    private String studentusername;

    /**
     * This method is constructor of class
     * @param  StudentUsername This param used for replacing old username with new username and password
     * @return  nothing
     */
    public StudentSetting(String StudentUsername) {
        studentusername = StudentUsername;
        this.setTitle("تغییر نام کاربری و رمز عبور");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(330,160);// set size
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible


        /**
         * This method is an ActionListener ! that add a listener for buttonClose for waiting to
         * Clicking buttonClose and Close the app
         * @param : no param
         * @return: nothing
         */
        ButtonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        /**
         * This method is an ActionListener ! that add a listener for buttonSaveChange for waiting to
         * Clicking buttonSaveChange and saves the new username and password
         * @param : no param
         * @return: nothing
         */
        buttonSaveChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldNewUsername.getText().trim().length() < 3)
                {
                    JOptionPane.showMessageDialog(null,"نام کاربری نمی تواند کمتر از 3 حرف باشد",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    setVisible(true);
                    return;
                }
                if(textFieldNewPass.getText().trim().length() < 8)
                {
                    JOptionPane.showMessageDialog(null, "پسورد نمی تواند کمتر از 8 کاراکتر باشد",
                            "هشدار", JOptionPane.WARNING_MESSAGE);
                    setVisible(true);
                    return;
                }

                if(IsRepepetiveUsername(textFieldNewUsername.getText())){
                    JOptionPane.showMessageDialog(new JFrame(), "این نام کاربری قبلا انتخاب شده است",
                            "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try {
                    String OldUsername = null, OldPassword = null;
                    FileManager fm = new FileManager(StudentsPath);
                    String[] result = fm.ReadFile();
                    int CountLines = fm.CountLines();
                    int studentRow;
                    for(studentRow = 0; studentRow < CountLines; studentRow++){
                        String data = result[studentRow];
                        int startuser = data.indexOf("username=");
                        int enduser = data.indexOf(";", startuser);
                        OldUsername = data.substring(startuser + 9, enduser);
                        int startpass = data.indexOf("password=");
                        int endpass = data.indexOf(";", startpass);
                        OldPassword = data.substring(startpass + 9, endpass);
                        if(studentusername.equals(OldUsername))
                        { break;}
                    }
                    String FoundStudent = result[studentRow];
                    FoundStudent = FoundStudent.replace(OldUsername, textFieldNewUsername.getText());
                    FoundStudent = FoundStudent.replace(OldPassword, textFieldNewPass.getText());
                    result[studentRow] = FoundStudent;
                    for(int i = 0 ; i < CountLines; i++){
                        if(i ==0)
                            fm.FileWriter(result[i], false);
                        else
                            fm.FileWriter(result[i], true);
                    }
                } catch (IOException ex) {
                    Logger.getLogger(StudentSetting.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {
                    String OldUsername = null, OldPassword = null;
                    FileManager fm = new FileManager(SelectUnitPath);
                    if(!fm.IsEmpty()){
                        String[] result = fm.ReadFile();
                        int CountLines = fm.CountLines();
                        int studentRow;
                        for(studentRow = 0; studentRow < CountLines; studentRow++){
                            String data = result[studentRow];
                            int startuser = data.indexOf("studentusername=");
                            int enduser = data.indexOf(";", startuser);
                            OldUsername = data.substring(startuser + 16, enduser);
                            if(StudentMain.studentusername.equals(OldUsername)){
                                String FoundStudent = result[studentRow];
                                FoundStudent = FoundStudent.replace(OldUsername, textFieldNewUsername.getText());
                                result[studentRow] = FoundStudent;
                            }
                        }
                        for(int i = 0 ; i < CountLines; i++){
                            if(i ==0)
                                fm.FileWriter(result[i], false);
                            else
                                fm.FileWriter(result[i], true);
                        }
                    }
                    StudentMain.studentusername = studentusername = textFieldNewUsername.getText();
                    JOptionPane.showMessageDialog(null,"اطلاعات با موفقیت تغییر یافت",
                            "ثبت موفق", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(StudentSetting.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }


    /**
     * This method is to check if a username is used before or not?
     * actually this method check all users such as the only admin, all students and all professors
     * @param Username : This is a username that entered for new student username
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
            Logger.getLogger(StudentSetting.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentSetting.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(StudentSetting.class.getName()).log(Level.SEVERE, null, ex);
        }
        return IsRepepetive;
    }
}
