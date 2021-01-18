package Oop;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * author: zijiezhou
 * Date:   2020/9/17 14:56
 * Description:日历测试
 */
public class Calendar {
    public  void  calendar() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon Tue Thu Fri Sat Sun");
        for (int i = 0; i <value ; i++) {
            System.out.println("  ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.println("*");
            }else {
                System.out.println(" ");
            }
            date = date.plusDays(1);
            if(date.getDayOfWeek().getValue() == 1){
                System.out.println();
            }
        }
        if(date.getDayOfWeek().getValue() != 1){
            System.out.println();}

    }
}
