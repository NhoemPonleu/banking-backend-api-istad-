package com.example.api.service;

import com.example.api.dto.AccountTypeDto;
import com.example.api.dto.UpdateAccountDto;
import com.example.api.model.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountTypeService {
    List<AccountTypeDto> findAllAccount() ;
    AccountTypeDto insertAccount(AccountTypeDto accountTypeDto);
    AccountTypeDto getAccountById(Integer id);
    AccountType updateAccount(Integer id, AccountType type);
    Integer deleteAccountTypeById(Integer id);

}
