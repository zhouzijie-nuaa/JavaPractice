package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * author: zijiezhou
 * Date:   2020/8/31 14:06
 * Description:
 */
public class ConvertStream {
    public static void main(String[] args) {
//java中的双冒号运算就是Java中的方法引用 method references
//[方法引用]的格式是 类名::方法名
//举例：
//1.表达式：
//person -> person.getName();
//可以替换成：
//Person::getName
//
//2.表达式：
//() -> new HashMap<>();
//可以替换成：
//HashMap::new
    try{
        Stream<String> stream = Stream.of("a", "b", "c");

//       将Stream由String类型转换为Array类型
        String[] strArrays = stream.toArray(String[]::new);

//        转换为Collection
        List<String> list1 = stream.collect(Collectors.toList());
        ArrayList<String> list2 = stream.collect(Collectors.toCollection(ArrayList::new));
        Set<String> set1 = stream.collect(Collectors.toSet());
        Stack<String> set2 = stream.collect(Collectors.toCollection(Stack::new));

//        转换为String类型
        String string = stream.collect(Collectors.joining()).toString();


    }catch (Exception e){
        e.printStackTrace();
    }
    }


}
