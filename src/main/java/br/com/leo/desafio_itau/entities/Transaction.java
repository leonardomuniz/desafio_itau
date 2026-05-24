package br.com.leo.desafio_itau.entities;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transaction {
    private double valor;
    private OffsetDateTime dataHora;
}
