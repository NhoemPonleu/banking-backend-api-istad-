package com.example.api.provider;

import org.apache.ibatis.jdbc.SQL;
public class AccountTypeProvider {
    public String bulidSelectSql() {
        return new SQL() {{
            SELECT("*");
            FROM("account_types");
        }}.toString();
    }
    public String insertAccount(){
        String sql=new SQL()
                .INSERT_INTO("account_types")
                .VALUES("name","#{name}")
                .toString();
        return sql;
    }
    public String deleteAccountTypeById() {
        return new SQL() {{
            DELETE_FROM("account_types");
            WHERE("id = #{id}");
        }}.toString();
    }

    public String getAccountTypeById1(){
        return new SQL(){{
            SELECT("*");
            FROM("account_types");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String updateAccountTypeById(){
        return new SQL(){{
            UPDATE("account_types");
            SET("name=#{name}");
            WHERE("id=#{id}");
        }}.toString();
    }
    public String deleteIdUser(){
        return new SQL(){{
            DELETE_FROM("account_types");
            WHERE("id=#{id}");
        }}.toString();
    }
}
