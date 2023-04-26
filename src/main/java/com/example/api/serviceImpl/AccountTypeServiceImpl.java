package com.example.api.serviceImpl;
import com.example.api.dto.AccountTypeDto;
import com.example.api.mapper.AccountTypeMapper;
import com.example.api.mapper.AccountTypeMapper1;
import com.example.api.model.AccountType;
import com.example.api.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
@RequiredArgsConstructor
@Service
public class AccountTypeServiceImpl implements AccountTypeService {
    private final AccountTypeMapper accountTypeMapper;
    @Override
    public List<AccountTypeDto> findAllAccount() {
        List<AccountType>accountTypes=accountTypeMapper.selectAllAccount();
     List<AccountTypeDto> list=accountTypes.stream().
                map(accountType ->new AccountTypeDto(accountType.getName())).toList();
        return list;


    }

    @Override
    public AccountType insertAccount(AccountType accountType) {
        accountTypeMapper.insertAccountType(accountType);
        return accountType;
    }

    @Override
    public AccountType deleteAccountById(int id) {
       int dd=  accountTypeMapper.deleteById(id);
        return null;
    }


}
