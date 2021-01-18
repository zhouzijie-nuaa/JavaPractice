import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/**
 * author: zijiezhou
 * Date:   2020/8/31 16:42
 * Description:java.time包中关键类
 */
public class Time {
    public static void main(String[] args) {
/*    instant:瞬时时间
*     LocalDate：本地日期，不包括具体时间，格式：yyyy-MM-dd
*     localTime：本地时间，不包括日期，格式：yyyy-MM-dd  HH:mm:ss
*     localDatetime ：组合了日期和时间，但不包括时差和时区信息
*     ZoneDateTime：最完整的日期格式，包括市区和相对UTC或格林威治的时差
* */


//        1、获取当前的日期时间
//        通过静态工厂方法now()来获取当前时间
        LocalDate now = LocalDate.now();
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println("当前时间："+now.toString());
        System.out.println("当前时间:"+now1.toString());
        //        当前时间：2020-08-31
        //        当前时间:2020-08-31T16:50:59.020

//        2、获取当前的年月日分秒
//        获取时间后,直接get获取年月日时分秒
        LocalDateTime now2 = LocalDateTime.now();
        System.out.println("当前年："+now2.getYear());
        System.out.println("当前月："+now2.getMonth());
        System.out.println("当前日："+now2.getDayOfMonth());
        System.out.println("当前小时："+now2.getHour());
        System.out.println("当前分："+now2.getMinute());
        System.out.println("当前时间："+now2.toString());

//        3、格式化时间
//        格式化时间需要用到DateTimeFormatter类
        LocalDateTime now3 = LocalDateTime.now();
        System.out.println("格式化时间："+now3.format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss")));

//        4、时间增减
//        时间后移plus，时间前移minus，指定年份withyear
        LocalDateTime now4 = LocalDateTime.now();
        System.out.println("后五天时间："+now4.plusDays(5));
        System.out.println("前五天时间："+now4.minusDays(5).format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm:ss")));
        System.out.println("前一个月时间："+now4.minusMonths(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd  HH:mm：ss")));
        System.out.println("后一个月时间："+now4.plusMonths(1));
        System.out.println("指定2099年当前时间："+now4.withYear(2099));

//        5、创建指定时间
//        通过指定年月日来创建
        LocalDate of = LocalDate.of(2018, 02, 11);
        System.out.println("指定的时间为："+of);

//        6、时间差比较
//        a.具体相差的年月日
        LocalDate parse = LocalDate.parse("2017-02-03");
        LocalDate parse1 = LocalDate.parse("2019-03-23");
        Period between = Period.between(parse, parse1);
        System.out.println("相差年："+between.getYears()+"相差月："+between.getMonths()+"相差日:"+between.getDays());


    }
}
