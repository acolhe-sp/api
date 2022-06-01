package com.sptech.apikraken.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_type_payment")
public class TypePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_payment")
    private Integer id;

    @Column(name = "description_type_payment")
    private String description;

    public TypePayment() {}

    public TypePayment(Integer id) {
        this.id = id;
    }

    public TypePayment(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "TypePayment{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
