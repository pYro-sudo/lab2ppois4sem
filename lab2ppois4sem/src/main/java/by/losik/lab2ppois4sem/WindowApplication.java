package by.losik.lab2ppois4sem;

import by.losik.lab2ppois4sem.controller.IExitable;
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

public class WindowApplication extends Application implements IExitable {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    @Override
    public void start(Stage stage) {
        try{
            logger.info("Launching at {}", System.getProperty("user.dir"));
            Parent fxmlLoader = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/by/losik/lab2ppois4sem/main-view.fxml")));
            Scene scene = new Scene(fxmlLoader, 1270, 700);
            stage.setTitle("App");
            stage.getIcons().add(new Image("file:src/main/resources/by/losik/lab2ppois4sem/DukeCheers.png"));
            stage.setScene(scene);
            stage.show();

            stage.setOnCloseRequest(windowEvent -> {
                runnable.run();
                windowEvent.consume();
                logger.info("Shutting down application event occurred");
            });
        }
        catch (NullPointerException | IOException e){
            logger.error("Configuration exception occurred", e);
        }
    }

    public static void main(String[] args) {
        launch();
    }
}