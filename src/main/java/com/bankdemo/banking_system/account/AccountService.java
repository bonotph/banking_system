package com.bankdemo.banking_system.account;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    
    public List<Account> getAccount(){
        return accountRepository.findAll();
    }

    public Optional<Account> getAccountByID(Long accountID){
        return accountRepository.findById(accountID);
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }
 
    public void deleteAccount(Long accountID) {
        boolean exists = accountRepository.existsById(accountID);
        if(!exists){
            throw new IllegalStateException("account not found");
        }
        accountRepository.deleteById(accountID);
    }

    public void updateAccount( Long accountID, Account account) {
        boolean exists = accountRepository.existsById(accountID);
        if(!exists){
            throw new IllegalStateException("account not found");
        }
        accountRepository.save(account);
    }


}
