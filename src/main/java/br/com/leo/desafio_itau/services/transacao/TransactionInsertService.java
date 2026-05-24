package br.com.leo.desafio_itau.services.transacao;

import br.com.leo.desafio_itau.DTOs.InputTransacaoDto;
import br.com.leo.desafio_itau.entity.Transacao;
import org.springframework.stereotype.Service;

@Service
public class TransactionInsertService {

    public void run(InputTransacaoDto transacao) {
        System.out.println(transacao);
    }
}
