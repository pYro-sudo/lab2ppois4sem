package by.losik.lab2ppois4sem.controller;

import by.losik.lab2ppois4sem.model.Form;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class MainController implements IExitable {
    private final Logger logger = LoggerFactory.getLogger(Form.class);
    public MediaView mv;
    @FXML
    private DisplayController displayViewController;
    private OptionsController optionsController;
    private final XMLController xmlController = new XMLController();
    @FXML
    private ChoiceBox<String> treeOrTable;
    @FXML
    private ChoiceBox<Integer> paginationFactor;
    @FXML
    private TextArea textArea;
    public void onHelpButtonClick() {
        logger.info("Help is initiated");
        textArea.setText("""
                Press the button and follow the instructions to navigate.
                Options:
                Search - search forms in database;
                Add - add new form in database;
                Delete - delete some form from database;
                Show all - show all data in database;
                Show XML - show data stored in XML file;
                Save XML - save database data in XML format;
                Help - acquire help.

                If there are any problems with input, consider entering corresponding values & following the prompts.
                The string input length is limited up to 20 characters.

                'Next' and 'Previous' buttons are needed in order to navigate through the whole tablespace, when the 'Table'
                option is selected. Also there is an option to jump to the first page with 'First' and to the last one with 'Last'.

                Also there is a possibility to choose the 'Tree' option, that provides the information in the form of tree.

                The default view is in the form of table, database is the default data source.

                Consider that all the data, configured in XML format, is stored in 'data.xml'.
                """);
    }

    public void onAddButtonClick() {
        textArea.setText("""
                You entered the add option.
                Now it is required to fill the form.
                1 - student name;
                2 - student surname;
                3 - student father name;
                4 - father name;
                5 - father surname;
                6 - father father name;
                7 - mother name;
                8 - mother surname;
                9 - mother father name;
                10 - father salary;
                11 - mother salary;
                12 - number of brothers;
                13 - number of sisters.
                """);
        loadOptionsController();
        optionsController.setAddOrDeleteSearch(true);
        optionsController.onAddAction();
        displayViewController.resetPage();
    }

    public void onSearchButtonClick() {
        textArea.setText("""
                You entered the search option.
                Please, select the option by which
                you want to find the data.
                1 - student name;
                2 - student surname;
                3 - student father name;
                4 - father name;
                5 - father surname;
                6 - father father name;
                7 - mother name;
                8 - mother surname;
                9 - mother father name;
                10 - father salary;
                11 - mother salary;
                12 - number of brothers;
                13 - number of sisters.
                """);
        loadOptionsController();
        optionsController.setAddOrDeleteSearch(false);
        optionsController.onSearchAction();
        displayViewController.resetPage();
    }

    public void onDeleteButtonClick() {
        textArea.setText("""
                You entered the delete option.
                Please, select the option by which
                you want to delete the data.
                1 - student name;
                2 - student surname;
                3 - student father name;
                4 - father name;
                5 - father surname;
                6 - father father name;
                7 - mother name;
                8 - mother surname;
                9 - mother father name;
                10 - father salary;
                11 - mother salary;
                12 - number of brothers;
                13 - number of sisters.
                """);
        loadOptionsController();
        optionsController.setAddOrDeleteSearch(false);
        optionsController.onDeleteAction();
        displayViewController.resetPage();
    }

    public void onShowAllAction() {
        try{
            logger.info("Show all data initiation");
            textArea.setText("""
                        The operation of showing all rows was successfully completed.
                        Check the result to the right.
                        """);
            displayViewController.setXmlSource(false);
            displayViewController.showAllForms();
            displayViewController.resetPage();
        }
        catch (Exception e){
            textArea.setText("""
                        Persistence fail.
                        Sorry for inconveniences.
                        """);
            logger.error("Persistence fail.",e);
        }
    }

    public void onSaveXMLAction() {
        try{
            xmlController.saveXML();
            logger.info("Saving data in XML at data.xml at, {}", System.getProperty("user.dir"));
            textArea.setText("The forms from database were saved at " + new File("data.xml").getAbsolutePath());
        }
        catch (Exception e){
            textArea.setText("""
                        Persistence fail.
                        Sorry for inconveniences.
                        """);
            logger.error("Persistence fail.",e);
        }
    }

    public void onShowXMLAction() {
        displayViewController.setXmlSource(true);
        displayViewController.resetPage();
        displayViewController.showAllForms();
    }

    public void initialize() {
        logger.info("Initialization at {}", System.getProperty("user.dir"));

        treeOrTable.setOnAction(event -> {
            if(treeOrTable.getSelectionModel().getSelectedIndex() == 0){
                logger.debug("Table is chosen");
                displayViewController.setTree(false);
                displayViewController.getTableBox().setVisible(true);
                displayViewController.getTreeBox().setVisible(false);
            }
            else{
                logger.debug("Tree is chosen");
                displayViewController.setTree(true);
                displayViewController.getTableBox().setVisible(false);
                displayViewController.getTreeBox().setVisible(true);
            }
        });

        paginationFactor.setOnAction(event -> {
            displayViewController.setFactor(paginationFactor.getValue());
            logger.debug("Selected factor {}",paginationFactor.getValue());
        });
    }

    public void loadOptionsController(){
        try {
            FXMLLoader loader = new FXMLLoader(
                    getClass().getResource("/by/losik/lab2ppois4sem/options-view.fxml"));
            Parent root = loader.load();

            optionsController = loader.getController();

            Stage optionsStage = new Stage();
            optionsStage.setTitle("Options");
            optionsStage.getIcons().add(new Image("file:src/main/resources/by/losik/lab2ppois4sem/DukeCheers.png"));
            optionsStage.setScene(new Scene(root));
            optionsStage.show();

            optionsController.setStage(optionsStage);
            optionsController.setMainController(this);
        } catch (Exception e) {
            logger.error("Failed to load options window", e);
        }
    }
    public DisplayController getDisplayViewController() {
        return displayViewController;
    }
    public TextArea getTextArea() {
        return textArea;
    }

    public void onExitAction() {
        runnable.run();
        try {
            Media media = new Media(new File("src/main/resources/by/losik/lab2ppois4sem/moan-by-Tuna.mp3").toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setVolume(5.0);
            mv.setMediaPlayer(mediaPlayer);
            mv.getMediaPlayer().play();
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
        logger.info("Shutting down application event occurred");
    }
}
