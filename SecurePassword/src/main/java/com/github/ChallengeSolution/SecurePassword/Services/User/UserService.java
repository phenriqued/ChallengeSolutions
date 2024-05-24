package com.github.ChallengeSolution.SecurePassword.Services.User;


import com.github.ChallengeSolution.SecurePassword.DTOs.User.UserDTO;
import com.github.ChallengeSolution.SecurePassword.Infra.SecurityConfig.AuthenticationPassword.AuthenticationPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private AuthenticationPasswordService authenticationPassword;

    public void validatePassword(UserDTO user){
        authenticationPassword.authenticationPassword(user.password());
    }

}
