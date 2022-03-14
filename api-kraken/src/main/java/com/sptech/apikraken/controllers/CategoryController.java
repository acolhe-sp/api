package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @GetMapping
    public ResponseEntity listCategories() {
        if (!iCategoryRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iCategoryRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

}
