package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.users.RegisterUserValidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;


    @GetMapping
    public ResponseEntity listUsers(){

        if (!iUserRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iUserRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

}
