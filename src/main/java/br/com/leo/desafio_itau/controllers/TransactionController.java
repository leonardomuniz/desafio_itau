package br.com.leo.desafio_itau.controllers;

import br.com.leo.desafio_itau.DTOs.InputTransactionDto;
import br.com.leo.desafio_itau.exceptions.BusinessRuleException;
import br.com.leo.desafio_itau.services.transactions.TransactionInsertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransactionController {
    private final TransactionInsertService transactionInsertService;

    @Autowired
    public TransactionController(TransactionInsertService transactionInsertService) {
        this.transactionInsertService = transactionInsertService;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody InputTransactionDto input) {
        boolean simular = true;
        if (simular) {
            throw new BusinessRuleException("Bora ver o que sai daqui");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
