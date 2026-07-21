package org.example.ordermanagementjpa.dto;
import org.example.ordermanagementjpa.model.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerResponseDto {

    private Integer id;
    private String name;
    private String email;
    private String address;
    private List<OrderResponseDto> orders;
}
