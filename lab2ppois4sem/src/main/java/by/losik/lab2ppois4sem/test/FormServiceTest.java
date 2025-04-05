package by.losik.lab2ppois4sem.test;

import by.losik.lab2ppois4sem.service.FormService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FormServiceTest {
    final FormService formService = new FormService();

    @Test
    public void testExecutor(){
        Assert.assertEquals(formService.findByAmountOfBrothers(31415926).size(), 0);
        Assert.assertEquals(formService.findByAmountOfSisters(271828183).size(), 0);
        Assert.assertEquals(formService.findByStudentName("b").size(), 0);
        Assert.assertEquals(formService.findByStudentSurname("t").size(), 0);
        Assert.assertEquals(formService.findByStudentFatherName("c").size(), 0);
        Assert.assertEquals(formService.findByFatherName("g").size(), 0);
        Assert.assertEquals(formService.findByFatherSurname("z").size(), 0);
        Assert.assertEquals(formService.findByFatherFatherName("l").size(), 0);
        Assert.assertNotEquals(formService.findByFatherSalary(0, Integer.MAX_VALUE).size(), 0);
        Assert.assertEquals(formService.findByMotherName("a").size(), 0);
        Assert.assertEquals(formService.findByMotherSurname("qwedffwegf").size(), 0);
        Assert.assertEquals(formService.findByMotherFatherName("d").size(), 0);
        Assert.assertNotEquals(formService.findByMotherSalary(0, Integer.MAX_VALUE).size(), 0);
    }
}
