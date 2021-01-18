
package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 16:09
 * Description:最大最小值和去重
 */
public class StreamMaxMinDistinct {
    public static void main(String[] args) {
//        得到最大最小值
        List<String> strings = Arrays.asList("zhangsan", "lisi", "wangwu", "zhaoliou");
        int asInt = strings.stream().mapToInt(String::length).max().getAsInt();
        int asInt1 = strings.stream().mapToInt(String::length).min().getAsInt();
        System.out.println("最大字符长度："+asInt+"最短字符长度："+asInt1);
//        获取去重后的数据
        String s = "good good study day day up";
        ArrayList<String> strings1 = new ArrayList<>();
        strings1.add(s);
        List<String> collect = strings1.stream().flatMap(str -> Stream.of(str.split(" "))).filter(str -> str.length() > 0)
                .map(String::toUpperCase).distinct().sorted().collect(Collectors.toList());
        System.out.println("去重之后的数据："+ collect);

    }
}
