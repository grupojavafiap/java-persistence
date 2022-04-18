package br.com.fiap.javapersistence.persistence.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import br.com.fiap.javapersistence.persistence.dtos.OrdersDto;
import br.com.fiap.javapersistence.persistence.models.Customer;
import br.com.fiap.javapersistence.persistence.models.Orders;
import br.com.fiap.javapersistence.persistence.models.Product;
import br.com.fiap.javapersistence.persistence.repositories.CustomerRepository;
import br.com.fiap.javapersistence.persistence.repositories.OrdersRepository;
import br.com.fiap.javapersistence.persistence.repositories.ProductRepository;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;



@Service
public class OrdersService {
    
    final OrdersRepository ordersRepository;
    final CustomerRepository customerRepository;
    final ProductRepository productRepository;

    public OrdersService(
        OrdersRepository ordersRepository,
        CustomerRepository customerRepository,
        ProductRepository productRepository) {
        this.ordersRepository = ordersRepository;
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
    }

    @Cacheable(value = "allOrders", unless= "#result.size() == 0")
    public List<Orders> findAll()
    {
        return ordersRepository.findAll();
    }

    @Cacheable(value= "ordersCache", key= "#id")
    public Optional<Orders> findById(long id)
    {
        return ordersRepository.findById(id);
    }

    @Cacheable(value= "ordersCache", key= "#cpf")
    public List<Orders> findOrdersByCpf(Long cpf) 
    {
        return ordersRepository.findOrdersByCpf(cpf);
    }

    @Caching(
		evict= { 
			@CacheEvict(value= "ordersCache", key= "#id"),
			@CacheEvict(value= "allOrders", allEntries= true)
		}
	) 
    public void deleleById(long id)
    {
        ordersRepository.deleteById(id);
    }

    @Caching(
		put= { @CachePut(value= "ordersCache", key= "#orders.id") },
		evict= { @CacheEvict(value= "allOrders", allEntries= true) }
	)
    public Orders save(OrdersDto ordersDto) throws Exception
    {
        var orders = new Orders();
        BeanUtils.copyProperties(ordersDto, orders);

        if(ordersDto.getCustomerId() != null)
        {
            Customer customer = customerRepository.getById(ordersDto.getCustomerId());

            if(customer == null)
            {
                throw new Exception("Customer not found");
            }

            orders.setCustomerOrders(customer);
            List<Orders> ordersList = new ArrayList<Orders>();
            ordersList.add(orders);
            customer.setOrders(ordersList);
        }

        if(ordersDto.getProductsId() != null)
        {
            Set<Product> productsList = new HashSet<Product>();
            Set<Orders> ordersList = new HashSet<Orders>();
            ordersList.add(orders);

            for (Long id : ordersDto.getProductsId()) 
            {
                Product product = productRepository.getById(id);

                if(product == null)
                {
                    throw new Exception("Product not found");
                }
                
                productsList.add(product);
                product.setOrders(ordersList);
            }

            orders.setProducts(productsList);
        }

        return ordersRepository.save(orders);

        /*
        if(ordersDto.getCustomer() != null)
        {
            Customer customer = new Customer();
            customer.setCpf(ordersDto.getCustomer().getCpf());
            customer.setEmail(ordersDto.getCustomer().getEmail());
            customer.setGender(ordersDto.getCustomer().getGender());
            customer.setName(ordersDto.getCustomer().getName());
            customer.setUsername(ordersDto.getCustomer().getUsername());

            if(ordersDto.getCustomer().getAddress() != null)
            {
                List<Address> addressList = new ArrayList<>();
                for(AddressDto addressDto: ordersDto.getCustomer().getAddress())
                {
                    Address address = new Address();
                    address.setCep(addressDto.getCep());
                    address.setDescription(addressDto.getDescription());
                    address.setState(addressDto.getState());
                    address.setCustomer(customer);
                    addressList.add(address);
                }
                customer.setAddress(addressList);
            }

            orders.setCustomerOrders(customer);
        }
        */
    }
}
