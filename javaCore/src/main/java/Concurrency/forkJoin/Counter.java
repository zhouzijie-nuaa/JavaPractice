package Concurrency.forkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.function.DoublePredicate;

/**
 * author: zijiezhou
 * Date:   2021/1/4 14:46
 * Description:
 */
public class Counter extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 1000;
    private double[] values;
    private int from;
    private int to;
    private DoublePredicate filter;

    public Counter(double[] values, int from, int to, DoublePredicate filter) {
        this.values = values;
        this.from = from;
        this.to = to;
        this.filter = filter;
    }

    @Override
    protected Integer compute() {
        int count = 0;
        if (to - from < THRESHOLD) {
            for (int i = from; i < to; i++) {
                if (filter.test(values[i])) {
                    count++;
                }
            }
            return count;
        } else {
            int mid = (from + to)/2;
            Counter first = new Counter(values, from, mid, filter);
            Counter second = new Counter(values, mid, to, filter);
            invokeAll(first, second);
            return first.join() + second.join();
        }
    }
}
