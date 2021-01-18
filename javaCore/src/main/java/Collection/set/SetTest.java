package Collection.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

/**
 * author: zijiezhou
 * Date:   2020/10/29 14:43
 * Description:
 */
public class SetTest {

    public static void main(String[] args) {

        HashSet<Object> words = new HashSet<>();
        long totalTime = 0;

        try(Scanner in = new Scanner(System.in))
        {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() -callTime;
                totalTime += callTime;
            }
        }

        Iterator<Object> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext() ; i++) {
            System.out.println(iter.next());
        }
        System.out.println(".....");
        System.out.println(words.size() + " distinct words. " + totalTime + "milliseconds.");
    }

}
