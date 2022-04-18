package br.com.fiap.javapersistence.persistence.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import java.util.List;

import javax.validation.constraints.Email;

@NotNull
public class CustomerDto {

    @NotNull
    private Long cpf;

    @NotBlank
    @Size(min = 3, max = 60)
    private String name;

    @NotBlank
    @Email()
    private String email;

    @NotBlank
    private String gender;

    @NotBlank
    private String username;

    @NotNull
    private List<AddressDto> address;

    public Long getCpf() {
        return this.cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<AddressDto> getAddress() {
        return this.address;
    }

    public void setAddress(List<AddressDto> address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDto [address=" + address + ", cpf=" + cpf + ", email=" + email + ", gender=" + gender
                + ", name=" + name + ", username=" + username + "]";
    }

    
}
