package com.sptech.apikraken.dto.request.address;

import com.sptech.apikraken.entity.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

public class AddressDTO {

    @NotBlank
    private String state;

    @NotBlank
    private String city;

    @NotBlank
    private String district;

    @Pattern(regexp = "(^[0-9]{5})-?([0-9]{3}$)", message = "CEP inválido")
    private String cep;

    @NotBlank
    private String street;

    @NotBlank
    @Positive
    private String number;

    private String complement;

    public AddressDTO() {}

    public AddressDTO(String state, String city, String district, String cep, String street, String number, String complement) {
        this.state = state;
        this.city = city;
        this.district = district;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public AddressDTO(Address address) {
        this(
             address.getState(),
             address.getCity(),
             address.getDistrict(),
             address.getCep(),
             address.getStreet(),
             address.getNumber(),
             address.getComplement()
        );
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
        return "AddressDTO{" +
                "state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                ", cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
