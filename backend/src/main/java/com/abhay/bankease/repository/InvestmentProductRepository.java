package com.abhay.bankease.repository;

import com.abhay.bankease.entity.InvestmentProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InvestmentProductRepository extends JpaRepository<InvestmentProduct, Long> {
    List<InvestmentProduct> findByActiveTrue();
}