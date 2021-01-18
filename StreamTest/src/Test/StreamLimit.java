package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * author: zijiezhou
 * Date:   2020/8/31 15:29
 * Description:用于获取指定数量的流
 */
public class StreamLimit {
    public static void main(String[] args) {
//        获取前N条数de数据
        Random random = new Random();
        System.out.println("取到的前3条数据：");
        random.ints().limit(3).forEach(System.out::println);
//        结合Skip使用得到需要的数据
//        Skip表示的是丢掉前n个元素
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            User user = new User(i, "param" + i);
            users.add(user);
        }
        System.out.println("截取前的数据："+users);
        //map多用于stream的类型转换
        List<String> collect = users.stream().map(User::getName).limit(3).skip(2).collect(Collectors.toList());
        System.out.println("截取后的数据："+collect);
    }
}
