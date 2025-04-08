package by.losik.lab2ppois4sem.controller;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public interface IExitable {
    Runnable runnable = () -> {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit?");

        alert.setTitle("Exit");
        alert.setHeaderText("Exiting app");

        var stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image("file:src/main/resources/by/losik/lab2ppois4sem/DukeCheers.png"));

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                Platform.exit();
            }
        });
    };
}
