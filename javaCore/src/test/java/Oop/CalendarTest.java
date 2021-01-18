package Oop;

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * author: zijiezhou
 * Date:   2020/9/17 15:06
 * Description:
 */
public class CalendarTest {

    @Test
    public void calendar() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();
        int value = weekday.getValue();

        System.out.println("Mon  Tue  Thu  Fri  Sat  Sun");
        for (int i = 0; i <value ; i++) {
            System.out.print("  ");
        }
        while (date.getMonthValue() == month){
            System.out.printf("%3d", date.getDayOfMonth());
            if(date.getDayOfMonth() == today){
                System.out.print("*");
            }else {
                System.out.print(" ");
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