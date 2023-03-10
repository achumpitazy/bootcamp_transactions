package com.bootcamp.transactions.repository;

import com.bootcamp.transactions.entity.Transaction;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface TransactionsRepository extends ReactiveMongoRepository<Transaction, String> {
	Flux<Transaction> findByCustomerId(String customerId);
}
