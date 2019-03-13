package wind.junit.testsuit;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:54
 **/
public class TestJunit2 {

    @Test(timeout = 100)
    public void test2() throws Exception {
        System.out.println("test2");
        Thread.sleep(101);
    }

    @Test
    @Ignore
    public void testIgnore() {
        System.out.println("ignore");
    }

}
