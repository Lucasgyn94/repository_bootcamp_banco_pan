package com.example.dioclass.rdswithapirest.myFirstApi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {
    // ficam os atributos e métodos
    private final PersonRepository repositoryPerson;

    public PersonController(PersonRepository repository) {
        this.repositoryPerson = repository;
    }

    @GetMapping("/")
    public String helloWorld(){
        return "Essa é a minha primeira API no Spring Boot";
    }

    // metodos de requisição
    @GetMapping("/persons")
    public List<Person> personFindAll(){
        return repositoryPerson.findAll();
    }

    @GetMapping("/persons/{id}")
    public Optional<Person> consulteById(@PathVariable Long id){
        return repositoryPerson.findById(id);
    }
}
