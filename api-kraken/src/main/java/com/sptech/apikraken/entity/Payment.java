package com.sptech.apikraken.entity;

import javax.persistence.*;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment")
    private Integer id;

    @Column(name = "value_payment")
    private Double value;

    @ManyToOne
    @JoinColumn(name = "fk_type_payment", referencedColumnName = "id_type_payment")
    private TypePayment type;

    public Payment() {
    }

    public Payment(Double value, TypePayment type) {
        this.value = value;
        this.type = type;
    }

    public Payment(Integer id, Double value, TypePayment type) {
        this(value, type);
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public TypePayment getType() {
        return type;
    }

    public void setType(TypePayment type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", value=" + value +
                ", type=" + type +
                '}';
    }
}
