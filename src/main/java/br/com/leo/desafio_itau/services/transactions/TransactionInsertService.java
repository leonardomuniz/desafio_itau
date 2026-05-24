package br.com.leo.desafio_itau.services.transactions;

import br.com.leo.desafio_itau.DTOs.InputTransactionDto;
import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.repositories.TransactionRepositoryInMemory;
import org.springframework.stereotype.Service;

@Service
public class TransactionInsertService {
    private final TransactionRepositoryInMemory transactionRepositoryInMemory;

    public TransactionInsertService(TransactionRepositoryInMemory transactionRepositoryInMemory) {
        this.transactionRepositoryInMemory = transactionRepositoryInMemory;
    }

    public void run(Transaction transacao) {
        transactionRepositoryInMemory.save(transacao);
    }
}
