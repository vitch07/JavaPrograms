package org.example.ordermanagementjpa.service;

import org.example.ordermanagementjpa.dto.CustomerRequestDto;
import org.example.ordermanagementjpa.dto.CustomerResponseDto;
import org.example.ordermanagementjpa.exception.CustomerNotFoundException;
import org.example.ordermanagementjpa.model.Customer;
import org.example.ordermanagementjpa.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerServiceImp implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public CustomerResponseDto saveCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = mapToEntity(customerRequestDto);
        customerRepo.save(customer);
        return mapToResponse(customer);
    }

    public CustomerResponseDto mapToResponse(Customer customer){
        CustomerResponseDto response = new CustomerResponseDto();
        response.setId(customer.getId());
        response.setName(customer.getName());
        response.setEmail(customer.getEmail());
        return response;
    }


    public Customer mapToEntity(CustomerRequestDto  customer){
        Customer cust = new Customer();
        cust.setName(customer.getName());
        cust.setEmail(customer.getEmail());
        cust.setAddress(customer.getAddress());
        cust.setOrders(cust.getOrders());
        return cust;
    }

    @Override
    public CustomerResponseDto getById(Integer id) {
        Customer customer = customerRepo.findById(id).orElseThrow
                (() -> new CustomerNotFoundException("The Customer with this ID is not found !!!!"));
        return mapToResponse(customer);
    }

    @Override
    public CustomerResponseDto updateById(Integer id, CustomerRequestDto customer) {
        Customer customer1 = customerRepo.findById(id).orElseThrow
                (() -> new CustomerNotFoundException("The Customer with this ID is not found !!!!"));
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());

        Customer updated_customer = customerRepo.save(customer1);

        return mapToResponse(updated_customer);
    }

    @Override
    public void deleteById(Integer id) {
        Customer customer = customerRepo.findById(id).orElseThrow(()->new CustomerNotFoundException("THe customer is not in the database!!!!!"));
        customerRepo.deleteById(customer.getId());
    }
}
