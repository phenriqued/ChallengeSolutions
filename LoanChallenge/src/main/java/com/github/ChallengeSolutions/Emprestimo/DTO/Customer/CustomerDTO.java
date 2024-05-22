package com.github.ChallengeSolutions.Emprestimo.DTO.Customer;

import br.com.caelum.stella.validation.CPFValidator;
import com.github.ChallengeSolutions.Emprestimo.Infra.Exceptions.CustomerException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.math.BigDecimal;
@Valid
public record CustomerDTO(
         @NotBlank
         String cpf,
         @NotBlank
         String name,
         @NotNull
         Integer age,
         @NotNull
         BigDecimal income,
         @NotBlank
         @Pattern(regexp = "^.{2}$")
         String uf) {

    public CustomerDTO{
        if(!validateCpf(cpf)){
            throw new CustomerException("Invalid CPF");
        }
    }

    private Boolean validateCpf(String cpf){
        CPFValidator validator = new CPFValidator();
        try{
            validator.assertValid(cpf);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
