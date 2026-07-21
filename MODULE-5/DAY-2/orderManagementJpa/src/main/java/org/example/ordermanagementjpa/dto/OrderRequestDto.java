package org.example.ordermanagementjpa.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class OrderRequestDto {
    @PastOrPresent
    private Date orderDate;
    @NotNull
    private Integer customerId;
    @NotEmpty(message = "Order items are missing please enter the order items")
    private List<OrderItemRequestDto> items;
}