package com.java8.queries;

import com.java8.queries.database.Initializer;
import com.java8.queries.models.Employee;
import com.java8.queries.models.Mark;
import com.java8.queries.models.Student;
import com.java8.queries.service.EmployeeQueryService;
import com.java8.queries.service.StudentQueryService;

import java.util.List;
import java.util.Map;

public class TestMain {

    static void m1() {
        System.out.println("hello");
    }

    private static List<Student> studentList;
    private static List<Employee> employeeList;

    public static void main(String[] args) {

        studentList = Initializer.initializeStudents(studentList);
        employeeList = Initializer.initializeEmployees(employeeList);

        String queryString = args[0];
        switch (queryString) {
            case "findTopStudents":
                StudentQueryService.findTopStudents(studentList, 2).forEach(System.out::println);
                break;
            case "countMaleFemale":
                System.out.println(EmployeeQueryService.countMaleFemale(employeeList));
                break;
            case "getNamesOfAllDepartments":
                System.out.println(EmployeeQueryService.getNamesOfAllDepartments(employeeList));
                break;
            case "getAverageAgeOfMaleAndFemale":
                System.out.println(EmployeeQueryService.getAverageAgeOfMaleAndFemale(employeeList));
                break;
            case "getHighestPaidEmployee":
                System.out.println(EmployeeQueryService.getHighestPaidEmployee(employeeList));
                break;
            case "getEmployeesJoinedAfterCertainYear":
                System.out.println(EmployeeQueryService.getEmployeesJoinedAfterCertainYear(employeeList, 2015));
                break;
            case "getAverageSalaryOfEachDepartment":
                System.out.println(EmployeeQueryService.getAverageSalaryOfEachDepartment(employeeList));
                break;
            case "countNumberOfEmployeesDepartmentWise":
                System.out.println(EmployeeQueryService.countNumberOfEmployeesDepartmentWise(employeeList));
                break;
            case "getOldestEmployeeOfOrganization":
                System.out.println(EmployeeQueryService.getOldestEmployeeOfOrganization(employeeList));
                break;
            case "seperateEmployeesOnBasisOfAge":
                System.out.println(EmployeeQueryService.seperateEmployeesOnBasisOfAge(employeeList));
                break;
            case "getAverageSalaryAndTotalSalary":
                System.out.println("Average= " + EmployeeQueryService.getAverageSalaryAndTotalSalary(employeeList).getAverage());
                System.out.println("Total= " + EmployeeQueryService.getAverageSalaryAndTotalSalary(employeeList).getSum());
                break;
            case "getNamesOfEmployeesDepartmentWise":
                System.out.println(EmployeeQueryService.getNamesOfEmployeesDepartmentWise(employeeList));
                break;
            case "getAvergaeSalaryOfMaleFemaleEmployees":
                System.out.println(EmployeeQueryService.getAvergaeSalaryOfMaleFemaleEmployees(employeeList));
                break;
            case "getMaleFemaleEmployeesByDepartment":
                System.out.println(EmployeeQueryService.getMaleFemaleEmployeesByDepartment(employeeList, "IT"));
                break;
            case "getMostExperiencedEmployee":
                System.out.println(EmployeeQueryService.getMostExperiencedEmployee(employeeList));
                break;
            case "getYoungestemployeeByDeptAndGender":
                System.out.println(EmployeeQueryService.getYoungestemployeeByDeptAndGender(employeeList, "HR", "Male"));
                break;
            case "program:StaticConcept":
                //program static don't need a reference type inner exec will convert into className first and then call Static Methods
                TestMain tm = null;
                tm.m1();
                break;
            default:
                System.out.println("query string did not match");
                break;
        }
    }


}
