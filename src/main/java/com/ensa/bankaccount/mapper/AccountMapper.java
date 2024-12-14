package com.ensa.bankaccount.mapper;

import com.ensa.bankaccount.dto.AccountDto;
import com.ensa.bankaccount.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountMapper {
    public static AccountDto mapAccountToAccountDTO(Account account){
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account,accountDto);
        return accountDto;
    }
}
