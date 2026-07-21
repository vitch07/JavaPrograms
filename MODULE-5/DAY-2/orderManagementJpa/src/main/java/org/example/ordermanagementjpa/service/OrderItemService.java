package org.example.ordermanagementjpa.service;

import org.example.ordermanagementjpa.dto.OrderItemRequestDto;
import org.example.ordermanagementjpa.dto.OrderItemResponseDto;
import org.example.ordermanagementjpa.dto.OrderResponseDto;
import org.example.ordermanagementjpa.model.Order;
import org.example.ordermanagementjpa.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemService  {
    List<OrderItemResponseDto> getAllOrders();
    void addOrderItem(OrderItemRequestDto orderItemRequestDto);
    OrderItemResponseDto updateOrderItem(Integer productId,OrderItemRequestDto orderItemRequestDto);
    void deleteByOrderItem(OrderItemRequestDto dto);
}
