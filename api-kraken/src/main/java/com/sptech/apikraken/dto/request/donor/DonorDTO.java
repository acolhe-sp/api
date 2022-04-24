package com.sptech.apikraken.dto.request.donor;

import com.sptech.apikraken.dto.request.user.UserDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.Post;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class DonorDTO extends UserDTO {

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

    private List<NGO> ngos_follow;

    private List<Post> notifications;

    public DonorDTO() {}

    public DonorDTO(Donor donor) {
        super(donor.getUser());
        this.rg = donor.getRg();
        this.cpf = donor.getCpf();
        this.ngos_follow = new ArrayList<>();
        this.notifications = new ArrayList<>();
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

    public List<NGO> getNgos_follow() {
        return ngos_follow;
    }

    public void setNgos_follow(List<NGO> ngos_follow) {
        this.ngos_follow = ngos_follow;
    }

    public List<Post> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Post> notifications) {
        this.notifications = notifications;
    }

    @Override
    public String toString() {
        return "DonorDTO{" +
                "rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
