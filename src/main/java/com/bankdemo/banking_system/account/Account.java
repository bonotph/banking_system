package com.bankdemo.banking_system.account;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Account {
    @Id
    @SequenceGenerator(
        name = "account_sequence",
        sequenceName = "account_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator = "account_sequence"
    )
    private Long accountID;
    private String name;
    private String currency;
    private Double balance;
    private String type;


    public Account(){};
    public Account(
        String name,
        String currency,
        Double balance,
        String type
    ){
        this.name = name;
        this.currency = currency;
        this.balance = balance;
        this.type = type;
    }
    
    public Long getID(){
        return accountID;    
    }
    public void setID(Long accountID){
        this.accountID = accountID;
    }

    public String getName(){
        return name;    
    }
    public void setName(String name){
        this.name = name;
    }

    public String getCurrency(){
        return currency;    
    }
    public void setCurrency(String currency){
        this.currency = currency;
    }

    public Double getBalance(){
        return balance;
    }
    public void setBalance(Double balance){
        this.balance = balance;
    }

    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }

}