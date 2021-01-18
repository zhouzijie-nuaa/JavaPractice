package Oop;

/**
 * author: zijiezhou
 * Date:   2020/9/27 14:59
 * Description:证明java中只有值传递没有引用调用
 */
public class ParamTest {
    public static void main(String[] args) {
        System.out.println("Testing tripleValue:");
        double precent = 10;
        System.out.println("Before: precent = " + precent);
        tripleValue(precent);
        System.out.println("After: precent = " + precent);

        System.out.println("\n Testing tripleSalary:");
        Employee harry = new Employee("harry", 57777);
        System.out.println("Before: salary=" + harry.getSalary());
        tripleSalary(harry);
        System.out.println("After: salary= " + harry.getSalary());

        System.out.println("\n Testing swap:");
        Employee a = new Employee("Alice", 344444);
        Employee bob = new Employee("Bob", 42346);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + bob.getName());
        swap(a,bob);
        System.out.println("After：" + a.getName());
        System.out.println("After：" + bob.getName());

    }

    public static void tripleValue(double x){
        x = x * 3;
        System.out.println("End of method: x=" + x);
    }

    public static void tripleSalary(Employee x){
        x.raiseSalary(200);
        System.out.println("End of method: salary =" + x.getSalary());
    }

    public static void swap(Employee x, Employee y){
        Employee temp = x;
        x = y;
        y =temp;
        System.out.println("End of method: x=" + x.getName());
        System.out.println("End of method: y=" + y.getName());
    }

    static class Employee{
        private String name;
        private double salary;

        public Employee(String name, double salary) {
            this.name = name;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public double getSalary() {
            return salary;
        }

        public void raiseSalary(double bypercent)
        {
            double raise = salary * bypercent / 100;
            salary += raise;
        }
    }
}
