package br.com.leo.desafio_itau.entity;

import java.time.OffsetDateTime;

public record ErroResposta(
        OffsetDateTime timestamp,
        Integer status,
        String erro,
        String mensagem,
        String path
) { }
