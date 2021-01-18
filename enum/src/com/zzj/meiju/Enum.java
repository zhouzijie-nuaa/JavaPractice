package com.zzj.meiju;

/**
 * author: zijiezhou
 * Date:   2020/9/6 15:17
 * Description:
 */
public class Enum {
    public enum Family {
        DOUGHTER,
        FATHER,
        MOTHER,
        SON,
    }

    public static void main(String[] args) {
        Family f = Family.FATHER;
        for (Family family:Family.values()){
            System.out.println(family+",ordinal"+family.ordinal());
//            values():获取对应枚举的值
//            ordinal():获取枚举顺序的值
//            import static com.zzj.meiju.*:实现静态导包
//            即不需要使用枚举类名。常量的方式来使用
        }
    }
}
