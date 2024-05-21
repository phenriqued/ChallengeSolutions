package com.github.ChallengeSolutions.Emprestimo.Entities.Customer;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor
@Getter
@EqualsAndHashCode(of = {"cpf"})
public class CustomerEntity {

    private Long id;
    private String cpf;
    private String name;
    private Integer age;
    private BigDecimal income;
    private String uf;

}
