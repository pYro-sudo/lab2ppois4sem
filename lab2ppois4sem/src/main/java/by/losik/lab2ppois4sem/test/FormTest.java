package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.model.Father;
import by.losik.lab2ppois4sem.model.Form;
import by.losik.lab2ppois4sem.model.Mother;
import by.losik.lab2ppois4sem.model.Student;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FormTest {
    final Form form = new Form();

    @BeforeTest
    public void init(){
        form.setFather(new Father());
        form.setMother(new Mother());
        form.setStudent(new Student());
    }

    @Test
    public void testForm(){
        Assert.assertNotNull(form.getFather());
        Assert.assertNotNull(form.getMother());
        Assert.assertNotNull(form.getStudent());
    }
}
