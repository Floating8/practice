package aop;

/**
 * @author ：zht
 * @date ：Created in 2020/4/28 8:59
 * @description：
 * @modified By：
 * @version: $
 */
/*切面实现类*/
public class LogAdvice implements Advice{

    @Override
    public void beforeAdvice() {
        System.out.println("start time:"+System.currentTimeMillis());
    }

    @Override
    public void afterAdvice() {
        System.out.println("end time:"+System.currentTimeMillis());
    }
}
