package com.example.bankingSystem.model;

/**
 * Created by mandeep.singh on 10:54 AM 23/03/21 Tuesday
 */
public class CustomerDTO {
    int customerId;
    String customerName;
    boolean kycDone;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public boolean isKycDone() {
        return kycDone;
    }

    public void setKycDone(boolean kycDone) {
        this.kycDone = kycDone;
    }
}
