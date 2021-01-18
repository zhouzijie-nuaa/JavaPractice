package Test;

import java.util.Arrays;
import java.util.List;

/**
 * author: zijiezhou
 * Date:   2020/8/31 16:04
 * Description:流并行处理程序的代替方法
 */
public class StreamParallel {
    public static void main(String[] args) {
//        获取空字符串的数量
        List<String> list = Arrays.asList("", "h", "f", "", "f", "", "", "", "b", "", "3");
        long count = list.parallelStream().filter(str -> str.isEmpty()).count();
        System.out.println("空字符串的数量为："+ count);

    }
}
