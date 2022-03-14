package com.sptech.apikraken.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_donation")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_donation")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "fk_donor", referencedColumnName = "id_donor")
    private Donor donor;

    @ManyToOne
    @JoinColumn(name = "fk_ngo", referencedColumnName = "id_ngo")
    private NGO ngo;

    @Column(name = "value_donation")
    private double value;

    @Column(name = "datetime_donation")
    private LocalDateTime dateDonation;

    public Donation() {}

    public Donation(int id, Donor donor, NGO ngo, double value) {
        this.id = id;
        this.donor = donor;
        this.ngo = ngo;
        this.value = value;
        this.dateDonation = LocalDateTime.now();
    }

    public Donation(int id, Donor donor, NGO ngo, double value, LocalDateTime dateDonation) {
        this(id, donor, ngo, value);
        this.dateDonation = dateDonation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Donor getDonor() {
        return donor;
    }

    public void setDonor(Donor donor) {
        this.donor = donor;
    }

    public NGO getNgo() {
        return ngo;
    }

    public void setNgo(NGO ngo) {
        this.ngo = ngo;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public LocalDateTime getDateDonation() {
        return dateDonation;
    }

    public void setDateDonation(LocalDateTime dateDonation) {
        this.dateDonation = dateDonation;
    }

    @Override
    public String toString() {
        return "Donation{" +
                "id=" + id +
                ", donor=" + donor +
                ", ngo=" + ngo +
                ", value=" + value +
                ", dateDonation=" + dateDonation +
                '}';
    }
}
