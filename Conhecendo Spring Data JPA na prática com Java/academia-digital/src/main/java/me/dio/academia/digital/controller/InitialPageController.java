package me.dio.academia.digital.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialPageController {
    @GetMapping("/")
    public String bemVindo() {
        return "Seja Bem-Vindo à minha Academia Digital";
    }
}
