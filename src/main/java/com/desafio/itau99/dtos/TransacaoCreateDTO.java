package com.desafio.itau99.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class TransacaoCreateDTO {
    @NotNull()
    @PositiveOrZero()
    private Double valor;

    @NotNull()
    @PastOrPresent()
    private LocalDateTime dataHora;
}
