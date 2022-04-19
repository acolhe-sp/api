package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.PayloadRetornoLogon;
import com.sptech.apikraken.entity.User;
import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.useCases.users.LogonUserValidateUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
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
    public ResponseEntity logon(@RequestBody String email, @RequestBody String pass) {

        User user = iUserRepository.findByEmailAndPassword(email, pass);

        if(user.getId() == null) return ResponseEntity.status(404).build();

        PayloadRetornoLogon response = this.logonUserValidateUseCase.execute(user);

        return ResponseEntity.status(404).build();

    }

}
