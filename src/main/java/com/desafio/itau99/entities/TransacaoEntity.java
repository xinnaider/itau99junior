package com.desafio.itau99.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoEntity {
    private double valor;
    private String dataHora;
}