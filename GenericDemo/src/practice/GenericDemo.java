package practice;

import org.junit.Test;

import java.util.*;

/**
 * @author ：zht
 * @date ：Created in 2020/4/29 16:32
 * @description：
 * @modified By：
 * @version: $
 */
public class GenericDemo {
    @Test
    public void test5(){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"x");
        map.put(2,"c");

        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for(Map.Entry entry:entrySet){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    }


    @Test
    public void test4(){
        String[] arrays = {"x","u","y"};
        String[] strs = func(arrays, 0, 2);
        System.out.println(Arrays.toString(strs));
    }

    @Test
    public void test3(){
        Node<Number> n1 = new Node<>(5);
        Node<Integer> n2 = new Node<>(6);
        //n1=n2 不支持这样
        getData(n1);
        getData2(n2);
        getUpperNumverData(n1);
        getUpperNumverData(n2);

    }
    public static void getData(Node<Number> node){
        System.out.println(node.getData());
    }

    public static void getData2(Node<?> node){
        //node.setData(20);     当使用通配符定义泛型类型时只能输出，不能修改
        System.out.println(node.getData());
    }

    public static void getUpperNumverData(Node<? extends Number> data){
        //只能是Number类及其子类,也不能进行修改
        //泛型的上限用？extends 下限用？super
        //下限只能设置其具体类和其父类，上限是设置具体类和其子类
        System.out.println("data:"+data.getData());
    }

    /*泛型的方法*/
    public static <T>  T[] func(T[] array,int i,int t){
        T temp = array[i];
        array[i] = array[t];
        array[t] = temp;
        return array;
    }

    @Test
    public void test2(){
        Node<String> stringNode = new Node<>("a");
        Node<Integer> intNode = new Node<>(10);
        System.out.println(stringNode.getData());
        System.out.println(intNode.getData());
    }

    @Test
    public void testNode(){
        Node<String> stringNode = new Node<>("x");
        Node<Integer> intNode = new Node<>(10);
        System.out.println(stringNode.getData());
        System.out.println(intNode.getData());
        System.out.println(intNode.addData());

    }
    @Test
    public void test1(){
        List<String> list = new ArrayList<String>();
        list.add("a");
        //list.add(10);
        //list.add(new Object());

        for (int i=0;i<list.size();i++){
            //如果我们不能确定集合中的元素类型，那么我们需要在处理元素时判断元素的类型，才能做相应的操作

        }
    }
}
