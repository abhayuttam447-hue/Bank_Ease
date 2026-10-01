package com.abhay.bankease.controller;

import com.abhay.bankease.dto.request.LoanApplicationRequest;
import com.abhay.bankease.dto.response.LoanResponse;
import com.abhay.bankease.service.LoanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loans")
@RequiredArgsConstructor
public class LoanController {
    private final LoanService service;

    @PostMapping
    public ResponseEntity<LoanResponse> apply(@Valid @RequestBody LoanApplicationRequest r) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.apply(r));
    }

    @GetMapping
    public List<LoanResponse> mine() {
        return service.myLoans();
    }
}
