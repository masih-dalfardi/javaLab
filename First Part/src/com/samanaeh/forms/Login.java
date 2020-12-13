package com.samanaeh.forms;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends javax.swing.JFrame{
    private JPanel panel1;
    private JTextField textFieldUsername;
    private JComboBox comboBoxLogin;
    private JButton ButtonLogin;
    private JButton ButtonClose;
    private JPasswordField passwordField;
    private JPanel jpanel1;

    public Login(){
        comboBoxLogin.addItem("استاد");
        comboBoxLogin.addItem("دانشجو");
        comboBoxLogin.addItem("ادمین");

        this.setTitle("ورود");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(350,210);// sizes the frame so that all its contents
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible

        ButtonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {dispose();}
        });
        ButtonLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch (comboBoxLogin.getSelectedIndex()) {
                    case 0:
                        new MasterMain();
                        break;

                    case 1:
                        new StudentMain();
                        break;

                    case 2:
                        new AdminMain();
                        break;
                }
            }
        });
    }

    public static void main(String[] args) {
        new Login();
    }
}
