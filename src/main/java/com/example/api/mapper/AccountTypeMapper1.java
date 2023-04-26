package com.example.api.mapper;

import com.example.api.dto.AccountTypeDto;
import com.example.api.model.AccountType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel="spring")
public interface AccountTypeMapper1 {
    List<AccountTypeDto>toDtoList(List<AccountType>model);
    AccountTypeDto toDto(AccountType model);
}
