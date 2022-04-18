package br.com.fiap.javapersistence.persistence.models;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Address implements Serializable{
    
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String state;

    @Column(nullable = false)
    private String description;

    @ManyToOne()
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;


    public Address() {
    }

    public Address(String cep, String state, String description, Customer customer) {
        this.cep = cep;
        this.state = state;
        this.description = description;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", cep='" + getCep() + "'" +
            ", state='" + getState() + "'" +
            ", description='" + getDescription() + "'" +
            ", customer='" + getCustomer() + "'" +
            "}";
    }

}
