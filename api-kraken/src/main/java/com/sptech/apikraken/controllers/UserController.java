package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.logon.LogonDTO;
import com.sptech.apikraken.dto.response.PayloadRetornoLogon;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.users.LogonUserValidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private LogonUserValidateUseCase logonUserValidateUseCase;

    @GetMapping
    public ResponseEntity listUsers(){

        if (!iUserRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iUserRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

    @PostMapping("/logon")
    public ResponseEntity logon(@RequestBody LogonDTO logonDTO) {


        User user = iUserRepository
                .findByEmailAndPassword(logonDTO.getEmail(), logonDTO.getPassword());

        if(user == null) return ResponseEntity.status(404).build();

        PayloadRetornoLogon response = this.logonUserValidateUseCase.execute(user);

        return ResponseEntity.status(200).build();
    }

    @PatchMapping(value = "/pic/{id}", consumes = "image/jpeg")
    public ResponseEntity patchPic(@PathVariable int id, @RequestBody byte[] picFile) {

        if (!iUserRepository.existsById(id)) return ResponseEntity.status(404).build();

        User user = iUserRepository.findById(id).get();

        user.setImg(picFile);
        iUserRepository.save(user);

        return ResponseEntity.status(200).build();
    }

    @GetMapping(value = "/pic/{id}", produces = "image/jpeg")
    public ResponseEntity getPic(@PathVariable int id) {
        if (!iUserRepository.existsById(id)) return ResponseEntity.status(404).build();

        User user = iUserRepository.findById(id).get();

        byte[] picFile = user.getImg();

        return ResponseEntity.status(200).body(picFile);
    }




}
