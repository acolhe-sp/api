package com.sptech.apikraken.entity;

import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_donor")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donor")
    private Integer id;

    @Column(name = "rg_donor")
    @Pattern(regexp = "(^\\d{1,2}).?(\\d{3}).?(\\d{3})-?(\\d{1}|X|x$)", message = "RG inválido")
    private String rg;

    @Column(name = "cpf_donor")
    @CPF
    private String cpf;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @NotNull
    private User user;

    @ManyToMany(mappedBy = "followers")
    private List<NGO> ngos_follow;

    @ManyToMany
    @JoinTable(
            name = "notifications_post_donor",
            joinColumns = @JoinColumn(name = "fk_donor", referencedColumnName = "id_donor"),
            inverseJoinColumns = @JoinColumn(name = "fk_post", referencedColumnName = "id_post")
    )
    private List<Post> notifications;

    public Donor() {}

    public Donor(String rg, String cpf, User user) {
        this.rg = rg;
        this.cpf = cpf;
        this.user = user;
        this.ngos_follow = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    public Donor(Integer id, String rg, String cpf, User user) {
        this(rg, cpf, user);
        this.id = id;
    }

    public void donate(double value, NGO ngo) {

    }

    public void evaluationNGO(NGO ngo, double pontuation) {

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        return "Donor{" +
                "id=" + id +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", user=" + user +
                '}';
    }

}
