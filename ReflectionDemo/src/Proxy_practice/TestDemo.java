package Proxy_practice;

import org.junit.Test;

/**
 * @author ：zht
 * @date ：Created in 2020/4/6 8:50
 * @description：
 * @modified By：
 * @version: $
 */
public class TestDemo {
    @Test
    public void testProxy(){
        CreateProxy cp = new CreateProxy();//用来创建代理对象的对象
        Subject person = new Person();
        Subject proxy =(Subject) cp.create(person);
        proxy.shopping();
    }
}
