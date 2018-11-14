package wind.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-11-12 14:09
 **/
public class ClazzSynchronize {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Aa.method1();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                Aa.method2();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}

class Aa {

    public synchronized static void method1() throws Exception {
        System.out.println("call synchronized static method1");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("call synchronized static method1 end");
    }

    public synchronized static void method2() throws Exception {
        System.out.println("call synchronized method2");
        TimeUnit.SECONDS.sleep(5);
        System.out.println("call synchronized method2 end");
    }

}