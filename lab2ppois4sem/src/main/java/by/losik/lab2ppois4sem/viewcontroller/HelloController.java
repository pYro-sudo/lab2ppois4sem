package by.losik.lab2ppois4sem.viewcontroller;

import by.losik.lab2ppois4sem.model.*;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class HelloController {
    int page = 0;
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
    private Button previous;
    @FXML
    private Button next;
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
                Help - acquire help.
                
                If there are any problems with input, consider entering unique values & following the prompts.
                The string input length is limited up to 20 characters.
                
                'Next' and 'Previous' buttons are needed in order to navigate through the whole tablespace.
                """);
        stackPane.setVisible(false);
        next.setVisible(false);
        previous.setVisible(false);
    }

    @FXML
    protected void onSearchButtonClick(){
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Search");
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
        stackPane.setVisible(true);
        addTile.setVisible(false);
        tilePane.setVisible(false);
        execute.setVisible(false);
        vBoxAdd.setVisible(false);
        next.setVisible(false);
        previous.setVisible(false);
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
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("min");
            input1.setPromptText("max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            search.setVisible(true);
            delete.setVisible(false);
            action.set(Action.father_salary);
            radFatherSalary.setSelected(false);
        });
        radMotherName.setOnAction(actionEvent -> {
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
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("min");
            input1.setPromptText("max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            search.setVisible(true);
            delete.setVisible(false);
            action.set(Action.mother_salary);
            radMotherSalary.setSelected(false);
        });

        search.setOnAction(actionEvent -> {
            try{
                List<Form> formList;
                switch (action.get()){
                    case stud_name -> formList = executor.getFormsByStudentName(input.getText());
                    case stud_surname -> formList = executor.getFormsByStudentSurname(input.getText());
                    case stud_father_name -> formList = executor.getFormsByStudentFatherName(input.getText());
                    case stud_num_of_brothers ->
                            formList = executor.getFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                    case stud_num_of_sisters ->
                            formList = executor.getFormsByAmountOfSisters(Integer.parseInt(input.getText()));
                    case father_name -> formList = executor.getFormsByFatherName(input.getText());
                    case father_surname -> formList = executor.getFormsByFatherSurname(input.getText());
                    case father_father_name -> formList = executor.getFormsByFatherFatherName(input.getText());
                    case father_salary -> formList = executor.getFormsByFatherSalary(
                            Float.parseFloat(input0.getText()),Float.parseFloat(input1.getText()));
                    case mother_name -> formList = executor.getFormsByMotherName(input.getText());
                    case mother_surname -> formList = executor.getFormsByMotherSurname(input.getText());
                    case mother_father_name -> formList = executor.getFormsByMotherFatherName(input.getText());
                    case mother_salary -> formList = executor.getFormsByMotherSalary(
                            Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                    default -> throw new RuntimeException();
                }

                ObservableList<Form> forms = FXCollections.observableList(formList);

                displayColumns(forms);

                textArea.setText("""
                        The search operation was successfully completed.
                        Check the result to the right.
                        """);

                vBoxToggle.setVisible(false);
                search.setVisible(false);
            }
            catch (Exception e){
                textArea.setText("""
                        Wrong input or database persistence fail.
                        Ensure the fact that selected option fields are not empty
                        and they correspond to assumed input.
                        """);
            }
        });
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
            System.out.println("[" + new Date(System.currentTimeMillis()) + "] Confirm");
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

                displayColumns(forms);

                next.setVisible(true);
                previous.setVisible(true);

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
    }
    @FXML
    protected void onDeleteButtonClick() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Delete");
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
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("min");
            input1.setPromptText("max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            action.set(Action.father_salary);
            radFatherSalary.setSelected(false);
        });
        radMotherName.setOnAction(actionEvent -> {
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
            unaryInput.setVisible(false);
            binaryInput.setVisible(true);
            input0.setPromptText("min");
            input1.setPromptText("max");
            input0.clear();
            input1.clear();
            searchOrDeleteConfirm.setVisible(true);
            delete.setVisible(true);
            action.set(Action.mother_salary);
            radMotherSalary.setSelected(false);
        });

        delete.setOnAction(actionEvent -> {
            try{
                List<Form> formList;
                switch (action.get()){
                    case stud_name -> formList = executor.deleteFormsByStudentName(input.getText());
                    case stud_surname -> formList = executor.deleteFormsByStudentSurname(input.getText());
                    case stud_father_name -> formList = executor.deleteFormsByStudentFatherName(input.getText());
                    case stud_num_of_brothers ->
                            formList = executor.deleteFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                    case stud_num_of_sisters ->
                            formList = executor.deleteFormsByAmountOfSisters(Integer.parseInt(input.getText()));
                    case father_name -> formList = executor.deleteFormsByFatherName(input.getText());
                    case father_surname -> formList = executor.deleteFormsByFatherSurname(input.getText());
                    case father_father_name -> formList = executor.deleteFormsByFatherFatherName(input.getText());
                    case father_salary -> formList = executor.deleteFormsByFatherSalary(
                            Float.parseFloat(input0.getText()),Float.parseFloat(input1.getText()));
                    case mother_name -> formList = executor.deleteFormsByMotherName(input.getText());
                    case mother_surname -> formList = executor.deleteFormsByMotherSurname(input.getText());
                    case mother_father_name -> formList = executor.deleteFormsByMotherFatherName(input.getText());
                    case mother_salary -> formList = executor.deleteFormsByMotherSalary(
                            Float.parseFloat(input0.getText()), Float.parseFloat(input1.getText()));
                    default -> throw new RuntimeException();
                }

                ObservableList<Form> forms = FXCollections.observableList(formList);
                displayColumns(forms);

                next.setVisible(true);
                previous.setVisible(true);

                textArea.setText("""
                        The delete operation was successfully completed.
                        Check the result to the right.
                        """);

                vBoxToggle.setVisible(false);
                delete.setVisible(false);
            }
            catch (Exception e){
                textArea.setText("""
                        Wrong input or persistence fail.
                        Ensure the fact that selected option fields are not empty
                        and they correspond to assumed input.
                        """);
            }
        });
    }

    @FXML
    protected void onShowAllAction() {
        try{
            System.out.println("[" + new Date(System.currentTimeMillis()) + "] Show All");
            textArea.setText("""
                        The operation of showing all rows was successfully completed.
                        Check the result to the right.
                        """);

            List<Form> formList = executor.getAllData();
            ObservableList<Form> forms = FXCollections.observableList(formList);
            displayColumns(forms);

            stackPane.setVisible(false);

            next.setVisible(true);
            previous.setVisible(true);
        }
        catch (Exception e){
            textArea.setText("""
                        Persistence fail.
                        Sorry for inconveniences.
                        """);
        }
    }

    @FXML
    protected void moveToPrevious() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Previous" + page);
        try{
            List<Form> formList = executor.getAllData();
            ObservableList<Form> forms;
            List<Form> pageForms = new ArrayList<>();
            if(page*15 > formList.size()){
                page = formList.size()/15-1;
            }
            if(page <= 0){
                return;
            }
            else{
                int i =0;
                while(page*15-i >= 0 && i < 15){
                    pageForms.add(formList.get(page*15-i));
                    ++i;
                }
                --page;
                forms = FXCollections.observableList(pageForms);
            }
            displayColumns(forms);
        }
        catch (Exception e){
            System.out.println("""
                    Persistence fail or out of bounds.
                    """);
        }
    }
    @FXML
    public void moveToNext() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Next" + page);
        try{
            List<Form> formList = executor.getAllData();
            ObservableList<Form> forms;
            List<Form> pageForms = new ArrayList<>();
            if(page*15 >= formList.size()){
                page--;
                return;
            }
            else{
                int i =0;
                while(page*15+i < formList.size() && i < 15){
                    pageForms.add(formList.get(page*15+i));
                    ++i;
                }
                page++;
                forms = FXCollections.observableList(pageForms);
            }
            displayColumns(forms);
        }
        catch (Exception e){
            System.out.println("""
                    Persistence fail or out of bounds.
                    """);
        }
    }

    private void displayColumns(ObservableList<Form> forms){
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
}