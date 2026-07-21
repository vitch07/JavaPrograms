package org.example.ordermanagementjpa.service;


import org.example.ordermanagementjpa.dto.OrderItemRequestDto;
import org.example.ordermanagementjpa.dto.OrderItemResponseDto;
import org.example.ordermanagementjpa.dto.OrderRequestDto;
import org.example.ordermanagementjpa.dto.OrderResponseDto;
import org.example.ordermanagementjpa.exception.CustomerNotFoundException;
import org.example.ordermanagementjpa.model.Customer;
import org.example.ordermanagementjpa.model.Order;
import org.example.ordermanagementjpa.model.OrderItem;
import org.example.ordermanagementjpa.model.Product;
import org.example.ordermanagementjpa.repository.CustomerRepo;
import org.example.ordermanagementjpa.repository.OrderItemRepo;
import org.example.ordermanagementjpa.repository.OrderRepo;
import org.example.ordermanagementjpa.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderItemServiceImpl implements OrderItemService {
    @Autowired
    private OrderItemRepo orderItemRepository;
    @Autowired
    private OrderRepo orderRepo;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public List<OrderItemResponseDto> getAllOrders() {
        List<OrderItem> orderItems = orderItemRepository.findAll();
        return orderItems.stream()
                .map(orderItem -> new OrderItemResponseDto(
                        orderItem.getId(),
                        orderItem.getOrder().getId(),
                        orderItem.getProduct().getId(),
                        orderItem.getProduct().getName(),
                        orderItem.getQuantity()
                ))
                .toList();
    }

    public OrderItemResponseDto mapToResponse(OrderItem orderItem) {
        OrderItemResponseDto dto = new OrderItemResponseDto();
        dto.setId(orderItem.getId());
        dto.setOrderId(orderItem.getOrder().getId());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setProductName(orderItem.getProduct().getName());
        dto.setQuantity(orderItem.getQuantity());
        return dto;
    }

    public OrderItemResponseDto updateOrderItem(Integer productId, OrderItemRequestDto orderItemRequestDto) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("The Product not found!!"));
        OrderItemResponseDto returnResponseDto = new OrderItemResponseDto();
        returnResponseDto.setProductId(product.getId());
        returnResponseDto.setQuantity(orderItemRequestDto.getQuantity());
        deleteByOrderItem(orderItemRequestDto);
        return returnResponseDto;
    }

    @Override
    public void addOrderItem(OrderItemRequestDto orderItemRequestDto) {
        OrderItem orderItem = new OrderItem();
        orderItem.setQuantity(orderItemRequestDto.getQuantity());
        Order order = orderRepo.findById(orderItemRequestDto.getOrderId()).orElse(null);
        Product product = productRepository.findById(orderItemRequestDto.getProductId()).orElse(null);
        orderItem.setOrder(order);
        orderItem.setProduct(product);
        orderItemRepository.save(orderItem);

    }

    public void deleteByOrderItem(OrderItemRequestDto orderItemRequestDto) {
        orderItemRepository.deleteById(orderItemRequestDto.getProductId());
    }
}