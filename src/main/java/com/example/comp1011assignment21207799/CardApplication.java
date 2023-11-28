package com.example.comp1011assignment21207799;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class CardApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CardApplication.class.getResource("card-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("YugiAPI");
        Image icon = new Image("file:src/main/java/com/example/comp1011assignment21207799/img/icon.png");
        stage.getIcons().add(icon);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}