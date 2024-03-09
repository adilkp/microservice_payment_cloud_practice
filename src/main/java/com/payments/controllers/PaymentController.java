package com.payments.controllers;

import com.payments.entities.Transaction;
import com.payments.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public Transaction create(@RequestBody Transaction transaction) {
        return paymentService.add(transaction);
    }

    @GetMapping("{txn_id}")
    public Transaction getTransaction(@PathVariable Long txn_id) {
        return paymentService.getTransactionById(txn_id);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return paymentService.getAllTransactions();
    }

    @GetMapping("user/{user_id}")
    public List<Transaction> getTransactionByUserId(@PathVariable Long user_id) {
        return paymentService.getTransactionByUserId(user_id);
    }

}
