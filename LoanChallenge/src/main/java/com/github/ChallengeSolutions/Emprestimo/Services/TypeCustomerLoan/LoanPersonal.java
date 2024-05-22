package com.github.ChallengeSolutions.Emprestimo.Services.TypeCustomerLoan;

import com.github.ChallengeSolutions.Emprestimo.Services.TypeLoan.TypeLoan;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class LoanPersonal implements TypeCustomerLoan{
    @Override
    public TypeLoan lending(Integer age, BigDecimal income, String uf) {
        if(income.compareTo(new BigDecimal(3000)) <= 0) {
            return TypeLoan.PERSONAL;
        }else if((income.compareTo(new BigDecimal(3000)) >= 0 && income.compareTo(new BigDecimal(5000)) <= 0)
                || age < 30 && uf.compareToIgnoreCase("SP") == 0){
            return TypeLoan.PERSONAL;
        }
        return null;
    }
}
