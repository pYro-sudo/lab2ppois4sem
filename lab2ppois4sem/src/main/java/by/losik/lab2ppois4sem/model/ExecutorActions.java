package by.losik.lab2ppois4sem.model;

import java.util.List;

public interface ExecutorActions {
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
    List<Form> deleteFormsByStudentName(String name);
    List<Form> deleteFormsByStudentSurname(String surname);
    List<Form> deleteFormsByStudentFatherName(String fatherName);
    List<Form> deleteFormsByMotherName(String name);
    List<Form> deleteFormsByMotherSurname(String surname);
    List<Form> deleteFormsByMotherFatherName(String fatherName);
    List<Form> deleteFormsByFatherName(String name);
    List<Form> deleteFormsByFatherSurname(String surname);
    List<Form> deleteFormsByFatherFatherName(String fatherName);
    List<Form> deleteFormsByMotherSalary(float minSalary, float maxSalary);
    List<Form> deleteFormsByFatherSalary(float minSalary, float maxSalary);
    List<Form> deleteFormsByAmountOfSisters(int amount);
    List<Form> deleteFormsByAmountOfBrothers(int amount);
    void setForm(String studentName, String studentSurname, String studentFatherName,
                 String fatherName, String fatherSurname, String fatherFatherName,
                 String motherName, String motherSurname, String motherFatherName,
                 int amountOfSisters, int amountOfBrothers,
                 float fatherSalary, float motherSalary);

}
