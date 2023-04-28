package com.example.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
@Builder
public record CreateUserDto(@NotBlank String name,
                            @NotBlank String gender,
                            String studentCardId,
                            Boolean isStudent,
                            @NotNull String oneSignalId) {
}
