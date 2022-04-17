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

import br.com.fiap.javapersistence.persistence.dtos.ProductDto;
import br.com.fiap.javapersistence.persistence.models.Product;
import br.com.fiap.javapersistence.persistence.services.ProductService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/product")
@Tag(name = "Produtos", description = "Recursos da API de Produtos")
public class ProductController {

    final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    
    @GetMapping
    public ResponseEntity<List<Product>> findAll()
    {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable long id) 
    {
        return ResponseEntity.status(HttpStatus.OK).body(productService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable long id) 
    {
        productService.deleleById(id);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody @Valid ProductDto productDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDto));
    }
}
