package br.com.leo.desafio_itau.services.transactions;

import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.repositories.TransactionRepositoryInMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionListService {
    private final TransactionRepositoryInMemory transactionRepositoryInMemory;

    public TransactionListService(TransactionRepositoryInMemory transactionRepositoryInMemory) {
        this.transactionRepositoryInMemory = transactionRepositoryInMemory;
    }

    public List<Transaction> run() {
        return transactionRepositoryInMemory.list();
    }
}
