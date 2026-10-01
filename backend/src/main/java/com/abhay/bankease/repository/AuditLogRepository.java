package com.abhay.bankease.repository;

import com.abhay.bankease.entity.AuditLog;
import com.abhay.bankease.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditLogRepository extends JpaRepository<AuditLog, Long> {
    List<AuditLog> findTop100ByOrderByCreatedAtDesc();

    List<AuditLog> findTop100ByUserOrderByCreatedAtDesc(User user);
}