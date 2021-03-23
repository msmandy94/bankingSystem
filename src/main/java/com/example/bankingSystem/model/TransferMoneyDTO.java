package com.example.bankingSystem.model;

/**
 * Created by mandeep.singh on 12:51 PM 23/03/21 Tuesday
 */
public class TransferMoneyDTO {
    int srcAccount;
    int destAccount;
    double amount;

    public int getSrcAccount() {
        return srcAccount;
    }

    public void setSrcAccount(int srcAccount) {
        this.srcAccount = srcAccount;
    }

    public int getDestAccount() {
        return destAccount;
    }

    public void setDestAccount(int destAccount) {
        this.destAccount = destAccount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
