package com.zzj.reflect;

/**
 * author: zijiezhou
 * Date:   2020/9/6 11:04
 * Description:
 */
public class Student  extends Person{
    public String className;
    public String address;

    public Student(String classname) {
        this.className = classname;
    }
    public Student(String name, int age, String className, String address) {
        super(name, age);
        this.className = className;
        this.address = address;
    }
    public Student(){
        super();
    }

    @Override
    public String toString() {
        return "姓名:"+name+"年龄:"+age+"班级："+className+"地址："+address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
