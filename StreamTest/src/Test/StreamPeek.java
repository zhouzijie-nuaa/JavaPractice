package Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 15:58
 * Description:对每个元素执行操作并返回一个新的Stream
 */

public class StreamPeek {
    public static void main(String[] args) {
        System.out.println("peek使用：");
        Stream.of("one","two","three","four").filter(e->e.length()>3).peek(e->System.out.println("转换之前是："+e))
                .map(String::toUpperCase).peek(e->System.out.println("转换之后是："+e)).collect(Collectors.toList());
    }
}
