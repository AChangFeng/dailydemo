package wind.junit.basic.usage;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-03-12 15:56
 **/
public class MessageUtil {

    private String message;

    public MessageUtil(String message) {
        this.message = message;
    }

    public String printMessage() {
        System.out.println(this.message);
        return this.message;
    }
}
