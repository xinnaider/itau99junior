package com.desafio.itau99.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Utils", description = "Endpoints auxiliares")
public class UtilsController {
    @GetMapping("/healthcheck")
    public String healthcheck(){
        return "OK";
    }
}
