package com.payments.service.serviceimpl;

import com.payments.entities.Transaction;
import com.payments.exceptions.ResourceNotFoundException;
import com.payments.repositories.PaymentRepository;
import com.payments.service.PaymentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl implements PaymentService {

    private PaymentRepository paymentRepository;

    private UserClient userClient;

    public PaymentServiceImpl(PaymentRepository paymentRepository, UserClient userClient) {
        this.paymentRepository = paymentRepository;
        this.userClient = userClient;
    }

    @Override
    public Transaction add(Transaction t) {
        return paymentRepository.save(t);
    }

    @Override
    public List<Transaction> getAllTransactions() {
        List<Transaction> transactions = paymentRepository.findAll();
        List<Transaction> newTransactions = transactions.stream().map(transaction -> {
            transaction.setUser(userClient.getUserOfTransaction(transaction.getUser_id()));
            return transaction;
        }).collect(Collectors.toList());
        return newTransactions;
    }

    @Override
    public Transaction getTransactionById(Long id) {
        Transaction transaction = paymentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction with id : "+id+" not found !!!"));
        transaction.setUser(userClient.getUserOfTransaction(transaction.getUser_id()));
        return transaction;
    }

    @Override
    public List<Transaction> getTransactionByUserId(Long user_id) {
        return paymentRepository.findByUser_id(user_id);
    }
}
