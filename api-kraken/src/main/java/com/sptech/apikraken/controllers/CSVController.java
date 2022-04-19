package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.IUserRepository;
import com.sptech.apikraken.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/csv-generator")
public class CSVController {

    @Autowired CSVService csv;
    @Autowired IUserRepository repository;

    @PostMapping
    public ResponseEntity gravarArquivo() {

        if (!repository.findAll().isEmpty()) {
            csv.gravaArquivoCSV(repository.findAll(), "usuarios");
            return ResponseEntity.status(201).build();
        }

        return ResponseEntity.status(204).build();
    }

    @GetMapping
    public ResponseEntity lerArquivo() {
        csv.leExibeArquivoCsv("usuarios");
        return ResponseEntity.status(200).build();
    }

}
