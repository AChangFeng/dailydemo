package wind.se;

import java.lang.ref.WeakReference;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-18 09:56
 **/
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<Fruit> wrFruit = new WeakReference<>(new Fruit());

        if (null != wrFruit.get()) {
            System.out.println("before gc fruit is not null!");
        }

        System.gc();

        if (null == wrFruit.get()) {
            System.out.println("after gc fruit is null!");
        }else {
            System.out.println("after gc fruit is not null!");
        }

    }

}

class Fruit {

}
