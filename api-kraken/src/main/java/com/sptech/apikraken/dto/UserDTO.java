package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.Address;

public class UserDTO {

    private String img;
    private String name;
    private String email;
    private String password;
    private AddressDTO addressDTO;

    public UserDTO(String img, String name, String email, String password, AddressDTO addressDTO) {
        this.img = img;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressDTO = addressDTO;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public AddressDTO getAddressDTO() {
        return addressDTO;
    }

    public void setAddressDTO(AddressDTO addressDTO) {
        this.addressDTO = addressDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + addressDTO +
                '}';
    }
}
