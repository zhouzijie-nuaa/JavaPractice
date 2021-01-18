
package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * author: zijiezhou
 * Date:   2020/8/31 14:43
 * Description:用于设置相关的条件来过滤出元素
 */
public class StreamFilter {
    public static void main(String[] args) {
//        通过与findAny得到if/else的值
        List<String> list = Arrays.asList("张三", "李四", "王五", "赵六");
        String result = list.stream().filter(str -> "李四".equals(str)).findAny().orElse("没有找到对应人物");
        String result1 = list.stream().filter(str -> "李二".equals(str)).findAny().orElse("没有找到对应的人物");
        System.out.println("第一次找寻结果："+result);
        System.out.println("第二次找寻结果："+result1);
//        通过与mapToint计算和
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User(6,"张三"));
        users.add(new User(1,"王五"));
        users.add(new User(2,"赵六"));
        users.add(new User(3,"王丽"));
        users.add(new User(4,"张三"));
        int sum = users.stream().filter(u -> "张三".equals(u.getName())).mapToInt(u -> u.getId()).sum();
        System.out.println("计算结果："+sum);
    }
}
