package com.sptech.apikraken.service;

import com.sptech.apikraken.dto.request.donation.DonationDTO;
import com.sptech.apikraken.dto.response.donation.DonationDataPerfil;
import com.sptech.apikraken.dto.response.donation.DonationDataPerfilNGO;
import com.sptech.apikraken.entity.Donation;
import com.sptech.apikraken.entity.Payment;
import com.sptech.apikraken.repository.IDonationRepository;
import com.sptech.apikraken.repository.IPaymentRepository;
import com.sptech.apikraken.utils.interfaces.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService implements IService<DonationDTO, Donation> {

    @Autowired private IDonationRepository iDonationRepository;
    @Autowired private IPaymentRepository iPaymentRepository;

    @Override
    public Donation create(DonationDTO donation) {
        try {

            Payment payment = iPaymentRepository.save(donation.getPayment());

            donation.setPayment(payment);

            System.out.println("new donation payment: "+donation);

            return iDonationRepository.save(new Donation(donation));

        } catch (Exception e) {
            throw new Error("erro ao cadastrar donation: "+ e.getMessage());
        }
    }

    public DonationDataPerfilNGO getByIdNGO(Integer id) {
        try {

            List<Donation> donations = iDonationRepository.findByNgoId(id);

            DonationDataPerfilNGO data = new DonationDataPerfilNGO(
                    donations.size(),
                    donations,
                    donations.stream().filter(donation -> donation.getStatus().equals("Concluido"))
                                        .map(donation -> donation.getPayment().getValue())
                                        .reduce(0.0, Double::sum),
                    donations.stream().filter(donation -> donation.getStatus().equals("Pendente"))
                                        .map(donation -> donation.getPayment().getValue())
                                        .reduce(0.0, Double::sum)
            );

            return data;

        } catch (Exception e) {
            throw new Error("erro ao cadastrar donation: "+ e.getMessage());
        }
    }

    @Override
    public Boolean delete(Integer id) {

        if (!iDonationRepository.existsById(id)) {
            return false;
        }

        iDonationRepository.deleteById(id);

        return true;

    }
}
