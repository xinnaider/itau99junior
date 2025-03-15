package com.desafio.itau99.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransacaoController  {
    @PostMapping("/transacao")
    public void transacao() {
        System.out.println("Transacao realizada com sucesso!");
    }

    @GetMapping("/transacao/estatistica")
    public void estatistica() {
        System.out.println("Estatistica realizada com sucesso!");
    }
}
