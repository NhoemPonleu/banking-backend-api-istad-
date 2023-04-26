package com.example.api.dto;

import lombok.Builder;
import lombok.ToString;

@Builder
public record UserDto (String name,
                       String gender,
                       String studentCardId,
                       Boolean isStudent){

}
