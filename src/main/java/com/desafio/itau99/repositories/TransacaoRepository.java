package com.desafio.itau99.repositories;

import com.desafio.itau99.entities.TransacaoEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

@Component
public class TransacaoRepository {
    private List<TransacaoEntity> transacoes = new ArrayList<>();

    public void save(TransacaoEntity transacao) {
        transacoes.add(transacao);
    }

    public void deleteAll() {
        transacoes.clear();
    }

    public List<TransacaoEntity> where(Function<TransacaoEntity, Boolean> _callback) {
        List<TransacaoEntity> transacoesFiltradas = new ArrayList<>();

        for (TransacaoEntity transacao : transacoes) {
            if (_callback.apply(transacao)) {
                transacoesFiltradas.add(transacao);
            }
        }

        return transacoesFiltradas;
    }
}
