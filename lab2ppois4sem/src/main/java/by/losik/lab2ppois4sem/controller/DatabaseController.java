package by.losik.lab2ppois4sem.controller;

import by.losik.lab2ppois4sem.model.Form;
import by.losik.lab2ppois4sem.service.FormService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DatabaseController {
    private static final Logger logger = LoggerFactory.getLogger(Form.class);
    private static final FormService formService = new FormService();
    public ObservableList<Form> getAllForms() {
        try{
            logger.info("Showing all data");
            return FXCollections.observableList(formService.findAll());
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByStudentName(String name){
        try{
            logger.info("Finding by student info");
            return FXCollections.observableList(formService.findByStudentName(name));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByStudentSurname(String surname){
        try{
            logger.info("Finding by student info");
            return FXCollections.observableList(formService.findByStudentSurname(surname));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByStudentFatherName(String fatherName){
        try{
            logger.info("Finding by student info");
            return FXCollections.observableList(formService.findByStudentFatherName(fatherName));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByMotherName(String name){
        try{
            logger.info("Finding by mother info");
            return FXCollections.observableList(formService.findByMotherName(name));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByMotherSurname(String surname){
        try{
            logger.info("Finding by mother info");
            return FXCollections.observableList(formService.findByMotherSurname(surname));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByMotherFatherName(String fatherName){
        try{
            logger.info("Finding by mother info");
            return FXCollections.observableList(formService.findByStudentName(fatherName));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByFatherName(String name){
        try{
            logger.info("Finding by father info");
            return FXCollections.observableList(formService.findByFatherName(name));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByFatherSurname(String surname){
        try{
            logger.info("Finding by father info");
            return FXCollections.observableList(formService.findByFatherSurname(surname));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByFatherFatherName(String fatherName){
        try{
            logger.info("Finding by father info");
            return FXCollections.observableList(formService.findByFatherFatherName(fatherName));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByMotherSalary(float minSalary, float maxSalary){
        try{
            logger.info("Finding by mother info");
            return FXCollections.observableList(formService.findByMotherSalary(minSalary, maxSalary));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByFatherSalary(float minSalary, float maxSalary){
        try{
            logger.info("Finding by father info");
            return FXCollections.observableList(formService.findByFatherSalary(minSalary, maxSalary));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getBySisterAmount(int amount){
        try{
            logger.info("Finding by student info");
            return FXCollections.observableList(formService.findByAmountOfSisters(amount));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public ObservableList<Form> getByBrotherAmount(int amount){
        try{
            logger.info("Finding by student info");
            return FXCollections.observableList(formService.findByAmountOfBrothers(amount));
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return null;
        }
    }

    public int deleteByStudentName(String name){
        try{
            logger.info("Deleting by student info");
            return formService.deleteByStudentName(name);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByStudentSurname(String surname){
        try{
            logger.info("Deleting by student info");
            return formService.deleteByStudentSurname(surname);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByStudentFatherName(String fatherName){
        try{
            logger.info("Deleting by student info");
            return formService.deleteByStudentFatherName(fatherName);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByMotherName(String name){
        try{
            logger.info("Deleting by mother info");
            return formService.deleteByMotherName(name);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByMotherSurname(String surname){
        try{
            logger.info("Deleting by mother info");
            return formService.deleteByMotherSurname(surname);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByMotherFatherName(String fatherName){
        try{
            logger.info("Deleting by mother info");
            return formService.deleteByMotherFatherName(fatherName);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByFatherName(String name){
        try{
            logger.info("Deleting by father info");
            return formService.deleteByFatherName(name);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByFatherSurname(String surname){
        try{
            logger.info("Deleting by father info");
            return formService.deleteByFatherSurname(surname);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByFatherFatherName(String fatherName){
        try{
            logger.info("Deleting by father info");
            return formService.deleteByFatherFatherName(fatherName);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByMotherSalary(float minSalary, float maxSalary){
        try{
            logger.info("Deleting by mother info");
            return formService.deleteByMotherSalary(minSalary, maxSalary);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByFatherSalary(float minSalary, float maxSalary){
        try{
            logger.info("Deleting by father info");
            return formService.deleteByFatherSalary(minSalary, maxSalary);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteBySisterAmount(int amount){
        try{
            logger.info("Deleting by student info");
            return formService.deleteByAmountOfSisters(amount);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public int deleteByBrotherAmount(int amount){
        try{
            logger.info("Deleting by student info");
            return formService.deleteByAmountOfBrothers(amount);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
            return -1;
        }
    }

    public void addForm(String studentName, String studentSurname, String studentFatherName,
                        String fatherName, String fatherSurname, String fatherFatherName,
                        String motherName, String motherSurname, String motherFatherName,
                        int amountOfSisters, int amountOfBrothers,
                        float fatherSalary, float motherSalary){
        try{
            logger.info("Adding new form");
            formService.setForm(studentName, studentSurname,
                    studentFatherName, fatherName, fatherSurname,
                    fatherFatherName, motherName, motherSurname,
                    motherFatherName, amountOfSisters, amountOfBrothers,
                    fatherSalary, motherSalary);
        }
        catch (Exception e){
            logger.error("Persistence fail",e);
        }
    }
}
