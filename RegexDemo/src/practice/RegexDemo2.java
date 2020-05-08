package practice;

import org.junit.Test;

/**
 * @author solang
 * @date 2020-05-08 15:01
 */
public class RegexDemo2 {
    @Test
    public void test(){
        //匹配电话号码
        String phoneNumber = "010-12345678";
        boolean b = phoneNumber.matches("\\d{3,4}-\\d{7,8}");//前面是3-4位-，后面是7-8位
        System.out.println(b);
        //匹配手机号码
        String phone = "12345678911";
        System.out.println(phone.matches("[1][2-9]\\d{9}"));//第一位是1，第二位是3-9，后面有九位
        //匹配用户名：字母开头，数字字母下划线组成
        String username= "abc1313";
        System.out.println(username.matches("[a-zA-Z]+[\\w|_]*"));//字母开头，“+”为出现一次或多次，“|”为或；
        // “w”为匹配包括下划线的任何单词字符。等价于“[A-Za-z0-9_]”。；“*”为0次或多次

        //匹配Ip地址
        String ip = "20.10.20.132";
        System.out.println(ip.matches("\\d{1,3}.\\d{1,3}.\\d{1,3}.\\d{1,3}"));
        //匹配网址
        String addr = "http://www.baidu.com";
        System.out.println(addr.matches("http://\\w+.\\w+.\\S*"));//“S”是匹配任何非空白字符。等价于[^ \f\n\r\t\v]。

        //匹配年龄
        String age= "18";
        System.out.println(age.matches("\\d{1,3}"));

        //匹配金额
        String price = "19.8";
        System.out.println(price.matches("\\d+.\\d+"));

    }

}
