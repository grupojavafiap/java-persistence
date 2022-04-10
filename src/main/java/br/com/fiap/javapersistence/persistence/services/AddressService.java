package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.AddressDto;
import br.com.fiap.javapersistence.persistence.models.Address;
import br.com.fiap.javapersistence.persistence.repositories.AddressRepository;

@Service
public class AddressService {

    final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> findAll() {
        return addressRepository.findAll();        
    }
    public Optional<Address> findById(Long id) {
        return addressRepository.findById(id);
    }

    public List<Address> findAddressByCpf(Long cpf) {
        return addressRepository.findAddressByCpf(cpf);
    }

    public void deleleById(long id)
    {
        addressRepository.deleteById(id);
    }

    public void deleteAddressByCpf(long cpf)
    {
        addressRepository.deleteAddressByCpf(cpf);
    }

    public Address save(AddressDto addressDto)
    {
        var address = new Address();
        BeanUtils.copyProperties(addressDto, address);

        return addressRepository.save(address);
    }
    
}
