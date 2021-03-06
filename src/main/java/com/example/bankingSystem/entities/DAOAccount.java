package com.example.bankingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.*;

/**
 * Created by mandeep.singh on 10:49 AM 23/03/21 Tuesday
 */

@Entity
@Table(name = "account")
public class DAOAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Indexed
    private int customerId;

    @Column
    private AccountType accountType;

    @Column
    private double balance;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}