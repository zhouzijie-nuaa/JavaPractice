package Generic.pair3;

import Generic.pair.Pair;

/**
 * author: zijiezhou
 * Date:   2020/10/23 18:47
 * Description:
 */
public class PairAlg {

    public static boolean hasNulls(Pair<?> p)
    {
        return p.getFirst() == null || p.getSecond() == null;
    }

    public static void swap(Pair<?> p)
    {
        swapHelper(p);
    }

    public static <T> void swapHelper(Pair<T> p)
    {
        T t = p.getFirst();
        p.setFirst(p.getSecond());
        p.setSecond(t);
    }

}
