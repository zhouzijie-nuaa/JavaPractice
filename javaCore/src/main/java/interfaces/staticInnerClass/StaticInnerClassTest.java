package interfaces.staticInnerClass;

/**
 * author: zijiezhou
 * Date:   2020/10/17 16:45
 * Description:
 */
public class StaticInnerClassTest {

    public static void main(String[] args) {
        double[] d = new double[20];
        for (int i = 0; i < d.length; i++) {
            d[i] = 100 * Math.random();
        }

        ArrayAlg.pair p = ArrayAlg.minmax(d);
        System.out.println("min = " + p.getFirst());
        System.out.println("max = " + p.getSecond());
    }


}
