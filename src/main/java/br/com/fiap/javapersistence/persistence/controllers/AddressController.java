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

import br.com.fiap.javapersistence.persistence.dtos.AddressDto;
import br.com.fiap.javapersistence.persistence.models.Address;
import br.com.fiap.javapersistence.persistence.services.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {

    final AddressService addressService;
    
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<List<Address>> findAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Address>> findById(@PathVariable long id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findById(id));
    }

    @GetMapping("/addressbycpf/{cpf}")
    public ResponseEntity<List<Address>> findAddressByCpf(@PathVariable long cpf) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(addressService.findAddressByCpf(cpf));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable long id) 
    {
        addressService.deleleById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/deleteAddress/{cpf}")
    public ResponseEntity<Object> deleteAddressByCpf(@PathVariable long cpf) 
    {
        addressService.deleteAddressByCpf(cpf);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Address> save(@RequestBody @Valid AddressDto addressDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(addressService.save(addressDto));
    }
}
