package com.github.ChallengeSolutions.Emprestimo.Services.TypeLoan;

import lombok.Getter;

@Getter
public enum TypeLoan {
    PERSONAL(4.0),
    GUARANTEED(3.0),
    CONSIGNMENT(2.0);

    private final Double interestRate;
    TypeLoan(Double interestRate) {
        this.interestRate = interestRate;
    }

}
