package Inherit.abstractClasses;

import java.time.LocalDate;
import java.time.Period;

/**
 * author: zijiezhou
 * Date:   2020/10/3 16:30
 * Description:
 */
public class Employee  extends Person {
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary, int year, int month, int day) {
        super(name);
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDat() {
        return hireDay;
    }


    @Override
    public String getDespription() {
        return String.format("an employee with a salary of $%.2f", salary);
    }

    public void raiseSalary(double bypercent){
        double raise = salary * bypercent / 100;
        salary += raise;
    }
}
