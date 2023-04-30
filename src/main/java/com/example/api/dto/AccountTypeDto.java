package com.example.api.dto;

import jakarta.validation.constraints.NotBlank;
import org.mapstruct.Mapper;

public record AccountTypeDto(@NotBlank
                             String name) {
}
