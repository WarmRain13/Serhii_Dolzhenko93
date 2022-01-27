package com.company;

public class TopManager extends Worker {

    private Company company;


    public TopManager(int salary, Company company) {
        super(salary);
        this.company = company;
    }

    @Override
    public int getMonthSalary() {
        int salary = super.getMonthSalary();
        int income = company.getIncome();
        if (income > 10_000_000)
            return (int) (salary + salary * 1.5);
        return salary;
    }
}
