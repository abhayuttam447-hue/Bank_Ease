package com.abhay.bankease.repository;

import com.abhay.bankease.entity.Beneficiary;
import com.abhay.bankease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
    List<Beneficiary> findByUser(User user);

    Optional<Beneficiary> findByIdAndUser(Long id, User user);
}