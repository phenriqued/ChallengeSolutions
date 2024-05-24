package com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.PasswordValidator;

import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.PasswordException;
import org.springframework.stereotype.Component;

@Component
public class NumericValidator implements PasswordValidator{
    @Override
    public void validate(String password) {
        var numericCharacter = password.chars().anyMatch(Character::isDigit);
        if(!numericCharacter)
            throw new PasswordException("A senha deve possuir pelo menos um dígito númerico");

    }
}
