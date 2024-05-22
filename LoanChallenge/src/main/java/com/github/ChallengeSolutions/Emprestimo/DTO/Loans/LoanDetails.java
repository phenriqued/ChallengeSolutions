package com.github.ChallengeSolutions.Emprestimo.DTO.Loans;

import com.github.ChallengeSolutions.Emprestimo.Services.TypeLoan.TypeLoan;

public record LoanDetails(TypeLoan type, Double interestRate) {
}
