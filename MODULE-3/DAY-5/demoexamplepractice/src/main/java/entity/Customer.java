package entity;

public final class Customer {
    private final String customerId;
    private final String customerName;
    private final String branch;
    private final String accountType;
    private final double balance;
    private final int age;


    public Customer(String customerId, String customerName, String branch, String accountType, double balance, int age) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.branch = branch;
        this.accountType = accountType;
        this.balance = balance;
        this.age = age;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBranch() {
        return branch;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public int getAge() {
        return age;
    }
}
