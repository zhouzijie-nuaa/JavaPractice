package Collection.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * author: zijiezhou
 * Date:   2020/10/28 15:30
 * Description:
 */
public class linkedListTest {

    public static void main(String[] args) {
        LinkedList<Object> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        LinkedList<Object> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<Object> aIter = a.listIterator();
        Iterator<Object> bIter = b.iterator();

        while(bIter.hasNext())
        {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());
        }

        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {
            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();
            }
        }

        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);
    }

}
