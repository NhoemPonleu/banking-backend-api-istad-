package com.example.api.filter;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserFilter {
    private Integer id;
    private String name;
}
