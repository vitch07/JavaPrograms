package org.example.ordermanagementjpa.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemRequestDto {
    @NotNull
    private Integer orderId;
    @NotNull(message = "Product Id should not be Null")
    private Integer productId;
    @NotNull(message = "Quantity is missing please enter the quantity")
    private Integer quantity;
}
