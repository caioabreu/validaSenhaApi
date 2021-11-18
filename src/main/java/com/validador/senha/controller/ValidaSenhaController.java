package com.validador.senha.controller;

import com.google.gson.Gson;
import com.validador.senha.domain.LoginRequest;
import com.validador.senha.domain.LoginResponse;
import com.validador.senha.service.ValidaSenhaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidaSenhaController {

    Gson gson = new Gson();
    Logger logger = LoggerFactory.getLogger(ValidaSenhaController.class);
    private ValidaSenhaService validaSenhaService = new ValidaSenhaService();

    @ResponseBody
    @PostMapping(value = "/validacao", consumes = "application/json", produces = "application/json")
    public ResponseEntity<LoginResponse> validacao(@RequestBody String password) {
        try {
            LoginRequest loginRequest = gson.fromJson(password, LoginRequest.class);
            LoginResponse response = new LoginResponse();
            response.setValid(validaSenhaService.isValid(loginRequest.getPassword()));
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Erro - Validacao: ", e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

}
