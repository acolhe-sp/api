package com.sptech.apikraken.dto.request.donor;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;

public class UpdateDocumentsDonorDTO {

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

    public UpdateDocumentsDonorDTO(String rg, String cpf) {
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
}
