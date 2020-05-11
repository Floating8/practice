package practice;

import java.util.Arrays;

/**
 * @author zht
 * @date 2020-05-10 16:00
 */
@MyAnnotation(name="xx",like={"aa","ww"},color = Color.GREEN)//通过default可以指定变量默认值，有了默认值在使用时可以不设置
public class Cat {
    private String name;
    public int age;
    private Color color;
    private String[] like;

    public String[] getLike() {
        return like;
    }

    public void setLike(String[] like) {
        this.like = like;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
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

    @Override
    //表示该方法重写了父类的方法，用于验证方法是否覆盖父类的方法
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color=" + color +
                ", like=" + Arrays.toString(like) +
                '}';
    }



    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }

    @Deprecated
    //表示用于标记方法已过时，不建议使用
    public String printInfo(){
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
