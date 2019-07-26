package com.wallet.webservice.persistence.services;

import com.wallet.webservice.persistence.entities.Expense;
import com.wallet.webservice.persistence.entities.UserWallet;
import com.wallet.webservice.persistence.repositories.UserWalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
public class WalletServiceImpl implements WalletService {

    @Autowired
    private UserWalletRepository walletRepo;

    @Override
    public UserWallet insertUserExpense(String username, Expense expense) throws Exception {
        UserWallet userWallet = this.walletRepo.getByUsername((username));
        if (userWallet == null) {
            throw new Exception("Username not found!");
        } else {
            if (expense.getTag() == null || expense.getTag() == "") {
                throw new Exception("Tag can't be empty!");
            }
            if (expense.getCost() == null || expense.getCost() == 0) {
                throw new Exception("Cost can't be empty or 0!");
            }
            Expense exp = expense;
            exp.setDate(LocalDateTime.now());
            userWallet.getExpenses().add(exp);
            return this.walletRepo.save(userWallet);
        }
    }

    @Override
    public UserWallet insertUser(String username, String name, String surname) throws Exception {
        UserWallet userWallet = this.walletRepo.getByUsername((username));
        if (userWallet == null) {
            userWallet = new UserWallet();
            userWallet.setExpenses(new ArrayList<Expense>());
            userWallet.setUsername(username);
            userWallet.setName(name);
            userWallet.setSurname(surname);
            return this.walletRepo.save(userWallet);
        } else {
            throw new Exception("This user already exists!");
        }
    }

    @Override
    public UserWallet getUserWallet(String username) {
        return this.walletRepo.getByUsername((username));
    }
}
