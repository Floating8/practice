package aop;

import org.junit.Test;

import java.io.InputStream;

/**
 * @author ：zht
 * @date ：Created in 2020/4/28 9:29
 * @description：
 * @modified By：
 * @version: $
 */
public class AopTest {
    @Test
    public void test(){
        //1:读取配置文件
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("aop/bean.properties");
        //2:创建Bean的工厂对象
        BeanFactory beanFactory = new BeanFactory(in);
        //3:获取代理对象
        ProxyFactoryBean proxyFactoryBean=(ProxyFactoryBean) beanFactory.getBean("bean");
        IManager proxy = (IManager)proxyFactoryBean.getProxy();
        proxy.add("xxx");
    }
}
