package wind.spring;

import lombok.Data;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.PropertyAccessorFactory;
import org.springframework.beans.PropertyValue;

/**
 * @description:
 * @author: ChangFeng
 * @create: 2018-08-27 10:44
 **/
public class BeanWrapperDemo {

    public static void main(String[] args) {
        User user = new User();
        BeanWrapper beanWrapper = PropertyAccessorFactory.forBeanPropertyAccess(user);
        beanWrapper.setPropertyValue("name","Sam");
        System.out.println(user);
        beanWrapper.setPropertyValue(new PropertyValue("name","Jack"));
        System.out.println(user);
    }
}

@Data
class User {
    private String name;
}