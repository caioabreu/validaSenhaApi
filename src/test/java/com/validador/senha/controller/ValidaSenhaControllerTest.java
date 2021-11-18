package com.validador.senha.controller;

import com.google.gson.Gson;
import com.validador.senha.domain.LoginRequest;
import com.validador.senha.service.ValidaSenhaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ValidaSenhaControllerTest {

    Gson gson = new Gson();
    private ValidaSenhaController validaSenhaController;
    private ValidaSenhaService validaSenhaService;


    @BeforeEach
    public void init() {
        validaSenhaController = new ValidaSenhaController();
        validaSenhaService = new ValidaSenhaService();
    }

    @Test
    public void controllerEntradaFormatoCorretoStatusHttpOk() {
        String entrada = mockLoginRequest();

        var saida = validaSenhaController.validacao(entrada);

        assertEquals(HttpStatus.OK, saida.getStatusCode());
        assertNotNull(saida.getBody());
    }

    @Test
    public void controllerEntradaFormatoIncorretoStatusBadRequest() {
        String entrada = "{jsonErrado}";

        var saida = validaSenhaController.validacao(entrada);

        assertEquals(HttpStatus.BAD_REQUEST, saida.getStatusCode());
    }

    private String mockLoginRequest() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setPassword("aaasdsad");
        return gson.toJson(loginRequest);
    }
}
