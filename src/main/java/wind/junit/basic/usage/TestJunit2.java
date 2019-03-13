package wind.junit.basic.usage;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 10:59
 **/
public class TestJunit2 extends TestCase {

    protected double fValue1;
    protected double fValue2;

    @Before
    public void setUp() {
        fValue1 = 2.0;
        fValue2 = 3.0;
        System.out.println("setUp");
    }

    @After
    public void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    public void testAdd() {
        System.out.println("Number of Test Case = " + this.countTestCases());

        String name = this.getName();
        System.out.println("Test Cast Name = " + name);

        this.setName("testNewAdd");
        String newName = this.getName();
        System.out.println("Updated Test Case Name = " + newName);
    }

}
