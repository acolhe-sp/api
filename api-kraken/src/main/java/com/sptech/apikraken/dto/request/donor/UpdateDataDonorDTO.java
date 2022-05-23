package com.sptech.apikraken.dto.request.donor;

import com.sptech.apikraken.dto.request.address.AddressDTO;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class UpdateDataDonorDTO {

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

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

}
