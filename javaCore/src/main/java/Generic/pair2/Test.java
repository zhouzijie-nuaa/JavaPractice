package Generic.pair2;

/**
 * author: zijiezhou
 * Date:   2020/10/22 14:54
 * Description:
 */
public class Test implements Comparable{

    private String name;
    private double money;

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public Test(String name, double money) {
        this.name = name;
        this.money = money;
    }

    @Override
    public int compareTo(Object o) {
        return -1;
    }
}
