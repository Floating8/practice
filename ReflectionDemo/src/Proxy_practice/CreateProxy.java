package Proxy_practice;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author ：zht
 * @date ：Created in 2020/4/6 8:39
 * @description：
 * @modified By：
 * @version: $
 */
/*用于动态生成一个代理对象*/
public class CreateProxy implements InvocationHandler {

    private Object target;//被代理的对象
    public Object create(Object target){//用于创建代理对象
        this.target=target;
        Object o = Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), this);
        return o;
    }
    @Override
    /*代理对象要执行的方法,参数分别为：代理类对象，被代理对象的方法，被代理对象方法的参数*/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("找产品~~~");
        System.out.println("确定物品");
        method.invoke(target,args);
        System.out.println("完成本次交易");
        return null;
    }
}
