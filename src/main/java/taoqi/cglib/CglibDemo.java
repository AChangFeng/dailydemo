package taoqi.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-09-03 13:56
 **/
public class CglibDemo {

    public void test() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        CglibDemo cglibDemo = new CglibDemo();
        CglibDemo cglibDemo1 = getProxy(cglibDemo);
        cglibDemo1.test();
    }

    public static <T> T getProxy(T target) {
        Objects.requireNonNull(target);
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                System.out.println("before method run...");
                Object result = methodProxy.invokeSuper(o, args);
                System.out.println("after method run...");
                return result;
            }
        });
        return (T) enhancer.create();
    }
}