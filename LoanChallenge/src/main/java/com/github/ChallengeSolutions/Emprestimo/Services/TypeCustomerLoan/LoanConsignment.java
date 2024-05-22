package com.github.ChallengeSolutions.Emprestimo.Services.TypeCustomerLoan;


import com.github.ChallengeSolutions.Emprestimo.Services.TypeLoan.TypeLoan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanConsignment implements TypeCustomerLoan{
    @Override
    public TypeLoan lending(Integer age, BigDecimal income, String uf) {
        if(income.compareTo(new BigDecimal(5000)) >= 0) {
            return TypeLoan.CONSIGNMENT;
        }
        return null;
    }
}
