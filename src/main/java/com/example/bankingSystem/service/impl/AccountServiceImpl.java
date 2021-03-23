package com.example.bankingSystem.service.impl;

import com.example.bankingSystem.dao.AccountDao;
import com.example.bankingSystem.entities.DAOAccount;
import com.example.bankingSystem.model.AccountDTO;
import com.example.bankingSystem.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by mandeep.singh on 12:43 PM 23/03/21 Tuesday
 */
@Service
public class AccountServiceImpl implements AccountService {


    @Autowired
    private AccountDao accountDao;


    @Override
    public DAOAccount addAccount(AccountDTO accountDTO) {
        DAOAccount daoAccount = new DAOAccount();
        daoAccount.setCustomerId(accountDTO.getCustomerId());
        daoAccount.setBalance(accountDTO.getBalance());
        daoAccount.setAccountType(accountDTO.getAccountType());
        return accountDao.save(daoAccount);
    }

    @Override
    public DAOAccount linkAccount(long accountId, long customerId) {
        DAOAccount accountDetails = getAccountDetails(accountId);
        accountDetails.setCustomerId(customerId);
        accountDao.save(accountDetails); // todo test
        return accountDetails;
    }

    @Override
    public DAOAccount getAccountDetails(long accountId) {
        return accountDao.findById(accountId);
    }

    @Override
    public boolean transferMoney(long srcAccId, long destAccId, double amount) {
        return false;
    }
}
