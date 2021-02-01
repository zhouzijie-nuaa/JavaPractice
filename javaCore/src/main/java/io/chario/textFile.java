package io.chario;

import Oop.Employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author zzj
 * @date 2021/1/31 15:23
 **/
public class textFile {

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        Employee[] staff = new Employee[3];

        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try (PrintWriter out = new PrintWriter("employee.dat", "UTF-8")) {
            writeData(staff, out);
        }

         try (Scanner in = new Scanner(new FileInputStream("employee.dat"), "UTF-8")) {
             Employee[] newStaff = readData(in);
             for (Employee e : newStaff) {
                 System.out.println(e);
             }
         }
    }

    private static void writeData(Employee[] staff, PrintWriter out) {
        out.println(staff.length);

        for (Employee e : staff) {
            writeEmployee(out, e);
        }
    }

    private static void writeEmployee(PrintWriter out, Employee e) {
        out.println(e.getName() + "|" + e.getSalary() + "|" + e.getHireDay());
    }

    private static Employee[] readData(Scanner in) {
        int n = in.nextInt();
        in.nextLine();

        final Employee[] employees = new Employee[n];
        for (int i = 0; i < n ; i++) {
            employees[i] = readEmployee(in);
        }
        return employees;
    }

    private static Employee readEmployee(Scanner in) {
        final String line = in.nextLine();
        final String[] tokens = line.split("\\|");
        String name = tokens[0];
        final double salary = Double.parseDouble(tokens[1]);
        final LocalDate hireDate = LocalDate.parse(tokens[2]);
        final int year = hireDate.getYear();
        final int month = hireDate.getMonthValue();
        final int day = hireDate.getDayOfMonth();
        return new Employee(name, salary, year, month, day);
    }

}
