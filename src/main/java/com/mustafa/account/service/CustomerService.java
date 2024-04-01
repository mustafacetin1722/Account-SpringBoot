package com.mustafa.account.service;

import com.mustafa.account.dto.CustomerDto;
import com.mustafa.account.dto.converter.CustomerDtoConverter;
import com.mustafa.account.exception.CustomerNotFoundException;
import com.mustafa.account.model.Customer;
import com.mustafa.account.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerDtoConverter customerDtoConverter;

    public CustomerService(CustomerRepository customerRepository,
                           CustomerDtoConverter customerDtoConverter) {
        this.customerRepository = customerRepository;
        this.customerDtoConverter = customerDtoConverter;
    }

    protected Customer findCustomerById(String id){
        return this.customerRepository.findById(id).
                orElseThrow(() -> new CustomerNotFoundException("Customer could not find by id: " + id));
    }
    public CustomerDto getCustomerById(String customerId) {
        return customerDtoConverter.convertToCustomerDto(findCustomerById(customerId));
    }
    public List<CustomerDto> getAllCustomer(){
        return customerRepository.findAll()
                .stream().map(customer -> customerDtoConverter.convertToCustomerDto(customer))
                .collect(Collectors.toList());
    }
}
