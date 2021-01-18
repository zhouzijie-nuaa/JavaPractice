package Test;

import java.util.ArrayList;

/**
 * author: zijiezhou
 * Date:   2020/8/31 16:24
 * Description:
 * Allmatch
 * Anymatch
 * nonematch
 */
public class StreamMatch {
    public static void main(String[] args) {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i <4 ; i++) {
            User user = new User(i, "param" + i);
            users.add(user);
        }
        boolean b = users.stream().allMatch(u -> u.getId() > 3);
        System.out.println("是否全部都大于3："+b);
        boolean b1 = users.stream().anyMatch(u -> u.getId() > 3);
        System.out.println("是否存在大于3的情况："+b1);
        boolean b2 = users.stream().noneMatch(u -> u.getId() > 3);
        System.out.println("是否没有大于3的情况："+b2);
    }
}
