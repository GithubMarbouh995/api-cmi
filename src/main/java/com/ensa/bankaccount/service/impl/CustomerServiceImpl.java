package com.ensa.bankaccount.service.impl;

import com.ensa.bankaccount.dto.CustomerDto;
import com.ensa.bankaccount.entity.Customer;
import com.ensa.bankaccount.mapper.CustomerMapper;
import com.ensa.bankaccount.respository.CustomerRepository;
import com.ensa.bankaccount.service.CustomerService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    @Override
    public CustomerDto addCustomer(CustomerDto customerDto) {
        Customer customer =  Customer.builder()
                .username(customerDto.getUsername())
                .cin(customerDto.getCin())
                .build();
        return CustomerMapper.mapCustomerToCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDto getCustomerById(Long customerId) {
        return CustomerMapper.mapCustomerToCustomerDTO(customerRepository.findById(customerId).orElseThrow(()->new RuntimeException("Customer Not Found")));
    }

    @Override
    public List<CustomerDto> getAllCustomers() {
        return customerRepository.findAll().stream().map(CustomerMapper::mapCustomerToCustomerDTO).collect(Collectors.toList());
    }
}
