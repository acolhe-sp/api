package com.sptech.apikraken.dto.request.donor;

import com.sptech.apikraken.dto.request.user.UserDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.Post;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;
import java.util.List;

public class DonorDTO extends UserDTO {

    private Integer id;

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

    private List<Post> notifications;

    public DonorDTO() {}

    public DonorDTO(Integer id) {
        this.id = id;
    }

    public DonorDTO(Donor donor) {
        super(donor.getUser());
        this.rg = donor.getRg();
        this.cpf = donor.getCpf();
        this.notifications = donor.getNotifications();
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
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

    public List<Post> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Post> notifications) {
        this.notifications = notifications;
    }

    public Integer getUserId() {
        return super.getId();
    }

    @Override
    public String toString() {
        return "DonorDTO{" +
                "id=" + id +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", notifications=" + notifications +
                '}';
    }
}
