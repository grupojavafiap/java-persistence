package br.com.fiap.javapersistence.persistence.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.OrdersDto;
import br.com.fiap.javapersistence.persistence.models.Orders;
import br.com.fiap.javapersistence.persistence.repositories.OrdersRepository;

@Service
public class OrdersService {
    
    final OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<Orders> findAll()
    {
        return ordersRepository.findAll();
    }

    public Optional<Orders> findById(long id)
    {
        return ordersRepository.findById(id);
    }

    public List<Orders> findOrdersByCpf(Long cpf) 
    {
        return ordersRepository.findOrdersByCpf(cpf);
    }

    public void deleleById(long id)
    {
        ordersRepository.deleteById(id);
    }

    public Orders save(OrdersDto ordersDto)
    {
        var orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);

        return ordersRepository.save(orders);
    }
}
