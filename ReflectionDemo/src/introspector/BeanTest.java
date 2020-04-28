package introspector;

import org.junit.Test;

/**
 * @author ：zht
 * @date ：Created in 2020/4/22 19:15
 * @description：
 * @modified By：
 * @version: $
 */
public class BeanTest {
    @Test
    public void getBeanTest(){
        Config bean = (Config) BeanFactory.getBean("bean.name");
        System.out.println(bean);
    }
}
