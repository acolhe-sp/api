package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.User;

public class UserDTO {

    private Integer id;
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

    public UserDTO(Integer id, String img, String name, String email, String password, AddressDTO addressDTO) {
        this(img, name, email, password, addressDTO);
        this.id = id;
    }

    public UserDTO(User user) {
        this(
                user.getImg(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                new AddressDTO(user.getAddress())
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressDTO=" + addressDTO +
                '}';
    }
}
