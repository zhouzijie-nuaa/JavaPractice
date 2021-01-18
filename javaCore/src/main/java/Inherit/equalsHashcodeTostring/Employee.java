package Inherit.equalsHashcodeTostring;

import java.time.LocalDate;
import java.util.Objects;

/**
 * author: zijiezhou
 * Date:   2020/10/5 20:15
 * Description:
 */
public class Employee {
    private String name;
    private double salary;
    private LocalDate hireDay;

    public Employee(String name, double salary,int year, int month, int day) {
        this.name = name;
        this.salary = salary;
        this.hireDay = LocalDate.of(year, month, day);
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double bypercent){
        double raise = salary * bypercent / 100;
        salary += raise;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
        {return true;
        }
        if( obj == null){
            return false;
        }
        if(getClass() != obj.getClass()){
            return false;
        }
        Employee other = (Employee) obj;
        return Objects.equals(name, other.name) && salary == other.salary && Objects.equals(hireDay, other.hireDay);

    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, hireDay);
    }

    @Override
    public String toString() {
        return getClass().getName() + "[ name = " + name + ", salary = " + salary + ", hireDay = " +hireDay + "]";
    }
}
