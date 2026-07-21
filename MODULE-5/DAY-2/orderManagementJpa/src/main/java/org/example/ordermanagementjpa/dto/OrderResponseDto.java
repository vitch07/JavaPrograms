package org.example.ordermanagementjpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Integer orderId;

    private Integer customerId;

    private String customerName;

    private List<OrderItemResponseDto> items;
}