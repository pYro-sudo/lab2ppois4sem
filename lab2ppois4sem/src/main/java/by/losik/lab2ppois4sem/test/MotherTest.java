package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.model.Mother;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MotherTest {
    final Mother mother = new Mother();
    @BeforeTest
    public void init(){
        mother.setMotherName("Nambi");
        mother.setMotherSurname("Shrivanassa");
        mother.setMotherFatherName("Aidee");
        mother.setSalary(10);
    }

    @Test
    public void testMother(){
        Assert.assertEquals(mother.getMotherName(), "Nambi");
        Assert.assertEquals(mother.getMotherSurname(), "Shrivanassa");
        Assert.assertEquals(mother.getMotherFatherName(), "Aidee");
        Assert.assertEquals(mother.getSalary(), 10);
    }
}
