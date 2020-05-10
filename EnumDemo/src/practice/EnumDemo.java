package practice;

import com.sun.org.apache.regexp.internal.RE;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;

/**
 * @author zht
 * @date 2020-05-08 16:17
 */
public class EnumDemo {

    public static final int RED=0x1;
    public static final int GREEN=0x2;
    public static final int BLUE=0x3;
    public int color;

    @Test
    public void test1(){
        color= RED;
        color= 4;
    }

    public Color colorEnum;
    @Test
    public void test2(){
        colorEnum = Color.RED;
        colorEnum = Color.BLUE;
        colorEnum = Color.GREEN;
        System.out.println(colorEnum);
        System.out.println(colorEnum.name());
        System.out.println(colorEnum.ordinal());//枚举的序号
        System.out.println(colorEnum.toString());

        Color[] values = Color.values();
        System.out.println(Arrays.toString(values));
    }

    @Test
    public void test3(){
        EnumSet<Color> set = EnumSet.allOf(Color.class);
        for(Color c:set){
            System.out.println(c);
        }

        EnumMap<Color,String> map = new EnumMap<>(Color.class);//Color.class作为key
        map.put(Color.RED,"red");
        map.put(Color.GREEN,"green");
        map.put(Color.BLUE,"blue");
    }

    @Test
    public void test4(){
        System.out.println(Color.BLUE.getColor());
        System.out.println(Color.BLUE.getColor2());
    }

    //使用枚举实现单例设计模式
    @Test
    public void test5(){
        Singleton.SINGLETON.method();
    }
}
