package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.LoanApplicationRequest;
import com.abhay.bankease.dto.request.LoanDecisionRequest;
import com.abhay.bankease.dto.response.LoanResponse;

import java.util.List;

public interface LoanService {
    LoanResponse apply(LoanApplicationRequest r);

    List<LoanResponse> myLoans();

    List<LoanResponse> pending();

    LoanResponse decide(Long id, LoanDecisionRequest r);
}