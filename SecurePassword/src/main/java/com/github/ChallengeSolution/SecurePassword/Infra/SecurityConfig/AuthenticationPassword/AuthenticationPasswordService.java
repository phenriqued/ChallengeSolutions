package com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword;

import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.AggregatePasswordException;
import com.github.ChallengeSolution.SecurePassword.Infra.Exceptions.PasswordException;
import com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.PasswordValidator.PasswordValidator;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class AuthenticationPasswordService {

    @Autowired
    private List<PasswordValidator> passwordValidators;

    public void authenticationPassword(String password) {
        List<String> errors = new ArrayList<>();

        for (PasswordValidator validator : passwordValidators) {
            try {
                validator.validate(password);
            } catch (PasswordException e) {
                errors.add(e.getMessage());
            }
        }
        if (!errors.isEmpty()) {
            throw new AggregatePasswordException(errors);
        }
    }
}
