package com.ensa.bankaccount.web;

import com.ensa.bankaccount.dto.CustomerDto;
import com.ensa.bankaccount.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerRestController {

    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<CustomerDto> addCustomer(@RequestBody CustomerDto customerDto){
        CustomerDto customerDtoSaved = customerService.addCustomer(customerDto);
        return new ResponseEntity<>(customerDtoSaved, HttpStatus.CREATED);
    }
}
