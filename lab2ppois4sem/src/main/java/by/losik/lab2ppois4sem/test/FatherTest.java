package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.model.Father;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FatherTest {
    final Father father = new Father();
    @BeforeTest
    public void init(){
        father.setFatherName("Kirill");
        father.setFatherSurname("Ryabushkin");
        father.setFatherFatherName("Anatol'evich");
        father.setSalary(10);
    }

    @Test
    public void testFather(){
        Assert.assertEquals(father.getFatherName(),"Kirill");
        Assert.assertEquals(father.getFatherSurname(),"Ryabushkin");
        Assert.assertEquals(father.getFatherFatherName(),"Anatol'evich");
        Assert.assertEquals(father.getSalary(),10);
    }
}
