package br.com.leo.desafio_itau.controllers;

import br.com.leo.desafio_itau.entities.Statistic;
import br.com.leo.desafio_itau.entities.Transaction;
import br.com.leo.desafio_itau.services.statistic.StatisticListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estatistica")
public class StatisticController {
    private final StatisticListService statisticListService;

    @Autowired
    public StatisticController(StatisticListService statisticListService) {
        this.statisticListService = statisticListService;
    }

    @GetMapping
    public ResponseEntity<Statistic> list() {
        Statistic response = statisticListService.run();
        return ResponseEntity.ok(response);
    }
}
