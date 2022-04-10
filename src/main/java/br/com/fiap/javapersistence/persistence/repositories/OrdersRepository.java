package br.com.fiap.javapersistence.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.javapersistence.persistence.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    @Query(value = "select a.id, a.totalPrice from orders a where a.cpf = :cpf", nativeQuery = true)
    public List<Orders> findOrdersByCpf(@Param("cpf") Long cpf);
}
