package Collection.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * author: zijiezhou
 * Date:   2020/10/29 16:07
 * Description:
 */
public class TreeSetTest {

    public static void main(String[] args) {
        TreeSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster",1234));
        parts.add(new Item("Widget",4562));
        parts.add(new Item("Modem",9912));
        System.out.println(parts);

        TreeSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
    
}
