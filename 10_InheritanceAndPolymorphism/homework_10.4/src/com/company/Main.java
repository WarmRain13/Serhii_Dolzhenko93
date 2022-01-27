package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        Operator operator = new Operator(30000);
        company.hire(operator);
        for (int i = 0; i < 180; i++) {
            company.hire(new Operator(30000));
        }
        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager(40000));
            if (i % 8 == 8) {
                workers.add(new TopManager(50000, company));
            }
        }
        company.hireAll(workers);
        printEmployees(company);
        System.out.println("------------------------------");
        List<com.company.Employee> employees = company.getEmployees();
        int size = employees.size();
        System.out.println(size);
        for (int i = 0; i < size / 2; i++) {
            company.fire(employees.get(i));
        }
        System.out.println(company.getEmployees().size());
    }

    private static void printEmployees(Company company) {
        System.out.println("------------------------------");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(12);
        for (Employee e : topSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
        System.out.println("------------------------------");
        List<Employee> lowSalaryStaff = company.getLowersSalaryStaff(12);
        for (Employee e : lowSalaryStaff) {
            System.out.println(e.getMonthSalary());
        }
    }
}
