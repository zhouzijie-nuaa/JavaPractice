package com.zzj.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * author: zijiezhou
 * Date:   2020/9/6 11:13
 * Description:
 */
public class TestReflect {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class student =null;//获取student这个类类的对象，可通过这个类对象去获取Student类的实例化对象
        try {
            student=Class.forName("com.zzj.reflect.Student");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Field[] fields = student.getFields();
        for (Field f:fields){
            System.out.println(f);
        }
        System.out.println("_______________________");

        Field[] declaredFields = student.getDeclaredFields();
        for (Field df:declaredFields){
            System.out.println(df);
        }
        System.out.println("_______________________");

        Method[] methods = student.getMethods();
        for (Method m:methods){
            System.out.println(m);
        }
        System.out.println("________________________");

        Method[] declaredMethods = student.getDeclaredMethods();
        for (Method dm:declaredMethods){
            System.out.println(dm);
        }
        System.out.println("____________________________");

        Constructor[] constructors = student.getConstructors();
        for (Constructor c:constructors){
            System.out.println(c);
        }
        System.out.println("____________________________");

        Constructor[] declaredConstructors = student.getDeclaredConstructors();
        for (Constructor dc:declaredConstructors){
            System.out.println(dc);
        }

        Class c = Class.forName("com.zzj.reflect.Student");
        Student stu1 = (Student) c.newInstance();
        stu1.setAddress("浙江丽水");
        System.out.println(stu1);
//      使用默认的构造方法进行实例化，

        Constructor constructor = c.getConstructor(String.class, int.class, String.class, String.class);
        Student stu2 = (Student) constructor.newInstance("zzj", 24, "三班", "浙江丽水");
        System.out.println(stu2);
//        取得全部的构造函数，使用构造函数进行赋值

        Method showInfo = c.getMethod("ShowInfo");
        Object invoke = showInfo.invoke(stu2);
    }
}
