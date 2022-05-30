package com.sptech.apikraken.dto.response.ngo;

import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.Category;
import com.sptech.apikraken.utils.enums.UserTypeEnum;

public class NGOComplete {

    private Integer id;
    private Integer idUser;
    private byte[] img;
    private String name;
    private String email;
    private Address address;
    private UserTypeEnum userType;
    private String cnpj;
    private String description;
    private Category category;
    private double assessment;

    public NGOComplete(Integer id, Integer idUser, byte[] img, String name, String email, Address address, UserTypeEnum userType, String cnpj, String description, Category category, double assessment) {
        this.id = id;
        this.idUser = idUser;
        this.img = img;
        this.name = name;
        this.email = email;
        this.address = address;
        this.userType = userType;
        this.cnpj = cnpj;
        this.description = description;
        this.category = category;
        this.assessment = assessment;
    }

    public Integer getId() {
        return id;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setImg(byte[] img) {
        this.img = img;
    }

    public byte[] getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public UserTypeEnum getUserType() {
        return userType;
    }

    public String getCnpj() {
        return cnpj;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public double getAssessment() { return assessment; }

}
