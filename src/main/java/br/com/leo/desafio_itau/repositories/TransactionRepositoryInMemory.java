package br.com.leo.desafio_itau.repositories;

import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.interfaces.TransactionRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TransactionRepositoryInMemory implements TransactionRepository {
    private final ConcurrentMap<Long, Transaction> database = new ConcurrentHashMap<>();
    private final AtomicLong generatedId = new AtomicLong(1);

    @Override
    public void save(Transaction transaction) {
       transaction.setId(generatedId.getAndIncrement());
       database.put(transaction.getId(), transaction);
    }

    @Override
    public List<Transaction> list() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void clear() {
        database.clear();
    }
}
