package com.example.api.mapper;

import com.example.api.dto.UserDto;
import com.example.api.model.User;
import com.example.api.provider.UserProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Mapper
@Repository
public interface UserMapper {
    @InsertProvider(type = UserProvider.class,method = "insertUser")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    void insert(@Param("u") User user);

    @SelectProvider(type = UserProvider.class,method = "selectById")
    @Result(column = "student_card_id",property = "studentCardId")
    @Result(column = "is_student",property = "isStudent")
    Optional<User> slectById(@Param("id") Integer id);
    @Select("SELECT EXISTS(SELECT * FROM users WHERE id=#{id})")
    boolean existById(@Param("id") Integer id);
    @DeleteProvider(type = UserProvider.class,method = "deleteIdUser")
    void deleteUserById(@Param("id") Integer id);
    @UpdateProvider(type = UserProvider.class,method = "isUpdateIsDeleteUserById")
    void updateisDeletedById(@Param("id") Integer id,@Param("status") boolean status);
//    @UpdateProvider(type = UpdateProvider.class,method = "updateUser")
//    void update(@Param("id")Integer id, User user);

}
