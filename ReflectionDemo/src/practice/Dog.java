package practice;

/**
 * @author ：zht
 * @date ：Created in 2020/3/29 9:34
 * @description：
 * @modified By：
 * @version: $
 */
public class Dog {
    private String name;
    private int age;
    private String color;

    private void set(){
        System.out.println("123456");
    }
    protected void get(){
        System.out.println("654321");
    }
    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                '}';
    }

    public Dog() {

    }

    public Dog(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
