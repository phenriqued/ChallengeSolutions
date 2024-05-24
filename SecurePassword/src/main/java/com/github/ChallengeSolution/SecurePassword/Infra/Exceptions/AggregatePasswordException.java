package com.github.ChallengeSolution.SecurePassword.Infra.Exceptions;

import lombok.Getter;

import java.util.List;


@Getter
public class AggregatePasswordException extends RuntimeException{

    private final List<String> validatorsException;

    public AggregatePasswordException(List<String> validatorsException) {
        this.validatorsException = validatorsException;
    }
}
