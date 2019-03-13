package wind.junit.complete.test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:30
 **/
public class EmpBusinessLogic {

    public double calculateYearlySalary(EmployeeDetails employeeDetails) {
        double yearlySalary = 0;
        yearlySalary = employeeDetails.getMonthlySalary() * 12;
        return yearlySalary;
    }

    public double calculateAppraisal(EmployeeDetails employeeDetails) {
        double appraisal = 0;

        if (employeeDetails.getMonthlySalary() < 10_000) {
            appraisal = 500;
        } else {
            appraisal = 1000;
        }
        return appraisal;
    }

}
