package com.sptech.apikraken.dto.request.donation;

import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.Payment;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class DonationDTO {

    private Integer id;

    @NotNull
    private Donor donor;

    @NotNull
    private NGO ngo;

    @NotNull
    private Payment payment;

    private String status;

    private LocalDateTime dateDonation;

    public DonationDTO() {}

    public DonationDTO(Donor donor, NGO ngo, Payment payment, String status) {
        this.donor = donor;
        this.ngo = ngo;
        this.payment = payment;
        this.status = status;
        this.dateDonation = LocalDateTime.now();
    }

    public DonationDTO(Integer id, Donor donor, NGO ngo, Payment payment, String status) {
        this(donor, ngo, payment, status);
        this.id = id;
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
        return "DonationDTO{" +
                "id=" + id +
                ", donor=" + donor +
                ", ngo=" + ngo +
                ", payment=" + payment +
                ", status='" + status + '\'' +
                ", dateDonation=" + dateDonation +
                '}';
    }
}
