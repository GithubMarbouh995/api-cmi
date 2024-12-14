package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.CustomerDto;


import java.util.List;

public interface CustomerService {
    CustomerDto addCustomer(CustomerDto customerDto);

    void deleteCustomerById(Long id);

    CustomerDto getCustomerById(Long customerId);

    List<CustomerDto> getAllCustomers();
}
