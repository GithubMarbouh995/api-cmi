package com.ensa.bankaccount.web;

import com.ensa.bankaccount.dto.AccountDto;
import com.ensa.bankaccount.request.BalanceAccountRequest;
import com.ensa.bankaccount.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/account/")
@AllArgsConstructor
public class AccountRestController {

    private AccountService accountService;

    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestParam Long customerId) {
        AccountDto accountDto = accountService.addAccount(customerId);
        return new ResponseEntity<>(accountDto, HttpStatus.CREATED);
    }

    @PutMapping("/deposit")
    public ResponseEntity<Void> deposit(@RequestBody BalanceAccountRequest balanceAccountRequest) {
        accountService.deposit(balanceAccountRequest);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/withdraw")
    public ResponseEntity<Void> withdraw(@RequestBody BalanceAccountRequest balanceAccountRequest) {
        accountService.withdraw(balanceAccountRequest);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccount(@PathVariable Long id) {
        AccountDto accountDto = accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts() {
        List<AccountDto> accounts = accountService.getAllAccounts();
        return ResponseEntity.ok(accounts);
    }

    @GetMapping("customer/{customerId}")
    public ResponseEntity<List<AccountDto>> getAccountsByCustomerId(@PathVariable Long customerId) {
        List<AccountDto> accounts = ((AccountServiceImpl) accountService).getAccountsByCustomerId(customerId);
        return ResponseEntity.ok(accounts);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id) {
        accountService.deleteAccountById(id);
        return ResponseEntity.ok().build();
    }
}
