package com.github.ChallengeSolutions.Emprestimo.Services;

import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.CustomerDTO;
import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.LoansCustomer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
class CustomerServiceTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    private JacksonTester<CustomerDTO> customerDTOJson;


    @Autowired
    private CustomerService customerService;



    @Test
    @DisplayName("Deverá retorna uma lista com os tipos de emprestimos")
    void customerLoanTest() {
        CustomerDTO dto = new CustomerDTO("222.888.444-52", "Jonas test", 26, new BigDecimal(7000), "SP");
        LoansCustomer loansCustomer = customerService.customerLoan(dto);

        assertEquals(loansCustomer.customer(), dto.name());
        assertNotNull(loansCustomer.loans());
        assertFalse(loansCustomer.loans().isEmpty());
    }

    @Test
    @DisplayName("Deverá retornar 400 Bad Request quando não há dados do Cliente")
    void customerLoanTestCenarioDois() throws Exception {
        mockMvc.perform(post("/customer-loans")).andExpect(status().isBadRequest());
    }

}