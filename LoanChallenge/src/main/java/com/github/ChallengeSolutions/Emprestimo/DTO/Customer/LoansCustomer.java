package com.github.ChallengeSolutions.Emprestimo.DTO.Customer;

import com.github.ChallengeSolutions.Emprestimo.DTO.Loans.LoanDetails;

import java.util.List;

public record LoansCustomer(String customer, List<LoanDetails> loans) {
}
