package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.FundTransferRequest;
import com.abhay.bankease.dto.response.TransferResponse;

import java.util.List;

public interface TransferService {
    TransferResponse transfer(FundTransferRequest r);

    List<TransferResponse> history();
}