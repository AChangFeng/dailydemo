package wind.junit.basic.usage;

import org.junit.Assert;
import org.junit.Test;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-13 10:10
 **/
public class TestJunit1 {

    @Test
    public void testaAdd() {
        int num = 5;
        String tmp = null;
        String str = "Junit is working fine";

        Assert.assertEquals("Junit is working fine", str);
        Assert.assertFalse(num > 6);
        Assert.assertNull(tmp);
    }
}
