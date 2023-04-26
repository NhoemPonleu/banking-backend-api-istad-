package com.example.api.mapper;

import com.example.api.model.AccountType;
import com.example.api.provider.AccountTypeProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class,method = "bulidSelectSql")
    List<AccountType>selectAllAccount();
    @InsertProvider(type = AccountTypeProvider.class,method = "insertAccount")
    void insertAccountType(AccountType accountType);
   @DeleteProvider(type = AccountTypeProvider.class,method = "deleteAccountTypeById")
   int deleteById(int id);
}
