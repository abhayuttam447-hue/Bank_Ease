package com.abhay.bankease.repository;

import com.abhay.bankease.entity.Investment;
import com.abhay.bankease.entity.User;
import com.abhay.bankease.enums.InvestmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InvestmentRepository extends JpaRepository<Investment, Long> {
    List<Investment> findByUserOrderByPurchasedAtDesc(User user);

    Optional<Investment> findByIdAndUser(Long id, User user);

    List<Investment> findByStatus(InvestmentStatus status);
}