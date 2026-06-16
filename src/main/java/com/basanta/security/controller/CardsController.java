package com.basanta.security.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardsController {

    @GetMapping("/api/myCards")
    public String getCardsDetails(){
        return "My Cards Details are from DB";
    }

}
