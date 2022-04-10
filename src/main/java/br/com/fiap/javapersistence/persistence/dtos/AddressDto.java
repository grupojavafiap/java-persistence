package br.com.fiap.javapersistence.persistence.dtos;

import javax.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank
    private String cep;

    @NotBlank
    private String state;

    @NotBlank
    private String description;
    
    public String getCep() {
        return this.cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
