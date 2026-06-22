package BankDao;

import entity.Customer;

import java.util.*;
import java.util.stream.Collectors;

public class BankDaoImpl implements BankDao{

    Map<String, Customer> customers = new HashMap<>();

    @Override
    public void loadCustomers(List<String> records) {

    }


    @Override
    public List<Customer> topCustomers(int n) {
        customers.values().stream()
                .sorted(Comparator.comparingDouble(Customer::getBalance).reversed())
                .limit(n)
                .collect(Collectors.toList());
        return List.of();
    }

    @Override
    public Map<String, Double> averageBalanceByAccount() {
        return Map.of();
    }

    @Override
    public Optional<Customer> richestCustomer() {
        return Optional.empty();
    }

    @Override
    public Set<String> branchesWithMultipleAccountTypes() {
        return Set.of();
    }

    @Override
    public Map<String, List<Customer>> groupCustomersByBranch() {
        return Map.of();
    }

    @Override
    public List<String> suspiciousCustomers() {
        return List.of();
    }

    @Override
    public Map<String, Optional<Customer>> topCustomerPerBranch() {
        return Map.of();
    }
}
