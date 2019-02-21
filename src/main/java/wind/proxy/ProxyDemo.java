package wind.proxy;

import java.lang.reflect.Proxy;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2019-02-15 14:17
 **/
public class ProxyDemo {

    public static void main(String[] args) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new UserServiceImpl());
        Object o = Proxy.newProxyInstance(ProxyDemo.class.getClassLoader(), new Class[]{UserService.class}, myInvocationHandler);
        UserService o1 = (UserService) o;
        o1.query();
    }

}
