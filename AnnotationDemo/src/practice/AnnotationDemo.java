package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zht
 * @date 2020-05-10 16:00
 */

public class AnnotationDemo {

    @Test
    //利用反射处理注解
    public void test2(){
        Class<Cat> catClass = Cat.class;
        //获取类上应用的指定注解
        MyAnnotation annotation = catClass.getAnnotation(MyAnnotation.class);
        //获取注解上变量值
        String name = annotation.name();
        int age = annotation.age();
        Color color = annotation.color();
        String[] like = annotation.like();
        try {
            Cat cat = catClass.newInstance();//newInstance: 弱类型。低效率。只能调用无参构造
            cat.setName(name);
            cat.setAge(age);
            cat.setColor(color);
            cat.setLike(like);
            System.out.println(cat);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        Cat cat = new Cat("miaomiao",3);
        cat.printInfo();//调用了一个已过时的方法，但还是可以用。

        @SuppressWarnings("all")
        //消除警告信息
        List list = new ArrayList();
        list.add("aa");
        list.add(10);
        list.add(10.1f);

    }
}
