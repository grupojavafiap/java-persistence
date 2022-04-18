package br.com.fiap.javapersistence.persistence.services;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;


import br.com.fiap.javapersistence.persistence.dtos.CustomerDto;
import br.com.fiap.javapersistence.persistence.models.Address;
import br.com.fiap.javapersistence.persistence.models.Customer;
import br.com.fiap.javapersistence.persistence.repositories.CustomerRepository;

@Service
public class CustomerService {

    final CustomerRepository customerRepository;

    public CustomerService(
        CustomerRepository customerRepository) {
            this.customerRepository = customerRepository;
    }


    /**
     * Salva o usuário passado.
     * 
     * @param user
     * @return
     */
    @Caching(
		put= { @CachePut(value= "customerCache", key= "#customer.id") },
		evict= { @CacheEvict(value= "allCustomer", allEntries= true) }
	)
    public Customer save(CustomerDto customerDto)
    {
        var customer = new Customer();
        
        BeanUtils.copyProperties(customerDto, customer);

        if(customerDto.getAddress() != null)
        {
            List<Address> listAddress = new ArrayList<>();
            
            for(int i=0; i<customerDto.getAddress().size(); i++)
            {
                Address address = new Address();
                address.setCep(customerDto.getAddress().get(i).getCep());
                address.setDescription(customerDto.getAddress().get(i).getDescription());
                address.setState(customerDto.getAddress().get(i).getDescription());
                address.setCustomer(customer);
                listAddress.add(address);
            }

            customer.setAddress(listAddress);
        }
        return customerRepository.save(customer);
    }

    /**
     * Retorna todos os usuários cadastrados.
     * 
     * @return
     */
    @Cacheable(value = "allCustomer", unless= "#result.size() == 0")
    public List<Customer> findAll()
    {
        return customerRepository.findAll();
    }

    /**
     * Retorna o usuário a partir do id informado
     * 
     * @param id
     * @return
     */
    @Cacheable(value= "customerCache", key= "#id")
    public Optional<Customer> findById(long id)
    {
        return customerRepository.findById(id);
    }

    @Cacheable(value= "customerCache", key= "#cpf")
    public List<Customer> findByCpf(long cpf)
    {
        return customerRepository.findByCpf(cpf);
    }

    /**
     * Exclui o usuário com o ID passado.
     * 
     * @param id
     */
	@Caching(
		evict= { 
			@CacheEvict(value= "customerCache", key= "#id"),
			@CacheEvict(value= "allCustomer", allEntries= true)
		}
	) 
    public void deleleById(long id)
    {
        customerRepository.deleteById(id);
    }
}
