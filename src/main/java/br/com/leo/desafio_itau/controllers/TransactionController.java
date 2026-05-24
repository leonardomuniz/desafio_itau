package br.com.leo.desafio_itau.controllers;

import br.com.leo.desafio_itau.DTOs.InputTransactionDto;
import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.exceptions.BusinessRuleException;
import br.com.leo.desafio_itau.services.transactions.TransactionInsertService;
import br.com.leo.desafio_itau.services.transactions.TransactionListService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionInsertService transactionInsertService;
    private final TransactionListService transactionListService;

    @Autowired
    public TransactionController(TransactionInsertService transactionInsertService, TransactionListService transactionListService) {
        this.transactionInsertService = transactionInsertService;
        this.transactionListService = transactionListService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> list() {
        List<Transaction> response = transactionListService.run();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody InputTransactionDto input) {

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
