package com.example.api.controller;

import com.example.api.base.BaseRest;
import com.example.api.model.AccountType;
import com.example.api.service.AccountTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.zip.DataFormatException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account-type")
public class AccountTypeController {
    private final AccountTypeService accountTypeService;
    @GetMapping
    public BaseRest<?>selectAllAccount(){
        var accountTypeDtoList=accountTypeService.findAllAccount();
        System.out.println(accountTypeDtoList);
        return BaseRest.builder().status(true).code(200).message("Account have benn found")
                .data(accountTypeDtoList).timestamp(LocalDateTime.now()).build();
    }
    @PostMapping("/add")
    public BaseRest<Object> createAccount(@RequestBody AccountType accountType){
        AccountType acc=accountTypeService.insertAccount(accountType);
     //   accountTypeDto.
    return BaseRest.builder().status(true).code(200).message("Account has been created")
            .data(acc).timestamp(LocalDateTime.now()).build();
    }
   @DeleteMapping("/{id}")
    public BaseRest<?> delete(@PathVariable("id") int id){
        // AccountType dd= accountTypeService.deleteAccountById(id);
        //   accountTypeDto.
        return BaseRest.builder().message("Account has been Delete id="+id)
                .data(accountTypeService.deleteAccountById(id)).timestamp(LocalDateTime.now()).build();
    }

}
