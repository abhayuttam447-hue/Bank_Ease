package com.abhay.bankease.service.impl;

import com.abhay.bankease.entity.User;
import com.abhay.bankease.exception.ResourceNotFoundException;
import com.abhay.bankease.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class BaseService {
    private final UserRepository userRepository;

    public User currentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findWithRoleByEmail(email).orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
}
