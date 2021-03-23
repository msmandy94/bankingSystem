package com.example.bankingSystem.model;

/**
 * Created by mandeep.singh on 12:51 PM 23/03/21 Tuesday
 */
public class TransferMoneyDTO {
    long srcAccount;
    long destAccount;
    double amount;

    public long getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(long srcAccount) {
        this.srcAccount = srcAccount;
    }

    public long getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(long destAccount) {
        this.destAccount = destAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
