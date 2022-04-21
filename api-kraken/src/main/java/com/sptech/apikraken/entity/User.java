package com.sptech.apikraken.entity;

import com.sptech.apikraken.utils.enums.UserTypeEnum;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "img_user")
    private String img;

    @Column(name = "name_user")
    @Length(min = 3, max = 50, message = "Nome inválido")
    private String name;

    @Column(name = "email_user")
    @Email
    private String email;

    @Column(name = "password_user")
    private String password;

    @OneToOne
    @JoinColumn(name = "fk_address", referencedColumnName = "id_address")
    private Address address;

    @NotNull
    private UserTypeEnum userType;

    private boolean connect;

    public User() {}

    public User(String img, String name, String email, String password, Address address, UserTypeEnum userType, boolean hasConnect) {
        this.img = img;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.userType = userType;
        this.connect = hasConnect;
    }

    public User(Integer id, String img, String name, String email, String password, Address address, UserTypeEnum userType, boolean hasConnect) {
        this(img, name, email, password, address, userType, hasConnect);
        this.id = id;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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
}
