package Oop;

/**
 * author: zijiezhou
 * Date:   2020/9/27 15:53
 * Description:
 */
public class ConstructorTest {
    public static void main(String[] args) {
        conEmployee[] staff = new conEmployee[3];
        staff[0] = new conEmployee("harry",4666666);
        staff[1] = new conEmployee(600000);
        staff[2] = new conEmployee();

        for(conEmployee e : staff){
            System.out.println("name=" + e.getName() + ",id = " + e.getId() + ",salary=" + e.getSalary() );
        }
    }
}
