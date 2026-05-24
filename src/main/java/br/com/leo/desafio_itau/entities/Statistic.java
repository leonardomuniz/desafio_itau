package br.com.leo.desafio_itau.entities;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Statistic {
    private long count;
    private double sum;
    private double avg;
    private double min;
    private double max;
}
