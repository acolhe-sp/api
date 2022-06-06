package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.donor.DonorDTO;
import com.sptech.apikraken.dto.request.donor.UpdateDocumentsDonorDTO;
import com.sptech.apikraken.dto.response.donation.DonationDataPerfil;
import com.sptech.apikraken.dto.response.donor.DonorFollowing;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.service.DonorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
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

    @PutMapping("/{id}/documents")
    public ResponseEntity updateDocsDonor(@PathVariable int id,
                                            @RequestBody @Valid UpdateDocumentsDonorDTO docsDonor)
    {
        boolean updated = donorService.updateDocs(id, docsDonor);

        if (updated) return ResponseEntity.status(201).build();

        return ResponseEntity.status(400).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateDonor(@PathVariable Integer id,
                                      @RequestBody @Valid DonorDTO donorUpdate)
    {
        try {

            Donor updated = donorService.update(id, donorUpdate);
            return ResponseEntity.status(201).body(updated);

        } catch(Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    @PostMapping("/{id}/follow/{idOng}")
    public ResponseEntity updateStateFollowDonor(@PathVariable Integer id,
                                                @PathVariable Integer idOng)
    {
        try {

            boolean stateFollow = donorService.turnFollowState(id, idOng);

            return ResponseEntity.status(201).body(stateFollow);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/follow/{idOng}")
    public ResponseEntity checkStateFollowDonor(@PathVariable Integer id,
                                                 @PathVariable Integer idOng)
    {
        try {

            boolean stateFollow = donorService.checkFollowState(id, idOng);

            return ResponseEntity.status(201).body(stateFollow);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/following")
    public ResponseEntity followsDonor(@PathVariable Integer id) {
        try {

            DonorFollowing dataFollow = donorService.countFollowsDonor(id);

            return ResponseEntity.status(201).body(dataFollow);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping("/{idDonor}/like-post/{idPost}")
    public ResponseEntity updateLikeStatePostByDonor(@PathVariable Integer idDonor,
                                                     @PathVariable Integer idPost)
    {
        try {

            boolean stateLikePost = donorService.turnLikeState(idDonor, idPost);

            return ResponseEntity.status(201).body(stateLikePost);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{idDonor}/state-like-post/{idPost}")
    public ResponseEntity checkLikeStatePostByDonor(@PathVariable Integer idDonor,
                                                     @PathVariable Integer idPost)
    {
        try {

            boolean stateLikePost = donorService.checkLikeState(idDonor, idPost);

            return ResponseEntity.status(201).body(stateLikePost);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}/donations")
    public ResponseEntity donationsDonor(@PathVariable Integer id) {
        try {

            DonationDataPerfil dataDonations = donorService.dataDonationsDonor(id);

            return ResponseEntity.status(201).body(dataDonations);

        } catch (Exception e) {
            System.out.println("esse erro: "+e.getMessage());
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteDonor(@PathVariable int id) {

        if (donorService.delete(id)) return ResponseEntity.status(200).build();

        return ResponseEntity.status(404).build();
    }

}
