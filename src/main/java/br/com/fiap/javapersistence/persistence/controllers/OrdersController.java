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

import br.com.fiap.javapersistence.persistence.dtos.OrdersDto;
import br.com.fiap.javapersistence.persistence.models.Orders;
import br.com.fiap.javapersistence.persistence.services.OrdersService;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    final OrdersService ordersService;

    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public ResponseEntity<List<Orders>> findAll() 
    {
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Orders>> findById(@PathVariable long id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.findById(id));
    }

    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<List<Orders>> findByCpf(@PathVariable long cpf) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(ordersService.findOrdersByCpf(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable long id) 
    {
        ordersService.deleleById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Orders> save(@RequestBody @Valid OrdersDto ordersDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(ordersService.save(ordersDto));
    }

    
}
