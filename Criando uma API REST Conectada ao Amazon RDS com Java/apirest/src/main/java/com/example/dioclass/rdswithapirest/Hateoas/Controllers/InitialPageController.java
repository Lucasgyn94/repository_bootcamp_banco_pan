package com.example.dioclass.rdswithapirest.Hateoas.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitialPageController {
    @GetMapping("/")
    public String boasVindas() {
        return "bem vindo a minha REST Hateoas";
    }
}
