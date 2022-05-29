package com.sptech.apikraken.dto.request.ngo;

import com.sptech.apikraken.dto.request.address.AddressDTO;
import com.sptech.apikraken.dto.request.user.UserDTO;
import com.sptech.apikraken.entity.Category;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.utils.enums.UserTypeEnum;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotNull;

public class NgoDTO {

    private Integer id;

    @CNPJ
    private String cnpj;

    private String description;

    @NotNull
    private Category category;

    @NotNull
    private UserDTO user;

    private double assessment;

    public NgoDTO() {}

    public NgoDTO(Integer id) {
        this.id = id;
    }

    public NgoDTO(NGO ngo) {
        this.id = ngo.getId();
        this.cnpj = ngo.getCnpj();
        this.description = ngo.getDescription();
        this.category = ngo.getCategory();
        this.user = new UserDTO(ngo.getUser());
    }

    public NgoDTO(Integer id, byte[] img, String name, String email, String password, AddressDTO addressDTO, UserTypeEnum userType, boolean hasConnect, Integer idNGO, String cnpj, String description, Category category, double assessment) {
        this.id = idNGO;
        this.cnpj = cnpj;
        this.description = description;
        this.category = category;
        this.assessment = assessment;
        this.user = new UserDTO(id, img, name, email, password, addressDTO, userType, hasConnect);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public double getAssessment() {
        return assessment;
    }

    public void setAssessment(double assessment) {
        this.assessment = assessment;
    }

    @Override
    public String toString() {
        return "NgoDTO{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", user=" + user +
                ", assessment=" + assessment +
                '}';
    }
}
