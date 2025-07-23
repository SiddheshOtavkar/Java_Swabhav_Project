package com.aurionpro.assign1;

import java.util.*;
import java.util.stream.*;
import java.time.LocalDate;

public class EmployeeDemo {
    public static void main(String[] args) {
        List<EmployeeModel> employees = Arrays.asList(
            new EmployeeModel("Amit", 65000, LocalDate.of(2018, 5, 10), "Male"),
            new EmployeeModel("Sita", 85000, LocalDate.of(2016, 3, 15), "Female"),
            new EmployeeModel("Omkar", 75000, LocalDate.of(2019, 1, 20), "Male"),
            new EmployeeModel("Priya", 85000, LocalDate.of(2017, 11, 5), "Female"),
            new EmployeeModel("Ravi", 70000, LocalDate.of(2015, 7, 30), "Male")
        );

        // 1. Employee with max salary
        EmployeeModel maxSalaryEmp = employees.stream()
            .max(Comparator.comparingDouble(EmployeeModel::getSalary))
            .orElse(null);
        System.out.println("Highest salary: " + maxSalaryEmp);

        // 2. Employee with second highest salary
        EmployeeModel secondHighest = employees.stream()
            .sorted(Comparator.comparingDouble(EmployeeModel::getSalary).reversed())
            .distinct()  // not necessary unless duplicates
            .skip(1)
            .findFirst()
            .orElse(null);
        System.out.println("Second highest salary: " + secondHighest);

        // 3. Most senior employee (earliest joiningDate)
        EmployeeModel seniorMost = employees.stream()
            .min(Comparator.comparing(EmployeeModel::getJoiningDate))
            .orElse(null);
        System.out.println("Most senior employee: " + seniorMost);

        // 4. Count employees by gender
        Map<String, Long> genderCount = employees.stream()
            .collect(Collectors.groupingBy(EmployeeModel::getGender, Collectors.counting()));
        System.out.println("Gender count: " + genderCount);
    }
}

