package com.github.ChallengeSolutions.Emprestimo.Services;

import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.CustomerDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @DisplayName("Devera retorna umaa lista com os tipos de emprestimos")
    void customerLoanTest() {
        CustomerDTO dto = new CustomerDTO("0000000", "test", 26, new BigDecimal(7000), "SP");
        customerService.customerLoan(dto);
    }
}