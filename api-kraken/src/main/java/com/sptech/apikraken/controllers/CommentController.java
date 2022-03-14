package com.sptech.apikraken.controllers;

import com.sptech.apikraken.repository.ICommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private ICommentRepository iCommentRepository;

    @GetMapping
    public ResponseEntity listComments() {
        if (!iCommentRepository.findAll().isEmpty()) {
            return ResponseEntity.status(200).body(iCommentRepository.findAll());
        }

        return ResponseEntity.status(404).build();
    }

}
