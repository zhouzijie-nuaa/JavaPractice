package Generic.pair2;

import Generic.pair.Pair;

import java.time.LocalDate;

/**
 * author: zijiezhou
 * Date:   2020/10/22 14:50
 * Description:
 */
public class PairTest {

    public static void main(String[] args) {
        LocalDate[] birthdays = {
                LocalDate.of(1906, 12, 9),
                LocalDate.of(1815, 12, 10),
                LocalDate.of(1903, 12, 3),
                LocalDate.of(1910, 6, 22),
        };
        Test[] test = {
                new Test("zzj", 456464),
                new Test("zll", 56123),
        };
        Pair<Test> minmax = ArrayAlg.minmax(test);
        Pair<LocalDate> mm = ArrayAlg.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

}
