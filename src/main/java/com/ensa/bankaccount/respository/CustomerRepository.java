package com.ensa.bankaccount.respository;

import com.ensa.bankaccount.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findCustomerByUsername(String username);
}
