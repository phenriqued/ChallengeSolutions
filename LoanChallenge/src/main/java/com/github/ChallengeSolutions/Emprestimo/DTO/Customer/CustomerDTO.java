package com.github.ChallengeSolutions.Emprestimo.DTO.Customer;

import java.math.BigDecimal;

public record CustomerDTO(
         String cpf,
         String name,
         Integer age,
         BigDecimal income,
         String uf) {
}
