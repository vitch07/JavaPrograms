package org.example.ordermanagementjpa.service;

import lombok.RequiredArgsConstructor;
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
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;
    private final OrderItemRepo orderItemRepo;
    private final CustomerRepo customerRepo;
    private final ProductRepository productRepository;

    @Override
    public OrderResponseDto save(OrderRequestDto orderRequestDto) {
        Order order = mapToEntity(orderRequestDto);
        Order saveOrder = orderRepo.save(order);
        return mapToResponse(saveOrder);
    }
    @Override
    public OrderResponseDto getById(int id) {
        return null;
    }

    @Override
    public OrderResponseDto update(int id, OrderRequestDto orderRequestDto) {
        return null;
    }

    @Override
    public List<OrderResponseDto> getAll() {
        List<Order> orders = orderRepo.findAll();
        return orders.stream()
                .map(order -> new OrderResponseDto(
                        order.getId(),
                        order.getCustomer().getId(),
                        order.getCustomer().getName(),
                        order.getOrderItems().stream()
                                .map(orderItem ->
                                        new OrderItemResponseDto(
                                        orderItem.getId(),
                                        orderItem.getOrder().getId(),
                                        orderItem.getProduct().getId(),
                                        orderItem.getProduct().getName(),
                                        orderItem.getQuantity()
                                ))
                                .toList()
                ))
                .toList();
    }
    public OrderResponseDto mapToResponse(Order order){
         OrderResponseDto dto = new OrderResponseDto();

    dto.setOrderId(order.getId());
    dto.setCustomerId(order.getCustomer().getId());
    dto.setCustomerName(order.getCustomer().getName());
    List<OrderItemResponseDto> itemDtos = order.getOrderItems()
            .stream()
            .map(this::mapOrderItemToResponse)
            .toList();
    dto.setItems(itemDtos);
    return dto;
}
    private OrderItemResponseDto mapOrderItemToResponse(OrderItem orderItem) {

        OrderItemResponseDto dto = new OrderItemResponseDto();

        dto.setId(orderItem.getId());
        dto.setOrderId(orderItem.getOrder().getId());
        dto.setProductId(orderItem.getProduct().getId());
        dto.setProductName(orderItem.getProduct().getName());
        dto.setQuantity(orderItem.getQuantity());

        return dto;
    }

    public Order mapToEntity(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setOrderDate(orderRequestDto.getOrderDate());
        Customer customer = customerRepo.findById(orderRequestDto.getCustomerId())
                .orElseThrow(() -> new CustomerNotFoundException("The customer is not found!!"));
        order.setCustomer(customer);
        List<OrderItem> items = orderRequestDto.getItems().stream()
                .map(itemRequestDto -> {
                    Product product1 = productRepository.findById(itemRequestDto.getProductId())
                            .orElseThrow(() -> new RuntimeException("Product  not found"));
                    OrderItem orderItem = new OrderItem();
                    orderItem.setProduct(product1);
                    orderItem.setQuantity(itemRequestDto.getQuantity());
                    orderItem.setOrder(order);
                    return orderItem;
                }).toList();
        order.setOrderItems(items);
        return order;
    }

    @Override
    public List<OrderResponseDto> getByCustomer(Customer customer) {

        return List.of();
    }
}
