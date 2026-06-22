package BankDao;

import entity.Customer;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface BankDao {
    void loadCustomers(List<String> records);
    List<Customer> topCustomers(int n);
    Map<String,Double> averageBalanceByAccount();
    Optional<Customer> richestCustomer();
    Set<String> branchesWithMultipleAccountTypes();
    Map<String,List<Customer>> groupCustomersByBranch();
    List<String> suspiciousCustomers();
    Map<String, Optional<Customer>> topCustomerPerBranch();
}
