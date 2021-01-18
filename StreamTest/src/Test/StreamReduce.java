package Test;

import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 16:32
 * Description:
 * 将Stream元素组合起来进行操作
 */
public class StreamReduce {
    public static void main(String[] args) {
//        字符串连接
        String reduce = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println("字符串拼接:" +reduce);
//        得到最小值

    }
}
