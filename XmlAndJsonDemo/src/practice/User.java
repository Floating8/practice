package practice;

/**
 * @author zht
 * @date 2020-05-18 9:00
 */
public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", followers_count=" + followers_count +
                '}';
    }

    private int followers_count;

    public User(String name, int followers_count) {
        this.name = name;
        this.followers_count = followers_count;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(int followers_count) {
        this.followers_count = followers_count;
    }
}
