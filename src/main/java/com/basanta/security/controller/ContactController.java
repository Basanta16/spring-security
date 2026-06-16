package com.basanta.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ContactController {

    @GetMapping("/contacts")
    public String saveContactDetails(){
        return "My Contacts are from DB";
    }
}
