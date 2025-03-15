package com.desafio.itau99.controllers;

import com.desafio.itau99.dtos.TransacaoCreateDTO;
import com.desafio.itau99.entities.TransacaoEntity;
import com.desafio.itau99.services.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.DoubleSummaryStatistics;

@RestController
public class TransacaoController  {
    TransacaoService transacaoService;

    @PostMapping("/transacao")
    public TransacaoEntity create(@RequestBody @Valid TransacaoCreateDTO transacao) {
        return transacaoService.create(transacao);
    }

    @GetMapping("/transacao/estatistica/{lastSeconds}")
    public DoubleSummaryStatistics estatistica(@PathVariable Long lastSeconds) {
        return transacaoService.estatistica(lastSeconds);
    }
}
