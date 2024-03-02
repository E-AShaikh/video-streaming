package com.videostreaming.authentication.controller;

import com.videostreaming.authentication.model.Account;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountController {

    @PostMapping("/")
    public Boolean authenticate(@RequestBody Account account) {
        return account.getUserName().equals("e.abushaikh") && account.getPassword().equals("Manifold123");
    }
}
