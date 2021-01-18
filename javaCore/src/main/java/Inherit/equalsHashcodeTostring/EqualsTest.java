package Inherit.equalsHashcodeTostring;

/**
 * author: zijiezhou
 * Date:   2020/10/5 20:35
 * Description:
 */
public class EqualsTest {
    public static void main(String[] args) {
        Employee alice1 = new Employee("Alice Adams", 750000, 1987, 12, 15);
        Employee alice2 = alice1;
        Employee alice3 = new Employee("Alice Adams", 750000, 1987, 12, 15);
        Employee bob = new Employee("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2:" + (alice1 == alice2));
        /* 对于等号 == 来说，对象之前的比较即为是否引用了同一个对象*/
        System.out.println("alice1 == alice3:" + (alice1 == alice3));

        System.out.println("alice1.equals(alice3):" + alice1.equals(alice3));

        System.out.println("alice1.equals(bob):" + alice1.equals(bob));

        System.out.println("bob.toString():" + bob.toString());

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBounes(5000);

        System.out.println("boss.toString():" + boss);

        System.out.println("carl.equals(boss):" + carl.equals(boss));

        System.out.println("alice1.hashcode(): " + alice1.hashCode());

        System.out.println("alice3.hashcode(): " + alice3.hashCode());

        System.out.println("bob.hashcode(): " + bob.hashCode());

        System.out.println("carl.hashCode(): " + carl.hashCode());


    }
}
