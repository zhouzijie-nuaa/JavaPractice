package Collection.treeSet;

import java.util.Objects;

/**
 * author: zijiezhou
 * Date:   2020/10/29 16:07
 * Description:
 */
public class Item implements Comparable<Item>{

    private String description;
    private int partNumber;

    public Item(String description, int partNumber) {
        this.description = description;
        this.partNumber = partNumber;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "[description = " + description + " ,partNumber = " + partNumber + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Item other = (Item)obj;
        return Objects.equals(description,other.description) && partNumber == other.partNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(description,partNumber);
    }

    @Override
    public int compareTo(Item o) {
        int diff = Integer.compare(partNumber,o.partNumber);
        return diff != 0 ? diff : description.compareTo(o.description);
    }

}
