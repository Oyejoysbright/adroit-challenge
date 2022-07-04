/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.adroit.challenge.models.SearchData;

/**
 * FXML Controller class
 *
 * @author Ayomide Joysbright Oyediran
 */

public class SearchBoxController implements Initializable {

    @FXML
    private ComboBox<String> field1;
    @FXML
    private ComboBox<String> field2;
    @FXML
    private ComboBox<String> field3;
    @FXML
    private ComboBox<String> field4;
    @FXML
    private ComboBox<String> field5;
    @FXML
    private TextField value1;
    @FXML
    private TextField value2;
    @FXML
    private TextField value3;
    @FXML
    private TextField value4;
    @FXML
    private TextField value5;
    
    private Object caller;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void onClearValues(ActionEvent event) {        
        field1.setValue("");
        field2.setValue("");
        field3.setValue("");
        field4.setValue("");
        field5.setValue("");
        
        String promptText = "select";
        field1.setPromptText(promptText);
        field2.setPromptText(promptText);
        field3.setPromptText(promptText);
        field4.setPromptText(promptText);
        field5.setPromptText(promptText);
        
        value1.setText("");
        value2.setText("");
        value3.setText("");
        value4.setText("");
        value5.setText("");
        
        doSearch(new SearchData());
    }
    
    private void doSearch(SearchData data) {
        try {
            DataViewController controller1 = (DataViewController) this.caller;
            controller1.onSearchRequest(data);
        }
        catch (ClassCastException cce) {
            // Cast to second data view controller which is yet to be implemented
        }
        catch (Exception e) {
        }
    }

    @FXML
    private void onSearch(ActionEvent event) {
        SearchData data = new SearchData(
                field1.getValue(), field2.getValue(), field3.getValue(), field4.getValue(), field5.getValue(),
                value1.getText(), value2.getText(), value3.getText(), value4.getText(), value5.getText());
        doSearch(data);
    }
    
    public void loadComboBox(String[] data) {
        field1.getItems().setAll(data);
        field2.getItems().setAll(data);
        field3.getItems().setAll(data);
        field4.getItems().setAll(data);
        field5.getItems().setAll(data);
    }
    
    public void setCaller(Object caller) {
        this.caller = caller;
    }
    
    
}
