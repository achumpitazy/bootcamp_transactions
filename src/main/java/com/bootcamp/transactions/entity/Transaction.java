package com.bootcamp.transactions.entity;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection="transactions")
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
	private String amount;
	@NotEmpty
	private String transactionDate;
}
