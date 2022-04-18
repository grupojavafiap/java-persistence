package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.AddressDto;
import br.com.fiap.javapersistence.persistence.models.Address;
import br.com.fiap.javapersistence.persistence.repositories.AddressRepository;


import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;


@Service
public class AddressService {

    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Cacheable(value = "allAddress", unless= "#result.size() == 0")
    public List<Address> findAll() {
        return addressRepository.findAll();        
    }
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    @Caching(
		evict= { 
			@CacheEvict(value= "addressCache", key= "#id"),
			@CacheEvict(value= "allAddress", allEntries= true)
		}
	) 
    public void deleleById(long id)
    {
        addressRepository.deleteById(id);
    }

    @Caching(
		put= { @CachePut(value= "addressCache", key= "#address.id") },
		evict= { @CacheEvict(value= "allAddress", allEntries= true) }
	)
    public Address save(AddressDto addressDto)
    {
        var address = new Address();
        BeanUtils.copyProperties(addressDto, address);

        return addressRepository.save(address);
    }
    
}
