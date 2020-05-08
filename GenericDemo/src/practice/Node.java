package practice;

/**
 * @author ：zht
 * @date ：Created in 2020/4/29 16:47
 * @description：
 * @modified By：
 * @version: $
 */
/*泛型类
* T:参数化类型，在实际使用时才会指定具体类型
* 泛型只作用与编译期检查，在编译后会被擦除*/
public class Node<T> {
    private T data;
    public Node(){
    }

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T addData(){

        data= (T) (data+"10");
        return data;
    }
}
