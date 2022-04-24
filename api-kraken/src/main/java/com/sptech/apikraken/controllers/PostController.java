package com.sptech.apikraken.controllers;

import com.sptech.apikraken.dto.request.post.PostDTO;
import com.sptech.apikraken.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired private PostService postService;

    @GetMapping
    public ResponseEntity listPosts() {

        if (postService.getAll().getTamanho() == 0) return ResponseEntity.status(204).build();

        return ResponseEntity.status(200).body(postService.getAll());
    }

    @PostMapping
    public ResponseEntity registerPost(@RequestBody @Valid PostDTO post){
        try {

            return ResponseEntity.status(201).body(postService.create(post));

        } catch(Exception e) {
            return ResponseEntity.status(404).build();
        }
    }

}
