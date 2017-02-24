/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lx04;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import java.util.*; //for the ArrayList object
import java.text.DecimalFormat;

/**
 *
 * @author SamsungX
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label averageOutput;
    @FXML private TextField input;
    @FXML private Label errorLabel;
    
    private List<Double> array = new ArrayList<>(); //initialize an array list that only takes in double
    /* An array list is an object that allows for
     * saving items like an array without a fixed limit
     * on the amount of items to be saved
     */
    
    @FXML
    private void calculate() {
        try {
            Double get = Double.parseDouble(input.getText()); //Parse the text from the text box
            if(array.add(get)) { //add the parsed text to the array list
                //this is placed inside an if statement because there can be errors whenever an element is added into an array list
                Double thisIsAThing = 0d; //initialize a double variable to hold the sum of the entire array
                for (int i = 0; i < array.size(); i++) { //this entire for loop is just for getting the sum of the array
                    thisIsAThing += array.get(i); //array.get() takes in the index as a parameter and returns that value. add that to the variable
                }
                thisIsAThing /= array.size(); //divide with the total size of the array to get the mean average
                averageOutput.setText(new DecimalFormat("#0.00").format(thisIsAThing) + ""); //oh look a new object let's explain it indepth
                /* A DecimalFormat object is an object that is found in the
                 * java.text library. It is capable of detecting and reformatting
                 * double and float values to fit a specific decimal format.
                 * The object also turns it automatically into a string! So that's quite convenient...
                 */
                input.setText("");
                errorLabel.setText("");
            }
            else
                throw new Exception("Welp that broke"); //in case the array list doesn't take any more or something did break...
        }
        catch (Exception e) { //your average exception catcher
            errorLabel.setText("Error: '" + input.getText() + "' is not numeric.");
            System.out.println(e); //this is a debug line in checking what the exception actually is
        }
    }
    
    @FXML private void reset() {
        array.clear();
        errorLabel.setText("");
        averageOutput.setText("0.00");
        input.setText("");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
