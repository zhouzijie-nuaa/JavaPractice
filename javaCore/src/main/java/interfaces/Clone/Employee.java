package interfaces.Clone;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * author: zijiezhou
 * Date:   2020/10/14 20:49
 * Description:
 */
public class Employee implements Cloneable{

    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
        this.hireDay = new Date();
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        Employee cloned = (Employee) super.clone();

        cloned.hireDay = (Date) hireDay.clone();

        return cloned;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDat = new GregorianCalendar(year, month - 1, day).getTime();
        hireDay.setTime(newHireDat.getTime());
    }

    public void raiseSalary(double byPercent){
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return "Employee [name =" + name + ",salary =" + salary + ", hireDay = " + hireDay + "]";
    }
}
