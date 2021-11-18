package com.validador.senha.service;

import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
public class ValidaSenhaService {

    public boolean isValid(String text) {
        String regex = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{9,}$";

        if (!uniqueCharacters(text)) {
            return false;
        }

        return Pattern.compile(regex)
                .matcher(text)
                .matches();
    }

    private boolean uniqueCharacters(String s) {
        return s.chars().filter(e -> Collections.frequency(s.chars().boxed().collect(Collectors.toList()), e) > 1).count() <= 1;
    }
}
