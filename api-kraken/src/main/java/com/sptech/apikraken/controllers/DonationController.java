package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.donation.DonationDTO;
import com.sptech.apikraken.dto.response.donation.DonationDataPerfil;
import com.sptech.apikraken.entity.Donation;
import com.sptech.apikraken.repository.IDonationRepository;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.service.DonationService;
import com.sptech.apikraken.utils.stack.PilhaObj;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired private IDonationRepository iDonationRepository;
    @Autowired private INGORepository iNGORepository;
    @Autowired private DonationService donationService;

    private PilhaObj<Donation> pilha = new PilhaObj<>(10);

    @GetMapping
    public ResponseEntity listDonations() {
        if (!iDonationRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iDonationRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/ngo/{id}")
    public ResponseEntity dataDonationsToNGO(@PathVariable Integer id) {

        try {

            if (!iNGORepository.existsById(id)) return ResponseEntity.status(404).build();

            return ResponseEntity.status(200).body(donationService.getByIdNGO(id));

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity createDonation(@RequestBody @Valid DonationDTO donation) {

        try {
            return ResponseEntity.status(201).body(donationService.create(donation));
        } catch (Exception e) {
            System.out.println("erro ao criar doação");
            return ResponseEntity.status(500).build();
        }

    }

    @PostMapping("/prepare-donation")
    public ResponseEntity aguardeDonation(@RequestBody @Valid DonationDTO donation) {

        try {

            Donation donationCreated = donationService.create(donation);

            if(!this.pilha.isFull()) this.pilha.push(donationCreated);

            return ResponseEntity.status(200).build();

        } catch (Exception e) {
            System.out.println("erro ao criar doação");
            return ResponseEntity.status(500).build();
        }

    }

    @PostMapping("/rollback-donation")
    public ResponseEntity rollbackDonation() {

        try {

            if(!this.pilha.isEmpty()) {
                donationService.delete(this.pilha.pop().getId());
            }

            return ResponseEntity.status(200).build();

        } catch (Exception e) {
            System.out.println("erro ao fazer rollback");
            return ResponseEntity.status(500).build();
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDonation(@PathVariable Integer id) {

        try {

            return ResponseEntity.status(201).body(donationService.delete(id));

        } catch (Exception e) {
            System.out.println("erro ao deletar doação");
            return ResponseEntity.status(500).build();
        }

    }

}
