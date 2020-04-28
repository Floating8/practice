package bean;

/**
 * @author ：zht
 * @date ：Created in 2020/4/9 8:48
 * @description：
 * @modified By：
 * @version: $
 */
public class Emp {
    private String name;
    private int age;
    private int salary;

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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getInfo(){
        return "name="+name;
    }
}
