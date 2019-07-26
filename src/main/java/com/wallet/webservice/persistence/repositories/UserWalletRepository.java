package com.wallet.webservice.persistence.repositories;

import com.wallet.webservice.persistence.entities.UserWallet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserWalletRepository extends MongoRepository<UserWallet, String> {
    public UserWallet getByUsername(String username);
}
