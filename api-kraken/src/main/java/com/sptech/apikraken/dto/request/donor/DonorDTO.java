package com.sptech.apikraken.dto.request.donor;

import com.sptech.apikraken.dto.request.user.UserDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.Post;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Pattern;
import java.util.List;

public class DonorDTO {

    private Integer id;

    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @CPF
    private String cpf;

    private UserDTO user;

    private List<Post> notifications;

    public DonorDTO() {}

    public DonorDTO(Integer id) {
        this.id = id;
    }

    public DonorDTO(Donor donor) {
        this.rg = donor.getRg();
        this.cpf = donor.getCpf();
        this.user = new UserDTO(donor.getUser());
        this.notifications = donor.getNotifications();
    }

    public Integer getId() {
        return id;
    }

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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
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
                "id=" + id +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", user=" + user +
                ", notifications=" + notifications +
                '}';
    }
}
