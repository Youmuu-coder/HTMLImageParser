package com.youmuu;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class App extends Application {
    private static final int DEFAULT_WIDTH = 700;
    private static final int DEFAULT_HEIGHT = 480;
    private static final String RESOURCE_PATH = "./layouts/new.fxml";

    @Override
    public void start(Stage stage) {
        Parent parent = null;
        try {
            URL fxml = getClass().getClassLoader().getResource(RESOURCE_PATH);
            if (fxml != null) {
                parent = FXMLLoader.load(fxml);
                var scene = new Scene(parent, DEFAULT_WIDTH, DEFAULT_HEIGHT);
                stage.setScene(scene);
                stage.show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}