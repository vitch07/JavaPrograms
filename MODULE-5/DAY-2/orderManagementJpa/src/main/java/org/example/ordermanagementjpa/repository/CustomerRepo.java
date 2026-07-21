package org.example.ordermanagementjpa.repository;

import org.example.ordermanagementjpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Integer> {
}
