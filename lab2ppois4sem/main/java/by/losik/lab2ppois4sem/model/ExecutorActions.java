package by.losik.lab2ppois4sem.model;

import java.util.List;

public interface ExecutorActions {
    List<Form> getAllData();
    List<Form> getFormsByStudentName(String name);
    List<Form> getFormsByStudentSurname(String surname);
    List<Form> getFormsByStudentFatherName(String fatherName);
    List<Form> getFormsByMotherName(String name);
    List<Form> getFormsByMotherSurname(String surname);
    List<Form> getFormsByMotherFatherName(String fatherName);
    List<Form> getFormsByFatherName(String name);
    List<Form> getFormsByFatherSurname(String surname);
    List<Form> getFormsByFatherFatherName(String fatherName);
    List<Form> getFormsByMotherSalary(float minSalary, float maxSalary);
    List<Form> getFormsByFatherSalary(float minSalary, float maxSalary);
    List<Form> getFormsByAmountOfSisters(int amount);
    List<Form> getFormsByAmountOfBrothers(int amount);
    int deleteFormsByStudentName(String name);
    int deleteFormsByStudentSurname(String surname);
    int deleteFormsByStudentFatherName(String fatherName);
    int deleteFormsByMotherName(String name);
    int deleteFormsByMotherSurname(String surname);
    int deleteFormsByMotherFatherName(String fatherName);
    int deleteFormsByFatherName(String name);
    int deleteFormsByFatherSurname(String surname);
    int deleteFormsByFatherFatherName(String fatherName);
    int deleteFormsByMotherSalary(float minSalary, float maxSalary);
    int deleteFormsByFatherSalary(float minSalary, float maxSalary);
    int deleteFormsByAmountOfSisters(Integer amount);
    int deleteFormsByAmountOfBrothers(Integer amount);
    void setForm(String studentName, String studentSurname, String studentFatherName,
                 String fatherName, String fatherSurname, String fatherFatherName,
                 String motherName, String motherSurname, String motherFatherName,
                 int amountOfSisters, int amountOfBrothers,
                 float fatherSalary, float motherSalary);

}
