package com.github.ChallengeSolution.SecurePassword.Controllers.Authentication;


import com.github.ChallengeSolution.SecurePassword.DTOs.User.UserDTO;
import com.github.ChallengeSolution.SecurePassword.Services.User.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/validate-password")
public class AuthenticationController {

    @Autowired
    private UserService service;


    @PostMapping
    public ResponseEntity authenticationPassword(@RequestBody @Valid UserDTO userDTO){
        service.validatePassword(userDTO);
        return ResponseEntity.noContent().build();
    }

}
