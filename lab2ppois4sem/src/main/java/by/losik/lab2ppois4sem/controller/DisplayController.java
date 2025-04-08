package by.losik.lab2ppois4sem.controller;

import by.losik.lab2ppois4sem.model.Form;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


public class DisplayController {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    private final XMLController xmlController = new XMLController();
    private final DatabaseController databaseController = new DatabaseController();
    private int page = 0;
    private int factor = 0;
    private boolean xmlSource = false;
    private boolean tree = false;
    @FXML
    private TextField shownPage;
    @FXML
    private VBox tableBox;
    @FXML
    private VBox treeBox;
    @FXML
    private TableColumn<Form, Integer> form_id;
    @FXML
    private TableColumn<Form, String> student_name;
    @FXML
    private TableColumn<Form, String> student_surname;
    @FXML
    private TableColumn<Form, String> student_father_name;
    @FXML
    private TableColumn<Form, String> father_name;
    @FXML
    private TableColumn<Form, String> father_surname;
    @FXML
    private TableColumn<Form, String> father_father_name;
    @FXML
    private TableColumn<Form, String> mother_name;
    @FXML
    private TableColumn<Form, String> mother_surname;
    @FXML
    private TableColumn<Form, String> mother_father_name;
    @FXML
    private TableColumn<Form, Float> father_salary;
    @FXML
    private TableColumn<Form, Float> mother_salary;
    @FXML
    private TableColumn<Form, Integer> brothers;
    @FXML
    private TableColumn<Form, Integer> sisters;
    @FXML
    private TableView<Form> formTableView;
    @FXML
    private TreeView<String> treeView;
    private List<Form> formsForSearch;
    public void displayColumns(ObservableList<Form> forms){
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
    }

    public void displayTree(ObservableList<Form> forms){
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

    public VBox getTableBox() {
        return tableBox;
    }

    public VBox getTreeBox() {
        return treeBox;
    }
    public void moveToPrevious() {
        logger.info("Moved to previous = {}", page);
        try {
            if(factor == 0) resetPage();
            List<Form> formList = formsForSearch == null ? getCurrentDataList() : formsForSearch;
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

    public void moveToNext() {
        logger.info("Moved to next = {}", page);
        try {
            if(factor == 0) resetPage();
            List<Form> formList = formsForSearch == null ? getCurrentDataList() : formsForSearch;
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

    public void jumpToFirst() {
        logger.info("Jump to first");
        try {
            if(factor == 0) resetPage();
            List<Form> formList = formsForSearch == null ? getCurrentDataList() : formsForSearch;
            page = 0;
            updateDisplayedForms(formList);
        } catch (Exception e) {
            System.out.println("Persistence fail or out of bounds.");
            e.printStackTrace();
        }
    }

    public void jumpToLast() {
        logger.info("Jump to last");
        try {
            if(factor == 0) resetPage();
            List<Form> formList = formsForSearch == null ? getCurrentDataList() : formsForSearch;
            int totalPages = (int) Math.ceil((double) formList.size() / factor);
            page = Math.max(0, totalPages - 1);
            updateDisplayedForms(formList);
        } catch (Exception e) {
            System.out.println("Persistence fail or out of bounds.");
            e.printStackTrace();
        }
    }

    public List<Form> getCurrentDataList() {
        logger.info("Extracting from XML = {}", xmlSource);
        formsForSearch = xmlSource ? xmlController.showXML() : databaseController.getAllForms();
        return formsForSearch;
    }

    public void updateDisplayedForms(List<Form> formList) {
        logger.info("Updating table form");
        int startIndex = page * factor;
        int endIndex = Math.min(startIndex + factor, formList.size());

        List<Form> pageForms = formList.subList(startIndex, endIndex);
        ObservableList<Form> forms = FXCollections.observableList(pageForms);

        shownPage.setText(String.valueOf(page + 1));
        if (tree) {
            displayTree(forms);
        } else {
            displayColumns(forms);
        }
    }

    public void showAllForms(){
        logger.info("Showing all forms");
        resetPage();
        formsForSearch = getCurrentDataList();
        if (tree) {
            displayTree(FXCollections.observableList(formsForSearch));
        } else {
            displayColumns(FXCollections.observableList(formsForSearch));
        }
    }

    public void resetPage(){
        page = -1;
        shownPage.setText(String.valueOf(0));
    }

    public void displaySearch(){
        displayColumns(FXCollections.observableList(formsForSearch));
    }

    public void setXmlSource(boolean xmlSource){
        this.xmlSource = xmlSource;
    }

    public void setFactor(int factor) {
        this.factor = factor;
    }

    public void setTree(boolean tree) {
        this.tree = tree;
    }

    public DatabaseController getDatabaseController() {
        return databaseController;
    }

    public void setFormsForSearch(List<Form> formsForSearch) {
        this.formsForSearch = formsForSearch;
    }
}
