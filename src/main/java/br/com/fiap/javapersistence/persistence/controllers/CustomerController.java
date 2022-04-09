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

import br.com.fiap.javapersistence.persistence.dtos.CustomerDto;
import br.com.fiap.javapersistence.persistence.models.Customer;
import br.com.fiap.javapersistence.persistence.services.CustomerService;

@RestController
@RequestMapping("/user")
public class CustomerController {
    
    final CustomerService userService;

    public CustomerController(CustomerService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<List<Customer>> findAll() 
    {
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Customer>> findById(@PathVariable long id) 
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
    public ResponseEntity<Customer> save(@RequestBody @Valid CustomerDto customerDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(customerDto));
    }

}
