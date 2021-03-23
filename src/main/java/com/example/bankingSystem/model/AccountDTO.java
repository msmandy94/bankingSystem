package com.example.bankingSystem.model;

import com.example.bankingSystem.entities.AccountType;

/**
 * Created by mandeep.singh on 12:41 PM 23/03/21 Tuesday
 */
public class AccountDTO {
    private long id;
    private long customerId;
    private double balance;
    private AccountType accountType;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(long customerId) {
        this.customerId = customerId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
}
