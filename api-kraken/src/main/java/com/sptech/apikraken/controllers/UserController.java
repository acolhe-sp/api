package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.logon.LogonDTO;
import com.sptech.apikraken.dto.request.user.UserParam;
import com.sptech.apikraken.dto.response.logon.PayloadRetornoLogon;
import com.sptech.apikraken.entity.Donor;
import com.sptech.apikraken.entity.NGO;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IDonorRepository;
import com.sptech.apikraken.repository.INGORepository;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.users.LogonUserValidateUseCase;
import com.sptech.apikraken.utils.enums.UserTypeEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IDonorRepository iDonorRepository;

    @Autowired
    private INGORepository iNGORepository;

    @Autowired
    private LogonUserValidateUseCase logonUserValidateUseCase;

    @GetMapping
    public ResponseEntity listUsers(){

        if (!iUserRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iUserRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUserById(@PathVariable Integer id) {

        User user = iUserRepository.findById(id).get();

        if(user.getId() == null) return ResponseEntity.status(404).build();

        PayloadRetornoLogon response = null;

        if (user.getUserType() == UserTypeEnum.USER_DONOR) {

            Donor donor = iDonorRepository.findById(user.getId()).get();
            response = this.logonUserValidateUseCase.execute(user, donor);

        } else {

            NGO ngo = iNGORepository.findById(user.getId()).get();
            response = this.logonUserValidateUseCase.execute(user, ngo);

        }

        return ResponseEntity.status(200).body(response);
    }

    @PostMapping("/logon")
    public ResponseEntity logon(@RequestBody @Valid LogonDTO logonDTO) {

        User user = iUserRepository
                .findByEmailAndPassword(logonDTO.getEmail(), logonDTO.getPassword());

        if(user == null) return ResponseEntity.status(404).build();

        PayloadRetornoLogon response = null;

        if (user.getUserType() == UserTypeEnum.USER_DONOR) {

            Donor donor = iDonorRepository.findByUserId(user.getId());
            response = this.logonUserValidateUseCase.execute(user, donor);

        } else {

            NGO ngo = iNGORepository.findByUserId(user.getId());
            response = this.logonUserValidateUseCase.execute(user, ngo);

        }

        return ResponseEntity.status(200).body(response);
    }

    @PutMapping("/logout/{id}")
    public ResponseEntity logout(@PathVariable Integer id) {
        try {
            User user = iUserRepository.findById(id).get();

            if(user.getId() == null) return ResponseEntity.status(404).build();

            user.setConnect(false);
            iUserRepository.save(user);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PatchMapping(value = "/pic/{id}", consumes="application/json")
    public ResponseEntity patchPic(@PathVariable int id, @RequestBody UserParam userParam) {

        try {
            if (!iUserRepository.existsById(id)) return ResponseEntity.status(404).build();

            User user = iUserRepository.findById(id).get();

            byte[] encoded = Base64Utils.encode(userParam.getImg().getBytes());

            user.setImg(encoded);
            iUserRepository.save(user);

            return ResponseEntity.status(200).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping(value = "/pic/{id}", produces = "image/jpeg")
    public ResponseEntity getPic(@PathVariable int id) {
        try {
            if (!iUserRepository.existsById(id)) return ResponseEntity.status(404).build();

            User user = iUserRepository.findById(id).get();

            byte[] decoded = Base64Utils.decode(user.getImg() != null ? user.getImg() : new byte[]{});

            return ResponseEntity.status(200).body(new String(decoded));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

}
