package com.company;

public interface Employee extends Comparable<Employee> {
    public int getMonthSalary();

    @Override
    default int compareTo(Employee o) {
        return Integer.compare(getMonthSalary(), o.getMonthSalary());
    }
}
