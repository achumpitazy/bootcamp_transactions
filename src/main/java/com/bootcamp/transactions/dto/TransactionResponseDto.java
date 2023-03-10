package com.bootcamp.transactions.dto;

import com.bootcamp.transactions.entity.Transaction;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionResponseDto {
	private Transaction transaction;
	private Message statusDto;
}
