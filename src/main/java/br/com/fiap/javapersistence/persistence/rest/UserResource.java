package br.com.fiap.javapersistence.persistence.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {
    

    @GetMapping("/user")
    public String findAll() 
    {
        return String.format("Retornar todos os registros");
    }

    @GetMapping("/user/{id}")
    public String findById(@PathVariable long id) 
    {
        return String.format("Hello %s!", id);
    }

}
