package wind.clazz;

import org.apache.commons.io.IOUtils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-10-09 10:10
 **/
public class FileSystemClassLoader extends ClassLoader {

    private String rootDir;

    public FileSystemClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = this.getClassData(name);
        if (null == classData) {
            throw new ClassNotFoundException();
        }
        return defineClass(name, classData, 0, classData.length);
    }

    private byte[] getClassData(String className) {
        String path = this.classNameToPath(className);
        try {
            FileInputStream fis = new FileInputStream(path);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            IOUtils.copy(fis, baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) throws Exception {
        FileSystemClassLoader classLoader = new FileSystemClassLoader("D:\\Users\\TQ-G153\\Desktop");
        Class<?> cglibDemo = classLoader.loadClass("wind.cglib.CglibDemo");
        Object newInstance = cglibDemo.newInstance();
        Method method = cglibDemo.getMethod("test");
        method.invoke(newInstance);
    }
}