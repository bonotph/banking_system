package com.bankdemo.banking_system.transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @CrossOrigin

    @PostMapping("/transfer")
    @Transactional 
    public ResponseEntity<?> transferFunds(@Valid @RequestBody Transaction transaction) {
        transactionService.transfer(transaction);
        return ResponseEntity.ok("Transfer successful");
    }

    @CrossOrigin
    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@Valid @RequestBody Transaction transaction) {
        transactionService.deposit(transaction);
        return ResponseEntity.ok("Deposit successful");
    }
}