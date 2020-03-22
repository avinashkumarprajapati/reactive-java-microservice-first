package com.java8.queries.service;

import com.java8.queries.models.Employee;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeeQueryService {

    /**
     * Question) How many male and female employees are there in the organization?
     * Explaination: For queries such as above where you need to group the input elements, use
     * the Collectors.groupingBy() method. In this query, we use Collectors.groupingBy()
     * method which takes two arguments. We pass Employee::getGender as first argument
     * which groups the input elements based on gender and Collectors.counting() as second
     * argument which counts the number of entries in each group.
     */
    public static Map<String, Long> countMaleFemale(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(employee -> employee.getGender(),
                        Collectors.counting()));
    }

    /* get names of all departments in the organization?
    Use distinct() method after calling map(Employee::getDepartment) on the stream. It will return unique departments.
    */

    public static List<String> getNamesOfAllDepartments(List<Employee> employeeList) {
        return employeeList.stream()
                .map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
    }

    // What is the average age of male and female employees?
    public static Map<String, Double> getAverageAgeOfMaleAndFemale(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy((Employee::getGender), Collectors.averagingInt(Employee::getAge)));
    }

    // Get the details of highest paid employee in the organization?
    public static Employee getHighestPaidEmployee(List<Employee> employeeList) {
       /* return employeeList.stream()
                .sorted((e1, e2) -> {
                    Double e1s = e1.getSalary();
                    Double e2s = e2.getSalary();
                    return (e1s > e2s) ? -1 : (e1s < e2s) ? 1 : 0;
                })
                .limit(1)
                .collect(Collectors.toList()).get(0);
        */

        // other solution
        Optional<Employee> highestPaidEmployeeWrapper =
                employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
        return highestPaidEmployeeWrapper.get();


    }

    // Get the names of all employees who have joined after 2015?
    public static List<Employee> getEmployeesJoinedAfterCertainYear(List<Employee> employeeList, Integer year) {
        return employeeList.stream()
                .filter(employee -> employee.getYearOfJoining() > year)
                .collect(Collectors.toList());
    }


    // What is the average salary of each department?
    public static Map<String, Double> getAverageSalaryOfEachDepartment(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
    }


    // Count the number of employees in each department?
    public static Map<String, Long> countNumberOfEmployeesDepartmentWise(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy((Employee::getDepartment), Collectors.counting()));
    }

    //Get the details of youngest male employee in the product development department?
    public static Employee getYoungestemployeeByDeptAndGender(List<Employee> employeeList, String dept, String gender) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(dept)
                        && employee.getGender().equalsIgnoreCase(gender))
                .min(Comparator.comparing(Employee::getAge)).get();
    }

    //Who has the most working experience in the organization?
    public static Employee getMostExperiencedEmployee(List<Employee> employeeList) {
        return employeeList.stream()
                .min(Comparator.comparing(Employee::getYearOfJoining)).get();
    }

    //How many male and female employees are there in the sales and marketing team?
    public static Map<String, Long> getMaleFemaleEmployeesByDepartment(List<Employee> employeeList, String dept) {
        return employeeList.stream()
                .filter(employee -> employee.getDepartment().equalsIgnoreCase(dept))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
    }

    //What is the average salary of male and female employees?
    public static Map<String, Double> getAvergaeSalaryOfMaleFemaleEmployees(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
    }

    //List down the names of all employees in each department?
    public static Map<String, List<Employee>> getNamesOfEmployeesDepartmentWise(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList()));
    }

    /**
     * *What is the average salary and total salary of the whole organization?
     * For this query, we use Collectors.summarizingDouble() on Employee::getSalary
     * which will return statistics of the employee salary like max, min, average and total
     */

    public static DoubleSummaryStatistics getAverageSalaryAndTotalSalary(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
    }

    /**
     * Separate the employees who are younger or equal to 25 years from those employees who are older than 25 years.
     * For this query, we will be using Collectors.partitioningBy()
     * method which separates input elements based on supplied Predicate.
     */
    public static Map<Boolean, List<Employee>> seperateEmployeesOnBasisOfAge(List<Employee> employeeList) {
        return employeeList.stream()
                .collect(Collectors.partitioningBy(e -> e.getAge() >= 25));
    }

    //Who is the oldest employee in the organization? What is his age and which department he belongs to?
    public static Employee getOldestEmployeeOfOrganization(List<Employee> employeeList) {
        return employeeList.stream()
                .max(Comparator.comparing(Employee::getYearOfJoining)).get();
    }
}
