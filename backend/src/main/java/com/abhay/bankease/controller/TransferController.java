package com.abhay.bankease.controller;

import com.abhay.bankease.dto.request.FundTransferRequest;
import com.abhay.bankease.dto.response.TransferResponse;
import com.abhay.bankease.service.TransferService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transfers")
@RequiredArgsConstructor
public class TransferController {
    private final TransferService service;

    @PostMapping
    public TransferResponse transfer(@Valid @RequestBody FundTransferRequest r) {
        return service.transfer(r);
    }

    @GetMapping
    public List<TransferResponse> history() {
        return service.history();
    }
}
