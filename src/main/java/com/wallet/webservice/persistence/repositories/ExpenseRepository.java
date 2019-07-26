package com.wallet.webservice.persistence.repositories;

import com.wallet.webservice.persistence.entities.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ExpenseRepository extends MongoRepository<Expense, String> {
}
