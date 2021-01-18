package Oop;

import java.util.Random;

/**
 * author: zijiezhou
 * Date:   2020/9/27 15:53
 * Description:
 */
public class conEmployee {
    private static int nextId;
    private int id;
    private String name = "";
    private double salary;

    static {
        Random random = new Random();
        nextId = random.nextInt(10000);
    }

    {
       id = nextId;
       nextId++;
    }

    public conEmployee(String n, double s){
        name = n;
        salary = s;
    }

    public conEmployee(double s){
        this("Employee # " + nextId,s );
    }

    public int getId() {
        return id;
    }

    public conEmployee(){

    }

    public static int getNextId() {
        return nextId;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}
