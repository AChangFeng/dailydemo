package wind.junit.basic.usage;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-12 16:13
 **/
public class TestJunit {

    String message = "Hello World!";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test
    public void testPrintMessage() {
        Assert.assertEquals(message, messageUtil.printMessage());
    }

}
