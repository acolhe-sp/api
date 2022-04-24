package com.sptech.apikraken.entity;

import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_ngo")
public class NGO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ngo")
    private Integer id;

    @Column(name = "cnpj_ngo")
    @CNPJ
    private String cnpj;

    @Column(name = "description_ngo")
    private String description;

    @ManyToOne
    @JoinColumn(name = "fk_category", referencedColumnName = "id_category")
    private Category category;

    @OneToOne
    @JoinColumn(name = "fk_user", referencedColumnName = "id_user")
    @NotNull
    private User user;

    @ManyToMany(mappedBy = "ngos_follow")
    private List<Donor> followers;

    public NGO() {}

    public NGO(String cnpj, String description, Category category, User user) {
        this.cnpj = cnpj;
        this.description = description;
        this.category = category;
        this.user = user;
        this.followers = new ArrayList<>();
    }

    public NGO(Integer id, String cnpj, String description, Category category, User user) {
        this(cnpj, description, category, user);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Donor> getFollowers() {
        return this.followers;
    }

    @Override
    public String toString() {
        return "NGO{" +
                "id=" + id +
                ", cnpj='" + cnpj + '\'' +
                ", description='" + description + '\'' +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
