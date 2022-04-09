package br.com.fiap.javapersistence.persistence.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Email;

@NotNull
public class CustomerDto {

    @NotBlank
    @Size(max = 5)
    private String name;

    @NotBlank
    @Email()
    private String email;

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




    
}
