package Oop;

/**
 * author: zijiezhou
 * Date:   2020/9/26 14:46
 * Description:
 */
public class StaticTest {
    public static void main(String[] args) {
        Employeestatic[] ep = new Employeestatic[3];
        ep[0] = new Employeestatic("tom", 4000000);
        ep[1] = new Employeestatic("dick",7000000);
        ep[2] = new Employeestatic("harry",9000000);

        for (Employeestatic e :ep){
            e.setId();
            System.out.println("name=" + e.getName() + ",id=" + e.getId() + ",salary=" + e.getSalary());
        }
        int n = Employeestatic.getNextId();
        System.out.println("Next available id = " + n );
    }
}
