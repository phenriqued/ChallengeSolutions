package com.github.ChallengeSolutions.Emprestimo.Services.TypeCustomerLoan;


import com.github.ChallengeSolutions.Emprestimo.Services.TypeLoan.TypeLoan;

import java.math.BigDecimal;


public interface TypeCustomerLoan {
    TypeLoan lending(Integer age, BigDecimal income, String uf);

}
