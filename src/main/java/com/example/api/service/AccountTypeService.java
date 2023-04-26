package com.example.api.service;

import com.example.api.dto.AccountTypeDto;
import com.example.api.model.AccountType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountTypeService {
    List<AccountTypeDto> findAllAccount() ;
    AccountType insertAccount(AccountType accountType);
    AccountType deleteAccountById(int id);

}
