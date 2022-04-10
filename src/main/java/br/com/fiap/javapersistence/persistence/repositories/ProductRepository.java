package br.com.fiap.javapersistence.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.javapersistence.persistence.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{}
