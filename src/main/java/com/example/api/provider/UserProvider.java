package com.example.api.provider;

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
}
