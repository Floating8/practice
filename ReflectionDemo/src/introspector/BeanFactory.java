package introspector;

import jdk.internal.util.xml.impl.Input;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author ：zht
 * @date ：Created in 2020/4/21 19:30
 * @description：
 * @modified By：
 * @version: $
 * 通过内省的API来装配一个bean对象，bean对象的值是通过配置文件中来获取
 * 目的是为了提高维护性
 */
public class BeanFactory {
    private static Properties prop = new Properties();
    //使用静态代码块读取配置文件
    static {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("introspector/config.Properties");
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /*
    * 获取一个Bean*/
    public static Object getBean(String name){
        Object bean = null;
        String beanName = prop.getProperty(name);
        try {
            Class<?> aClass = Class.forName(beanName);
            bean = aClass.newInstance();//实例化bean对象
            //通过类信息获取JavaBean的描述信息
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass);
            //通过Javabean描述信息，获取该类的所有属性描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                String propertyName = propertyDescriptors[i].getName();
                Method writeMethod = propertyDescriptors[i].getWriteMethod();
                if("username".equals(propertyName)) {
                    //相当于调用属性的set方法
                    writeMethod.invoke(bean,prop.getProperty("bean.username"));
                }else if ("password".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.password"));
                }else if("url".equals(propertyName)){
                    writeMethod.invoke(bean,prop.getProperty("bean.url"));
                }
            }
        } catch (ClassNotFoundException | IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
