package Generic.pair;

/**
 * author: zijiezhou
 * Date:   2020/10/21 15:53
 * Description:
 */
public class PairTest {

    public static void main(String[] args) {
        String[] words = {"Mary", "Had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());

    }

}
