package com.sptech.apikraken.dto.response.donation;

import com.sptech.apikraken.entity.Donation;

import java.util.List;

public class DonationDataPerfil {

    private Integer qtdDonations;
    private List<Donation> donations;
    private Double valorTotalDoado;

    public DonationDataPerfil(Integer qtdDonations, List<Donation> donations, Double valorTotalDoado) {
        this.qtdDonations = qtdDonations;
        this.donations = donations;
        this.valorTotalDoado = valorTotalDoado;
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

    public Double getValorTotalDoado() {
        return valorTotalDoado;
    }

    public void setValorTotalDoado(Double valorTotalDoado) {
        this.valorTotalDoado = valorTotalDoado;
    }
}
