package by.losik.lab2ppois4sem.viewcontroller;

import by.losik.lab2ppois4sem.model.Executor;
import by.losik.lab2ppois4sem.model.Form;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;

import java.util.List;

import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

public class HelloController {
    @FXML
    private VBox vBoxAdd;
    @FXML
    private VBox vBoxToggle;
    private final ToggleGroup group = new ToggleGroup();
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
    private TilePane radButtons;
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
    Executor executor = new Executor();
    @FXML
    private TextArea textArea;
    @FXML
    private Button execute;
    @FXML
    protected void onHelpButtonClick() {
        System.out.println("[" + new Date(System.currentTimeMillis()) + "] Help");
        textArea.setText("""
                Press the button and follow the instructions to navigate.
                Options:
                Search - search forms;
                Add - add new form;
                Delete - delete some form;
                Help - acquire help.
                """);
        vBoxToggle.setVisible(false);
        searchOrDeletePane.setVisible(false);
        searchOrDeleteInput.setVisible(false);
        searchOrDeleteConfirm.setVisible(false);
        vBoxAdd.setVisible(false);
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
                    case stud_num_of_brothers -> formList = executor.getFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                    case stud_num_of_sisters -> formList = executor.getFormsByAmountOfSisters(Integer.parseInt(input.getText()));
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
                StringBuilder stringBuilder = new StringBuilder();
                formList.forEach(x -> stringBuilder.append(x.toString()).append("\n"));
                textArea.setText("The result:\n" + stringBuilder);
                vBoxToggle.setVisible(false);
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
        addTile.setVisible(true);
        tilePane.setVisible(true);
        execute.setVisible(true);
        vBoxAdd.setVisible(true);
        radButtons.setVisible(false);
        vBoxToggle.setVisible(false);
        searchOrDeleteInput.setVisible(false);
        searchOrDeletePane.setVisible(false);
        searchOrDeleteConfirm.setVisible(false);


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
                    case stud_num_of_brothers -> formList = executor.deleteFormsByAmountOfBrothers(Integer.parseInt(input.getText()));
                    case stud_num_of_sisters -> formList = executor.deleteFormsByAmountOfSisters(Integer.parseInt(input.getText()));
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
                StringBuilder stringBuilder = new StringBuilder();
                formList.forEach(x -> stringBuilder.append(x.toString()).append("\n"));
                textArea.setText("The result:\n" + stringBuilder);
                vBoxToggle.setVisible(false);
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
}