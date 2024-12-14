package com.ensa.bankaccount.mapper;


import com.ensa.bankaccount.dto.CustomerDto;

import com.ensa.bankaccount.entity.Customer;
import org.springframework.beans.BeanUtils;

public class CustomerMapper {
    public static CustomerDto mapCustomerToCustomerDTO(Customer customer){
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer,customerDto);
        return customerDto;
    }
}
