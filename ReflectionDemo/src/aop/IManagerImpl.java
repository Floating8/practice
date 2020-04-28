package aop;

import java.util.ArrayList;

/**
 * @author ：zht
 * @date ：Created in 2020/4/27 11:18
 * @description：
 * @modified By：
 * @version: $
 */
public class IManagerImpl implements IManager {
    private ArrayList<String> list = new ArrayList<>();
    @Override
    public void add(String item) {
        list.add(item);
        System.out.println(item);
    }
}
