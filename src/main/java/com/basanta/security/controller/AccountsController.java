package com.basanta.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

    @GetMapping("/api/myAccounts")
    public String getAccountsDetails(){
        return "My accounts are from DB";
    }

}
