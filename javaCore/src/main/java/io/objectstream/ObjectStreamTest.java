package io.objectstream;

import Oop.Employee;

import java.io.*;

/**
 * @author zzj
 * @date 2021/2/1 15:19
 **/
public class ObjectStreamTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Employee harry = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        Employee carl = new Employee("Carl Cracker", 80000, 1987, 12, 15);
        Employee tony = new Employee("Tony Tester", 40000, 1990, 3, 15);
        Employee[] staff = new Employee[3];
        staff[0] = carl;
        staff[1] = harry;
        staff[2] = tony;
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employee.dat"))) {
            out.writeObject(staff);
        }
        String s = new String();
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employee.dat"))){
            Employee[] newStaff = (Employee[])in.readObject();
            newStaff[1].raiseSalary(10);
            for (Employee e : newStaff) {
                System.out.println(e);
            }
        }

    }
}
