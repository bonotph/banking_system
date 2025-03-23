package com.bankdemo.banking_system.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping
    public List<Account> getAccount(){
        return accountService.getAccount();
    }

    @GetMapping(path = "{accountID}")
    public Account getAccountByID(@PathVariable("id") Long accountID){
        return accountService.getAccountByID(accountID).orElse(null);
    }

    @PostMapping
    public Account createAccount(@Valid @NonNull @RequestBody Account account){
        return accountService.createAccount(account);
    }
    
    @DeleteMapping(path = "{accountID}")
    public void deleteAccount(@NonNull @PathVariable("id") Long accountID) {
        accountService.deleteAccount(accountID);
    }

    @PutMapping(path = "{accountID}")
    public void updateAccount(@NonNull @PathVariable("id") Long accountID, @NonNull @Valid @RequestBody Account account) {
        accountService.updateAccount(accountID, account);
    }

    
}
