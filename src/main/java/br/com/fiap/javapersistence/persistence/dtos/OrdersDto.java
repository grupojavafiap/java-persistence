package br.com.fiap.javapersistence.persistence.dtos;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.fiap.javapersistence.persistence.models.Customer;
import br.com.fiap.javapersistence.persistence.models.Product;

public class OrdersDto {

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    private Customer customer;

    @NotNull
    private List<Product> products;    

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
