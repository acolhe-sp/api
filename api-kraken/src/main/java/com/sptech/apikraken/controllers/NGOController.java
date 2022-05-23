package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.ngo.NgoDTO;
import com.sptech.apikraken.dto.request.ngo.UpdateDescriptionNgoDTO;
import com.sptech.apikraken.dto.response.ngo.NGOComplete;
import com.sptech.apikraken.service.NGOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ngos")
public class NGOController {

    @Autowired private NGOService ngoService;

    @GetMapping
    public ResponseEntity listNGOs() {

        if (ngoService.getAll().getTamanho() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ngoService.getAll());
    }

    @GetMapping("/card-data")
    public ResponseEntity listNGOsComplete() {

        List<NGOComplete> ngos = ngoService.getAllComplete();

        if (ngos.isEmpty()) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ngos);
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity listNGOsByCategoria(@RequestParam Integer idCategoria) {

        if (idCategoria > 7) return ResponseEntity.status(404).build();

        List<NGOComplete> ngos = ngoService.listNGOsByCategoria(idCategoria);

        if (ngos.isEmpty()) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(ngos);

    }

    @GetMapping("/{id}")
    public ResponseEntity getNGOById(@PathVariable Integer id) {

        NGOComplete ngo = ngoService.getById(id);

        if (ngo == null) return ResponseEntity.status(404).build();

        return ResponseEntity.status(200).body(ngo);
    }

    @PostMapping
    public ResponseEntity registerNGO(@RequestBody @Valid NgoDTO ngo){
        try {

            return ResponseEntity.status(201).body(ngoService.create(ngo));

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

    @PutMapping("/description")
    public ResponseEntity updateDescNGO(@RequestBody @Valid UpdateDescriptionNgoDTO newNGO)
    {
        boolean updated = ngoService.updateDescription(newNGO);

        return updated ? ResponseEntity.status(201).build()
                        : ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNGO(@PathVariable Integer id) {

        boolean deleted = ngoService.delete(id);

        return deleted ? ResponseEntity.status(201).build()
                        : ResponseEntity.status(404).build();

    }

}
