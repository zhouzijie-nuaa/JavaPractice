
package Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * author: zijiezhou
 * Date:   2020/8/31 14:25
 * Description:
 * map方法用于映射每个元素到对应的结果，一对一的关系
 * map方法中间需要填入对应的lambda表达式
 */
public class StreamMap {
    public static void main(String[] args) {
//        大小写转换
        List<String> list = Arrays.asList("ZhangSan", "LiSi", "WangWu", "ZhaoLiu");
        System.out.println("转换之前："+ list);
        List<String> list2 = list.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println("转换之后：" +list2);
//        转换数据类型
        List<String> list3 = Arrays.asList("1", "2", "3");
        System.out.println("转换之前："+list3);
        List<Integer> list4 = list3.stream().map(Integer::valueOf).collect(Collectors.toList());
        System.out.println("转换之后："+ list4);
//        获取平方
        List<Integer> list5 = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7});
        System.out.println("转换之前："+ list5);
        List<Integer> list6 = list5.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("转换之后："+list6);


    }
}
