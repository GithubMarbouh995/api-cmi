package com.ensa.bankaccount.service.impl;

import com.ensa.bankaccount.dto.AccountDto;
import com.ensa.bankaccount.entity.Account;
import com.ensa.bankaccount.entity.Customer;
import com.ensa.bankaccount.mapper.AccountMapper;
import com.ensa.bankaccount.request.BalanceAccountRequest;
import com.ensa.bankaccount.respository.AccountRepository;
import com.ensa.bankaccount.respository.CustomerRepository;
import com.ensa.bankaccount.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    @Override
    public AccountDto addAccount(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        
        Account account = Account.builder()
                .customer(customer)
                .balance(0.0f)
                .build();
        accountRepository.save(account);
        return AccountMapper.mapAccountToAccountDTO(account);
    }

    @Override
    public void deleteAccountById(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        return AccountMapper.mapAccountToAccountDTO(
                accountRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("Account Not Found"))
        );
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        return accountRepository.findAll()
                .stream()
                .map(AccountMapper::mapAccountToAccountDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(BalanceAccountRequest balanceAccountRequest) {
        Account account = accountRepository.findById(balanceAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account Not Found"));
        account.setBalance(account.getBalance() + balanceAccountRequest.getAmount());
        accountRepository.save(account);
    }

    @Override
    public void withdraw(BalanceAccountRequest balanceAccountRequest) {
        Account account = accountRepository.findById(balanceAccountRequest.getAccountId())
                .orElseThrow(() -> new RuntimeException("Account Not Found"));
        if (account.getBalance() < balanceAccountRequest.getAmount()) {
            throw new RuntimeException("Balance not sufficient");
        }
        account.setBalance(account.getBalance() - balanceAccountRequest.getAmount());
        accountRepository.save(account);
    }

    public List<AccountDto> getAccountsByCustomerId(Long customerId) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
        return customer.getAccounts().stream()
                .map(AccountMapper::mapAccountToAccountDTO)
                .collect(Collectors.toList());
    }
}
