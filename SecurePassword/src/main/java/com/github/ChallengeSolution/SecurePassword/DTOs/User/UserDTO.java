package com.github.ChallengeSolution.SecurePassword.DTOs.User;

import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank
        String nickName,
        @NotBlank
        String password) {

}
