package com.github.ChallengeSolution.SecurePassword.Infra.Exceptions;


public class PasswordException extends RuntimeException{
    public PasswordException(String message) {
        super(message);
    }
}
