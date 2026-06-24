package org.example.weeklyassignment3.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "expenditures")
public class Expenditure {

    @Id
    private String expenseId;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String expenseType;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private String vendor;

    @Column(nullable = false)
    private int priority;

    public Expenditure() {
    }

    public Expenditure(String expenseId, String department,
                       String expenseType, double amount,
                       String vendor, int priority) {
        this.expenseId = expenseId;
        this.department = department;
        this.expenseType = expenseType;
        this.amount = amount;
        this.vendor = vendor;
        this.priority = priority;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}