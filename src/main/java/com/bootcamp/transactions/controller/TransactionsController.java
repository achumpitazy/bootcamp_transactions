package com.bootcamp.transactions.controller;

import com.bootcamp.transactions.dto.Message;
import com.bootcamp.transactions.dto.TransactionRequestDto;
import com.bootcamp.transactions.entity.Transaction;
import com.bootcamp.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/transaction")
public class TransactionsController {

	@Autowired
	private TransactionsService transactionsService;

	@GetMapping
	public Flux<Transaction> getAll(){
		return transactionsService.getAll();
	}

	@GetMapping("/{transactionId}")
	public Mono<Transaction> getTransactionById(@PathVariable String transactionId){
		return transactionsService.getTransactionById(transactionId);
	}

	@GetMapping("/customer/{customerId}")
	public Flux<Transaction> getTransactionByCustomerId(@PathVariable String customerId){
		return transactionsService.getTransactionByCustomerId(customerId);
	}

	@PostMapping
	public Mono<Transaction> createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
		return transactionsService.createTransaction(transactionRequestDto);
	}

	@PutMapping
	public Mono<Transaction> updateTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
		return transactionsService.updateTransaction(transactionRequestDto);
	}

	@DeleteMapping("/{transactionId}")
	public Mono<Message> deleteTransaction(@PathVariable String transactionId){
		return transactionsService.deleteTransaction(transactionId);
	}
	
	@GetMapping("/product/{productId}")
	public Flux<Transaction> getAllXProductId(@PathVariable String productId){
		return transactionsService.getAllXProductId(productId);
	}
}
