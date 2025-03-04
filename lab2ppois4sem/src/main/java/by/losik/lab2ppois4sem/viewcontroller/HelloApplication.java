package by.losik.lab2ppois4sem.viewcontroller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Objects;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            System.out.println(System.getProperty("user.dir"));
            System.out.println("[" + new Date(System.currentTimeMillis()) + "] Launch");
            Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/by/losik/lab2ppois4sem/hello-view.fxml")));
            Scene scene = new Scene(fxmlLoader, 650, 700);
            stage.setTitle("App");
            stage.getIcons().add(new Image("file:src/main/resources/by/losik/lab2ppois4sem/DukeCheers.png"));
            stage.setScene(scene);
            stage.show();
        }
        catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}