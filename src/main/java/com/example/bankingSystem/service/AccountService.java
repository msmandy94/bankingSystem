package com.example.bankingSystem.service;

import com.example.bankingSystem.entities.DAOAccount;
import com.example.bankingSystem.model.AccountDTO;

/**
 * Created by mandeep.singh on 12:39 PM 23/03/21 Tuesday
 */
public interface AccountService {
    DAOAccount addAccount(AccountDTO accountDTO);

    DAOAccount linkAccount(long accountId, long customerId);

    DAOAccount getAccountDetails(long accountId);

    boolean transferMoney(long srcAccId, long destAccId, double amount);
}
