package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private IAddressRepository iAddressRepository;

    @GetMapping
    public ResponseEntity listAdress() {
        if (!iAddressRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iAddressRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

}
