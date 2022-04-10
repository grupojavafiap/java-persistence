package br.com.fiap.javapersistence.persistence.dtos;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.fiap.javapersistence.persistence.models.Orders;

public class ProductDto {

    @NotBlank
    private String name;

    @NotNull
    private Long amount;

    @NotNull
    private BigDecimal price;

    private List<Orders> orders;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAmount() {
        return this.amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    } 
    
    public List<Orders> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
