package com.abhay.bankease.controller;

import com.abhay.bankease.dto.request.CreateAccountRequest;
import com.abhay.bankease.dto.response.AccountResponse;
import com.abhay.bankease.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService service;

    @PostMapping
    public ResponseEntity<AccountResponse> create(@Valid @RequestBody CreateAccountRequest r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));
    }

    @GetMapping
    public List<AccountResponse> mine() {
        return service.myAccounts();
    }

    @GetMapping("/{id}")
    public AccountResponse get(@PathVariable Long id) {
        return service.get(id);
    }
}
