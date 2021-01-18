package Test;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterTest {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("张三", "李四", "王五", "赵六");
        System.out.println("过滤之前："+ list);
        ArrayList<Object> result = new ArrayList<>();
        for(String str :list) {
            if(!"李四".equals(str)){
                result.add(str);
            }
        }
        System.out.println("过滤之后："+ result);
    }
}
