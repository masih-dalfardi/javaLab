import javax.swing.*;
import java.awt.*;

/**
 * in this class we make graphical interface for calculator
 * and two kind of calculator is available: basic and advance
 */
public class CalculatorGUI {

    //the basic frame of cal
    private JFrame calFrame;
    //the tabbedPane we add two kinds of calculators on
    private JTabbedPane tabbedPane;

    //the basic panel for basic cal
    private JPanel basicPanel;
    //for advance cal
    private JPanel advancePanel;

    /**
     * this is a constructor witch calls other classes two make a good interface
     */
    public CalculatorGUI() {
        //initializing objects
        calFrame = new JFrame();
        tabbedPane = new JTabbedPane();
        basicPanel = new JPanel();
        advancePanel = new JPanel();

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
        basicKeyboard(basicPanel);
        setKeyboardPanelNumbers(basicPanel);
    }

    /**
     * in this class we set the components to our calculator
     */
    private void setAdvancePanel() {
        //set the layout two null
        advancePanel.setLayout(null);
        //set panels to our advance panel
        setTextField(advancePanel);
        basicKeyboard(advancePanel);
        setKeyboardPanelNumbers(advancePanel);
        advanceKeyboard(advancePanel);
    }

    /**
     * @param panel this is the panel we want to add our numeric keyboard on
     */
    private void setKeyboardPanelNumbers(JPanel panel) {
        //making a new keyboard and add it to panel
        JPanel keyboard = new JPanel();

        //set size and set layout to grid
        keyboard.setBounds(10, 90, 200, 160);
        keyboard.setLayout(new GridLayout(4, 3));

        //adding buttons to keyboard
        for (int i = 9; i > 0; i--)
            keyboard.add(new JButton("" + i));
        keyboard.add(new JButton("0"));
        keyboard.add(new JButton("."));
        keyboard.add(new JButton("="));

        panel.add(keyboard);
    }

    /**
     * @param panel the panel we want to add the basic operations on
     */
    private void basicKeyboard(JPanel panel) {
        //we make a new panel for basic operations
        JPanel basicKeyboard = new JPanel();

        //set the size and set the layout to frid
        basicKeyboard.setBounds(210, 10, 66, 240);
        basicKeyboard.setLayout(new GridLayout(6, 1));
        //add keyboard on
        basicKeyboard.add(new JButton("AC"));
        basicKeyboard.add(new JButton("/"));
        basicKeyboard.add(new JButton("*"));
        basicKeyboard.add(new JButton("%"));
        basicKeyboard.add(new JButton("-"));
        basicKeyboard.add(new JButton("+"));

        //add the panel on keyboard
        panel.add(basicKeyboard);
    }

    /**
     * @param panel the panel we want to add the advance operators on
     */
    private void advanceKeyboard(JPanel panel) {
        //make a new panel for advance operators and set its size and layout
        JPanel advanceKeyboard = new JPanel();
        advanceKeyboard.setLayout(new GridLayout(6, 1));
        advanceKeyboard.setBounds(280, 10, 66, 240);

        //making an array of buttons and set their fonts
        JButton[] buttons = new JButton[6];
        buttons[0] = new JButton();
        buttons[0].setFont(new Font("Arial", 10, 20));
        advanceKeyboard.add(buttons[0]);
        for (int i = 1; i < 6; i++) {
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("Arial", 10, 10));
            advanceKeyboard.add(buttons[i]);
        }

        //add text of buttons
        buttons[0].setText("shift");
        buttons[1].setText("sin/cos");
        buttons[2].setText("tan/cot");
        buttons[3].setText("exp/log");
        buttons[4].setText("PI");
        buttons[5].setText("E");

        //add the advance keyboard on its panel
        advancePanel.add(advanceKeyboard);
    }

    /**
     * @param panel the panel we want to add a test field on
     */
    private void setTextField(JPanel panel) {
        //make a panel and set its bound
        JTextField textField = new JTextField();
        textField.setBounds(10, 10, 200, 80);

        //set the font of this text field
        textField.setFont(new Font("Arial", 14, 14));

        //add text field on panel
        panel.add(textField);
    }

}