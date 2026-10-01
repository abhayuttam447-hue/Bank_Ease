package com.abhay.bankease.service;

import com.abhay.bankease.dto.request.BeneficiaryRequest;
import com.abhay.bankease.dto.response.BeneficiaryResponse;

import java.util.List;

public interface BeneficiaryService {
    BeneficiaryResponse add(BeneficiaryRequest r);

    List<BeneficiaryResponse> list();

    void deactivate(Long id);
}