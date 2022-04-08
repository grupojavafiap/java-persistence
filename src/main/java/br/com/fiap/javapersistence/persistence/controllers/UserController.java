package br.com.fiap.javapersistence.persistence.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
public class UserController {
    
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<User>> findAll() 
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable long id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable long id) 
    {
        userService.deleleById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    @PostMapping
    public ResponseEntity<User> save(@RequestBody @Valid UserDto userDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userDto));
    }

}
