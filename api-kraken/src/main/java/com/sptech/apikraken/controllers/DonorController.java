package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.DonorDTO;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @GetMapping
    public ResponseEntity listDonors() {

        if (donorService.getAll().getTamanho() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(donorService.getAll());
    }

    @PostMapping
    public ResponseEntity registerDonor(@RequestBody @Valid DonorDTO donor){
        try {

            return ResponseEntity.status(201).body(donorService.create(donor));

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDonor(@PathVariable int id,
                                      @RequestBody DonorDTO newDonor)
    {
        try {

            boolean updated = donorService.update(id, newDonor);

            if (updated) return ResponseEntity.status(201).build();

            return ResponseEntity.status(400).build();

        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDonor(@PathVariable int id) {

        if (donorService.delete(id)) return ResponseEntity.status(200).build();

        return ResponseEntity.status(404).build();
    }

}
