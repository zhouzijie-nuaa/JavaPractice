package Stream.collecting;

import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author zzj
 * @date 2021/1/26 15:05
 **/
public class CollectingResults {

    public static Stream<String> noVowels() throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("../123.text")
        ), StandardCharsets.UTF_8);
        List<String> wordlist = Arrays.asList(contents.split("\\PL+"));
        Stream<String> words = wordlist.stream();
        return words.map(s -> s.replaceAll("[12314]", ""));
    }

    public static <T> void show(String label, Set<T> set) {
        System.out.print(label + ":" + set.getClass().getName());
        System.out.println("[" + set.stream().limit(10).map(Objects::toString).collect(Collectors.joining(",")) + "]");
    }

    public static void main(String[] args) throws IOException {
        Iterator<Integer> iter = Stream.iterate(0, n -> n + 1).limit(10).iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        Object[] numbers = Stream.iterate(0, n -> n + 1).limit(10).toArray();
        System.out.println("Object array:" + numbers);

        try {
            Integer number = (Integer)numbers[0];
            System.out.println("number:" + number);
            System.out.println("The following statement throws an exception:");
            Integer[] numbers2 = (Integer[]) numbers;
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        Integer[] numbers3 = Stream.iterate(0, n -> n + 1).limit(10).toArray(Integer[]::new);
        System.out.println("Integer array:" + numbers3);

        Set<String> noVowelSet = noVowels().collect(Collectors.toSet());
        show("noVowelSet", noVowelSet);

        TreeSet<String> noVowelTreeSet = noVowels().collect(Collectors.toCollection(TreeSet::new));
        show("noVowelTreeSet", noVowelTreeSet);

        String result = noVowels().limit(10).collect(Collectors.joining());
        System.out.println("Joining with commas: " + result);

        IntSummaryStatistics summary = noVowels().collect(Collectors.summarizingInt(String::length));
        double averageWordLength = summary.getAverage();
        int maxWordLength = summary.getMax();
        System.out.println("Average word length:" + averageWordLength);
        System.out.println("Max word length:" + maxWordLength);
        System.out.println("foreach:");
        noVowels().limit(10).forEach(System.out::println);
    }

}
