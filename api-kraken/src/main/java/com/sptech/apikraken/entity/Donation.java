package com.sptech.apikraken.entity;

import com.sptech.apikraken.dto.request.donation.DonationDTO;

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

    @OneToOne
    @JoinColumn(name = "fk_payment", referencedColumnName = "id_payment")
    private Payment payment;

    @Column(name = "status_donation")
    private String status;

    @Column(name = "datetime_donation")
    private LocalDateTime dateDonation;

    public Donation() {}

    public Donation(Donor donor, NGO ngo, Payment payment, String status) {
        this.donor = donor;
        this.ngo = ngo;
        this.payment = payment;
        this.status = status;
        this.dateDonation = LocalDateTime.now();
    }

    public Donation(Integer id, Donor donor, NGO ngo, Payment payment, String status) {
        this(donor, ngo, payment, status);
        this.id = id;
    }

    public Donation(int id, Donor donor, NGO ngo, Payment payment, String status, LocalDateTime dateDonation) {
        this(id, donor, ngo, payment, status);
        this.dateDonation = dateDonation;
    }

    public Donation(DonationDTO donationDTO) {
        this(
            donationDTO.getDonor(),
            donationDTO.getNgo(),
            donationDTO.getPayment(),
            donationDTO.getStatus()
        );
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

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
                ", payment=" + payment +
                ", status=" + status +
                ", dateDonation=" + dateDonation +
                '}';
    }
}
