package wind.java8;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-12 10:44
 **/
public class InterfaceMethodDemo {

    public static void main(String[] args) {
        MyDataImpl obj = new MyDataImpl();
        obj.print("");
        obj.isNull("abc");
    }
}

class MyDataImpl implements MyData {

    public  boolean isNull(String str) {
        System.out.println("Impl Null Check");
        return str == null ? true : false;
    }

}

interface MyData {
    default void print(String str) {
        if (!isNull(str)) {
            System.out.println("MyData Pring::" + str);
        }
    }

    default boolean isNull(String str) {
        System.out.println("Interface Null Check");
        return str == null ? true : "".equals(str) ? true : false;
    }
}
