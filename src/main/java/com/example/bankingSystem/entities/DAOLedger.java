package com.example.bankingSystem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.mongodb.core.index.Indexed;

import javax.persistence.*;

/**
 * Created by mandeep.singh on 12:30 PM 23/03/21 Tuesday
 */

@Entity
@Table(name = "ledger")
public class DAOLedger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    @Indexed
    private int transactionTimeInMillis;

    @Column
    private int srcAccountId;

    @Column
    private int destAccountId;

    @Column
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransactionTimeInMillis() {
        return transactionTimeInMillis;
    }

    public void setTransactionTimeInMillis(int transactionTimeInMillis) {
        this.transactionTimeInMillis = transactionTimeInMillis;
    }

    public int getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(int srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public int getDestAccountId() {
        return destAccountId;
    }

    public void setDestAccountId(int destAccountId) {
        this.destAccountId = destAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
