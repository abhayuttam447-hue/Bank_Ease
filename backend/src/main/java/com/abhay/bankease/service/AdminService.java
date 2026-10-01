package com.abhay.bankease.service;

import com.abhay.bankease.dto.response.AdminUserResponse;
import com.abhay.bankease.dto.response.UserResponse;
import com.abhay.bankease.enums.KycStatus;

import java.util.List;

public interface AdminService {
    List<AdminUserResponse> users();

    UserResponse updateKyc(Long userId, KycStatus status);

    UserResponse setEnabled(Long userId, boolean enabled);
}