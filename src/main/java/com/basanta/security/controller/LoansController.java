package com.basanta.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoansController {

    @GetMapping("/api/myLoans")
    public String getLoansDetails(){
        return "My Loans are from DB";
    }
}
