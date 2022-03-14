package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.IDonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/donations")
public class DonationController {

    @Autowired
    private IDonationRepository iDonationRepository;

    @GetMapping
    public ResponseEntity listDonations() {
        if (!iDonationRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iDonationRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

}
