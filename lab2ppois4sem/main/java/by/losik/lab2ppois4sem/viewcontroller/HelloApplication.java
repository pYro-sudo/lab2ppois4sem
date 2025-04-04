package by.losik.lab2ppois4sem.viewcontroller;

import by.losik.lab2ppois4sem.model.Form;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    @Override
    public void start(Stage stage) throws IOException {
        try{
            System.out.println(System.getProperty("user.dir"));
            logger.info("Launching");
            Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/by/losik/lab2ppois4sem/main-view.fxml")));
            Scene scene = new Scene(fxmlLoader, 1350, 700);
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
        launch();
    }
}