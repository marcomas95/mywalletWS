package com.wallet.webservice.persistence.services;

import com.wallet.webservice.persistence.entities.Expense;
import com.wallet.webservice.persistence.entities.UserWallet;

public interface WalletService {
    public UserWallet insertUserExpense(String username, Expense expense) throws Exception;
    public UserWallet insertUser(String username, String name, String surname) throws Exception;
    public UserWallet getUserWallet(String username);

}
