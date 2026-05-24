package br.com.leo.desafio_itau.entity;

import lombok.*;

import java.time.OffsetDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Transacao {
    private double valor;
    private OffsetDateTime dataHora;
}
