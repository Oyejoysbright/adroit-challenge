/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import org.adroit.challenge.models.File;
import org.adroit.challenge.utils.Helper;

/**
 * FXML Controller class
 *
 * @author Ayomide Joysbright Oyediran
 */
public class DataPopupController implements Initializable {

    @FXML
    private Label titleLabel;
    @FXML
    private TableView<File> dataTable;
    @FXML
    private TableColumn<File, Long> idCol;
    @FXML
    private TableColumn<File, Hyperlink> urlCol;
    private int counter = 0;
    private ArrayList<File> files = new ArrayList<>();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTable();
    }

    private void initTable() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        Hyperlink link = new Hyperlink("test");

        urlCol.setCellFactory((var param) -> {
            final TableCell<File, Hyperlink> cell = new TableCell<>() {

                {
                    if (counter < files.size()) {
                    File data = dataTable.getItems().get(counter++);
                        System.err.println(data.getUrl());
                        link.setText(data.getUrl());
                        link.setOnAction(evt -> {
                            com.jpc.pure.Helper.OPEN_BROWSER(data.getUrl());
                        });
                    }
                }

                @Override
                protected void updateItem(Hyperlink item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(link);
                    }
                }
            };
            return cell;
        });

//        urlCol.setCellFactory(factory -> new Callback<File, Hyperlink>() {
//            public TableCell call(TableColumn column) {
//                return new TableCell() {
//                    @Override
//                    protected void updateItem(Object t, boolean bln) {
//                        super.updateItem(t, bln);
//                        System.out.println(getTableView().getItems().get(getIndex()));
//                    }
//                    
//                }
//            }
//        });
    }

    public void loadData(ArrayList<File> files) {
        dataTable.setItems(
                FXCollections.observableArrayList(files)
        );
        this.files = files;
    }

}
