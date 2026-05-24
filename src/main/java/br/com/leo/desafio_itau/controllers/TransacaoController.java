package br.com.leo.desafio_itau.controllers;

import br.com.leo.desafio_itau.DTOs.InputTransacaoDto;
import br.com.leo.desafio_itau.entity.Transacao;
import br.com.leo.desafio_itau.exception.RegraNegocioException;
import br.com.leo.desafio_itau.services.transacao.TransactionInsertService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transacao")
public class TransacaoController {
    private final TransactionInsertService transactionInsertService;

    @Autowired
    public TransacaoController(TransactionInsertService transactionInsertService) {
        this.transactionInsertService = transactionInsertService;
    }

    @PostMapping
    public ResponseEntity<Void> insert(@Valid @RequestBody InputTransacaoDto input) {
        boolean simular = true;
        if (simular) {
            throw new RegraNegocioException("Bora ver o que sai daqui");
        }

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
