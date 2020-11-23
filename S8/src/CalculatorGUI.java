import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;

/**
 * in this class we make graphical interface for calculator
 * and two kind of calculator is available: basic and advance
 */
public class CalculatorGUI {

    //this is the control part for MVC design
    private Operator[] operator;

    //the basic frame of cal
    private JFrame calFrame;
    //the tabbedPane we add two kinds of calculators on
    private JTabbedPane tabbedPane;

    //the basic panel for basic cal
    private JPanel basicPanel;
    //for advance cal
    private JPanel advancePanel;

    //the basic and advance text fields
    private JTextField basicTxtField;
    private JTextField advanceTxtField;
    //the content of text fields
    private String text[];

    //button handlers for basic and advance panels
    private ButtonHandler[] buttonHandlers;

    /**
     * this is a constructor witch calls other classes two make a good interface
     */
    public CalculatorGUI() {
        //initialize array of operators
        operator = new Operator[2];
        operator[0] = new Operator();
        operator[1] = new Operator();

        //initializing objects
        calFrame = new JFrame();

        tabbedPane = new JTabbedPane();

        basicPanel = new JPanel();
        advancePanel = new JPanel();

        buttonHandlers = new ButtonHandler[2];
        buttonHandlers[0] = new ButtonHandler(basicPanel);
        buttonHandlers[1] = new ButtonHandler(advancePanel);

        basicTxtField = new JTextField();
        advanceTxtField = new JTextField();

        text = new String[2];
        text[0] = "";
        text[1] = "";

        //calling the calculator class
        calculator();
    }

    /**
     * in this class we make the frame and the tabbedPane of
     * our calculator and add two panels on tabbedPane
     * at last we call other classes to add other components
     * to our panels
     */
    private void calculator() {
        //frame making and setting the bound of it
        calFrame.setSize(370, 350);
        calFrame.setLocation(300, 250);
        calFrame.add(tabbedPane);

        //make a new menu bar
        JMenuBar menuBar = new JMenuBar();
        calFrame.setJMenuBar(menuBar);

        //add a new menu to menu bar
        JMenu menu = new JMenu("File");
        menu.setMnemonic('F');
        menuBar.add(menu);

        //add items to meu bars and add action listeners to them
        JMenuItem menuItem1 = new JMenuItem("EXIT");
        menuItem1.addActionListener(e -> System.exit(0));
        menuItem1.setMnemonic('X');
        menu.add(menuItem1);

        JMenuItem menuItem2 = new JMenuItem("COPY");
        menuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK ));
        menuItem2.addActionListener(e -> {
            StringSelection stringSelection = new StringSelection (text[0]);
            Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
            clpbrd.setContents (stringSelection, null);
        });
        menu.add(menuItem2);

        //set bounds of tabbedPane and add other panels on
        tabbedPane.setBounds(50, 50, 100, 100);
        tabbedPane.add("Basic", basicPanel);
        tabbedPane.add("Advance", advancePanel);

        //call classes to fill this tabbedPane
        setAdvancePanel();
        setBasicPanel();

        //show the frame
        calFrame.setVisible(true);
        //finish the program after close it
        calFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * in this class we set the components to our calculator
     */
    private void setBasicPanel() {
        //set the layout two null
        basicPanel.setLayout(null);
        //set panels to our basic panel
        setTextField(basicPanel);
        setBasicKeyboard(basicPanel);
        setKeyboardPanelNumbers(basicPanel);
    }
