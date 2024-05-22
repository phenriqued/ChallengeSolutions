package com.github.ChallengeSolutions.Emprestimo.Controllers;


import com.github.ChallengeSolutions.Emprestimo.DTO.Customer.CustomerDTO;
import com.github.ChallengeSolutions.Emprestimo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-loans")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity loanType(@RequestBody CustomerDTO dto){
        return ResponseEntity.ok().body(customerService.customerLoan(dto));
    }

}
