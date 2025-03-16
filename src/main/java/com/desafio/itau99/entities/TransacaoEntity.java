package com.desafio.itau99.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class TransacaoEntity {
    private double valor;
    private LocalDateTime dataHora;
}