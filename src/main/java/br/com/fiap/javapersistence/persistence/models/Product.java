package br.com.fiap.javapersistence.persistence.models;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Product implements Serializable{
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long amount;

    @Column(nullable = false)
    private BigDecimal price;


    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "products")
    // @JoinTable(
    //       name = "Product_Order", 
    //       joinColumns = @JoinColumn(name = "product_id"), 
    //       inverseJoinColumns = @JoinColumn(name = "orders_id"))    
    @JsonManagedReference    
    private Set<Orders> orders;


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Long getAmount() {
        return amount;
    }


    public void setAmount(Long amount) {
        this.amount = amount;
    }


    public BigDecimal getPrice() {
        return price;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Orders> getOrders() {
        return orders;
    }


    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }   
}
