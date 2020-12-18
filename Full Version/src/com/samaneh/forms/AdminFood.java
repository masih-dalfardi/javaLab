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
 * This class is for create the food plan by admin , to use students
 */
public class AdminFood extends javax.swing.JFrame{
    private JTextField textFieldSatBreak;
    private JTextField textFieldSatLunch;
    private JTextField textFieldSatDinner;
    private JTextField textFieldSatBreakPrice;
    private JTextField textFieldSatLunchPrice;
    private JTextField textFieldSatDinnerPrice;
    private JTextField textFieldSunBreak;
    private JButton buttonSave;
    private JButton buttonClose;
    private JPanel panel1;
    private JTextField textFieldSunBreakPrice;
    private JTextField textFieldMonBreak;
    private JTextField textFieldMonBreakPrice;
    private JTextField textFieldTuseBreak;
    private JTextField textFieldTuseBreakPrice;
    private JTextField textFieldWedBreak;
    private JTextField textFieldWedBreakPrice;
    private JTextField textFieldThursBreak;
    private JTextField textFieldThursBreakPrice;
    private JTextField textFieldSunLunch;
    private JTextField textFieldSunLunchPrice;
    private JTextField textFieldMonLunch;
    private JTextField textFieldMonLunchPrice;
    private JTextField textFieldTuseLunch;
    private JTextField textFieldTuseLunchPrice;
    private JTextField textFieldWedLunch;
    private JTextField textFieldWedLunchPrice;
    private JTextField textFieldThursLunch;
    private JTextField textFieldThursLunchPrice;
    private JTextField textFieldSunDinner;
    private JTextField textFieldSunDinnerPrice;
    private JTextField textFieldMonDinner;
    private JTextField textFieldMonDinnerPrice;
    private JTextField textFieldTuseDinner;
    private JTextField textFieldTuseDinnerPrice;
    private JTextField textFieldWedDinner;
    private JTextField textFieldWedDinnerPrice;
    private JTextField textFieldThursDinner;
    private JTextField textFieldThursDinnerPrice;

    Path FoodPlanPathTemp = Paths.get("src/Files", "FoodPaln.txt");
    String FoodPlanPath = String.valueOf(FoodPlanPathTemp);

    /**
     * This method is constructor of class
     * @param : nothing
     * @return : nothing
     */
    public AdminFood() {
        this.setTitle("تنظیم برنامه غذایی");//Add Title
        this.setContentPane(panel1);//Add Root Pane
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Completely exit
        this.setSize(1100,280);//set sizes
        this.setLocationRelativeTo(null);//start in center of Screen
        this.setVisible(true);//set visible
        NumberValidation1();
        NumberValidation2();
        NumberValidation3();
        NumberValidation4();
        NumberValidation5();
        NumberValidation6();
        NumberValidation7();
        NumberValidation8();
        NumberValidation9();
        NumberValidation10();
        NumberValidation11();
        NumberValidation12();
        NumberValidation13();
        NumberValidation14();
        NumberValidation15();
        NumberValidation16();
        NumberValidation17();
        NumberValidation18();

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
         * Clicking buttonSave and check the enterances and save food plan
         * @param : no param
         * @return: nothing
         */
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldSatBreak.getText().trim().equals("")|| textFieldSatBreakPrice.getText().trim().equals("")||
                        textFieldSatLunch.getText().trim().equals("")|| textFieldSatLunchPrice.getText().trim().equals("")||
                        textFieldSatDinner.getText().trim().equals("")|| textFieldSatDinnerPrice.getText().trim().equals("")||

                        textFieldSunBreak.getText().trim().equals("")|| textFieldSunBreakPrice.getText().trim().equals("")||
                        textFieldSunLunch.getText().trim().equals("")|| textFieldSunLunchPrice.getText().trim().equals("")||
                        textFieldSunDinner.getText().trim().equals("")|| textFieldSunDinner.getText().trim().equals("")||

                        textFieldMonBreak.getText().trim().equals("")|| textFieldMonBreakPrice.getText().trim().equals("")||
                        textFieldMonLunch.getText().trim().equals("")|| textFieldMonLunchPrice.getText().trim().equals("")||
                        textFieldMonDinner.getText().trim().equals("")|| textFieldMonDinnerPrice.getText().trim().equals("")||

                        textFieldTuseBreak.getText().trim().equals("")|| textFieldTuseBreakPrice.getText().trim().equals("")||
                        textFieldTuseLunch.getText().trim().equals("")|| textFieldTuseLunchPrice.getText().trim().equals("")||
                        textFieldTuseDinner.getText().trim().equals("")|| textFieldTuseDinnerPrice.getText().trim().equals("")||

                        textFieldWedBreak.getText().trim().equals("")|| textFieldWedBreakPrice.getText().trim().equals("")||
                        textFieldWedLunch.getText().trim().equals("")|| textFieldWedLunchPrice.getText().trim().equals("")||
                        textFieldWedDinner.getText().trim().equals("")|| textFieldWedDinnerPrice.getText().trim().equals("")||

                        textFieldThursBreak.getText().trim().equals("")|| textFieldThursBreakPrice.getText().trim().equals("")||
                        textFieldThursLunch.getText().trim().equals("")|| textFieldThursLunchPrice.getText().trim().equals("")||
                        textFieldThursDinner.getText().trim().equals("")|| textFieldThursDinnerPrice.getText().trim().equals(""))
                {JOptionPane.showMessageDialog(new JFrame(), "همه فیلدها را باید پر کنید",
                        "Dialog", JOptionPane.ERROR_MESSAGE);
                    return;}

                FileManager fm = new FileManager(FoodPlanPath);
                String Saturday = "day=saturday;"  + "breakfast=" + textFieldSatBreak.getText() +
                        ";breakfastprice=" + textFieldSatBreakPrice.getText() +
                        ";lunch=" + textFieldSatLunch.getText() +
                        ";lunchprice=" + textFieldSatLunchPrice.getText() +
                        ";dinner=" + textFieldSatDinner.getText() +
                        ";dinnerprice=" + textFieldSatDinnerPrice.getText() + ";";
                String Sunday = "day=sunday;"  + "breakfast=" + textFieldSunBreak.getText() +
                        ";breakfastprice=" + textFieldSunBreakPrice.getText() +
                        ";lunch=" + textFieldSunLunch.getText() +
                        ";lunchprice=" + textFieldSunLunchPrice.getText() +
                        ";dinner=" + textFieldSunDinner.getText() +
                        ";dinnerprice=" + textFieldSunDinnerPrice.getText() + ";";
                String Monday = "day=monday;"  + "breakfast=" + textFieldMonBreak.getText() +
                        ";breakfastprice=" + textFieldMonBreakPrice.getText() +
                        ";lunch=" + textFieldMonLunch.getText() +
                        ";lunchprice=" + textFieldMonLunchPrice.getText() +
                        ";dinner=" + textFieldMonDinner.getText() +
                        ";dinnerprice=" + textFieldMonDinnerPrice.getText() + ";";
                String Tuseday = "day=tuseday;"  + "breakfast=" + textFieldTuseBreak.getText() +
                        ";breakfastprice=" + textFieldTuseBreakPrice.getText() +
                        ";lunch=" + textFieldTuseLunch.getText() +
                        ";lunchprice=" + textFieldTuseLunchPrice.getText() +
                        ";dinner=" + textFieldTuseDinner.getText() +
                        ";dinnerprice=" + textFieldTuseDinnerPrice.getText() + ";";
                String Wednesday = "day=wednesday;"  + "breakfast=" + textFieldWedBreak.getText() +
                        ";breakfastprice=" + textFieldWedBreakPrice.getText() +
                        ";lunch=" + textFieldWedLunch.getText() +
                        ";lunchprice=" + textFieldWedLunchPrice.getText() +
                        ";dinner=" + textFieldWedDinner.getText() +
                        ";dinnerprice=" + textFieldWedDinnerPrice.getText() + ";";
                String Thursday = "day=thursday;"  + "breakfast=" + textFieldThursBreak.getText() +
                        ";breakfastprice=" + textFieldThursBreakPrice.getText() +
                        ";lunch=" + textFieldThursLunch.getText() +
                        ";lunchprice=" + textFieldThursLunchPrice.getText() +
                        ";dinner=" + textFieldThursDinner.getText() +
                        ";dinnerprice=" + textFieldThursDinnerPrice.getText() + ";";
                try {
                    fm.FileWriter(Saturday, false);
                    fm.FileWriter(Sunday, true);
                    fm.FileWriter(Monday, true);
                    fm.FileWriter(Tuseday, true);
                    fm.FileWriter(Wednesday, true);
                    fm.FileWriter(Thursday, true);
                    JOptionPane.showMessageDialog(new JFrame(), "با موفقیت ثبت شد", "تایید", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    Logger.getLogger(AdminFood.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation1()
    {
        textFieldSatBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSatBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSatBreakPrice.setEditable(true);
                } else {
                    textFieldSatBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation2()
    {
        textFieldSunBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSunBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSunBreakPrice.setEditable(true);
                } else {
                    textFieldSunBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation3()
    {
        textFieldMonBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldMonBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldMonBreakPrice.setEditable(true);
                } else {
                    textFieldMonBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation4()
    {
        textFieldTuseBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldTuseBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldTuseBreakPrice.setEditable(true);
                } else {
                    textFieldTuseBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation5()
    {
        textFieldWedBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldWedBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldWedBreakPrice.setEditable(true);
                } else {
                    textFieldWedBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation6()
    {
        textFieldThursBreakPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldThursBreakPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldThursBreakPrice.setEditable(true);
                } else {
                    textFieldThursBreakPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation7()
    {
        textFieldSatLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSatLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSatLunchPrice.setEditable(true);
                } else {
                    textFieldSatLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation8()
    {
        textFieldSunLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSunLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSunLunchPrice.setEditable(true);
                } else {
                    textFieldSunLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation9()
    {
        textFieldMonLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldMonLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldMonLunchPrice.setEditable(true);
                } else {
                    textFieldMonLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation10()
    {
        textFieldTuseLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldTuseLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldTuseLunchPrice.setEditable(true);
                } else {
                    textFieldTuseLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation11()
    {
        textFieldWedLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldWedLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldWedLunchPrice.setEditable(true);
                } else {
                    textFieldWedLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation12()
    {
        textFieldThursLunchPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldThursLunchPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldThursLunchPrice.setEditable(true);
                } else {
                    textFieldThursLunchPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation13()
    {
        textFieldSatDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSatDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSatDinnerPrice.setEditable(true);
                } else {
                    textFieldSatDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */

    private void NumberValidation14()
    {
        textFieldSunDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldSunDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldSunDinnerPrice.setEditable(true);
                } else {
                    textFieldSunDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */

    private void NumberValidation15()
    {
        textFieldMonDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldMonDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldMonDinnerPrice.setEditable(true);
                } else {
                    textFieldMonDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */

    private void NumberValidation16()
    {
        textFieldTuseDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldTuseDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldTuseDinnerPrice.setEditable(true);
                } else {
                    textFieldTuseDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */

    private void NumberValidation17()
    {
        textFieldWedDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldWedDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldWedDinnerPrice.setEditable(true);
                } else {
                    textFieldWedDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }

    /**
     * This method is for vhecking the enterance of food price, to be sure that we have only numbers!
     * we use this method in several places of our project for checking enterances
     * @param : no param
     * @return : nothing
     */
    private void NumberValidation18()
    {
        textFieldThursDinnerPrice.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                String value = textFieldThursDinnerPrice.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
                    textFieldThursDinnerPrice.setEditable(true);
                } else {
                    textFieldThursDinnerPrice.setEditable(false);
                    JOptionPane.showMessageDialog(new JFrame(), "فقط عدد وارد کنید", "Dialog", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
