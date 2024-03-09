package com.payments.service;

import com.payments.entities.Transaction;

import java.util.List;

public interface PaymentService {

    Transaction add(Transaction t);

    List<Transaction> getAllTransactions();

    Transaction getTransactionById(Long id);

    List<Transaction> getTransactionByUserId(Long user_id);
}
