package by.losik.lab2ppois4sem.viewcontroller;

import by.losik.lab2ppois4sem.model.*;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

public class HelloController {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    private int factor = 0;
    private int page = 0;
    boolean xmlSource = false;
    TableColumn<Form, Integer> form_id = new TableColumn<>("Form id");
    TableColumn<Form, String> student_name = new TableColumn<>("Student name");
    TableColumn<Form, String> student_surname = new TableColumn<>("Student surname");
    TableColumn<Form, String> student_father_name = new TableColumn<>("Student father name");
    TableColumn<Form, String> father_name = new TableColumn<>("Father name");
    TableColumn<Form, String> father_surname = new TableColumn<>("Father surname");
    TableColumn<Form, String> father_father_name = new TableColumn<>("Father father name");
    TableColumn<Form, String> mother_name = new TableColumn<>("Mother name");
    TableColumn<Form, String> mother_surname = new TableColumn<>("Mother surname");
    TableColumn<Form, String> mother_father_name = new TableColumn<>("Mother father name");
    TableColumn<Form, Float> father_salary = new TableColumn<>("Father salary");
    TableColumn<Form, Float> mother_salary = new TableColumn<>("Mother salary");
    TableColumn<Form, Integer> brothers = new TableColumn<>("Brothers");
    TableColumn<Form, Integer> sisters = new TableColumn<>("Sisters");
    ToggleGroup group = new ToggleGroup();
    Executor executor = new Executor();
    @FXML
    private TilePane navigableTile;
    @FXML
    private TextField shownPage;
    @FXML
    private ChoiceBox<Integer> factorChoice;
    @FXML
    private TableView<Form> formTableView;
    @FXML
    private VBox vBoxAdd;
    @FXML
    private VBox vBoxToggle;
    @FXML
    private StackPane stackPane;
    @FXML
    private TilePane unaryInput;
    @FXML
    private TextField input;
    @FXML
    private Button search;
    @FXML
    private TilePane addTile;
    @FXML
    private GridPane radButtons;
    @FXML
    private RadioButton radStudentName;
    @FXML
    private RadioButton radStudentSurname;
    @FXML
    private RadioButton radStudentFatherName;
    @FXML
    private RadioButton radFatherName;
    @FXML
    private RadioButton radFatherSurname;
    @FXML
    private RadioButton radFatherFatherName;
    @FXML
    private RadioButton radMotherName;
    @FXML
    private RadioButton radMotherSurname;
    @FXML
    private RadioButton radMotherFatherName;
    @FXML
    private RadioButton radNumOfBrothers;
    @FXML
    private RadioButton radNumOfSisters;
    @FXML
    private RadioButton radFatherSalary;
    @FXML
    private RadioButton radMotherSalary;
    @FXML
    private TilePane searchOrDeleteInput;
    @FXML
    private StackPane searchOrDeletePane;
    @FXML
    private TilePane binaryInput;
    @FXML
    private TextField input0;
    @FXML
    private TextField input1;
    @FXML
    private StackPane searchOrDeleteConfirm;
    @FXML
    private Button delete;
    @FXML
    private TilePane tilePane;
    @FXML
    private TextField studSurname;
    @FXML
    private TextField studFatherName;
    @FXML
    private TextField fatherName;
    @FXML
    private TextField fatherSurname;
    @FXML
    private TextField fatherFatherName;
    @FXML
    private TextField motherName;
    @FXML
    private TextField motherSurname;
    @FXML
    private TextField motherFatherName;
    @FXML
    private TextField amountOfBrothers;
    @FXML
    private TextField amountOfSisters;
    @FXML
    private TextField fatherSalary;
    @FXML
    private TextField motherSalary;
    @FXML
    private TextField studName;
    @FXML
    private TextArea textArea;
    @FXML
    private Button execute;
    @FXML
    private ChoiceBox<String> choice;
    @FXML
    private VBox tableBox;
    @FXML
    private VBox treeBox;
    @FXML
    private TreeView<String> treeView;
    @FXML
    private StackPane treeOrTable;

    Stage stage = new Stage();

    @FXML
    protected void onHelpButtonClick() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Help");
        textArea.setText("""
                Press the button and follow the instructions to navigate.
                Options:
                Search - search forms;
                Add - add new form;
                Delete - delete some form;
                Show all - show all data;
                Show XML - show data stored in XML file;
                Save XML - save database data in XML format;
                Help - acquire help.
                
                If there are any problems with input, consider entering unique values & following the prompts.
                The string input length is limited up to 20 characters.
                
                'Next' and 'Previous' buttons are needed in order to navigate through the whole tablespace, when the 'Table'
                option is selected.
                
                Also there is the possibility to choose the 'Tree' option, that provides the information in the form of tree.
                
                If you don't specify, which display mode you want, nothing will show up.
                
                Consider that all the data, configured in XML format, is stored in 'data.xml'.
                """);
        stage.close();
        treeOrTable.setVisible(false);
        page = 0;
        navigableTile.setVisible(false);
    }

    @FXML
    protected void onSearchButtonClick(){
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
        try {
            loadNewWindow();

            xmlSource = false;

            treeOrTable.setVisible(true);
            stackPane.setVisible(true);
            addTile.setVisible(false);
            tilePane.setVisible(false);
            execute.setVisible(false);
            vBoxAdd.setVisible(false);
            navigableTile.setVisible(false);
            vBoxToggle.setVisible(true);
            radButtons.setVisible(true);
            searchOrDeleteInput.setVisible(true);
            searchOrDeletePane.setVisible(true);
            unaryInput.setVisible(false);
            binaryInput.setVisible(false);
            input.clear();
            input0.clear();
            input1.clear();
            delete.setVisible(false);

            radStudentName.setToggleGroup(group);
            radStudentSurname.setToggleGroup(group);
            radStudentFatherName.setToggleGroup(group);
            radNumOfBrothers.setToggleGroup(group);
            radNumOfSisters.setToggleGroup(group);
            radFatherName.setToggleGroup(group);
            radFatherSurname.setToggleGroup(group);
            radFatherFatherName.setToggleGroup(group);
            radFatherSalary.setToggleGroup(group);
            radMotherName.setToggleGroup(group);
            radMotherSurname.setToggleGroup(group);
            radMotherFatherName.setToggleGroup(group);
            radMotherSalary.setToggleGroup(group);

            AtomicReference<Action> action = new AtomicReference<>();

            radStudentName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.stud_name);
                radStudentName.setSelected(false);
            });
            radStudentSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.stud_surname);
                radStudentSurname.setSelected(false);
            });
            radStudentFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.stud_father_name);
                radStudentFatherName.setSelected(false);
            });
            radNumOfBrothers.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Brother amount");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.stud_num_of_brothers);
                radNumOfBrothers.setSelected(false);
            });
            radNumOfSisters.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Sister amount");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.stud_num_of_sisters);
                radNumOfSisters.setSelected(false);
            });
            radFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.father_name);
                radFatherName.setSelected(false);
            });
            radFatherSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.father_surname);
                radFatherSurname.setSelected(false);
            });
            radFatherFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.father_father_name);
                radFatherFatherName.setSelected(false);
            });
            radFatherSalary.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                unaryInput.setVisible(false);
                binaryInput.setVisible(true);
                input0.setPromptText("Min");
                input1.setPromptText("Max");
                input0.clear();
                input1.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.father_salary);
                radFatherSalary.setSelected(false);
            });
            radMotherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.mother_name);
                radMotherName.setSelected(false);
            });
            radMotherSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.mother_surname);
                radMotherSurname.setSelected(false);
            });
            radMotherFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.mother_father_name);
                radMotherFatherName.setSelected(false);
            });
            radMotherSalary.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                unaryInput.setVisible(false);
                binaryInput.setVisible(true);
                input0.setPromptText("Min");
                input1.setPromptText("Max");
                input0.clear();
                input1.clear();
                searchOrDeleteConfirm.setVisible(true);
                search.setVisible(true);
                delete.setVisible(false);
                action.set(Action.mother_salary);
                radMotherSalary.setSelected(false);
            });

            search.setOnAction(actionEvent -> {
                stage.close();
                System.out.println(actionEvent.getSource());
                try {
                    logger.info("Performing search by = {}", action.get());
                    List<Form> formList;
                    switch (action.get()) {
                        case stud_name -> formList = executor.getFormsByStudentName(input.getText());
                        case stud_surname -> formList = executor.getFormsByStudentSurname(input.getText());
                        case stud_father_name -> formList = executor.getFormsByStudentFatherName(input.getText());
                        case stud_num_of_brothers -> formList = executor.getFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                        case stud_num_of_sisters -> formList = executor.getFormsByAmountOfSisters(Integer.parseInt(input.getText()));
                        case father_name -> formList = executor.getFormsByFatherName(input.getText());
                        case father_surname -> formList = executor.getFormsByFatherSurname(input.getText());
                        case father_father_name -> formList = executor.getFormsByFatherFatherName(input.getText());
                        case father_salary -> formList = executor.getFormsByFatherSalary(
                                Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                        case mother_name -> formList = executor.getFormsByMotherName(input.getText());
                        case mother_surname -> formList = executor.getFormsByMotherSurname(input.getText());
                        case mother_father_name -> formList = executor.getFormsByMotherFatherName(input.getText());
                        case mother_salary -> formList = executor.getFormsByMotherSalary(
                                Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                        default -> throw new RuntimeException();
                    }

                    ObservableList<Form> forms = FXCollections.observableList(formList);

                    if (tableBox.isVisible()) {
                        displayColumns(forms);
                    }
                    if (treeBox.isVisible()) {
                        displayTree(forms);
                    }

                    textArea.setText("""
                            The search operation was successfully completed.
                            Check the result to the right.
                            """);

                    vBoxToggle.setVisible(false);
                    search.setVisible(false);
                } catch (Exception e) {
                    textArea.setText("""
                            Wrong input or database persistence fail.
                            Ensure the fact that selected option fields are not empty
                            and they correspond to assumed input.
                            """);
                }
            });
        } catch (Exception e){
            textArea.setText("""
                    Loading options fail.
                    """);
            e.printStackTrace();
        }
    }

    @FXML
    protected void onAddButtonClick(){
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Add");
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
        try {
            loadNewWindow();

            xmlSource = false;
            treeOrTable.setVisible(true);
            stackPane.setVisible(true);
            tilePane.setVisible(true);
            execute.setVisible(true);
            vBoxAdd.setVisible(true);
            radButtons.setVisible(false);
            vBoxToggle.setVisible(false);
            addTile.setVisible(true);
            searchOrDeleteInput.setVisible(false);
            searchOrDeletePane.setVisible(false);
            searchOrDeleteConfirm.setVisible(false);

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

            execute.setOnAction(actionEvent -> {
                logger.info("Adding data");
                stage.close();
                System.out.println(actionEvent.getSource());
                try{
                    executor.setForm(
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
                    textArea.setText("""
                        The form was successfully filled!
                        Now click any other button to perform an operation.
                        """);

                    List<Form> formList = executor.getAllData();
                    ObservableList<Form> forms = FXCollections.observableList(formList);

                    if(tableBox.isVisible()){
                        displayColumns(forms);
                    }
                    if(treeBox.isVisible()){
                        displayTree(forms);
                    }

                    navigableTile.setVisible(true);

                    stackPane.setVisible(false);
                    addTile.setVisible(false);
                    tilePane.setVisible(false);
                    execute.setVisible(false);
                }
                catch (Exception e){
                    textArea.setText("""
                    Wrong input or persistence fail.
                    Ensure the fact that all fields are not empty
                    and they correspond to assumed input.
                    """);
                }
            });
        } catch (Exception e) {
            textArea.setText("""
                    Loading options fail.
                    """);
            e.printStackTrace();
        }
    }
    @FXML
    protected void onDeleteButtonClick() {
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
        try {
            loadNewWindow();

            xmlSource = false;
            treeOrTable.setVisible(true);
            stackPane.setVisible(true);
            addTile.setVisible(false);
            tilePane.setVisible(false);
            execute.setVisible(false);
            vBoxAdd.setVisible(false);
            vBoxToggle.setVisible(true);
            radButtons.setVisible(true);
            searchOrDeleteInput.setVisible(true);
            searchOrDeletePane.setVisible(true);
            unaryInput.setVisible(false);
            binaryInput.setVisible(false);
            input.clear();
            input0.clear();
            input1.clear();
            search.setVisible(false);

            radStudentName.setToggleGroup(group);
            radStudentSurname.setToggleGroup(group);
            radStudentFatherName.setToggleGroup(group);
            radNumOfBrothers.setToggleGroup(group);
            radNumOfSisters.setToggleGroup(group);
            radFatherName.setToggleGroup(group);
            radFatherSurname.setToggleGroup(group);
            radFatherFatherName.setToggleGroup(group);
            radFatherSalary.setToggleGroup(group);
            radMotherName.setToggleGroup(group);
            radMotherSurname.setToggleGroup(group);
            radMotherFatherName.setToggleGroup(group);
            radMotherSalary.setToggleGroup(group);

            AtomicReference<Action> action = new AtomicReference<>();

            radStudentName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.stud_name);
                radStudentName.setSelected(false);
            });
            radStudentSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.stud_surname);
                radStudentSurname.setSelected(false);
            });
            radStudentFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Student father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.stud_father_name);
                radStudentFatherName.setSelected(false);
            });
            radNumOfBrothers.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Brother amount");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.stud_num_of_brothers);
                radNumOfBrothers.setSelected(false);
            });
            radNumOfSisters.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Sister amount");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.stud_num_of_sisters);
                radNumOfSisters.setSelected(false);
            });
            radFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.father_name);
                radFatherName.setSelected(false);
            });
            radFatherSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.father_surname);
                radFatherSurname.setSelected(false);
            });
            radFatherFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Father father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.father_father_name);
                radFatherFatherName.setSelected(false);
            });
            radFatherSalary.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                unaryInput.setVisible(false);
                binaryInput.setVisible(true);
                input0.setPromptText("Min");
                input1.setPromptText("Max");
                input0.clear();
                input1.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.father_salary);
                radFatherSalary.setSelected(false);
            });
            radMotherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.mother_name);
                radMotherName.setSelected(false);
            });
            radMotherSurname.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother surname");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.mother_surname);
                radMotherSurname.setSelected(false);
            });
            radMotherFatherName.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                binaryInput.setVisible(false);
                unaryInput.setVisible(true);
                input.setPromptText("Mother father name");
                input.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.mother_father_name);
                radMotherFatherName.setSelected(false);
            });
            radMotherSalary.setOnAction(actionEvent -> {
                System.out.println(actionEvent.getSource());
                unaryInput.setVisible(false);
                binaryInput.setVisible(true);
                input0.setPromptText("Min");
                input1.setPromptText("Max");
                input0.clear();
                input1.clear();
                searchOrDeleteConfirm.setVisible(true);
                delete.setVisible(true);
                action.set(Action.mother_salary);
                radMotherSalary.setSelected(false);
            });

            delete.setOnAction(actionEvent -> {
                logger.info("Performing delete by = {}", action.get());
                stage.close();
                System.out.println(actionEvent.getSource());
                try{
                    int count;
                    switch (action.get()){
                        case stud_name -> count = executor.deleteFormsByStudentName(input.getText());
                        case stud_surname -> count = executor.deleteFormsByStudentSurname(input.getText());
                        case stud_father_name -> count = executor.deleteFormsByStudentFatherName(input.getText());
                        case stud_num_of_brothers ->
                                count = executor.deleteFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                        case stud_num_of_sisters ->
                                count = executor.deleteFormsByAmountOfSisters(Integer.parseInt(input.getText()));
                        case father_name -> count = executor.deleteFormsByFatherName(input.getText());
                        case father_surname -> count = executor.deleteFormsByFatherSurname(input.getText());
                        case father_father_name -> count = executor.deleteFormsByFatherFatherName(input.getText());
                        case father_salary -> count = executor.deleteFormsByFatherSalary(
                                Float.parseFloat(input0.getText()),Float.parseFloat(input1.getText()));
                        case mother_name -> count = executor.deleteFormsByMotherName(input.getText());
                        case mother_surname -> count = executor.deleteFormsByMotherSurname(input.getText());
                        case mother_father_name -> count = executor.deleteFormsByMotherFatherName(input.getText());
                        case mother_salary -> count = executor.deleteFormsByMotherSalary(
                                Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                        default -> throw new RuntimeException();
                    }

                    textArea.setText(String.format("""
                        The delete operation was successfully completed.
                        Check the result to the right.
                        The amount of rows deleted is: %d.
                        """, count));

                    vBoxToggle.setVisible(false);
                    delete.setVisible(false);
                }
                catch (Exception e){
                    textArea.setText("""
                        Wrong input or persistence fail.
                        Ensure the fact that selected option fields are not empty
                        and they correspond to assumed input.
                        """);
                    e.printStackTrace();
                }
            });
        } catch (Exception e){
            textArea.setText("""
                    Loading options fail.
                    """);
            e.printStackTrace();
        }
    }

    private void loadNewWindow() {
        try{
            System.out.println(System.getProperty("user.dir"));
            logger.info("Loading auxiliary window");
            FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("/by/losik/lab2ppois4sem/options-view.fxml")));

            fxmlLoader.setController(this);
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
            stage.setTitle("Options");
            stage.getIcons().add(new Image("file:src/main/resources/by/losik/lab2ppois4sem/DukeCheers.png"));
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            logger.error("Load failed");
            e.printStackTrace();
        }
    }

    @FXML
    protected List<Form> onShowAllAction() {
        try{
            logger.info("Show all data");
            textArea.setText("""
                        The operation of showing all rows was successfully completed.
                        Check the result to the right.
                        """);
            treeOrTable.setVisible(true);

            List<Form> formList = executor.getAllData();
            ObservableList<Form> forms = FXCollections.observableList(formList);
            if(tableBox.isVisible()){
                displayColumns(forms);
            }
            if(treeBox.isVisible()){
                displayTree(forms);
            }
            xmlSource = false;

            stage.close();
            page = 0;

            navigableTile.setVisible(true);

            return forms;
        }
        catch (Exception e){
            textArea.setText("""
                        Persistence fail.
                        Sorry for inconveniences.
                        """);
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @FXML
    protected void moveToPrevious() {
        logger.info("Moved to previous = {}", page);
        try {
            List<Form> formList = getCurrentDataList();
            if (formList.isEmpty() || page <= 0) {
                return;
            }

            page--;
            updateDisplayedForms(formList);
        } catch (Exception e) {
            logger.error("Moved to previous error at page = {}", page);
            e.printStackTrace();
        }
    }

    @FXML
    public void moveToNext() {
        logger.info("Moved to next = {}", page);
        try {
            List<Form> formList = getCurrentDataList();
            int totalPages = (int) Math.ceil((double) formList.size() / factor);

            if (page >= totalPages - 1) {
                return;
            }

            page++;
            updateDisplayedForms(formList);
        } catch (Exception e) {
            logger.error("Moved to next error at page = {}", page);
            e.printStackTrace();
        }
    }

    @FXML
    public void jumpToFirst() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Jump to first");
        try {
            List<Form> formList = getCurrentDataList();
            page = 0;
            updateDisplayedForms(formList);
        } catch (Exception e) {
            System.out.println("Persistence fail or out of bounds.");
            e.printStackTrace();
        }
    }

    @FXML
    public void jumpToLast() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Jump to last");
        try {
            List<Form> formList = getCurrentDataList();
            int totalPages = (int) Math.ceil((double) formList.size() / factor);
            page = Math.max(0, totalPages - 1);
            updateDisplayedForms(formList);
        } catch (Exception e) {
            System.out.println("Persistence fail or out of bounds.");
            e.printStackTrace();
        }
    }

    private List<Form> getCurrentDataList() throws Exception {
        logger.info("Extracting from XML = {}", xmlSource);
        if (xmlSource) {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();
            saxParser.parse(new File("data.xml"), handler);
            return handler.getForms();
        } else {
            return executor.getAllData();
        }
    }

    private void updateDisplayedForms(List<Form> formList) {
        logger.info("Updating table form");
        int startIndex = page * factor;
        int endIndex = Math.min(startIndex + factor, formList.size());

        List<Form> pageForms = formList.subList(startIndex, endIndex);
        ObservableList<Form> forms = FXCollections.observableList(pageForms);

        shownPage.setText(String.valueOf(page + 1));
        displayColumns(forms);
    }

    private void displayTree(ObservableList<Form> forms){
        logger.info("Tree display");

        TreeItem<String> rootItem = new TreeItem<>("Forms");

        forms.forEach(x -> {
            TreeItem<String> leaf = new TreeItem<>("Form id: " + x.getId());

            TreeItem<String> studentLeaf = new TreeItem<>("Student");
            studentLeaf.getChildren().add(new TreeItem<>("Name: " + x.getStudent().getStudentName()));
            studentLeaf.getChildren().add(new TreeItem<>("Surname: " + x.getStudent().getStudentSurname()));
            studentLeaf.getChildren().add(new TreeItem<>("Father name: " + x.getStudent().getStudentFatherName()));
            studentLeaf.getChildren().add(new TreeItem<>("Brothers: " + x.getStudent().getNumOfBrothers()));
            studentLeaf.getChildren().add(new TreeItem<>("Sisters: " + x.getStudent().getNumOfSisters()));
            leaf.getChildren().add(studentLeaf);

            TreeItem<String> fatherLeaf = new TreeItem<>("Father");
            fatherLeaf.getChildren().add(new TreeItem<>("Name: " + x.getFather().getFatherName()));
            fatherLeaf.getChildren().add(new TreeItem<>("Surname: " + x.getFather().getFatherSurname()));
            fatherLeaf.getChildren().add(new TreeItem<>("Father name: " + x.getFather().getFatherFatherName()));
            fatherLeaf.getChildren().add(new TreeItem<>("Salary: " + x.getFather().getSalary()));
            leaf.getChildren().add(fatherLeaf);

            TreeItem<String> motherLeaf = new TreeItem<>("Mother");
            motherLeaf.getChildren().add(new TreeItem<>("Name: " + x.getMother().getMotherName()));
            motherLeaf.getChildren().add(new TreeItem<>("Surname: " + x.getMother().getMotherSurname()));
            motherLeaf.getChildren().add(new TreeItem<>("Father name: " + x.getMother().getMotherFatherName()));
            motherLeaf.getChildren().add(new TreeItem<>("Salary: " + x.getFather().getSalary()));
            leaf.getChildren().add(motherLeaf);

            rootItem.getChildren().add(leaf);
        });

        treeView.setRoot(rootItem);
    }
    private void displayColumns(ObservableList<Form> forms){
        logger.info("Columns of table display");

        formTableView.setItems(forms);

        form_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        student_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getStudent().getStudentName()));
        student_surname.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getStudent().getStudentSurname()));
        student_father_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getStudent().getStudentFatherName()));
        father_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getFather().getFatherName()));
        father_surname.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getFather().getFatherSurname()));
        father_father_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getFather().getFatherFatherName()));
        mother_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getMother().getMotherName()));
        mother_surname.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getMother().getMotherSurname()));
        mother_father_name.setCellValueFactory(x ->
                new SimpleStringProperty(x.getValue().getMother().getMotherFatherName()));
        father_salary.setCellValueFactory(x ->
                new SimpleFloatProperty(x.getValue().getFather().getSalary()).asObject());
        mother_salary.setCellValueFactory(x ->
                new SimpleFloatProperty(x.getValue().getMother().getSalary()).asObject());
        brothers.setCellValueFactory(x ->
                new SimpleIntegerProperty(x.getValue().getStudent().getNumOfBrothers()).asObject());
        sisters.setCellValueFactory(x ->
                new SimpleIntegerProperty(x.getValue().getStudent().getNumOfSisters()).asObject());

        formTableView.getColumns().clear();
        formTableView.getColumns().add(form_id);
        formTableView.getColumns().add(student_name);
        formTableView.getColumns().add(student_surname);
        formTableView.getColumns().add(student_father_name);
        formTableView.getColumns().add(father_name);
        formTableView.getColumns().add(father_surname);
        formTableView.getColumns().add(father_father_name);
        formTableView.getColumns().add(mother_name);
        formTableView.getColumns().add(mother_surname);
        formTableView.getColumns().add(mother_father_name);
        formTableView.getColumns().add(father_salary);
        formTableView.getColumns().add(mother_salary);
        formTableView.getColumns().add(brothers);
        formTableView.getColumns().add(sisters);
    }

    @FXML
    public void initialize() {
        try{
            ObservableList<String> variants = FXCollections.observableArrayList("Table", "Tree");
            choice.setItems(variants);

            choice.setOnShowing(event -> System.out.println("[" + new Date(System.currentTimeMillis()) + "] Choice display"));

            choice.setOnAction(event -> {
                if (choice.getSelectionModel().isSelected(0)) {
                    tableBox.setVisible(true);
                    treeBox.setVisible(false);
                } else if (choice.getSelectionModel().isSelected(1)) {
                    tableBox.setVisible(false);
                    treeBox.setVisible(true);
                }
            });

            ObservableList<Integer> factorVariants = FXCollections.observableArrayList(5, 10, 15, 20);
            factorChoice.setItems(factorVariants);

            factorChoice.setOnShowing(event -> System.out.println("[" + new Date(System.currentTimeMillis()) + "] Factor choice display"));

            factorChoice.setOnAction(event ->{
                factor = (factorChoice.getSelectionModel().getSelectedIndex()+1)*5;
                System.out.println("Factor: " + factor);
            });
        }
        catch (Exception e){
            System.out.println("Options loaded");
        }
    }

    public void onSaveXMLAction() {
        xmlSource = true;
        stage.close();

        try{
            logger.info("Saving in XML at = {}", new File("data.xml").getAbsolutePath());
            List<Form> savedData = executor.getAllData();

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            Document doc = docBuilder.newDocument();

            Element rootElement = doc.createElement("forms");
            rootElement.setAttribute("data", String.valueOf(new Date(System.currentTimeMillis())));
            doc.appendChild(rootElement);

            savedData.forEach(x -> {
                Element formElement = doc.createElement("form");
                rootElement.appendChild(formElement);

                Element idElement = doc.createElement("form-id");
                idElement.setAttribute("value", String.valueOf(x.getId()));
                formElement.appendChild(idElement);

                Element studentElement = doc.createElement("student");
                formElement.appendChild(studentElement);

                addElement(doc, studentElement, "student-id", String.valueOf(x.getStudent().getId()));
                addElement(doc, studentElement, "student-name", x.getStudent().getStudentName());
                addElement(doc, studentElement, "student-surname", x.getStudent().getStudentSurname());
                addElement(doc, studentElement, "student-father-name", x.getStudent().getStudentFatherName());
                addElement(doc, studentElement, "student-number-of-brothers", String.valueOf(x.getStudent().getNumOfBrothers()));
                addElement(doc, studentElement, "student-number-of-sisters", String.valueOf(x.getStudent().getNumOfSisters()));

                Element motherElement = doc.createElement("mother");
                formElement.appendChild(motherElement);

                addElement(doc, motherElement, "mother-id", String.valueOf(x.getMother().getId()));
                addElement(doc, motherElement, "mother-name", x.getMother().getMotherName());
                addElement(doc, motherElement, "mother-surname", x.getMother().getMotherSurname());
                addElement(doc, motherElement, "mother-father-name", x.getMother().getMotherFatherName());
                addElement(doc, motherElement, "mother-salary", String.valueOf(x.getMother().getSalary()));

                Element fatherElement = doc.createElement("father");
                formElement.appendChild(fatherElement);

                addElement(doc, fatherElement, "father-id", String.valueOf(x.getFather().getId()));
                addElement(doc, fatherElement, "father-name", x.getFather().getFatherName());
                addElement(doc, fatherElement, "father-surname", x.getFather().getFatherSurname());
                addElement(doc, fatherElement, "father-father-name", x.getFather().getFatherFatherName());
                addElement(doc, fatherElement, "father-salary", String.valueOf(x.getFather().getSalary()));
            });

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);

            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{https://xml.apache.org/xslt}indent-amount", "4");

            StreamResult result = new StreamResult(new File("data.xml"));
            transformer.transform(source, result);

            textArea.setText("All the data was saved in XML at: " + new File("data.xml").getAbsolutePath());
        }
        catch (Exception e){
            textArea.setText("The data was not saved in XML at: " + new File("data.xml").getAbsolutePath());
        }
    }

    private void addElement(Document document, Element parent, String tagName, String value) {
        Element element = document.createElement(tagName);
        element.setAttribute("value", value);
        parent.appendChild(element);
    }

    public List<Form> onShowXMLAction() {

        xmlSource = true;
        stage.close();

        try{
            logger.info("Showing from XML at = {}", new File("data.xml").getAbsolutePath());
            treeOrTable.setVisible(true);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            XMLHandler handler = new XMLHandler();

            File xmlFile = new File("data.xml");
            saxParser.parse(xmlFile, handler);

            ObservableList<Form> forms = FXCollections.observableArrayList(handler.getForms());
            if(tableBox.isVisible()){
                displayColumns(forms);
            }
            if(treeBox.isVisible()){
                displayTree(forms);
            }
            navigableTile.setVisible(true);
            textArea.setText("All the data was loaded from XML at: " + new File("data.xml").getAbsolutePath());

            return forms;
        }
        catch (Exception e){
            textArea.setText("The data was not found or there is parsing error.");
            return new ArrayList<>();
        }
    }

    private static class XMLHandler extends DefaultHandler {
        private final List<Form> forms = new ArrayList<>();
        private Form currentForm = null;
        private Student currentStudent = null;
        private Mother currentMother = null;
        private Father currentFather = null;
        private StringBuilder data = null;
        private String currentElement = null;

        public List<Form> getForms() {
            return forms;
        }

        @Override
        public void startElement(String uri, String localName, String currentName, Attributes attributes) {
            data = new StringBuilder();
            currentElement = currentName;

            switch (currentName) {
                case "form" -> currentForm = new Form();
                case "student" -> currentStudent = new Student();
                case "mother" -> currentMother = new Mother();
                case "father" -> currentFather = new Father();
            }

            if (currentForm != null && "form-id".equals(currentName)) {
                currentForm.setId(Integer.parseInt(attributes.getValue("value")));
            } else if (currentStudent != null) {
                switch (currentName) {
                    case "student-id" -> currentStudent.setId(Integer.parseInt(attributes.getValue("value")));
                    case "student-name" -> currentStudent.setStudentName(attributes.getValue("value"));
                    case "student-surname" -> currentStudent.setStudentSurname(attributes.getValue("value"));
                    case "student-father-name" -> currentStudent.setStudentFatherName(attributes.getValue("value"));
                    case "student-number-of-brothers" ->
                            currentStudent.setNumOfBrothers(Integer.parseInt(attributes.getValue("value")));
                    case "student-number-of-sisters" ->
                            currentStudent.setNumOfSisters(Integer.parseInt(attributes.getValue("value")));
                }
            } else if (currentMother != null) {
                switch (currentName) {
                    case "mother-id" -> currentMother.setId(Integer.parseInt(attributes.getValue("value")));
                    case "mother-name" -> currentMother.setMotherName(attributes.getValue("value"));
                    case "mother-surname" -> currentMother.setMotherSurname(attributes.getValue("value"));
                    case "mother-father-name" -> currentMother.setMotherFatherName(attributes.getValue("value"));
                    case "mother-salary" -> currentMother.setSalary(Float.parseFloat(attributes.getValue("value")));
                }
            } else if (currentFather != null) {
                switch (currentName) {
                    case "father-id" -> currentFather.setId(Integer.parseInt(attributes.getValue("value")));
                    case "father-name" -> currentFather.setFatherName(attributes.getValue("value"));
                    case "father-surname" -> currentFather.setFatherSurname(attributes.getValue("value"));
                    case "father-father-name" -> currentFather.setFatherFatherName(attributes.getValue("value"));
                    case "father-salary" -> currentFather.setSalary(Float.parseFloat(attributes.getValue("value")));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String currentName) {
            switch (currentName) {
                case "form" -> {
                    if (currentForm != null) {
                        forms.add(currentForm);
                        currentForm = null;
                    }
                }
                case "student" -> {
                    if (currentForm != null && currentStudent != null) {
                        currentForm.setStudent(currentStudent);
                        currentStudent = null;
                    }
                }
                case "mother" -> {
                    if (currentForm != null && currentMother != null) {
                        currentForm.setMother(currentMother);
                        currentMother = null;
                    }
                }
                case "father" -> {
                    if (currentForm != null && currentFather != null) {
                        currentForm.setFather(currentFather);
                        currentFather = null;
                    }
                }
            }
        }

        @Override
        public void characters(char[] chars, int start, int length) {
            if (currentElement != null) {
                data.append(new String(chars, start, length).trim());
            }
        }
    }
}