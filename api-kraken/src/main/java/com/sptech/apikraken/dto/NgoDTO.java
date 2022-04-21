package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.Category;
import com.sptech.apikraken.entity.NGO;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;

public class NgoDTO extends UserDTO{

    @CNPJ
    private String cnpj;

    private String description;

    @NotNull
    private Category category;

    public NgoDTO() {}

    public NgoDTO(NGO ngo) {
        super(ngo.getUser());
        this.cnpj = ngo.getCnpj();
        this.description = ngo.getDescription();
        this.category = ngo.getCategory();
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
