package br.com.fiap.javapersistence.persistence.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fiap.javapersistence.persistence.models.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    @Query(value = "select a from address a where a.cpf = :cpf", nativeQuery = true)
    public List<Address> findAddressByCpf(@Param("cpf") Long cpf);

    @Query(value = "delete from address where cpf = :cpf", nativeQuery = true)
    public void deleteAddressByCpf(@Param("cpf") Long cpf);
}