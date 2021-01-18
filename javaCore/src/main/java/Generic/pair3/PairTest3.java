package Generic.pair3;

import Generic.pair.Pair;
import Inherit.Employee;
import Inherit.Maneger;
import Inherit.equalsHashcodeTostring.Manager;

/**
 * author: zijiezhou
 * Date:   2020/10/23 18:55
 * Description:
 */
public class PairTest3 {

    public static void main(String[] args) {

    }

    public static void printBuddies(Pair< ? extends Inherit.Employee> p)
    {
        Inherit.Employee first = p.getFirst();
        Inherit.Employee second = p.getSecond();
        System.out.println(first.getName() + "and" + second.getName() + "are buddies.");

    }

    public static void minmaxBonus(Maneger[] a, Pair < ? super Manager> result)
    {
        if (a.length == 0) {
            return;
        }

        Maneger min = a[0];
        Maneger max = a[0];

        for (int i = 1; i < a.length ; i++) {

        }
    }
}
