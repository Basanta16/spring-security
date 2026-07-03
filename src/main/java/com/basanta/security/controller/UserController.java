package com.basanta.security.controller;

import com.basanta.security.entity.Customer;
import com.basanta.security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    private ResponseEntity<String> registerUser (@RequestBody Customer customer) {
        try{

           String hashPwd = passwordEncoder.encode(customer.getPassword());
           customer.setPassword(hashPwd);
            Customer savedCustomer = customerRepository.save(customer);
           if(savedCustomer.getId() > 0){
               return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
           }

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occured of :" + e.getMessage());
        }
        return null;
    }
}
