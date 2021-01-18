package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 15:17
 * Description:
 * flatMap方法主要用于映射每个元素到对应的结果，一对多
 */
public class StreamFlatMap {
    public static void main(String[] args) {
//        从句子中得到单词
        String Worlds = "The Way Of the Future";
        ArrayList<String> list = new ArrayList<>();
        list.add(Worlds);
        List<String> collect = list.stream().flatMap(str -> Stream.of(str.split(" "))).filter(world -> world.length() > 0).collect(Collectors.toList());
        /*将多个Stream连接成一个Stream*/
        collect.forEach(System.out::println);
        /*
        * forEach(System.out::println)等于
        * forEach(t->System.out.println(t))
        * */
    }
}
