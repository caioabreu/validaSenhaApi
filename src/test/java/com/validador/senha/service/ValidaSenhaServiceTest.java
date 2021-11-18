package com.validador.senha.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ValidaSenhaServiceTest {

    private ValidaSenhaService validaSenhaService;

    @BeforeEach
    public void init() {
        validaSenhaService = new ValidaSenhaService();
    }

    @Test
    public void validaSenhaVaziaRetornaFalso() {
        String entrada = "";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaPequenaRetornaFalso() {
        String entrada = "aa";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaABRetornaFalso() {
        String entrada = "ab";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaLetrasRetornaFalso() {
        String entrada = "AAAbbbCc";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaSoLetrasRepetidasRetornaFalso() {
        String entrada = "AAAbbbCc";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaRepeticaoJuntaRetornaFalso() {
        String entrada = "AbTp9!foo";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaRepeticaoSeparadaRetornaFalso() {
        String entrada = "AbTp9!foA";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaEspacoRetornaFalso() {
        String entrada = "AbTp9 fok";
        var saida = validaSenhaService.isValid(entrada);
        assertFalse(saida);
    }

    @Test
    public void validaSenhaCorretaRetornaTrue() {
        String entrada = "AbTp9!fok";
        var saida = validaSenhaService.isValid(entrada);
        assertTrue(saida);
    }

    @Test
    public void validaSenhaCorretaMaiorNoveRetornaTrue() {
        String entrada = "AbTp9!fok8";
        var saida = validaSenhaService.isValid(entrada);
        assertTrue(saida);
    }

}
