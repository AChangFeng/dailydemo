package wind.junit.testsuit;

import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:54
 **/
public class TestJunit1 {

    @Test(expected = ArithmeticException.class)
    public void test1() {
        int x = 1 / 0;
        System.out.println("test1");
    }

}
