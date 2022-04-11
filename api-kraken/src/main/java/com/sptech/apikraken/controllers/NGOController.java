package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.NgoDTO;
import com.sptech.apikraken.service.NGOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/ngos")
public class NGOController {

    @Autowired private NGOService ngoService;

    @GetMapping
    public ResponseEntity listNGOs() {

        return ResponseEntity.status(200).body(ngoService.getAll());

    }

    @PostMapping
    public ResponseEntity registerNGO(@RequestBody @Valid NgoDTO ngo){

        try {

            ngoService.create(ngo);
            return ResponseEntity.status(201).build();

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity updateNGO(@PathVariable Integer id,
                                    @RequestBody NgoDTO newNGO)
    {
        boolean updated = ngoService.update(id, newNGO);

        return updated ? ResponseEntity.status(201).build()
                        : ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNGO(@PathVariable Integer id) {

        try {
            ngoService.delete(id);
            ResponseEntity.status(201).build();
        } catch (Exception e) {
            return ResponseEntity.status(404).build();
        }

        return ResponseEntity.status(404).build();
    }

}
