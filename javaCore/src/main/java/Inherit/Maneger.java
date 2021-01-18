package Inherit;

/**
 * author: zijiezhou
 * Date:   2020/10/2 16:32
 * Description:
 */
public class Maneger extends Employee{
    double bonus;
    /*注：
    * 若之类的构造器没有显式地调用超类的构造器，则将自动调用超类默认的构造器；
    * 若超类没有不带参数的构造器，并且在子类的构造器中又没有显式地调用其他构造器，java编译器则会报告错误
    * */
    public Maneger(String name, double salary, int year, int month, int day) {
        super(name, salary, year, month, day);
        bonus = 0;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double getSalary() {
        double baseSalary = super.getSalary();
        return baseSalary + bonus;
    }
}
