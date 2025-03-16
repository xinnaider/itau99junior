package com.desafio.itau99.services;

import com.desafio.itau99.dtos.TransacaoCreateDTO;
import com.desafio.itau99.dtos.TransacaoEstatisticaDTO;
import com.desafio.itau99.entities.TransacaoEntity;
import com.desafio.itau99.repositories.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransacaoService {
    private final TransacaoRepository transacaoRepository;

    public void create(TransacaoCreateDTO transacao) {
        log.info("Transação recebida: {}", transacao);

        transacaoRepository.save(transacao);
    }

    public TransacaoEstatisticaDTO estatistica(Long lastSeconds) {
        lastSeconds = Optional.ofNullable(lastSeconds).orElse(60L);

        LocalDateTime limite = LocalDateTime.now().minusSeconds(lastSeconds);

        List<TransacaoEntity> transacoes = transacaoRepository.where(transacao -> transacao.getDataHora().isAfter(limite));

        log.info("Transações realizados nos últimos {} segundos: {}", lastSeconds, transacoes);

        TransacaoEstatisticaDTO stats = new TransacaoEstatisticaDTO(transacoes.stream()
                .mapToDouble(TransacaoEntity::getValor)
                .summaryStatistics());

        log.info("Estatísticas das transações realizadas nos últimos {} segundos: {}", lastSeconds, stats);

        return stats;
    }

    public void deleteAll() {
        log.info("Transações deletadas: {}", transacaoRepository.get());

        transacaoRepository.deleteAll();
    }
}
