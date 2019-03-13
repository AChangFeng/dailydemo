package wind.junit.basic.usage;

import junit.framework.TestResult;
import junit.framework.TestSuite;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:23
 **/
public class JunitTestSuite {

    public static void main(String[] args) {
        TestSuite testSuite = new TestSuite(TestJunit1.class, TestJunit2.class, TestJunit3.class);
        TestResult testResult = new TestResult();
        testSuite.run(testResult);
        System.out.println("Number of test cases = " + testSuite.countTestCases());
    }

}
