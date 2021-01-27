package Stream.parallel;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;

/**
 * @author zzj
 * @date 2021/1/27 15:49
 **/
public class ParallelStreams {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(Paths.get("../123.text")), StandardCharsets.UTF_8);
        List<String> wordlist = Arrays.asList(contents.split("//PL+"));
        int[] shortwords = new int[10];
        wordlist.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortwords[s.length()] ++;
            }
        });
        System.out.println(Arrays.toString(shortwords));

        Arrays.fill(shortwords, 0);
        wordlist.parallelStream().forEach(s -> {
            if (s.length() < 10) {
                shortwords[s.length()]++;
            }
        });
        System.out.println(Arrays.toString(shortwords));

        Stream<String> stringStream = wordlist.parallelStream();
        stringStream.filter(s -> s.length() < 10).collect(
                Collectors.groupingBy(String::length, counting())
        );
        System.out.println(stringStream);


    }
}
