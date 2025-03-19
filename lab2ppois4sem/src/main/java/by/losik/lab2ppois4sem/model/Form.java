package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "form", schema = "lab2ppois4sem")
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "father_id")
    private Father father;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "mother_id")
    private Mother mother;

    public int getId() {
        return this.id;
    }

    public Student getStudent() {
        return this.student;
    }

    public Father getFather() {
        return this.father;
    }

    public Mother getMother() {
        return this.mother;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }

    public String toString() {
        return "Form(id=" + this.getId() +
                ", \nstudent=\n" + this.getStudent() +
                ", \nfather=\n" + this.getFather() +
                ", \nmother=\n" + this.getMother() + "\n)";
    }
}
