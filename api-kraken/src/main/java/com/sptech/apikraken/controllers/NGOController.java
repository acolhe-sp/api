package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.NgoDTO;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.ngos.RegisterNGOValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ngos")
public class NGOController {

    @Autowired
    private INGORepository iNGORepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterNGOValidateUseCase registerNGOValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;

    @GetMapping
    public ResponseEntity listNGOs() {
        if (!iNGORepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iNGORepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity registerNGO(@RequestBody NgoDTO ngo){

        Address newAddress = new Address(
                ngo.getAddressDTO().getState(),
                ngo.getAddressDTO().getDistrict(),
                ngo.getAddressDTO().getCep(),
                ngo.getAddressDTO().getStreet(),
                ngo.getAddressDTO().getNumber(),
                ngo.getAddressDTO().getComplement()
        );

        User newUser = new User(
                ngo.getImg(),
                ngo.getName(),
                ngo.getEmail(),
                ngo.getPassword(),
                this.registerAddressUseCase.execute(newAddress)
        );

        User userRegister = this.registerUserValidateUseCase.execute(newUser);

        if (userRegister != null) {

            NGO newNGO = new NGO(ngo.getCnpj(), ngo.getDescription(), ngo.getCategory(), userRegister);

            boolean created = this.registerNGOValidateUseCase.execute(newNGO);

            if (created) return ResponseEntity.status(201).build();

        }

        return ResponseEntity.status(404).build();

    }

}
