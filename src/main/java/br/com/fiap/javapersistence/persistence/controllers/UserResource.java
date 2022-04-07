package br.com.fiap.javapersistence.persistence.controllers;

import java.util.List;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.javapersistence.persistence.dtos.UserDto;
import br.com.fiap.javapersistence.persistence.models.User;
import br.com.fiap.javapersistence.persistence.services.UserService;

@RestController
@RequestMapping("/user")
public class UserResource {
    
    final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll() 
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable long id) 
    {
        return String.format("Hello %s!", id);
    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserDto userDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

}
