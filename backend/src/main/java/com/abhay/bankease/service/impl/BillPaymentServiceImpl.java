package com.abhay.bankease.service.impl;

import com.abhay.bankease.dto.request.BillPaymentRequest;
import com.abhay.bankease.dto.response.BillPaymentResponse;
import com.abhay.bankease.entity.AuditLog;
import com.abhay.bankease.entity.BankAccount;
import com.abhay.bankease.entity.BillPayment;
import com.abhay.bankease.entity.User;
import com.abhay.bankease.enums.AccountStatus;
import com.abhay.bankease.enums.AuditAction;
import com.abhay.bankease.enums.BillPaymentStatus;
import com.abhay.bankease.exception.BusinessException;
import com.abhay.bankease.exception.ResourceNotFoundException;
import com.abhay.bankease.mapper.BankEaseMapper;
import com.abhay.bankease.repository.AuditLogRepository;
import com.abhay.bankease.repository.BankAccountRepository;
import com.abhay.bankease.repository.BillPaymentRepository;
import com.abhay.bankease.service.BillPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BillPaymentServiceImpl implements BillPaymentService {
    private final BankAccountRepository accounts;
    private final BillPaymentRepository bills;
    private final BaseService base;
    private final BankEaseMapper mapper;
    private final AuditLogRepository audit;

    @Override
    @Transactional
    public BillPaymentResponse pay(BillPaymentRequest r) {
        User u = base.currentUser();
        BankAccount a = accounts.findByIdForUpdate(r.getAccountId()).orElseThrow(() -> new ResourceNotFoundException("Bank account not found"));
        if (!a.getUser().getId().equals(u.getId()))
            throw new BusinessException("You cannot use another user's account");
        if (a.getStatus() != AccountStatus.ACTIVE) throw new BusinessException("Account is not active");
        if (r.getAmount().compareTo(a.getBalance()) > 0) throw new BusinessException("Insufficient account balance");
        a.setBalance(a.getBalance().subtract(r.getAmount()));
        accounts.save(a);
        BillPayment b = BillPayment.builder().referenceNumber("BILL" + UUID.randomUUID().toString().replace("-", "").substring(0, 20).toUpperCase()).user(u).account(a).billerName(r.getBillerName()).billerCategory(r.getBillerCategory()).consumerNumber(r.getConsumerNumber()).amount(r.getAmount()).status(BillPaymentStatus.SUCCESS).build();
        bills.save(b);
        audit.save(AuditLog.builder().user(u).action(AuditAction.BILL_PAYMENT).description("Bill payment " + b.getReferenceNumber() + " for " + r.getAmount()).build());
        return mapper.toBill(b);
    }

    @Override
    public List<BillPaymentResponse> history() {
        return bills.findTop50ByUserOrderByCreatedAtDesc(base.currentUser()).stream().map(mapper::toBill).toList();
    }
}
