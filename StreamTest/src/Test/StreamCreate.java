package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 13:59
 * Description:
 */
public class StreamCreate {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("a", "b", "c");
        String[] strArray = {"a", "b", "c"};
        stream = Stream.of(strArray);
        stream= Arrays.stream(strArray);
        List<String> list = Arrays.asList(strArray);
        stream =list.stream();
    }
}
