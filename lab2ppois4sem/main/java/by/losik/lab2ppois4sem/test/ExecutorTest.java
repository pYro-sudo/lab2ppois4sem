package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.model.Executor;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExecutorTest {
    Executor executor = new Executor();

    @Test
    public void testExecutor(){
        Assert.assertEquals(executor.getFormsByAmountOfBrothers(3).size(), 0);
        Assert.assertEquals(executor.getFormsByAmountOfSisters(2).size(), 0);
        Assert.assertEquals(executor.getFormsByStudentName("b").size(), 0);
        Assert.assertEquals(executor.getFormsByStudentSurname("t").size(), 0);
        Assert.assertEquals(executor.getFormsByStudentFatherName("c").size(), 0);
        Assert.assertEquals(executor.getFormsByFatherName("g").size(), 0);
        Assert.assertEquals(executor.getFormsByFatherSurname("z").size(), 0);
        Assert.assertEquals(executor.getFormsByFatherFatherName("l").size(), 0);
        Assert.assertNotEquals(executor.getFormsByFatherSalary(0, Integer.MAX_VALUE).size(), 0);
        Assert.assertEquals(executor.getFormsByMotherName("a").size(), 0);
        Assert.assertEquals(executor.getFormsByMotherSurname("qwedffwegf").size(), 0);
        Assert.assertEquals(executor.getFormsByMotherFatherName("d").size(), 0);
        Assert.assertNotEquals(executor.getFormsByMotherSalary(0, Integer.MAX_VALUE).size(), 0);
    }
}
