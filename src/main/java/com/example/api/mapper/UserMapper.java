package com.example.api.mapper;

import com.example.api.dto.UserDto;
import com.example.api.model.User;
import com.example.api.provider.UserProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    @InsertProvider(type = UserProvider.class,method = "insertUser")
    void insert(@Param("u") User user);
    @SelectProvider(type = UserProvider.class,method = "buildSelectUser")
    List<User> selectAllUser();
}
