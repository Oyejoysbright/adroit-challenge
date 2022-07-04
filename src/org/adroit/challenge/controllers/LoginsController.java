/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import org.adroit.challenge.models.LoginData;
import org.adroit.challenge.utils.Helper;

/**
 * FXML Controller class
 *
 * @author Ayomide Joysbright Oyediran
 */
public class LoginsController implements Initializable {

    @FXML
    private Label versionLabel;
    @FXML
    private Label dateLabel;
    @FXML
    private TableView<LoginData> dataTable;
    @FXML
    private TableColumn<LoginData, String> grpColumn;
    @FXML
    private TableColumn<LoginData, Long> idColumn;
    @FXML
    private TableColumn<LoginData, String> stanColumn;
    @FXML
    private TableColumn<LoginData, String> nazwaColumn;
    @FXML
    private TableColumn<LoginData, String> opisColumn;
    @FXML
    private TableColumn<LoginData, String> loginColumn;
    @FXML
    private TableColumn<LoginData, Void> actionColumn;

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
        initiateColumns();
        loadData();
    }

    private void initiateColumns() {
        grpColumn.setCellValueFactory(new PropertyValueFactory<>("grp"));
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        stanColumn.setCellValueFactory(new PropertyValueFactory<>("stan"));
        nazwaColumn.setCellValueFactory(new PropertyValueFactory<>("nazwa"));
        opisColumn.setCellValueFactory(new PropertyValueFactory<>("opis"));
        loginColumn.setCellValueFactory(new PropertyValueFactory<>("login"));

        actionColumn.setCellFactory((var param) -> {
            final TableCell<LoginData, Void> cell = new TableCell<>() {
                private final Button btn = new Button();

                {
                    btn.setGraphic(new ImageView(new Helper().imagePathGenerator("settings.png")));
                    btn.setOnAction(((evt) -> {
                        LoginData data = getTableView().getItems().get(getIndex());
                        openDataView(data.getNazwa());
                    }));
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };
            return cell;
        });
    }

    private void loadData() {
        try {
            LoginData[] data = Helper.READER_EX.FROM_JSON_CP(
                    Helper.JSON_PATH_GENERATOR("logins"),
                    LoginData[].class);
            if (data.length > 0) {
                dataTable.getItems().addAll(data);
            }
        } catch (IOException ex) {
            Logger.getLogger(
                    LoginsController.class.getName()
            ).log(Level.SEVERE, null, ex);
        }
    }

    private void openDataView(String nazwa) {
        if (nazwa.equalsIgnoreCase("person")) {
            try {
                Helper.NAVIGATOR.switchScreen(dataTable, Helper.FXML_PATH_GENERATOR("DataView"), Boolean.TRUE);
            } catch (IOException ex) {
                Logger.getLogger(LoginsController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
