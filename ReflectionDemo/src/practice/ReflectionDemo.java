package practice;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @author ：zht
 * @date ：Created in 2020/3/29 9:34
 * @description：
 * @modified By：
 * @version: $
 */
public class ReflectionDemo {
    @Test
    public  void test5(){
        Dog dog = new Dog("xx",4,"132");
        Class<Dog> dogClass = Dog.class;
        //获取类的包名
        Package aPackage = dogClass.getPackage();
        System.out.println(aPackage.getName());
        //获取公共的方法，包括继承的共有方法
        Method[] methods = dogClass.getMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(methods[i]);
            if (methods[i].getName().equals("toString")){
                try {
                    String s = (String) methods[i].invoke(dog);
                    System.out.println(s);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("----------------------");
        //访问私有方法,获取到本类中定义的所有方法，不包括父类
        Method[] declaredMethods = dogClass.getDeclaredMethods();
        for (int i = 0; i < declaredMethods.length; i++) {
            System.out.println(declaredMethods[i]);
            if (declaredMethods[i].getName().equals("set")){
                //设置私有方法可以被访问(去除访问修饰符的检查)
                declaredMethods[i].setAccessible(true);
                try {
                    declaredMethods[i].invoke(dog);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //获取所有属性
    @Test
    public void test4(){
        Class<Dog> dogClass = Dog.class;
        Field[] fields = dogClass.getFields();//获取非私有属性
        System.out.println(fields.length);
        Field[] declaredFields = dogClass.getDeclaredFields();//获取所有属性
        System.out.println(declaredFields.length);
        for (int i = 0; i < declaredFields.length; i++) {
            int modifiers = declaredFields[i].getModifiers();
            System.out.println(Modifier.toString(modifiers)+" "+declaredFields[i].getName());

        }
    }


    /*通过反射来实例化对象*/
    @Test
    public void test3(){
        Class<Dog> dogClass = Dog.class;
        Constructor<?>[] constructors = dogClass.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println(constructors[i].getName());
            System.out.println(constructors[i].getParameterCount());
            
        }
        try {
            //获取一个指定的构造方法
            Constructor<Dog> constructor = dogClass.getConstructor(String.class, int.class, String.class);
            //调用带参数的构造器来实例化对象
            Dog dog = constructor.newInstance("xx", 2, "red");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void test2(){
        Class<Dog> dogClass = Dog.class;
        try {
            //通过class对象实例化类对象，调用了默认无参的构造方法
            Dog dog =(Dog)dogClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }



    /*获取class对象的三种形式*/
    public void test1(){
        /*通过对象的getclass（）方法*/
        Dog dog = new Dog("xx",5,"red");
        Class aClass = dog.getClass();

        //通过类.class
        Class dogClass = Dog.class;

        //通过class.forname方法
        try {
            Class aClass1 = Class.forName("practice.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
