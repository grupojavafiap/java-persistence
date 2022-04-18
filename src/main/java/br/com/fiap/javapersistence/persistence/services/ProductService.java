package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;

import br.com.fiap.javapersistence.persistence.dtos.ProductDto;
import br.com.fiap.javapersistence.persistence.models.Product;
import br.com.fiap.javapersistence.persistence.repositories.ProductRepository;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    

    @Cacheable(value = "allProduct", unless= "#result.size() == 0")
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Cacheable(value= "productCache", key= "#id")
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

	@Caching(
		evict= { 
			@CacheEvict(value= "productCache", key= "#id"),
			@CacheEvict(value= "allProduct", allEntries= true)
		}
	)    
    public void deleleById(long id)
    {
        productRepository.deleteById(id);
    }

    @Caching(
		put= { @CachePut(value= "productCache", key= "#product.id") },
		evict= { @CacheEvict(value= "allProduct", allEntries= true) }
	)
    public Product save(ProductDto productDto)
    {
        var product = new Product();
        BeanUtils.copyProperties(productDto, product);

        return productRepository.save(product);
    }
}
