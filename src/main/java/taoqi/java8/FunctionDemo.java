package taoqi.java8;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-08-02 10:26
 **/
public class FunctionDemo {

    public static void main(String[] args) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        Consumer<String> greeter = (p) -> System.out.println("Hello, " + p);
        greeter.andThen((t) -> System.out.println("now is :" + df.format(new Date()))).accept("Skywalker");
    }

}