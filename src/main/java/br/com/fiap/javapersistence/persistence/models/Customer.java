package br.com.fiap.javapersistence.persistence.models;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Customer {

    @Id
	private Long cpf;

    @Column(nullable = false)
	private String name;

    @Column(nullable = false)
	private String email;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    private String username;
    
    @OneToMany
    private List<Address> address;

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }




}
