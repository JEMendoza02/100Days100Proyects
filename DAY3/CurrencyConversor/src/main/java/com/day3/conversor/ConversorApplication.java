package com.day3.conversor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ConversorApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //Parte del icono de la ventana
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("icon.png")));
        stage.getIcons().add(icon);
        //Obtener la vista FXML
        FXMLLoader fxmlLoader = new FXMLLoader(ConversorApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 445, 267);
        stage.setTitle("Conversor de Monedas");
        stage.setScene(scene);
        stage.show();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        // Obtener el controlador desde el cargador FXML
        ConversorController controller = fxmlLoader.getController();
        controller.initialize();

    }

    public static void main(String[] args) {
        launch();
    }
}