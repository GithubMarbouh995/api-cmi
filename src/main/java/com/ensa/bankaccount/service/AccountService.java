package com.ensa.bankaccount.service;

import com.ensa.bankaccount.dto.AccountDto;
import com.ensa.bankaccount.request.BalanceAccountRequest;

import java.util.List;

public interface AccountService {
    AccountDto addAccount(Long customerId);
    void deleteAccountById(Long id);
    AccountDto getAccountById(Long id);
    List<AccountDto> getAllAccounts();

    void deposit(BalanceAccountRequest balanceAccountRequest);

    void withdraw(BalanceAccountRequest balanceAccountRequest);



}
