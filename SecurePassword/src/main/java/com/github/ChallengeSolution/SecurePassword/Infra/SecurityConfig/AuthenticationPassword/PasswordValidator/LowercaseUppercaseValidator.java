package com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.PasswordValidator;

import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.PasswordException;
import org.springframework.stereotype.Component;

@Component
public class LowercaseUppercaseValidator implements PasswordValidator{
    @Override
    public void validate(String password) {
        var uppercaseLetter = password.chars().anyMatch(Character::isUpperCase);
        var lowercaseLetter = password.chars().anyMatch(Character::isLowerCase);
        if(!uppercaseLetter || !lowercaseLetter)
            throw new PasswordException("A senha deve possuir pelo menos um caractere maiúsculo e minúsculo");
    }
}
