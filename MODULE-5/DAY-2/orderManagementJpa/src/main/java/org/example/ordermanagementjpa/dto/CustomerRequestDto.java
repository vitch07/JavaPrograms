package org.example.ordermanagementjpa.dto;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ordermanagementjpa.model.Order;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDto {
    @NotBlank(message = "Name is missing please enter the name")
    private String name;
    @NotBlank(message = "Email is missing please enter the email")
    private String email;
    @NotEmpty(message = "Address is missing please enter the address")
    private String address;
}
