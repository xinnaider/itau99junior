package com.desafio.itau99.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoEntity {
    private double valor;
    private LocalDateTime dataHora;
}