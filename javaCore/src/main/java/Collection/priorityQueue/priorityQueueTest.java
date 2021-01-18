package Collection.priorityQueue;

import com.sun.prism.shader.AlphaOne_Color_AlphaTest_Loader;

import java.time.LocalDate;
import java.util.PriorityQueue;

/**
 * author: zijiezhou
 * Date:   2020/10/30 15:30
 * Description:
 */
public class priorityQueueTest {

    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9));
        pq.add(LocalDate.of(1815, 12, 10));
        pq.add(LocalDate.of(1903,12,3));
        pq.add(LocalDate.of(1910,6,22));

        System.out.println("Iterating over elements ...");
        for (LocalDate date: pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }

}
