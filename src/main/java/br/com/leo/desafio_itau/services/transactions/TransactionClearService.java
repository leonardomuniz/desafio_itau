package br.com.leo.desafio_itau.services.transactions;

import br.com.leo.desafio_itau.repositories.TransactionRepositoryInMemory;
import org.springframework.stereotype.Service;

@Service
public class TransactionClearService {
    private final TransactionRepositoryInMemory transactionRepositoryInMemory;

    public TransactionClearService(TransactionRepositoryInMemory transactionRepositoryInMemory) {
        this.transactionRepositoryInMemory = transactionRepositoryInMemory;
    }

    public void run() {
        transactionRepositoryInMemory.clear();
    }
}
