package br.com.fiap.javapersistence.persistence.jpa.user;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<User, Long>
{

    /**
     * Retorna as informações do usuário a partir do nome
     * 
     * @param name
     * @return
     */
    User findByName(String name);

    /**
     * Retorna as informações do usuário a partir do id.
     * 
     * @param name
     * @return
     */
    Optional<User> findById(Long id);

}