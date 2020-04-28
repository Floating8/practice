package Proxy_practice;

/**
 * @author ：zht
 * @date ：Created in 2020/4/6 8:37
 * @description：
 * @modified By：
 * @version: $
 */
public class Person implements Subject{
    @Override
    public void shopping() {
        System.out.println("付款，买到好产品");
    }
}
