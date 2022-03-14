package com.sptech.apikraken.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_donor")
public class Donor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donor")
    private Integer id;

    @Column(name = "rg_donor")
    private String rg;

    @Column(name = "cpf_donor")
    private String cpf;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    private User user;

    public Donor() {}

    public Donor(String rg, String cpf, User user) {
        this.rg = rg;
        this.cpf = cpf;
        this.user = user;
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
