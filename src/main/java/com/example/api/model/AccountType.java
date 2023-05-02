package com.example.api.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class AccountType {
    private  Integer id;
    private String name;
    List<User> user;
}
