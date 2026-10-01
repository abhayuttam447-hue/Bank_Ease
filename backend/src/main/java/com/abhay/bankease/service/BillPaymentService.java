package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.BillPaymentRequest;
import com.abhay.bankease.dto.response.BillPaymentResponse;

import java.util.List;

public interface BillPaymentService {
    BillPaymentResponse pay(BillPaymentRequest r);

    List<BillPaymentResponse> history();
}