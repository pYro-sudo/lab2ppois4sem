package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.model.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class StudentTest {
    final Student student = new Student();
    @BeforeTest
    public void init(){
        student.setStudentName("Van");
        student.setStudentSurname("Darkholm");
        student.setStudentFatherName("Travis");
        student.setNumOfBrothers(10);
        student.setNumOfSisters(5);
    }
    @Test
    public void testStudent(){
        Assert.assertEquals(student.getStudentName(), "Van");
        Assert.assertEquals(student.getStudentSurname(), "Darkholm");
        Assert.assertEquals(student.getStudentFatherName(), "Travis");
        Assert.assertEquals(student.getNumOfBrothers(), 10);
        Assert.assertEquals(student.getNumOfSisters(), 5);
    }
}
