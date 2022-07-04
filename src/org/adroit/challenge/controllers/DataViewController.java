/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Popup;
import javafx.stage.Window;
import org.adroit.challenge.models.Country;
import org.adroit.challenge.models.Date;
import org.adroit.challenge.models.Description;
import org.adroit.challenge.models.Person;
import org.adroit.challenge.models.Role;
import org.adroit.challenge.models.Sanction;
import org.adroit.challenge.models.SearchData;
import org.adroit.challenge.utils.Helper;

/**
 * FXML Controller class
 *
 * @author Ayomide Joysbright Oyediran
 */
public class DataViewController implements Initializable {

    @FXML
    private Button btnMenu;
    private Popup searchBoxPopup = new Popup();
    private Popup datapopup = new Popup();
    @FXML
    private AnchorPane searchContainer;
    @FXML
    private Button btnSearch;
    private final Helper helper = new Helper();
    @FXML
    private TableView<Person> personsTable;
    @FXML
    private TableColumn<Person, Long> personIdCol;
    @FXML
    private TableColumn<Person, String> personActionCol;
    @FXML
    private TableColumn<Person, String> personDateActionCol;
    @FXML
    private TableColumn<Person, String> personGenderCol;
    @FXML
    private TableColumn<Person, String> personActiveStatusCol;
    @FXML
    private TableColumn<Person, String> personDeceasedCol;
    @FXML
    private TableColumn<Person, String> personBirthplaceCol;
    @FXML
    private TableColumn<Person, String> personAddressLineCol;
    @FXML
    private TableColumn<Person, String> personAddressCityCol;
    @FXML
    private TableColumn<Person, String> personAddressCountryCol;
    @FXML
    private TableColumn<Person, String> personFirstNameCol;
    @FXML
    private TableColumn<Person, String> personMiddleNameCol;
    @FXML
    private TableColumn<Person, String> personSurnameCol;
    @FXML
    private TableColumn<Person, Void> personOptionsCol;
    @FXML
    private TableView<org.adroit.challenge.models.Number> numbersTable;
    @FXML
    private TableColumn<org.adroit.challenge.models.Number, Long> numberIdCol;
    @FXML
    private TableColumn<org.adroit.challenge.models.Number, String> numberDocTypeCol;
    @FXML
    private TableColumn<org.adroit.challenge.models.Number, String> numberValuesCol;
    @FXML
    private TableColumn<org.adroit.challenge.models.Number, String> numberNoteCol;
    @FXML
    private TableView<Description> descriptionTable;
    @FXML
    private TableColumn<Description, Long> descriptionIdCol;
    @FXML
    private TableColumn<Description, Long> descriptionDIdCol;
    @FXML
    private TableColumn<Description, String> descriptionDescriptionCol;
    @FXML
    private TableView<Country> countriesTable;
    @FXML
    private TableColumn<Country, Long> countryIdCol;
    @FXML
    private TableColumn<Country, String> countryTypeCol;
    @FXML
    private TableColumn<Country, String> countryCodeCol;
    @FXML
    private TableColumn<Country, String> countryNameCol;
    @FXML
    private TableColumn<Country, String> countryPmCodeCol;
    @FXML
    private TableView<Date> datesTable;
    @FXML
    private TableColumn<Date, Long> dateIdCol;
    @FXML
    private TableColumn<Date, String> dateTypeCol;
    @FXML
    private TableColumn<Date, String> dateDateCol;
    @FXML
    private TableColumn<Date, String> datePmCol;
    @FXML
    private TableView<Sanction> sanctionsTable;
    @FXML
    private TableColumn<Sanction, Long> sanctionIdCol;
    @FXML
    private TableColumn<Sanction, String> sanctionListCodeCol;
    @FXML
    private TableColumn<Sanction, String> sanctionDateStartCol;
    @FXML
    private TableColumn<Sanction, String> sanctionDateStopCol;
    @FXML
    private TableColumn<Sanction, String> sanctionNameCol;
    @FXML
    private TableColumn<Sanction, String> sanctionStatusCol;
    @FXML
    private TableView<Role> rolesTable;
    @FXML
    private TableColumn<Role, Long> rolesIdCol;
    @FXML
    private TableColumn<Role, String> rolesTypeCol;
    @FXML
    private TableColumn<Role, String> rolesStartDateCol;
    @FXML
    private TableColumn<Role, String> rolesStopDateCol;
    @FXML
    private TableColumn<Role, String> rolesTitleCol;
    @FXML
    private TableView<Person> associatesTable;
    @FXML
    private TableColumn<Person, Long> associateIdCol;
    @FXML
    private TableColumn<Person, String> associateAssocIdCol;
    @FXML
    private TableColumn<Person, String> associateExCol;
    @FXML
    private TableColumn<Person, String> associateTypeCol;
    @FXML
    private TableColumn<Person, String> associateGenderCol;
    @FXML
    private TableColumn<Person, String> associateDeceasedCol;
    @FXML
    private TableColumn<Person, String> associateFirstNameCol;
    @FXML
    private TableColumn<Person, String> associateMiddleNameCol;
    @FXML
    private TableColumn<Person, String> associateSurnameCol;
    @FXML
    private TableColumn<Person, Void> associateOptionsCol;

    private FilteredList<Person> persons;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnBack;
    @FXML
    private Button btnSave;
    @FXML
    private HBox submenus;

    private Window window;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPopup();
        initAssociateTable();
        initCountryTable();
        initDateTable();
        initDescriptionTable();
        initNumberTable();
        initPersonTable();
        initRoleTable();
        initSanctionTable();
        loadPersonsTableData();
    }

    private Window getWindow() {
        if (this.window != null) {
            return this.window;
        } else {
            this.window = btnMenu.getScene().getWindow();
            return this.window;
        }
    }

    private void initPopup() {
        try {
            searchBoxPopup.getContent().add(helper.loadSearchBox(this));
            datapopup.getContent().add(helper.loadDataPopup());
            datapopup.setAutoHide(true);
        } catch (IOException ex) {
            Logger.getLogger(DataViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onSearch(ActionEvent event) {
        if (!searchBoxPopup.isShowing()) {
            btnSearch.setGraphic(new ImageView(helper.imagePathGenerator("up.png")));
            searchBoxPopup.setAnchorY(searchContainer.getHeight());
            searchBoxPopup.setAnchorX(searchContainer.getLayoutX());
            searchBoxPopup.show(getWindow());
        } else {
            searchBoxPopup.hide();
            btnSearch.setGraphic(new ImageView(helper.imagePathGenerator("down.png")));
        }
    }

    private void initAssociateTable() {
        associateAssocIdCol.setCellValueFactory(new PropertyValueFactory<>("assocId"));
        associateDeceasedCol.setCellValueFactory(new PropertyValueFactory<>("deceased"));
        associateExCol.setCellValueFactory(new PropertyValueFactory<>("ex"));
        associateFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        associateGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        associateIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        associateMiddleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        associateSurnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));
        associateTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));

        associateOptionsCol.setCellFactory((var param) -> {
            final TableCell<Person, Void> cell = new TableCell<>() {

                private final Button btnSwitch = new Button();
                private final Button btnPictures = new Button();

                {
                    btnSwitch.setGraphic(new ImageView(new Helper().imagePathGenerator("switch.png")));
                    btnPictures.setGraphic(new ImageView(new Helper().imagePathGenerator("pictures.png")));
                    btnPictures.setOnAction(((evt) -> {
                        Helper.DATA_POPUP_CONTROLLER.loadData(getTableView().getItems().get(getIndex()).getFiles());
                        showDataPopup();
                    }));
                    btnSwitch.setOnAction((evt) -> {
                        Person rowData = getTableView().getItems().get(getIndex());
                        persons = new FilteredList<>(
                                FXCollections.observableArrayList(rowData)
                        );
                        personsTable.setItems(persons);
                        updateMinorTables(rowData);
                    });
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        HBox box = new HBox(btnSwitch, btnPictures);
                        box.setSpacing(10);
                        setGraphic(box);
                    }
                }
            };
            return cell;
        });
    }

    private void initCountryTable() {
        countryCodeCol.setCellValueFactory(new PropertyValueFactory<>("code"));
        countryIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        countryNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        countryPmCodeCol.setCellValueFactory(new PropertyValueFactory<>("pmCode"));
        countryTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void initDateTable() {
        dateDateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        dateIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        datePmCol.setCellValueFactory(new PropertyValueFactory<>("datePm"));
        dateTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void initDescriptionTable() {
        descriptionDIdCol.setCellValueFactory(new PropertyValueFactory<>("descId"));
        descriptionDescriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
    }

    private void initNumberTable() {
        numberDocTypeCol.setCellValueFactory(new PropertyValueFactory<>("docType"));
        numberIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        numberNoteCol.setCellValueFactory(new PropertyValueFactory<>("note"));
        numberValuesCol.setCellValueFactory(new PropertyValueFactory<>("value"));
    }

    private void showDataPopup() {
        if (datapopup.isShowing()) {
            datapopup.hide();
        } else {
            datapopup.setAnchorX(100);
            datapopup.setAnchorY(100);
            datapopup.show(getWindow());
        }
    }

    private void initPersonTable() {
        personActionCol.setCellValueFactory(new PropertyValueFactory<>("action"));
        personActiveStatusCol.setCellValueFactory(new PropertyValueFactory<>("activeStatus"));
        personAddressCityCol.setCellValueFactory(new PropertyValueFactory<>("addressCity"));
        personAddressCountryCol.setCellValueFactory(new PropertyValueFactory<>("addressCountry"));
        personAddressLineCol.setCellValueFactory(new PropertyValueFactory<>("addressLine"));
        personBirthplaceCol.setCellValueFactory(new PropertyValueFactory<>("birthplace"));
        personDateActionCol.setCellValueFactory(new PropertyValueFactory<>("dateAction"));
        personDeceasedCol.setCellValueFactory(new PropertyValueFactory<>("deceased"));
        personFirstNameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        personGenderCol.setCellValueFactory(new PropertyValueFactory<>("gender"));
        personIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        personMiddleNameCol.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        personSurnameCol.setCellValueFactory(new PropertyValueFactory<>("surname"));

        personOptionsCol.setCellFactory((var param) -> {
            final TableCell<Person, Void> cell = new TableCell<>() {

                private final Button btnOption = new Button();
                private final Button btnShare = new Button();

                {
                    btnOption.setGraphic(new ImageView(new Helper().imagePathGenerator("option.png")));
                    btnShare.setGraphic(new ImageView(new Helper().imagePathGenerator("share.png")));
                    btnShare.setOnAction(((evt) -> {
                        Person data = getTableView().getItems().get(getIndex());
                        Helper.DATA_POPUP_CONTROLLER.loadData(data.getFiles());
                        showDataPopup();
                    }));
                }

                @Override
                protected void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        HBox box = new HBox(btnOption, btnShare);
                        box.setSpacing(10);
                        setGraphic(box);
                    }
                }
            };
            return cell;
        });
    }

    private void initRoleTable() {
        rolesIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        rolesStartDateCol.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        rolesStopDateCol.setCellValueFactory(new PropertyValueFactory<>("stopDate"));
        rolesTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        rolesTypeCol.setCellValueFactory(new PropertyValueFactory<>("type"));
    }

    private void initSanctionTable() {
        sanctionDateStartCol.setCellValueFactory(new PropertyValueFactory<>("dateState"));
        sanctionDateStopCol.setCellValueFactory(new PropertyValueFactory<>("dateStop"));
        sanctionIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        sanctionListCodeCol.setCellValueFactory(new PropertyValueFactory<>("listCode"));
        sanctionNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        sanctionStatusCol.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadNumbersTableData(ArrayList<org.adroit.challenge.models.Number> numbers) {
        numbersTable.setItems(FXCollections.observableArrayList(numbers));
    }

    private void loadAssociatesTableData(ArrayList<Person> associates) {
        associatesTable.setItems(FXCollections.observableArrayList(associates));
    }

    private void loadCountriesTableData(ArrayList<Country> countries) {
        countriesTable.setItems(FXCollections.observableArrayList(countries));
    }

    private void loadDatesTableData(ArrayList<Date> dates) {
        datesTable.setItems(FXCollections.observableArrayList(dates));
    }

    private void loadDescriptionsTableData(ArrayList<Description> descriptions) {
        descriptionTable.setItems(FXCollections.observableArrayList(descriptions));
    }

    private void loadRolesTableData(ArrayList<Role> roles) {
        rolesTable.setItems(FXCollections.observableArrayList(roles));
    }

    private void loadSanctionsTableData(ArrayList<Sanction> sanctions) {
        sanctionsTable.setItems(FXCollections.observableArrayList(sanctions));
    }

    private void updateMinorTables(Person person) {
        loadNumbersTableData(person.getNumbers());
        loadAssociatesTableData(person.getAssociates());
        loadCountriesTableData(person.getCountries());
        loadDatesTableData(person.getDates());
        loadDescriptionsTableData(person.getDescriptions());
        loadRolesTableData(person.getRoles());
        loadSanctionsTableData(person.getSanctions());
    }

    private void loadPersonsTableData() {
        try {
            personsTable.setRowFactory(factory -> {
                TableRow<Person> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    Person person = row.getItem();
                    updateMinorTables(person);
                });
                return row;
            });
            persons = new FilteredList<>(
                    FXCollections.observableArrayList(Helper.READER_EX.FROM_JSON_CP(Helper.JSON_PATH_GENERATOR("persons"), Person[].class))
            );
            personsTable.setItems(persons);
            String[] fields = Helper.FIELDS_TO_STRING(Person.class.getDeclaredFields());
            Helper.SEARCH_BOX_CONTROLLER.loadComboBox(fields);
        } catch (IOException ex) {
            Logger.getLogger(DataViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onSearchRequest(SearchData data) {
        persons.setPredicate(person -> {
            try {
                String field1Value = Helper.JPC_HELPER.getFieldValue(person, data.getField1());
                String field2Value = Helper.JPC_HELPER.getFieldValue(person, data.getField2());
                String field3Value = Helper.JPC_HELPER.getFieldValue(person, data.getField3());
                String field4Value = Helper.JPC_HELPER.getFieldValue(person, data.getField4());
                String field5Value = Helper.JPC_HELPER.getFieldValue(person, data.getField5());
                if (field1Value.equalsIgnoreCase(data.getValue1())
                        && field2Value.equalsIgnoreCase(data.getValue2())
                        && field3Value.equalsIgnoreCase(data.getValue3())
                        && field4Value.equalsIgnoreCase(data.getValue4())
                        && field5Value.equalsIgnoreCase(data.getValue5())) {
                    return true;
                }
            } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(DataViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        });
    }

    @FXML
    private void onBack(ActionEvent event) {
        try {
            Helper.NAVIGATOR.switchScreen(btnBack, Helper.FXML_PATH_GENERATOR("Logins"), Boolean.TRUE);
        } catch (IOException ex) {
            Logger.getLogger(DataViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void onMenuClick(ActionEvent event) {
        submenus.setVisible(!submenus.isVisible());
    }
}
