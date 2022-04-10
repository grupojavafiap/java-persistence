package br.com.fiap.javapersistence.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.javapersistence.persistence.models.Customer;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query(value = "select a.id, a.cpf, a.name, a.email, a.gender, a.username from customer a where a.cpf = :cpf", nativeQuery = true)
    public List<Customer> findByCpf(@Param("cpf") Long cpf);
}