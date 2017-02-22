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
import java.util.*;
import java.text.DecimalFormat;

/**
 *
 * @author SamsungX
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private Label averageOutput;
    @FXML private TextField input;
    @FXML private Label errorLabel;
    
    private List<Double> array = new ArrayList<>();
    
    @FXML
    private void calculate() {
        try {
            Double get = Double.parseDouble(input.getText());
            if(array.add(get)) {
                Double thisIsAThing = 0d;
                for (int i = 0; i < array.size(); i++) {
                    thisIsAThing += array.get(i);
                }
                thisIsAThing /= array.size();
                averageOutput.setText(new DecimalFormat("#0.00").format(thisIsAThing) + "");
                input.setText("");
                errorLabel.setText("");
            }
            else
                throw new Exception("Welp that broke");
        }
        catch (Exception e) {
            errorLabel.setText("Error: '" + input.getText() + "' is not numeric.");
            System.out.println(e);
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
