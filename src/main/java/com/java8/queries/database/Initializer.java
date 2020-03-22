package com.java8.queries.database;

import com.java8.queries.models.Employee;
import com.java8.queries.models.Mark;
import com.java8.queries.models.Student;

import java.util.ArrayList;
import java.util.List;

public class Initializer {
    private static List<Mark> markList1;
    private static List<Mark> markList2;
    private static List<Mark> markList3;

    public static List<Student> initializeStudents(List<Student> studentList) {
        markList1 = new ArrayList<>();
        markList1.add(new Mark(1, 1, 13, "Science"));
        markList1.add(new Mark(2, 1, 33, "SST"));
        markList1.add(new Mark(3, 1, 83, "Hindi"));

        markList2 = new ArrayList<>();
        markList2.add(new Mark(1, 2, 63, "Science"));
        markList2.add(new Mark(2, 2, 73, "SST"));
        markList2.add(new Mark(3, 2, 83, "Hindi"));

        markList3 = new ArrayList<>();
        markList3.add(new Mark(1, 3, 100, "Science"));
        markList3.add(new Mark(2, 3, 100, "SST"));
        markList3.add(new Mark(3, 3, 100, "Hindi"));

        studentList = new ArrayList<>();
        studentList.add(new Student(1, "Ram", markList1));
        studentList.add(new Student(2, "Shyam", markList2));
        studentList.add(new Student(3, "Shivam", markList3));

        return studentList;
    }

    public static List<Employee> initializeEmployees(List<Employee> employeeList) {
        employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        return employeeList;
    }

}
