package by.losik.lab2ppois4sem.repository;

import java.util.List;

public abstract class FormRepository<T>{
    public abstract List<T> findAll();
    public abstract List<T> findByStudentName(String name);
    public abstract List<T> findByStudentSurname(String surname);
    public abstract List<T> findByStudentFatherName(String fatherName);
    public abstract List<T> findByMotherName(String name);
    public abstract List<T> findByMotherSurname(String surname);
    public abstract List<T> findByMotherFatherName(String fatherName);
    public abstract List<T> findByFatherName(String name);
    public abstract List<T> findByFatherSurname(String surname);
    public abstract List<T> findByFatherFatherName(String fatherName);
    public abstract List<T> findByMotherSalary(float minSalary, float maxSalary);
    public abstract List<T> findByFatherSalary(float minSalary, float maxSalary);
    public abstract List<T> findByAmountOfSisters(int amount);
    public abstract List<T> findByAmountOfBrothers(int amount);
    public abstract int deleteByStudentName(String name);
    public abstract int deleteByStudentSurname(String surname);
    public abstract int deleteByStudentFatherName(String fatherName);
    public abstract int deleteByMotherName(String name);
    public abstract int deleteByMotherSurname(String surname);
    public abstract int deleteByMotherFatherName(String fatherName);
    public abstract int deleteByFatherName(String name);
    public abstract int deleteByFatherSurname(String surname);
    public abstract int deleteByFatherFatherName(String fatherName);
    public abstract int deleteByMotherSalary(float minSalary, float maxSalary);
    public abstract int deleteByFatherSalary(float minSalary, float maxSalary);
    public abstract int deleteByAmountOfSisters(Integer amount);
    public abstract int deleteByAmountOfBrothers(Integer amount);
    public abstract void setForm(String studentName, String studentSurname, String studentFatherName,
                        String fatherName, String fatherSurname, String fatherFatherName,
                        String motherName, String motherSurname, String motherFatherName,
                        int amountOfSisters, int amountOfBrothers,
                        float fatherSalary, float motherSalary);
}
