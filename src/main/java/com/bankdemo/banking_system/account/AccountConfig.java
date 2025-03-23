package com.bankdemo.banking_system.account;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountConfig {

    @Bean
    CommandLineRunner commandLineRunner(AccountRepository accountRepository){
        return args -> {
            Account Bono = new Account("bono","HKD",0.0, "broke");
            
            accountRepository.saveAll(java.util.List.of(Bono));
        };
    }
}
