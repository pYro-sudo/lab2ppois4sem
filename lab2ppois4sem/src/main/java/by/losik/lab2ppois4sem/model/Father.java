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
    protected String fatherName;
    @Column(name = "father_surname")
    protected String fatherSurname;
    @Column(name = "father_father_name")
    protected String fatherFatherName;
    @Column(name = "salary")
    protected float salary;

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
        return "\tFather(id=" + this.getId() +
                ", \n\t\tfatherName=" + this.getFatherName() +
                ", \n\t\tfatherSurname=" + this.getFatherSurname() +
                ", \n\t\tfatherFatherName=" + this.getFatherFatherName() +
                ", \n\t\tsalary=" + this.getSalary() + "\n\t)";
    }

    public void setId(int id) {
        this.id = id;
    }
}
