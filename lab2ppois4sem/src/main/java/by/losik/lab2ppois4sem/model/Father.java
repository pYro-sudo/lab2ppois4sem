package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "father_info", schema = "lab2ppois4sem")
public class Father {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "father_name")
    String fatherName;
    @Column(name = "father_surname")
    String fatherSurname;
    @Column(name = "father_father_name")
    String fatherFatherName;
    @Column(name = "salary")
    float salary;

    public int getId() {
        return this.id;
    }

    public String getFatherName() {
        return this.fatherName;
    }

    public String getFatherSurname() {
        return this.fatherSurname;
    }

    public String getFatherFatherName() {
        return this.fatherFatherName;
    }

    public float getSalary() {
        return this.salary;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public void setFatherFatherName(String fatherFatherName) {
        this.fatherFatherName = fatherFatherName;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String toString() {
        return "Father(id=" + this.getId() + ", fatherName=" + this.getFatherName() + ", fatherSurname=" + this.getFatherSurname() + ", fatherFatherName=" + this.getFatherFatherName() + ", salary=" + this.getSalary() + ")";
    }
}
