package br.com.leo.desafio_itau.services.transacao;

import br.com.leo.desafio_itau.DTOs.InputTransactionDto;
import org.springframework.stereotype.Service;

@Service
public class TransactionInsertService {

    public void run(InputTransactionDto transacao) {
        System.out.println(transacao);
    }
}
