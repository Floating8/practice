package practice;

import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ：zht
 * @date ：Created in 2020/5/6 19:30
 * @description：
 * @modified By：
 * @version: $
 */
public class RegexDemo {
    @Test
    public void test3(){
        String s = "465464354";
        boolean b = s.matches("[0-9]+");
        boolean b1 = s.matches("\\d+");
        System.out.println(b+"-"+b1);
    }

    @Test
    public void test2(){
        //创建一个匹配模式
        Pattern p = Pattern.compile("a+b");
        Matcher matcher = p.matcher("ab");
        boolean b = matcher.matches();//实现匹配
        System.out.println(b);
    }


    /*
    * 不使用正则表达式来检查字符串是否由数字组成的方法*/
    @Test
    public void test1(){
        String s = "52a01314";
        char[] chars = s.toCharArray();//将字符串转化为字符数组
        boolean flag = true;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]<'0'||chars[i]>'9'){
                flag=false;
                break;
            }
        }
        if (flag){
            System.out.println("是由数字组成");
        }else {
            System.out.println("不是由数字组成");
        }
    }
}
