package Inherit.abstractClasses;

/**
 * author: zijiezhou
 * Date:   2020/10/3 16:35
 * Description:
 */
public class Student extends Person{
    private String major;

    public Student(String name,String major) {
        super(name);
        this.major = major;
    }

    @Override
    public String getDespription() {
        return "a student majoring in" + major;
    }
}
