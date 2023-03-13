package com.bootcamp.transactions.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="transaction")
public class Transaction {
	@Id
	private String id;
	@NotEmpty
	private String productType;
	@NotEmpty
	private String productId;
	@NotEmpty
	private String customerId;
	@NotEmpty
	private String transactionType;
	@NotEmpty
	private Double amount;
	@NotEmpty
	private Date transactionDate;
	@NotEmpty
	private String customerType;
}
