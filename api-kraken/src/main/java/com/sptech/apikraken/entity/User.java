package com.sptech.apikraken.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;

    @Column(name = "img_user")
    @Length(min = 5, message = "Imagem inválida")
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

    public User() {}

    public User(String img, String name, String email, String password, Address address) {
        this.img = img;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
    }

    public User(Integer id, String img, String name, String email, String password, Address address) {
        this(img, name, email, password, address);
        this.id = id;
    }

    public void logon(String email, String password) {

    }

    public void logoff(User user) {

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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address=" + address +
                '}';
    }

}
