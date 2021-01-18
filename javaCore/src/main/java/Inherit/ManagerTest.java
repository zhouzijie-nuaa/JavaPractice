package Inherit;

/**
 * author: zijiezhou
 * Date:   2020/10/2 16:37
 * Description:
 */
public class ManagerTest {
    public static void main(String[] args) {

        Maneger boss = new Maneger("Carl Craker", 800000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee[] staff = new Employee[3];
        staff[0] = boss;
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1 );
        staff[2] = new Employee("Tommy tester", 400000, 1990, 5,15);

        for(Employee e : staff){
            System.out.println("name = " + e.getName() + ",salary = " + e.getSalary());
        }

    }
}
