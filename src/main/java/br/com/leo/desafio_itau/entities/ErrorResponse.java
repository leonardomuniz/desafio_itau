package br.com.leo.desafio_itau.entities;

import java.time.OffsetDateTime;

public record ErrorResponse(
        OffsetDateTime timestamp,
        Integer status,
        String erro,
        String mensagem,
        String path
) { }
