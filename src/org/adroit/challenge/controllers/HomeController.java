/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.controllers;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.adroit.challenge.utils.Helper;

/**
 * FXML Controller class
 *
 * @author Ayomide Joysbright Oyediran
 */
public class HomeController implements Initializable {

    @FXML
    private JFXButton btnPanele;
    @FXML
    private JFXButton btnLogout;
    @FXML
    private VBox cardsVBox;
    @FXML
    private HBox cardsHBox;
    @FXML
    private Label dateLabel;
    @FXML
    private Label versionLabel;
    @FXML
    private BorderPane homeContainer;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateLabel.setText(LocalDate.now().toString());
        versionLabel.setText(Helper.APP_TITLE());
    }

    @FXML
    private void onLogout(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void onShowLogins(ActionEvent event) {
        try {
            Helper.NAVIGATOR.switchScreen(btnPanele, Helper.FXML_PATH_GENERATOR("Logins"), true);
                    
                    } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
