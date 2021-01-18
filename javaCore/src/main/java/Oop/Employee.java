package Oop;

import java.time.LocalDate;

/**
 * author: zijiezhou
 * Date:   2020/9/17 15:20
 * Description:
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee ( String name) {
        this.name = name;
    }

    public Employee(String name, double salary, int year, int month, int day){
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month ,day);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void setHireDay(LocalDate hireDay) {
        this.hireDay = hireDay;
    }

    public void raiseSalary(double Precent){
        double raise = salary * Precent / 100;
        salary += raise;
    }
}
