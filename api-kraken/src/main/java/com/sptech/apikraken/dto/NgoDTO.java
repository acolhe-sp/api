package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.Category;

public class NgoDTO extends UserDTO{

    private String cnpj;
    private String description;
    private Category category;

    public NgoDTO(String img, String name, String email, String password, AddressDTO addressDTO, String cnpj, String description, Category category) {
        super(img, name, email, password, addressDTO);
        this.cnpj = cnpj;
        this.description = description;
        this.category = category;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "NgoDTO{" +
                "cnpj='" + cnpj + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }
}
