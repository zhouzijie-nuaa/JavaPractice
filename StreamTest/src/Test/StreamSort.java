package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * author: zijiezhou
 * Date:   2020/8/31 15:47
 * Description:用于对流进行升序排序
 */
public class StreamSort {
    public static void main(String[] args) {
//        随机取值排序
        Random random = new Random();
        System.out.println("取到的前三条数据然后进行排序：");
        random.ints().limit(3).sorted().forEach(System.out::println);
//        优化排序（先获取在排序效率会更高）
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            User user = new User(i, "param" + i);
            users.add(user);
        }
//        普通排序
        List<User> list = users.stream().sorted((u, v) -> u.getName().compareTo(v.getName())).limit(3).collect(Collectors.toList());
        System.out.println("排序后的数据："+list);
//        优化排序取值
        List<User> list1 = users.stream().limit(3).sorted((u, v) -> u.getName().compareTo(v.getName())).collect(Collectors.toList());
        System.out.println("优化排序后的数据："+list1);
    }
}
