package com.desafio.itau99.controllers;

import com.desafio.itau99.dtos.TransacaoCreateDTO;
import com.desafio.itau99.dtos.TransacaoEstatisticaDTO;
import com.desafio.itau99.services.TransacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transacao")
@Tag(name = "Transação", description = "Endpoints para criação e consulta de transações")
@RequiredArgsConstructor
public class TransacaoController  {
    private final TransacaoService transacaoService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody @Valid TransacaoCreateDTO transacao) {
        transacaoService.create(transacao);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/estatistica")
    public ResponseEntity<TransacaoEstatisticaDTO> estatistica(@RequestParam(required = false) Long lastSeconds) {
        TransacaoEstatisticaDTO estatistica = transacaoService.estatistica(lastSeconds);

        return ResponseEntity.status(HttpStatus.OK).body(estatistica);
    }

    @DeleteMapping()
    public ResponseEntity<Object>  deleteAll() {
        transacaoService.deleteAll();

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
