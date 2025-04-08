package by.losik.lab2ppois4sem.controller;

import by.losik.lab2ppois4sem.model.Form;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.atomic.AtomicReference;

public class OptionsController {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    private MainController mainController;
    private boolean addDisplay = true;
    @FXML private VBox vBoxAdd;
    @FXML private TextField studName;
    @FXML private TextField studSurname;
    @FXML private Button search;
    @FXML private Button delete;
    @FXML private StackPane searchOrDeleteConfirm;
    @FXML private TextField input1;
    @FXML private TextField input0;
    @FXML private TilePane binaryInput;
    @FXML private TextField input;
    @FXML private TilePane unaryInput;
    @FXML private RadioButton radMotherSalary;
    @FXML private RadioButton radFatherSalary;
    @FXML private RadioButton radNumOfSisters;
    @FXML private RadioButton radNumOfBrothers;
    @FXML private RadioButton radMotherFatherName;
    @FXML private RadioButton radMotherSurname;
    @FXML private RadioButton radStudentSurname;
    @FXML private RadioButton radStudentFatherName;
    @FXML private RadioButton radFatherName;
    @FXML private RadioButton radFatherSurname;
    @FXML private RadioButton radFatherFatherName;
    @FXML private RadioButton radMotherName;
    @FXML private RadioButton radStudentName;
    @FXML private GridPane radButtons;
    @FXML private VBox vBoxToggle;
    @FXML private TextField motherSalary;
    @FXML private TextField fatherSalary;
    @FXML private TextField amountOfSisters;
    @FXML private TextField amountOfBrothers;
    @FXML private TextField motherFatherName;
    @FXML private TextField motherSurname;
    @FXML private TextField motherName;
    @FXML private TextField fatherFatherName;
    @FXML private TextField fatherSurname;
    @FXML private TextField fatherName;
    @FXML private TextField studFatherName;
    @FXML private Button add;
    private Stage stage;
    ToggleGroup group = new ToggleGroup();
    public void onAddAction() {
        logger.info("Adding data");
        vBoxAdd.setVisible(true);
        vBoxToggle.setVisible(false);
        studName.clear();
        studSurname.clear();
        studFatherName.clear();
        fatherName.clear();
        fatherSurname.clear();
        fatherFatherName.clear();
        motherName.clear();
        motherSurname.clear();
        motherFatherName.clear();
        amountOfBrothers.clear();
        amountOfSisters.clear();
        fatherSalary.clear();
        motherSalary.clear();
        add.setOnAction(event -> {
            try{
                stage.close();
                mainController.getDisplayViewController()
                        .getDatabaseController().addForm(
                        studName.getText(),
                        studSurname.getText(),
                        studFatherName.getText(),
                        fatherName.getText(),
                        fatherSurname.getText(),
                        fatherFatherName.getText(),
                        motherName.getText(),
                        motherSurname.getText(),
                        motherFatherName.getText(),
                        Integer.parseInt(amountOfBrothers.getText()),
                        Integer.parseInt(amountOfSisters.getText()),
                        Float.parseFloat(fatherSalary.getText()),
                        Float.parseFloat(motherSalary.getText())
                );
                mainController.getTextArea().setText("""
                The form was successfully filled!
                Now click any other button to perform an operation.
                """);
            }
            catch (Exception e){
                logger.error("Persistence error occurred", e);
                mainController.getTextArea().setText("""
                Wrong input or persistence fail.
                Ensure the fact that selected option fields are not empty
                and they correspond to assumed input.
                """);
            }
        });
    }
    public void onSearchAction() {

        vBoxAdd.setVisible(false);
        vBoxToggle.setVisible(true);

        AtomicReference<Action> action = new AtomicReference<>();
        radStudentName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.stud_name);
            radStudentName.setSelected(false);
        });
        radStudentSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.stud_surname);
            radStudentSurname.setSelected(false);
        });
        radStudentFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.stud_father_name);
            radStudentFatherName.setSelected(false);
        });
        radNumOfBrothers.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Brother amount");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.stud_num_of_brothers);
            radNumOfBrothers.setSelected(false);
        });
        radNumOfSisters.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Sister amount");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.stud_num_of_sisters);
            radNumOfSisters.setSelected(false);
        });
        radFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.father_name);
            radFatherName.setSelected(false);
        });
        radFatherSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.father_surname);
            radFatherSurname.setSelected(false);
        });
        radFatherFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.father_father_name);
            radFatherFatherName.setSelected(false);
        });
        radFatherSalary.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("Min");
            input1.setPromptText("Max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.father_salary);
            radFatherSalary.setSelected(false);
        });
        radMotherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.mother_name);
            radMotherName.setSelected(false);
        });
        radMotherSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.mother_surname);
            radMotherSurname.setSelected(false);
        });
        radMotherFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.mother_father_name);
            radMotherFatherName.setSelected(false);
        });
        radMotherSalary.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("Min");
            input1.setPromptText("Max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(false);
            search.setVisible(true);
            action.set(Action.mother_salary);
            radMotherSalary.setSelected(false);
        });

        search.setOnAction(event -> {
            try{
                stage.close();
                switch (action.get()) {
                    case stud_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByStudentName(input.getText()));
                    case stud_surname -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByStudentSurname(input.getText()));
                    case stud_father_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByStudentFatherName(input.getText()));
                    case stud_num_of_brothers -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByBrotherAmount(Integer.parseInt(input.getText())));
                    case stud_num_of_sisters -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getBySisterAmount(Integer.parseInt(input.getText())));
                    case father_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByFatherName(input.getText()));
                    case father_surname -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByFatherSurname(input.getText()));
                    case father_father_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByFatherFatherName(input.getText()));
                    case father_salary -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByFatherSalary(
                                            Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText())));
                    case mother_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByMotherName(input.getText()));
                    case mother_surname -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByMotherSurname(input.getText()));
                    case mother_father_name -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByMotherFatherName(input.getText()));
                    case mother_salary -> mainController.getDisplayViewController().setFormsForSearch(
                            mainController.getDisplayViewController()
                                    .getDatabaseController().getByMotherSalary(
                                            Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText())));
                    default -> throw new RuntimeException();
                }
                mainController.getDisplayViewController().displaySearch();
                mainController.getTextArea().setText("""
                    The search operation was successfully committed!
                    Check out the result to the right.
                    """);
            }
            catch (Exception e){
                logger.error("Persistence error occurred", e);
                mainController.getTextArea().setText("""
                    Wrong input or persistence fail.
                    Ensure the fact that selected option fields are not empty
                    and they correspond to assumed input.
                    """);
            }
        });


    }
    public void onDeleteAction() {

        vBoxAdd.setVisible(false);
        vBoxToggle.setVisible(true);

        AtomicReference<Action> action = new AtomicReference<>();
        radStudentName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.stud_name);
            radStudentName.setSelected(false);
        });
        radStudentSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.stud_surname);
            radStudentSurname.setSelected(false);
        });
        radStudentFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Student father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.stud_father_name);
            radStudentFatherName.setSelected(false);
        });
        radNumOfBrothers.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Brother amount");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.stud_num_of_brothers);
            radNumOfBrothers.setSelected(false);
        });
        radNumOfSisters.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Sister amount");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.stud_num_of_sisters);
            radNumOfSisters.setSelected(false);
        });
        radFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.father_name);
            radFatherName.setSelected(false);
        });
        radFatherSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.father_surname);
            radFatherSurname.setSelected(false);
        });
        radFatherFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Father father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.father_father_name);
            radFatherFatherName.setSelected(false);
        });
        radFatherSalary.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("Min");
            input1.setPromptText("Max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.father_salary);
            radFatherSalary.setSelected(false);
        });
        radMotherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.mother_name);
            radMotherName.setSelected(false);
        });
        radMotherSurname.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother surname");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.mother_surname);
            radMotherSurname.setSelected(false);
        });
        radMotherFatherName.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            binaryInput.setVisible(false);
            unaryInput.setVisible(true);
            input.setPromptText("Mother father name");
            input.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.mother_father_name);
            radMotherFatherName.setSelected(false);
        });
        radMotherSalary.setOnAction(actionEvent -> {
            logger.info("Event source {}", actionEvent.getSource());
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("Min");
            input1.setPromptText("Max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            search.setVisible(false);
            action.set(Action.mother_salary);
            radMotherSalary.setSelected(false);
        });

        delete.setOnAction(event -> {
            try{
                stage.close();
                int deletedRows;
                switch (action.get()) {
                    case stud_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByStudentName(input.getText());
                    case stud_surname -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByStudentSurname(input.getText());
                    case stud_father_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByStudentFatherName(input.getText());
                    case stud_num_of_brothers -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByBrotherAmount(Integer.parseInt(input.getText()));
                    case stud_num_of_sisters -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteBySisterAmount(Integer.parseInt(input.getText()));
                    case father_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByFatherName(input.getText());
                    case father_surname -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByFatherSurname(input.getText());
                    case father_father_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByFatherFatherName(input.getText());
                    case father_salary -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByFatherSalary(
                                    Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                    case mother_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByMotherName(input.getText());
                    case mother_surname -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByMotherSurname(input.getText());
                    case mother_father_name -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByMotherFatherName(input.getText());
                    case mother_salary -> deletedRows = mainController.getDisplayViewController()
                            .getDatabaseController().deleteByMotherSalary(
                                    Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                    default -> throw new RuntimeException();
                }

                mainController.getTextArea().setText(String.format("""
                    The delete operation was successfully committed!
                    The amount of rows deleted: %d
                    """, deletedRows));
            }
            catch (Exception e){
                logger.error("Persistence error occurred", e);
                mainController.getTextArea().setText("""
                    Wrong input or persistence fail.
                    Ensure the fact that selected option fields are not empty
                    and they correspond to assumed input.
                    """);
            }
        });
    }

    public void initialize(){
        if(addDisplay){
            logger.info("Add option was chosen");
        }
        else{
            logger.info("Setting toggle group");
            radButtons.getChildren().forEach(x -> {
                RadioButton y = (RadioButton) x;
                y.setToggleGroup(group);
            });
        }
    }
    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    public void setAddOrDeleteSearch(boolean add){
        this.addDisplay = add;
    }
}
