package com.desafio.itau99.repositories;

import com.desafio.itau99.dtos.TransacaoCreateDTO;
import com.desafio.itau99.entities.TransacaoEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
@Slf4j
public class TransacaoRepository {
    private final List<TransacaoEntity> transacoes = new ArrayList<>();

    public void save(TransacaoCreateDTO transacao) {
        TransacaoEntity transacaoEntity = new TransacaoEntity(transacao.getValor(), transacao.getDataHora());

        transacoes.add(transacaoEntity);
    }

    public void deleteAll() {
        transacoes.clear();
    }

    public List<TransacaoEntity> where(Function<TransacaoEntity, Boolean> _callback) {
        return transacoes.stream().filter(_callback::apply).toList();
    }

    public List<TransacaoEntity> get() {
        return transacoes;
    }
}
