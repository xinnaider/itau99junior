package com.desafio.itau99.dtos;

import lombok.Data;

import java.util.DoubleSummaryStatistics;

@Data
public class TransacaoEstatisticaDTO {
    private long count;
    private double sum;
    private double min;
    private double max;
    private double average;

    public TransacaoEstatisticaDTO (DoubleSummaryStatistics stats) {
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.min = stats.getMin();
        this.max = stats.getMax();
        this.average = stats.getAverage();
    }

    /**
     * Retorna o valor mínimo das transações.
     * Se não houver transações (count == 0), retorna 0.0 em vez de Double.POSITIVE_INFINITY do DoubleSummaryStatistics.
     *
     * @return valor mínimo ou 0.0 se não houver dados.
     */
    public double getMin() {
        return count == 0 ? 0.0 : min;
    }

    /**
     * Retorna o valor máximo das transações.
     * Se não houver transações (count == 0), retorna 0.0 em vez de Double.NEGATIVE_INFINITY do DoubleSummaryStatistics.
     *
     * @return valor máximo ou 0.0 se não houver dados.
     */
    public double getMax() {
        return count == 0 ? 0.0 : max;
    }
}
