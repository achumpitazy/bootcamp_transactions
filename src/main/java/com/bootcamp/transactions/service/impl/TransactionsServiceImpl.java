package com.bootcamp.transactions.service.impl;

import com.bootcamp.transactions.dto.Message;
import com.bootcamp.transactions.dto.TransactionRequestDto;
import com.bootcamp.transactions.entity.Transaction;
import com.bootcamp.transactions.repository.TransactionsRepository;
import com.bootcamp.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;

	@Override
	public Flux<Transaction> getAll() {
		return transactionsRepository.findAll();
	}

	@Override
	public Mono<Transaction> getTransactionById(String transactionId) {
		return transactionsRepository.findById(transactionId);
	}

	@Override
	public Flux<Transaction> getTransactionByCustomerId(String customerId) {
		return transactionsRepository.findByCustomerId(customerId);
	}

	@Override
	public Mono<Transaction> createTransaction(TransactionRequestDto transactionRequestDto) {
		Transaction transaction = new Transaction(null,transactionRequestDto.getProductType(),
				transactionRequestDto.getProductId(),transactionRequestDto.getCustomerId()
				,transactionRequestDto.getTransactionType(),transactionRequestDto.getAmount(),
				transactionRequestDto.getTransactionDate());
		return transactionsRepository.save(transaction);
	}

	@Override
	public Mono<Transaction> updateTransaction(TransactionRequestDto transactionRequestDto) {
		return transactionsRepository.findById(transactionRequestDto.getId())
				.flatMap(uTransaction -> {
					uTransaction.setProductType(transactionRequestDto.getProductType());
					uTransaction.setProductId(transactionRequestDto.getProductId());
					uTransaction.setCustomerId(transactionRequestDto.getCustomerId());
					uTransaction.setTransactionType(transactionRequestDto.getTransactionType());
					uTransaction.setAmount(transactionRequestDto.getAmount());
					uTransaction.setTransactionDate(transactionRequestDto.getTransactionDate());
					return transactionsRepository.save(uTransaction);
				});
	}

	@Override
	public Mono<Message> deleteTransaction(String transactionId) {
		Message message = new Message("transaction does not exist");
		return transactionsRepository.findById(transactionId)
				.flatMap(dTransaction -> {
					message.setMessage("Person deleted successfully");
					return transactionsRepository.deleteById(dTransaction.getId()).thenReturn(message);
				}).defaultIfEmpty(message);
	}
}
