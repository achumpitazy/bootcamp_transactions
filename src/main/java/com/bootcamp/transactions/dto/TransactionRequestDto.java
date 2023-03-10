package com.bootcamp.transactions.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class TransactionRequestDto {
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
