package com.github.ChallengeSolutions.Emprestimo.Services;

import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.CustomerDTO;
import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.LoansCustomer;
import com.github.ChallengeSolutions.Emprestimo.DTO.Loans.LoanDetails;
import com.github.ChallengeSolutions.Emprestimo.Services.TypeCustomerLoan.TypeCustomerLoan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CustomerService {

    @Autowired
    private List<TypeCustomerLoan> listTypeCustomerLoan;

    public LoansCustomer customerLoan(CustomerDTO dto){
        List<LoanDetails> loans = new ArrayList<>();

        var typeLoans = listTypeCustomerLoan.stream()
                .map(loanType -> loanType.lending(dto.age(), dto.income(), dto.uf()))
                .filter(Objects::nonNull)
                .toList();

        typeLoans.forEach(loan -> loans.add(new LoanDetails(loan, loan.getInterestRate())));

        return new LoansCustomer(dto.name(), loans);
    }
}
