package interfaces.EmployeeSort;

import java.util.Arrays;

/**
 * author: zijiezhou
 * Date:   2020/10/12 16:27
 * Description:
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Harry Hacker", 250000);
        staff[1] = new Employee("Carl Cracker", 750000);
        staff[2] = new Employee("Tony Tester", 380000);

        Arrays.sort(staff);

        for(Employee e : staff){
            System.out.println("name = " + e.getName() + ", salary= " + e.getSalary());
        }
    }
}
