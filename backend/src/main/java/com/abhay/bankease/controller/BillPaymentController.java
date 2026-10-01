package com.abhay.bankease.controller;

import com.abhay.bankease.dto.request.BillPaymentRequest;
import com.abhay.bankease.dto.response.BillPaymentResponse;
import com.abhay.bankease.service.BillPaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bill-payments")
@RequiredArgsConstructor
public class BillPaymentController {
    private final BillPaymentService service;

    @PostMapping
    public BillPaymentResponse pay(@Valid @RequestBody BillPaymentRequest r) {
        return service.pay(r);
    }

    @GetMapping
    public List<BillPaymentResponse> history() {
        return service.history();
    }
}
