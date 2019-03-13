package wind.junit.basic.usage;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:13
 **/
public class TestJunit3 extends TestResult {

    public synchronized void addError(Test test, Throwable throwable) {
        super.addError(test, throwable);
    }

    public synchronized void addFailure(Test test, AssertionFailedError error) {
        super.addFailure(test, error);
    }

    public synchronized void stop() {
        System.out.println("stop");
    }

    @org.junit.Test
    public void testAdd() {
        System.out.println("testAdd");
    }

}
