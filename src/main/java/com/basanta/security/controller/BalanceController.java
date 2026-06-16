package com.basanta.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BalanceController {
    @GetMapping("/api/myBalance")
    public String getBalanceDetails(){
        return "My Balance are from DB";
    }
}
