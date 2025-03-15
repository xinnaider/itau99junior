package com.desafio.itau99.services;

import com.desafio.itau99.dtos.TransacaoCreateDTO;
import com.desafio.itau99.entities.TransacaoEntity;
import com.desafio.itau99.repositories.TransacaoRepository;
import jakarta.validation.constraints.Null;

import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Optional;

public class TransacaoService {
    TransacaoRepository transacaoRepository;

    public TransacaoEntity create(TransacaoCreateDTO transacao) {
        return transacaoRepository.save(transacao);
    }

    public DoubleSummaryStatistics estatistica(Long lastSeconds) {
        LocalDateTime limite = LocalDateTime.now().minusSeconds(Optional.ofNullable(lastSeconds).orElse(60L));

        return transacaoRepository.where(transacao -> {
                    return transacao.getDataHora().isAfter(limite);
                })
                .stream()
                .mapToDouble(TransacaoEntity::getValor)
                .summaryStatistics();
    }
}
