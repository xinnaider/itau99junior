package com.desafio.itau99.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class TransacaoCreateDTO {
    @NotNull(message = "O valor é obrigatório.")
    @PositiveOrZero(message = "A transação deve ter valor igual ou maior que zero.")
    private Double valor;

    @NotNull(message = "A data/hora é obrigatória.")
    @PastOrPresent(message = "A transação não deve acontecer no futuro.")
    private LocalDateTime dataHora;
}
