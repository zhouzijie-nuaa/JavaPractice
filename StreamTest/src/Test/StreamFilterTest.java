package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: zijiezhou
 * Date:   2020/8/31 11:28
 * Description:
 */

public class StreamFilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "李四", "王五", "赵六");
        List<String> result = list.stream().filter(str -> !"李四".equals(str)).collect(Collectors.toList());
//        list.stream:将list转换为Stream();
//        filter():将stream根据相应的条件进行过滤
//        .collect(Collectors.toList()):将stream转换为list类型数据
        System.out.println("过滤后:"+ result);
    }

}
