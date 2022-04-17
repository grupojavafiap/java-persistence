package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.ProductDto;
import br.com.fiap.javapersistence.persistence.models.Product;
import br.com.fiap.javapersistence.persistence.repositories.ProductRepository;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    
    @Cacheable(cacheNames = "Product", key="#root.method.name")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public void deleleById(long id)
    {
        productRepository.deleteById(id);
    }

    public Product save(ProductDto productDto)
    {
        var product = new Product();
        BeanUtils.copyProperties(productDto, product);

        return productRepository.save(product);
    }
}
