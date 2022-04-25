package com.sptech.apikraken.entity;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_address")
    private Integer id;

    @Column(name = "state_address")
    @Length(min = 3, message = "estate min lenght")
    private String state;

    @Column(name = "city_address")
    private String city;

    @Column(name = "district_address")
    private String district;

    @Column(name = "cep_address")
    @Pattern(regexp = "(^[0-9]{5})-?([0-9]{3}$)")
    private String cep;

    @Column(name = "street_address")
    private String street;

    @Column(name = "number_address")
    private String number;

    @Column(name = "complement_address")
    private String complement;

    public Address(String state, String city, String district, String cep, String street, String number, String complement) {
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public Address(Integer id, String state, String city, String district, String cep, String street, String number, String complement) {
        this(state, city, district, cep, street, number, complement);
        this.id = id;
    }

    public Address() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
