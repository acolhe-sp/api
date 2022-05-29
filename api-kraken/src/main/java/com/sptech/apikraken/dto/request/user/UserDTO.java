package com.sptech.apikraken.dto.request.user;

import com.sptech.apikraken.dto.request.address.AddressDTO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.utils.enums.UserTypeEnum;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class UserDTO {

    @Positive
    private Integer id;

    private byte[] img;

    @NotBlank
    @Length(max = 40, message = "Nome muito grande")
    private String name;

    @Email
    private String email;

    @Length(min = 8, max = 20, message = "Senha inválida")
    private String password;

    @NotNull
    private AddressDTO addressDTO;

    @NotNull
    private UserTypeEnum userType;

    private boolean connect;

    public UserDTO() {}

    public UserDTO(Integer id, byte[] img, String name, String email, String password, AddressDTO addressDTO, UserTypeEnum userType, boolean hasConnect) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.email = email;
        this.password = password;
        this.addressDTO = addressDTO;
        this.userType = userType;
        this.connect = hasConnect;
    }

    public UserDTO(User user) {
        this(
                user.getId(),
                user.getImg(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                new AddressDTO(user.getAddress()),
                user.getUserType(),
                user.isConnect()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getImg() {
        return img;
    }

    public void setImg(byte[] img) {
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

    public UserTypeEnum getUserType() {
        return userType;
    }

    public void setUserType(UserTypeEnum userType) {
        this.userType = userType;
    }

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        this.connect = connect;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", addressDTO=" + addressDTO +
                ", userType=" + userType +
                ", hasConnect=" + connect +
                '}';
    }
}
