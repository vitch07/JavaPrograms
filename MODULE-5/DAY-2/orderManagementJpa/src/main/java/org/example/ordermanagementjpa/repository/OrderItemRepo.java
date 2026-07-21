package org.example.ordermanagementjpa.repository;

import org.example.ordermanagementjpa.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepo extends JpaRepository<OrderItem, Integer> {
}
