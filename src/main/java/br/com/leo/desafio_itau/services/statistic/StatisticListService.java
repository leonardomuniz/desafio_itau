package br.com.leo.desafio_itau.services.statistic;

import br.com.leo.desafio_itau.entities.Statistic;
import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.repositories.TransactionRepositoryInMemory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
public class StatisticListService {
    private final TransactionRepositoryInMemory transactionRepositoryInMemory;

    public StatisticListService(TransactionRepositoryInMemory transactionRepositoryInMemory) {
        this.transactionRepositoryInMemory = transactionRepositoryInMemory;
    }

    public Statistic run() {
        List<Transaction> transactionList = transactionRepositoryInMemory.list();

        OffsetDateTime lastSixtySeconds = OffsetDateTime.now().minusSeconds(60);

        List<Transaction> transactionFiltered = transactionList.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(lastSixtySeconds))
                .toList();

        return new Statistic(
                transactionFiltered.size(),
                transactionFiltered.stream().mapToDouble(Transaction::getValor).sum(),
                transactionFiltered.stream().mapToDouble(Transaction::getValor).average().orElse(0.0),
                transactionFiltered.stream().mapToDouble(Transaction::getValor).min().orElse(0.0),
                transactionFiltered.stream().mapToDouble(Transaction::getValor).max().orElse(0.0)
        );
    }
}
