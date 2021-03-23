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
    private long id;

    @Column
    @Indexed
    private long transactionTimeInMillis;

    @Column
    private long srcAccountId;

    @Column
    private long destAccountId;

    @Column
    private long amount;

    public long getTransactionTimeInMillis() {
        return transactionTimeInMillis;
    }

    public void setTransactionTimeInMillis(long transactionTimeInMillis) {
        this.transactionTimeInMillis = transactionTimeInMillis;
    }

    public long getSrcAccountId() {
        return srcAccountId;
    }

    public void setSrcAccountId(long srcAccountId) {
        this.srcAccountId = srcAccountId;
    }

    public long getDestAccountId() {
        return destAccountId;
    }

    public void setDestAccountId(long destAccountId) {
        this.destAccountId = destAccountId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
