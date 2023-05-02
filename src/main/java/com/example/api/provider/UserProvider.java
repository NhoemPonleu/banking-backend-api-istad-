package com.example.api.provider;

import com.example.api.filter.UserFilter;
import com.example.api.model.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;
public class UserProvider {
    public String insertUser(@Param("u") User user){
        return  new SQL(){{
            INSERT_INTO("users");
            VALUES("name","#{u.name}");
            VALUES("gender","#{u.gender}");
            VALUES("one_signal_id","#{u.oneSignalId}");
            VALUES("student_card_id","#{u.studentCardId}");
            VALUES("is_student","#{u.isStudent}");
            VALUES("is_deleted","FALSE");
        }}.toString();
    }
    public String buildSelectUser() {
        return new SQL() {{
            SELECT("*");
            FROM("users");
        }}.toString();
    }
    public String selectById(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("id=#{id}","is_deleted=FALSE");
        }}.toString();
    }
    public String deleteIdUser(){
        return new SQL(){{
            DELETE_FROM("users");
            WHERE("id=# {id}");
        }}.toString();
    }
    public String isUpdateIsDeleteUserById(){
        return  new SQL(){{
            UPDATE("users");
            SET("is_deleted=#{status}");
            WHERE("id=#{id}");
        }}.toString();
    }
//    public String updateUser(){
//        return new SQL(){{
//            UPDATE("users");
//            SET("name = #{name}");
//            SET("gender = #{gender}");
//            SET("one_signal_id = #{oneSignalId}")
//            ;SET("is_deleted = #{isDeleted}");
//            SET("is_student = #{isStudent}");
//            SET("student_card_id = #{studentCardId}");
//            WHERE("id = #{id}");
//
//        }}.toString();
//    }
    public String buildSelectSql(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("is_deleted=FALSE");
            ORDER_BY("id DESC");
        }}.toString();
    }
    public String updateUserSql(){
        return  new SQL(){{
            UPDATE("users");
            SET("name=#{name}");
            SET("gender=#{gender}");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String searchByNameUser(UserFilter filter){
        return new SQL(){{
            SELECT("id,name");
            FROM("users");
            if (filter.getId() != null) {
                WHERE("id like #{id}");
            }
            if (filter.getName() != null) {
                WHERE("name like #{name}");
            }

        }}.toString();
    }
    public String searchByName(){
        return  new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("name=#{name}","is_deleted=FALSE");

        }}.toString();
    }
    public String searchMultipleUser(){
        return new SQL(){{
            SELECT("*");
            FROM("users");
            WHERE("name iLIKE CONCAT ('%',#{name.name},'%')");
        }}.toString();
    }
}
