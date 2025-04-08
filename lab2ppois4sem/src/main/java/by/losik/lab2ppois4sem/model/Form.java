package by.losik.lab2ppois4sem.model;

import jakarta.persistence.*;

@Entity
@Table(name = "form", schema = "lab2ppois4sem")
@NamedQueries({
        @NamedQuery(
                name = "Forms.findAll",
                query = "select f from Form f"
        ),
        @NamedQuery(
                name = "Forms.findByStudentName",
                query = "select f from Form f where f.student.studentName = :name"
        ),
        @NamedQuery(
                name = "Forms.findByStudentSurname",
                query = "select f from Form f where f.student.studentSurname = :surname"
        ),
        @NamedQuery(
                name = "Forms.findByStudentFatherName",
                query ="select f from Form f where f.student.studentFatherName = :fatherName"
        ),
        @NamedQuery(
                name = "Forms.findByMotherName",
                query = "select f from Form f where f.mother.motherName = :name"
        ),
        @NamedQuery(
                name = "Forms.findByMotherSurname",
                query = "select f from Form f where f.mother.motherSurname = :surname"
        ),
        @NamedQuery(
                name = "Forms.findByMotherFatherName",
                query = "select f from Form f where f.mother.motherFatherName = :fatherName"
        ),
        @NamedQuery(
                name = "Forms.findByFatherName",
                query = "select f from Form f where f.father.fatherName = :name"
        ),
        @NamedQuery(
                name = "Forms.findByFatherSurname",
                query = "select f from Form f where f.father.fatherSurname = :surname"
        ),
        @NamedQuery(
                name = "Forms.findByFatherFatherName",
                query = "select f from Form f where f.father.fatherFatherName = :fatherName"
        ),
        @NamedQuery(
                name = "Forms.findByMotherSalary",
                query = "select f from Form f where f.mother.salary between :minSalary and :maxSalary"
        ),
        @NamedQuery(
                name = "Forms.findByFatherSalary",
                query = "select f from Form f where f.father.salary between :minSalary and :maxSalary"
        ),
        @NamedQuery(
                name = "Forms.findBySisterAmount",
                query = "select f from Form f where f.student.numOfSisters = :amount"
        ),
        @NamedQuery(
                name = "Forms.findByBrotherAmount",
                query = "select f from Form f where f.student.numOfBrothers = :amount"
        ),
        @NamedQuery(
                name = "Forms.removeByStudentName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.student.studentName = :name)"
        ),
        @NamedQuery(
                name = "Forms.removeByStudentSurname",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.student.studentSurname = :surname)"
        ),
        @NamedQuery(
                name = "Forms.removeByStudentFatherName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.student.studentFatherName = :fatherName)"
        ),
        @NamedQuery(
                name = "Forms.removeByMotherName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.mother.motherName = :name)"
        ),
        @NamedQuery(
                name = "Forms.removeByMotherSurname",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.mother.motherSurname = :surname)"
        ),
        @NamedQuery(
                name = "Forms.removeByMotherFatherName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.mother.motherFatherName = :fatherName)"
        ),
        @NamedQuery(
                name = "Forms.removeByFatherName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.father.fatherName = :name)"
        ),
        @NamedQuery(
                name = "Forms.removeByFatherSurname",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.father.fatherSurname = :surname)"
        ),
        @NamedQuery(
                name = "Forms.removeByFatherFatherName",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.father.fatherFatherName = :fatherName)"
        ),
        @NamedQuery(
                name = "Forms.removeByMotherSalary",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.mother.salary between :minSalary and :maxSalary)"
        ),
        @NamedQuery(
                name = "Forms.removeByFatherSalary",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.father.salary between :minSalary and :maxSalary)"
        ),
        @NamedQuery(
                name = "Forms.removeBySisterAmount",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.student.numOfSisters = :amount)"
        ),
        @NamedQuery(
                name = "Forms.removeByBrotherAmount",
                query = "delete from Form f where f.id in " +
                        "(select f2.id from Form f2 where f2.student.numOfBrothers = :amount)"
        )
})
public class Form {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    protected Student student;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "father_id")
    protected Father father;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "mother_id")
    protected Mother mother;

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

    public void setId(int id) {
        this.id = id;
    }
}
