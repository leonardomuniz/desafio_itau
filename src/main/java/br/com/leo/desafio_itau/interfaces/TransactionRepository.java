package br.com.leo.desafio_itau.interfaces;

import br.com.leo.desafio_itau.entities.Transaction;

import java.util.List;

public interface TransactionRepository {
    void save(Transaction transaction);
    List<Transaction> list();
    void clear();
}
