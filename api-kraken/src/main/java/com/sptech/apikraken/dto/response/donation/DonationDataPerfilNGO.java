package com.sptech.apikraken.dto.response.donation;

import com.sptech.apikraken.entity.Donation;

import java.util.List;

public class DonationDataPerfilNGO {
    private Integer qtdDonations;
    private List<Donation> donations;
    private Double valorTotalArrecadado;
    private Double valorPendenteArrecadar;

    public DonationDataPerfilNGO(Integer qtdDonations, List<Donation> donations, Double valorTotalArrecadado, Double valorPendenteArrecadar) {
        this.qtdDonations = qtdDonations;
        this.donations = donations;
        this.valorTotalArrecadado = valorTotalArrecadado;
        this.valorPendenteArrecadar = valorPendenteArrecadar;
    }

    public Integer getQtdDonations() {
        return qtdDonations;
    }

    public void setQtdDonations(Integer qtdDonations) {
        this.qtdDonations = qtdDonations;
    }

    public List<Donation> getDonations() {
        return donations;
    }

    public void setDonations(List<Donation> donations) {
        this.donations = donations;
    }

    public Double getvalorTotalArrecadado() {
        return valorTotalArrecadado;
    }

    public void setvalorTotalArrecadado(Double valorTotalArrecadado) {
        this.valorTotalArrecadado = valorTotalArrecadado;
    }

    public Double getvalorPendenteArrecadar() {
        return valorPendenteArrecadar;
    }

    public void setvalorPendenteArrecadar(Double valorPendenteArrecadar) {
        this.valorPendenteArrecadar = valorPendenteArrecadar;
    }
}
