package com.sptech.apikraken.dto;


import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.User;

public class DonorDTO extends UserDTO{

    private String rg;
    private String cpf;

    public DonorDTO(String img, String name, String email, String password, AddressDTO addressDTO, String rg, String cpf) {
        super(img, name, email, password, addressDTO);
        this.rg = rg;
        this.cpf = cpf;
    }

    public DonorDTO(Donor donor) {
        super(
            donor.getUser().getImg(),
            donor.getUser().getName(),
            donor.getUser().getEmail(),
            donor.getUser().getPassword(),
            new AddressDTO(donor.getUser().getAddress())
        );
        this.rg = donor.getRg();
        this.cpf = donor.getCpf();
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
