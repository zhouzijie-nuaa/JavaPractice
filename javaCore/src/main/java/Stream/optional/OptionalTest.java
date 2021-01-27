package Stream.optional;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * @author zzj
 * @date 2021/1/26 14:27
 **/
public class OptionalTest {

    public static void main(String[] args) throws IOException {
        String contents = new String(Files.readAllBytes(
                Paths.get("../123.text")), StandardCharsets.UTF_8);
        List<String> wordlist = Arrays.asList(contents.split("\\PL+"));

        Optional<String> optionalValue = wordlist.stream().filter(s -> s.contains("fred")).findFirst();
        System.out.println(optionalValue.orElse("No Wprd") + "contains fres");

        Optional<String> optinalString = Optional.empty();
        String result = optinalString.orElse("N/A");
        System.out.println("result" + result);
        result = optinalString.orElseGet(() -> Locale.getDefault().getDisplayName());
        System.out.println("result" + result);

        try {
            result = optinalString.orElseThrow(IllegalStateException::new);
            System.out.println("result" + result);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        optionalValue = wordlist.stream().filter(s -> s.contains("red")).findFirst();
        optionalValue.ifPresent(s -> System.out.println(s + "contains red"));

        HashSet<String> results = new HashSet<>();
        optionalValue.ifPresent(results::add);
        Optional<Boolean> added = optionalValue.map(results::add);
        System.out.println(added);

        System.out.println(inverse(4.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(-1.0).flatMap(OptionalTest::squareRoot));
        System.out.println(inverse(0.0).flatMap(OptionalTest::squareRoot));
        Optional<Double> result2 = Optional.of(-4.0).flatMap(OptionalTest::inverse).flatMap(OptionalTest::squareRoot);
        System.out.println(result2);

    }

    public static Optional<Double> inverse(Double x) {
        return x == 0 ? Optional.empty() : Optional.of(1 / x);
    }

    public static Optional<Double> squareRoot(Double x) {
        return x < 0 ? Optional.empty() : Optional.of(Math.sqrt(x));
    }

}
