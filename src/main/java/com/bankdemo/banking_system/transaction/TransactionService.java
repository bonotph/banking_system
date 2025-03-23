package com.bankdemo.banking_system.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bankdemo.banking_system.account.Account;
import com.bankdemo.banking_system.account.AccountRepository;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Autowired
    public TransactionService(AccountRepository accountRepository, TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(Transaction transaction) {
        Account fromAccount = accountRepository.findById(transaction.getFromAccountID())
            .orElseThrow(() -> new RuntimeException("Account not found"));
        
        Account toAccount = accountRepository.findById(transaction.getToAccountID())
            .orElseThrow(() -> new RuntimeException("Account not found"));

        if (fromAccount.getBalance() < transaction.getAmount()) {
            throw new RuntimeException("Insufficient funds");
        }

        fromAccount.setBalance(fromAccount.getBalance() - transaction.getAmount());
        toAccount.setBalance(toAccount.getBalance() + transaction.getAmount());

        transactionRepository.save(transaction);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

    @Transactional
    public void deposit(Transaction transaction) {
        if(transaction.getFromAccountID().equals(transaction.getToAccountID())){
            throw new RuntimeException("Unmatched account");
        }
        Account account = accountRepository.findById(transaction.getFromAccountID())
        .orElseThrow(() -> new RuntimeException("Account not found"));
    
        account.setBalance(account.getBalance() + transaction.getAmount());
        transactionRepository.save(transaction);
        accountRepository.save(account);
    }
}
