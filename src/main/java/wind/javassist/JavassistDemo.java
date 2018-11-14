package wind.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

import java.lang.reflect.Method;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-10-18 17:24
 **/
public class JavassistDemo {

    public static void main(String[] args) throws Exception {
        defineNewClass();
    }

    public static void modifyClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        CtClass ctClass = classPool.get("wind.javassist.Rectangle");
        ctClass.setSuperclass(classPool.get("wind.javassist.Point"));
        ctClass.writeFile();
        byte[] b = ctClass.toBytecode();
        Class<?> aClass = ctClass.toClass();
    }

    public static void defineNewClass() throws Exception {
        ClassPool classPool = ClassPool.getDefault();
        //makeClass() cannot create a new interface;
        // makeInterface() in ClassPool can do.
        // Member methods in an interface can be created with abstractMethod() in CtNewMethod.
        CtClass ctClass = classPool.makeClass("Point");
        CtMethod ctMethod = CtNewMethod.make("public void say(){System.out.println(\"Hello, Javassist\");}", ctClass);
        ctClass.addMethod(ctMethod);
        Class<?> aClass = ctClass.toClass();
        Method say = aClass.getMethod("say");
        say.invoke(aClass.newInstance(), null);
        //ctClass.writeFile();
    }

    public static void defrostCtClass() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass newClass = pool.makeClass("NewClass");
        // If a CtClass object is converted into a class file by writeFile(), toClass(), or toBytecode(),
        // Javassist freezes that CtClass object.  Further modifications of that CtClass object are not permitted.
        newClass.writeFile();
        // After defrost() is called, the CtClass object can be modified again.
        newClass.defrost();
        newClass.setSuperclass(pool.get("java.lang.Object"));
    }

}