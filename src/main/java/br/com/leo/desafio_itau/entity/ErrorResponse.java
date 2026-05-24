package br.com.leo.desafio_itau.entity;

import java.time.OffsetDateTime;

public record ErrorResponse(
        OffsetDateTime timestamp,
        Integer status,
        String erro,
        String mensagem,
        String path
) { }
