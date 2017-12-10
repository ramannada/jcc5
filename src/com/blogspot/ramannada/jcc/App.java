package com.blogspot.ramannada.jcc;

import com.blogspot.ramannada.jcc.utils.MariaDB;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        MariaDB.getMariaDbPoolDataSource();
    }
}
