package org.example.ordermanagementjpa.service;

import org.example.ordermanagementjpa.dto.CustomerRequestDto;
import org.example.ordermanagementjpa.dto.CustomerResponseDto;
import org.example.ordermanagementjpa.model.Customer;

public interface CustomerService {

    CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto);
    CustomerResponseDto getById(Integer id);
    CustomerResponseDto updateById(Integer id, CustomerRequestDto customer);
    void deleteById(Integer id);

}
