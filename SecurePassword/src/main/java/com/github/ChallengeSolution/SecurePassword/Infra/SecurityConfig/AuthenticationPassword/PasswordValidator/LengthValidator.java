package com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.PasswordValidator;

import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.PasswordException;
import org.springframework.stereotype.Component;

@Component
public class LengthValidator implements PasswordValidator{
    @Override
    public void validate(String password) {
        if(password.length() <= 7)
            throw new PasswordException("A senha deve possuir pelo menos 8 caracteres");
    }
}
