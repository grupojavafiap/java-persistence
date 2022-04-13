package br.com.fiap.javapersistence.persistence.dtos;

import java.math.BigDecimal;
import java.util.List;

import javax.validation.constraints.NotNull;

public class OrdersDto {

    @NotNull
    private BigDecimal totalPrice;

    @NotNull
    // private CustomerDto customer;
    private Long customerId;

    @NotNull
    //private List<ProductDto> products;    
    private List<Long> productsId;

    public BigDecimal getTotalPrice() {
        return this.totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /*
    public CustomerDto getCustomer() {
        return this.customer;
    }

    public void setCustomer(CustomerDto customer) {
        this.customer = customer;
    }

    public List<ProductDto> getProducts() {
        return this.products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }
    */

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductsId() {
        return this.productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }
}
