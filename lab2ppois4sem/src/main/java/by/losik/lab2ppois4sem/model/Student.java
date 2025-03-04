package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student_info", schema = "lab2ppois4sem")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_surname")
    private String studentSurname;
    @Column(name = "student_father_name")
    private String studentFatherName;
    @Column(name = "num_of_sisters")
    private int numOfSisters;
    @Column(name = "num_of_brothers")
    private int numOfBrothers;

    public int getId() {
        return this.id;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getStudentSurname() {
        return this.studentSurname;
    }

    public String getStudentFatherName() {
        return this.studentFatherName;
    }

    public int getNumOfSisters() {
        return this.numOfSisters;
    }

    public int getNumOfBrothers() {
        return this.numOfBrothers;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setStudentSurname(String studentSurname) {
        this.studentSurname = studentSurname;
    }

    public void setStudentFatherName(String studentFatherName) {
        this.studentFatherName = studentFatherName;
    }

    public void setNumOfSisters(int numOfSisters) {
        this.numOfSisters = numOfSisters;
    }

    public void setNumOfBrothers(int numOfBrothers) {
        this.numOfBrothers = numOfBrothers;
    }

    public String toString() {
        return "Student(id=" + this.getId() + ", studentName=" + this.getStudentName() + ", studentSurname=" + this.getStudentSurname() + ", studentFatherName=" + this.getStudentFatherName() + ", numOfSisters=" + this.getNumOfSisters() + ", numOfBrothers=" + this.getNumOfBrothers() + ")";
    }
}
