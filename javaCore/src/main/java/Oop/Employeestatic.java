package Oop;

/**
 * author: zijiezhou
 * Date:   2020/9/26 14:40
 * Description:包含静态属性的雇员类
 */
public class Employeestatic {
    private static int nextId = 1;
    private String name;
    private double salary;
    private int id;

    public Employeestatic(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.id = 0;
    }

    public static int getNextId() {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public int getId() {
        return id;
    }

    public void setId(){
        id = nextId;
        nextId++;
    }

    public static void main(String[] args) {
        Employeestatic harry = new Employeestatic("harry", 500000);
        System.out.println(harry.getName() + " " + harry.getSalary());
    }
}
