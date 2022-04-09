package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.CustomerDto;
import br.com.fiap.javapersistence.persistence.models.Customer;
import br.com.fiap.javapersistence.persistence.repositories.CustomerRepository;

@Service
public class CustomerService {

    final CustomerRepository userRepository;

    public CustomerService(CustomerRepository userRepository) {
        this.userRepository = userRepository;
    }


    /**
     * Salva o usuário passado.
     * 
     * @param user
     * @return
     */
    public Customer save(CustomerDto customerDto)
    {
        var customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);

        return userRepository.save(customer);
    }

    /**
     * Retorna todos os usuários cadastrados.
     * 
     * @return
     */
    public List<Customer> findAll()
    {
        return userRepository.findAll();
    }

    /**
     * Retorna o usuário a partir do id informado
     * 
     * @param id
     * @return
     */
    public Optional<Customer> findById(long id)
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
