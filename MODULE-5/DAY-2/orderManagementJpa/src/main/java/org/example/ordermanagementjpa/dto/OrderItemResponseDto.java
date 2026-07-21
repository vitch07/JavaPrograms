package org.example.ordermanagementjpa.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDto {

    @NotNull
    private Integer id;
    @NotNull
    private Integer orderId;
    @NotNull
    private Integer productId;
    @NotBlank
    private String productName;
    private Integer quantity;
}
