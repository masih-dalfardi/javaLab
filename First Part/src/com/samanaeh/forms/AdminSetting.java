package com.samanaeh.forms;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminSetting extends javax.swing.JFrame{
    private JPanel panel1;
    private JTextField textFieldNewUsername;
    private JPasswordField passwordFieldNewPassword;
    private JButton ButtonClose;
    private JButton buttonSaveChange;

    public AdminSetting() {
        this.setTitle("تغییر نام کاربری و رمز عبور");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(330,160);// sizes the frame so that all its contents
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible

        ButtonClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
}
