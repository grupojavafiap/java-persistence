package br.com.fiap.javapersistence.persistence.models;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Orders {
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    
    @Column(nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customerOrders;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(
        name = "orders_product",
        joinColumns = {
            @JoinColumn(
                name = "orders_id",
                referencedColumnName = "id",
                nullable = false,
                updatable = false)},
        inverseJoinColumns = {
            @JoinColumn(
                name = "product_id",
                referencedColumnName = "id",
                nullable = false,
                updatable = false)}
    )
    private List<Product> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Customer getCustomerOrders() {
        return this.customerOrders;
    }

    public void setCustomerOrders(Customer customerOrders) {
        this.customerOrders = customerOrders;
    }   

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


}
