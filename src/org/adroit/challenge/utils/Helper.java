/*
 * This file is generate by Joysbright for Adroit
 */
package org.adroit.challenge.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jpc.jfx.Navigator;
import com.jpc.pure.io.ReaderEx;
import java.io.IOException;
import java.lang.reflect.Field;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import org.adroit.challenge.controllers.DataPopupController;
import org.adroit.challenge.controllers.SearchBoxController;


/**
 *
 * @author Ayomide Joysbright Oyediran
 */
public class Helper {
    
    public static final ObjectMapper MAPPER = new ObjectMapper();
    public static final Navigator NAVIGATOR = new Navigator();
    public static final ReaderEx READER_EX = new ReaderEx();
    public static final com.jpc.pure.Helper JPC_HELPER = new com.jpc.pure.Helper();
    public static SearchBoxController SEARCH_BOX_CONTROLLER = new SearchBoxController();
    public static DataPopupController DATA_POPUP_CONTROLLER = new DataPopupController();
    
    public AnchorPane loadSearchBox(Object caller) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Helper.FXML_PATH_GENERATOR("SearchBox")));
        AnchorPane pane = loader.load();
        SearchBoxController controller = loader.getController();
        controller.setCaller(caller);
        Helper.SEARCH_BOX_CONTROLLER = controller;
        return pane;
    }
    
    public AnchorPane loadDataPopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(Helper.FXML_PATH_GENERATOR("DataPopup")));
        AnchorPane pane = loader.load();
        Helper.DATA_POPUP_CONTROLLER = loader.getController();
        return pane;
    }
    
    public static String FXML_PATH_GENERATOR(String name){
        return "/org/adroit/challenge/views/"+name+".fxml";
    }
    
    public static String JSON_PATH_GENERATOR(String name){
        return "/resources/jsons/"+name+".json";
    }
    
    public String imagePathGenerator(String file){
        return getClass().getResource("/resources/images/"+file).toString();
    }
    
    public static String APP_TITLE() {
        return AppInfo.NAME.value+" "+AppInfo.VERSION.value;
    }
    
    public static String[] FIELDS_TO_STRING(Field[] fields) {
        String[] res = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            res[i] = fields[i].getName();
        }
        return res;
    }
}
