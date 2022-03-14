package com.sptech.apikraken.dto;


public class DonorDTO extends UserDTO{

    private String rg;
    private String cpf;

    public DonorDTO(String img, String name, String email, String password, AddressDTO addressDTO, String rg, String cpf) {
        super(img, name, email, password, addressDTO);
        this.rg = rg;
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "DonorDTO{" +
                "rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
