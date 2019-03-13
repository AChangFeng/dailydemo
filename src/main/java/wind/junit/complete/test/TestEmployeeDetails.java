package wind.junit.complete.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:34
 **/
public class TestEmployeeDetails {

    EmployeeDetails employeeDetails = new EmployeeDetails();

    EmpBusinessLogic empBusinessLogic = new EmpBusinessLogic();

    @Before
    public void setUp() {
        employeeDetails.setAge(25);
        employeeDetails.setMonthlySalary(8000);
        employeeDetails.setName("Rajeev");
    }

    @Test
    public void testCalculateYearlySalary() {
        double salary = empBusinessLogic.calculateYearlySalary(employeeDetails);
        Assert.assertEquals(96000, salary, 0);
    }

    @Test
    public void testCalculateAppraisal() {
        double appraisal = empBusinessLogic.calculateAppraisal(employeeDetails);
        Assert.assertEquals(500, appraisal, 0);
    }

}
