package org.example.ordermanagementjpa.repository;

import org.example.ordermanagementjpa.model.Customer;
import org.example.ordermanagementjpa.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findByCustomer(Customer customer);
}
