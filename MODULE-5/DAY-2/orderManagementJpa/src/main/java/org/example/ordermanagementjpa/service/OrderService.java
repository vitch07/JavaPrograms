package org.example.ordermanagementjpa.service;

import org.example.ordermanagementjpa.dto.OrderItemResponseDto;
import org.example.ordermanagementjpa.dto.OrderRequestDto;
import org.example.ordermanagementjpa.dto.OrderResponseDto;
import org.example.ordermanagementjpa.model.Customer;
import org.example.ordermanagementjpa.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderService  {

    OrderResponseDto save(OrderRequestDto orderRequestDto);
    OrderResponseDto getById(int id);
    OrderResponseDto update(int id, OrderRequestDto orderRequestDto);
    List<OrderResponseDto> getAll();
    List<OrderResponseDto> getByCustomer(Customer customer);

}
