package practice;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author zht
 * @date 2020-05-11 9:02
 */
@Retention(RetentionPolicy.RUNTIME)//表示该注解的作用范围在运行时存在
public @interface MyAnnotation {
    //定义变量
    public String name();
    public int age() default 2;//给变量设置默认值
    public String[] like();//定义一个数组变量
    public Color color();//定义一个枚举类型的变量
}
