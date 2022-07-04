package org.adroit.challenge;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.adroit.challenge.utils.Helper;

/**
 *
 * @author Ayomide Joysbright Oyediran
 */
public class AdroitApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        stage.initStyle(StageStyle.UNDECORATED);
        Helper.NAVIGATOR.startApp(stage, Helper.FXML_PATH_GENERATOR("Home"), true);
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
