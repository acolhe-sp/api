package com.sptech.apikraken.dto;

import com.sptech.apikraken.entity.Address;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

public class AddressDTO {

    @NotBlank
    private String state;

    @NotBlank
    private String district;

    @NotBlank
    private String cep;

    @NotBlank
    private String street;

    @NotBlank
    @Positive
    private String number;

    private String complement;

    public AddressDTO() {}

    public AddressDTO(String state, String district, String cep, String street, String number, String complement) {
        this.state = state;
        this.district = district;
        this.cep = cep;
        this.street = street;
        this.number = number;
        this.complement = complement;
    }

    public AddressDTO(Address address) {
        this(
             address.getState(),
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
                ", district='" + district + '\'' +
                ", cep='" + cep + '\'' +
                ", street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
