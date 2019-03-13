package wind.junit.parameterizedtest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 14:15
 **/
@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {

    private Integer inputNumber;

    private Boolean expectedResult;

    private PrimeNumberChecker checker;

    public PrimeNumberCheckerTest(Integer inputNumber, Boolean expectedResult) {
        this.inputNumber = inputNumber;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        checker = new PrimeNumberChecker();
    }

    @Parameterized.Parameters
    public static Collection primeNumbers() {
        return Arrays.asList(new Object[][]{
                {2, true},
                {6, false},
                {19, true},
                {22, false},
                {23, true},
        });
    }

    @Test
    public void testPrimeNumberChecker() {
        System.out.println("Parameterized number is : " + inputNumber);
        Assert.assertEquals(expectedResult, checker.validate(inputNumber));
    }
}
