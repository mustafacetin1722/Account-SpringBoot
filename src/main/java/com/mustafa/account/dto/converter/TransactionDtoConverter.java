package com.mustafa.account.dto.converter;

import com.mustafa.account.dto.TransactionDto;
import com.mustafa.account.model.Transaction;
import org.springframework.stereotype.Component;

@Component
public class TransactionDtoConverter {

    public TransactionDto convert(Transaction from) {
        return new TransactionDto(from.getId(),
                from.getTransactionType(),
                from.getAmount(),
                from.getTransactionDate());

    }
}
