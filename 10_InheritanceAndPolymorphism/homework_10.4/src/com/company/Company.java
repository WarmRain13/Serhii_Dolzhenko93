package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Company {
    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public void hire(Employee employee) {
        employees.add(employee);
    }

    public void hireAll(List<Employee> employees) {
        employees.addAll(this.employees);
    }

    public void fire(Employee employee) {
        employees.remove(employee);
    }

    public int getIncome() {
        int income = 0;
        for (Employee e : employees) {
            if (e instanceof Manager) {
                income += ((Manager) e).getSales();
            }
        }
        return income;
    }

    public List<Employee> getTopSalaryStaff(int count) {
        Collections.sort(employees);
        Collections.reverse(employees);
        return new ArrayList<>(employees.subList(0, count));
    }

    public List<Employee> getLowersSalaryStaff(int count) {
        Collections.sort(employees);
        return new ArrayList<>(employees.subList(0, count));
    }
}
