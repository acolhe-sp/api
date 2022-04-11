package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.DonorDTO;
import com.sptech.apikraken.entity.Address;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.addresses.RegisterAddressUseCase;
import com.sptech.apikraken.useCases.donors.RegisterDonorValidateUseCase;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired private IDonorRepository iDonorRepository;
    @Autowired private IUserRepository iUserRepository;

    @Autowired private RegisterUserValidateUseCase registerUserValidateUseCase;
    @Autowired private RegisterDonorValidateUseCase registerDonorValidateUseCase;
    @Autowired private RegisterAddressUseCase registerAddressUseCase;

    @GetMapping
    public ResponseEntity listDonors() {
        if (!iDonorRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iDonorRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity registerDonor(@RequestBody DonorDTO donor){
        Address newAddress = new Address(
                donor.getAddressDTO().getState(),
                donor.getAddressDTO().getDistrict(),
                donor.getAddressDTO().getCep(),
                donor.getAddressDTO().getStreet(),
                donor.getAddressDTO().getNumber(),
                donor.getAddressDTO().getComplement()
        );

        User newUser = new User(
                donor.getImg(),
                donor.getName(),
                donor.getEmail(),
                donor.getPassword(),
                this.registerAddressUseCase.execute(newAddress)
        );

        User userRegister = this.registerUserValidateUseCase.execute(newUser);

        if (userRegister != null) {

            Donor newDonor = new Donor(donor.getRg(), donor.getCpf(), userRegister);

            boolean created = this.registerDonorValidateUseCase.execute(newDonor);

            if (created) return ResponseEntity.status(201).build();

        }

        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDonor(@PathVariable int id,
                                      @RequestBody DonorDTO newDonor)
    {

        if (iDonorRepository.existsById(id)) {
            newDonor.setId(id);
            this.registerDonor(newDonor);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDonor(@PathVariable int id) {

        if (iDonorRepository.existsById(id)) {
            iDonorRepository.deleteById(id);
            iUserRepository.deleteById(id);

            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

}
