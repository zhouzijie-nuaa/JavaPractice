package Generic.pair2;

import Generic.pair.Pair;

/**
 * author: zijiezhou
 * Date:   2020/10/22 14:39
 * Description:
 */
public class ArrayAlg {

    public static <T extends Comparable> Pair<T> minmax(T[] a)
    {
        if (a == null || a.length == 0) {
            return null;
        }
        T max = a[0];
        T min = a[0];
        for (int i = 1; i < a.length ; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }
//      不指名泛型类型，那么默认指定的类型是Object类型
        Pair result = new Pair<>(min,max);
        return result;

    }

}
