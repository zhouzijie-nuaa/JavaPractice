package com.zzj.reflect;

/**
 * author: zijiezhou
 * Date:   2020/9/6 10:52
 * Description:
 */
public class Person {
    public String name;
    public int age;

    public Person(){

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String ShowInfo(){
        return "name="+name+"age="+age;
    }
}
