package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.CreateAccountRequest;
import com.abhay.bankease.dto.response.AccountResponse;

import java.util.List;

public interface AccountService {
    AccountResponse create(CreateAccountRequest request);

    List<AccountResponse> myAccounts();

    AccountResponse get(Long id);
}