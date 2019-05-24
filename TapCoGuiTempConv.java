/* Program Name: Temperature Converter
 * Author: Cody Tapp
 * Date: July 7, 2018
 * Class: CIT 149 Java I
 * Description: This program will convert temperatures from Fahrenheit to Celcius and vice verse. The user can
 * select in the dropdown button what two units to convert. The user can input a number to calculate as well.
 * Temperature results will be displayed to two decimal points to the right. 
 */ 

import javax.swing.*; //Imported to create elements of the GUI window
import java.awt.*;
import java.awt.event.*;

public class TapCoGuiTempConv extends JFrame 
{ // Begin class

    public static void main(String[] args) // This method is only used to call the GUI method to execute. 
    { // Begin method
        new TapCoGuiTempConv();       
    } // End method
    
    // Variables consist of GUI buttons, a comboBox button that is used to select "C to F" or "F to C", and two text fields.
    private JButton buttonConvert;
    private JButton buttonExit;
    private JComboBox<String> conversionSelector = new JComboBox<>(new String[]{"F to C", "C to F"});
    private JTextField inputText;
    private JTextField displayText;
    
    public TapCoGuiTempConv() // This method consists of all of the elements of the GUI program. 
    { // Begin method
        
        // Sets the size, location, title, and closing procedure. 
        this.setSize(500,200);
        this.setLocation(400, 400);
        this.setTitle("Temperature Conversion"); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // New buttonListener and JPanel objects are created. JLabels are added to the window.
        ButtonListener listen = new ButtonListener(); 
        JPanel tempPanel = new JPanel(); 
        tempPanel.add(new JLabel("Enter Temperature to convert:"));
        tempPanel.add(new JLabel("Temp: "));
        
        
        // inputText is the new textField object. Will be used for the user to type in a number up to 10 characters. 
        inputText = new JTextField(10);
        tempPanel.add(inputText);
        
        
        //displayText will retain the results of the calculation after the dialog window is closed. 
        displayText = new JTextField(10);
        displayText.setEditable(false); // Prevents user from editing this textbox. 
        tempPanel.add(displayText);
        
        
        String[] convChoices = {"C to F", "F to C"}; // ComboBox has a string array that will be used to display options in the dropdown menu
        conversionSelector.addActionListener(listen); // ComboBox is added as an action listener and executes based on its selection.
        tempPanel.add(conversionSelector); // ComboBox button is added to the panel. 
        
        // New button object is created and named buttonConvert. It will display a label showing "Convert." 
        buttonConvert = new JButton ("Convert");
        buttonConvert.addActionListener(listen); // When hovered over with a mouse, a tip will display with description.
        buttonConvert.setToolTipText("Calculates the conversion of temperature units."); 
        tempPanel.add(buttonConvert); // Convert button is added to the panel
        
        // Same as previous button, except labeled with Exit and description.
        buttonExit = new JButton ("Exit");
        buttonExit.addActionListener(listen);
        buttonExit.setToolTipText("Closes the window and ends the program.");
        tempPanel.add(buttonExit);
        
        // This method is added to the panel and displayed. 
        this.add(tempPanel);
        this.setVisible(true);
    } // End method
    
    // An inner class is created for the buttonlistener object. When the button is clicked, an event is triggered. 
    private class ButtonListener implements ActionListener
    { // Begin inner class
        public void actionPerformed (ActionEvent e) 
        { // Begin method
            double convertTemp = 0.0; // inner class variable declared, will be used to output the results.           
            double inputTemp = Double.parseDouble(inputText.getText()); // Converts user input to a double used for calculations. 
            if(e.getSource() == buttonConvert) // If buttonConvert event is triggered (clicked)
            { // Begin outer if
                if(conversionSelector.getSelectedItem().toString().equals("C to F")) // If user set comboBox to C to F.
                { // begin inner if
                    double degreesF; // degreesF and degreesC are declared. degreeC will be used as the input and degrees F consists of an equation.
                    double degreesC = inputTemp;
                    degreesF = (9*(degreesC)/5)+32;
                    convertTemp = degreesF; // convertTemp is equivalent to degreeF so it can be converted to string for output. 
                    
                    

                } // end inner if
                
                else if(conversionSelector.getSelectedItem().toString() == ("F to C")) // If F to C is selected in ComboBox
                { // begin inner elseif
                    double degreesC; // degreesC is initialized as the equation, degreesF is initialized to user input.
                    double degreesF = inputTemp;
                    degreesC = (5*(degreesF - 32))/9;
                    convertTemp = degreesC; // same as previous If except degreesC will be used. 
                }// end inner elseif
                
                String convResult = (String.format("%.2f", (convertTemp))); // convResult is declared as string and assigned to outputting convResult as string with 2 decimal places. 
                String displayResult = (convResult); // The displayResult string will process convResult 
                displayText.setText(displayResult); // String is processed into displayText box and will output displayResult        
                inputText.requestFocusInWindow(); // Cursor will refocus into the input textbox
               
            } // End if
            
            else if (e.getSource().equals(buttonExit)) // If the exit button is clicked, program will close and terminate.
            { // begin outter elseif
                System.exit(0);
            } // end outter elseif
    
        } // end inner method
    } // End inner class   
} // End class
    