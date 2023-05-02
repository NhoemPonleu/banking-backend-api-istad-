package com.example.api.mapper;

import com.example.api.dto.AccountTypeDto;
import com.example.api.dto.UpdateAccountDto;
import com.example.api.model.AccountType;
import com.example.api.model.User;
import com.example.api.provider.AccountTypeProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface AccountTypeMapper {
    @SelectProvider(type = AccountTypeProvider.class,method = "bulidSelectSql")
    List<AccountType>selectAllAccount();
    @InsertProvider(type = AccountTypeProvider.class,method = "insertAccount")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insertAccountType(AccountType accountType);
   @DeleteProvider(type = AccountTypeProvider.class,method = "deleteAccountTypeById")
   int deleteById(int id);
   @SelectProvider(type = AccountTypeProvider.class,method = "getAccountTypeById1")
    Optional<AccountType> slectById(@Param("id") Integer id);
    @Select("SELECT EXISTS (SELECT * FROM account_types WHERE id=#{id})")
    boolean existById(@Param("id") Integer id);
    @DeleteProvider(type = AccountTypeProvider.class,method = "deleteIdUser")
    void deleteAccountTpeById(@Param("id") Integer id);

    @UpdateProvider(type = AccountTypeProvider.class,method = "updateAccountTypeById")
    void updateAccountType(@Param("a") AccountType Type);
}
