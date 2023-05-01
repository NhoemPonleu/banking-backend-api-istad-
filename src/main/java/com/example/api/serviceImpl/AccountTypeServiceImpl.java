package com.example.api.serviceImpl;
import com.example.api.dto.AccountTypeDto;
import com.example.api.dto.UpdateAccountDto;
import com.example.api.dto.UserDto;
import com.example.api.mapper.AccountTypeMapper;
import com.example.api.mapper.AccountTypeMapper1;
import com.example.api.model.AccountType;
import com.example.api.model.User;
import com.example.api.service.AccountTypeService;
import io.swagger.v3.oas.models.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
@RequiredArgsConstructor
@Service
@Component
public class AccountTypeServiceImpl implements AccountTypeService {
    private final AccountTypeMapper accountTypeMapper;
    private final AccountTypeMapper1 accountTypeMapper1;
    @Override
    public List<AccountTypeDto> findAllAccount() {
        List<AccountType>accountTypes=accountTypeMapper.selectAllAccount();
     List<AccountTypeDto> list=accountTypes.stream().
                map(accountType ->new AccountTypeDto(accountType.getName())).toList();
        return list;


    }

    @Override
    public AccountTypeDto insertAccount(AccountTypeDto accountTypeDto) {
       AccountType type= accountTypeMapper1.toAccountType(accountTypeDto);
        accountTypeMapper.insertAccountType(type);
        return accountTypeDto;
    }

    @Override
    public AccountTypeDto getAccountById(Integer id) {
       AccountType type= accountTypeMapper.slectById(id)
                .orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Account with %d is not found",id)));
        return accountTypeMapper1.toDto(type);
    }

    @Override
    public AccountType updateAccount(Integer id, AccountType type) {

      AccountTypeDto getId=getAccountById(id);
        BeanUtils.copyProperties(type,getId,"id");
         // accountTypeMapper.updateAccountType(id,type);
        return null;
    }
    @Override
    public Integer deleteAccountTypeById(Integer id) {
        boolean isFound=accountTypeMapper.existById(id);
        if(isFound){
            accountTypeMapper.deleteAccountTpeById(id);
            return id;
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,String
                .format("Account with %d not found"+id));


    }


}
