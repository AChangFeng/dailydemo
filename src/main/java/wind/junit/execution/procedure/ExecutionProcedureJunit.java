package wind.junit.execution.procedure;

import org.junit.*;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 11:43
 **/
public class ExecutionProcedureJunit {

    @BeforeClass
    public static void beforeClass() {
        System.out.println("in before class");
    }

    @AfterClass
    public static void afterClass() {
        System.out.println("in after class");
    }

    @Before
    public void before() {
        System.out.println("in before");
    }

    @After
    public void after() {
        System.out.println("in after");
    }

    @Test
    public void testCase1() {
        System.out.println("in test case 1");
    }

    @Test
    public void testCase2() {
        System.out.println("in test case 2");
    }

}
