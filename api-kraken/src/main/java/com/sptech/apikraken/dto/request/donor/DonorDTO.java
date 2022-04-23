package com.sptech.apikraken.dto.request.donor;


import com.sptech.apikraken.dto.request.UserDTO;
import com.sptech.apikraken.entity.Donor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;

public class DonorDTO extends UserDTO {

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

    public DonorDTO() {}

    public DonorDTO(Donor donor) {
        super(donor.getUser());
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