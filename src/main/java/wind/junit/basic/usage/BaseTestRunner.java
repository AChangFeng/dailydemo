package wind.junit.basic.usage;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:17
 **/
public class BaseTestRunner {

    public static void runTestJunit(Class clazz) {
        Result result = JUnitCore.runClasses(clazz);

        result.getFailures().forEach(System.out::print);

        System.out.println(result.wasSuccessful());
    }

}
