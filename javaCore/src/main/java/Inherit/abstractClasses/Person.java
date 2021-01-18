package Inherit.abstractClasses;

/**
 * author: zijiezhou
 * Date:   2020/10/3 16:27
 * Description:
 */
public abstract class Person {
    public abstract String getDespription();
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
