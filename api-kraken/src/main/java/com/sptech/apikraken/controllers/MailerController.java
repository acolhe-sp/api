package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.MailerDTO;
import com.sptech.apikraken.entity.Mailer;
import com.sptech.apikraken.service.MailerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/sendmail")
public class MailerController {
    @Autowired MailerService mailerService;

    @PostMapping
    public ResponseEntity<Mailer> sendigMail(@RequestBody @Valid MailerDTO emailDTO) {
        Mailer email = new Mailer();
        BeanUtils.copyProperties(emailDTO, email);
        mailerService.sendMail(email);
        return ResponseEntity.status(200).build();
    }
}
