package br.com.leo.desafio_itau.DTOs;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PositiveOrZero;

import java.time.OffsetDateTime;

public record InputTransacaoDto(
        @NotNull(message = "O valor é obrigatório")
        @PositiveOrZero(message = "O valor da transação deve ser maior ou igual a zero")
        Double valor,

        @NotNull(message = "O data e hora é obrigatório")
        @Past(message = "A data e hora da transação tem que ter acontecido no passado")
        OffsetDateTime dataHora
) { }

