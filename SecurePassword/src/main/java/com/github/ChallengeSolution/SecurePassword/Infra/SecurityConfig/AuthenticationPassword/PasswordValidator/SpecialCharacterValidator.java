package com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.PasswordValidator;

import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.PasswordException;
import org.springframework.stereotype.Component;

@Component
public class SpecialCharacterValidator implements PasswordValidator{
    @Override
    public void validate(String password) {
        var special = password.chars().anyMatch(c -> !Character.isLetterOrDigit(c));
        if(!special)
            throw new PasswordException("A senha deve possuir pelo menos um caractere especial (e.g, !@#$%).");
    }
}
