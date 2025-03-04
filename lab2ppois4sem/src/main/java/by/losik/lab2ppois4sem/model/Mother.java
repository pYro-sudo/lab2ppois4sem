package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mother_info", schema = "lab2ppois4sem")
public class Mother {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mother_name")
    private String motherName;
    @Column(name = "mother_surname")
    private String motherSurname;
    @Column(name = "mother_father_name")
    private String motherFatherName;
    @Column(name = "salary")
    private float salary;

    public int getId() {
        return this.id;
    }

    public String getMotherName() {
        return this.motherName;
    }

    public String getMotherSurname() {
        return this.motherSurname;
    }

    public String getMotherFatherName() {
        return this.motherFatherName;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public void setMotherFatherName(String motherFatherName) {
        this.motherFatherName = motherFatherName;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Mother(id=" + this.getId() + ", motherName=" + this.getMotherName() + ", motherSurname=" + this.getMotherSurname() + ", motherFatherName=" + this.getMotherFatherName() + ", salary=" + this.getSalary() + ")";
    }
}
