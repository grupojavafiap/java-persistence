package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.UserDto;
import br.com.fiap.javapersistence.persistence.models.User;
import br.com.fiap.javapersistence.persistence.repositories.UserRepository;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Salva o usuário passado.
     * 
     * @param user
     * @return
     */
    public User save(UserDto userDto)
    {
        var user = new User();
        BeanUtils.copyProperties(userDto, user);

        return userRepository.save(user);
    }

    /**
     * Retorna todos os usuários cadastrados.
     * 
     * @return
     */
    public List<User> findAll()
    {
        return userRepository.findAll();
    }

    /**
     * Retorna o usuário a partir do id informado
     * 
     * @param id
     * @return
     */
    public Optional<User> findById(long id)
    {
        return userRepository.findById(id);
    }


    /**
     * Exclui o usuário com o ID passado.
     * 
     * @param id
     */
    public void deleleById(long id)
    {
         userRepository.deleteById(id);
    }
}
