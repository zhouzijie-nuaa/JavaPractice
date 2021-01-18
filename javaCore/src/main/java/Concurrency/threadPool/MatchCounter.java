package Concurrency.threadPool;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * author: zijiezhou
 * Date:   2021/1/4 13:20
 * Description:
 */
public class MatchCounter implements Callable<Integer> {

    private File directory;
    private String keyword;
    private ExecutorService pool;
    private int count;

    public MatchCounter(File directory, String keyword, ExecutorService pool) {
        this.directory = directory;
        this.keyword = keyword;
        this.pool = pool;
    }

    @Override
    public Integer call() {
        count = 0;
        try {
            File[] files = directory.listFiles();
            ArrayList<Future<Integer>> results = new ArrayList<>();

            for (File file : files ) {
                if (file.isDirectory()) {
                    MatchCounter counter = new MatchCounter(file, keyword, pool);
                    Future<Integer> result = pool.submit(counter);
                    results.add(result);
                } else {
                    if (search(file)) {
                        count++;
                    }
                }
            }

            for (Future<Integer> result : results) {
                try {
                    count += result.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    public boolean search(File file) {
        try {
            try (Scanner in = new Scanner(file, "UTF-8")){
                boolean found = false;
                while (!found && in.hasNextLine()) {
                    String line = in.nextLine();
                    if (line.contains(keyword)) {
                        found = true;
                    }
                }
                return found;
            } catch (Exception e) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
