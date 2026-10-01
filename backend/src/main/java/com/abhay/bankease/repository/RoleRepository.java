package com.abhay.bankease.repository;

import com.abhay.bankease.entity.Role;
import com.abhay.bankease.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleType name);
}